package fever.graph.utils;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class DBConnection
{
	
	static GraphDatabaseService _instance = null;
	private static final String DB_PATH = "/Users/Dante/Documents/workspace/tools/neo4j-2.2.5/data/graph.db";
	
	public static void initDB()
	{
		_instance = new GraphDatabaseFactory().newEmbeddedDatabase( DB_PATH );
		registerShutdownHook( _instance );		
	}
	
	
	/**
	 * Get the database service access - will run the db init if not done.
	 * @return a initiated db service
	 * @throws Exception  if connection cannot be established
	 * 
	 */
	public static GraphDatabaseService getService() throws Exception
	{
		if(_instance == null)
			initDB();
		if(_instance == null)
			throw new Exception("Can't connect");
		
		return _instance;
		
	}

	/**
	 * 
	 * turn off the database service.
	 */
	public static void shutdown()
	{
		if(_instance != null)
		{
			_instance.shutdown();
			_instance = null;
		}
	}
	
	
	private static void registerShutdownHook( final GraphDatabaseService graphDb )
	{
	    Runtime.getRuntime().addShutdownHook( new Thread()
	    {
	        @Override
	        public void run()
	        {
	            graphDb.shutdown();
	        }
	    } );
	}
	
	public static String getPropValue(Node n, String prop) throws Exception
	{
		String val = null;
		try(Transaction tx = DBConnection.getService().beginTx())
		{
			val = (String) n.getProperty(prop);
			tx.success();
		}
		catch(Exception e)
		{
			throw new Exception("Failed to retrieve node info ", e);
		}
		return val;
	}
	
}
