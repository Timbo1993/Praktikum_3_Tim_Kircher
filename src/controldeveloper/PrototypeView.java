package controldeveloper;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
//import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

public class PrototypeView extends JPanel{
	private PrototypeListModel lM=null;
	private	JList<String> l = new JList<String>();
	//private JButton add =new JButton("add");
	
	


	public PrototypeView (PrototypeListModel pLM){
		lM=pLM;
		l.setListData(lM.getItems());
		setLayout(new BorderLayout());
		
		l.setSelectionForeground( Color.gray );		//schriftfarbe
	    l.setSelectionBackground( Color.orange );	//Hintergrund
	    //l.setSelectedIndex( 0 );					
			
	    add(l);
		
		l.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane sP =new JScrollPane(l, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JLabel label=new JLabel("Prototypes", JLabel.CENTER);
		label.setFont(label.getFont().deriveFont(Font.ITALIC));
		
		
	
		JPanel p1=new JPanel (new FlowLayout(FlowLayout.RIGHT));
		p1.add(new JButton("add"));
	
	
	//header bleibt beim scrollen immer sichtbar
			JViewport header = new JViewport();
			header.setView(label);
			sP.setColumnHeader(header);
	
			add(sP, BorderLayout.CENTER);
			add(p1, BorderLayout.SOUTH);
	}
	
	
}
// JScrollPane.VERTICAL_SCROLLBAR_{ALWAYS},JScrollPane.HORIZONTAL_SCROLLBAR_{AS_NEEDED});