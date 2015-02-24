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
import java.awt.GridLayout;
import java.awt.Toolkit;


public class acm {

	private JFrame acmMain;

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
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the MSUM ACM content utility.");
		lblWelcomeToThe.setBounds(0, 22, 448, 15);
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		acmMain.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 22, 448, 166);
		acmMain.getContentPane().add(lblNewLabel);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("/home/jake/git/msumacm_post_generator/post-generator/src/acm/penguin_superhero.png"));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 179, 448, 50);
		acmMain.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnCreateNewPost = new JButton("Create New Post");
		btnCreateNewPost.setFocusable(false);
		btnCreateNewPost.setBounds(145, 12, 153, 25);
		panel.add(btnCreateNewPost);
	}
}
