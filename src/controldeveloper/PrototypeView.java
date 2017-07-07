package controldeveloper;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;

import controlmodel.ControlModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 * 
 * View of the Prototypes of the {@link Commands}
 *
 */
public class PrototypeView extends JPanel{
	private PrototypeListModel lM=null;
	private	JList<String> l = new JList<String>();
	private JButton add =new JButton("add");
	

/**
 * 
 * Constructor of {@link PrototypeView}
 * {@param pLM} Model of the {@link PrototypeListModel}
 */
	public PrototypeView (PrototypeListModel pLM){
		lM=pLM;
		l.setListData(lM.getItems());
		setLayout(new BorderLayout());
		
		l.setSelectionForeground( Color.gray );		//schriftfarbe
	    l.setSelectionBackground( Color.orange );	//Hintergrund
	    //l.setSelectedIndex( 0 );					
			
	    add(l);
		
		l.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane sP =new JScrollPane(l, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JLabel label=new JLabel("Prototypes", JLabel.CENTER);
		label.setFont(label.getFont().deriveFont(Font.ITALIC));
		
		//l.setMinimumSize(minimumSize());
	/**
	 * Action Listener of the Add Button
	 * Adds the selected Item of the ListModel {@param lM} to the {@param aTM} Table model
	 */
		add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if ((lM.setSelectedItem(l.getSelectedIndex()).equals("Direction")))	{
					CommandListView.aTM.list.add(ControlModel.getInstance().getCommandTypes()[0].createInstance());
				}
				
				else if ((lM.setSelectedItem(l.getSelectedIndex()).equals("Gear")))	{
					CommandListView.aTM.list.add(ControlModel.getInstance().getCommandTypes()[1].createInstance());
				}
				
				else if ((lM.setSelectedItem(l.getSelectedIndex()).equals("Repetition")))	{
					CommandListView.aTM.list.add(ControlModel.getInstance().getCommandTypes()[2].createInstance());
				}
				
				else if ((lM.setSelectedItem(l.getSelectedIndex()).equals("Pause")))	{
					CommandListView.aTM.list.add(ControlModel.getInstance().getCommandTypes()[3].createInstance());
				}
				
				CommandListView.aTM.fireTableDataChanged();
				ControlModel.getInstance().getControlProcess().printCommandList();
				System.out.println(ControlModel.getInstance().getControlProcess().getLength());
			}
		});
		
		JPanel p1=new JPanel (new FlowLayout(FlowLayout.RIGHT));
		p1.add(add);
		
	
		//header bleibt beim scrollen immer sichtbar
			JViewport header = new JViewport();
			header.setView(label);
			sP.setColumnHeader(header);
	
			add(sP, BorderLayout.CENTER);
			add(p1, BorderLayout.SOUTH);
	}
}