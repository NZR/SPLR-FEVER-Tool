package fever.graph.model;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;

import fever.graph.utils.DBConnection;

public class FeatureEditNode
{
	public static final String _name = "name";
	public static final String _type = "type";
	public static final String _visibility = "visibility";
	public static final String _optionality = "optionality";
	public static final String _change = "change";
	
	public static enum Relationships implements RelationshipType
	{
	    IN,WAS,IS
	}
	
	public Node n = null; 
	
	public FeatureEditNode(Node fe_node)
	{
		n = fe_node;
	}
	
	public String getTouchedFeatureName() throws Exception
	{
		try(Transaction tx = DBConnection.getService().beginTx())
		{
			String name = (String)n.getProperty(_name);
			tx.success();
			return name;
		}
		catch(Exception e)
		{
			throw new Exception("Failed to retrieve feature info");
		}
	}
}
