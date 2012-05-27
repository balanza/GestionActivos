package GUI.components;

import java.awt.Component;
import java.util.EventObject;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import persistence.IEntity;

import DAO.abstractDAO;

public class EntitySingleSelector<T> extends JComboBox implements TableCellRenderer{

	private abstractDAO<T> dao;

	
	public EntitySingleSelector(abstractDAO<T> dao) throws InstantiationException, IllegalAccessException{		
		this.dao = dao;		
		load();
	}
	
	private void load(){
		removeAllItems();
		List<T> l = dao.findAll();
		for(T i: l){
			IEntity entity = (IEntity)i;
			addItem(entity);
		}
		
	}
	
	public void setSelected(Object value){
		for(int i=0; i<getItemCount(); i++){
			if(value == getItemAt(i)){
				setSelectedIndex(i);
				return;
			}
		}
		
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		// TODO Auto-generated method stub
		return this;
	}
	
	
	
}


