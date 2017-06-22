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

import java.io.File;
import java.util.Vector;
import command.Command;
import commandlist.CommandList;
import commandtype.CommandType;
import hsrt.mec.controldeveloper.io.IOType;
import hsrt.mec.controldeveloper.io.TextFile;

public class ControlModel{
	
	private static ControlModel instance = null;
	private CommandType[] commandTypes = new CommandType[4];
	private CommandList controlProcess = new CommandList();
	
	
	private ControlModel(){
	}
	
	public static ControlModel getInstance(){
		if (instance == null){
			instance = new ControlModel();
		}
		return instance;
	}
	
	public void createCommandTypes(){
		commandTypes[0] = new CommandType("Direction");
		commandTypes[1] = new CommandType("Gear");
		commandTypes[2] = new CommandType("Repetition");
		commandTypes[3] = new CommandType("Pause");
	}
	
	public boolean load(File f){
		Vector data = new Vector();
		TextFile txt = new TextFile(f, false);
		boolean success = txt.read(data);
		txt.close();
		int i = 0;
		while(data.get(i) != "end"){
			
			i++;
		}
		return success;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean save(File f){
		TextFile txt = new TextFile(f, false);
		Vector data = new Vector();
		boolean success = false;
		int i = 0;
		
		while (controlProcess.get(i) != null){	

			if (controlProcess.get(i).getName() == "Direction"){
				data.add(controlProcess.get(i).toString());	
			}
			else if (controlProcess.get(i).getName() == "Gear"){
				data.add(controlProcess.get(i).toString());
			}
			
			else if (controlProcess.get(i).getName() == "Repetition"){
				data.add(controlProcess.get(i).toString());
			}
			
			else if (controlProcess.get(i).getName() == "Pause"){
				data.add(controlProcess.get(i).toString());
			}
			else{
				return false;
			}
			i++;
		}
		data.add("end");
		success = txt.write(data);
		txt.close();
		return success;
	}
	
	public void commandPerformed(Command com){
		
	}
	
	public CommandList getControlProcess(){
//		if (){
//			
//		}
		return controlProcess;
	}
	
}

