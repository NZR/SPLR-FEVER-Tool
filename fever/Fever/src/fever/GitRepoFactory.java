package fever;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class GitRepoFactory {

	public static Repository getRepo() throws Exception
	{
		if(_instance == null)
		{
			PropReader r = new PropReader();
			String repoPath = r.getProperty("repo.path");
			
			FileRepositoryBuilder builder = new FileRepositoryBuilder();
			_instance = builder.setGitDir(new File(repoPath+"/.git"))
					.build();
		}
		
		return _instance;
	}
	
	private static Repository _instance = null;
}
