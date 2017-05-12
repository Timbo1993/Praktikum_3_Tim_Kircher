package command;
import hsrt.mec.controldeveloper.core.com.command.IDirection;

/**
 * 
 * @author Tim Kircher
 * The Direction Command
 */

public class Direction extends Command implements IDirection {
	private int degree;
	
	
	/**
	 * Constructor of {@link Direction}
	 * 
	 * @param myDegree degree of the {@link Direction}
	 * @param myName name of the {@link Direction}
	 */
	public Direction(int myDegree, String myName){
		super(myName);
		this.setDegree(myDegree);
	}

	/**
	 * Sets the degree of the {@link Direction} 
	 * @param myDegree
	 */
	public void setDegree(int myDegree) {
		this.degree = myDegree;
	}
	
	/**
	 * Returns the degree of the {@link Direction}
	 */
	@Override
	public int getDegree() {
		return this.degree;
	}
	
	/**
	 * Returns the content of the {@link Direction}
	 */
	@Override
	public String toString(){
		return getName() + ": " + getDegree() +"�";
	}
}