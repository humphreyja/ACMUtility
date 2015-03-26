import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.CardLayout;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class acm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame acmMain;
	private final JPanel home = new JPanel();
	private JTextField textName;
	private JTextField textAuthor;
	private JTextField txtHttp;
	private JTextField txtlocation;
	private JTextField textField;
	private int postHeight;
	private int postWidth;
	private File userFile;
	private JFileChooser chooser;
	private post postObject;
	private String path = System.getProperty("user.home");
	private String userDataFile = this.path + File.separator + ".msumacm" + File.separator + "postgenerator" + File.separator + "UserData";
	private String dataFolder;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch (Exception e){
			System.out.println("ERROR: "+e);
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					acm window = new acm();
					window.acmMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public acm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			path = new File(".").getCanonicalPath();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.dataFolder = path + this.dataFolder;
		postHeight = 668;
		if (System.getProperty("os.name").startsWith("Windows"))
		{
			this.dataFolder = "C:\\Programs\\msumacm\\postgenerator\\data\\";
			postWidth = 664;
		}
		else
		{
			this.dataFolder = "/etc/msumacm/postgenerator/data/";
			postWidth = 651;
		}
		userFile = new File(this.userDataFile);
		sourceControl gitObj = new sourceControl();
		UserSettings userDataObj = new UserSettings();
		userDataObj.setUserFile(userFile);
		gitObj.setGitEmail("humphreyja@mnstate.edu");
		gitObj.setGitUser("jake");
		if(userFile.exists() && !userFile.isDirectory())
		{
			if(userDataObj.checkDataFile())
			{
				gitObj.setGitRepo(userDataObj.getRepoLocation());
				
			}else{
				System.out.println("Error parsing file");
			}
		}else{
			System.out.println("File Not Found");

		}

		
		
		postObject = new workshop();
		
		acmMain = new JFrame();
		acmMain.setResizable(false);
		acmMain.setIconImage(Toolkit.getDefaultToolkit().getImage(this.dataFolder + "penguin_superhero_icon.png"));
		acmMain.setTitle("MSUM ACM Utility");
		acmMain.setBounds(100, 100, 450, 300);
		acmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//-------- Start screen --------
		acmMain.getContentPane().setLayout(new CardLayout(0, 0));
		acmMain.getContentPane().add(home, "name_273493709313831");
		home.setLayout(null);
		home.setBounds(0, 12, 448, 220);
		
		//Welcome message
		JLabel lblWelcomeToThe = new JLabel("Welcome to the MSUM ACM content utility.");
		lblWelcomeToThe.setBounds(0, 0, 448, 15);
		home.add(lblWelcomeToThe);
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Penguin image
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 448, 166);
		home.add(lblNewLabel);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(this.dataFolder + "penguin_superhero.png"));
		
		//button container
		JPanel panel = new JPanel();
		panel.setBounds(0, 166, 448, 50);
		home.add(panel);
		panel.setLayout(null);
		//button to continue to next panel
		JButton btnCreateNewPost = new JButton("Create New Post");
		
		
		btnCreateNewPost.setFocusable(false);
		btnCreateNewPost.setBounds(47, 12, 153, 25);
		panel.add(btnCreateNewPost);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setBounds(242, 12, 153, 25);
		panel.add(btnSettings);
		
		
		if(!gitObj.checkRepository())
		{
			btnCreateNewPost.setEnabled(false);
		}
		//-------- End Start Screen --------
		
		
		//-------- Finished Screen --------
		JPanel finalPanel = new JPanel();
		acmMain.getContentPane().add(finalPanel, "name_273493460363616");
		finalPanel.setLayout(null);
		
		//Final panel message
		JLabel lblNewLabel_1 = new JLabel("Your new post has been created");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 160, 448, 27);
		finalPanel.add(lblNewLabel_1);
		
		//Final panel image
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(this.dataFolder + "penguin_superhero.png"));
		lblNewLabel_2.setBounds(0, 12, 448, 112);
		finalPanel.add(lblNewLabel_2);
		
		//Button to exit the program
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(248, 190, 117, 25);
		finalPanel.add(btnExit);
		
		//button to create additional posts
		JButton btnNewPost = new JButton("New Post");
		
		btnNewPost.setBounds(78, 190, 117, 25);
		finalPanel.add(btnNewPost);
		//-------- End Finished Screen --------
		
		//-------- Start Post Creator Screen --------
		JPanel post_creator = new JPanel();
		acmMain.getContentPane().add(post_creator, "name_273493594208610");
		post_creator.setLayout(null);
		
		//post label with default label
		JLabel lblPostTypeName = new JLabel("Workshop");
		lblPostTypeName.setFont(new Font("Dialog", Font.BOLD, 22));
		lblPostTypeName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPostTypeName.setBounds(12, 12, 650, 24);
		post_creator.add(lblPostTypeName);
		
		JPanel PanelPostCol1 = new JPanel();
		PanelPostCol1.setBounds(0, 48, 356, 246);
		post_creator.add(PanelPostCol1);
		PanelPostCol1.setLayout(null);
		
		//post title 
		JLabel lblname = new JLabel("Post Title: ");
		lblname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblname.setBounds(13, 18, 95, 23);
		PanelPostCol1.add(lblname);
		
		//post title tbox
		textName = new JTextField();
		textName.setBounds(118, 12, 206, 35);
		PanelPostCol1.add(textName);
		textName.setColumns(10);
		
		//post author
		JLabel lblA = new JLabel("Post Author:");
		lblA.setHorizontalAlignment(SwingConstants.RIGHT);
		lblA.setBounds(12, 71, 95, 15);
		PanelPostCol1.add(lblA);
		
		//post author tbox
		textAuthor = new JTextField();
		textAuthor.setBounds(118, 61, 206, 35);
		PanelPostCol1.add(textAuthor);
		textAuthor.setColumns(10);
		
		//post location
		JLabel lblEventLocation = new JLabel("Location:");
		lblEventLocation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEventLocation.setBounds(12, 114, 95, 23);
		PanelPostCol1.add(lblEventLocation);
		
		//post location tbox
		txtlocation = new JTextField();
		txtlocation.setText("BR 165/166");
		txtlocation.setBounds(118, 110, 206, 35);
		PanelPostCol1.add(txtlocation);
		txtlocation.setColumns(10);
		
		//post time date container
		JPanel ptimedate = new JPanel();
		ptimedate.setBounds(0, 149, 356, 85);
		PanelPostCol1.add(ptimedate);
		ptimedate.setLayout(null);
		
		//post time label
		JLabel lblEventTime = new JLabel("Event Time:");
		lblEventTime.setBounds(32, 53, 81, 15);
		ptimedate.add(lblEventTime);
		
		//post date label
		JLabel lblEventDate = new JLabel("Event Date:");
		lblEventDate.setBounds(32, 12, 82, 15);
		ptimedate.add(lblEventDate);
		
		//post time container
		JPanel timePanel = new JPanel();
		timePanel.setBounds(100, 45, 240, 40);
		ptimedate.add(timePanel);
		
		//hour combo
		JComboBox<String> CBHour = new JComboBox<String>();
		timePanel.add(CBHour);
		CBHour.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		//minute combo
		JComboBox<String> CBMinute = new JComboBox<String>();
		timePanel.add(CBMinute);
		CBMinute.setModel(new DefaultComboBoxModel<String>(new String[] {"00", "15", "30", "45"}));
		
		//TOD combo
		JComboBox<String> CBTimeOfDay = new JComboBox<String>();
		timePanel.add(CBTimeOfDay);
		CBTimeOfDay.setModel(new DefaultComboBoxModel<String>(new String[] {" AM   ", " PM   "}));
		
		//post date container
		JPanel datepanel = new JPanel();
		datepanel.setBounds(100, 0, 240, 40);
		ptimedate.add(datepanel);
		
		//month combo
		JComboBox<String> CBMonth = new JComboBox<String>();
		datepanel.add(CBMonth);
		CBMonth.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		//day combo
		JComboBox<String> CBDay = new JComboBox<String>();
		datepanel.add(CBDay);
		CBDay.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		//year combo
		JComboBox<String> CBYear = new JComboBox<String>();
		datepanel.add(CBYear);
		CBYear.setModel(new DefaultComboBoxModel<String>(new String[] {"2014", "2015", "2016", "2017", "2018", "2019", "2020"}));
		
		//post type container
		JPanel panelPostCol2 = new JPanel();
		panelPostCol2.setBounds(371, 48, 267, 246);
		post_creator.add(panelPostCol2);
		panelPostCol2.setLayout(null);
		
		//type combo
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(129, 19, 126, 24);
		panelPostCol2.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel<String>(post.postTypeList));
		comboBox.setMaximumRowCount(3);
		
		//post type label
		JLabel lblPostType = new JLabel("Post Type:");
		lblPostType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPostType.setBounds(23, 22, 88, 19);
		panelPostCol2.add(lblPostType);
		
		//post duration panel
		JPanel plength = new JPanel();
		plength.setBounds(0, 53, 267, 45);
		panelPostCol2.add(plength);
		plength.setLayout(null);
		plength.setVisible(false);
		
		//post duration label
		JLabel lblL = new JLabel("Duration:");
		lblL.setBounds(38, 5, 67, 15);
		plength.add(lblL);
		
		//post duration tbox
		textField = new JTextField();
		textField.setBounds(129, 2, 126, 35);
		plength.add(textField);
		textField.setColumns(10);
		
		//post duration sub label
		JLabel lblinMins = new JLabel("(In Mins.)");
		lblinMins.setBounds(38, 20, 70, 15);
		plength.add(lblinMins);
		
		//pres data panel
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 53, 267, 86);
		panelPostCol2.add(panel_1);
		panel_1.setLayout(null);
		
		//extern cbox label
		JCheckBox chckbxExternal = new JCheckBox("External");
		chckbxExternal.setBounds(130, 55, 129, 23);
		panel_1.add(chckbxExternal);
		
		//extern cbox tbox
		txtHttp = new JTextField();
		txtHttp.setBounds(129, 12, 126, 35);
		panel_1.add(txtHttp);
		txtHttp.setText("http://");
		txtHttp.setVisible(false);
		txtHttp.setColumns(10);
		
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(129, 12, 126, 24);
		panel_1.add(comboBox_1);
		
		//pres data label
		JLabel lblPresData = new JLabel("Pres. Data:");
		lblPresData.setBounds(23, 12, 88, 15);
		panel_1.add(lblPresData);
		lblPresData.setHorizontalAlignment(SwingConstants.RIGHT);
		
		//toggle presentation data type
		chckbxExternal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxExternal.isSelected()){
					txtHttp.setVisible(true);
					comboBox_1.setVisible(false);
				}else{
					txtHttp.setVisible(false);
					comboBox_1.setVisible(true);
				}
			}
		});
		
		//select type of post
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblPostTypeName.setText((String) comboBox.getItemAt(comboBox.getSelectedIndex()));
				
				if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Workshop"){
					postObject = new workshop();
					
				}else if (comboBox.getItemAt(comboBox.getSelectedIndex()) == "Article"){
					postObject = new article();
				}
				else{ //notification
					postObject = new alert();
				}
				
				if(postObject.haveTitle())
				{
					lblname.setVisible(true);
					textName.setVisible(true);
				}else{
					lblname.setVisible(false);
					textName.setVisible(false);
				}
				if(postObject.haveAuthor())
				{
					lblA.setVisible(true);
					textAuthor.setVisible(true);
				}else{
					lblA.setVisible(false);
					textAuthor.setVisible(false);
				}
				if(postObject.haveLocation())
				{
					lblEventLocation.setVisible(true);
					txtlocation.setVisible(true);
				}else{
					lblEventLocation.setVisible(false);
					txtlocation.setVisible(false);
				}
				if(postObject.haveDateTime())
				{
					ptimedate.setVisible(true);
				}else{
					ptimedate.setVisible(false);
				}
				if(postObject.haveDuration() && postObject.havePresentationData())
				{
					panel_1.setBounds(0, 90, 267, 86);
				}else{
					panel_1.setBounds(0, 53, 267, 86);
				}
				if(postObject.haveDuration())
				{
					plength.setVisible(true);
				}else{
					plength.setVisible(false);
				}
				if(postObject.havePresentationData())
				{
					panel_1.setVisible(true);
					
				}else{
					panel_1.setVisible(false);
				}
			}
		});
		
		JEditorPane dtrpnPostContent = new JEditorPane("text/plain","Post Content");
		dtrpnPostContent.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(dtrpnPostContent.getText().isEmpty())
				{
					dtrpnPostContent.setText("Post Content");
				}
				
			}
		});
		dtrpnPostContent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(dtrpnPostContent.getText().equals("Post Content"))
					dtrpnPostContent.setText("");
			}
		});
		
		
		JScrollPane scrollPane = new JScrollPane(dtrpnPostContent);
		scrollPane.setLocation(12, 322);
		scrollPane.setSize(626, 238);
		dtrpnPostContent.setBounds(12, 216, 638, 228);
		dtrpnPostContent.setPreferredSize(new Dimension(100,60));
		scrollPane.setPreferredSize(new Dimension(600,60));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setMinimumSize(new Dimension(100, 30));
        final int MAX_HEIGHT_RSZ = 120;
        dtrpnPostContent.addCaretListener(new CaretListener() {

            public void caretUpdate(CaretEvent e) {
                int height = Math.min(dtrpnPostContent.getPreferredSize().height, MAX_HEIGHT_RSZ);
                Dimension preferredSize = scrollPane.getPreferredSize();
                preferredSize.height = height;
                scrollPane.setPreferredSize(preferredSize);
                acm.this.validate();
            }
        });
        
		post_creator.add(scrollPane);
		
		JButton btnCreate = new JButton("Create");
		
		btnCreate.setBounds(521, 572, 117, 30);
		post_creator.add(btnCreate);
		
		//-------- Settings Screen --------
		JPanel settings = new JPanel();
		acmMain.getContentPane().add(settings, "name_114706592258015");
		settings.setLayout(null);
		
		JLabel lblrepoLocation = new JLabel("Repository Location:");
		lblrepoLocation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblrepoLocation.setBounds(12, 59, 160, 15);
		settings.add(lblrepoLocation);
		
		JLabel lblSettingHeader = new JLabel("Configure Local Settings");
		lblSettingHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettingHeader.setBounds(12, 5, 424, 15);
		settings.add(lblSettingHeader);
		
		JButton btnSelectFolder = new JButton("Browse");
		btnSelectFolder.setBounds(39, 86, 117, 25);
		settings.add(btnSelectFolder);
		
		JLabel lblrepolocationstring = new JLabel("");
		lblrepolocationstring.setBounds(184, 59, 252, 15);
		settings.add(lblrepolocationstring);
		if(gitObj.checkRepository())
		{
			lblrepolocationstring.setText(gitObj.getGitRepo());
		}
		
		JButton btnDone = new JButton("Done");
		
		btnDone.setBounds(319, 223, 117, 25);
		settings.add(btnDone);

		btnSelectFolder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnVal = chooser.showOpenDialog(acmMain);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					userDataObj.setRepoLocation(chooser.getSelectedFile().getPath());
				}
				lblrepolocationstring.setText(userDataObj.getRepoLocation());
				gitObj.setGitRepo(userDataObj.getRepoLocation());
				if(gitObj.checkRepository()){
					System.out.println("Good Repository");
				}else{
					System.out.println("Bad Repository");
				}
			}
		});
		
		

		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String postdate=(String) CBYear.getItemAt(CBYear.getSelectedIndex()) + "-" + (String) CBMonth.getItemAt(CBMonth.getSelectedIndex()) + "-" + (String) CBDay.getItemAt(CBDay.getSelectedIndex());
				int milHour = Integer.parseInt(CBHour.getItemAt(CBHour.getSelectedIndex()));
				milHour += (CBTimeOfDay.getSelectedIndex() == 1) ? 12 : 0;
				
				String posttime=milHour + ":" + (String) CBMinute.getItemAt(CBMinute.getSelectedIndex()) + ":00";
				ArrayList<String> errList = new ArrayList<String>();
				if(postObject.haveTitle())
				{
					if(!textName.getText().equals(""))
						postObject.setPostTitle(textName.getText());
					else
						errList.add("title");
				}
				if(postObject.haveAuthor())
				{
					if(!textAuthor.getText().equals(""))
						postObject.setPostAuthor(textAuthor.getText());
					else
						errList.add("author");
				}
				if(postObject.haveContent())
				{
					if((!dtrpnPostContent.getText().equals("")) && (!dtrpnPostContent.getText().equals("Post Content")))
						postObject.setPostContent(dtrpnPostContent.getText());
					else
						errList.add("content");
				}
				if(postObject.haveDateTime())
				{
					postObject.setPostDatetime(postdate, posttime);
				}
				if(postObject.haveDuration())
				{
					if(!textField.getText().equals(""))
						postObject.setPostDuration(Integer.parseInt(textField.getText()));
					else
						errList.add("duration");
				}
				if(postObject.haveLocation())
				{
					if(!txtlocation.getText().equals(""))
						postObject.setPostLocation(txtlocation.getText());
					else
						errList.add("location");
				}
				if(postObject.havePresentationData())
				{
					if(txtHttp.isVisible())
					{
						if(!txtHttp.getText().equals("") && !txtHttp.getText().equals("http://"))
							postObject.setPostPresentationData(txtHttp.getText());
						else
							errList.add("external presentation data");
					}
					else
					{
						if(comboBox_1.getItemAt(comboBox_1.getSelectedIndex()) != "<none>")
							postObject.setPostPresentationData(comboBox_1.getItemAt(comboBox_1.getSelectedIndex()));
					}
				}

				if (errList.size() > 1)
				{
					String emsg = "Missing Fields: \n";
					for(String item : errList)
					{
						emsg += item + "\n";
					}
					JOptionPane.showMessageDialog(null, emsg, "Error",JOptionPane.ERROR_MESSAGE);
				}else
				{
					postObject.setRepoLoc(gitObj.getGitRepo());
					postObject.writeFile();
					post_creator.setVisible(false);
					finalPanel.setVisible(true);
					acmMain.setBounds(100,100,450,300);
				}
			}
		});
		
		btnNewPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finalPanel.setVisible(false);
				post_creator.setVisible(true);
				acmMain.setBounds(100, 100, postWidth, postHeight);
				postObject = new workshop();
				textName.setText("");
				textAuthor.setText("");
				dtrpnPostContent.setText("Post Content");
				CBYear.setSelectedIndex(0);
				CBMonth.setSelectedIndex(0);
				CBDay.setSelectedIndex(0);
				CBHour.setSelectedIndex(0);
				CBMinute.setSelectedIndex(0);
				CBTimeOfDay.setSelectedIndex(0);
				txtHttp.setText("http://");
				comboBox_1.setSelectedIndex(0);
				textField.setText("");
				comboBox.setSelectedIndex(0);
				
			}
		});

		
		
		btnSettings.setFocusable(false);
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.setVisible(false);
				settings.setVisible(true);
				
				
			}
		});
		
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				settings.setVisible(false);
				home.setVisible(true);
				userDataObj.writeDataFile();
				if(!gitObj.checkRepository())
				{
					btnCreateNewPost.setEnabled(false);
				}else{
					btnCreateNewPost.setEnabled(true);
					
				}
			}
		});
		
		btnCreateNewPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.setVisible(false);
				post_creator.setVisible(true);
				acmMain.setBounds(100, 100, postWidth, postHeight);
				int boxLength = 1;
				comboBox_1.addItem("<none>");
				if(gitObj.checkRepository()){
					File folder;
					folder = new File(gitObj.getGitRepo() + "/presentation-data");
					if(!folder.exists())
						folder = new File(gitObj.getGitRepo() + "\\presentation-data");
					
					File[] listOfFiles = folder.listFiles();

				    for (int i = 0; i < listOfFiles.length; i++) {
				      if (listOfFiles[i].isFile()) {
				    	  comboBox_1.addItem(listOfFiles[i].getName());
				      }
				    }
				    boxLength += listOfFiles.length;
				}
				comboBox_1.setMaximumRowCount(boxLength);
			}
		});
	}
}
