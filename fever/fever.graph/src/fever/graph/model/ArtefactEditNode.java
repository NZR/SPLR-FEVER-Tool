package fever.graph.model;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;

import fever.graph.utils.DBConnection;

public class ArtefactEditNode
{
	public static final String _type = "type";
	public static final String _name = "name"; 
	public static final String _change = "change";

	public static enum Relationships implements RelationshipType
	{
	    DIFF
	}
	
	public Node n;	
	public ArtefactEditNode(Node node)
	{
		n = node;
	}
	
	public String getFileNameWithoutExtension() throws Exception
	{
		String file_name = DBConnection.getPropValue(n, _name);
		if(file_name.contains("."))
			file_name = file_name.substring(0, file_name.lastIndexOf("."));
		return file_name;
	}
	
}
