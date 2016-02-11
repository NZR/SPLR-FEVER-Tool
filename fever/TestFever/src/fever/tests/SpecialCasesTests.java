package fever.tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import fever.change.FeatureOrientedChange;
import fever.change.PatternMatcher.patterns;
import fever.parsers.CommitInfoExtractor;
import fever.utils.ParsingUtils;
import models.ChangeType;

/**
 * 
 * @author Dante
 *This class contains specific test cases from commits that were found to be problematic during the evaluation of the FEVER tool.
 *
 */
public class SpecialCasesTests 
{

	@Test
	public void GPIO_ADI() throws Exception
	{	
		/**
		 * This test requires the diff context to be 0 and the diff algorithm to be HISTOGRAM ! (and not Meyers for instances).
		 */
		String commit_id = "54e4ff4d402450af5cec599f1cd9ab34997b3149";
		String feature_name  = "GPIO_ADI";
		int[] expected_sig = {1,0,1,0,0,1,0,1,0,1,0,0,1,0,0,0,1,1,0,0,0,0,0};

		Utils.testFeatureChangeSignature(commit_id, feature_name, expected_sig);
	}
	
//	@Test
//	public void PINCTRL() throws Exception
//	{	
//		String commit_id = "741ecef62a37bcc368ff8c7282f810327edc3d94";
//		String feature_name  = "PINCTRL";
//		int[] expected_sig = {1,0,1,0,0,1,0,1,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0};
//		
//		System.out.println("Will fail as long as I can't compose line together");
//		Utils.testFeatureChangeSignature(commit_id, feature_name, expected_sig);
//	}
//	
	@Test
	public void KUSER_HELPERS() throws Exception
	{	
		String commit_id = "f6f91b0d9fd971c630cef908dde8fe8795aefbf8";
		String feature_name  = "KUSER_HELPERS";
		int[] expected_sig = {1,0,1,0,1,0,1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0};

		Utils.testFeatureChangeSignature(commit_id, feature_name, expected_sig);
	}
	
	@Test
	public void USB_EHCI_HCD_AT91() throws Exception
	{	
		/**
		 * This one forced the introduction of diff line filtering: 
		 * we remove diff containing just one line that appears to be matching a pre-compiler statements
		 * those are removed on the basis that such changes are already captured by ConditionalBlock changes.
		 */
		String commit_id = "9773696105534dd5193576adfe4a0117a6489c64";
		String feature_name  = "USB_EHCI_HCD_AT91";
		int[] expected_sig = {1,0,1,0,1,0,1,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0};

		Utils.testFeatureChangeSignature(commit_id, feature_name, expected_sig);
	}
	
	@Test
	public void GENERIC_HARDIRQS() throws Exception
	{	
		/**
		 * This one forced the introduction of diff line filtering: 
		 * we remove diff containing just one line that appears to be matching a pre-compiler statements
		 * those are removed on the basis that such changes are already captured by ConditionalBlock changes.
		 */
		String commit_id = "0244ad004a54e39308d495fee0a2e637f8b5c317";
		String feature_name  = "GENERIC_HARDIRQS";
		int[] expected_sig = {0,1,1,0,0,1,0,1,1,0,0,0,0,0,1,0,0,0,1,0,1,0,0};

		Utils.testFeatureChangeSignature(commit_id, feature_name, expected_sig);
	}
	

				
	@Test
	public void INITIALIZE_XTENSA_MMU_INSIDE_VMLINUX() throws Exception
	{	
		/**
		 * This one forced the introduction of diff line filtering: 
		 * we remove diff containing just one line that appears to be matching a pre-compiler statements
		 * those are removed on the basis that such changes are already captured by ConditionalBlock changes.
		 */
		String commit_id = "e85e335f8ff615f74e29e09cc2599f095600114b";
		String feature_name  = "INITIALIZE_XTENSA_MMU_INSIDE_VMLINUX";
		int[] expected_sig = {1,0,1,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0};

		Utils.testFeatureChangeSignature(commit_id, feature_name, expected_sig);
	}
	
	@Test
	public void ARM_S3C24XX_CPUFREQ_DEBUGFS () throws Exception
	{
		/**
		 * Update of a condition around #if/else block
		 * I should find a new condition around existing code - with just one line of code.
		 */
		String commit_id = "f023f8dd59bf93e29e9b9bd98a92eeef43b1a32a";
		String feature_name  = "ARM_S3C24XX_CPUFREQ_DEBUGFS";
		int[] expected_sig = {1,0,1,0,1,0,1,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0};
		
		Utils.testFeatureChangeSignature(commit_id, feature_name, expected_sig);
	}
	
