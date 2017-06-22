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
import command.Direction;
import command.Gear;
import command.Pause;
import command.Repetition;
import commandlist.CommandList;
import commandtype.CommandType;
import hsrt.mec.controldeveloper.io.IOType;
import hsrt.mec.controldeveloper.io.TextFile;

/**
 * Class for central management of the {@link CommandList} and the Array of {@link CommandType}s
 *
 */
public class ControlModel{
	
	private static ControlModel instance = null;
	private CommandType[] commandTypes = new CommandType[4];
	private CommandList controlProcess = new CommandList();
	
	/**
	 * Default constructor
	 */
	private ControlModel(){
	}
	
	/**
	 * Creates one instance of the {@link ControlModel} if there is none, grants access to the ControlModel
	 * @return {@link ControlModel} 
	 * returns the instance of ControlModel
	 */
	public static ControlModel getInstance(){
		if (instance == null){
			instance = new ControlModel();
		}
		return instance;
	}
	
	/**
	 * Fills the list of {@link CommandType}s with the 4 different types of {@link Command}s
	 */
	public void createCommandTypes(){
		commandTypes[0] = new CommandType("Direction");
		commandTypes[1] = new CommandType("Gear");
		commandTypes[2] = new CommandType("Repetition");
		commandTypes[3] = new CommandType("Pause");
	}
	
	/**
	 * @return the array with the {@link CommandType}s
	 */
	public CommandType[] getCommandTypes(){
		return commandTypes;
	}
	
	/**
	 * Loads the {@link Command}s from the given {@link File} and adds them to the {@link CommandList}
	 * @param f		File that shall be loaded
	 * @return		true if successfull
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean load(File f){
		controlProcess = new CommandList();
		Vector data = new Vector();
		TextFile txt = new TextFile(f, false);
		boolean success = txt.read(data);	//Speichert Inhalt der Textdatei im Vektor, jede Zeile ist ein "Inhalt des vektors"
		txt.close();
		int i = 0;		//Laufvariable für die Zeilen der Textdatei
		Command c = null;
		
		if(success == true){
			//Schleife geht den Vektor durch bis "end" kommt
			while(data.get(i).toString().equals("end") == false){
				
//				String s1 = data.get(i).toString();		//Eine 
//				String[] teile = s1.split("\\s");
				String[] teile = data.get(i).toString().split("\\s");	//teilt immer eine Zeile der Textdatei in bestandteile auf
				//if(teile[0] == "Direction:"){				// Warum nicht Möglich?
				
				//Schlüsselwort am Anfang wird abgefragt um das Command zu identifizieren
				//dann wird das identifizierte Command neu angelegt mit Werten aus der textdatei
				if(teile[0].equals("Direction:") == true ){
					c = new Direction(Integer.parseInt(teile[1]));
				}
				else if (teile[0].equals("Gear:") == true){
					c = new Gear(Integer.parseInt(teile[1]), Double.parseDouble(teile[3]));
				}
				else if (teile[0].equals("Repetition:") == true ){
					c = new Repetition(Integer.parseInt(teile[1]), Integer.parseInt(teile[3]));
				}
				else if (teile[0].equals("Pause:") == true){
					c = new Pause(Double.parseDouble(teile[1]));
				}
				controlProcess.add(c);	//das gerade erstellte Command wird der Liste hinzugefügt
				i++;
			}
		}
		else
			System.out.println("Error reading the File");
		return success;
	}
	
	/**
	 * saves the current {@link CommandList} in the stated file
	 * @param f		file in which the {@link CommandList} is saved
	 * @return		true if successfull
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean save(File f){
		TextFile txt = new TextFile(f, false);
		Vector data = new Vector();
		boolean success = false;
		int i = 0;
		
		while (controlProcess.get(i) != null){	
			data.add(controlProcess.get(i).toString());
//			if (controlProcess.get(i).getName() == "Direction"){
//				data.add(controlProcess.get(i).toString());	
//			}
//			else if (controlProcess.get(i).getName() == "Gear"){
//				data.add(controlProcess.get(i).toString());
//			}
//			
//			else if (controlProcess.get(i).getName() == "Repetition"){
//				data.add(controlProcess.get(i).toString());
//			}
//			
//			else if (controlProcess.get(i).getName() == "Pause"){
//				data.add(controlProcess.get(i).toString());
//			}
//			else{
//				return false;
//			}
			i++;
		}
		data.add("end");
		success = txt.write(data);
		txt.close();
		return success;
	}
	
	/**
	 * ???
	 * @param com
	 */
	public void commandPerformed(Command com){
		
	}
	
	/**
	 * used to gain access to the {@link CommandList}
	 * @return the instance of the {@link CommandList}
	 */
	public CommandList getControlProcess(){
//		if (){
//			
//		}
		return controlProcess;
	}
	
}

