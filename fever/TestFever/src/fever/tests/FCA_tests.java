package fever.tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fever.change.FeatureOrientedChange;
import fever.parsers.CommitInfoExtractor;

public class FCA_tests {

	//
	
	@Test
	public void move_feature_seen_as_2_deletions() throws Exception
	{
		/**
		 * The problem here is that all features in the file were seen as removed.
		 * This issue is caused by Undertaker printing error message inside its output file... 
		 * 
		 */
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("ab0431059ed0d0e3a9e532ad0488ada25021249d"); //easy modular feature addition on Linux.

		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
		
		assertTrue(changes.size() == 2);

		s.closeRepo();
	}
	
	
	//3cc377b9ae4bd3133bf8ba388d2b2b66b2b973c1
	@Test
	public void shouldnt_find_refs_in_code() throws Exception
	{
		/**
		 * The problem here is that all features in the file were seen as removed.
		 * This issue is caused by Undertaker printing error message inside its output file... 
		 * 
		 */
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("3cc377b9ae4bd3133bf8ba388d2b2b66b2b973c1"); //easy modular feature addition on Linux.

		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
		
		assertTrue(changes.size() == 2);

		s.closeRepo();
	}
	
	@Test
	public void no_code_edit() throws Exception
	{
		/**
		 * The problem here is that all features in the file were seen as removed.
		 * This issue is caused by Undertaker printing error message inside its output file... 
		 * 
		 */
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("69ad5da41b4ed94aef31d4111a3442cfd73ce570"); //easy modular feature addition on Linux.

		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
		
		assertTrue(changes.size() == 1);

		s.closeRepo();
	}
	
	
	@Test 
	public void not_wrapping_existing_code() throws Exception
	{
		/**
		 * The problem here is that all features in the file were seen as removed.
		 * This issue is caused by Undertaker printing error message inside its output file... 
		 * 
		 */
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("994dcf7055df88623d25f3593b931a018a76b502"); //easy modular feature addition on Linux.

		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
		
		assertTrue(changes.size() == 1);

		s.closeRepo();
	}
	
	@Test 
	public void does_wrap_exising_code()
	 throws Exception
	 {
		//
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("0d455c12c6428647547bacccaaced3cae0f35570"); //easy modular feature addition on Linux.

		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
		
		assertTrue(changes.size() == 1);

		s.closeRepo();
	 }
	
	
	@Test
	public void shouldHaveEditedCode()
	throws Exception
	{
		//
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("0d455c12c6428647547bacccaaced3cae0f35570"); //easy modular feature addition on Linux.

		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
		
		assertTrue(changes.size() == 1);

		s.closeRepo();
	}
	
	
	@Test
	public void test()
	 throws Exception
	 {
		
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("54e4ff4d402450af5cec599f1cd9ab34997b3149"); //easy modular feature addition on Linux.

		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
		
		assertTrue(changes.size() == 1);

		s.closeRepo();
	 }
	
	@Test
	public void test_feature_with_no_optionality() throws Exception
	{
		//
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("7f15a256b556bf26780d7a0bd03c88914a852022"); //easy modular feature addition on Linux.

		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
		
		assertTrue(changes.size() == 1);

		s.closeRepo();
	}
}
