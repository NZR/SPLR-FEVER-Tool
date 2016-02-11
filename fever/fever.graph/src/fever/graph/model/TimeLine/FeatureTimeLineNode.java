package fever.graph.model.TimeLine;

import java.util.Map;
import java.util.Map.Entry;

import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;

import fever.graph.utils.DBConnection;

public class FeatureTimeLineNode
{
	public static final String _name = "name";
	public static final String _label_timeline = "TimeLine";
	
	public static enum Relationships implements RelationshipType
	{
	    FEATURE_CORE_UPDATE, FEATURE_INFLUENCE_UPDATE
	}
	
	
	
}
