package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.TableModel;

import org.jdesktop.application.Application;

import GUI.DataTableModel.abstractDataTableModel;

public abstract class PanelData<T> extends javax.swing.JPanel {

	protected JTable datatable;
	protected JToolBar toolbar;

	
	
	
	public PanelData(abstractDataTableModel<T> tm) {
		super();
		try{
		initGUI();
		setDataTableModel(tm);
		tm.refresh();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	


	private void initGUI() {
		try {
			
			BorderLayout thisLayout = new BorderLayout();
			this.setLayout(thisLayout);
			setPreferredSize(new Dimension(900, 400));
			
			{
				toolbar = new JToolBar();
				this.add(toolbar, BorderLayout.NORTH);
				toolbar.setName("jToolBar1");
			}
			{
				datatable = new JTable();
				this.add(new JScrollPane(datatable), BorderLayout.CENTER);
				
			}

			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(this);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void setDataTableModel(TableModel tm){
		datatable.setModel(tm);		
	} 
	
	
	
	
	
}
