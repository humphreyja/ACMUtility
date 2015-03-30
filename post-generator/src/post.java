import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Parent class of all types of posts
 * @author Jake Humphrey
 * <br />MSUM ACM Organization Web Miester 
 * <br />msumacm.org
 * @version 1.0.0
 */
public abstract class post {
	protected String post_content;
	protected String post_title;
	private boolean btitle = false;
	private boolean bauthor = false;
	private boolean bcontent = false;
	private boolean bdatetime = false;
	private boolean bpresentationdata = false;
	private boolean bduration = false;
	private boolean blocation = false;
	private boolean bleader = false;
	private boolean bteam = false;
	private boolean bexpand = false;
	private boolean bfinished = false;
	private boolean bsummary = false;
	private String repoLoc;
	protected String postType;
	protected String postLayout;
	protected String postDir= File.separatorChar + "_posts" + File.separatorChar;
	private String preDataDir = File.separatorChar + "presentation-data" + File.separatorChar;
	public static String[] postTypeList = {"Workshop","Article", "Notification","Project","Research"};
	
	/**
	 * Returns the presentation data directory
	 * @return String 
	 */
	protected String getPreDataDir()
	{
		return this.preDataDir;
	}
	
	/**
	 * Returns the post title but as a file safe version. I.E. no white space
	 * @return String
	 */
	public String SafeTitle()
	{
		return this.post_title.trim().replaceAll(" ", "-");
	}
	
	/**
	 * Sets the location of the Repository
	 * @param directory
	 */
	public void setRepoLoc(String directory)
	{
		this.repoLoc = directory;
	}
	
	/**
	 * Checks if all the fields are filled out for the appropriate post and writes to the file and returns the state.
	 * @return boolean 
	 */
	public boolean writeFile()
	{
		if (this.objectComplete())
        {
			if(!this.repoLoc.equals(""))
			{
				//date object used to create the file with the date in it
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				try {
					File file = new File(this.repoLoc + this.postDir + dateFormat.format(date) + "-" + this.SafeTitle() + ".markdown");
					if(file.exists())
						return false;
					BufferedWriter output = new BufferedWriter(new FileWriter(file));
					//yaml front matter
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
	            	//content
	            	output.newLine();
	            	output.write(this.getPostContent());
	            	output.newLine();
	            	output.close();
				} catch (IOException e)
				{
					return false;
				}
			}else{
	           	return false;
			}
		}
		return true;
	}
	
	/**
	 * Sets the post author
	 * @param author
	 */
	public abstract void setPostAuthor(String author);
	
	/**
	 * Sets the post datetime
	 * @param date
	 * @param time
	 */
	public abstract void setPostDatetime(String date, String time);
	
	/**
	 * Sets the post presentation data or resource
	 * @param PresentationData
	 */
	public abstract void setPostPresentationData(String PresentationData); 
	
	/**
	 * Sets the post duration
	 * @param Duration
	 */
	public abstract void setPostDuration(int Duration);
	
	/**
	 * Sets the post location
	 * @param post_location
	 */
	public abstract void setPostLocation(String post_location);
	
	/**
	 * Sets the post team
	 * @param team
	 */
	public abstract void setPostTeam(String team);
	
	/**
	 * Sets the state of the post expand field
	 * @param TorF
	 */
	public abstract void setPostExpand(boolean TorF);
	
	/**
	 * Sets the state of the post finished field
	 * @param TorF
	 */
	public abstract void setPostFinished(boolean TorF);
	
	/**
	 * Sets the state of the post summary
	 * @param summary
	 */
	public abstract void setPostSummary(String summary);
	
	/**
	 * Returns the state of the post object on if all of it's fields have been filled
	 * @return state
	 */
	public abstract boolean objectComplete();
	
	
	/**
	 * Returns true if the object uses the leader form
	 * @return boolean
	 */
	public boolean haveLeader() {
		return this.bleader;
	}
	
	/**
	 * Sets the state of the object to require the use of a leader form
	 */
	public void requireLeader(){
		this.bleader = true;
	}
	
	/**
	 * Returns true if the object uses the team form
	 * @return boolean
	 */
	public boolean haveTeam() {
		return this.bteam;
	}
	
	/**
	 * Sets the state of the object to require the use of a team form
	 */
	public void requireTeam(){
		this.bteam = true;
	}
	
	/**
	 * Returns true if the object uses the expand checkbox
	 * @return boolean
	 */
	public boolean haveExpand() {
		return this.bexpand;
	}
	/**
	 * Sets the state of the object to require the use of a expand checkbox
	 */
	public void requireExpand(){
		this.bexpand = true;
	}
	
	/**
	 * Returns true if the object uses the completed checkbox
	 * @return boolean
	 */
	public boolean haveFinished() {
		return this.bfinished;
	}
	
	/**
	 * Sets the state of the object to require the use of a completed checkbox
	 */
	public void requireFinished(){
		this.bfinished = true;
	}
	
	/**
	 * Returns true if the object uses the summary form
	 * @return boolean
	 */
	public boolean haveSummary() {
		return this.bsummary;
	}
	
	/**
	 * Sets the state of the object to require the use of a summary form
	 */
	public void requireSummary(){
		this.bsummary = true;
	}
	
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
