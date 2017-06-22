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

package command;
import hsrt.mec.controldeveloper.core.com.command.IRepetition;

/**
 * 
 *	The Repetition {@link Command}
 */
public class Repetition extends Command implements IRepetition {
	private int nrSteps;
	private int nrRepetitions;
		
	/**
	 * Constructor of {@link Repetition}
	 * @param myNrSteps			the number of steps
	 * @param myNrRepetitions	the number of repetitions
	 * @param myName			the name of the {@link Command}
	 */
	public Repetition (int myNrSteps, int myNrRepetitions){
		super("Repetition");
		this.setNrRepetitions(myNrRepetitions);
		this.setNrSteps(myNrSteps);
	}

	/**
	 * Sets the number of steps for the {@link Repetition}
	 * @param myNrSteps
	 */
	public void setNrSteps(int myNrSteps) {
		if(myNrSteps <= 0){
//			System.out.println("Nr of steps should be > 0");
		}
		else {
			this.nrSteps = myNrSteps;
		}
	}

	/**
	 * Sets the number of repetitions for the {@link Repetition}
	 * @param myNrRepetitions
	 */
	public void setNrRepetitions(int myNrRepetitions) {
		if(myNrRepetitions <= 0){
//			System.out.println("Number of repetitions should be > 0");
		}
		else {
			this.nrRepetitions = myNrRepetitions;
		}
	}
	
	/**
	 * Returns the number of repetitions
	 */
	@Override
	public int getNrRepetitions() {
		return this.nrRepetitions;
	}
	
	/**
	 * Returns the number of steps
	 */
	@Override
	public int getNrSteps() {
		return this.nrSteps;
	}
	
	/**
	 * Returns the content of the {@link Repetition}
	 */
	@Override
	public String toString(){
		return getName() + ": " + getNrSteps() +" Schritte, " + getNrRepetitions() + " Widerholungen";
	}	
	

}
