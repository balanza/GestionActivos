package GUI.components;

import java.awt.Component;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


public class EntityMultipleSelectorCellRenderer extends JButton implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean arg2, boolean arg3, int arg4, int arg5) {
		
		
		String txt = "0 elementos";
		if(value != null){
			txt = ((Set)value).size() + " elementos";
		} 
		this.setText(txt);
		
		return this;
	}

}
