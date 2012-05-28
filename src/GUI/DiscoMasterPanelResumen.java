package GUI;

import dominio.Aplicacion;
import dominio.DiscoMaster;
import dominio.Departamento;
import dominio.DiscoMaster;
import dominio.Empresa;
import dominio.SistemaOperativo;
import DAO.AplicacionDAO;
import DAO.DepartamentoDAO;
import DAO.DiscoMasterDAO;
import DAO.SistemaOperativoDAO;
import GUI.DataTableModel.DiscoMasterDataTableModel;
import GUI.DataTableModel.EmpresaDataTableModel;
import GUI.DataTableModel.SortedListModel;
import GUI.DataTableModel.abstractDataTableModel;
import GUI.components.CalendarCellEditor;
import GUI.components.EntityMultipleSelectorCellEditor;
import GUI.components.EntityMultipleSelectorCellRenderer;
import GUI.components.EntitySingleSelectorCellEditor;

public class DiscoMasterPanelResumen extends PanelResumen<DiscoMaster> {

	public DiscoMasterPanelResumen() {
		super(new DiscoMasterDataTableModel());
	}
	
	@Override
	protected void setRenders(){
		try {
			datatable.getColumnModel().getColumn(1).setCellEditor(new EntityMultipleSelectorCellEditor<SistemaOperativo>(new SistemaOperativoDAO()));
			datatable.getColumnModel().getColumn(1).setCellRenderer(new EntityMultipleSelectorCellRenderer());
			datatable.getColumnModel().getColumn(2).setCellEditor(new EntityMultipleSelectorCellEditor<Aplicacion>(new AplicacionDAO()));
			datatable.getColumnModel().getColumn(2).setCellRenderer(new EntityMultipleSelectorCellRenderer());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
