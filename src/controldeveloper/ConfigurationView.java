package controldeveloper;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ConfigurationView extends JPanel {
	JButton save = new JButton("save");
	JLabel l1=new JLabel("Direction");
	JLabel l2=new JLabel("Gear");
	JTextField f1 = new JTextField(15);
	JTextField f2 = new JTextField(15);
	
	
	
	public ConfigurationView(){
		
		setLayout(new BorderLayout());
		
		JPanel p2=new JPanel (new GridLayout(4,1));
		
		//obere Spalte
		JPanel p3=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p3.add(l1);
		p3.add(f1);
		p3.setVisible(false);
		
		//untere Spalte
		JPanel p4=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p4.add(l2);
		p4.add(f2);
		p4.setVisible(false);
		
		//untere Leiste mit save Button
		JPanel p1=new JPanel (new FlowLayout(FlowLayout.RIGHT));
		p1.add(save);
	
		CommandListView.t.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if(CommandListView.t.getValueAt(CommandListView.t.getSelectedRow(), 1).equals("Direction")){
					l1.setText("Degree:");
					p3.setVisible(true);	
					p4.setVisible(false);
				}
			}
			
		});
		
		// ab hier unterscheidung was ausgewählt ist in Table model
//		if("Direction"){
//			l1.setText("Degree:");
//			p3.setVisible(true);	
//			p4.setVisible(false);
//		}
//		else if("Gear"){
//			l1.setText("Speed:");
//			l2.setText("Duration:");
//			p3.setVisible(true);
//			p4.setVisible(true);
//		}
//		else if("Pause"){
//			l1.setText("Duration:");
//			p3.setVisible(true);
//			p4.setVisible(false);
//		}
//		else if("Repetition"){
//			l1.setText("Nr Steps:");
//			l2.setText("Nr Repetitions");
//			p3.setVisible(true);
//			p4.setVisible(true);
//		}
		
		
		
		
		save.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(l1.getText().equals("Degree:")){
					CommandListView.aTM.setValueAt(Integer.parseInt(f1.getText()), 0,CommandListView.t.getSelectedRow());

				}
			}
			
			
			
		});
		
		
		
		p2.add(p3);
		p2.add(p4);
		
		
		
		add(p1, BorderLayout.SOUTH);
		add(p2, BorderLayout.CENTER);
	
	
	
	}
	
	
	
	
	
	
}
