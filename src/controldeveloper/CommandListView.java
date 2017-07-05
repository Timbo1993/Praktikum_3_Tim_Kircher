package controldeveloper;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class CommandListView extends JPanel {
	 static JTable t = new JTable();
	static CommandListModel aTM = null;
	private JButton remove = new JButton("remove");
	private JButton up = new JButton("up");
	private JButton down = new JButton("down");
	private JButton stop = new JButton("stop");
	private JButton start = new JButton("start");

	
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
	    
	    //ActionListener als anonyme klassen
		remove.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		up.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			}
			
		});
		
		down.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
		start.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
		stop.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
		
		setLayout(new BorderLayout());
		add(new JScrollPane(t), BorderLayout.CENTER);
		
		
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
