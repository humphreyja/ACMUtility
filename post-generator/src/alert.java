
public class alert extends post{
	private String post_location;
	private String post_datetime;
	
	alert()
	{
		this.requireTitle();
		this.requireContent();
		this.requireLocation();
		this.requireDateTime();
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
	
	public String[] getPostAttributesList()
	{
		String[] post_attributes = {this.getPostTitle(),this.getPostDatetime(),this.getPostLocation(),this.getPostContent()}; 
		return post_attributes;
	}
}
