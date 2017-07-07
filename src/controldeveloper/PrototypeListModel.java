package controldeveloper;

/**
 * Model Class for the list of prototypes
 *
 */
public class PrototypeListModel {
	private String[] types = {"Direction","Gear","Repetition", "Pause"};
	private int index;
	
	
	/**
	 * 
	 * @returns the String Array with the different prototypes
	 */
	public String[] getItems(){
		return types;
	}
	
	
	/**
	 * 
	 * @param index
	 * @returns the name of the selected index of the list
	 */
	public String setSelectedItem (int index){
		if (index < 0 || index > types.length)
			return "error";
		
		this.index=index;
		return types[this.index];
	}

}
