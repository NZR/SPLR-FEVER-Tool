package fever.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fever.change.FeatureOrientedChange;
import fever.change.PatternMatcher.patterns;
import fever.parsers.CommitInfoExtractor;

public class PatternMatchingTests {

	
	@Test
	public void AVOMF () throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		
		List<String> ids = new ArrayList<String>(); 
		ids.add("3cadd2d98972f806165c634553ac4918b2b7920c"); //easy modular feature addition on Linux.
		
		String feature = "TOUCHSCREEN_INEXIO";
		patterns p = patterns.AVOMF;
		
		searchForAndClose(s, ids, feature, p);
	}
	
	
	@Test
	public void avogmf() throws Exception 
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("91da11f870f00a3322b81c73042291d7f0be5a17"); //easy modular feature addition on Linux.
		
		String feature = "NET_DSA";
		patterns p = patterns.AVOGMF;
		
		searchForAndClose(s, ids, feature, p);
	}
	
	@Test
	public void AVONMF() throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("06b3db1b9bccdc8c2c743122a89745279e5ecc46"); //easy modular feature addition on Linux.
		
		String feature = "FSCACHE_DEBUG";
		patterns p = patterns.AVONMF;
		
		searchForAndClose(s, ids, feature, p);
	}
	
	@Test 
	public void AVONMCFF_1() throws Exception
	{	
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("366d19e181be873c70f4aafca3931d77d781ccd7");
		
		String feature = "MATOM";
		patterns p = patterns.AVONMCFF;
		
		searchForAndClose(s, ids, feature, p);
	}
	
	
	@Test 
	public void AVONMCFF_3() throws Exception
	{	
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("30295c8936f3a426985e99bebb17d72bd7847910");
		
		String feature = "AR600x_DUAL_ANTENNA";
		patterns p = patterns.AVONMCFF;
		
		searchForAndClose(s, ids, feature, p);
	}

	
	
	@Test
	public void AVMVF() throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("6b7d8f8b5c43f7bedda750d8a9dab0658da1d2ba"); //easy modular feature addition on Linux.
		
		String feature = "SERIAL_ALTERA_UART_MAXPORTS";
		patterns p = patterns.AVMVF;
		
		searchForAndClose(s, ids, feature, p);
	}
	
	
	@Test
	public void AIMF() throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 		
		List<String> ids = new ArrayList<String>(); 
		ids.add("c93993aca45a223452d2a95383b655c85878c6e8"); //easy modular feature addition on Linux.
		
		String feature = "SND_SOC_WM8915";
		patterns p = patterns.AIMF;
		
		searchForAndClose(s, ids, feature, p);
	}

	@Test
	public void fcutof() throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("347ec4e47dd249c0620f429d8458fc42eed63e0e"); //easy modular feature addition on Linux.

		String feature = "GPIO_S5PV210";
		patterns p = patterns.FCUTVOF;
		
		searchForAndClose(s, ids, feature, p);
	}
	
	public void RENAME() throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("3bece55aa5356af0171aaa64fd9c4f7601c47f1c"); 

		String feature = "PINMUX_SIRF";
		patterns p = patterns.RENAME;

		searchForAndClose(s, ids, feature, p);
	}
	
	
	@Test
	public void AVOCFF() throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("72246da40f3719af3bfd104a2365b32537c27d83"); 
		
		String feature = "USB_DWC3_VERBOSE";
		patterns p = patterns.AVOCFF;
		
		searchForAndClose(s, ids, feature, p);
	}
	
	static public void searchForAndClose(CommitInfoExtractor s, List<String> ids,
			String feature, patterns p) throws Exception {
		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
		
		boolean found = false;
		for(FeatureOrientedChange c : changes)
		{
			if(c.f_name.equals(feature))
			{
				//assertTrue(c.matched_patterns.size() == 1);
				assertTrue(c.matched_patterns.contains(p));
				found = true;
			}
		}
		
		assertTrue(found);
		s.closeRepo();
		System.gc();
	}

}
