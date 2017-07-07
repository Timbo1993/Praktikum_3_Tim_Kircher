package controldeveloper;


import javax.swing.table.AbstractTableModel;

import command.Direction;
import command.Gear;
import command.Pause;
import command.Repetition;
import commandlist.CommandList;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Model Class for the {@link CommandList}
 *
 */
@SuppressWarnings("serial")
public class CommandListModel extends AbstractTableModel {
	static final String[] columnHeader= {"No.", "Command", "Configuration"};
//	private int rowCount = 0;
//	private Vector<Vector<String>> rows = new Vector<Vector<String>>();
	CommandList list = ControlModel.getInstance().getControlProcess();
	
	/**
	 * returns the number of columns of the table with the Commands
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnHeader.length;
	}

	/**
	 * returns the number of rows with the Commands
	 */
	@Override
	public int getRowCount() {
//		return ControlModel.getInstance().getControlProcess().getLength();
//		return rowCount;
		return list.getLength();
	}

//	public void neu(){
//		
//	}
	
	/**
	 * Returns the object of a cell of the Table with the Commands
	 */
	@Override
	public Object getValueAt(int row, int column) {
		if(column == 0){
			return row+1;
		}
		else if (column == 1){
			if(list.get(row)== null)
				return "error";
			else
				return list.get(row).getName();
		}
		else if (column == 2){
			return list.get(row);
		}
		else return "error";
	}
	
	/**
	 * Returns the name of a Column
	 */
	public String getColumnName(int column){
		return columnHeader[column];
	}

	/**
	 * Used to set the COmmand at the Selected row
	 * @param value1	First value for the Command
	 * @param value2	Second Value of the Command
	 * @param row		position of the Command in the {@link CommandList}
	 */
	public void setValueAt(String value1,String value2, int row){
		
		int i1=0, i2=0;
		double d1=0;
		
		if(ControlModel.getInstance().getControlProcess().get(row).getName().equals("Direction")){
			try{
				i1 = Integer.parseInt(value1);
			}
			catch(NumberFormatException e){
				System.out.println("kein gültiger wert");
			}
			((Direction)ControlModel.getInstance().getControlProcess().get(row)).setDegree(i1);
			fireTableDataChanged();
		}
		else if (ControlModel.getInstance().getControlProcess().get(row).getName().equals("Gear")){
			try{
				i1 = Integer.parseInt(value1);
			}
			catch(NumberFormatException e){
				System.out.println("kein gültiger wert");
			}
			try{
				d1 = Double.parseDouble(value2);
			}
			catch(NumberFormatException e){
				System.out.println("kein gültiger wert");
			}
			
			((Gear)ControlModel.getInstance().getControlProcess().get(row)).setSpeed(i1);
			((Gear)ControlModel.getInstance().getControlProcess().get(row)).setDuration(d1);
			fireTableDataChanged();
		}
		else if (ControlModel.getInstance().getControlProcess().get(row).getName().equals("Repetition")){
			try{
				i1 = Integer.parseInt(value1);
			}
			catch(NumberFormatException e){
				System.out.println("kein gültiger wert");
			}
			try{
				i2 = Integer.parseInt(value2);
			}
			catch(NumberFormatException e){
				System.out.println("kein gültiger wert");
			}
			
			((Repetition)ControlModel.getInstance().getControlProcess().get(row)).setNrSteps(i1);
			((Repetition)ControlModel.getInstance().getControlProcess().get(row)).setNrRepetitions(i2);
			fireTableDataChanged();
		}
		else if (ControlModel.getInstance().getControlProcess().get(row).getName().equals("Pause")){
			try{
				d1 = Double.parseDouble(value1);
			}
			catch(NumberFormatException e){
				System.out.println("kein gültiger wert");
			}
			
			((Pause)ControlModel.getInstance().getControlProcess().get(row)).setDuration(d1);
			fireTableDataChanged();
		}
	}
	
//	public void addRow(){
//		rowCount++;
//	}
	/**
	 * Refreshs the table with the {@link CommandList}
	 */
	public void changed(){
		fireTableDataChanged();
	}
	
	/**
	 * 
	 */
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		    if ( columnIndex==0 )
		      return false;
		    return true;
	}
	
	/**
	 * Removes a row from the table and deletes the Command from the {@link CommandList}
	 * @param row
	 */
	  public void delRow(int row){
		    if (row<0 || row>=list.getLength())
		      return;

		    ControlModel.getInstance().getControlProcess().remove(row);

//		    fireTableDataChanged();
		    fireTableRowsDeleted(row, row);
		  }
}
