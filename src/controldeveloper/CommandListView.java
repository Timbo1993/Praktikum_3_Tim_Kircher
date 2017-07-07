package controldeveloper;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import hsrt.mec.controldeveloper.core.com.ComHandler;
import hsrt.mec.controldeveloper.core.com.ComPortHandler;
import hsrt.mec.controldeveloper.core.com.command.ICommand;
import hsrt.mec.controldeveloper.io.Console;
import hsrt.mec.controldeveloper.io.IOType;
import hsrt.mec.controldeveloper.io.SerialUSB;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * View Class for the Table with the {@link CommandList} and the buttons for the control
 *
 */
@SuppressWarnings("serial")
public class CommandListView extends JPanel {
	 static JTable t = new JTable();
	static CommandListModel aTM = null;
	private JButton remove = new JButton("remove");
	private JButton up = new JButton("up");
	private JButton down = new JButton("down");
	private JButton stop = new JButton("stop");
	private JButton start = new JButton("start");

	/**
	 * Constructor of the View
	 * @param m Model of the {@link COmmandList}
	 */
	public CommandListView(CommandListModel m){
		this.aTM = m;
		
		t.setModel(aTM);
	    t.setSelectionForeground( Color.gray );
	    t.setSelectionBackground( Color.orange );
		
	    t.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
			}	    	
	    });
	    
	    /**
	     * Action LIstener for the remove button
	     */
	    //ActionListener als anonyme klassen
		remove.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(t.getSelectedRow()!=-1){
					int merker = t.getSelectedRow();
					aTM.delRow(t.getSelectedRow());				
					CommandListView.aTM.fireTableDataChanged();
				
					if(ControlModel.getInstance().getControlProcess().getLength()>=1){
						if(merker == 0)
							t.setRowSelectionInterval(0, 0);
						else
							t.setRowSelectionInterval(merker-1, merker-1);
					}
				}
			}
		});
		
		/**
		 * Action Listener for the up button
		 */
		up.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(t.getSelectedRow()!=-1){
					int merker = t.getSelectedRow();

					ControlModel.getInstance().getControlProcess().moveUp(t.getSelectedRow());
					CommandListView.aTM.fireTableDataChanged();
				
					if (merker == 0)
						t.setRowSelectionInterval(0, 0);
					else 
						t.setRowSelectionInterval(merker-1, merker-1);
				}
			}
			
		});
		
		/**
		 * Action Listener for the down button
		 */
		down.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(t.getSelectedRow()!=-1){
					int merker = t.getSelectedRow();
					ControlModel.getInstance().getControlProcess().moveDown(t.getSelectedRow());
					CommandListView.aTM.fireTableDataChanged();
				
					if(merker == ControlModel.getInstance().getControlProcess().getLength()-1)
						t.setRowSelectionInterval(merker, merker);
					else
						t.setRowSelectionInterval(merker+1, merker+1);
				}
			}
				
			
		});
		
		/**
		 * Action LIstener for the start button
		 */
		start.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<ICommand> commands = new Vector<ICommand>();
				
				for(int i = 0; ControlModel.getInstance().getControlProcess().get(i) != null; i++){
					commands.addElement(ControlModel.getInstance().getControlProcess().get(i));
				}
//				ControlModel.getInstance().comHandler;
//				for(int i=0; i < ControlModel.getInstance().getControlProcess().getLength();i++ ){
//					System.out.println(t.getValueAt(i,2));
////					ausgabe.append((String) t.getValueAt(i, 2)) ; 
////					ausgabe.append("\n"); 
				IOType t = new Console();
				t= new SerialUSB(ComPortHandler.getPorts()[1]);
				ComHandler.getInstance().start(commands, t);
//				AusgabeView.ausgabe.setText("");
//				for (int i=0;i<ControlModel.getInstance().getControlProcess().getLength();i++ ){
					
//				AusgabeView.addText(t.getValueAt(i, 2).toString());
				
//				}
			}
			
		});
		
		/**
		 * Action Listener for the stop button
		 */
		stop.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				AusgabeView.ausgabe.setText("");
			}
			
		});
		
		
		setLayout(new BorderLayout());
		add(new JScrollPane(t, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
				), BorderLayout.CENTER);
		
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));

		p1.add(remove);
		
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(up);
		p2.add(down);
		p2.add(stop);
		p2.add(start);
		
		p.add(p1, BorderLayout.WEST);
		p.add(p2, BorderLayout.EAST);
		add(p, BorderLayout.SOUTH);

	}
}
