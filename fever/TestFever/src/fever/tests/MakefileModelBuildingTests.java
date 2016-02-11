package fever.tests;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fever.parsers.CommitInfoExtractor;
import fever.parsers.build.BuildScriptBuilder;


public class MakefileModelBuildingTests {

	

	@Test
	public void test() throws Exception
	{

		File makefile = new File ("resources/SimpleMakefile");
		if ( ! makefile.exists() )
		{
			throw new IllegalArgumentException("Test parameter wrong: can't open the makefile for the test!");
		}
		
		BuildScriptBuilder b = new BuildScriptBuilder();
		b.buildModelFromFile(makefile,"resources/SimpleMakefile");
	}
	
	@Test
	public void test2() throws Exception
	{

		File makefile = new File ("resources/HardMakefile");
		if ( ! makefile.exists() )
		{
			throw new IllegalArgumentException("Test parameter wrong: can't open the makefile for the test!");
		}
		
		BuildScriptBuilder b = new BuildScriptBuilder();
		b.buildModelFromFile(makefile,"resources/HardMakefile");
	}	
	
	@Test
	public void diffMakeFile() throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		
		List<String> ids = new ArrayList<String>(); 
		
		ids.add("77f720b71d88a3cbf574c113566a31c93099f97d"); //easy modular feature addition on Linux.
		
		s.extractFeatureChanges(ids);
		
		System.out.println("test over");
	}
	
	@Test
	public void mappingUdateTest() throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		
		List<String> ids = new ArrayList<String>(); 
		
		ids.add("748de6736c1e482e111f9d1b5a5d5b1787600cad"); //mapping update
		
		s.extractFeatureChanges(ids);
		
		System.out.println("test over");
	}
	
	@Test
	public void ccflagTest() throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		
		List<String> ids = new ArrayList<String>(); 
		
		ids.add("ba55bd74360ea4b8b95e73ed79474d37ff482b36"); //mapping update
		
		s.extractFeatureChanges(ids);
		
		System.out.println("test over");
	}
	
	@Test
	public void moveUnitFromNonFeature() throws Exception
	{
		//
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		
		List<String> ids = new ArrayList<String>(); 
		
		ids.add("cf8d943260528b669c9f0fa6fb4f1c17cab0ecda"); //mapping update
		
		s.extractFeatureChanges(ids);
		
		System.out.println("test over");
	}
	
}
