package GUI.components;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import DAO.abstractDAO;
import GUI.VentanaDualList;
import GUI.DataTableModel.SortedListModel;

public class EntityMultipleSelectorCellEditor<T> extends AbstractCellEditor
		implements TableCellEditor {
	
	private JButton component;
	private VentanaDualList<T> ventana;
	public abstractDAO<T> dao;
	
	public EntityMultipleSelectorCellEditor(abstractDAO<T> dao, SortedListModel initial) throws InstantiationException, IllegalAccessException{
		component = new JButton();
		ventana = new VentanaDualList<T>(dao, initial);
		component.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e){
				ventana.setLocationRelativeTo(null);
				ventana.setVisible(true);	
				
			}
		});
		
		setText(initial.getSize() + " elementos");
	}
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return ventana.getSelectedList();
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		
		table.setValueAt(value, row, column);
		return component;
		
	}
	
	
	public void setText(String text){
		component.setText(text);
	}

}




