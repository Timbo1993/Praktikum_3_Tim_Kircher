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
import hsrt.mec.controldeveloper.core.com.command.IPause;

/**
 * 
 *	The pause command
 */
public class Pause extends Command implements IPause{
	private double duration;

	/**
	 * Constructor of {@link Pause}
	 * @param myDuration	the duration of {@link Pause}
	 * @param myName		the name of the {@link Command}
	 */
	public Pause(int myDuration){
		super("Pause");
		this.setDuration(myDuration);
	}

	/**
	 * Sets the duration of the {@link Pause}
	 * @param myDuration
	 */
	public void setDuration(double myDuration) {
		if(myDuration <= 0){
			System.out.println("Duration of pause should be > 0");
		}
		else {
			this.duration = myDuration;
		}
	}
	
	/**
	 * Returns the duration of {@link Pause}
	 */
	@Override
	public double getDuration() {
		return this.duration;
	}
	
	/**
	 * Returns the content of the {@link Pause}
	 */
	@Override
	public String toString(){
		return getName() + ": " + getDuration() +" Sekunden";
	}

}
