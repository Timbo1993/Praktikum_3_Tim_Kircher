package controldeveloper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import command.Command;
import command.Direction;
import command.Gear;
import command.Pause;
import command.Repetition;
import commandlist.CommandList;
import controldeveloper.ControlDeveloperMenuBar;
import controldeveloper.ControlDeveloperView;
import controlmodel.ControlModel;

public class ControlDeveloper {

	public static void main(String[] args) {
		JFrame mainFrame = new JFrame("ControlDeveloper");
		ControlModel cm = ControlModel.getInstance();
//		cm.createCommandTypes();
		


		
		//Menü
		ControlDeveloperMenuBar menu = new ControlDeveloperMenuBar(new ControlDeveloperView());
		mainFrame.setJMenuBar(menu);
		mainFrame.setLayout(new BorderLayout());
		
		//Layout
		mainFrame.setLayout(new BorderLayout());
		
		CommandListModel cLM = new CommandListModel();
		CommandListView cLV = new CommandListView(cLM);
		mainFrame.add(cLV, BorderLayout.CENTER);
		
		PrototypeListModel pLM= new PrototypeListModel();
		PrototypeView pV=new PrototypeView(pLM);
		mainFrame.add (pV, BorderLayout.WEST);
		
		
		
		
		
		
		//Configuration
		ConfigurationView cV=new ConfigurationView();
		mainFrame.add(cV,BorderLayout.EAST);
		
		
		
		//Ausgabe textfeld
		AusgabeView aV=new AusgabeView();
		mainFrame.add(aV, BorderLayout.SOUTH);
		
		
		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
