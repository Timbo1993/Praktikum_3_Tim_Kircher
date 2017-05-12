package commandlist;
import command.Command;

/**
 * 
 *	The linked list with the {@link Command}s
 */
public class CommandList {
	
	private Element root;
	
	/**
	 * Default Constructor
	 */
	public CommandList(){
		//empty
	}
		
	/**
	 * Adds an {@link Command} to the {@link CommandList}
	 * @param c	the {@link Command} thats added to the list
	 * @return	true if {@link Command} was successfully added, false if not
	 */
	public boolean add(Command c){
		boolean success = false;
		
		if(this.root == null){		//Wenn Liste leer, vorheriges nud n�chstes Element Null
			root = new Element(c, null, null);
		}
		else{
			Element hilfszeiger = this.root;
			
			while (hilfszeiger.getNext() != null){		//Schleife iteriert bis zum letzten Element
				hilfszeiger = hilfszeiger.getNext();
			}
			Element newElement = new Element (c, hilfszeiger, null);
			hilfszeiger.setNext(newElement);
			success = true;
		}
		
		return success;
	}
	
	/**
	 * Removes an {@link Element} in the {@link CommandList}
	 * @param pos	position of the {@link Element} that will be removed
	 * @return		true if successfully removed, false if not
	 */
	public boolean remove(int pos){
		boolean success = false;
		boolean isInList = true;		//wenn position gr��er ist als listenelemente vorhanden
		Element hilfszeiger = this.root;
		int counter = 0;
		
		while (counter < pos && isInList){
			if (hilfszeiger.getNext() != null){
				hilfszeiger = hilfszeiger.getNext();
				counter++;
			}
			else{
				isInList = false;
				System.out.println("List does not have position: " + pos);
				System.out.println("\n");
			}
		}
		
		if(isInList){
			if (pos == 0){
				hilfszeiger.getNext().setPrev(null);
				this.root = hilfszeiger.getNext();				
			}
			else if (hilfszeiger.getNext() == null){
				hilfszeiger.getPrev().setNext(null);
			}
			else{
				Element next = hilfszeiger.getNext();
				Element prev = hilfszeiger.getPrev();
				prev.setNext(next);
				next.setPrev(prev);
				success = true;
			}
		}
				
		return success;
	}
	
	/**
	 * Gets the {@link Command} at the requested Position
	 * @param pos	position of the {@link Element}
	 * @return		returns the {@link Command} at the position
	 */
	public Command get(int pos){
		Element hilfszeiger = this.root;
		int counter = 0;
		boolean isInList = true;
		
		while (counter < pos && isInList){
			if (hilfszeiger.getNext() != null){
				hilfszeiger = hilfszeiger.getNext();
				counter++;
			}
			else{
				isInList = false;
				System.out.println("List does not have the position " + pos);
				System.out.println("\n");
			}
		}
		
		return hilfszeiger.getElement();
	}
	
