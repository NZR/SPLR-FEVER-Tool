package fever.tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.junit.Test;

import fever.change.FeatureOrientedChange;
import fever.change.FeatureOrientedChange.Optionality;
import fever.parsers.CommitInfoExtractor;
import models.ChangeType;
import models.VariabilityTypes;

public class CodeChangeExtractorTest
{
	
	@Test
	public void code_change_added_removed_ifelse_full_blocks() throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("535d3ae9c808e6a5248f0524dbc7a9e997cf3288");

		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
		
		assertTrue(changes.size() == 1);
 
		s.closeRepo();
	}
	
	
	@Test
	public void new_ifdef_around_existing_line() throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("440b87eac4ca21ccb3f56e7b1f126e0eebcc0f84");

		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
		

		assertTrue(changes.size() == 1);

		s.closeRepo();
	}

/**
0244ad004a54e39308d495fee0a2e637f8b5c317	GENERIC_HARDIRQS
f7c1285f0eba8e0910decc0fa5b409f886e4358e	BOOTLOADER_DRIVER
ecd73cc5c9e137559f4625b347f20cf9ed0de3d5	PPC_INDIRECT_IO
09df7c4c8097ca4a11393b1edd4997d786daad52	X86_OOSTORE		
e269a869417cd4053b37da1b19186902d3cbf63b	SVINTO_SIM
 * @throws Exception
 */
	
	@Test
	public void ifdef_around_existing_code() throws Exception
	{	
		//
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("54e4ff4d402450af5cec599f1cd9ab34997b3149"); 
		
		String feature_name  = "GPIO_ADI";
		int[] expected_sig = {1,0,1,0,0,1,0,1,0,1,0,0,1,0,0,0,1,1,0,0,0,0,0,1,0};
		Vector<Integer> change_sig = toVector(expected_sig);
		
		testFeatureChangeSignature(s, ids, feature_name, change_sig);
	}


private void testFeatureChangeSignature(CommitInfoExtractor s, List<String> ids, String feature_name, Vector<Integer> change_sig) throws Exception
{
	List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
	
	boolean found = false;
	for(FeatureOrientedChange c : changes)
	{
		if(c.f_name.equals(feature_name))
		{
			Vector<Integer> sig  =buildArrayFromFeatureChange(c);
			assertTrue(sig.equals(change_sig));
			found = true;
		}
	}
	assertTrue(found);
	s.closeRepo();
}
	
	private Vector<Integer> toVector(int[] array)
	{
		Vector<Integer> v = new Vector<Integer>();
		for(int i : array)
			v.add(i);
		return v;
	}


	@Test
	public void found_nonexistant_removal_with_code_edit() throws Exception
	{
		//ACPI_PROC_EVENT
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("1696d9dc57e062ce5200f6a42a6aaada15b434bb"); 

		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
		
		assertTrue(changes.size() == 1);

		s.closeRepo();
	}
	
	
	@Test 
	void found_nonexistent_removal_with_preserved_code() throws Exception 
	{
		//BRCMFMAC_SDIO_OOB
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("668761ac01d6f5a36b8e5a24d4e154550e2c4c3b"); 

		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
		
		assertTrue(changes.size() == 1);

		s.closeRepo();
	}
	
	static public Vector<Integer> buildArrayFromFeatureChange(FeatureOrientedChange c)
	{
		
		Vector<Integer> sig = new Vector<Integer>();
		
		boolean isBoolTriFeature = (c.f_type == VariabilityTypes.BOOLEAN || c.f_type == VariabilityTypes.TRISTATE);

		//
		sig.add((c.f_change == ChangeType.ADDED ? 1:0));
		sig.add((c.f_change != ChangeType.ADDED ? 1:0));
		
		sig.add((isBoolTriFeature ? 1:0)); sig.add((!isBoolTriFeature ? 1:0));
		sig.add((c.p.visible ? 1:0)); sig.add((!c.p.visible ? 1:0));
		sig.add((c.f_optionality == Optionality.OPTIONAL ? 1:0)); sig.add((c.f_optionality != Optionality.OPTIONAL ? 1:0));
		
		sig.add((c.p.guard ? 1:0)); sig.add((c.p.modular  ? 1:0));sig.add((c.p.cc_flag ? 1:0));
		

		
		if(c.p.add)
		{
			sig.add((c.p.at_least_one_resource_change_match_feat_change ? 1:0));
			sig.add((c.p.at_least_one_resource_change_doesnot_match_feat_change ? 1:0));
			sig.add(0);sig.add(0);

		}
		else
		{	
			sig.add(0);sig.add(0);
			sig.add((c.p.at_least_one_resource_change_match_feat_change ? 1:0));
			sig.add((c.p.at_least_one_resource_change_doesnot_match_feat_change ? 1:0));
		}
		
		
		if(c.p.add)
		{
			sig.add(c.p.at_least_one_full_code_block_match_feat_change ? 1:0);
			sig.add(c.p.at_least_one_code_block_with_edited_content ? 1:0);
			sig.add(c.p.at_least_one_full_code_block_doesnt_match_feat_change ? 1:0);
			sig.add(0);sig.add(0);sig.add(0);
		}
		else
		{
			sig.add(0);sig.add(0);sig.add(0);
			sig.add(c.p.at_least_one_full_code_block_match_feat_change ? 1:0);
			sig.add(c.p.at_least_one_code_block_with_edited_content ? 1:0);
			sig.add(c.p.at_least_one_full_code_block_doesnt_match_feat_change ? 1:0);
		}
		
		sig.add(( c.p.add && c.p.referenced_value) ? 1:0);
		sig.add((!c.p.add && c.p.referenced_value) ? 1:0);
		
		return sig;
	}
	
	
	//LEFT OVER
	

