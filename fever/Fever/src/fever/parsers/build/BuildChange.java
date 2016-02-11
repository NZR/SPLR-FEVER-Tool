package fever.parsers.build;

import java.util.ArrayList;
import java.util.List;

import models.ChangeType;

public class BuildChange {

	public enum ArtefactType {SYMBOL,FEATURE};

	public ArtefactType type;
	public ChangeType _change;
	public String _name;
	public String _file;
	public List<BuildTargetChange> targets = new ArrayList<BuildTargetChange>();
	
}
