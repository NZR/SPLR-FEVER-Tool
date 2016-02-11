package fever.parsers.featuremodel;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.emf.common.util.EList;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import models.Choice;
import models.DefaultValue;
import models.Feature;
import models.ModelsFactory;
import models.Select;
import models.VariabilityModel;
import models.VariabilityModelEntity;
import models.VariabilityTypes;


public class FeatureModelBuilder {
	
	
	
	VariabilityModel vm = null;
	
	Map<String,String> feature_id_mapping = new HashMap<String,String>();
	Map<String,String> id_feature_mapping = new HashMap<String,String>();
	
	public FeatureModelBuilder()
	{

		
		vm = ModelsFactory.eINSTANCE.createVariabilityModel();
	}
	
	
	public VariabilityModel buildEmptyModel()
	{
		return ModelsFactory.eINSTANCE.createVariabilityModel();
	}
	
	@SuppressWarnings("finally")
	public VariabilityModel buildModelFromFile(File f) throws Exception
	{
		DocumentBuilder docBuilder = null;
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		docBuilderFactory.setValidating(false);
		docBuilderFactory.setCoalescing(true);//CDATA handling

		try
		{
			
			docBuilder = docBuilderFactory.newDocumentBuilder();
		}
		catch(Exception e)
		{
			throw new Exception("Can't instantiate doc - no XML loaded just yet. Check configuration.",e);
		}
		
		Document doc = null;
		try
		{
			doc = docBuilder.parse(f);
			
			NodeList children = doc.getChildNodes();
			for(int i = 0; i < children.getLength(); i++)
			{
				Node c = children.item(i);
				String name = c.getNodeName();
				if("submenu".equalsIgnoreCase(name) || "menu".equalsIgnoreCase(name))
				{
					extractNodeInfo(c);
				}
			}
			
			for(VariabilityModelEntity vme : vm.getFeatures())
			{
				resolveAlias(vme);
			}
		}
		catch(Exception e)
		{
			//throw new Exception("Parsing of the file failed - check path &  content " + f.getAbsolutePath(),e);
			System.err.println("Parsing of the file failed - check path &  content " + f.getAbsolutePath() + 
					"\n producing an empty feature model for this one (might be perfectly valid)");
			
		}
		finally
		{
			return vm; //can be empty but not null;
		}
	
	}

	
	
	
	private void resolveAlias(VariabilityModelEntity vme)
	{
		resolveIdsForDefVals(vme);
		resolveIdsForSelects(vme);
		
		String dep = vme.getDepends();
		if(containsIds(dep))
		{
			vme.setDepends(replaceIds(dep));
		}
		String pc = vme.getPresenceCondition();
		if(containsIds(pc))
		{
			vme.setPresenceCondition(replaceIds(pc));
		}
		String prc = vme.getPromptCondition();
		if(containsIds(prc))
		{
			vme.setPromptCondition(replaceIds(prc));
		}
	}

	private void resolveIdsForSelects(VariabilityModelEntity vme) {
		EList<Select> sels = vme.getSelects();
		for(Select s: sels)
		{
			String c = s.getCondition();
			if(containsIds(c))
			{
				s.setCondition(replaceIds(c));
			}
			String t = s.getTarget();
			if(containsIds(t))
			{
				s.setTarget(replaceIds(t));
				s.setId(replaceIds(s.getId()));
			}
		}
	}

	private boolean containsIds(String t) {
		return t != null && t.length() != 0 && t.contains("S@");
	}

	private void resolveIdsForDefVals(VariabilityModelEntity vme) {
		EList<DefaultValue> defvals = vme.getDefaultValues();
		for(DefaultValue df : defvals)
		{
			String c = df.getCondition();
			if(containsIds(c))
			{
				df.setCondition(replaceIds(c));
			}
			String v = df.getValue();
			if(containsIds(v))
			{
				df.setValue(replaceIds(v));
				df.setId(replaceIds(df.getId()));
			}
		}
	}

	private static final String idsRE    = "S@-?\\d*" ;
    private static Pattern idsREPattern ;
    
    static {
    	idsREPattern    = Pattern.compile(idsRE) ;
    }
    
