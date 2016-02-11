package fever.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;

import fever.graph.model.ArtefactEditNode;
import fever.graph.model.CommitNode;
import fever.graph.model.MappingEditNode;
import fever.graph.utils.DBConnection;
import fever.parsers.build.BuildChange;
import fever.parsers.build.BuildChange.ArtefactType;
import fever.parsers.build.BuildTargetChange;
import fever.parsers.build.PartialMappingEvolution;
import models.ChangeType;
import models.CompilationTargetType;

public class BuildChangeExtractor
{
	public Map<String, List<String>> commit_parents;
	public Map<String, Node> files;
	
	public BuildChangeExtractor(Map<String, List<String>> commit_parents, Map<String, Node> files)
	{
		this.commit_parents = commit_parents;
		this.files = files;
	}
	
	
	public List<Node> addBuildChangesToCommit(List<PartialMappingEvolution> build_changes, Node commit_node) throws Exception
	{
		List<Node> nodes = new ArrayList<Node>();	
		for(PartialMappingEvolution fm : build_changes)
		{
			String build_file_name = fm._file_name;

			Node file_edit =files.get(commit_node.getId() + "_" + build_file_name);
			if(file_edit == null)
			{
				continue;
			}
			
			for(BuildChange bc : fm._symbol_changes)
			{
				if ( bc.type== ArtefactType.SYMBOL)
					continue;
				
				for(BuildTargetChange btc : bc.targets)
				{
					Node n = createNodeForMappingChange ( bc, bc._name, bc.type, btc, commit_node, file_edit);
					nodes.add(n);
				}			
			}
		}
		
		return nodes;
	}


	/**
	 * WARNING: You must be in a Neo4j transaction to call this method.
	 * 
	 * @param bc
	 * @param affectedFeature
	 * @param type
	 * @param btc
	 * @param commit_node
	 * @param file_edit
	 * @return
	 * @throws Exception
	 */
	private Node createNodeForMappingChange(BuildChange bc, String affectedFeature, ArtefactType type, BuildTargetChange btc, Node commit_node, Node file_edit) throws Exception
	{	
		Node n = null;
		n = DBConnection.getService().createNode();
		n.addLabel( DynamicLabel.label("MappingEdit"));
		
		n.setProperty(MappingEditNode._type, bc.type == ArtefactType.FEATURE ? "FEATURE" : "SYMBOL");
		n.setProperty(MappingEditNode._feature, affectedFeature);
		n.setProperty(MappingEditNode._target, btc._name);
		n.setProperty(MappingEditNode._target_type, btc._type.getLiteral());
		n.setProperty(MappingEditNode._mapping_change, bc._change.getLiteral());
		n.setProperty(MappingEditNode._target_change, btc._change.getLiteral());
		n.setProperty(MappingEditNode._artefact_change, btc._state.getLiteral());
		
		commit_node.createRelationshipTo(n, CommitNode.Relationships.CHANGES_BUILD);
		n.createRelationshipTo(file_edit, MappingEditNode.Relationships.IN);
		
		if(btc._type == CompilationTargetType.COMPILATION_UNIT)
		{
			adjustTargetChange(btc, commit_node, n);
		}
		return n;
	}


	private void adjustTargetChange(BuildTargetChange btc, Node commit_node, Node n) throws Exception
	{
		
			RelationshipType t = CommitNode.Relationships.TOUCHES;
			Direction d = Direction.OUTGOING;
			Iterable<Relationship> rels = commit_node.getRelationships(t,d);
			Iterator<Relationship> rel_itr = rels.iterator();
			
			boolean hit = false;
			
			while(rel_itr.hasNext())
			{
				Relationship rel = rel_itr.next();
				Node artefact = rel.getEndNode();
				
				String art_name = (String)artefact.getProperty(ArtefactEditNode._name);
				if(art_name.contains("."))
					art_name = art_name.substring(0,art_name.lastIndexOf(".")-1);
				if(art_name.contains("/"))
					art_name = art_name.substring(art_name.lastIndexOf("/")+1);
				if(btc._name.contains(art_name))
				{
					String art_change = (String)artefact.getProperty(ArtefactEditNode._change);
					n.setProperty(MappingEditNode._target_change, artefact.getProperty(ArtefactEditNode._change));
				}
			}
			
			if(!hit)
			{
				n.setProperty(MappingEditNode._target_change, btc._change.getLiteral());
			}
	}
	
}