	@Test
	public void BOOTLOADER_DRIVER () throws Exception
	{
		/**
		 * Update of a condition around #if/else block
		 * I should find a new condition around existing code - with just one line of code.
		 */
		String commit_id = "f7c1285f0eba8e0910decc0fa5b409f886e4358e";
		String feature_name  = "BOOTLOADER_DRIVER";
		
		int[] expected_sig = {0,1,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0};
		
		Utils.testFeatureChangeSignature(commit_id, feature_name, expected_sig);
	}
	
	@Test
	public void BRCMFMAC_SDIO_OOB () throws Exception
	{
		/**
		 * Update of a condition around #if/else block
		 * I should find a new condition around existing code - with just one line of code.
		 */
		String commit_id = "668761ac01d6f5a36b8e5a24d4e154550e2c4c3b";
		String feature_name  = "BRCMFMAC_SDIO_OOB";
		
		int[] expected_sig = {0,1,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0};
		
		Utils.testFeatureChangeSignature(commit_id, feature_name, expected_sig);
	}

	@Test
	public void FIREWIRE_OHCI_REMOTE_DMA () throws Exception
	{
		/**
		 * Update of a condition around #if/else block
		 * I should find a new condition around existing code - with just one line of code.
		 */
		String commit_id = "8bc588e0e585bc9085df75e84d4d5635f45cf360";
		String feature_name  = "FIREWIRE_OHCI_REMOTE_DMA";
		
		int[] expected_sig = {0,1,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0};
		
		Utils.testFeatureChangeSignature(commit_id, feature_name, expected_sig);
	}
	

	
	@Test
	public void CAVIUM_OCTEON_SOC () throws Exception
	{
		/**
		 * issue with multiple targets of different types
		 */
		String commit_id = "9ddebc46e70b434e485060f7c1b53c5b848a6c8c";
		String feature_name  = "CAVIUM_OCTEON_SOC";
		
		int[] expected_sig = {1,0,1,0,1,0,1,0,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0};
		
		Utils.testFeatureChangeSignature(commit_id, feature_name, expected_sig);
	}
	

	
	//
	@Test
	public void CRYPTO_BLOWFISH_AVX2_X86_64 () throws Exception
	{
		/**
		 * case with alias. 
		 */
		String commit_id = "3d387ef08c40382315b8e9baa4bc9a07f7c49fce";
		String feature_name  = "CRYPTO_BLOWFISH_AVX2_X86_64";
		
		int[] expected_sig = {0,1,1,0,1,0,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0};
		
		Utils.testFeatureChangeSignature(commit_id, feature_name, expected_sig);
	}
	
	
	@Test
	public void DRM_I915_PRELIMINARY_HW_SUPPORT () throws Exception
	{
		/**
		 * Update of a condition around #if/else block
		 * I should find a new condition around existing code - with just one line of code.
		 */
		String commit_id = "99486b8e6140da7721c932e708a6c17dc1dd970a";
		String feature_name  = "DRM_I915_PRELIMINARY_HW_SUPPORT";
		
		int[] expected_sig = {1,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0};
		
		Utils.testFeatureChangeSignature(commit_id, feature_name, expected_sig);
	}
	
	@Test
	public void P_FS_SECURITY () throws Exception
	{
		/**
		 * Update of a condition around #if/else block
		 * I should find a new condition around existing code - with just one line of code.
		 */
		String commit_id = "d9a738597faf7cd2edeec82ce8fd81969fed8390";
		String feature_name  = "9P_FS_SECURITY";
		
		int[] expected_sig = {1,0,1,0,1,0,1,0,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0};
		
		Utils.testFeatureChangeSignature(commit_id, feature_name, expected_sig);
	}
	
	//
	@Test
	public void ADT7410 () throws Exception
	{
		/**
		 * Update of a condition around #if/else block
		 * I should find a new condition around existing code - with just one line of code.
		 */
		String commit_id = "cddc1424f39e7c04045a6431eaf13a003fb8335a";
		String feature_name  = "ADT7410";
		
		int[] expected_sig = {0,1,1,0,1,0,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0};
		
		Utils.testFeatureChangeSignature(commit_id, feature_name, expected_sig);
	}
	/// Test mapping update 
	
	
	@Test
	public void ARM_SA1110_CPUFREQ () throws Exception
	{
		/**
		 * Update of a condition around #if/else block
		 * I should find a new condition around existing code - with just one line of code.
		 */
		String commit_id = "59a2e613d07fbd592ff711c87458eabcf9c98902";
		String feature_name  = "ARM_SA1110_CPUFREQ";
		
		int[] expected_sig = {1,0,1,0,0,1,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0};
		
		Utils.testFeatureChangeSignature(commit_id, feature_name, expected_sig);
	}
	
	
	
