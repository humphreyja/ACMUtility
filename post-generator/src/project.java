import java.io.File;


public class project extends post{
	private String post_datetime;
	private String post_leader;
	private String post_team = "";
	private boolean post_expand;
	private boolean post_finished;
	private String post_summary;
	private String post_resources;
	
	
	project()
	{
		this.requireTitle();
		this.requireContent();
		this.requireDateTime();
		this.requireLeader();
		this.requireTeam();
		this.requireExpand();
		this.requireFinished();
		this.requirePresentationData();
		this.requireSummary();
		this.postType = "project";
		this.postLayout = "project";
		this.postDir = File.separatorChar + "projects" + File.separatorChar + this.postDir;
	}
	@Override
	public void setPostAuthor(String author) {
		this.post_leader = author;
		
	}
	
	/**
	 * Returns the post author
	 * @return string post_author
	 */
	public String getPostLeader() {
		return  "leader: \"" + post_leader + "\"";
	}

	@Override
	public void setPostDatetime(String date, String time) {
		datetime dt = new datetime(date,time);
		this.post_datetime = dt.getDateTime();
		
	}
	
	public String getPostDatetime() {
		return  "date: " + post_datetime;
	}

	@Override
	public void setPostPresentationData(String PresentationData) {
		this.post_resources = PresentationData;
		
	}
	
	public String getPostPresentationData(){
		return "resources: " + this.post_resources;
	}

	@Override
	public void setPostDuration(int Duration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPostLocation(String post_location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean objectComplete() {
		if(this.post_title.equals("") || this.post_leader.equals("") || this.post_content.equals("") || this.post_content.equals("Post Content") || this.post_summary.equals("") || this.post_summary.equals("Post Summary"))
			return false;
		else
			return true;
	}

	@Override
	public String[] getPostAttributesList() {
		String[] post_attributes = {this.getPostTitle(),this.getPostLeader(),this.getPostTeam(),this.getPostExpandString(), this.getPostFinishedString(),this.getPostDatetime(),this.getPostPresentationData(),this.getPostSummary()}; 
		return post_attributes;
	}
	@Override
	public void setPostTeam(String team) {
		this.post_team = team;
		
	}
	
	public String getPostTeam()
	{
		return "team: \"" + this.post_team + "\"";
	}
	@Override
	public void setPostExpand(boolean TorF) {
		this.post_expand = TorF;
		
	}
	@Override
	public void setPostFinished(boolean TorF) {
		this.post_finished = TorF;
		
	}
	@Override
	public void setPostSummary(String summary) {
		this.post_summary = summary;
		
	}
	
	public String getPostExpandString(){
		return "expand: " + ((this.post_expand) ? "true" : "false");
	}
	
	public String getPostFinishedString(){
		return "complete: " + ((this.post_finished) ? "true" : "false");
	}
	
	public String getPostSummary(){
		return "summary: \"" + this.post_summary + "\"";
	}

}
