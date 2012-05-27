package GUI.components;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import DAO.abstractDAO;

public class EntitySingleSelectorCellEditor<T> extends AbstractCellEditor
		implements TableCellEditor {
	
	private EntitySingleSelector<T> component;
	
	public EntitySingleSelectorCellEditor(abstractDAO<T> dao) throws InstantiationException, IllegalAccessException{
		component = new EntitySingleSelector<T>(dao);
	}
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return component.getSelectedItem();
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		
		table.setValueAt(value, row, column);
		component.setSelected(value);
		return component;
		
	}

}




