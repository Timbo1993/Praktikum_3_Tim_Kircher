package controldeveloper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controlmodel.ControlModel;

public class CommandListTable extends JPanel{
	
	private static DefaultTableModel 	clTM = null;
	private static JTable 	t = new JTable();	
	private JButton remove = new JButton("Remove");
	private JButton up = new JButton("Up");
	private JButton down = new JButton("Down");
	private JButton stop = new JButton("stop");
	private JButton start = new JButton("start");

	
	public CommandListTable(DefaultTableModel m){
	
		CommandListTable.clTM = m;
		setLayout(new BorderLayout());
		t.setModel(clTM);
	    t.setSelectionForeground( Color.gray );
	    t.setSelectionBackground( Color.orange );

	    
	    add(new JScrollPane(t), BorderLayout.CENTER);
	    
	    JPanel p = new JPanel();
	    p.add(remove);
	    p.add(up);
	    p.add(down);
	    p.add(start);
	    p.add(stop);
	    add(p, BorderLayout.SOUTH);
	    
	    
	}

	public static DefaultTableModel getDefaultTable(){
		return clTM;
	}
	public static JTable getTable(){
		return t;
	}

}
	
