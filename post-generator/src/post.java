import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class post {
	private String post_content;
	private String post_title;
	private boolean btitle = false;
	private boolean bauthor = false;
	private boolean bcontent = false;
	private boolean bdatetime = false;
	private boolean bpresentationdata = false;
	private boolean bduration = false;
	private boolean blocation = false;
	private String repoLoc;
	protected String postType;
	protected String postLayout;
	protected String postDir= File.separatorChar + "_posts" + File.separatorChar;
	private String preDataDir = "/presentation-data/";
	public static String[] postTypeList = {"Workshop","Article", "Notification"};
	
	protected String getPreDataDir()
	{
		return this.preDataDir;
	}
	
	public String SafeTitle()
	{
		return this.post_title.replaceAll(" ", "-");
	}
	public void setRepoLoc(String dir)
	{
		this.repoLoc = dir;
	}
	public void writeFile()
	{
		if (this.objectComplete())
        {
			if(!this.repoLoc.equals(""))
			{
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				try {
					File file = new File(this.repoLoc + this.postDir + dateFormat.format(date) + "-" + this.SafeTitle() + ".markdown");
					BufferedWriter output = new BufferedWriter(new FileWriter(file));
					output.write("---");
					output.newLine();
	            	output.write("Layout: " + this.postLayout);
	            	output.newLine();
	            	for(String item : this.getPostAttributesList())
	            	{
	            		output.write(item);
	            		output.newLine();
	            	}
	            	output.write("categories: " + this.postType);
	            	output.newLine();
	            	output.write("---");
	            	output.newLine();
	            	output.write(this.getPostContent());
	            	output.newLine();
	            	output.close();
	            	System.out.println("Success!");
				} catch (IOException e)
				{
					System.out.println("Fail");
				}
			}else{
	           	System.out.println("Fail");
			}
		}
	}
	
	public abstract void setPostAuthor(String author);
	public abstract void setPostDatetime(String date, String time);
	public abstract void setPostPresentationData(String PresentationData); 
	public abstract void setPostDuration(int Duration);
	public abstract void setPostLocation(String post_location);
	
	public abstract boolean objectComplete();
	
	/**
	 * Returns true if the object uses the title form
	 * @return boolean
	 */
	public boolean haveTitle() {
		return btitle;
	}
	/**
	 * Sets the state of the object to require the use of a title form
	 */
	public void requireTitle() {
		this.btitle = true;
	}
	/**
	 * Returns true if the object uses the author form
	 * @return boolean
	 */
	public boolean haveAuthor() {
		return bauthor;
	}
	/**
	 * Sets the state of the object to require the use of an author form
	 */
	public void requireAuthor() {
		this.bauthor = true;
	}
	/**
	 * Returns true if the object uses the content form
	 * @return boolean
	 */
	public boolean haveContent() {
		return bcontent;
	}
	/**
	 * Sets the state of the object to require the use of a content form
	 */
	public void requireContent() {
		this.bcontent = true;
	}
	/**
	 * Returns true if the object uses the date and time forms
	 * @return boolean
	 */
	public boolean haveDateTime() {
		return bdatetime;
	}
	/**
	 * Sets the state of the object to require the use of a date/time form
	 */
	public void requireDateTime() {
		this.bdatetime = true;
	}
	/**
	 * Returns true if the object uses the presentation data form
	 * @return boolean
	 */
	public boolean havePresentationData() {
		return bpresentationdata;
	}
	/**
	 * Sets the state of the object to require the use of a presentation data form
	 */
	public void requirePresentationData() {
		this.bpresentationdata = true;
	}
	/**
	 * Returns true if the object uses the duration form
	 * @return boolean
	 */
	public boolean haveDuration()
	{
		return bduration;
	}
	/**
	 * Sets the state of the object to require the use of a duration form
	 */
	public void requireDuration() {
		this.bduration = true;
	}
	/**
	 * Returns true if the object uses the location form
	 * @return boolean
	 */
	public boolean haveLocation()
	{
		return blocation;
	}
	/**
	 * Sets the state of the object to require the use of a location form
	 */
	public void requireLocation()
	{
		this.blocation = true;
	}
	/**
	 * Returns the post content
	 * @return String post_content
	 */
	public String getPostContent()
	{
		return post_content;
	}
	/**
	 * Returns the post title
	 * @return String post_title
	 */
	public String getPostTitle()
	{
		return  "title: \"" + post_title + "\"";
	}
	/**
	 * Sets the post content
	 * @param content
	 */
	public void setPostContent(String content)
	{
		this.post_content = content;
	}
	/**
	 * Sets the post title
	 * @param title
	 */
	public void setPostTitle(String title)
	{
		this.post_title = title;
	}
	
	/**
	 * Returns all the posts attributes as a list of strings
	 * @return String[] post_attributes
	 */
	public abstract String[] getPostAttributesList();
}
