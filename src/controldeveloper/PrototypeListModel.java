package controldeveloper;

import javax.swing.DefaultListModel;

public class PrototypeListModel extends DefaultListModel<String> {
	private String[] types = {"Direction","Gear","Repetition","Pause"};
	private int index;
	
	public PrototypeListModel(){
		for(String item: types)
			this.addElement(item);
	}
	
	public String setSelectedItem(int index){
		if(index < 0 || index > types.length)
			return "error";
		this.index = index;
		return types[this.index];
	}
}
