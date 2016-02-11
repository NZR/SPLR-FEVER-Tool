package fever.parsers.build;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import models.BuildModel;
import models.CompilationTarget;
import models.CompilationTargetType;
import models.MakeSymbol;
import models.MappedFeature;
import models.ModelsFactory;
import fever.GitRepoFactory;
import fever.utils.ParsingUtils;



public class BuildScriptBuilder {
	
	public Map<String,List<String>> raw_mapping = new HashMap<String,List<String>>();

	List<CompilationTarget> _known_targets = new ArrayList<CompilationTarget>();
	
	public String _path= "";
	public String _folder = "";
	
	public BuildModel buildModelFromFile(File f, String filePath) throws Exception 
	{

		_path = f.getAbsolutePath();
		if(filePath.contains("/"))
			_folder = filePath.substring(0,filePath.lastIndexOf("/"));
		else
			_folder = filePath;
		String to_rem = GitRepoFactory.getRepo().getDirectory().getAbsolutePath().replace(".git", "");
		_folder = _folder.replace(to_rem, "");
		
		BufferedReader r = new BufferedReader(new FileReader(f));	
		fillRawMapping(r);
		r.close();
		
		try{
			resolveAliases();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage()  + " " + _folder );
		}

		BuildModel m = buildModel();

		return m;
	}

	private BuildModel buildModel() {
		BuildModel build_model = ModelsFactory.eINSTANCE.createBuildModel();
		
		for(String k : raw_mapping.keySet())
		{
			List<String> feats = ParsingUtils.getFeatureNames(k);
			if(feats.size() != 1)
			{
				String s_name = k.trim();
				
				MakeSymbol existing_symbol = getExistingSymbol(build_model,s_name);
				MakeSymbol symbol = null; 
				if(existing_symbol != null)
				{
					symbol = existing_symbol;
				}
				else 
				{
					symbol = ModelsFactory.eINSTANCE.createMakeSymbol();
				}
				
				symbol.setName(s_name);

				List<CompilationTarget> found_targets = new ArrayList<CompilationTarget>();
				extractTargets(k, "make_symbol_"+s_name, found_targets);
				symbol.getTargets().addAll(found_targets);

				if(symbol.getTargets().size() != 0)
					build_model.getSymbols().add(symbol);
			}
			else
			{
				String f_name = feats.get(0);
				
				//search for the feature in the already extracted ones  (just in case).
				MappedFeature existing_mf = getExistingFeat(build_model,f_name);
				MappedFeature mf = null; 
				if(existing_mf != null)
				{
					mf = existing_mf;
				}
				else 
				{
					mf = ModelsFactory.eINSTANCE.createMappedFeature(); 
				}
				
				///HERE Do something for obj-y, or default built target in the file. 
				/// map it to an alias linked to the file. 
				/// then you'll figure out how to deal with that.
				
				mf.setFeatureName(f_name);
				mf.setId(f_name);
				
				List<CompilationTarget> found_targets = new ArrayList<CompilationTarget>();
				
				extractTargets(k, f_name, found_targets);
				addTargetsToFeature(mf,found_targets);
				if(mf.getTargets().size() != 0)
				{
					build_model.getFeatures().add(mf);
				}
			}
		}
		return build_model;
	}

	
	private void addTargetsToFeature(MappedFeature mf, List<CompilationTarget> targetsToMerge)
	{
		for(CompilationTarget t: targetsToMerge)
		{
			boolean found = false;
			for(CompilationTarget existing_t : mf.getTargets())
			{
				if(t.getTargetName().equals(existing_t.getTargetName()) && (t.getMappedToSymbol().equals(existing_t.getMappedToSymbol())))
				{
					found = true;
				}
			}
			if (! found)
			{
				mf.getTargets().add(t);
			}
		}
		
	}
	
	
	private void extractTargets(String k, String f_name,List<CompilationTarget> found_targets) 
	{
		
		for(String t : raw_mapping.get(k))
		{
			
//			boolean exists = false;
//			for(CompilationTarget known_target : _known_targets)
//			{
//				if(known_target.getTargetName().equals(t))
//				{
//					found_targets.add(known_target);
//					exists = true;
//					break;
//				}
//			}
//			if(exists || t.isEmpty())
//				continue;
			
			 t = t.trim();
			 CompilationTarget target = ModelsFactory.eINSTANCE.createCompilationTarget();
			 
			 target.setMappedToSymbol(f_name);
		
			 CompilationTargetType type = null;
			 if(t.endsWith(".o") || t.endsWith(".dts") || t.endsWith(".dtb"))
			 {
				 type = CompilationTargetType.COMPILATION_UNIT;
			 }
			 else if (isFolderName(t) )
			 {
				 type = CompilationTargetType.FOLDER;
				 t = _folder+"/"+t;
			 }
			 else if (ParsingUtils.isCompilationFlag(t))
			 {
				 type = CompilationTargetType.CC_FLAG;
			 }
			 
			 target.setTargetName(t);
			 
			 if(type != null)
			 {
				 target.setTargetType(type);
				 target.setId(t);
				 found_targets.add(target);
				 _known_targets.add(target);
			 }
		}
	}
	
	private boolean isFolderName(String t)
	{
		if (t.endsWith("/"))
			return true;
		if (t.length() < 2 )
			return false;
		
		if(t.contains("(") || t.contains(")") || t.contains("0x")  )
			return false;
		if (t.endsWith("dtbs")) //ok - true hack here. This specific string is NOT a folder. And it's annoying me.
			return false;
					
		if(!t.contains(".") && !t.contains("-") && !t.contains("_"))
			return true;
			
		return false;
	}

	private MappedFeature getExistingFeat(BuildModel m, String f_name) 
	{
		
		for(MappedFeature f : m.getFeatures())
		{
			if(f.getFeatureName().equals(f_name))
				return f;
		}
		return null;
	}
	
	private MakeSymbol getExistingSymbol(BuildModel m, String s_name) 
	{
		for(MakeSymbol s : m.getSymbols())
		{
			if(s.getName().equals(s_name))
				return s;
		}
		return null;
	}

	private void resolveAliases() 
	{
		
		Map<String,List<String>> alias = new HashMap<String,List<String>>();
		
		for(String k : raw_mapping.keySet())
		{
			List<String> targets = raw_mapping.get(k);
			for(String t : targets)
			{
				if((t.indexOf(".o") == -1  &&  t.indexOf("$") == -1) || t.indexOf("/") != -1)
				{ //not a compilation unit name, nor a variable, let's carry on.
					continue;
				}
				String srch_str  = "";
				boolean isVar = false;
				if(t.indexOf(".o") != -1)
				{
					srch_str = t.substring(0, t.length() -2);
				}
				else if (t.indexOf("$") != -1)
				{
					isVar = true;
					t = t.replace("(","");t = t.replace(")","");t = t.replace("$","");
					srch_str = t;
				}
				
				for(String candidate : raw_mapping.keySet())
				{
					if(candidate.equals(k))
						continue;
					if(candidate.indexOf("CONFIG_") != -1)
						continue;
					
					String s = candidate;
					if(candidate.indexOf("-") != -1 && !isVar)
						s = candidate.substring(0, candidate.lastIndexOf("-"));
					
					if(srch_str.equals(s))
					{
						alias.put(candidate, raw_mapping.get(candidate));
					}
				}
			}
		}
		
	
		for(String s : alias.keySet())
		{
			String alias_key ; 
			if( s.indexOf("-") != -1 )
				alias_key = s.substring(0, s.lastIndexOf("-"));
			else 
				alias_key = s;
			
			for(String key : raw_mapping.keySet())
			{
				if(key.equals(s))
					continue;
				List<String> vals = raw_mapping.get(key);
				List<Integer> idx = new ArrayList<Integer>();
				for(String val : vals)
				{
					String checkVal = val;
					if(val.contains("."))
						checkVal = val.substring(0, val.indexOf("."));

					if(alias_key.equals(checkVal))
					{
						Integer a = vals.indexOf(val);
						idx.add(a);
					}
				}
				
				if(!idx.isEmpty())
				{
					for(Integer i : idx)
					{
						vals.remove(i.intValue());
					}
					vals.addAll(alias.get(s));
				}
			}
		}
		
		for(String s : alias.keySet())
		{
			raw_mapping.remove(s);
		}
	}

	private void fillRawMapping(BufferedReader r) throws Exception {
		String l;
		
		Stack<String> ifeq = new Stack<String>();
		
		while(null != ( l= r.readLine()))
		{
			l = l.trim();
			while(l.endsWith("\\"))
			{			//line continuation first.
				try{
					l = l.substring(0, l.lastIndexOf("\\"));
					l+= " ";
					String tmp = r.readLine();
					if(tmp != null)
					{
						l = l+tmp.trim();	
					}
				}
				catch(Exception e)
				{
					throw new Exception("error on line : "+  l, e);
				}
			}
			if(l.startsWith("#")) //commented lines skipped
				continue;
			if(l.trim().length() == 0)	//empty lines skipped
				continue;
			if(l.indexOf("#") != -1)
				l = l.substring(0, l.indexOf("#")); //removing end of line comments
						
			if(l.startsWith("ifeq") || l.startsWith("ifdef"))
			{
				ifeq.push(l);
			}
			
			if(l.startsWith("endif") && !ifeq.isEmpty())
			{
				ifeq.pop();
			}
			
			String equality = "";
			boolean isAssignment = false;
			
			if(l.indexOf(":=") != -1)
			{
				isAssignment = true;
				equality = ":=";
			}
			else if (l.indexOf("+=") != -1)
			{
				equality = "+="; 
				isAssignment = true;
			}
			else if (l.indexOf("-=") != -1)
			{
				equality = "-="; 
				isAssignment = true;
			}
			
			if(isAssignment)
			{
				String[]elems = l.split("\\"+equality); 
				if(elems.length != 2)
				{
					//System.err.println("skipping weird line : " + l);
					continue;
				}
				String left = elems[0].trim();
				String right = elems[1].trim(); 
				
				String[] targets = right.split("\\s+");
				List<String> target_list = new ArrayList<String>();
				for(int i = 0 ; i < targets.length; i++)
				{
					boolean a = false;
					String target = targets[i].trim();
					if(target.endsWith(".o") && target.startsWith("$(") )
						target = target.substring(target.indexOf(")")+1,target.length());
					
					target_list.add(target);
				}
				
				createMappingForSymbolPair(left, target_list);
				if(!ifeq.isEmpty())
				{
					for(String s : ifeq)
					{
						List<String> alt = new ArrayList<String>();
						alt.addAll(target_list);
						createMappingForSymbolPair(s, alt);
					}
				}
			}
		}
	}

	private List<String> createMappingForSymbolPair(String left, List<String> target_list) 
	{
		
		List<String> existing_mapping = raw_mapping.get(left);
		if(existing_mapping != null)
		{
				raw_mapping.get(left).addAll(target_list);
		}
		else
		{
			raw_mapping.put(left, target_list);
		}
		return existing_mapping;
	}

}
