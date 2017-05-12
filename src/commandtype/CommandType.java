package commandtype;

import command.Command;

public class CommandType {
	private String name;

	public CommandType(){		
	}
	
	public Command createInstance(){
		return null;		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String myName) {
		this.name = myName;
	}
	
}
