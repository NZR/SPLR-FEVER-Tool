package fever.graph.model;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.unsafe.impl.batchimport.cache.DynamicLongArray;

import fever.graph.utils.DBConnection;
import fever.utils.ParsingUtils;

public class SourceEditNode
{
	public static final String _label_interaction = "interaction_edit";
	public static final String _label_reference = "reference_edit";
	public static final String _interaction = "interaction";
	public static final String _reference = "interaction";
	public static final String _change = "change";
	public static final String _code_edit = "code_edit";
	
	public static enum Relationships implements RelationshipType
	{
	    IN,EDITED_BY
	}
	
	public Node n; 
	
	public SourceEditNode(Node node )
	{
		n = node;
	}
	
	public List<String> getFeatures() throws Exception
	{
		String interaction = DBConnection.getPropValue(n, _interaction);
		List<String> features =  null;
		if ( this.n.hasLabel( DynamicLabel.label(_label_reference))) 
		{
				features = new ArrayList<String>(); 
				features.add(n.getProperty(_interaction).toString());
		}
		else
		{
			features = ParsingUtils.getFeatureNames(interaction);
		}
		
		return features;
	}
	
	
}
