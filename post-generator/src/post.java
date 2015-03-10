public abstract class post {
	private String post_content;
	private String post_title;
	private boolean btitle = false;
	private boolean bauthor = false;
	private boolean bcontent = false;
	private boolean bdatetime = false;
	private boolean bpresentationdate = false;
	private boolean bduration = false;
	private boolean blocation = false;
	
	/*
	 * method to write to file
	 * 
	 * 
	 */
	
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
		return bpresentationdate;
	}
	/**
	 * Sets the state of the object to require the use of a presentation data form
	 */
	public void requirePresentationData() {
		this.bpresentationdate = true;
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
		return post_title;
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
