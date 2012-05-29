package GUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;

import javax.swing.JTable;
import javax.swing.JToolBar;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.internal.ScrollableResultsImpl;
import org.jdesktop.application.Application;

import persistence.IEntity;

import javax.swing.SwingUtilities;

import DAO.DepartamentoDAO;
import DAO.EmpresaDAO;
import DAO.PersonaContactoDAO;
import DAO.abstractDAO;
import GUI.DataTableModel.DispositivoDataTableModel;
import GUI.DataTableModel.EmpresaDataTableModel;
import GUI.DataTableModel.ImpresoraDataTableModel;
import GUI.DataTableModel.OrdenadorDataTableModel;
import GUI.DataTableModel.abstractDataTableModel;
import GUI.components.CalendarCellEditor;
import GUI.components.DateReportDialog;
import GUI.components.EntitySingleSelector;
import GUI.components.EntitySingleSelectorCellEditor;

import com.cloudgarden.layout.AnchorLayout;

import dominio.Departamento;
import dominio.Dispositivo;
import dominio.Empresa;
import dominio.PersonaContacto;

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
public class PanelResumen<T> extends PanelData<T> {
	private JButton addButton;
	private JButton saveButton;
	private JButton saveAllButton;
	private JButton reportBajaButton;
	private JButton refreshButton;
	protected abstractDAO dao;

		

	
	public PanelResumen(abstractDataTableModel<T> tm, abstractDAO dao) {
		super(tm);
		this.dao = dao;
		initGUI();
	}

	public PanelResumen(abstractDataTableModel<T> tm) {
		super(tm);
		this.dao = null;
		initGUI();
	}
	


	private void initGUI() {
		try {
			
			{
				addButton = new JButton("añadir");
				toolbar.add(addButton);
				addButton.setName("addButton");
				addButton.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e){
						abstractDataTableModel<T> model = (abstractDataTableModel<T>)datatable.getModel();
						model.appendEmptyRow();
								
						model.fireTableDataChanged();
					}
				});
			}
			//toolbar.add(new JSeparator());
			{
				saveButton = new JButton("guardar");
				toolbar.add(saveButton);
				saveButton.setName("saveButton");
				saveButton.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e){
						//save the selected record
						@SuppressWarnings("unchecked")
						abstractDataTableModel<T> tm = (abstractDataTableModel<T>)datatable.getModel();
						tm.saveRow(datatable.getSelectedRow() );						
					}
				});
			}
			{
				saveAllButton = new JButton("guardar todos");
				toolbar.add(saveAllButton);
				saveAllButton.setName("saveAllButton");
				saveAllButton.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e){
						//save the selected record
						@SuppressWarnings("unchecked")
						abstractDataTableModel<T> model = (abstractDataTableModel<T>)datatable.getModel();
						model.saveAllRow();						
					}
				});
			}
			//toolbar.add(new JSeparator());
			/*{
				delButton = new JButton("borrar");
				toolbar.add(delButton);
				delButton.setName("delButton");
				delButton.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e){
						abstractDataTableModel<T> model = (abstractDataTableModel<T>)datatable.getModel();
						model.deleteByRowIndex(datatable.getSelectedRow());
						model.refresh();		
						model.fireTableDataChanged();
					}
				});
			}*/
			//toolbar.add(new JSeparator());
			{
				refreshButton = new JButton("actualizar");
				toolbar.add(refreshButton);
				refreshButton.setName("refreshButton");
				refreshButton.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e){
						//TODO: controllare che non ci siano dati da salvare
						abstractDataTableModel<T> model = (abstractDataTableModel<T>)datatable.getModel();
						model.refresh();		
						model.fireTableDataChanged();
					}
				});
			}
			
			
			
			//customize cell render
			setRenders();
			

			Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(this);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	protected void setRenders(){}
	



}



