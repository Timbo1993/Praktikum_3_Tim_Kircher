package commandlist;
import command.Command;

/**
 * 
 * @author Tim Kircher
 *	An element of the linked list
 */
public class Element {
	
	private Element next;
	private Element prev;
	private Command element;
	
	/**
	 * Constructor for Element
	 * @param com	the {@link Command} thats added to the element
	 * @param prev	the previous element
	 * @param next	the next element
	 */
	public Element(Command com, Element prev, Element next){
		this.element= com;
		this.setNext(next);
		this.setPrev(prev);
	}
	
	public Element getNext() {
		return next;
	}
	
	public void setNext(Element myNext) {
		this.next = myNext;
	}

	public Element getPrev() {
		return prev;
	}
		
	public void setPrev(Element myPrev) {
		this.prev = myPrev;
	}	
	
	
	public Command getElement(){
		return this.element;
	}
	
	public void setElement(Command myElement){
		this.element = myElement;
	}




	
}
