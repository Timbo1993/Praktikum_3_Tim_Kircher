package controldeveloper;

import javax.swing.JFrame;

/**
 * View for the menu bar
 *
 */
public class ControlDeveloperView extends JFrame {
	private ControlDeveloperMenuBar cdvMB;
	
	/**
	 * constructor of the view
	 */
	public ControlDeveloperView(){
		super ("Control-Developer");
		cdvMB = new ControlDeveloperMenuBar(this);
		setJMenuBar(cdvMB);
	}
}
