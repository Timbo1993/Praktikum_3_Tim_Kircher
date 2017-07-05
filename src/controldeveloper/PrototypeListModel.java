package controldeveloper;


public class PrototypeListModel {
	private String[] types = {"Direction","Gear","Repetition", "Pause"};
	private int index;
	
	
	public String[] getItems(){
		return types;
	}
	
	
	
	public String setSelectedItem (int index){
		if (index < 0 || index > types.length)
			return "error";
		
		this.index=index;
		return types[this.index];
	}

}
