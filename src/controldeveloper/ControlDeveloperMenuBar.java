package controldeveloper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Class for the Menu of the GUI
 *
 */
public class ControlDeveloperMenuBar extends JMenuBar implements ActionListener, MenuListener {

//	private static final long serialVersionUID = 1L;
	ControlDeveloperView	cdv = null;
	JMenu					m	= null;
	JMenuItem				mI	= null;
	File f = new File("D:/beispiel.txt");

	/**
	 * Consturctor of ControlDeveloperMenuBar
	 */
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
		
		m = new JMenu("Port");
		mI = new JMenuItem("toFile");
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

	/**
	 * Registers which menu item was selected and performs the action
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem mI = (JMenuItem) e.getSource();
		if(mI.getActionCommand().equals("Save")){
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Textfiles", "txt");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showSaveDialog(cdv);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		       
		       String path = chooser.getCurrentDirectory().getAbsolutePath()+
		    		   "/"+chooser.getSelectedFile().getName() + ".txt";
		       File f = new File(path);
		       ControlModel.getInstance().save(f);
		       AusgabeView.addText("Sucessfully saved: '"+path+"'");
		       
		    }
			
			ControlModel.getInstance().save(f);
			ControlModel.getInstance().getControlProcess().clearCommandList();
			CommandListView.aTM.fireTableDataChanged();
		}
		else if(mI.getActionCommand().equals("Load")){
			JFileChooser chooser = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		            "Textfiles", "txt");
		        chooser.setFileFilter(filter);
		    int returnVal = chooser.showOpenDialog(cdv);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		    	String path = chooser.getCurrentDirectory().getAbsolutePath()+
			    		   "/"+chooser.getSelectedFile().getName();
			       File f = new File(path);
			       ControlModel.getInstance().load(f);
			       AusgabeView.addText("Successfully saved: '"+path+"'");
		    }
			
			
			ControlModel.getInstance().load(f);
			CommandListView.aTM.fireTableDataChanged();
			ControlModel.getInstance().getControlProcess().printCommandList();
		}

		else if(mI.getActionCommand().equals("About <programmname>")){
			System.out.println("about");

		}
		else if(mI.getActionCommand().equals("toFile")){
			
		}
	}
	
}
