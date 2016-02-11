package fever.graph.model.TimeLine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;

import fever.graph.model.CommitNode;
import fever.graph.utils.DBConnection;

public class GraphStats
{

	static private Map<String, Stat> results = new HashMap<String,Stat>();
	
	public static void main(String[] args) throws Exception
	{

		
		
		System.out.println("Extracting stats about Feature TimeLines and Commits");
		String query = "Match (tl:TimeLine) return tl";
		
		try(Transaction tx = DBConnection.getService().beginTx(); Result result = DBConnection.getService().execute( query ))
		{
		    while ( result.hasNext() )
		    {
		        Map<String,Object> row = result.next();
		        for ( Entry<String,Object> column : row.entrySet() )
		        {
		        	Node n = (Node) column.getValue();
		        	extractInfoFromNode(n);
		        }
		    }
		    tx.success();
		}
		catch(Exception e)
		{
			throw new Exception("Failed to retrieve first commit node",e);
		}
		
		System.out.println("Done getting info, now dumping stats in file");
		
		File output = new File("output_stats.txt");
		output.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(output));
		for(String f_name : results.keySet() )
		{
			Stat r = results.get(f_name);
			bw.append(r.getCSV()+"\n");
			bw.flush();
		}
		bw.close();
	}

	private static void extractInfoFromNode(Node n) throws Exception
	{
		Stat feature_stat = new Stat();
		feature_stat.feature_name = DBConnection.getPropValue(n, "name");
		feature_stat.is_modular = false; 
		results.put(feature_stat.feature_name, feature_stat);
		
		Iterable<Relationship> core_updates = n.getRelationships(FeatureTimeLineNode.Relationships.FEATURE_CORE_UPDATE);
		Iterator<Relationship> core_itr = core_updates.iterator();
		while(core_itr.hasNext())
		{
			Relationship rel = core_itr.next();
			Node target = rel.getEndNode();
			if(target.hasLabel(DynamicLabel.label("FeatureEdit")))
			{
				feature_stat.nb_vm_update ++;
				
				Iterator<Relationship> rels_to_commit = target.getRelationships(Direction.INCOMING, CommitNode.Relationships.CHANGES_VM).iterator();
				while(rels_to_commit.hasNext())
				{	
					Relationship r =rels_to_commit.next();
					Node commit = r.getStartNode();
					String commitId = (String) commit.getProperty("hash");
					if ( !feature_stat.core_update_commits.contains(commitId))
					{
						feature_stat.core_update_commits.add(commitId);
					}
					if(feature_stat.influence_update_commits.contains(commitId) && !feature_stat.full_update_commits.contains(commitId))
					{
						feature_stat.full_update_commits.add(commitId);
					}					
				}
			}
			else if(target.hasLabel(DynamicLabel.label("MappingEdit")))
			{
				feature_stat.nb_mapping_update ++;
				feature_stat.is_modular = true;
				Iterator<Relationship> rels_to_commit = target.getRelationships(Direction.INCOMING, CommitNode.Relationships.CHANGES_BUILD).iterator();
				while(rels_to_commit.hasNext())
				{	
					Relationship r =rels_to_commit.next();
					Node commit = r.getStartNode();
					String commitId = (String) commit.getProperty("hash");
					if ( !feature_stat.core_update_commits.contains(commitId))
					{
						feature_stat.core_update_commits.add(commitId);
					}
					if(feature_stat.influence_update_commits.contains(commitId) && !feature_stat.full_update_commits.contains(commitId))
					{
						feature_stat.full_update_commits.add(commitId);
					}					
				}
			}
			else if(target.hasLabel(DynamicLabel.label("FileEdit")))
			{
				feature_stat.nb_file_update ++;
				Iterator<Relationship> rels_to_commit = target.getRelationships(Direction.INCOMING, CommitNode.Relationships.TOUCHES).iterator();
				while(rels_to_commit.hasNext())
				{	
					Relationship r =rels_to_commit.next();
					Node commit = r.getStartNode();
					String commitId = (String) commit.getProperty("hash");
					if ( !feature_stat.core_update_commits.contains(commitId))
					{
						feature_stat.core_update_commits.add(commitId);
					}
					if(feature_stat.influence_update_commits.contains(commitId) && !feature_stat.full_update_commits.contains(commitId))
					{
						feature_stat.full_update_commits.add(commitId);
					}					
				}
			}
		}
		
		
		Iterator<Relationship> influence_updates = n.getRelationships(FeatureTimeLineNode.Relationships.FEATURE_INFLUENCE_UPDATE).iterator();
		while(influence_updates.hasNext())
		{
			Relationship rel = influence_updates.next();
			Node target = rel.getEndNode();
			
			if(target.hasLabel(DynamicLabel.label("SourceEdit")))
			{
				feature_stat.nb_interaction_update ++;
				Iterator<Relationship> rels_to_commit = target.getRelationships(Direction.INCOMING, CommitNode.Relationships.CHANGES_IMPLEMENTATION).iterator();
				while(rels_to_commit.hasNext())
				{	
					Relationship r =rels_to_commit.next();
					Node commit = r.getStartNode();
					String commitId = (String) commit.getProperty("hash");
					if ( !feature_stat.influence_update_commits.contains(commitId))
					{
						feature_stat.influence_update_commits.add(commitId);
					}
					if(feature_stat.core_update_commits.contains(commitId) && !feature_stat.full_update_commits.contains(commitId))
					{
						feature_stat.full_update_commits.add(commitId);
					}					
				}
			}
		}
	}
}
