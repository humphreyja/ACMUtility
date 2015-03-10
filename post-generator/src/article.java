
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
		return Integer.toString(this.post_duration);
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
		return post_datetime;
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
		return post_author;
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
		String[] post_attributes = {this.getPostTitle(),this.getPostAuthor(),this.getPostDatetime(),this.getPostDurationString(),this.getPostContent()}; 
		return post_attributes;
	}
}
