package GUI;

import dominio.ConfiguracionTipo;
import dominio.Departamento;
import dominio.DiscoMaster;
import dominio.Empresa;
import DAO.DepartamentoDAO;
import DAO.DiscoMasterDAO;
import GUI.DataTableModel.ConfiguracionTipoDataTableModel;
import GUI.DataTableModel.EmpresaDataTableModel;
import GUI.DataTableModel.abstractDataTableModel;
import GUI.components.CalendarCellEditor;
import GUI.components.EntitySingleSelectorCellEditor;

public class ConfiguracionTipoPanelResumen extends PanelResumen<ConfiguracionTipo> {

	public ConfiguracionTipoPanelResumen() {
		super(new ConfiguracionTipoDataTableModel());
	}
	
	@Override
	protected void setRenders(){
		try {
			datatable.getColumnModel().getColumn(5).setCellEditor(new EntitySingleSelectorCellEditor<DiscoMaster>(new DiscoMasterDAO()));
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
