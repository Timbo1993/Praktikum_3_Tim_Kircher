package controldeveloper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class ControlDeveloperMenuBar extends JMenuBar implements ActionListener, MenuListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ControlDeveloperView	cdv = null;
	JMenu					m	= null;
	JMenuItem				mI	= null;
	
	public ControlDeveloperMenuBar(ControlDeveloperView cdv){
		this.cdv = cdv;
		
		//erstes Menü
		m = new JMenu("File");
		
		mI = new JMenuItem("Save");
		mI.setActionCommand("Save");
		mI.addActionListener(this);
		m.add(mI);
		m.addSeparator();
		
		mI = new JMenuItem("Load");
		mI.setActionCommand("Load");
		mI.addActionListener(this);
		m.add(mI);
		this.add(m);
		
		//zweites Menü
		m = new JMenu("Help");
		mI = new JMenuItem("About <programmname>");
		mI.setActionCommand("About <programmname>");
		mI.addActionListener(this);
		m.add(mI);
		this.add(m);
		
	}
	
	@Override
	public void menuCanceled(MenuEvent arg0) {}

	@Override
	public void menuDeselected(MenuEvent arg0) {}

	@Override
	public void menuSelected(MenuEvent arg0) {}

	@Override
	public void actionPerformed(ActionEvent e) {}

}