	private String replaceIds(String value)
	{
		Matcher m = idsREPattern.matcher(value);
		Map<String,String> replace = new HashMap<String,String>();
		while (m.find())
		{
			int idx1 = m.start();
			int idx2 = m.end();

			String g = value.substring(idx1, idx2);
			String f = id_feature_mapping.get(g);
			if(f != null )
				replace.put(g, f);
			else
				replace.put(g,"__UNRESOLVED_REFERENCE__");
		}

		for(String k : replace.keySet())
		{
			String v = replace.get(k);
			if(v!= null)
				value = value.replace(k, v);
		}
		
		return value;
	}
	
	
	private void extractNodeInfo(Node c) throws Exception 
	{
		String nodeName = c.getNodeName();
		
		if("submenu".equalsIgnoreCase( nodeName ) )
		{	//we skip this. As far as I know, submenus are just here to structure the XML file.
			NodeList list = c.getChildNodes();
			for(int i = 0 ; i < list.getLength() ; i ++)
			{	
				if("\n".equals(list.item(i).getNodeValue())) //dead line checks
					continue;
				
				extractNodeInfo(list.item(i));
			}
		}
		else if ("menu".equalsIgnoreCase(nodeName))
		{			
			boolean feat = isFeature(c);
			if(feat)
			{
				Feature myFeature = null;
				myFeature = ModelsFactory.eINSTANCE.createFeature();	
				
				extractFeatureInfo(myFeature,c);

				Feature existing_node = alreadyExists(myFeature);
				
				if(existing_node == null)
					vm.getFeatures().add(myFeature);
			}
			else
			{
				Choice choice = ModelsFactory.eINSTANCE.createChoice();
				vm.getFeatures().add(choice);
			}
		}
	}


	private Feature alreadyExists(Feature myFeature) {
		Feature existing_node = null;
		for(VariabilityModelEntity existing_f : vm.getFeatures())
		{
			
			if(existing_f instanceof models.Choice)
				continue;
			
			Feature exsting_feature = (Feature) existing_f;
			if(exsting_feature.getName().equals(myFeature.getName()))
			{
				existing_node = (Feature) existing_f;
			}
				
		}
		return existing_node;
	}

	private void extractFeatureInfo(Feature f, Node c) throws Exception 
	{
		
		NodeList list = c.getChildNodes();
		for(int i = 0 ; i < list.getLength() ; i ++)
		{
			Node n = list.item(i);
			String nodeName = n.getNodeName();
			if("symbol".equals(nodeName))
			{
				extractSymbolInfo(f, n);
			}
			else if ("dep".equals(nodeName)) 
			{
				f.setDepends(n.getTextContent());
			}
		}
	}

	private void extractSymbolInfo(Feature f, Node n) throws Exception 
	{
		
		extractSymbolAttributes(f, n);

		//extract sub nodes
		NodeList children = n.getChildNodes();
		int default_counter = 0;
		for(int j = 0; j < children.getLength() ; j ++)
		{
			Node child = children.item(j);
			if("\n".equals(child.getNodeValue())) //dead line checks
				continue;
			
			String nodeName = child.getNodeName();
			
			if(nodeName.equals("name"))
			{
				f.setName(child.getTextContent());
			}
			else if (nodeName.equals("property"))
			{
				String propType = child.getAttributes().getNamedItem("type").getNodeValue();

				
				if(propType.equals("?"))
				{
					extractIds(f, child);
				}
				else if(propType.equals("select"))
				{
					extractSelect(f,child);
				}
				else if(propType.equals("default"))
				{
					extractDefault(f,child, default_counter);
					default_counter ++; 
				}
				else if (propType.equalsIgnoreCase("choice"))
				{
					//continue : this is not applicable for feature. 
					// here we would get the parent choice ID - redundant with the content of the Choice object.
				}
				else if (propType.equalsIgnoreCase("menu")  || propType.equalsIgnoreCase("prompt") )
				{
					extractPrompt(f,child);
				}
				else
				{
					//DEBUG: find missing attribute by uncommenting this line: System.err.println("new type of node? " + propType);
				}
			}
		}
	}

	
	private void extractPrompt(Feature f, Node n) 
	{
		NodeList props = n.getChildNodes();
		String value = props.item(0).getTextContent();
		String condition = "";
		if(props.getLength() == 2)
		{
			condition = props.item(1).getChildNodes().item(0).getTextContent();
		}

		f.setPrompt(value);
		f.setPromptCondition(condition);
	}

