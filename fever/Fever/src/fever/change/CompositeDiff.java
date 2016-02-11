package fever.change;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.revwalk.RevCommit;

import models.CodeEdit;


public class CompositeDiff extends DiffEntry 
{

	List<RevCommit> _commits = new ArrayList<RevCommit>();
	private String _oldPath = "";
	private String _newPath = "";
	private ObjectId _oldId = null;
	private ObjectId _newId = null;
	private ChangeType _change = null;
	public List<Entry<Integer,Integer>> added_lines = new ArrayList<Entry<Integer,Integer>>();
	public List<Entry<Integer,Integer>> removed_lines = new ArrayList<Entry<Integer,Integer>>();
	
	public List<CodeEdit> changed_lines = new ArrayList<CodeEdit>();
	
	public List<RevCommit> getCommits ()
	{
		return _commits;
	}
	
	public CompositeDiff(DiffEntry d, RevCommit c)
	{
		_oldPath = d.getOldPath();
		_newPath = d.getNewPath();
		_oldId = d.getOldId().toObjectId();
		_newId = d.getNewId().toObjectId();
		_change = d.getChangeType();
	}
	
	/**
	 * Return true if this diff applies to this file.
	 * 
	 * @param old_fileName
	 * @param new_fileName
	 * @return
	 */
	public boolean isConcernedBy(DiffEntry d)
	{
		if(d.getOldPath().equals(_newPath) )
		{
			return true;
		}
		else 
			return false;
	}
	
	
	@Override 
	public ChangeType getChangeType()
	{
		return _change;
	}
	
	
	
	public void addLaterCommit(DiffEntry d, RevCommit c)
	{
		_newPath = d.getNewPath();
		_newId = d.getNewId().toObjectId();		

		_commits.add(c);
		
		
		if(_change == ChangeType.MODIFY && d.getChangeType() == ChangeType.DELETE)
		{
			_change = d.getChangeType();
		}//else we keep the original change type.
		
	}

	@Override
	public String getNewPath()
	{
		return _newPath;
	}
	
	@Override
	public String getOldPath()
	{
		return _oldPath;
	}
	

	public ObjectId getOldObjectId()
	{
		return _oldId;
	}
	
	
	public ObjectId getNewObjectId()
	{
		return _newId;
	}
	
}
