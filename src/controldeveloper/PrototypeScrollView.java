package controldeveloper;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controlmodel.ControlModel;

public class PrototypeScrollView extends JPanel {
	private DefaultListModel<String> lM = null;
	private JList<String> l = new JList<String>();
	private JButton add = new JButton("add");
	
	public JList getList(){
		return this.l;
	}
	public PrototypeScrollView(DefaultListModel<String> m){
		lM = m;
		setLayout(new BorderLayout());
		l.setModel(lM);
		l.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane sP = new JScrollPane(l);
		JLabel label = new JLabel("Prototypes", JLabel.CENTER);
		label.setFont(label.getFont().deriveFont(Font.ITALIC));
		l.setSelectedIndex(0);
		
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {	
				if((((PrototypeListModel) lM).setSelectedItem(l.getSelectedIndex()).equals("Direction"))){
					ControlModel.getInstance().getControlProcess().add(
							ControlModel.getInstance().getCommandTypes()[0].createInstance()
					);
					Vector<String> rowData = new Vector<String>();
					rowData.addElement(Integer.toString(CommandListTable.getDefaultTable().getRowCount()+1));
					rowData.addElement(ControlModel.getInstance().getCommandTypes()[0].getName());
					CommandListTable.getDefaultTable().addRow(rowData);
				}
				else if((((PrototypeListModel) lM).setSelectedItem(l.getSelectedIndex()).equals("Repetition"))){
					ControlModel.getInstance().getControlProcess().add(
							ControlModel.getInstance().getCommandTypes()[2].createInstance()
					);	
					Vector<String> rowData = new Vector<String>();
					rowData.addElement(Integer.toString(CommandListTable.getDefaultTable().getRowCount()+1));
					rowData.addElement(ControlModel.getInstance().getCommandTypes()[2].getName());
					CommandListTable.getDefaultTable().addRow(rowData);
				}
				else if((((PrototypeListModel) lM).setSelectedItem(l.getSelectedIndex()).equals("Gear"))){
					ControlModel.getInstance().getControlProcess().add(
							ControlModel.getInstance().getCommandTypes()[1].createInstance()
					);
					Vector<String> rowData = new Vector<String>();
					rowData.addElement(Integer.toString(CommandListTable.getDefaultTable().getRowCount()+1));
					rowData.addElement(ControlModel.getInstance().getCommandTypes()[1].getName());
					CommandListTable.getDefaultTable().addRow(rowData);
				}
				else if((((PrototypeListModel) lM).setSelectedItem(l.getSelectedIndex()).equals("Pause"))){
					ControlModel.getInstance().getControlProcess().add(
							ControlModel.getInstance().getCommandTypes()[3].createInstance()
					);
					Vector<String> rowData = new Vector<String>();
					rowData.addElement(Integer.toString(CommandListTable.getDefaultTable().getRowCount()+1));
					rowData.addElement(ControlModel.getInstance().getCommandTypes()[3].getName());
					CommandListTable.getDefaultTable().addRow(rowData);
				}
			}			
		});
		
		//header bleibt beim scrollen immer sichtbar
		JViewport header = new JViewport();
		header.setView(label);
		sP.setColumnHeader(header);
		

		
		add(sP, BorderLayout.CENTER);
		add(add, BorderLayout.SOUTH);
	}
}
