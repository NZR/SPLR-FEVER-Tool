package fever.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;
import fever.graph.model.CommitNode;
import fever.graph.model.FeatureEditNode;
import fever.graph.utils.DBConnection;
import fever.parsers.featuremodel.PartialFMEvolution;
import fever.utils.ParsingUtils;
import models.DefaultValue;
import models.Feature;
import models.Select;

public class VMChangeExtractor
{
	public Map<String, List<String>> commit_parents;
	public Map<String, Node> files;
	
	public VMChangeExtractor(Map<String, List<String>> commit_parents, Map<String, Node> files)
	{
		this.commit_parents = commit_parents;
		this.files = files;
	}
	

	public List<Node> addVMChangesToCommit(List<PartialFMEvolution> fm_changes, Node commit_node) throws Exception
	{
		List<Node> nodes = new ArrayList<Node>();

		Map<Feature,List<String>> added = new HashMap<Feature,List<String>>();
		Map<Feature,List<String>> removed = new HashMap<Feature,List<String>>(); 
		Map<Feature,List<String>> modified = new HashMap<Feature,List<String>>();
		
		for(PartialFMEvolution fm: fm_changes)
		{
			for(Feature f: fm.added_features)
			{
				List<String> files = new ArrayList<String>();
				files.add(fm.file_name);
				added.put(f, files);
			}
			for(Feature f: fm.removed_features)
			{
				List<String> files = new ArrayList<String>();
				files.add(fm.file_name);
				removed.put(f, files);
			}
			for(Feature f: fm.modified_features.keySet())
			{
				List<String> files = new ArrayList<String>();
				files.add(fm.file_name);
				modified.put(f, files);
			}
		}
		
		List<Feature> keys_to_removed = new ArrayList<Feature>();
		
		consolidateEditsAcrossFiles(added, removed, modified, keys_to_removed);

		
		for(PartialFMEvolution fm: fm_changes)
		{
			for(Feature f : fm.added_features)
			{
				List<Node> file_nodes = getFileNodes(added.get(f),commit_node);
				Node n = createFeatureNode(commit_node, null,f,"Add", file_nodes);
				nodes.add(n);
			}
			
			for(Feature f : fm.removed_features)
			{
				List<Node> file_nodes = getFileNodes(removed.get(f),commit_node);
				Node n = createFeatureNode(commit_node, f,null, "Remove", file_nodes);
				nodes.add(n);
			}
			for(Feature f : fm.modified_features.keySet())
			{
				List<Node> file_nodes = getFileNodes(modified.get(f),commit_node);
				Node n = createFeatureNode(commit_node, f,fm.modified_features.get(f), "Modify", file_nodes);
				nodes.add(n);
			}
		}
		

		return nodes;
	}


	private void consolidateEditsAcrossFiles(Map<Feature, List<String>> added, Map<Feature, List<String>> removed, Map<Feature, List<String>> modified,
	        List<Feature> keys_to_removed)
	{
		for(Feature f: added.keySet())
		{
			if(removed.containsKey(f))
			{
				keys_to_removed.add(f);
				List<String> files = new ArrayList<String>();
				if(modified.containsKey(f))
				{
					files = modified.get(f);
				}
				files.addAll(added.get(f));
				files.addAll(removed.get(f));
				modified.put(f, files);
			}
		}

		for(Feature f: keys_to_removed)
		{
			added.remove(f);
			removed.remove(f);
		}
	}
	
	private List<Node> getFileNodes(List<String> file_names, Node commit_node) throws Exception
	{
		List<Node> nodes =new ArrayList<Node>(); 
		for(String s : file_names)
		{
			nodes.add(files.get(commit_node.getId() + "_" + s));
		}
		return nodes;
	}


	
	
	/**
	 * WARNING: you must be in a transaction to call this method!!!
	 * 
	 * @param nodeId commit id to which the new feature node will be attached
	 * @param f_old the feature being added/removed/moded
	 * @param op the operation affecting the feature (add/rem/mod)
	 * @throws Exception if the creation of the node/relationship fails.
	 * 
	 */
	private Node createFeatureNode(Node commit_node, Feature f_old, Feature f_new, String op, List<Node> file_edits) throws Exception
	{
		Node n = null;
		n = DBConnection.getService().createNode();
		n.addLabel( DynamicLabel.label("FeatureEdit"));
		n.setProperty(FeatureEditNode._change, op);
		
		if(f_old == null)
		{
			boolean visible =  ParsingUtils.isFeatureVisible(f_new);
			n.setProperty(FeatureEditNode._name, f_new.getName());
			n.setProperty(FeatureEditNode._type, f_new.getType().getLiteral());
			n.setProperty(FeatureEditNode._optionality,ParsingUtils.isFeatureOptional(f_new) ?  "optional" : "mandatory");
			n.setProperty(FeatureEditNode._visibility, visible? "visible" : "internal");
		}
		else
		{
			boolean visible =  ParsingUtils.isFeatureVisible(f_old);
			n.setProperty(FeatureEditNode._name, f_old.getName());
			n.setProperty(FeatureEditNode._type, f_old.getType().getLiteral());
			n.setProperty(FeatureEditNode._optionality,ParsingUtils.isFeatureOptional(f_old) ? "optional" : "mandatory");
			n.setProperty(FeatureEditNode._visibility,visible? "visible" : "internal");
		}
		
		if(f_old != null)
		{
			Node desc = buildFeatureDescNode(f_old);
			n.createRelationshipTo(desc, FeatureEditNode.Relationships.WAS);
		}
		
		if(f_new != null)
		{
			Node desc = buildFeatureDescNode(f_new);
			n.createRelationshipTo(desc, FeatureEditNode.Relationships.IS);
		}
		
		
		commit_node.createRelationshipTo(n, CommitNode.Relationships.CHANGES_VM);
		for(Node file_node : file_edits)
		{
			if(file_node != null)
			n.createRelationshipTo(file_node, FeatureEditNode.Relationships.IN);
		}
		
		return n;
	}
	
	private Node buildFeatureDescNode(Feature f) throws Exception
	{

		
		Node n = null;
		n = DBConnection.getService().createNode();
		n.addLabel( DynamicLabel.label("FeatureDesc"));
		n.setProperty("name", f.getName());
		n.setProperty("type",f.getType().getLiteral() );
		n.setProperty("depends on", f.getDepends() != null ? f.getDepends() : "" );
		n.setProperty("presence condition", f.getPresenceCondition()!= null ? f.getPresenceCondition() : "" );
		
		n.setProperty(FeatureEditNode._optionality,ParsingUtils.isFeatureOptional(f) ? "optional" : "mandatory");
		n.setProperty(FeatureEditNode._visibility,ParsingUtils.isFeatureVisible(f) ? "visible" : "internal");
		
		String txt = ""; 
		
		for (DefaultValue df : f.getDefaultValues() )
		{
			txt += (	df.getValue() + " if " + df.getCondition()+ " == ") ;
		}
		n.setProperty("default_values", txt.toString() );
		
		txt = "";
		for (Select s : f.getSelects())
		{
			txt += (	s.getTarget() + " " + s.getCondition()+ " \n") ;
		}
		n.setProperty("selects", txt.toString() );
		
		return n;
	}
}