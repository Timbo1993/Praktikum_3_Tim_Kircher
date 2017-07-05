package controldeveloper;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ConfigurationView extends JPanel{
	 JButton save = new JButton("save");
	JLabel l1 = new JLabel("");
	 JLabel l2 = new JLabel("");
	 JTextField f1 = new JTextField(20);
	 JTextField f2 = new JTextField(20);


	public ConfigurationView(){
//		public ConfigurationView(String string){

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3, 2));
		f1.setVisible(false);
		f2.setVisible(false);
		p.add(l1);
		p.add(f1);
		p.add(l2);
		p.add(f2);
		
		CommandListTable.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e) {
//				System.out.println(CommandListTable.getTable().getValueAt(CommandListTable.getTable().getSelectedRow(), 1).toString());
				if(CommandListTable.getTable().getValueAt(CommandListTable.getTable().getSelectedRow(), 1).equals("Direction")){
					l1.setText("Degree:");
					l2.setText("");
					l1.setVisible(true);
					l2.setVisible(false);
					f1.setVisible(true);
					f2.setVisible(false);
				}else if(CommandListTable.getTable().getValueAt(CommandListTable.getTable().getSelectedRow(), 1).equals("Gear")){
					l1.setText("Speed:");
					l2.setText("Duration");
					l1.setVisible(true);
					l2.setVisible(true);
					f1.setVisible(true);
					f2.setVisible(true);
				}else if(CommandListTable.getTable().getValueAt(CommandListTable.getTable().getSelectedRow(), 1).equals("Pause")){
					l1.setText("Duration:");
					l2.setText("");
					l1.setVisible(true);
					l2.setVisible(false);
					f1.setVisible(true);
					f2.setVisible(false);
				}else if(CommandListTable.getTable().getValueAt(CommandListTable.getTable().getSelectedRow(), 1).equals("Repetition")){
					l1.setText("Nr Steps:");
					l2.setText("Nr Repetitions");
					l1.setVisible(true);
					l2.setVisible(true);
					f1.setVisible(true);
					f2.setVisible(true);
				}
			}	    	
	    });
		/*
		if(string.equals("Direction")){
			l1.setText("Degree:");
			System.out.println("direction");
		}
		else if(string.equals("Pause")){
			l1.setText("Duration:");
			System.out.println("pause");

		}
		else if(string.equals("Gear")){
			l1.setText("Speed:");
			l2.setText("Duration:");
			System.out.println("gear");

		}
		else if(string.equals("Repetition")){
			l1.setText("Nr of steps:");
			l2.setText("Nr of Repetitions:");
			System.out.println("repetition");

		}
		*/
		p.add(save);
		add(p);
	}
}
