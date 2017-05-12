package commandlist;
import command.Command;

/**
 * 
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
	
	/**
	 * Returns the next {@link Element}
	 * @return 
	 */
	public Element getNext() {
		return next;
	}
	
	/**
	 * Sets the next {@link Element}
	 * @param myNext
	 */
	public void setNext(Element myNext) {
		this.next = myNext;
	}
	
	/**
	 * Returns the previous {@link Element}
	 * @return
	 */
	public Element getPrev() {
		return prev;
	}
		
	/**
	 * Sets the previous {@link Element}
	 * @param myPrev
	 */
	public void setPrev(Element myPrev) {
		this.prev = myPrev;
	}	
	
	/**
	 * Returns the {@link Command} of an {@link Element}
	 * @return
	 */
	public Command getElement(){
		return this.element;
	}
	
	/**
	 * Sets the {@link Command} of an {@link Element}
	 * @param myElement
	 */
	public void setElement(Command myElement){
		this.element = myElement;
	}




	
}
