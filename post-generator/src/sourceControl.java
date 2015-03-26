import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;

import edu.nyu.cs.javagit.api.JavaGitConfiguration;
import edu.nyu.cs.javagit.api.JavaGitException;
import edu.nyu.cs.javagit.api.commands.GitStatus;


public class sourceControl {
	private String gitUser = "";
	private String gitEmail = "";
	private String gitRepo = "";
	private File configFile;

	public boolean checkRepository()
	{
		if (gitUser.isEmpty() || gitEmail.isEmpty() || gitRepo.isEmpty())
			return false;
		try {
			JavaGitConfiguration.getGitVersion();	
		}
		catch (JavaGitException e){
			e.getMessage();
			return false;
		}
		
		File workingTreePath = new File(gitRepo);
		GitStatus gitStatus = new GitStatus();
		try {
			gitStatus.status(workingTreePath);
		} catch (JavaGitException | IOException e) {
			//not a repository
			return false;
		}
		
		configFile = new File(this.gitRepo + File.separatorChar + "_config.yml");
		try {
			if(!FileUtils.readFileToString(configFile).contains("msumacm.org"))
			{
				//not the website's repository
				return false;
			}
		} catch (IOException e) {
			//not the website's repository
			return false;
		}
		
		return true;
	}
	public String getGitUser() {
		return gitUser;
	}
	public void setGitUser(String gitUser) {
		this.gitUser = gitUser;
	}
	public String getGitEmail() {
		return gitEmail;
	}
	public void setGitEmail(String gitEmail) {
		this.gitEmail = gitEmail;
	}
	public String getGitRepo() {
		return gitRepo;
	}
	public void setGitRepo(String gitRepo) {
		this.gitRepo = gitRepo;
	}
	
}
