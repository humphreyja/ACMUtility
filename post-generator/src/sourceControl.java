import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import edu.nyu.cs.javagit.api.JavaGitConfiguration;
import edu.nyu.cs.javagit.api.JavaGitException;
import edu.nyu.cs.javagit.api.WorkingTree;
import edu.nyu.cs.javagit.api.commands.GitStatus;
import edu.nyu.cs.javagit.api.commands.GitStatusResponse;


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
	
	public boolean commitPost(){
		WorkingTree wt = WorkingTree.getInstance(new File(this.gitRepo));
		try {
			wt.add();
			wt.commit("POST_GENERATOR: Adding new file to posts");
			return true;
		} catch (IOException | JavaGitException e1) {
			GitStatus gitStatus = new GitStatus();
			try {
				GitStatusResponse re = gitStatus.status(new File(this.gitRepo));
				int status = 0;
				status += (re.getNewFilesToCommitSize() > 0)? 1 : 0;
				status += (re.getModifiedFilesToCommitSize() > 0)? 1 : 0;
				status += (re.getRenamedFilesToCommitSize() > 0)? 1 : 0;
				status += (re.getUntrackedFilesSize() > 0)? 1 : 0;
				status += (re.getDeletedFilesToCommitSize() > 0)? 1: 0;
				if (status > 0)
					return false;
				else
					return true;
			} catch (JavaGitException | IOException e) {
				//not a repository
				return false;
			}
		}
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
