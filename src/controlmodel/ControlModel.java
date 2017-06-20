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

package controlmodel;

import command.Command;
import commandlist.CommandList;
import commandtype.CommandType;

public class ControlModel {
	
	private ControlModel instance;
	private CommandType[] commandTypes = new CommandType[4];
	private CommandList controlProcess;
	
	
	private ControlModel(){
	}
	
	public ControlModel getInstance(){
		return instance;
	}
	
	public void createCommandTypes(){
		commandTypes[0] = new CommandType("Direction");
		commandTypes[1] = new CommandType("Gear");
		commandTypes[2] = new CommandType("Repetition");
		commandTypes[3] = new CommandType("Pause");
	}
	
//	public boolean load(File f){
//		return null
//	}
//	
//	public boolean save(File f){
//		return null;
//	}
	
	public void commandPerformed(Command com){
		
	}
	
	public CommandList getControlProcess(){
		return controlProcess;
	}
	
}

