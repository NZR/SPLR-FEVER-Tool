package fever.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import fever.graph.model.CommitNode;
import fever.graph.model.MappingEditNode;
import fever.graph.model.SourceEditNode;
import fever.graph.utils.DBConnection;
import fever.parsers.implementation.PartialImplEvolution;
import models.CodeEdit;
import models.ConditionalBlock;

public class CodeChangeExtractor
{
	public Map<String, List<String>> commit_parents;
	public Map<String, Node> files;
	
	public CodeChangeExtractor(Map<String, List<String>> commit_parents, Map<String, Node> files)
	{
		this.commit_parents = commit_parents;
		this.files = files;
	}

	public List<Node> addCodeChangesToCommit(List<PartialImplEvolution> impl_changes, Node commit_node) throws Exception
	{
		List<Node> nodes = new ArrayList<Node>(); 	
		for(PartialImplEvolution pie : impl_changes)
		{
			Node file_edit =files.get(commit_node.getId() + "_" + pie.get_file_name());
			if(file_edit == null)
				continue;

			buildAddedCodeBlocks(commit_node, nodes, pie, file_edit);
			buildRemoveCodeBlocks(commit_node, nodes, pie, file_edit);
			buildModdedCodeBlocks(commit_node, nodes, pie, file_edit);
			buildFeatRefChange(commit_node, nodes, pie, file_edit);
		}
		return nodes;
	}

	private void buildAddedCodeBlocks(Node commit_node, List<Node> nodes, PartialImplEvolution pie, Node file_edit) throws Exception
	{
			for(ConditionalBlock b : pie.added_blocks_with_new_code)
				nodes.add(addInteractionChangeNodeToCommit(b.getCondition(),"New","New", file_edit, commit_node, b.getEditedBy()));
			for(ConditionalBlock b : pie.added_blocks_with_edited_code)
				nodes.add(addInteractionChangeNodeToCommit(b.getCondition(),"New","Edited", file_edit, commit_node,b.getEditedBy()));
			for(ConditionalBlock b : pie.added_blocks_with_preserved_code)
				nodes.add(addInteractionChangeNodeToCommit(b.getCondition(),"New","Preserved", file_edit, commit_node,b.getEditedBy()));
	}

	private void buildRemoveCodeBlocks(Node commit_node, List<Node> nodes, PartialImplEvolution pie, Node file_edit) throws Exception
	{

			for(ConditionalBlock b : pie.removed_blocks_with_removed_code)
				nodes.add(addInteractionChangeNodeToCommit(b.getCondition(),"Remove","Remove", file_edit, commit_node,b.getEditedBy()));
			for(ConditionalBlock b : pie.removed_blocks_with_edited_code)
				nodes.add(addInteractionChangeNodeToCommit(b.getCondition(),"Remove","Edited", file_edit, commit_node,b.getEditedBy()));
			for(ConditionalBlock b : pie.removed_blocks_with_preserved_code)
				nodes.add(addInteractionChangeNodeToCommit(b.getCondition(),"Remove","Preserved", file_edit, commit_node,b.getEditedBy()));
	}

	private void buildModdedCodeBlocks(Node commit_node, List<Node> nodes, PartialImplEvolution pie, Node file_edit) throws Exception
	{
			for(ConditionalBlock b : pie.modded_code_blocks)
				nodes.add(addInteractionChangeNodeToCommit(b.getCondition(),"Modified","Edited", file_edit, commit_node,b.getEditedBy()));
	}

	private void buildFeatRefChange(Node commit_node, List<Node> nodes, PartialImplEvolution pie, Node file_edit) throws Exception
	{
			for(String s : pie.added_value_features)
				nodes.add(addRefChangeNodeToCommit(s,"Add", file_edit, commit_node));
			for(String s : pie.removed_value_features)
				nodes.add(addRefChangeNodeToCommit(s,"Remove", file_edit, commit_node));
	}
	
	private Node addRefChangeNodeToCommit(String ref, String edit, Node file_edit,Node commit_node) throws Exception
	{
		Node n = null;
		try (Transaction tx = DBConnection.getService().beginTx())
		{
			n = DBConnection.getService().createNode();
			n.addLabel( DynamicLabel.label("SourceEdit"));
			n.addLabel( DynamicLabel.label(SourceEditNode._label_reference));
			
			n.setProperty(SourceEditNode._reference, ref);
			n.setProperty(SourceEditNode._change, edit);
			
			commit_node.createRelationshipTo(n, CommitNode.Relationships.CHANGES_IMPLEMENTATION);
			n.createRelationshipTo(file_edit, MappingEditNode.Relationships.IN);
			tx.success();
		}
		catch(Exception e)
		{
			throw new Exception("Failed to create new Source Change node  - " + e.getMessage());
		}
		
		return n;
	}
	
	private Node addInteractionChangeNodeToCommit(String condition, String edit, String code_edit, Node file_edit,Node commit_node, EList<CodeEdit> edits) throws Exception
	{
		Node n = null;
					
		n = DBConnection.getService().createNode();
		n.addLabel( DynamicLabel.label("SourceEdit"));
		n.addLabel( DynamicLabel.label(SourceEditNode._label_interaction));
		
		n.setProperty(SourceEditNode._interaction, condition);
		n.setProperty(SourceEditNode._change, edit);
		n.setProperty(SourceEditNode._code_edit, code_edit);
		
		commit_node.createRelationshipTo(n, CommitNode.Relationships.CHANGES_IMPLEMENTATION);
		n.createRelationshipTo(file_edit, MappingEditNode.Relationships.IN);
		
		
		for(CodeEdit ce : edits)
		{
			Node edit_node = DBConnection.getService().createNode();
			edit_node.addLabel( DynamicLabel.label("LineEdit"));
			edit_node.setProperty("Diff", ce.getDiff());
			n.createRelationshipTo(edit_node, SourceEditNode.Relationships.EDITED_BY);
		}

		return n;
	}
	
}