	/**
	 * Moves an {@link Element} one position up in the {@link CommandList} (closer to the start)
	 * @param pos	position of the {@link Element}
	 * @return		true if successfully moved up, false if not
	 */
	public boolean moveUp(int pos){
		boolean success = false;
		boolean isInList = true;
		int counter = 0;
		Element hilfszeiger = this.root;
		
		if (pos < 0){
			System.out.println("Please enter a position >=0");
			System.out.println("\n");
			isInList = false;
		}
		else if(pos == 0){
			System.out.println("Element is already at the top of the List");
			System.out.println("\n");
			isInList = false;
		}
		else{
			while (counter < pos && isInList){
				if (hilfszeiger.getNext() != null){
					hilfszeiger = hilfszeiger.getNext();
					counter++;
				}
				else {
					isInList = false;
					System.out.println("List does not have the position" + pos);
					System.out.println("\n");
				}
			}
		}
		
		if (isInList){
            if (pos == 1){
    			hilfszeiger.getPrev().setNext (hilfszeiger.getNext());
    			hilfszeiger.getNext().setPrev(hilfszeiger.getPrev());;
    			hilfszeiger.setNext(hilfszeiger.getPrev());
    			hilfszeiger.getNext().setPrev(hilfszeiger);
    			hilfszeiger.setPrev(null);
    			this.root = hilfszeiger;
            }
            else if(hilfszeiger.getNext()==null){
           		hilfszeiger.setNext(hilfszeiger.getPrev ());
           		hilfszeiger.setPrev(hilfszeiger.getNext().getPrev());
           		hilfszeiger.getNext().setPrev(hilfszeiger);
           		hilfszeiger.getPrev().setNext(hilfszeiger);
           		hilfszeiger.getNext().setNext(null);
            }
            else{
    			hilfszeiger.getPrev().setNext (hilfszeiger.getNext());
    			hilfszeiger.setNext(hilfszeiger.getPrev ());
    			hilfszeiger.setPrev(hilfszeiger.getNext().getPrev());
                hilfszeiger.getNext().setPrev(hilfszeiger);
                hilfszeiger.getPrev().setNext(hilfszeiger);
                hilfszeiger.getNext().getNext().setPrev(hilfszeiger.getNext());
            }
			success = true;
		}		
		return success;
	}
	
	/**
	 * Moves an {@link Element} one position down in the {@link CommandList} (closer to the end where new commands are added)
	 * @param pos	posirion of the {@link Element}
	 * @return		true if succesfully moved down, false if not
	 */
	public boolean moveDown(int pos){
		boolean success = false;
		boolean isInList = true;
		int counter = 0;
		Element hilfszeiger = this.root;
		
		if(pos < 0){
			System.out.println("Please enter a position >=0");
			System.out.println("\n");
			isInList = false;
		}
		else if(pos != 0){
			while(counter < pos + 1   && isInList){
				if(hilfszeiger.getNext() != null){
					hilfszeiger = hilfszeiger.getNext();
					counter++;
				}
				else if(hilfszeiger.getNext() == null && counter == pos){
					isInList = false;
					System.out.println("Element is already at the end of the list");
					System.out.println("\n");
				}
				else{
					isInList = false;
					System.out.println("List does not have the position " + pos);
					System.out.println("\n");
				}
			}
			hilfszeiger = hilfszeiger.getPrev();
		}
		
		if(isInList){
			if (pos == 0){
				this.root = hilfszeiger.getNext();
				hilfszeiger.setPrev(hilfszeiger.getNext());
				hilfszeiger.setNext(hilfszeiger.getPrev().getNext());
				hilfszeiger.getNext().setPrev(hilfszeiger);
				hilfszeiger.getPrev().setNext(hilfszeiger);
				hilfszeiger.getPrev().setPrev(null);
			}
			else if(hilfszeiger.getNext().getNext()== null){
				hilfszeiger.getNext().setNext(hilfszeiger);
				hilfszeiger.getNext().setPrev(hilfszeiger.getPrev());
				hilfszeiger.getPrev().setNext(hilfszeiger.getNext());
				hilfszeiger.setPrev(hilfszeiger.getNext());
				hilfszeiger.setNext(null);
			}
			else{
				hilfszeiger.getPrev().setNext(hilfszeiger.getNext());
				hilfszeiger.getNext().setPrev(hilfszeiger.getPrev());
				hilfszeiger.setPrev(hilfszeiger.getNext());
				hilfszeiger.setNext(hilfszeiger.getPrev().getNext());
				hilfszeiger.getPrev().setNext(hilfszeiger);
				hilfszeiger.getNext().setPrev(hilfszeiger);
			}
			success = true;
		}
		
		return success;
	}	
	
	/**
	 * prints the whole {@link CommandList}
	 */
	public void printCommandList(){
		Element hilfszeiger = this.root;
		while (hilfszeiger != null){
			System.out.println(hilfszeiger.getElement().toString());
			hilfszeiger = hilfszeiger.getNext();
		}
	}
}
