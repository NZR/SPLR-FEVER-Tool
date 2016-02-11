package fever.graph.model;

import java.util.Iterator;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;

import fever.graph.utils.DBConnection;

public class MappingEditNode
{
	public static enum Relationships implements RelationshipType
	{
	    IN
	}
	
	public static final String _feature = "feature"; 
	public static final String _target = "target";
	public static final String _target_type = "target_type";
	public static final String _mapping_change = "mapping_change"; 
	public static final String _target_change = "target_change";
	public static final String _artefact_change = "artefact_change";
	
	public static final String _v_folder = "folder";
	public static final String _v_cu = "c.u.";
	public static final String _v_cff = "cff";
	public static String _type = "type" ;
	
	public Node n ;
	
	public MappingEditNode(Node node)
	{
		n = node;
	}
	
	public String getMappingTarget() throws Exception
	{
		String makefilePath =  "";
		try(Transaction tx = DBConnection.getService().beginTx())
		{
			Iterator<Relationship> rels = n.getRelationships(MappingEditNode.Relationships.IN, Direction.OUTGOING).iterator();
			while(rels.hasNext())
			{
				Relationship r = rels.next();
				Node n = r.getEndNode();
				makefilePath = DBConnection.getPropValue(n, ArtefactEditNode._name);
				break;
			}
			
			makefilePath = makefilePath.substring(0, makefilePath.lastIndexOf("/")+1);
			tx.success();
		}
		
		String artefactName = DBConnection.getPropValue(n, _target);
		if(artefactName.contains("."))
			artefactName.substring(0,artefactName.lastIndexOf("."));
		return (makefilePath+artefactName);
	}
	
	public String getMappedFeature() throws Exception
	{
		return DBConnection.getPropValue(n, _feature);
	}

	public boolean isNew() throws Exception
	{
		String change = DBConnection.getPropValue(n,_target_change); //ADDED - REMOVED - MODIFIED
		if(change.equalsIgnoreCase("ADDED") || change.equalsIgnoreCase("MODIFIED"))
			return true;
		else
			return false;
	}
	
	
}
