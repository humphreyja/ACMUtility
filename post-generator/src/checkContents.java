import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class checkContents {
	final private String DATE_FORMAT = "dd-MM-yyyy";
	private String error = "";

	public boolean isDateValid(String date) 
	{
	        try {
	            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
	            df.setLenient(false);
	            df.parse(date);
	            return true;
	        } catch (ParseException e) {
	        	setError("Invalid Date");
	            return false;
	        }
	}
	
	public boolean isTitleValid(String title)
	{
		return true;
	}
	
	public boolean isAuthorValid(String author)
	{
		return true;
	}
	
	public boolean isTimeInRange(String time)
	{
		return true;
	}
	
	public boolean isContentValid(String content)
	{
		return true;
	}
	
	private void setError(String e){
		error = e;
	}
	
	public String getError(){
		return error;
	}
}
