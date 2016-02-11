package fever.change;

import java.util.List;


import models.ChangeType;
import models.CompilationTargetType;

public class MappingChange 
{

	/**
	 * MAPPING LEVEL CHANGE INFORMATION
	 */
	
	public CompilationTargetType m_target_type; //type of the artefact mapped to the feature.
	public List<String> targets;				//name/value of the target
	
	public ChangeType m_change;					//mapping change
	public ChangeType m_target_change;			//change to the target themselves
	public ChangeType artefact_change;			//change of the pointed artefacts (for compilation units only)
	public String file_name = "";				//the name of the file itself.
}
