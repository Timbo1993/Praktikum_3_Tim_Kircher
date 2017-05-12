package command;
import hsrt.mec.controldeveloper.core.com.command.IGear;

/**
 * 
 *	The gear {@link Command}
 */
public class Gear extends Command implements IGear {
	private int speed;
	private double duration;
	
	/**
	 * Constructor of {@link Gear}
	 * 
	 * @param mySpeed		the speed of the {@link Gear}
	 * @param myDuration	the duration of the {@link Gear}
	 * @param myName		the name of the {@link Command}
	 */
	public Gear (int mySpeed, double myDuration){
		super("Gear");
		this.setSpeed(mySpeed);
		this.setDuration(myDuration);
		}	
	
	/**
	 * Sets the speed of {@link Gear}
	 * @param mySpeed
	 */
	public void setSpeed(int mySpeed) {
		this.speed = mySpeed;
	}
		
	/**
	 * Sets the duration of the {@link Gear}
	 * @param myDuration
	 */
	public void setDuration(double myDuration) {
		if (myDuration <= 0.0){
			System.out.println("Duration of gear should be >0");
		}
		this.duration = myDuration;
	}
	
	/**
	 * Returns the speed of the {@link Gear}
	 */
	@Override	
	public int getSpeed() {
		return this.speed;
	}
	
	/**
	 * Returns the duration of the {@link Gear}
	 */
	@Override
	public double getDuration() {
		return this.duration;
	}

	/**
	 * Returns the content of the {@link Gear}
	 */
	@Override
	public String toString(){
		return getName()+ ": " + getSpeed() + " m/s, " + getDuration() + " s";
	}
	

}