	private void extractDefault(Feature f, Node n, int index)
	{
		NodeList props = n.getChildNodes();
		DefaultValue dv = ModelsFactory.eINSTANCE.createDefaultValue();
		String value = props.item(0).getTextContent();
		String condition = "";
		if(props.getLength() == 2)
			condition = props.item(1).getChildNodes().item(0).getTextContent();

		dv.setCondition(condition);
		//dv.setOrder(index);
		dv.setValue(value);
		dv.setId(f.getName()+"_"+value);
		
		boolean hit = false;
		for(DefaultValue existing_dv: f.getDefaultValues())
		{
			if(existing_dv.getValue().equals(value))
			{
				existing_dv.setCondition(existing_dv.getCondition() + " || "+ condition);
				hit = true;
			}
		}

		if(!hit)
			f.getDefaultValues().add(dv);
	}
	/**
	 * Extract info from a "select" property XML node and stores the info as a
	 * new Select object attached to the feature f.
	 * @param f
	 * @param child
	 */
	private void extractSelect(Feature f, Node n) {
		
		NodeList props = n.getChildNodes();
		Select s = ModelsFactory.eINSTANCE.createSelect();
		f.getSelects().add(s);
		String target = props.item(0).getTextContent();
		String condition = "";
		if(props.getLength() == 2)
			props.item(1).getChildNodes().item(0).getTextContent();
		
		s.setCondition(condition);
		s.setTarget(target);
		s.setId(f.getName()+"_"+target);
	}

	/**
	 * Extract attributes from the Symbol XML node "n" and stores the information into the 
	 * feature "f"
	 * @param f
	 * @param n
	 */
	private void extractSymbolAttributes(Feature f, Node n) {
		String t = n.getAttributes().getNamedItem("type").getNodeValue();
		setFeatureType(f, t);

		String id = n.getAttributes().getNamedItem("id").getNodeValue();
		f.setId(id);
	}
	
	/**
	 * Adds an entry into the feature/id mapping table.
	 * (used to resolve IDs and identify external features).
	 * @param feature_name
	 * @param feature_id
	 */
	private void add_mapping_entry(String feature_name, String feature_id)
	{
			feature_id_mapping.put(feature_name, feature_id);
			id_feature_mapping.put(feature_id, feature_name);
	}

	
	/**
	 * Extract Ids information from a "menu" XML Node "n" and stores the information 
	 * into feature "f". 
	 * 
	 * 
	 * @param f
	 * @param n
	 * @throws Exception if XML parsing fails.
	 */
	private void extractIds(Feature f, Node n) throws Exception {
		NodeList l = n.getChildNodes();
		
		String fid = "";
		String presence = "";
		
		switch (l.getLength())
		{
			case (1) :
				fid = l.item(_id).getTextContent();
				break;
			case (2):
				fid = l.item(_id).getTextContent();
				presence = l.item(_presence_idx).getChildNodes().item(0).getTextContent();
				break;
			default:
				throw new Exception(_msg_id_extract);
		}
		
		f.setId(fid);		
		f.setPresenceCondition(presence);
		add_mapping_entry(f.getName(),fid);
	}

	/**
	 * Assign the feature type to the feature.
	 * Note: the actual type of the feature is not stored as a String. Hence the method.
	 * 
	 * @param f
	 * @param t
	 */
	private void setFeatureType(Feature f, String t) {
		if(t.equals("boolean"))
			f.setType(VariabilityTypes.BOOLEAN);
		else if (t.equalsIgnoreCase("tristate"))
			f.setType(VariabilityTypes.TRISTATE);
		else if (t.equalsIgnoreCase("int") || t.equalsIgnoreCase("integer"))
			f.setType(VariabilityTypes.INT);
		else if (t.equalsIgnoreCase("hex"))
			f.setType(VariabilityTypes.HEX);
		else if (t.equalsIgnoreCase("string"))
			f.setType(VariabilityTypes.STRING);
	}

	/**
	 * Given a "menu" XML Node, isFeature returns true if the menu qualifies as a feature: i.e. not a choice or an unamed menu.
	 * @param c
	 * @return
	 */
	private boolean isFeature(Node c) {
		
		
		Node SymNode  =c.getChildNodes().item(1);
		if(SymNode==null || SymNode.getNodeName() != "symbol")
		{
			return false;
		}
		String n = SymNode.getChildNodes().item(1).getNodeName();
		if("name".equals(n))
			return true;
		else
			return false;
	}

	private static final int _id = 0; //index of the first id in the "?" prop
	private static final int _presence_idx = 1; //index of the presence condition in the "?" structure.
	private static final String _msg_id_extract = "? property contains a weird number of field. Was expecting: "
			+ "<expr> FEATURE ID </expr>"
			+ "<visible><expr> FEATURE_EXPR WITH IDS </expr></visible>";
}
