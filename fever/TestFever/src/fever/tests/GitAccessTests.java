package fever.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.junit.Test;

import fever.parsers.CommitInfoExtractor;

public class GitAccessTests {

	@Test
	public void test() throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		
		List<String> ids = new ArrayList<String>(); 
		
		ids.add("77f720b71d88a3cbf574c113566a31c93099f97d"); //easy modular feature addition on Linux.
		
		s.extractFeatureChanges(ids);
		
		System.out.println("test over");
		
	}
	
	@Test
	public void test2() throws Exception
	{
		//that's just a modification of feature. 
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		
		List<String> ids = new ArrayList<String>(); 
		
		ids.add("15cbf627abcd93c3c668d5a92d58d9fec8f953dd"); 
		
		s.extractFeatureChanges(ids);
		
		System.out.println("test over");
		
	}
	
	
	
	@Test
	public void test3 () throws Exception
	{
		
		// Modular and non-modular feature addition.
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		
		List<String> ids = new ArrayList<String>(); 
		
		ids.add("0d1bb41ad4ebca92fafbab6d6c60438d7efef386"); 
		
		s.extractFeatureChanges(ids);
		
		System.out.println("test over");
	}
}
