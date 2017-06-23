package controldeveloper;

import javax.swing.JFrame;

public class ControlDeveloperView extends JFrame {
	private ControlDeveloperMenuBar cdvMB;
	
	public ControlDeveloperView(){
		super ("Control-Developer");
		cdvMB = new ControlDeveloperMenuBar(this);
		setJMenuBar(cdvMB);
	}
}
