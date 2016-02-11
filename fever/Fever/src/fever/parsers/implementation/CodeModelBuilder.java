package fever.parsers.implementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;

import fever.change.CompositeDiff;
import fever.utils.ParsingUtils;
import models.ConditionalBlock;
import models.ImplementationLine;
import models.ImplementationModel;
import models.ModelsFactory;
import models.ReferencedValueFeature;

public class CodeModelBuilder {


	
	private ImplementationModel im = null;
	public CodeModelBuilder()
	{
		im = ModelsFactory.eINSTANCE.createImplementationModel();
	}

	public ImplementationModel buildModelFromFile(File code, File results, CompositeDiff d) throws Exception 
	{
		
		String key = "";
		if(code.getName().contains("old"))
		{
			key = "_old_";
		}
		else 
		{
			key = "_new_";
		}
		
		extractBlocks(key, results, code, d);
		
		return im;

	}

	private void extractBlocks(String key, File results, File code, CompositeDiff d) throws Exception 
	{

		createBlocks(key, results);

		BufferedReader reader = new BufferedReader(new FileReader(code));
		String  l = reader.readLine();
		int idx = 1;
		while(l != null)
		{
			l = l.trim();
			
			if(l.length() == 0 ) 
			{
				idx ++;
				l = reader.readLine();
				continue;
			}
			
			while(l.endsWith("\\"))
			{
				String tmp = reader.readLine();
				idx ++;
				if(tmp != null)
				{
					l = (l.substring(0,l.length()-1) + tmp); 
				}
			}
			
			if(l.indexOf("#else") == -1 && l.indexOf("# if") == -1 && l.indexOf("#if") == -1 && l.indexOf("#elif") == -1 && l.indexOf("#ifndef") == -1 && l.indexOf("#endif") == -1 
					&& l.indexOf("# endif") == -1
					&&!l.startsWith("//") &&!l.startsWith("/*") &&!l.startsWith("*")
					&& !(l.indexOf("IS_ENABLED") != -1 && l.contains("#") ) 
					&& !l.endsWith("\\")) //avoiding feature in #ifdef 
			{
				List<String> names = ParsingUtils.getFeatureNames(l);
				if(names.size() != 0)
				{
					for(String n : names)
					{
						addRefToModel(n,idx);
					}
				}	
			}
			
			addLineToBlocks(l,idx);
			
			idx ++;
			l = reader.readLine();
		}
		reader.close();
	}

	private void createBlocks(String key, File results) throws FileNotFoundException, IOException
	{
		BufferedReader reader = new BufferedReader( new FileReader(results));
		String l = reader.readLine();
		
		List<ConditionalBlock> blocks = new ArrayList<ConditionalBlock>();
		while(l != null)
		{
			String[] args = l.split(",");//expecting a CSV file as input.
			if  ( args.length < 5 )
			{
				l = reader.readLine();
				continue;
			}
			else
			{
				if(args[0] != null && args[0].contains(key))
				{
					ConditionalBlock cb =  ModelsFactory.eINSTANCE.createConditionalBlock();
					cb.setCondition( args[4].trim());
					cb.setStart( Integer.valueOf(args[1].trim()));
					cb.setEnd(Integer.valueOf(args[2].trim()));
					cb.setExpression(args[3].trim());
					
					blocks.add(cb);
				}
			}
			l = reader.readLine();
		}
		reader.close();

		im.getBlocks().addAll(blocks);
	}
	
	
	
	private void addLineToBlocks(String l, int idx)
	{
		EList<ConditionalBlock> blocks = im.getBlocks();
		ImplementationLine line_model = ModelsFactory.eINSTANCE.createImplementationLine();
		line_model.setLine(l);
		
		if(blocks.size() == 0 )
		{
			return;
		}
		
		
		for(ConditionalBlock b : blocks)
		{
			if(b.getStart() < idx && b.getEnd() > idx )
			{
				b.getLines().add(line_model);
			}
		}
	}

	private void addRefToModel(String f_name, int idx)
	{
		
		EList<ConditionalBlock> blocks = im.getBlocks();

		ReferencedValueFeature ref = ModelsFactory.eINSTANCE.createReferencedValueFeature();
		ref.setName(f_name);
		
		if(blocks.size() == 0)
		{
			for(ReferencedValueFeature referenced_value : im.getValueFeatures())
			{
				if(referenced_value.getName().equals(f_name))
					return;
			}
			im.getValueFeatures().add(ref);
			return ;
		}
		else
		{
			for(ConditionalBlock b : blocks)
			{
				if( idx >= b.getStart() &&  idx <= b.getEnd())
				{
					for(ReferencedValueFeature ref_feat : b.getValueFeatures())
						if(ref_feat.getName().equalsIgnoreCase(f_name))
							return;
					
					b.getValueFeatures().add(ref);
					return;
				}
			}
			for(ReferencedValueFeature referenced_value : im.getValueFeatures())
			{
				if(referenced_value.getName().equals(f_name))
					return;
			}
			im.getValueFeatures().add(ref);//if we reach this point, we couldn't find a suitable block, might as well add it to the file model.
		}
	}
	
}
