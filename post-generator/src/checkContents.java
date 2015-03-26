import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class checkContents {
	final static String DATE_FORMAT = "dd-MM-yyyy";

	public static boolean isDateValid(String date) 
	{
		System.out.println(date);
	        try {
	            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
	            df.setLenient(false);
	            df.parse(date);
	            System.out.println("here");
	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
	}
}
