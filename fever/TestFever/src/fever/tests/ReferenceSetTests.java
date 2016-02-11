package fever.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fever.change.PatternMatcher.patterns;
import fever.parsers.CommitInfoExtractor;

/**
 * This class contains tests that are specific to the evaluation of the tool using the reference
 * set. 
 * 
 * In here, the commit used for test are part of the set. Those where miss classified at least once
 * by the tool. 
 * 
 * @author Dante
 *
 */
public class ReferenceSetTests {

	
	@Test
	public void VIDEO_V4L1_COMPAT () throws Exception
	{
		
		
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		
		List<String> ids = new ArrayList<String>(); 
		ids.add("08af245de0cf6ab5f4ed008ee2bb99273774fce0"); //easy modular feature addition on Linux.
		
		String feature = "VIDEO_V4L1_COMPAT";
		patterns p = patterns.RVOMF;
		
		PatternMatchingTests.searchForAndClose(s, ids, feature, p);
		
	}
	
	
	@Test
	public void SND_AT32_SOC_PLAYPAQ () throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		
		List<String> ids = new ArrayList<String>(); 
		ids.add("9aaca9683b014c4d718f32cbddb42e5b36ea3c0f"); //easy modular feature addition on Linux.
		
		String feature = "SND_AT32_SOC_PLAYPAQ";
		patterns p = patterns.AVOMF;
		
		PatternMatchingTests.searchForAndClose(s, ids, feature, p);
	}
	
	@Test
	public void ME1600 () throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		
		List<String> ids = new ArrayList<String>(); 
		ids.add("3fedd14818592016f7ffd84dfe134881b3896ecf"); //easy modular feature addition on Linux.
		
		String feature = "ME1600";
		patterns p = patterns.AVOMF;
		
		PatternMatchingTests.searchForAndClose(s, ids, feature, p);
	}
	
	//
	
	@Test
	public void LEDS_MC13783 () throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		
		List<String> ids = new ArrayList<String>(); 
		ids.add("7fdcef8a414eaeb367b3696005b25283d62d195d"); //easy modular feature addition on Linux.
		
		String feature = "LEDS_MC13783";
		patterns p = patterns.AVOMF;
		
		PatternMatchingTests.searchForAndClose(s, ids, feature, p);
	}
	

	@Test
	public void VIDEO_ADP1653 () throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		
		List<String> ids = new ArrayList<String>(); 
		ids.add("13abadad177074b84f6697639e1d4f64a55b1773"); //easy modular feature addition on Linux.
		
		String feature = "VIDEO_ADP1653";
		patterns p = patterns.AVOMF;
		
		PatternMatchingTests.searchForAndClose(s, ids, feature, p);
	}
	
	//
	
	
	@Test
	public void DRM_PSB_MRST () throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		
		List<String> ids = new ArrayList<String>(); 
		ids.add("0bbfa259ac9f678e3f3d1a7eb7f51d14840c6851"); //easy modular feature addition on Linux.
		
		String feature = "DRM_PSB_MRST";
		patterns p = patterns.FCUTVOF;
		
		PatternMatchingTests.searchForAndClose(s, ids, feature, p);
	}
	
	//9701dc94a14e54a33c3c99744ec3a761f6385fc6

	@Test
	public void VIDEO_TM6000 () throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		
		List<String> ids = new ArrayList<String>(); 
		ids.add("9701dc94a14e54a33c3c99744ec3a761f6385fc6"); //easy modular feature addition on Linux.
		
		String feature = "VIDEO_TM6000";
		patterns p = patterns.AVOMF;
		
		PatternMatchingTests.searchForAndClose(s, ids, feature, p);
	}

	
	@Test
	public void SND_AT91_SOC_ETI_SLAVE () throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		
		List<String> ids = new ArrayList<String>(); 
		ids.add("5cabc1a8b3acc4babd69f2c91a6ab4468dac6663"); //easy modular feature addition on Linux.
		
		String feature = "SND_AT91_SOC_ETI_SLAVE";
		patterns p = patterns.RVONMF;
		PatternMatchingTests.searchForAndClose(s, ids, feature, p);
	}
	
	//
	@Test
	public void X86_GOOD_APIC () throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		
		List<String> ids = new ArrayList<String>(); 
		ids.add("593f4a788e5d09e9f00182561437461b0b564de4"); //easy modular feature addition on Linux.
		
		String feature = "SND_AT91_SOC_ETI_SLAVE";
		patterns p = patterns.RVONMF;
		PatternMatchingTests.searchForAndClose(s, ids, feature, p);
	}
	
	@Test
	public void I2C_VOODOO3 () throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		
		List<String> ids = new ArrayList<String>(); 
		ids.add("a0c11cdd6a1975fd8d6d186f2e2865a82f3e9bbf"); //easy modular feature addition on Linux.
		
		String feature = "I2C_VOODOO3";
		patterns p = patterns.RVONMF;
		PatternMatchingTests.searchForAndClose(s, ids, feature, p);
	}
	
	//,JUMP_LABEL,
	@Test
	public void JUMP_LABEL () throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		
		List<String> ids = new ArrayList<String>(); 
		ids.add("45f81b1c96d9793e47ce925d257ea693ce0b193e"); //easy modular feature addition on Linux.
		
		String feature = "JUMP_LABEL";
		patterns p = patterns.AVONMCFF;
		PatternMatchingTests.searchForAndClose(s, ids, feature, p);
	}
}
