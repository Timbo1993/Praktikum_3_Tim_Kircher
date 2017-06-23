package controldeveloper;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ListModel;

public class PrototypeScrollView extends JFrame {
	private ListModel lM = null;
	private JList<String> l = new JList<String>();
	
	public PrototypeScrollView(ListModel m){
		lM = m;
		JScrollPane sP = new JScrollPane();
		JLabel label = new JLabel("Prototypes", JLabel.CENTER);
		label.setFont(label.getFont().deriveFont(Font.ITALIC));
	
		//header bleibt beim scrollen immer sichtbar
		JViewport header = new JViewport();
		header.setView(label);
		sP.setColumnHeader(header);
		
		add(sP);
	}
}
