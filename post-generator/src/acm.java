import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.BoxLayout;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import java.awt.SystemColor;

import javax.swing.JCheckBox;


public class acm extends JFrame {

	private JFrame acmMain;
	private final JPanel home = new JPanel();
	private JTextField textName;
	private JTextField textAuthor;
	private JTextField txtHttp;
	private JTextField txtlocation;
	private JTextField textField;

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
		acmMain = new JFrame();
		acmMain.setIconImage(Toolkit.getDefaultToolkit().getImage("/home/jake/git/msumacm_post_generator/post-generator/src/acm/penguin_superhero_icon.png"));
		acmMain.setTitle("MSUM ACM Utility");
		acmMain.setBounds(100, 100, 450, 300);
		acmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		acmMain.getContentPane().setLayout(null);
		
		JPanel finalPanel = new JPanel();
		finalPanel.setBounds(0, 12, 448, 220);
		acmMain.getContentPane().add(finalPanel);
		finalPanel.setLayout(null);
		finalPanel.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("Your new post has been created");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 160, 448, 27);
		finalPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("/home/jake/git/msumacm_post_generator/post-generator/src/acm/penguin_superhero.png"));
		lblNewLabel_2.setBounds(0, 12, 448, 112);
		finalPanel.add(lblNewLabel_2);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(248, 190, 117, 25);
		finalPanel.add(btnExit);
		
		JButton btnNewPost = new JButton("New Post");
		
		btnNewPost.setBounds(78, 190, 117, 25);
		finalPanel.add(btnNewPost);
		
		JPanel post_creator = new JPanel();
		post_creator.setBounds(0, 12, 650, 614);
		acmMain.getContentPane().add(post_creator);
		post_creator.setLayout(null);
		post_creator.setVisible(false);
		
		JLabel lblPostTypeName = new JLabel("Workshop");
		lblPostTypeName.setFont(new Font("Dialog", Font.BOLD, 22));
		lblPostTypeName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPostTypeName.setBounds(12, 12, 650, 24);
		post_creator.add(lblPostTypeName);
		
		JPanel PanelPostCol1 = new JPanel();
		PanelPostCol1.setBounds(0, 48, 356, 246);
		post_creator.add(PanelPostCol1);
		PanelPostCol1.setLayout(null);
		
		JLabel lblname = new JLabel("Post Title: ");
		lblname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblname.setBounds(13, 18, 95, 23);
		PanelPostCol1.add(lblname);
		
		textName = new JTextField();
		textName.setBounds(118, 12, 206, 35);
		PanelPostCol1.add(textName);
		textName.setColumns(10);
		
		JLabel lblA = new JLabel("Post Author:");
		lblA.setHorizontalAlignment(SwingConstants.RIGHT);
		lblA.setBounds(12, 71, 95, 15);
		PanelPostCol1.add(lblA);
		
		textAuthor = new JTextField();
		textAuthor.setBounds(118, 61, 206, 35);
		PanelPostCol1.add(textAuthor);
		textAuthor.setColumns(10);
		
		JLabel lblEventLocation = new JLabel("Location:");
		lblEventLocation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEventLocation.setBounds(12, 114, 95, 23);
		PanelPostCol1.add(lblEventLocation);
		
		txtlocation = new JTextField();
		txtlocation.setText("BR 165/166");
		txtlocation.setBounds(118, 110, 206, 35);
		PanelPostCol1.add(txtlocation);
		txtlocation.setColumns(10);
		
		JPanel ptimedate = new JPanel();
		ptimedate.setBounds(0, 149, 356, 85);
		PanelPostCol1.add(ptimedate);
		ptimedate.setLayout(null);
		
		JLabel lblEventTime = new JLabel("Event Time:");
		lblEventTime.setBounds(32, 53, 81, 15);
		ptimedate.add(lblEventTime);
		
		JLabel lblEventDate = new JLabel("Event Date:");
		lblEventDate.setBounds(32, 12, 82, 15);
		ptimedate.add(lblEventDate);
		
		JPanel timePanel = new JPanel();
		timePanel.setBounds(100, 45, 240, 40);
		ptimedate.add(timePanel);
		
		JComboBox CBHour = new JComboBox();
		timePanel.add(CBHour);
		CBHour.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		JComboBox CBMinute = new JComboBox();
		timePanel.add(CBMinute);
		CBMinute.setModel(new DefaultComboBoxModel(new String[] {"00", "15", "30", "45"}));
		
		JComboBox CBTimeOfDay = new JComboBox();
		timePanel.add(CBTimeOfDay);
		CBTimeOfDay.setModel(new DefaultComboBoxModel(new String[] {" AM   ", " PM   "}));
		
		JPanel datepanel = new JPanel();
		datepanel.setBounds(100, 0, 240, 40);
		ptimedate.add(datepanel);
		
		JComboBox CBMonth = new JComboBox();
		datepanel.add(CBMonth);
		CBMonth.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		JComboBox CBDay = new JComboBox();
		datepanel.add(CBDay);
		CBDay.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		JComboBox CBYear = new JComboBox();
		datepanel.add(CBYear);
		CBYear.setModel(new DefaultComboBoxModel(new String[] {"2014", "2015", "2016", "2017", "2018", "2019", "2020"}));
		
		JPanel panelPostCol2 = new JPanel();
		panelPostCol2.setBounds(371, 48, 267, 246);
		post_creator.add(panelPostCol2);
		panelPostCol2.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.setBounds(129, 19, 126, 24);
		panelPostCol2.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Workshop", "Article", "Notification"}));
		comboBox.setMaximumRowCount(3);
		
		JLabel lblPostType = new JLabel("Post Type:");
		lblPostType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPostType.setBounds(23, 22, 88, 19);
		panelPostCol2.add(lblPostType);
		
		JPanel plength = new JPanel();
		plength.setBounds(0, 53, 267, 75);
		panelPostCol2.add(plength);
		plength.setLayout(null);
		plength.setVisible(false);
		JLabel lblL = new JLabel("Duration:");
		lblL.setBounds(38, 5, 67, 15);
		plength.add(lblL);
		
		textField = new JTextField();
		textField.setBounds(129, 2, 126, 35);
		plength.add(textField);
		textField.setColumns(10);
		
		JLabel lblinMins = new JLabel("(In Mins.)");
		lblinMins.setBounds(38, 20, 70, 15);
		plength.add(lblinMins);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 53, 267, 86);
		panelPostCol2.add(panel_1);
		panel_1.setLayout(null);
		
		JCheckBox chckbxExternal = new JCheckBox("External");
		chckbxExternal.setBounds(130, 55, 129, 23);
		panel_1.add(chckbxExternal);
		
		txtHttp = new JTextField();
		txtHttp.setBounds(129, 12, 126, 35);
		panel_1.add(txtHttp);
		txtHttp.setText("http://");
		txtHttp.setVisible(false);
		txtHttp.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(129, 12, 126, 24);
		panel_1.add(comboBox_1);
		
		JLabel lblPresData = new JLabel("Pres. Data:");
		lblPresData.setBounds(23, 12, 88, 15);
		panel_1.add(lblPresData);
		lblPresData.setHorizontalAlignment(SwingConstants.RIGHT);
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
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblPostTypeName.setText((String) comboBox.getItemAt(comboBox.getSelectedIndex()));
				if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Workshop"){
					panel_1.setVisible(true);
					plength.setVisible(false);
					lblEventLocation.setVisible(true);
					txtlocation.setVisible(true);
					lblA.setVisible(true);
					textAuthor.setVisible(true);
				}else if (comboBox.getItemAt(comboBox.getSelectedIndex()) == "Article"){
					panel_1.setVisible(false);
					plength.setVisible(true);
					lblEventLocation.setVisible(false);
					txtlocation.setVisible(false);
					lblA.setVisible(true);
					textAuthor.setVisible(true);
				}
				else{ //notification
					lblEventLocation.setVisible(true);
					txtlocation.setVisible(true);
					panel_1.setVisible(true);
					plength.setVisible(false);
					lblA.setVisible(false);
					textAuthor.setVisible(false);
				}
			}
		});
		
		JEditorPane dtrpnPostContent = new JEditorPane("text/plain","Post Content");
		dtrpnPostContent.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				dtrpnPostContent.setText("Post Content");
			}
		});
		dtrpnPostContent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
		//post_creator.add(dtrpnPostContent);
		home.setBounds(0, 12, 448, 220);
		acmMain.getContentPane().add(home);
		home.setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the MSUM ACM content utility.");
		lblWelcomeToThe.setBounds(0, 0, 448, 15);
		home.add(lblWelcomeToThe);
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 448, 166);
		home.add(lblNewLabel);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("/home/jake/git/msumacm_post_generator/post-generator/src/acm/penguin_superhero.png"));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 166, 448, 50);
		home.add(panel);
		panel.setLayout(null);
		
		JButton btnCreateNewPost = new JButton("Create New Post");
		btnCreateNewPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.setVisible(false);
				post_creator.setVisible(true);
				acmMain.setBounds(100, 100, 651, 668);
			}
		});
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean validEntry=true;
				
				
				
				
				String postdate=(String) CBDay.getItemAt(CBDay.getSelectedIndex()) + "-" + (String) CBMonth.getItemAt(CBMonth.getSelectedIndex()) + "-" + (String) CBYear.getItemAt(CBYear.getSelectedIndex());
				checkContents contentChecker = new checkContents();
				if(!contentChecker.isDateValid(postdate)){
					validEntry = false;
				}
				if (textName.getText().isEmpty()) {
				    // Message box
				}
				
				
				
				if(validEntry){
					post_creator.setVisible(false);
					finalPanel.setVisible(true);
					acmMain.setBounds(100,100,450,300);
				}else{
					JOptionPane.showMessageDialog(null, contentChecker.getError());
				}
			}
		});
		btnNewPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finalPanel.setVisible(false);
				post_creator.setVisible(true);
				acmMain.setBounds(100, 100, 651, 668);
			}
		});
		btnCreateNewPost.setFocusable(false);
		btnCreateNewPost.setBounds(145, 12, 153, 25);
		panel.add(btnCreateNewPost);
	}
	
	
}
