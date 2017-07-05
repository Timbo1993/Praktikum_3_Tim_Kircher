package controldeveloper;


import javax.swing.table.AbstractTableModel;

import controlmodel.ControlModel;

@SuppressWarnings("serial")
public class CommandListModel extends AbstractTableModel {
	static final String[] columnHeader= {"No.", "Command", "Configuration"};
	private int rowCount = 0;
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnHeader.length;
	}

	@Override
	public int getRowCount() {
//		return ControlModel.getInstance().getControlProcess().getLength();
		return rowCount;
	}

	@Override
	public Object getValueAt(int row, int column) {
		return ControlModel.getInstance().getControlProcess().get(row);
	}
	
	public String getColumnName(int column){
		return columnHeader[column];
	}

	public void setValueAt(Object value, int row, int column){
		
	}
}
