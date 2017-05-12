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
		return null;
	}
	
	public void createCommandTypes(){
		
	}
	
//	public boolean load(File f){
//		return null
//	}
	
//	public boolean save(File f){
//		return null;
//	}
	
	public void commandPerformed(Command c){
		
	}
	
	public CommandList getControlProcess(){
		return null;
	}
	
}
