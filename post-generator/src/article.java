
public class article extends post{
	private String post_author;
	private String post_datetime;
	private int post_duration;
	
	article()
	{
		this.requireTitle();
		this.requireAuthor();
		this.requireContent();
		this.requireDateTime();
		this.requireDuration();
		this.requirePresentationData();
		this.postType = "article";
		this.postLayout = "article";
	}
	/**
	 * Returns the post duration
	 * @return int post_duration
	 */
	public int getPostDuration() {
		return this.post_duration;
	}
	/**
	 * Returns the post duration as a string data type
	 * @return String post_duration
	 */
	public String getPostDurationString()
	{
		return  "minutes-to-read: " + Integer.toString(this.post_duration);
	}
	/**
	 * Sets the post duration
	 * @param post_duration
	 */
	public void setPostDuration(int post_duration) {
		this.post_duration = post_duration;
	}
	/**
	 * Returns the post datetime
	 * @return String post_datetime
	 */
	public String getPostDatetime() {
		return  "date: " + post_datetime;
	}
	/**
	 * Sets the post date time
	 * @param post_datetime
	 */
	public void setPostDatetime(String date, String time) {
		datetime dt = new datetime(date,time);
		this.post_datetime = dt.getDateTime();
	}
	/**
	 * Returns the post author
	 * @return int post_author
	 */
	public String getPostAuthor() {
		return  "author: \"" + post_author + "\"";
	}
	/**
	 * Sets the post author
	 * @param post_author
	 */
	public void setPostAuthor(String post_author) {
		this.post_author = post_author;
	}
	
	
	public String[] getPostAttributesList()
	{
		String[] post_attributes = {this.getPostTitle(),this.getPostAuthor(),this.getPostDatetime(),this.getPostDurationString()}; 
		return post_attributes;
	}
	
	@Override
	public boolean objectComplete() {
		if(this.post_title.equals("") || this.post_author.equals("") || this.post_datetime.equals("") || Integer.toString(this.post_duration).equals("") || this.post_content.equals("") || this.post_content.equals("Post Content"))
			return false;
		else
			return true;
	}
	@Override
	public void setPostPresentationData(String PresentationData) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setPostLocation(String post_location) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setPostTeam(String team) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setPostExpand(boolean TorF) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setPostFinished(boolean TorF) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setPostSummary(String summary) {
		// TODO Auto-generated method stub
		
	}
}
