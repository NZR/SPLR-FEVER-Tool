package fever.graph.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;

import fever.graph.utils.DBConnection;

/**
 * This class represents a commit as represented in our database.
 * 
 * @author Dante
 *
 */
public class CommitNode
{
	public static enum Relationships implements RelationshipType
	{
	    PREVIOUS,NEXT,TOUCHES,CHANGES_VM,CHANGES_BUILD,CHANGES_IMPLEMENTATION
	}
	
	public static final String _hash = "hash";
	public static final String _author = "author";
	public static final String _commiter = "commiter";
	public static final String _message = "message";

	
	private static final String query_first_commit = "MATCH (first_commit:commit) WHERE NOT ()-[:NEXT]->(first_commit) RETURN first_commit";
	
	public static List<Node> getFirstCommitNode() throws Exception
	{
		List<Node> rs = new ArrayList<Node>();
		try(Transaction tx = DBConnection.getService().beginTx(); 
				Result result = DBConnection.getService().execute( query_first_commit ))
		{
			Node n = null;
		    while ( result.hasNext() )
		    {
		        Map<String,Object> row = result.next();
		        for ( Entry<String,Object> column : row.entrySet() )
		        {
		            	 n = (Node) column.getValue() ;
		            	 rs.add(n);
		        }
		    }
		    
		    return rs;
		}
		catch(Exception e)
		{
			throw new Exception("Failed to retrieve starting commit node(s)",e);
		}
	}
	
	public static Node getNextCommitNode(Node currentCommit) throws Exception
	{
		Direction dir  = Direction.OUTGOING;
		return getRelatedNode(currentCommit,CommitNode.Relationships.NEXT, dir);
	}
	
	public static List<Node> getNextCommitNodes(Node currentCommit) throws Exception
	{
		Direction dir  = Direction.OUTGOING;
		return getRelatedNodes(currentCommit,CommitNode.Relationships.NEXT, dir);
	}
	
	public static Node getPreviousCommitNode(Node currentCommit) throws Exception
	{
		Direction dir  = Direction.INCOMING;
		return getRelatedNode(currentCommit,CommitNode.Relationships.NEXT, dir);
	}

	private static Node getRelatedNode(Node currentCommit, RelationshipType t, Direction dir) throws Exception
	{
		try(Transaction tx = DBConnection.getService().beginTx())
		{
			Iterable<Relationship> rels =  currentCommit.getRelationships(t,dir);
			Iterator<Relationship> rel_itr = rels.iterator();
			Node next_commit = null;
			
			while(rel_itr.hasNext())
			{
				Relationship rel = rel_itr.next();
				if(next_commit == null)
					next_commit = rel.getEndNode();
				else
					throw new RuntimeException("More than one next commit, something is really wrong!");
			}
			tx.success();
			return next_commit;
		}
		catch(Exception e)
		{
			throw new Exception("Failed to retrieved next commit - " ,e);
		}
	}
	
	


	private static List<Node> getRelatedNodes(Node root, RelationshipType t, Direction dir) throws Exception
	{
		List<Node> nodes = new ArrayList<Node>();
		
		try(Transaction tx = DBConnection.getService().beginTx())
		{
			Iterable<Relationship> rels =  root.getRelationships(t,dir);
			Iterator<Relationship> rel_itr = rels.iterator();
			while(rel_itr.hasNext())
			{
				Relationship rel = rel_itr.next();
				Node n = rel.getEndNode();
				nodes.add(n);
			}
			tx.success();
		}
		catch(Exception e)
		{
			throw new Exception("Failed to retrieved related node - " ,e);
		}
		return nodes;
	}
	
	public static List<FeatureEditNode> getFeatureEdits(Node commit) throws Exception
	{
		Direction dir = Direction.OUTGOING;
		RelationshipType t = CommitNode.Relationships.CHANGES_VM;
		List<Node> nodes = getRelatedNodes(commit,t,dir);
		List<FeatureEditNode> fedits = new ArrayList<FeatureEditNode>();
		for(Node n :  nodes)
		{
			fedits.add(new FeatureEditNode(n));
			
		}
		return fedits;
	}
	
	
	public static List<ArtefactEditNode> getFileEdits(Node commit) throws Exception
	{
		Direction dir = Direction.OUTGOING;
		RelationshipType t = CommitNode.Relationships.TOUCHES;
		
		List<Node> nodes = getRelatedNodes(commit,t,dir);
		List<ArtefactEditNode> edits = new ArrayList<ArtefactEditNode>();
		for(Node n :  nodes)
		{
			edits.add(new ArtefactEditNode(n));
			
		}
		return edits;
	}
	
	public static List<MappingEditNode> getMappingEdits(Node commit) throws Exception
	{
		Direction dir = Direction.OUTGOING;
		RelationshipType t = CommitNode.Relationships.CHANGES_BUILD;
		
		List<Node> nodes = getRelatedNodes(commit,t,dir);
		List<MappingEditNode> edits = new ArrayList<MappingEditNode>();
		for(Node n :  nodes)
		{
			String change_type = (String)n.getProperty(MappingEditNode._type);
			if(change_type.equals("FEATURE"))
				edits.add(new MappingEditNode(n));
			
		}
		return edits;
	}
	
	public static List<SourceEditNode> getImplementationEdits(Node commit) throws Exception
	{
		Direction dir = Direction.OUTGOING;
		RelationshipType t = CommitNode.Relationships.CHANGES_IMPLEMENTATION;
		List<Node> nodes = getRelatedNodes(commit,t,dir);
		List<SourceEditNode> sourceEdits = new ArrayList<SourceEditNode>();
		for(Node n: nodes)
		{
			sourceEdits.add(new SourceEditNode(n));
		}
		
		return sourceEdits;
	}
	
	
}
