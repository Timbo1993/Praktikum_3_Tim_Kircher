package controldeveloper;


public class PrototypeListModel {
	private String[] types = {"Direction","Gear","Repetition", "Pause"};
	private int index;
	
	
	public String[] getItems(){
		return types;
	}
	
	
	
	public void setSelectedItem(int index){
		if (index < 0 || index > types.length)
			return;
		
		this.index=index;
		System.out.println(types[this.index]);
	}

}
