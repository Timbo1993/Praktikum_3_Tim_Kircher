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

	static JTextArea ausgabe = new JTextArea(5,20);
	static JScrollPane ausgabeScroll = new JScrollPane(ausgabe);

	
	
	public AusgabeView(){
		
		setLayout(new BorderLayout());
	
		ausgabe.setEditable(false);
		ausgabe.setLineWrap(true);
		ausgabe.setWrapStyleWord(true);
		add(ausgabeScroll);
//		for(int i=0;i<10;i++){
//		t.getValueAt(i, i);
//		ausgabe.append((String) cLM.getValueAt(i, i)) ; 
//		ausgabe.append("\n"); 
//	}
	}
	
	/**
	 * 
	 * Adds the @param s to the TextArea 
	 */
	public static void addText(String s){
		ausgabe.append(s+"\n");
		ausgabeScroll.getVerticalScrollBar().setValue(ausgabeScroll.getVerticalScrollBar().getMaximum()+1);
	}
	
}
