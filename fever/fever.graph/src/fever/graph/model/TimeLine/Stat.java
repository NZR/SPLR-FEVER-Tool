package fever.graph.model.TimeLine;

import java.util.ArrayList;
import java.util.List;

public class Stat
{
	public String feature_name = ""; 
	public List<String> core_update_commits = new ArrayList<String>(); 
	public List<String> influence_update_commits = new ArrayList<String>();
	public List<String> full_update_commits = new ArrayList<String>();
	
	public int nb_vm_update = 0; 
	public int nb_mapping_update = 0; 
	public int nb_file_update = 0; 
	public int nb_interaction_update = 0;
	
	public boolean is_modular = false;
	
	public void print()
	{
		String r = getMessage();
		System.out.println(r);
	}
	public String getCSV()
	{
		StringBuffer msg = new StringBuffer(250);
		
		msg.append(feature_name + "," + is_modular + "," + nb_vm_update + "," + nb_mapping_update + "," + nb_file_update +  "," + nb_interaction_update + "," + core_update_commits.size() + "," + influence_update_commits.size() + "," + full_update_commits ); 
		
		
		return msg.toString();
	}
	
	
	public String getMessage()
	{
		StringBuffer msg = new StringBuffer(250);
		msg.append(" ========== \n");
		msg.append(" Feature : " + feature_name + "\n");
		msg.append(" Modular: " + is_modular);
		msg.append(" nb core update: " + core_update_commits.size() + "\n");
		msg.append(" nb influence update: " + influence_update_commits.size() + "\n");
		msg.append(" nb full update: " + full_update_commits.size() + "\n");
		msg.append(" nb vm update: " + nb_vm_update + "\n");
		msg.append(" nb mapping update: " + nb_mapping_update + "\n");
		msg.append(" nb file update: " + nb_file_update + "\n");
		msg.append(" nb interaction update: " + nb_interaction_update + "\n");
		msg.append(" ===== \n");
		msg.append(" core update in:  \n");
		for(String cm : core_update_commits)
		{
			msg.append("\t" +cm + "\n" );
		}
		msg.append(" influence update in:  \n");
		for(String cm : influence_update_commits)
		{
			msg.append("\t" +cm + "\n" );
		}
		msg.append(" full update in:  \n");
		for(String cm : full_update_commits)
		{
			msg.append("\t" +cm + "\n" );
		}
		msg.append(" ========== \n");
		return msg.toString();
		
	}
	
}
