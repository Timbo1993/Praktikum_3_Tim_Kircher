/**
 * Aufgabenblatt 1
 * Aufgaben 1-4
 * Bearbeitungsdauer: nicht messbar
 * Bemerkungen:
 * keine
 *
 * @author Haslach & Kircher
 * @version 1.0
 */ 

package command;
import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 * 
 *Base class of all commands
 */

public abstract class Command implements ICommand{

	private String name;	
	
	
	/**
	 * Constructor
	 * 
	 * @param myName the name of the {@link Command} 
	 */
	public Command(String myName){
		if (myName == null){
			System.out.println("Name should not be null");
			this.name = "";
		}
		if(myName.isEmpty()){
			System.out.println("Name should not be empty!");
		}
		else{
			this.name = myName;
		}
	}
	
	/**
	 * 
	 * @param myName sets the name of the {@link Command}
	 */
	
	public void setName(String myName){
		this.name = myName;
	}
	/**
	 * Returns the content of the {@link Command}
	 */
	@Override
	public String getName(){
		return name;
	}
		
}
