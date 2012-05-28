package GUI.components;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import org.jdesktop.application.Application;

import dominio.*;

import DAO.abstractDAO;
import GUI.*;
import GUI.DataTableModel.*;

import javax.swing.*;
 import DAO.*;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class EntityMultipleSelector<T> extends JFrame {
	private abstractDAO<T> dao;
	private SortedListModel initial;
	
	private DualListBox dualList;

	public EntityMultipleSelector(abstractDAO<T> dao, SortedListModel initial) throws InstantiationException, IllegalAccessException{		
		this.dao = dao;
		this.initial = initial;
	
		
		initGUI();
		
	}
	
	public Set<T> getSelectedList(){
		Set<T> list = new HashSet<T>();
		SortedListModel model = dualList.getDestinationList();
		for(int i=0; i<model.getSize(); i++){
			list.add((T) model.getElementAt(i));			
		}
		
		return list;
	}
	
		
	private void initGUI() {
		try {
			{
				dualList = new DualListBox();
				getContentPane().add(dualList, BorderLayout.CENTER);
				
				this.dualList.setDestinationElements(initial);
				SortedListModel filtered = new SortedListModel();
				for(T o: dao.findAll()){
					if(!initial.contains(o)){
						filtered.add(o);				
					}			
				}
				this.dualList.setSourceElements(filtered);

				this.setSize(500, 300);

				pack();
				//this.setSize(900, 400);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