	@Test
	public void HAVE_UNDERSCORE_SYMBOL_PREFIX() throws Exception
	{
		/**
		 * Checking possible discrepency between differ's output.
		 */
		String commit_id = "b92021b09df70c1609e3547f3d6128dd560be97f";
		String feature_name  = "HAVE_UNDERSCORE_SYMBOL_PREFIX";
		
		int[] expected_sig = {1,0,1,0,0,1,1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0};
		
		Utils.testFeatureChangeSignature(commit_id, feature_name, expected_sig);
	}
	
	@Test
	public void Nb_FeatureEdit_Should_Be_One() throws Exception
	{
		/**
		 * Checking possible discrepency between differ's output.
		 */
		String commit_id = "7e01799c669c60460dce43556065ca3b66760dcf";
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add(commit_id);
		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
		boolean hit = false;
		for(FeatureOrientedChange c : changes)
		{
			if(c.f_name.equals("ARCH_HIGHBANK"))
			{
				hit = true;
			}
		}
		assertTrue(hit);
	}
	
//	@Test 
//	public void test_why_ref_edit () throws Exception
//	{
//		
//		/**
//		 * Checking possible discrepency between differ's output.
//		 */
//		String commit_id = "ab5d140b9eafae402aa3e673a63c5ef6164a9dd2";
//		CommitInfoExtractor s = new CommitInfoExtractor(); 
//		List<String> ids = new ArrayList<String>(); 
//		ids.add(commit_id);
//		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
//		boolean hit = false;
//		for(FeatureOrientedChange c : changes)
//		{
//			if(c.f_name.equals("ARCH_HIGHBANK"))
//			{
//				hit = true;
//			}
//		}
//		assertTrue(hit);
//	}
	
	//creating empty nodes for source edits ? Wth ? 
	@Test 
	public void test_crash_time_line_creation () throws Exception
	{
		String commit_id = "24aa07882b672fff2da2f5c955759f0bd13d32d5";
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add(commit_id);
		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
		boolean hit = false;
		for(FeatureOrientedChange c : changes)
		{
			if(c.f_name.equals("ARCH_HIGHBANK"))
			{
				hit = true;
			}
		}
		assertTrue(hit);
	}
	
	
	@Test 
	public void test_TCP_CONG_CUBIC_Shouldnt_be_touched () throws Exception
	{
		String commit_id = "b872a2371ffd13e6d83423ef621a707df4c158ac";
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add(commit_id);
		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
		boolean hit = false;
		for(FeatureOrientedChange c : changes)
		{
			if(c.f_name.equals("TCP_CONG_CUBIC") || c.f_name.equals("DEFAULT_TCP_CONG"))
			{
				hit = true;
			}
		}
		assertTrue(!hit);
	}
	//35fd0808d7
	
	@Test 
	public void test_HID_APPLE_Shouldnt_be_touched () throws Exception
	{
		String commit_id = "d66c266ad40e92a5c24fd0c5bbcf08c04ae41b6c";
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add(commit_id);
		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
		boolean hit = false;
		for(FeatureOrientedChange c : changes)
		{
			if(c.f_name.equals("HID_APPLE"))
			{
				hit = true;
			}
		}
		assertTrue(!hit);
	}
	//0ee332c145
	
	@Test
	public void test_no_modified_Features_here() throws Exception
	{
		String commit_id = "0ee332c1451869963626bf9cac88f165a90990e1";
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add(commit_id);
		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
		boolean hit = false;
		for(FeatureOrientedChange c : changes)
		{
			if(c.f_name.equals("HID_APPLE"))
			{
				hit = true;
			}
		}
		assertTrue(!hit);
	}

	@Test
	public void moved_features_are_supposed_to_be_modified() throws Exception
	{
		String commit_id = "3b1588593097b7d71f44c4b7b435bf28924316e0";
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add(commit_id);
		boolean hit = false;
		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
		for(FeatureOrientedChange c : changes)
		{
			if(c.f_name.equals("NET_DSA_MV88E6131"))
			{
				assertTrue(c.f_change == ChangeType.MODIFIED);
				hit =true;
			}
		}
		assertTrue(hit);
	}
	
	@Test
	public void simple_edit() throws Exception
	{
		
		
		
		
		String commit_id = "67435319866f89b55721fc88ca0dbda51629e3d6";
		fever.graph.Main.extractSingleCommit(commit_id);
//		CommitInfoExtractor s = new CommitInfoExtractor(); 
//		List<String> ids = new ArrayList<String>(); 
//		ids.add(commit_id);
//		boolean hit = false;
//		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
//		for(FeatureOrientedChange c : changes)
//		{
//			if(c.f_name.equals("NET_DSA_MV88E6131"))
//			{
//				assertTrue(c.f_change == ChangeType.MODIFIED);
//				hit =true;
//			}
//		}
//		assertTrue(hit);
	}
}

