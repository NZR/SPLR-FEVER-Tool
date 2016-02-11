package fever.graph.model.TimeLine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fever.parsers.build.BuildScriptBuilder;
import fever.utils.ParsingUtils;
import models.BuildModel;

public class MappingGenerator
{
	
	static List<String> file_names = new ArrayList<String>(); 
	static List<String> makefiles_to_parse = new ArrayList<String>();
	static List<String> virtual_features = new ArrayList<String>();
	
	static Map<String,List<String>> feature_file_mapping = new HashMap<String,List<String>>();
	
	static String repo_p = "/Users/Dante/Documents/workspace/git/linux/linux/";
	
	  public static void main(String[] args) throws Exception {
		    Path p = Paths.get(repo_p);
		    FileVisitor<Path> fv = new SimpleFileVisitor<Path>() {
		      @Override
		      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
		          throws IOException {
		    	  file_names.add(file.toString().replace(repo_p, ""));
		        
		    	  if(ParsingUtils.isBuildFile(file.getFileName().toString()))
		    	  {
		    		  makefiles_to_parse.add(file.toString());
		    	  }
		    	  
		    	  System.out.println(file.toString().replace(repo_p, ""));
		        return FileVisitResult.CONTINUE;
		      }
		    };

		    try {
		      Files.walkFileTree(p, fv);
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  
	  
		  extractBuildMapping();
		  
		  resolveVirtualMappings();
		  
		  File f = new File("mapping_out.txt");
		  f.createNewFile();
		  
		  BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		  
		  for(String f_name : feature_file_mapping.keySet())
		  {
			  bw.append(f_name+" :: ");
			  for(String s : feature_file_mapping.get(f_name))
			  {
				  bw.append(s + "=");  
			  }
			  bw.append("\n");
			  bw.flush();
		  }
		  bw.flush();
		  bw.close();
	  }

	private static void resolveVirtualMappings()
	{
		for(String vf : virtual_features)
		{
			String folder_name = vf.replace("VIRTUAL_FEATURE_", "");
			folder_name+="/";
			for(String feature :feature_file_mapping.keySet() )
			{
				if(feature.startsWith("VIRTUAL"))
					continue;
				
				List<String> targets = feature_file_mapping.get(feature);
				boolean got_it = false;
				for(String t : targets)
				{
					if ( t.equals(folder_name))
					{
						got_it = true;
					}
				}
				if(got_it)
				{
					feature_file_mapping.get(feature).addAll(feature_file_mapping.get(vf));
					break; //only one guard feature per folder. Hopefully.
				}
			}
		}
		
		for(String vf : virtual_features)
		{
			feature_file_mapping.remove(vf);
		}
		
	}

	private static void extractBuildMapping() throws Exception
	{
		for(String make_file_path: makefiles_to_parse)
		  {
			  File file = new File(make_file_path);
			  
			  String make_file_folder = file.getAbsolutePath().replace(repo_p, "");
			  if(make_file_folder.contains("/"))
				  make_file_folder = make_file_folder.substring(0,make_file_folder.lastIndexOf("/"));
			  
			  BuildScriptBuilder m = new BuildScriptBuilder();
			  m.buildModelFromFile(new File(make_file_path),make_file_path);
			  
			  for(String symbol : m.raw_mapping.keySet())
			  {
				  List<String> feature_names = ParsingUtils.getFeatureNames(symbol);
				  if(!feature_names.isEmpty())
				  {
					  extractFeatureMapping(make_file_folder, m, symbol, feature_names);
				  }
				  else if (symbol.equals("obj-y"))
				  {
					  String virtual_symbol = "VIRTUAL_FEATURE_"+make_file_folder;
					  
					  if(!virtual_features.contains(virtual_symbol))
						  virtual_features.add(virtual_symbol);
					  
					  List<String> virtual_features = new ArrayList<String>();
					  virtual_features.add(virtual_symbol);
					  extractFeatureMapping(make_file_folder, m, symbol, virtual_features);
				  }
			  }
		  }
	}

	private static void extractFeatureMapping(String make_file_folder, BuildScriptBuilder m, String symbol, List<String> feature_names)
	{
		List<String> targets = m.raw_mapping.get(symbol);
		  List<String> targeted_files = new ArrayList<String>();
		  for(String s : targets)
		  {
			  if(s.endsWith(".o")) //obj file, compilation unit, I should find a file associated with it.
			  {
				  String potential_file = s.substring(0,s.lastIndexOf("."));
				  potential_file = make_file_folder+"/"+ potential_file;
				  for(String f_name : file_names)
				  {
					  if(!f_name.contains("."))
						  continue;
					  
					  if(f_name.substring(0,f_name.lastIndexOf(".")).equals(potential_file))
					  {
						  targeted_files.add(f_name);
					  }
				  }
			  }
			  else if (s.endsWith("/"))
			  {
				  targeted_files.add(make_file_folder+"/"+s);
			  }
		  }
		  for(String feature : feature_names)
		  {
			  if(feature_file_mapping.containsKey(feature))
			  {
				  feature_file_mapping.get(feature).addAll(targeted_files);
			  }
			  else
			  {
				  feature_file_mapping.put(feature, targeted_files);
			  }
		  }
	}
}

