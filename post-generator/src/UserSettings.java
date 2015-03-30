import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

/**
 * Class to configure all user settings and store them in a settings xml file
 * @author Jake Humphrey
 * <br />MSUM ACM Organization Web Miester 
 * <br />msumacm.org
 * @version 1.0.0
 */
public class UserSettings {
	private String repoLocation = "";
	private File userFile;
	private boolean FileMade;
	public String getRepoLocation() {
		return repoLocation;
	}

	public void setRepoLocation(String repoLocation) {
		this.repoLocation = repoLocation;
	}
	
	public void setUserFile(File file)
	{
		this.userFile = file;
	}
	public boolean checkDataFile()
	{
		return this.readDataFile();
	}
	private boolean readDataFile()
	{
		try {
			 
			File fXmlFile = this.userFile;
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
		 
			NodeList nList = doc.getElementsByTagName("settings");
			Node data = nList.item(0).getFirstChild();
			this.setRepoLocation(data.getFirstChild().getTextContent());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public void writeDataFile()
	{
		
		if (!this.userFile.exists())
		{
			this.FileMade = false;
			System.out.println("Creating new data file");
			File msumdir = new File(System.getProperty("user.home") + File.separator + ".msumacm");
			boolean msumdirMade = (!msumdir.exists()) ? msumdir.mkdir() : true;
			File postgeneratordir = new File(System.getProperty("user.home") + File.separator + ".msumacm" + File.separator + "postgenerator");
			boolean postGeneratorDirMade = (!postgeneratordir.exists()) ? postgeneratordir.mkdir() : true;
			File newUserFile = new File(System.getProperty("user.home") + File.separator + ".msumacm" + File.separator + "postgenerator" + File.separator + "UserData");
			try {
				this.FileMade =  (msumdirMade && postGeneratorDirMade) ? newUserFile.createNewFile() : false;
			} catch (IOException e) {
				System.out.println("Error creating new data file. Your settings will not be saved!");
			}
		}else
			this.FileMade = true;
		
		if (this.FileMade){
			try {
				 
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		 
				// root elements
				Document doc = docBuilder.newDocument();
				Element rootElement = doc.createElement("settings");
				doc.appendChild(rootElement);
		 
				// staff elements
				Element data = doc.createElement("data");
				rootElement.appendChild(data);
		 
				// repo element
				Element repox = doc.createElement("repository");
				repox.appendChild(doc.createTextNode(this.getRepoLocation()));
				data.appendChild(repox);
		 
				// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(this.userFile);
		 
				// Output to console for testing
				// StreamResult result = new StreamResult(System.out);
		 
				transformer.transform(source, result);
		 
			} catch (ParserConfigurationException pce) {
				pce.printStackTrace();
			} catch (TransformerException tfe) {
				tfe.printStackTrace();
			}
		}else
			System.out.println("Error: Writing data file.  Your settings were not saved!");
	}
}
