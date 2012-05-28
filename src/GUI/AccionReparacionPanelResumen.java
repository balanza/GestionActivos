package GUI;

import dominio.AccionReparacion;
import dominio.Aplicacion;
import dominio.DiscoMaster;
import dominio.Departamento;
import dominio.Dispositivo;
import dominio.Empresa;
import dominio.Ordenador;
import dominio.SistemaOperativo;
import DAO.AplicacionDAO;
import DAO.DepartamentoDAO;
import DAO.DiscoMasterDAO;
import DAO.DispositivoDAO;
import DAO.OrdenadorDAO;
import DAO.SistemaOperativoDAO;
import GUI.DataTableModel.AccionAmpliacionDataTableModel;
import GUI.DataTableModel.AccionBajaDataTableModel;
import GUI.DataTableModel.AccionReparacionDataTableModel;
import GUI.DataTableModel.DiscoMasterDataTableModel;
import GUI.DataTableModel.EmpresaDataTableModel;
import GUI.DataTableModel.SortedListModel;
import GUI.DataTableModel.abstractDataTableModel;
import GUI.components.CalendarCellEditor;
import GUI.components.EntityMultipleSelectorCellEditor;
import GUI.components.EntityMultipleSelectorCellRenderer;
import GUI.components.EntitySingleSelectorCellEditor;

public class AccionReparacionPanelResumen extends PanelResumen<AccionReparacion> {


	
	public AccionReparacionPanelResumen(DispositivoDAO dao) {
		super(new AccionReparacionDataTableModel(), dao);
	}
	
	@Override
	protected void setRenders(){
		try {
		
			datatable.getColumnModel().getColumn(1).setCellEditor(new EntitySingleSelectorCellEditor<Dispositivo>(dao));
			datatable.getColumnModel().getColumn(2).setCellEditor(new CalendarCellEditor());
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
