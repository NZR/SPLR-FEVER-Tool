package fevers.linux;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import fever.change.FeatureOrientedChange;
import fever.parsers.CommitInfoExtractor;

public class ReferenceSetEvaluator_Addition_RelSpecific {

	public static void main(String[] args) throws Exception{
		
		File file = new File("err_additions_release_specifics.txt");
		if(file.exists())
			file.delete();
		file.createNewFile();
		
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setErr(ps);
		
		
		
		//File commitFile = new File("/Users/Dante/Documents/workspace/eclipse_workspaces/fevers/LinuxAnalyzer/src/resources/ref_additions_2.6.35.csv");
		
		File outputFile = new File("comparison_golden_set_addition_rel_spec.csv");
		if(outputFile.exists())
			outputFile.delete();
		
		boolean ok = outputFile.createNewFile();
		if(!ok)
			throw new Exception("can't open output file... this is useless");
		
		FileWriter writer = new FileWriter(outputFile);

		writer.append("commit,feature name, reference pattern, found pattern\n");

		String[] commits = 
			{
				
				"c6e3fd22cd538365bfeb82997d5b89562e077d42;SPEAKUP_SYNTH_DECTLK;AVOMF",	//v2.6.36		"depends on m"
				"c6e3fd22cd538365bfeb82997d5b89562e077d42;SPEAKUP_SYNTH_DTLK;AVOMF",	//v2.6.36		"depends on m"
				"8d77c036b57cf813d838f859e11b6a188acdb1fb;FTMAC100;AVOMF",				//v2.6.38		"&& m"
				"7d46d9e6dbffe8780aa8430a63543d3f7ba92860;KMEMCHECK_ENABLED_BY_DEFAULT;AVONMF", //v2.6.30 "&& m"
				"7d46d9e6dbffe8780aa8430a63543d3f7ba92860;KMEMCHECK_ONESHOT_BY_DEFAULT;AVONMF", //v2.6.30
				"f1d7dbbef51a624ff0ec76f022802d677fdb9888;COMEDI_ME_DAQ;FCUTOVF",		//v2.6.34	"depends on m"
				"f1d7dbbef51a624ff0ec76f022802d677fdb9888;COMEDI_ME4000;FCUTOVF",
				"f1d7dbbef51a624ff0ec76f022802d677fdb9888;COMEDI_PCL730;FCUTOVF",
				"f1d7dbbef51a624ff0ec76f022802d677fdb9888;COMEDI_S626;FCUTOVF",
				"f1d7dbbef51a624ff0ec76f022802d677fdb9888;COMEDI_SERIAL2002;FCUTOVF",
				"f1d7dbbef51a624ff0ec76f022802d677fdb9888;COMEDI_DAS6402;FCUTOVF",
				"eeb00c604ad203a51a0b92e124bcc4f98ba7e2c0;USB_GSPCA_PAC207;FCUTOVF",
				"eeb00c604ad203a51a0b92e124bcc4f98ba7e2c0;USB_GSPCA_STK014;FCUTOVF",
				"eeb00c604ad203a51a0b92e124bcc4f98ba7e2c0;USB_GSPCA_STK014;FCUTOVF",
				"3908c6902372206cc582ecf459af889b09a150c9;CAIF;AVOGMF",
				"126bb03b461c2f03f2d2a43b9a587941bf146e0e;USB_ENESTORAGE;AVOGMF",
				"85e09b40405b44b049500702beb6856646b4be46;RTL8192SE;AVOGMF",
				"1dac4186bcc663cb8c2bcc59481aea8fe9124a6c;RTS5139;AVOGMF",
				"13abadad177074b84f6697639e1d4f64a55b1773;VIDEO_ADP1653;AVOMF",
				"9bd060e492a2725c55404988ceed473a090bd04d;SOC_CAMERA_OV9740;AVOMF",
				"366d19e181be873c70f4aafca3931d77d781ccd7;MATOM;AVONMCFF",
				"45f81b1c96d9793e47ce925d257ea693ce0b193e;JUMP_LABEL;AVONMCFF",
				"30295c8936f3a426985e99bebb17d72bd7847910;AR600x_DUAL_ANTENNA;AVONMCFF"
			};
		
		
		
		for(int i = 0; i < commits.length ; i++)
		{
			String line = commits[i];
			System.out.println("extracting now line ("+i+") "+line);
			if(line!= null && !line.isEmpty())
			{
				extractCommit(line, writer);
			}
		}
		
		//reader.close();
		writer.close();
	}

	
	public static void extractCommit(String line, FileWriter writer) throws Exception
	{
		
		String[] infos = line.split(";");
		
		if(infos.length < 3)
			throw new Exception("Check the content of line : " + line);
		
		String feature_name = infos[1];
		String commit_id  = infos[0];
		String ref_pattern = infos[2];
		
		writer.append(commit_id+","+feature_name+","+ ref_pattern+",");
		
		CommitInfoExtractor s = new CommitInfoExtractor();
		try
		{
			System.err.println("---"+commit_id+"-"+feature_name);
			List<String> ids = new ArrayList<String>(); 
			ids.add(commit_id); //easy modular feature addition on Linux.
	
			List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
			
			for(FeatureOrientedChange c : changes)
			{
				if(c.f_name.equals(feature_name))
				{
					String p_output = "";
					
//					if(c.matched_patterns.size() >= 1)
//					{
//						for(int i = 0; i < c.matched_patterns.size() ; i++)
//						{
//							p_output += (c.matched_patterns.get(i));
//							if ( i + 1 < c.matched_patterns.size())
//								p_output+="|";
//						}
//					}
					if(c.matched_pattern.trim().length() != 0)
					{
						p_output = c.matched_pattern;
					}
					else
					{
						p_output = "-";
					}
					
					writer.append(p_output + ",");
				}
			}
			writer.flush();
			s.closeRepo();
		}
		catch(Exception e)
		{
			System.err.println("Failed to extract info from commit : "+line);	
		}
		finally
		{
			writer.append("\n");
			writer.flush();
			s.closeRepo();
		}

	}
}
