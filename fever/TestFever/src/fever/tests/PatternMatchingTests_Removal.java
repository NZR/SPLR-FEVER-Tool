package fever.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fever.change.PatternMatcher.patterns;
import fever.parsers.CommitInfoExtractor;

public class PatternMatchingTests_Removal {

	@Test
	public void RVOMF() throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("323a59613e5be6094c93261486de48a08d3a53f2"); 
		
		String feature = "SND_SA11XX_UDA1341";
		patterns p = patterns.RVOMF;
		
		PatternMatchingTests.searchForAndClose(s, ids, feature, p);
	}
	
	
	@Test
	public void RVOGMF() throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("03cf152646ac177c56e3100732143e92278b0630"); 
		
		String feature = "SND_INTEL_SST";
		patterns p = patterns.RVOGMF;
		
		PatternMatchingTests.searchForAndClose(s, ids, feature, p);
	}
	
	
	@Test
	public void RVONMF() throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("028c5a432aec0eb8cbb65b2ea05cd1ddd27c47a4"); 
		
		String feature = "FB_OMAP_092M9R";
		patterns p = patterns.RVONMF;
		
		PatternMatchingTests.searchForAndClose(s, ids, feature, p);
	}
	
	@Test
	public void RVOAF() throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("f860b0522f65d3a0f8e6a4d908933737e1a82817"); 
		
		String feature = "NETDEV_10000";
		patterns p = patterns.RVOAF;
		
		PatternMatchingTests.searchForAndClose(s, ids, feature, p);
	}
	
	@Test
	public void RVMVF() throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("af2bf4b4ee58d262a9a5c1d4ce6f81835058f8b5"); 
		
		String feature = "AR600x_DEBUG_UART_TX_PIN";
		patterns p = patterns.RVMVF;
		
		PatternMatchingTests.searchForAndClose(s, ids, feature, p);
	}
	
	@Test
	public void RIMF() throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("8eb26942ae6eea7976273e554ab7c4fb2a128e17"); 
		
		String feature = "FB_MSM_TVOUT";
		patterns p = patterns.RIMF;
		
		PatternMatchingTests.searchForAndClose(s, ids, feature, p);
	}
	
	@Test
	public void RCINMF() throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("b0006e69615868f3dfdfe2bd64eb11973f1208fc"); 
		
		String feature = "AR9170_LEDS";
		patterns p = patterns.RCINMF;
		
		PatternMatchingTests.searchForAndClose(s, ids, feature, p);
	}
	
	@Test
	public void MVOFNO() throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("5b2e303f6df1e0b1a903950c5d613a20c8c71a37"); 
		
		String feature = "INPUT_WINBOND_CIR";
		patterns p = patterns.MVOFNO;
		
		PatternMatchingTests.searchForAndClose(s, ids, feature, p);
	}
	
	@Test
	public void MVOFS() throws Exception
	{
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add("5e7ea11f603a0aeb77fd1bff0b242931ffe139de"); 
		
		String feature = "HID_QUANTA";
		patterns p = patterns.MVOFS;
		
		PatternMatchingTests.searchForAndClose(s, ids, feature, p);
	}
}
