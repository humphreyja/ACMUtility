
public class workshop extends post{
	private String post_author;
	private String post_location;
	private String post_datetime;
	private String post_presentation_data;
	
	workshop()
	{
		this.requireTitle();
		this.requireAuthor();
		this.requireContent();
		this.requireDateTime();
		this.requirePresentationData();
		this.requireLocation();
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
	 * Returns post location
	 * @return String post_location
	 */
	public String getPostLocation() {
		return post_location;
	}
	/**
	 * Sets the post Location
	 * @param post_location
	 */
	public void setPostLocation(String post_location) {
		this.post_location = post_location;
	}
	/**
	 * Returns the post presentation data
	 * @return String presentation_data
	 */
	public String getPostPresentationData() {
		return post_presentation_data;
	}
	/**
	 * Sets the post presentation data
	 * @param post_presentation_data
	 */
	public void setPostPresentationData(String post_presentation_data) {
		this.post_presentation_data = post_presentation_data;
	}
	
	public String[] getPostAttributesList()
	{
		String[] post_attributes = {this.getPostTitle(),this.getPostAuthor(),this.getPostDatetime(),this.getPostLocation(),this.getPostPresentationData(),this.getPostContent()}; 
		return post_attributes;
	}
}
