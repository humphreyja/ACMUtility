import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GUIEnterContent extends JFrame{
	private JTextField postName;
	private JTextField postDate;
	private JTextField postMatierial;
	private JTextField postContent;
	private JTextField postAuthor;
	private JTextField postLocation;
	private JTextField postDuration;
	private JComboBox eventType;
	
	private String[] types_of_events = {"event","article","info"};
	
	public GUIEnterContent()
	{
		super("MSUM-ACM Post Generator");
		setLayout(new FlowLayout());
		
		postName = new JTextField();
		postDate = new JTextField();
		postMatierial = new JTextField();
		postContent = new JTextField();
		postAuthor = new JTextField();
		postLocation = new JTextField();
		postDuration = new JTextField();
		eventType = new JComboBox(types_of_events);
		eventType.setFocusable(false);
		
		add(postName);
		add(eventType);
		add(postAuthor);
		add(postDate);
		add(postLocation);
		add(postDuration);
		add(postMatierial);
		add(postContent);
	}
	
}
