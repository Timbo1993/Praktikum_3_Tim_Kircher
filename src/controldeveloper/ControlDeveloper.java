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

package controldeveloper;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import command.Command;
import command.Direction;
import command.Gear;
import command.Pause;
import command.Repetition;
import commandlist.CommandList;

// modifizierer static: methode kann aufgerufen werden,
// ohne dass davor ein objekt der Klasse erzeugt werden muss

/**
 * 
 *	Test Class to test {@link Command}s and {@link CommandList} methods
 */


public class ControlDeveloper {

	private static String name = "Control-Developer";
	static int counter = 4;
	static Command[] commands = new Command[counter];
	static CommandList commandList;

	public static void main(String[] args){
		JFrame mainFrame = new JFrame("Control-Developer");
		
		//menu
		ControlDeveloperMenuBar menu = new ControlDeveloperMenuBar(new ControlDeveloperView());
		mainFrame.setJMenuBar(menu);
		
		//prototypen
		String[] types = {"Direction","Gear","Repetition","Pause"};
		JList prototypeList = new JList(types);
		JScrollPane prototypeScroll = new JScrollPane(prototypeList, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mainFrame.add(prototypeScroll);
		
		//Programmablauf
		
		
		mainFrame.setSize( 700,500 );
		mainFrame.setVisible(true);

		
		
		
//		GridBagLayout gb = new GridBagLayout();
//		GridBagConstraints c = new GridBagConstraints();
//		
////		f.add(new JMenu(), c);
//		f.add(new JScrollPane(), c);
//		f.add(new JEditorPane(), c);
//		f.add(new JScrollPane(), c);
		
		
//		ControlDeveloperView	cdV = new ControlDeveloperView();
//		PrototypeScrollView		pSV	= new PrototypeScrollView(null);
//		
//		pSV.setVisible(true);
//		pSV.pack();
//		pSV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		cdV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		cdV.pack();
		

	}
	
	
	
	
	
	
	
/*	
//Main 	Blatt 2
	public static void main(String[] args) {
		ControlModel cm = ControlModel.getInstance();
		File f = new File("D:/beispiel.txt");

		testCommands();
		cm.getControlProcess().add(commands[0]);
		cm.getControlProcess().add(commands[1]);
		cm.getControlProcess().add(commands[2]);
		cm.getControlProcess().add(commands[3]);
		cm.save(f);		
		cm.getControlProcess().clearCommandList();
		cm.getControlProcess().printCommandList();
		cm.load(f);
		cm.getControlProcess().printCommandList();
		cm.getControlProcess().clearCommandList();
		
		
		cm.createCommandTypes();	
		
		cm.getControlProcess().add(cm.getCommandTypes()[0].createInstance());	//fügt eine Direction zur Liste hinzu
		((Direction) cm.getControlProcess().get(0)).setDegree(1);
		
		cm.getControlProcess().add(cm.getCommandTypes()[1].createInstance());	//fügt einen Gear zur Liste hinzu
		((Gear) cm.getControlProcess().get(1)).setSpeed(2);
		((Gear) cm.getControlProcess().get(1)).setDuration(3.4);
		
		cm.getControlProcess().add(cm.getCommandTypes()[2].createInstance());	//fügt eine Repetition zur Liste hinzu
		((Repetition) cm.getControlProcess().get(2)).setNrSteps(5);
		((Repetition) cm.getControlProcess().get(2)).setNrRepetitions(6);
		
		cm.getControlProcess().add(cm.getCommandTypes()[3].createInstance());	//fügt eine Pause zur Liste hinzu
		((Pause) cm.getControlProcess().get(3)).setDuration(7.8);
			
		cm.getControlProcess().add(commands[0]);

		
		cm.save(f);	
		cm.load(f);
		cm.getControlProcess().printCommandList();
	}
	
	
	{
// Main Blatt 1	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.println("Aufgabe 1:");
//		System.out.println(name);
//		System.out.println(getName());		
//		System.out.println("\n");
//		
//		System.out.println("Aufgabe 3:");
//		testCommands();
//		printCommands();
//		
//		System.out.println("\n");
//		System.out.println("Aufgabe 4: liste hinzufügen und ausgeben:");
//		commandList  = new CommandList();
//		commandList.add(commands[0]);
//		commandList.add(commands[1]);
//		commandList.add(commands[2]);
//		commandList.add(commands[3]);
//		commandList.printCommandList();		
//		System.out.println("\n");
//
//		//MoveDown
//		System.out.println("Aufgabe 4: moveDown [-1]");
//		commandList.moveDown(-1);		
//		commandList.printCommandList();		
//		System.out.println("\n");
//		
//		System.out.println("Aufgabe 4: moveDown[0] (erstes Element)");
//		commandList.moveDown(0);		
//		commandList.printCommandList();		
//		System.out.println("\n");
//		
//		System.out.println("Aufgabe 4: moveDown[2]");
//		commandList.moveDown(2);		
//		commandList.printCommandList();		
//		System.out.println("\n");
//		
//		System.out.println("Aufgabe 4: moveDown[3](letztes Element)");
//		commandList.moveDown(3);		
//		commandList.printCommandList();		
//		System.out.println("\n");
//		
//		System.out.println("Aufgabe 4: moveDown[7](element existiert nicht)");
//		commandList.moveDown(7);		
//		commandList.printCommandList();		
//		System.out.println("\n");
//		
//		//MoveUp
//		System.out.println("Aufgabe 4: moveUp [-1]");
//		commandList.moveUp(-1);		
//		commandList.printCommandList();		
//		System.out.println("\n");
//		
//		System.out.println("Aufgabe 4: moveUp[0] (erstes Element)");
//		commandList.moveUp(0);		
//		commandList.printCommandList();		
//		System.out.println("\n");
//		
//		System.out.println("Aufgabe 4: moveUp[2]");
//		commandList.moveUp(2);		
//		commandList.printCommandList();		
//		System.out.println("\n");
//		
//		System.out.println("Aufgabe 4: moveUp[3](letztes Element)");
//		commandList.moveUp(3);		
//		commandList.printCommandList();		
//		System.out.println("\n");
//		
//		System.out.println("Aufgabe 4: moveUp[7](element existiert nicht)");
//		commandList.moveUp(7);		
//		commandList.printCommandList();		
//		System.out.println("\n");
//		
//		//Remove
//		System.out.println("Aufgabe 4: Remove[-1](element existiert nicht)");
//		commandList.remove(-1);		
//		commandList.printCommandList();		
//		System.out.println("\n");
//
//		System.out.println("Aufgabe 4: Remove[0](erstes Element)");
//		commandList.remove(0);		
//		commandList.printCommandList();		
//		System.out.println("\n");
//		
//		System.out.println("Aufgabe 4: Remove[1](elementin der mitte)");
//		commandList.remove(1);		
//		commandList.printCommandList();		
//		System.out.println("\n");
//		
//		System.out.println("Aufgabe 4: Remove[1](element am ende)");
//		commandList.remove(1);		
//		commandList.printCommandList();		
//		System.out.println("\n");
//		
//		System.out.println("Aufgabe 4: Remove[2](element existiert nicht)");
//		commandList.remove(2);		
//		commandList.printCommandList();		
//		System.out.println("\n");
//	}
	}
	*/

	/**
	 * Returns the name of the {@link ControlDeveloper}
	 * @return name of the {@link ControlDeveloper}
	 */
	public static String getName() {
		return name;
	}

	/**
	 * Sets the name of the {@link ControlDeveloper}
	 * @param myName	name that is given to the {@link ControlDeveloper}
	 */
	public static void setName(String myName) {
		ControlDeveloper.name = myName;
	}
	
	/**
	 * Creates new {@link Command}s and saves them in an array
	 */
	public static void testCommands(){
		commands[0] = new Direction(30);
		commands[1] = new Gear(10, 5.1);
		commands[2] = new Repetition(4, 3);
		commands[3] = new Pause(2.3);
	}
	
	/**
	 * prints the {@link Command}s in the array
	 */
	public static void printCommands(){
//		for (int i = 0; i < counter; i++){
//			System.out.println(commands[i].toString());
//		}
		for (Command c : commands)
			System.out.println(c.toString());
	}
}
	

