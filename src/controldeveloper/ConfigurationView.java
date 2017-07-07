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
	
		// ab hier unterscheidung was ausgewählt ist in Table model
		CommandListView.t.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				
				
				
				
				
				//sobald man was ausgewählt und gesafet hat kommt automatisch die Konfiguration des ersten Elementes
				// aussgewählt lassen wenn man es verschiebt?
				// wenn nur ein element dann kann man es nicht mehr löschen?
				//Falls nur einer von zwei Textfelden beschrieben wird  funktioniert es nicht
				
				
				
				f1.setText("");
				f2.setText("");		//leeren der Textfelder, falls man nicht auuf save drückt
				
				
				
				if(CommandListView.t.getValueAt(CommandListView.t.getSelectedRow(), 1).equals("Direction")){
					l1.setText("Degree:");
					p3.setVisible(true);	
					p4.setVisible(false);
				}
				else if (CommandListView.t.getValueAt(CommandListView.t.getSelectedRow(), 1).equals("Gear")){
					l1.setText("Speed:");
					p3.setVisible(true);
					l2.setText("Duration: ");
					p4.setVisible(true);
				}
				else if (CommandListView.t.getValueAt(CommandListView.t.getSelectedRow(), 1).equals("Repetition")){
					l1.setText("Nr Steps:");
					p3.setVisible(true);
					l2.setText("Nr Repetitions: ");
					p4.setVisible(true);
				}
				else if (CommandListView.t.getValueAt(CommandListView.t.getSelectedRow(), 1).equals("Pause")){
					l1.setText("Duration:");
					p3.setVisible(true);
					p4.setVisible(false);
				}
				else{
					p3.setVisible(false);
					p4.setVisible(false);
				}
			}
			
		});
		
		
		save.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int merker = CommandListView.t.getSelectedRow();
				if(l1.getText().equals("Degree:")){
					if(f1.getText().equals("")){
						CommandListView.aTM.setValueAt("0", f2.getText(),CommandListView.t.getSelectedRow());
					}
					else
						CommandListView.aTM.setValueAt(f1.getText(), f2.getText(),CommandListView.t.getSelectedRow());
				}
				else if(l1.getText().equals("Speed:") ){
					if (f1.getText().equals("")){
						if(f2.getText().equals(""))
							CommandListView.aTM.setValueAt("0", "0",CommandListView.t.getSelectedRow());
						else
						CommandListView.aTM.setValueAt("0", f2.getText(),CommandListView.t.getSelectedRow());
					}
					else if(f2.getText().equals(""))
						CommandListView.aTM.setValueAt(f1.getText(), "0",CommandListView.t.getSelectedRow());
					else
						
					CommandListView.aTM.setValueAt(f1.getText(), f2.getText(), CommandListView.t.getSelectedRow());
				}
				else if(l1.getText().equals("Nr Steps:") ){
					if (f1.getText().equals("")){
						if(f2.getText().equals(""))
							CommandListView.aTM.setValueAt("0", "0",CommandListView.t.getSelectedRow());
						else
						CommandListView.aTM.setValueAt("0", f2.getText(),CommandListView.t.getSelectedRow());
					}
					else if(f2.getText().equals(""))
						CommandListView.aTM.setValueAt(f1.getText(), "0",CommandListView.t.getSelectedRow());
					else
					CommandListView.aTM.setValueAt(f1.getText(), f2.getText(), CommandListView.t.getSelectedRow());
				}
				else if(l1.getText().equals("Duration:") ){
					if(f1.getText().equals("")){
						CommandListView.aTM.setValueAt("0", f2.getText(),CommandListView.t.getSelectedRow());
					}
					else
					CommandListView.aTM.setValueAt(f1.getText(), f2.getText(), CommandListView.t.getSelectedRow());
				}
				CommandListView.t.setRowSelectionInterval(merker, merker);
				f1.setText("");
				f2.setText("");
			}
			
			
		});
		
		
		
		p2.add(p3);
		p2.add(p4);
		
		
		
		add(p1, BorderLayout.SOUTH);
		add(p2, BorderLayout.CENTER);
	
	
	
	}
	
	
	
	
	
	
}
