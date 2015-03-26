import java.io.File;

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

public class UserSettings {
	private String repoLocation = "";
	private File userFile;

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
	}
}
