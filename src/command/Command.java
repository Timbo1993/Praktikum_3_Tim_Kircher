package command;
import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 * 
 * @author Tim Kircher
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
	
	@Override
	public String getName(){
		return name;
	}
		
}
