package fever.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fever.change.FeatureOrientedChange;
import fever.change.FeatureOrientedChange.Optionality;
import models.ChangeType;
import models.CodeEdit;
import models.CompilationTargetType;
import models.ConditionalBlock;
import models.DefaultValue;
import models.Feature;
import models.VariabilityTypes;

public class ParsingUtils {
	
	static Pattern pattern = Pattern.compile("(([^a-zA-Z_]CONFIG_[0-9a-zA-Z_\\-]+))",Pattern.MULTILINE);
	
	public static boolean isAdd(ChangeType op)
	{
		
		if(op.equals(ChangeType.ADDED) || op.equals(ChangeType.ADDED_VALUE))
			return true;
		else return false;
	}
	

	public static  boolean isRemove(ChangeType op)
	{
		if(op.equals(ChangeType.REMOVED) || op.equals(ChangeType.REMOVED_VALUE))
			return true;
		else return false;		
	}
	
	public static boolean isModified(ChangeType op)
	{
		if(op.equals(ChangeType.MODIFIED) || op.equals(ChangeType.MODIFIED_VALUE) || op.equals(ChangeType.MOVED))
			return true;
		else return false;
	}
	
	
	public static List<String> getFeatureNames(String line)
	{
		
		Matcher matcher = pattern.matcher(line);
		List<String> feat_names = new LinkedList<String>();
		
		while(matcher.find())
		{
			//System.out.println(matcher.group(idx));
			String g = matcher.group(1);
			if (null != g)
			{
				g = g.substring(g.indexOf("CONFIG_")); 
				if ( g.startsWith("CONFIG_") && !feat_names.contains(g))
					feat_names.add(g);
			}
		}
		
		
		List<String> sanitized = new ArrayList<String>();
		for(String s : feat_names)
		{
			sanitized.add( s.replace("CONFIG_", "") );
		}
		return sanitized;
	}
	
	
	public static boolean isCompilationFlag(String l)
	{
		if(l.indexOf("-l") != -1)
			return true;
		if(l.indexOf("-W") != -1)
			return true;
		if(l.indexOf("-D") != -1)
			return true;
		if(l.indexOf("cc-option") != -1)
			return true;
		if(l.indexOf("cc-flag") != -1)
			return true;
		if(l.startsWith("-f"))
			return true;
		if(l.startsWith("-pg"))
			return true;
		
		if(!isSourceFile(l) && !isBuildFile(l))
			return true; //serious hack... that's not very good.
		
		return false;
		
	}
	
	static public boolean isSourceFile(String fileName)
	{
		if(fileName.indexOf(".c") != -1|| fileName.indexOf(".h") != -1 
				||  fileName.indexOf(".S") != -1|| fileName.indexOf (".s") != -1 
				|| fileName.indexOf (".dts") != -1 || fileName.indexOf (".dtb") != -1)
			return true;
		else 
			return false;
	}
	
	
	static public boolean isBuildFile(String fileName)
	{
		if(fileName.indexOf("Makefile") != -1 || fileName.indexOf("Kbuild")  != -1 || fileName.indexOf("Platform") != -1)
		{
			return true;
		}
		else
			return false;
	}
	
	
	
