import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class postMain extends JFrame{
	public static void main(String[] arg)
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (UnsupportedLookAndFeelException e) {
			System.out.println("ERROR: "+e);
		}
		catch (ClassNotFoundException e) {
			System.out.println("ERROR: "+e);
		}
		catch (InstantiationException e) {
			System.out.println("ERROR: "+e);
		}
		catch (IllegalAccessException e) {
			System.out.println("ERROR: "+e);
		}
		
		GUIEnterContent GECObj = new GUIEnterContent();
		GECObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GECObj.setSize(600,400);
		GECObj.setVisible(true);
		
		
	}
}
