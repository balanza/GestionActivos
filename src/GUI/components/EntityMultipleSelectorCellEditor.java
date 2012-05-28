package GUI.components;

import java.awt.Component;
import java.util.*;

import javax.swing.AbstractCellEditor;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;


import DAO.abstractDAO;
import GUI.DataTableModel.SortedListModel;

public class EntityMultipleSelectorCellEditor<T> extends AbstractCellEditor
		implements TableCellEditor {
	
	private EntityMultipleSelector<T> popup;
	private abstractDAO<T> dao;
	
	public EntityMultipleSelectorCellEditor(abstractDAO<T> dao) throws InstantiationException, IllegalAccessException {

		this.dao = dao;
		popup = new EntityMultipleSelector(dao, new SortedListModel());
	}
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return popup.getSelectedList();
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		
		table.setValueAt(value, row, column);
		
		SortedListModel slm = new SortedListModel();
		if(value != null){
			for(Object o: (Set)value){
				slm.add(o);
			}			
		}
		
		try {
			popup = new EntityMultipleSelector(dao, slm);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		popup.setLocationRelativeTo(null);
		popup.setVisible(true);
		
		return new JLabel("...");
		
	}
	
	

}




