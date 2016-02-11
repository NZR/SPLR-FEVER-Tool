package fever.graph.model.TimeLine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;

import fever.graph.model.ArtefactEditNode;
import fever.graph.model.CommitNode;
import fever.graph.model.FeatureEditNode;
import fever.graph.model.MappingEditNode;
import fever.graph.model.SourceEditNode;
import fever.graph.utils.DBConnection;

public class TimeLineNodeGenerator
{
	static Map<String,Node> feature_timeLineNodes = new HashMap<String,Node>(); 
	static Map<String,List<String>> feature_file_mapping = new HashMap<String,List<String>>();
	static Map<String,List<String>> file_feature_mapping = new HashMap<String,List<String>>();
	static Map<String,List<String>> mappings_to_remove = new HashMap<String,List<String>>();
	
	public static String initial_mapping_file = "/Users/Dante/Documents/workspace/git/SPLR-FEVER/fever/fever.graph/mapping_out.txt";
	
	static Map<String,Node> done_commits = new HashMap<String,Node>();
	/**
	 * Method used to test time line creation and queries.
	 * @param args
	 * @throws Exception
	 */
	static public void main(String[] args) throws Exception
	{
		createTimeLines();
	}
	
	
	private static final void createTimeLines() throws Exception
	{
		
		getInitialFeatureFileMapping();
		
		/**
		 * Get ordered list of commits
		 * 
		 * For each commit: 
		 * 	get feature names
		 * 	update feature mapping based on mapping edit nodes
		 * 	create timeline node for commits
		 * 	link relevant timeline to artefact edits
		 * 	move to next commit  
		 */
		List<Node> commits_to_treat = CommitNode.getFirstCommitNode();
		startExtraction(commits_to_treat);
	}
	
	
	private static void getInitialFeatureFileMapping() throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader(initial_mapping_file));
		String line = null;
		while(( line = br.readLine() ) != null)
		{
			String[] args = line.split(" :: ");
			String feature_name= args[0];
			if(args.length != 2)
				continue;
			
			String[] targets = args[1].split("=");
			List<String> files = new ArrayList<String>();
			for(int i = 0; i < targets.length ; i ++)
			{
				if(targets[i] != null && targets[i].length() != 0 && !files.contains(targets[i]))
					files.add(targets[i]);
			}
			
			for(String t : files)
				addEntry(feature_name,t);
		}
		br.close();
		
	}


	static public void startExtraction(List<Node> commits) throws Exception
	{
		System.out.println("first round - init list.");
		List<Node> nexts = extractAll(commits);
		while(!nexts.isEmpty())
		{
			System.out.println("\t next list size:" + nexts.size());
			System.out.println("Done so far : " + done_commits.size() + "/" + commits.size() );
			nexts = extractAll(nexts);
		}
	}
	
	
	static public List<Node> extractAll(List<Node> commits) throws Exception
	{
		List<Node> nexts = new ArrayList<Node>();
		for(Node n : commits)
		{
			if(!done_commits.containsKey(String.valueOf(n.getId())))
			{
				List<Node> next_for_this_one = extractCommitInfo(n);
				boolean added_some = false;
				for(Node new_commit: next_for_this_one) 
				{
					if (!nexts.contains(new_commit)) //not sure that this does what I hope it does - object comparison on node proxies is not going to work I think - unless Neo4j has a great cache mech.
					{
						nexts.add(new_commit);
						added_some = true;
					}
				}
				if(!added_some)
				{
					System.out.println("commit " + n.getId() + " didn't return any valid next commit to look at.");
				}
			}
			else
			{
				System.out.println("skipping commit I already dealt with");
			}
		}
		return nexts;
	}
	
	static public List<Node> extractCommitInfo(Node commit) throws Exception
	{
		try(Transaction tx = DBConnection.getService().beginTx())
		{
			connectFeatureEdits(commit);
			tx.success();
		}
		catch(Exception e)
		{
			throw new Exception("Failed feature edits to the appropriate time line node",e);
		}
		
		try(Transaction tx = DBConnection.getService().beginTx())
		{
			connectMappingEdits(commit);
			tx.success();
		}
		catch(Exception e)
		{
			throw new Exception("Failed mapping edits to the appropriate time line node",e);
		}
		
		try(Transaction tx = DBConnection.getService().beginTx())
		{
			connectFileEdits(commit);
			tx.success();
		}
		catch(Exception e)
		{
			throw new Exception("Failed file edits to the appropriate time line node",e);
		}
		
		try(Transaction tx = DBConnection.getService().beginTx())
		{
			connectCodeEdit(commit);
			tx.success();
		}
		catch(Exception e)
		{
			throw new Exception("Failed code edits to the appropriate time line node",e);
		}
		
		try(Transaction tx = DBConnection.getService().beginTx())
		{
		
		cleanMappingTable(commit);
		}
		catch(Exception e)
		{
			throw new Exception("Failed code edits to the appropriate time line node",e);
		}
		
		done_commits.put(String.valueOf(commit.getId()), commit);

		return CommitNode.getNextCommitNodes(commit);
	}
	
	
	private static void connectCodeEdit(Node commit) throws Exception
	{
		List<SourceEditNode> sourceEdits = CommitNode.getImplementationEdits(commit);
		for(SourceEditNode n : sourceEdits)
		{
			List<String> f_names = n.getFeatures();
			for(String f_name : f_names)
			{
				Node featureTimeLine = getOrCreateTimeLineNodeFor(f_name);
				featureTimeLine.createRelationshipTo(n.n, FeatureTimeLineNode.Relationships.FEATURE_INFLUENCE_UPDATE);
			}
		}
	}


	private static void connectFileEdits(Node commit) throws Exception
	{
		List<ArtefactEditNode> nodes = CommitNode.getFileEdits(commit);
		
		for(ArtefactEditNode n : nodes)
		{
			String fileName = n.getFileNameWithoutExtension();
			List<String> mapped_feature_names = file_feature_mapping.get(fileName);
			if(mapped_feature_names == null || mapped_feature_names.isEmpty())
				mapped_feature_names =  file_feature_mapping.get(fileName+".o");
			
			if(mapped_feature_names != null && !mapped_feature_names.isEmpty())
			{
				for(String mapped_feature_name : mapped_feature_names)
				{
					Node timeLineNode= getOrCreateTimeLineNodeFor(mapped_feature_name);
					if(timeLineNode != null)
					{
						timeLineNode.createRelationshipTo(n.n, FeatureTimeLineNode.Relationships.FEATURE_CORE_UPDATE);
					}
				}
			}
		}
	}


	private static final void connectMappingEdits(Node commit) throws Exception
	{
		List<MappingEditNode> mapping_edits = CommitNode.getMappingEdits(commit);
		for(MappingEditNode me : mapping_edits)
		{
			String f_name = me.getMappedFeature();
			String file_name = me.getMappingTarget();
			
//			if(me.isNew())
//			{
				addEntry(f_name,file_name);
//			}
////			else
////			{
////				removeEntry(f_name,file_name);
////			}

			Node timeLine = getOrCreateTimeLineNodeFor(f_name);
			timeLine.createRelationshipTo(me.n,FeatureTimeLineNode.Relationships.FEATURE_CORE_UPDATE);
		}
	}
	
	private static final void cleanMappingTable(Node commit) throws Exception
	{
		List<MappingEditNode> mapping_edits = CommitNode.getMappingEdits(commit);
		for(MappingEditNode me : mapping_edits)
		{
			String f_name = me.getMappedFeature();
			String file_name = me.getMappingTarget();
			if(!me.isNew())
			{
				removeEntry(f_name,file_name);
			}
		}
	}
	
	private static void removeEntry(String f_name, String file_name)
	{
		if(file_name.contains("."))
			file_name= file_name.substring(0,file_name.lastIndexOf("."));
		
		List<String> known_features = file_feature_mapping.get(file_name);
		
		if(known_features != null && known_features.contains(f_name))
		{
			known_features.remove(f_name);
		}
		
		List<String> mapped_files = feature_file_mapping.get(f_name);
		if(mapped_files!=null && mapped_files.contains(file_name))
		{
			mapped_files.remove(file_name);
		}
	}


	private static void addEntry(String f_name, String file_name)
	{
		if(file_name.contains("."))
			file_name= file_name.substring(0,file_name.lastIndexOf("."));
		
		
		List<String> known_features = file_feature_mapping.get(file_name);
		
		if(known_features == null)
		{
			known_features = new ArrayList<String>();
			known_features.add(f_name);
			file_feature_mapping.put(file_name, known_features);
		}
		else if(!known_features.contains(f_name))
		{
			known_features.add(f_name);
		}
		
		
		List<String> mapped_files = feature_file_mapping.get(f_name);
		if(mapped_files==null)
		{
			mapped_files = new ArrayList<String>();
			mapped_files.add(file_name);
			feature_file_mapping.put(f_name, mapped_files);
		}
		else
		{
			if(!mapped_files.contains(file_name))
				mapped_files.add(file_name);
		}
	}


	private static final void connectFeatureEdits(Node commit) throws Exception
	{
		List<FeatureEditNode> feature_edits = CommitNode.getFeatureEdits(commit);
		for(FeatureEditNode fe : feature_edits)
		{
			String f_name = fe.getTouchedFeatureName();
			Node timeLine = getOrCreateTimeLineNodeFor(f_name);
			timeLine.createRelationshipTo(fe.n,FeatureTimeLineNode.Relationships.FEATURE_CORE_UPDATE);
		}
	}


	private static Node getOrCreateTimeLineNodeFor(String name) throws Exception
	{
		Node node = feature_timeLineNodes.get(name);
		if(node == null)
		{
			try(Transaction tx = DBConnection.getService().beginTx())
			{
				node = DBConnection.getService().createNode();
				node.addLabel(DynamicLabel.label(FeatureTimeLineNode._label_timeline));
				node.setProperty(FeatureTimeLineNode._name, name);
				tx.success();
			}
			catch(Exception e)
			{
				throw new Exception("failed to create new timeline node : " , e);
			}
			feature_timeLineNodes.put(name, node);
		}
		return node;
	}
}
