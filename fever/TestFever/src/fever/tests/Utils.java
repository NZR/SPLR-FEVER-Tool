package fever.tests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import fever.change.FeatureOrientedChange;
import fever.parsers.CommitInfoExtractor;
import fever.utils.ParsingUtils;

public class Utils
{
	public static void testFeatureChangeSignature(String commit_id, String feature_name, int[] expected_change) throws Exception
	{
		
		
		CommitInfoExtractor s = new CommitInfoExtractor(); 
		List<String> ids = new ArrayList<String>(); 
		ids.add(commit_id);
		List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
		Vector<Integer> change_sig = ParsingUtils.toVector(expected_change);
		
		boolean found = false;
		for(FeatureOrientedChange c : changes)
		{
			if(c.f_name.equals(feature_name))
			{
				Vector<Integer> sig  = ParsingUtils.buildArrayFromFeatureChange(c);
				
				if(!sig.equals(change_sig))
				{
					dumpFeatureChangeIntoFile(commit_id, feature_name, c);
					System.err.println("Test failure: "+feature_name+" . Change signature not as expected");
					System.err.println("Expecting : " + toString(expected_change));
					System.err.println("Got       : " + sig);
				}
				assertTrue(sig.equals(change_sig));
				found = true;
			}
		}
		assertTrue(found);
		s.closeRepo();
	}

	public static String toString(int[] expected_change)
	{
		String val = "";
		for(int i : expected_change)
		{
			val += (i+", ");
		}
		val = val.substring(0, val.length() - 2);
		val = "["+val+"]";
		return val;
	}

	private static void dumpFeatureChangeIntoFile(String commit_id, String feature_name, FeatureOrientedChange c) throws Exception
	{
		File outputFile = new File("test_output_"+commit_id+"_"+feature_name);
		if(!outputFile.exists())
			outputFile.createNewFile();
		
		FileWriter writer = new FileWriter(outputFile);
		
		writer.append("TEST : " + feature_name + " - " + commit_id + "\n");
		writer.append(c.dumpChangeDetails());
		writer.close();
		
		
	}
}
