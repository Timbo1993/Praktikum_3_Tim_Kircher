package command;
import hsrt.mec.controldeveloper.core.com.command.IPause;

/**
 * 
 * @author Tim Kircher
 *	The pause command
 */
public class Pause extends Command implements IPause{
	private double duration;

	/**
	 * Constructor of {@link Pause}
	 * @param myDuration	the duration of {@link Pause}
	 * @param myName		the name of the {@link Command}
	 */
	public Pause(int myDuration, String myName){
		super(myName);
		this.setDuration(myDuration);
	}

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

	@Override
	public String toString(){
		return getName() + ": " + getDuration() +" Sekunden";
	}

}