	static public boolean isVariabilityFile(String fileName)
	{
		if(fileName.contains("Kconfig"))
			return true;
		else
			return false;
	}
	
	
	static public boolean fileMatchCompilationUnit(String file_name, String cu_name)
	{
		
		try{
			String f = file_name.substring(file_name.lastIndexOf("/")+1, file_name.lastIndexOf(".")-1);
			String c = cu_name.substring(0, cu_name.lastIndexOf(".")-1);
			if(f.equalsIgnoreCase(c))
				return true;
			else
			{
				if(f.endsWith(c))
					return true;
				else if (c.endsWith(f))
					return true;
				else
					return false;
			}
							
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	static public CompilationTargetType getMappedType(String target)
	{
		CompilationTargetType type = null;
		 if(target.endsWith(".o"))
		 {
			 type = CompilationTargetType.COMPILATION_UNIT;
		 }
		 else if (target.endsWith("/"))
		 {
			 type = CompilationTargetType.FOLDER;
		 }
		 else if (ParsingUtils.isCompilationFlag(target))
		 {
			 type = CompilationTargetType.CC_FLAG;
		 }
		 return type;
	}
	
	
	static public boolean isFeatureOptional(Feature f)
	{
		boolean isOpt = false;
		
			VariabilityTypes t = f.getType();
			if( t == VariabilityTypes.TRISTATE || t == VariabilityTypes.BOOLEAN)
			{
				isOpt = true;
			}
			else
			{
				isOpt = false;
			}
			return isOpt;
	}

	static public boolean isFeatureVisible(Feature f)
	{
		boolean visible =  false;
		if(f.getPrompt() == null || "".equals(f.getPrompt()))
		{
			visible = false;
		}
		else
			visible = true;
		
		return visible;
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
	
	
	public static boolean codeInNewBlockFullyAddedByEdit(ConditionalBlock cb, CodeEdit ce)
	{
		int start_add = ce.getAdd_idx();
		int stop_add = start_add + ce.getAdd_size();
		
		if(stop_add < cb.getStart() || start_add > cb.getEnd())
			return false; //edit ends before the blocks starts, or start after the block is finished
		
		if(start_add <= (cb.getStart()+1) && stop_add >= (cb.getEnd()-1))
		{	//the edit starts before the first line of code in the blocks and ends after the last line of code of the block
			return true;
		}
		return false;
	}
	
	
	

	public static boolean EditInsideBlock(ConditionalBlock cb, CodeEdit ce)
	{
		//this is where i make it happen.
		
		
		if(cb.getStart() < ce.getAdd_idx() && cb.getEnd() > ce.getAdd_idx() || 
				cb.getStart() < ce.getRem_idx() && cb.getEnd() > ce.getRem_idx())
			return true;
		else
		return false;
	}
	
	
	public static boolean codeInNewBlockEditedByEdit(ConditionalBlock cb, CodeEdit ce)
	{
		int start_add = ce.getAdd_idx();
		int stop_add = ce.getAdd_idx() + ce.getAdd_size() -1;
		if(ce.getAdd_size()!=0)
		{
			//Added fragments
			if( start_add > (cb.getStart()+1) && stop_add < (cb.getEnd() -1) )
			{	//edit fully contained in block 
				return true;
			}
			
			if(start_add < (cb.getStart()+1) && stop_add >= (cb.getStart()+1))
			{	//starts before the block and ends after the start.
				return true;
			}
			
			if(start_add > (cb.getStart()+1) && start_add < (cb.getEnd()-1))
			{	//starts in the block.
				return true;
			}
		}
		int start_rem = ce.getAdd_idx(); //we are actually dealing with new blocks. The indices we get are in the new file format.
		int end_rem = start_rem + ce.getRem_size();
		if(ce.getRem_size() != 0)
		{
			//Removed fragments
			if( start_rem > (cb.getStart()+1) && end_rem < (cb.getEnd() -1) )
			{	//edit fully contained in block 
				return true;
			}
			
			if(start_rem < (cb.getStart()+1) && end_rem > (cb.getStart()+1))
			{	//starts before the block and ends after the start.
				return true;
			}
			
			if(start_rem > (cb.getStart()+1) && start_rem < (cb.getEnd()-1))
			{	//starts in the block.
				return true;
			}
		}
		
		return false;
	}
	
	///
	public static boolean codeInRemovedBlockFullyRemovedByEdit(ConditionalBlock cb, CodeEdit ce)
	{
		int start_rem = ce.getRem_idx();
		int stop_rem = start_rem + ce.getRem_size();
		
		if(stop_rem < cb.getStart() || start_rem > cb.getEnd())
			return false; //edit ends before the blocks starts, or start after the block is finished
		
		if(start_rem <= (cb.getStart()+1) && stop_rem >= (cb.getEnd()-1))
		{	//the edit starts before the first line of code in the blocks and ends after the last line of code of the block
			return true;
		}
		return false;
	}
	
	public static boolean codeInRemovedBlockEditedByEdit(ConditionalBlock cb, CodeEdit ce)
	{
		int start_rem = ce.getRem_idx();
		//DEBUG int stop_rem = ce.getRem_idx() + ce.getAdd_size() -1;
		int stop_rem = ce.getRem_idx() + ce.getRem_size() -1;
		if(ce.getRem_size()!=0)
		{
			//Added fragments
			if( start_rem > (cb.getStart()+1) && stop_rem < (cb.getEnd() -1) )
			{	//edit fully contained in block 
				return true;
			}
			
			if(start_rem < (cb.getStart()+1) && stop_rem >= (cb.getStart()+1))
			{	//starts before the block and ends after the start.
				return true;
			}
			
			if(start_rem > (cb.getStart()+1) && start_rem < (cb.getEnd()-1))
			{	//starts in the block.
				return true;
			}
		}
		
//		int start_add = ce.getRem_idx(); //we are actually dealing with new blocks. The indices we get are in the new file format.
//		int end_add = 0;
//		
//		if(isSingleIfDefAddition(ce))
//		{
//			end_add = start_rem + ce.getRem_size();
//		}
//		else
//		{
//			end_add = start_rem + ce.getRem_size()+ ce.getAdd_size();
//		}
//		
//			//note: index + removed (cause that's what the diff starts with) + added.
//		if(ce.getAdd_size() != 0)
//		{
//			//Removed fragments
//			if( start_add > (cb.getStart()+1) && end_add < (cb.getEnd() -1) )
//			{	//edit fully contained in block 
//				return true;
//			}
//			
//			if(start_add < (cb.getStart()+1) && end_add > (cb.getStart()+1))
//			{	//starts before the block and ends after the start.
//				return true;
//			}
//			
//			if(start_add > (cb.getStart()+1) && start_add < (cb.getEnd()-1))
//			{	//starts in the block.
//				return true;
//			}
//		}
//		
		return false;
		
	}

	public static Vector<Integer> toVector(int[] array)
	{
		Vector<Integer> v = new Vector<Integer>();
		for(int i : array)
			v.add(i);
		return v;
	}
	
	
	private static boolean isSingleIfDefAddition(CodeEdit ce)
	{
		if(ce.getAdd_size() != 1)
			return false;
		
		String diff = ce.getDiff();
		String[] diff_lines = diff.split("\\n");
		
		String added = diff_lines[diff_lines.length - 1];
		if(added.contains("#if"))
			return true;
		
		return false;
	}


	public static boolean touchesIfDefs(String diff)
	{
		if(diff.contains("#if"))
			return true;
		else
			return false;
	}
}
