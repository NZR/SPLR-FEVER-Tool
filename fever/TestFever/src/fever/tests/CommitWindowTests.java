package fever.tests;

import fever.GitRepoFactory;
import fever.PropReader;
import fever.change.CompositeDiff;
import fever.change.DiffBuilder;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revplot.PlotWalk;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.junit.Test;

public class CommitWindowTests 
{

	List<CompositeDiff> _diffs = new ArrayList<CompositeDiff>();
	Repository repository = null;
	RevWalk revWalk = null;
	

	
	public void setRepo() throws Exception
	{
		PropReader r = new PropReader();
		String repoPath = r.getProperty("repo.path");
		
		FileRepositoryBuilder builder = new FileRepositoryBuilder();
		repository = GitRepoFactory.getRepo();
	}
	
	@Test
	public void testCompositeCommitBuild() throws Exception
	{
		setRepo();		
		List<RevCommit> commits = new ArrayList<RevCommit>();

		RevCommit c1 = revWalk.parseCommit(ObjectId.fromString("27b11428b7de097c42f205beabb1764f4365443b")); //newest
		RevCommit c2 = revWalk.parseCommit(ObjectId.fromString("a1b8ff4c97b4375d21b6d6c45d75877303f61b3b"));
		RevCommit c3 = revWalk.parseCommit(ObjectId.fromString("5513a510fad73594e29e1e48e760e0a644a8a4f3")); //oldest
		
		commits.add(c3);
		commits.add(c2);
		commits.add(c1);
		
		DiffBuilder db = new DiffBuilder(2);
		db.setCommitList(commits);
		db.buildCompositeCommits();
	}
}
