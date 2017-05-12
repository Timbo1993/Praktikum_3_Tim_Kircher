package controldeveloper;
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Aufgabe 1:");
		System.out.println(name);
		System.out.println(getName());		
		System.out.println("\n");
		
		System.out.println("Aufgabe 3:");
		testCommands();
		printCommands();
		
		System.out.println("\n");
		System.out.println("Aufgabe 4: liste hinzufügen und ausgeben:");
		commandList  = new CommandList();
		commandList.add(commands[0]);
		commandList.add(commands[1]);
		commandList.add(commands[2]);
		commandList.add(commands[3]);
		commandList.printCommandList();		
		System.out.println("\n");

		//MoveDown
		System.out.println("Aufgabe 4: moveDown [-1]");
		commandList.moveDown(-1);		
		commandList.printCommandList();		
		System.out.println("\n");
		
		System.out.println("Aufgabe 4: moveDown[0] (erstes Element)");
		commandList.moveDown(0);		
		commandList.printCommandList();		
		System.out.println("\n");
		
		System.out.println("Aufgabe 4: moveDown[2]");
		commandList.moveDown(2);		
		commandList.printCommandList();		
		System.out.println("\n");
		
		System.out.println("Aufgabe 4: moveDown[3](letztes Element)");
		commandList.moveDown(3);		
		commandList.printCommandList();		
		System.out.println("\n");
		
		System.out.println("Aufgabe 4: moveDown[7](element existiert nicht)");
		commandList.moveDown(7);		
		commandList.printCommandList();		
		System.out.println("\n");
		
		//MoveUp
		System.out.println("Aufgabe 4: moveUp [-1]");
		commandList.moveDown(-1);		
		commandList.printCommandList();		
		System.out.println("\n");
		
		System.out.println("Aufgabe 4: moveUp[0] (erstes Element)");
		commandList.moveDown(0);		
		commandList.printCommandList();		
		System.out.println("\n");
		
		System.out.println("Aufgabe 4: moveUp[2]");
		commandList.moveDown(2);		
		commandList.printCommandList();		
		System.out.println("\n");
		
		System.out.println("Aufgabe 4: moveUp[3](letztes Element)");
		commandList.moveDown(3);		
		commandList.printCommandList();		
		System.out.println("\n");
		
		System.out.println("Aufgabe 4: moveUp[7](element existiert nicht)");
		commandList.moveDown(7);		
		commandList.printCommandList();		
		System.out.println("\n");
		
		//Remove
		System.out.println("Aufgabe 4: Remove[-1](element existiert nicht)");
		commandList.remove(-1);		
		commandList.printCommandList();		
		System.out.println("\n");

		System.out.println("Aufgabe 4: Remove[0](erstes Element)");
		commandList.remove(0);		
		commandList.printCommandList();		
		System.out.println("\n");
		
		System.out.println("Aufgabe 4: Remove[1](elementin der mitte)");
		commandList.remove(1);		
		commandList.printCommandList();		
		System.out.println("\n");
		
		System.out.println("Aufgabe 4: Remove[1](element am ende)");
		commandList.remove(1);		
		commandList.printCommandList();		
		System.out.println("\n");
		
		System.out.println("Aufgabe 4: Remove[2](element existiert nicht)");
		commandList.remove(2);		
		commandList.printCommandList();		
		System.out.println("\n");
	}

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
		commands[1] = new Gear(10, 5.0);
		commands[2] = new Repetition(4, 3);
		commands[3] = new Pause(2);
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
	

