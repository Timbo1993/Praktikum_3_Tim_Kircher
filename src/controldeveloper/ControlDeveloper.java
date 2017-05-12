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
 * @author Tim Kircher
 * @author Lenz Haslach
 *	Test Class to test {@link Command}s and {@link CommandList} methods
 */
public class ControlDeveloper {

	private static String name = "Control-Developer";
	static int counter = 4;
	static Command[] commands = new Command[counter];
	static CommandList commandList;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(name);
		System.out.println(getName());
		
		System.out.println("\n");
		
		testCommands();
		printCommands();
		
		commandList  = new CommandList();
		commandList.add(commands[0]);
		commandList.add(commands[1]);
		commandList.add(commands[2]);
		commandList.add(commands[3]);
		commandList.add(commands[0]);
		commandList.add(commands[1]);

		System.out.println("\n");

		commandList.printCommandList();
		
		System.out.println("\n");

		commandList.moveDown(5);
		
		commandList.printCommandList();
		
		System.out.println("\n");

	}

	public static String getName() {
		return name;
	}

	public static void setName(String myName) {
		ControlDeveloper.name = myName;
	}
	
	/**
	 * Creates new {@link Command}s and saves them in an array
	 */
	public static void testCommands(){
		commands[0] = new Direction(30, "dir1");
		commands[1] = new Gear(10, 5.0, "gear1");
		commands[2] = new Repetition(4, 3, "rep1");
		commands[3] = new Pause(2, "pause1");
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
	

