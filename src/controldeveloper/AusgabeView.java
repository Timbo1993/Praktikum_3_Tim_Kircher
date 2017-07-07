package controldeveloper;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Class for the output window
 *
 */
public class AusgabeView extends JPanel{

	JTextArea ausgabe = new JTextArea(5,20);
	
	
	
	public AusgabeView(){
		
		setLayout(new BorderLayout());
	
	ausgabe.setEditable(false);
	ausgabe.setLineWrap(true);
	ausgabe.setWrapStyleWord(true);
	ausgabe.setText("Lönz du spacko");
	
//	for(int i=0;i<10;i++){
//		t.getValueAt(i, i);
//	ausgabe.append((String) cLM.getValueAt(i, i)) ; 
//	ausgabe.append("\n"); 
//	}
	
	JScrollPane ausgabeScroll = new JScrollPane(ausgabe);
	add(ausgabeScroll);
	}
	
	
}
