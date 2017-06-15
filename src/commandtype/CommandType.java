/**
 * Aufgabenblatt 2
 * Aufgaben 
 * Bearbeitungsdauer: nicht messbar
 * Bemerkungen:
 * keine
 *
 * @author Haslach & Kircher
 * @version 1.0
 */ 

package commandtype;

import command.Command;

public class CommandType {
	private String name;

	public CommandType(String myName){
		this.name = myName;
	}
	
	public Command createInstance(String myName){
		
		return null;		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String myName) {
		this.name = myName;
	}
	
}
