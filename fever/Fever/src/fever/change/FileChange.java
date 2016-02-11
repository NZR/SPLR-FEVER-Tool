package fever.change;

import java.util.ArrayList;
import java.util.List;

import models.ChangeType;
import models.CompilationTargetType;
import models.CodeEdit;

public class FileChange {

	
	/**
	 * 
	 * IMPLEMENTATION FILE CHANGE INFORMATION
	 */
	
	public ChangeType file_change;
	public CompilationTargetType file_type;
	public boolean mapped = false;
	public String file_name;
	public List<CodeEdit> edits = new ArrayList<CodeEdit>();
}
