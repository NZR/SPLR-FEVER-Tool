package fever.parsers.build;

import models.ChangeType;
import models.CompilationTargetType;

public class BuildTargetChange {
	
	public CompilationTargetType _type;
	public ChangeType _change; 
	public String _name;
	public ChangeType _state;

	
	public ChangeType _artefactChange;
}
