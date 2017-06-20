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
import command.Direction;
import command.Gear;
import command.Pause;
import command.Repetition;

public class CommandType {
	private String name;

	public CommandType(String myName){
		this.name = myName;
	}
	
	public Command createInstance(){
		switch(this.getName()){
		
		case "Direction":
			Direction instDir = new Direction(0);
			return instDir;
			
		case "Gear":
			Gear instGear = new Gear(0, 0);
			return instGear;
			
		case "Pause":
			Pause instPause = new Pause(0);
			return instPause;
			
		case "Repetition":
			Repetition instRep = new Repetition(0, 0);
			return instRep;
			
		default:
			return null;		
	
		}
	}
	
	public String getName() {
		return name;
	}

//	public void setName(String myName) {
//		this.name = myName;
//	}
	
}
