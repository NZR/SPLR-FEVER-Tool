package fever.tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fever.change.FeatureOrientedChange;
import fever.parsers.CommitInfoExtractor;

public class DiffCleanerTest {
	
	@Test
	public void cleanDiffLines() throws Exception
	{
		
		String input = "diff --git a/drivers/infiniband/core/uverbs.h b/drivers/infiniband/core/uverbs.h\n"+
						"index 24adccb..bdc842e 100644\n"+
						"--- a/drivers/infiniband/core/uverbs.h\n"+
						"+++ b/drivers/infiniband/core/uverbs.h\n"+
						"@@ -245,2 +244,0 @@\n"+
						"-#ifdef CONFIG_INFINIBAND_EXPERIMENTAL_UVERBS_FLOW_STEERING\n"+
						"-\n"+
						"@@ -254,2 +251,0 @@\n"+
						"-\n"+
						"-#endif /* CONFIG_INFINIBAND_EXPERIMENTAL_UVERBS_FLOW_STEERING */\n";
		
		
		
		
		String[] lines = input.split("\n");
		
		
		for(int i = 0 ; i < lines.length ; i ++)
		{
			System.out.println(lines[i]);
			if(lines[i].startsWith("@@"))
			{	//chunk start
				
				String[] ranges = lines[i].split(" ");
				String range_remove = ranges[1]; 
				int rem_start = Integer.valueOf(range_remove.split(",")[0]);
				rem_start = rem_start * -1;
				int rem_size = Integer.valueOf(range_remove.split(",")[1]);
				
				String range_add = ranges[2];
				int add_start = Integer.valueOf(range_add.split(",")[0]);
				int add_size = Integer.valueOf(range_add.split(",")[1]);
				
				
				int j = i+1; 
				List<String> chunk_added_lines = new ArrayList<String>();
				List<String> chunk_removed_lines = new ArrayList<String>();
				
				
				
				while(j < lines.length && !lines[j].startsWith("@@") )
				{
					if(lines[j].startsWith("+"))
						chunk_added_lines.add(lines[j]);
					if(lines[j].startsWith("-"))
						chunk_removed_lines.add(lines[j]);
					j++;
				}
				
				//fix ranges and starting point.
				
				for(int idx = 0 ; idx < chunk_removed_lines.size() ; idx++)
				{
					if(chunk_removed_lines.get(idx).trim().length()!= 1)
						break;
					else
						rem_start++;
				}
				
				for(int idx = chunk_removed_lines.size() -1 ; idx > 0 ; idx--)
				{
					if(chunk_removed_lines.get(idx).trim().length()!= 1)
						break;
					else
						rem_size--;
				}
				
				
				for(int idx = 0 ; idx < chunk_added_lines.size() ; idx++)
				{
					if(chunk_added_lines.get(idx).trim().length()!= 1)
						break;
					else
						add_start++;
				}
				
				for(int idx = chunk_added_lines.size() -1 ; idx > 0 ; idx--)
				{
					if(chunk_added_lines.get(idx).trim().length()!= 1)
						break;
					else
						add_size--;
				}
				
				i = j-1;
			}
		}
	}
}
