package fever.graph.model;

import org.neo4j.graphdb.RelationshipType;

public class FeatureOrientedChangeNode
{
	public static final String _name = "name";
	public static final String _change = "change";
	public static final String _pattern = "pattern";
	public static final String _label_FOC = "FOC";

	public enum Relationships implements RelationshipType { IMPLEMENTED_IN, DEFINED_BY, MAPPED_BY, REFERENCED_IN };
}
