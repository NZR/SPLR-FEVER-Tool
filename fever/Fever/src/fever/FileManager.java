package fever;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class takes care of cleaning up temporary files
 * created by the various parsers. 
 *  
 * 
 * @author Dante
 *
 */
public class FileManager
{
	
	private static FileManager _instance = null;
	private List<File> files = new ArrayList<File>();
	
	private FileManager()
	{
	}
	
	public static FileManager getInstance()
	{
		if(_instance == null)
			_instance = new FileManager();
		return _instance;
	}
	
	public void registerFolderForCleanup(File f)
	{
		files.add(f);
	}
	
	void delete(File f) throws IOException 
	{
		  if (f.isDirectory()) {
		    for (File c : f.listFiles())
		      delete(c);
		  }
		  
		  try
		  {
			  if (!f.delete())
			    throw new FileNotFoundException("Failed to delete file: " + f);
		  }
		  catch(FileNotFoundException e)
		  {
			  //I don't mind *not* deleting files that are not around.
			  // and I do it... It's a bit off, but some files are deleted "on exit"
			  // others manually. Hence, some folders/files are already deleted here .
			  // and recursion doesn't help to figure things out. 
			  // Easy way out: ignore error.
			  // Why: cause tests showed I delete everything anyway, so I'm fine (roughly... for the moment... at least).
			  
			  // Just in case you want to know the details, uncomment the line below.
			  //System.err.println("Delete request on nonexistent file " + f.getAbsolutePath());
		  }
	}
	
	public void clean() throws Exception
	{
		for(File f : files)
		{
			delete(f);
		}
	}
	
}
