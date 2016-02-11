package fever.change;

import models.ChangeType;
import models.ConditionalBlock;

public class ImplFragmentChange 
{
	
	public ConditionalBlock old_b = null;
	public ConditionalBlock new_b = null;

	public String i_target; /*condition of the block(s)*/
	
	public String _file_name = "";
	
	public ChangeType i_refs_change  = null;		/*changes to value-feature references inside the implementation change*/
	public ChangeType i_interaction_change = null;	/*changes to condition around the code, usually is added or removed */
	public ChangeType i_behavior_change = null;		/*changes to implementation within the block*/
	
	public boolean i_fully_edited = false;			//behavior change details
	public boolean i_partially_edited =false;		//behavior change details
	public boolean i_not_edited =false;				//behavior change details
	
	public String diff = "";
	
}
