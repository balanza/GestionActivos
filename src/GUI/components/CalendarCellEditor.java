package GUI.components;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import DAO.abstractDAO;

public class CalendarCellEditor extends AbstractCellEditor
		implements TableCellEditor {
	
	private JDateChooser component;
	
	public CalendarCellEditor() throws InstantiationException, IllegalAccessException{
		component = new JDateChooser();
	}
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return component.getDate();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		
		Date d = null;
		
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssZ");
			d = df.parse((String)value);
		} catch (Exception ignore) {
		}
		

		
		if(d != null){
			component.setDate(d);
			table.setValueAt((String)value, row, column);
		}
		
		
		return component;
		
	}

}