//	@Test
//	public void test_too_many_fm_changes_found() throws Exception
//	{
//		/**
//		 * The problem here is that all features in the file were seen as removed.
//		 * This issue is caused by Undertaker printing error message inside its output file... 
//		 * 
//		 */
//		CommitInfoExtractor s = new CommitInfoExtractor(); 
//		List<String> ids = new ArrayList<String>(); 
//		ids.add("d1ff4b1cdbabb9ab9813f3d6e1cbec42cc5d6ed8"); //easy modular feature addition on Linux.
//
//		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
//		
//		assertTrue(changes.size() == 1);
//
//		s.closeRepo();
//	}
//	
//	@Test
//	public void rvomf_with_remaining_source_missclassified() throws Exception
//	{
//		/**
//		 * Here we have a rename. 
//		 * For the moment, I don't catch that.
//		 * But the "removal" part of the rename is miss-classified as "RVOMF" - but that's not right since the source file is not removed.
//		 * It stays exactly the same, and is reassigned to the renamed feature.
//		 * 
//		 */
//		CommitInfoExtractor s = new CommitInfoExtractor(); 
//		List<String> ids = new ArrayList<String>(); 
//		ids.add("22ac3e82e1d3e5cad92538fe4ab51906cb220444"); //easy modular feature addition on Linux.
//
//		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
//		
//		assertTrue(changes.size() == 2);
//
//		s.closeRepo();
//	}
//	
//	
//	@Test
//	public void xml_parsing_start_end_entity_error() throws Exception
//	{
//		/**
//		 * During the test run, quite a few commit caused the XML parser to crash when 
//		 * extracting the feature model. The error is : 
//		 * XML document structures must start and end within the same entity.
//		 * 	Here are some for test: 
//			7a3e97b0dc4bbac2ba7803564ab0057722689921 <-- used in this test
//			5d026c7242201e7c9d0e12fcb2bcaffead9d59fd
//			63b1a90da93e019adcafa2b2b1b921fc97debec5
//			5320918b9a87865223fd6b228e530bf30bc64d9d
//			b7370112f5195ae2e2e52b5ef46961422fa4daf0
//			714cc3a574282732dbd0c4389e4f82d750d7e5f9
//
//		 */
//		System.out.println("THIS TEST HAD FAILED IF YOU SEE \"STRUCTURE MUST START AND END WITH THE SAME ENTITY\" ERROR from the XML PARSER");
//		CommitInfoExtractor s = new CommitInfoExtractor(); 
//		List<String> ids = new ArrayList<String>(); 
//		ids.add("714cc3a574282732dbd0c4389e4f82d750d7e5f9"); //easy modular feature addition on Linux.
//
//		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
//		
//		//assertTrue(changes.size() == 2);
//
//		s.closeRepo();
//	}
//	
//	@Test
//	public void xml_parsing_premature_eof () throws Exception
//	{
//		/**
//		 * During the test run, quite a few commit caused the XML parser to crash when 
//		 * extracting the feature model. The error is : 
//		 * "Premature end of file."
//		 * 	Here are some for test: 
//			d314d74c695f967e10598467a326f41c78ed1e20 <-- used in this test.
//			e335e3eb82dada2765297f6ba501afc7555aba10
//			0b95ec56ae19f61ca664e83766a2180057f0e351
//			979b907fa55be8cdbbf455b9204b7e4602f303e6
//
//		 */
//		
//		System.out.println("THIS TEST HAD FAILED IF YOU SEE \"PREMATURE END OF FILE\" ERROR from the XML PARSER");
//		CommitInfoExtractor s = new CommitInfoExtractor(); 
//		List<String> ids = new ArrayList<String>(); 
//		ids.add("d314d74c695f967e10598467a326f41c78ed1e20"); //easy modular feature addition on Linux.
//
//		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
//		
//		//assertTrue(changes.size() == 2);
//
//		s.closeRepo();
//	}
//	
//	
//	@Test 
//	public void change_block_condition_with_existing_code() throws Exception
//	{
//		//092b2fb0766e7a0bf2e50d9cdd7d3b6bb5d12e19
//
//		CommitInfoExtractor s = new CommitInfoExtractor(); 
//		List<String> ids = new ArrayList<String>(); 
//		ids.add("092b2fb0766e7a0bf2e50d9cdd7d3b6bb5d12e19"); //easy modular feature addition on Linux.
//
//		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
//		
//		String feature = "VIRQ_DEBUG";
//		boolean found = false;
//		for(FeatureOrientedChange c : changes)
//		{
//			if(c.f_name.equals(feature))
//			{
//				assertTrue(c.matched_patterns.size() == 0);
//				found = true;
//			}
//		}
//		
//		assertTrue(found);
//
//		feature = "IRQ_DOMAIN_DEBUG";
//		found = false;
//		for(FeatureOrientedChange c : changes)
//		{
//			if(c.f_name.equals(feature))
//			{
//				assertTrue(c.matched_patterns.size() == 0);
//				found = true;
//			}
//		}
//		
//		s.closeRepo();
//		System.gc();
//	}
//
//	@Test
//	public void fcf_but_for_non_visible_feature () throws Exception
//	{
//		CommitInfoExtractor s = new CommitInfoExtractor(); 
//		List<String> ids = new ArrayList<String>(); 
//		ids.add("58af4a244fa9f7ef86f45aa9f8fa835a89274bdd"); 
//
//		String feature = "ARCH_HAS_DMA_SET_COHERENT_MASK";
//		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
//		
//		boolean found = false;
//		for(FeatureOrientedChange c : changes)
//		{
//			if(c.f_name.equals(feature))
//			{
//				assertTrue(c.matched_patterns.size() == 0);
//				found = true;
//			}
//		}
//		
//		assertTrue(found);
//	}
//	
//	//d314d74c695f967e10598467a326f41c78ed1e20
//	
//	@Test
//	public void code_fragemnt_re_conditioned () throws Exception
//	{
//		CommitInfoExtractor s = new CommitInfoExtractor(); 
//		List<String> ids = new ArrayList<String>(); 
//		ids.add("d314d74c695f967e10598467a326f41c78ed1e20"); 
//
//		String feature = "HAVE_NMI_WATCHDOG";
//		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
//		
//		boolean found = false;
//		for(FeatureOrientedChange c : changes)
//		{
//			if(c.f_name.equals(feature))
//			{
//				assertTrue(c.matched_patterns.size() == 0);
//				found = true;
//			}
//		}
//		
//		assertTrue(found);
//	}
//	
//	@Test
//	public void missed_classified_removal() throws Exception
//	{
//		//
//		
//		CommitInfoExtractor s = new CommitInfoExtractor(); 
//		List<String> ids = new ArrayList<String>(); 
//		ids.add("a1be5d649699e0eecfe5fc65130954435543cda4"); 
//
//		String feature = "TIMER_ACORN";
//		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
//		
//		boolean found = false;
//		for(FeatureOrientedChange c : changes)
//		{
//			if(c.f_name.equals(feature))
//			{
//				assertTrue(c.matched_patterns.size() == 0);
//				found = true;
//			}
//		}
//		
//		assertTrue(found);
//	}
//	
//	
//	@Test
//	public void missed_Classified_as_non_modular_with_existing_code() throws Exception
//	{
//		//092b2fb0766e7a0bf2e50d9cdd7d3b6bb5d12e19
//		CommitInfoExtractor s = new CommitInfoExtractor(); 
//		List<String> ids = new ArrayList<String>(); 
//		ids.add("092b2fb0766e7a0bf2e50d9cdd7d3b6bb5d12e19"); 
//
//		String feature = "VIRQ_DEBUG";
//		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
//		
//		boolean found = false;
//		for(FeatureOrientedChange c : changes)
//		{
//			if(c.f_name.equals(feature))
//			{
//				assertTrue(c.matched_patterns.size() == 0);
//				found = true;
//			}
//		}
//		
//		assertTrue(found);
//	}
//	
//	
//	@Test
//	public void cantbemodular_without_commit_window() throws Exception
//	{
//		//
//		
//		CommitInfoExtractor s = new CommitInfoExtractor(); 
//		List<String> ids = new ArrayList<String>(); 
//		ids.add("1f855824757efab36e08f8fc640f4d9fd1d3d1ab"); 
//
//		String feature = "AB8500_BM";
//		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
//		
//		boolean found = false;
//		for(FeatureOrientedChange c : changes)
//		{
//			if(c.f_name.equals(feature))
//			{
//				assertTrue(c.matched_patterns.size() == 0);
//				found = true;
//			}
//		}
//		
//		assertTrue(found);
//	}
//	
//	@Test
//	public void emf_compare_crash() throws Exception
//	{
//		CommitInfoExtractor s = new CommitInfoExtractor(); 
//		List<String> ids = new ArrayList<String>(); 
//		ids.add("ade7615de0643a9da628688e661e08148cd7c463"); 
//
//		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
//	}
//	
//	///
//	
//	@Test 
//	public void multiply_defined_Feature() throws Exception
//	{
//
//		CommitInfoExtractor s = new CommitInfoExtractor(); 
//		List<String> ids = new ArrayList<String>(); 
//		ids.add("5700f743b597951743da9c7d891d3989aac0486e"); 
//
//		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
//		
//		for(FeatureOrientedChange fc : changes)
//		{
//			if(fc.f_name.equals("DEFAULT_IO_DELAY_TYPE"))
//			{
//				throw new Exception("this feature is not modified in this commit.");
//			}
//		}
//	}
//	
//	///
//	
//	@Test public void moved_feature() throws Exception
//	{
//
//		CommitInfoExtractor s = new CommitInfoExtractor(); 
//		List<String> ids = new ArrayList<String>(); 
//		ids.add("ee89bd6bc73d1d14555418a2642172448052f1dd"); 
//
//		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
//		
//	}
//	
//	@Test 
//	public void cc_flags_capture() throws Exception
//	{
//		//
//		CommitInfoExtractor s = new CommitInfoExtractor(); 
//		List<String> ids = new ArrayList<String>(); 
//		ids.add("169c3c164f0dd791dfa023ab02c12cb286a72e6e"); 
//
//		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
//	}
//	
//	@Test 
//	public void cc_flags_capture_2() throws Exception
//	{
//		//
//		CommitInfoExtractor s = new CommitInfoExtractor(); 
//		List<String> ids = new ArrayList<String>(); 
//		ids.add("36ecafc5ad17861e2bc1fb12af4cc97680e25942"); 
//
//		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
//	}
//	
//	@Test
//	public void found_nonexistant_removal_with_code_edit() throws Exception
//	{
//		//ACPI_PROC_EVENT
//		CommitInfoExtractor s = new CommitInfoExtractor(); 
//		List<String> ids = new ArrayList<String>(); 
//		ids.add("1696d9dc57e062ce5200f6a42a6aaada15b434bb"); 
//
//		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
//		
//		assertTrue(changes.size() == 1);
//
//		s.closeRepo();
//	}
//	//
//	@Test
//	public void found_nonexistant_addition_with_code_edit() throws Exception
//	{
//		//DEBUG_KOBJECT_RELEASE
//		CommitInfoExtractor s = new CommitInfoExtractor(); 
//		List<String> ids = new ArrayList<String>(); 
//		ids.add("c817a67ecba7c3c2aaa104796d78f160af60920d"); 
//
//		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
//		
//		assertTrue(changes.size() == 1);
//
//		s.closeRepo();
//	}
//	
//	@Test
//	public void found_nonexistant_deletion_with_preserved_code() throws Exception
//	{
//		//BRCMFMAC_SDIO_OOB
//		CommitInfoExtractor s = new CommitInfoExtractor(); 
//		List<String> ids = new ArrayList<String>(); 
//		ids.add("668761ac01d6f5a36b8e5a24d4e154550e2c4c3b"); 
//
//		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
//		
//		assertTrue(changes.size() == 1);
//
//		s.closeRepo();
//	}
//	
}
