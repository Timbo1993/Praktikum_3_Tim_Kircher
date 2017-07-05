package controldeveloper;


import javax.swing.table.AbstractTableModel;

import command.Direction;
import commandlist.CommandList;
import controlmodel.ControlModel;
import java.util.Vector;


@SuppressWarnings("serial")
public class CommandListModel extends AbstractTableModel {
	static final String[] columnHeader= {"No.", "Command", "Configuration"};
	private int rowCount = 0;
//	private Vector<Vector<String>> rows = new Vector<Vector<String>>();
	CommandList list = ControlModel.getInstance().getControlProcess();
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnHeader.length;
	}

	@Override
	public int getRowCount() {
//		return ControlModel.getInstance().getControlProcess().getLength();
//		return rowCount;
		return list.getLength();
	}

	public void neu(){
		
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		if(column == 0){
			return row+1;
		}
		else if (column == 1){
			return list.get(row).getName();
		}
		else if (column == 2){
			return list.get(row);
		}
		else return "error";
	}
	
	public String getColumnName(int column){
		return columnHeader[column];
	}

	public void setValueAt(int value1,int value2, int row){
		if(ControlModel.getInstance().getControlProcess().get(row).getName().equals("Direction")){
			((Direction)ControlModel.getInstance().getControlProcess().get(row)).setDegree(value1);
			fireTableDataChanged();
		}
	}
	
//	public void addRow(){
//		rowCount++;
//	}
	public void changed(){
		fireTableDataChanged();
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		    if ( columnIndex==0 )
		      return false;
		    return true;
	}
}
