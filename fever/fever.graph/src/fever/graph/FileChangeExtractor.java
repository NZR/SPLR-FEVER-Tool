package fever.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import fever.change.FileChange;
import fever.graph.model.ArtefactEditNode;
import fever.graph.model.CommitNode;
import fever.graph.utils.DBConnection;
import fever.utils.ParsingUtils;
import models.ChangeType;
import models.CodeEdit;

public class FileChangeExtractor
{
	public Map<String, List<String>> commit_parents;
	public Map<String, Node> files;
	
	public FileChangeExtractor(Map<String, List<String>> commit_parents, Map<String, Node> files)
	{
		this.commit_parents = commit_parents;
		this.files = files;
	}
	
	/**
	 * Creates neo4j nodes for each file touched in the commit
	 * 
	 * @param files a list of FileChange object representing edit performed in the commit
	 * @param commitId the Neo4j id of the commit node  
	 */
	public List<Node> addFileChangesToCommit(List<FileChange> files, Node commit_node) throws Exception
	{
		List<Node> file_nodes = new ArrayList<Node>();
		for(FileChange fc : files)
		{
			ChangeType chg = fc.file_change;
			String name = fc.file_name;
			boolean build = ParsingUtils.isBuildFile(name);
			boolean source = ParsingUtils.isSourceFile(name);
			boolean vm = ParsingUtils.isVariabilityFile(name);
			
			Node file_edit = createNodeForFileChange(commit_node, chg, name, build, source, vm) ;
			file_nodes.add(file_edit);
			
			if(source && !fc.edits.isEmpty())
			{
				createNodesForCodeEdits(file_edit,fc);
			}
		}

		return file_nodes;
	}


	/**
	 * WARNING: Must be in a transaction to call this method.
	 * 
	 * @param file_edit
	 * @param fc
	 * @throws Exception
	 */
	private void createNodesForCodeEdits(Node file_edit, FileChange fc) throws Exception
	{
		for(CodeEdit e : fc.edits)
		{
			Node n = DBConnection.getService().createNode();
			n.addLabel( DynamicLabel.label("LineEdit"));
			n.addLabel( DynamicLabel.label("Unassigned"));
			n.setProperty("Content", e.getDiff());
			file_edit.createRelationshipTo(n, ArtefactEditNode.Relationships.DIFF);
		}
	}

	/**
	 * Creates a Neo4j node for one file change associated with commit "commitId". 
	 * It creates a new node with all the right attributes given as parameters
	 * and then creates a relationship between the commit Neo4j node and the newly created file edit node.
	 * 
	 * WARNING: Must be in a transaction to call this method.
	 * 
	 * @param commitId the ID of the commit touching this file
	 * @param chg the change type affecting this file
	 * @param name the name of the touched file
	 * @param build flag: is this a build file? 
	 * @param source flag: is this a source file? 
	 * @param vm flag: is this a variability model file? 
	 * @throws Exception if the node, or relationship, creation fails.
	 * 
	 */
	private Node createNodeForFileChange(Node commit_node, ChangeType chg, String name, boolean build, boolean source, boolean vm)
	        throws Exception
	{
		Node n  = DBConnection.getService().createNode();
		n.addLabel( DynamicLabel.label("ArtefactEdit"));			
		n.setProperty(ArtefactEditNode._name, name);
		n.setProperty(ArtefactEditNode._change, chg.getName());
		
		if(vm)
			n.setProperty(ArtefactEditNode._type,"vm");
		else if (build)
			n.setProperty(ArtefactEditNode._type,"build");
		else if (source)
			n.setProperty(ArtefactEditNode._type,"source");
		
		commit_node.createRelationshipTo(n, CommitNode.Relationships.TOUCHES);
		
		files.put(commit_node.getId()+"_"+name, n);

		if (-1 == n.getId()) throw new Exception("node creation failed");
		
		return n;
	}

}
