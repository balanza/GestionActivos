package GUI;

import dominio.AccionAmpliacion;
import dominio.AccionCambioDestino;
import dominio.Aplicacion;
import dominio.DiscoMaster;
import dominio.Departamento;
import dominio.DiscoMaster;
import dominio.Dispositivo;
import dominio.Empresa;
import dominio.Ordenador;
import dominio.PersonaContacto;
import dominio.SistemaOperativo;
import DAO.AplicacionDAO;
import DAO.DepartamentoDAO;
import DAO.DiscoMasterDAO;
import DAO.DispositivoDAO;
import DAO.OrdenadorDAO;
import DAO.PersonaContactoDAO;
import DAO.SistemaOperativoDAO;
import GUI.DataTableModel.AccionAmpliacionDataTableModel;
import GUI.DataTableModel.AccionBajaDataTableModel;
import GUI.DataTableModel.AccionCambioDestinoDataTableModel;
import GUI.DataTableModel.DiscoMasterDataTableModel;
import GUI.DataTableModel.EmpresaDataTableModel;
import GUI.DataTableModel.SortedListModel;
import GUI.DataTableModel.abstractDataTableModel;
import GUI.components.CalendarCellEditor;
import GUI.components.EntityMultipleSelectorCellEditor;
import GUI.components.EntityMultipleSelectorCellRenderer;
import GUI.components.EntitySingleSelectorCellEditor;

public class AccionCambioDestinoPanelResumen extends PanelResumen<AccionCambioDestino> {


	
	public AccionCambioDestinoPanelResumen(DispositivoDAO dao) {
		super(new AccionCambioDestinoDataTableModel(), dao);
	}
	
	@Override
	protected void setRenders(){
		try {
		
			datatable.getColumnModel().getColumn(1).setCellEditor(new EntitySingleSelectorCellEditor<Dispositivo>(dao));
			datatable.getColumnModel().getColumn(2).setCellEditor(new CalendarCellEditor());
			datatable.getColumnModel().getColumn(3).setCellEditor(new EntitySingleSelectorCellEditor<Departamento>(new DepartamentoDAO()));
			datatable.getColumnModel().getColumn(4).setCellEditor(new EntitySingleSelectorCellEditor<PersonaContacto>(new PersonaContactoDAO()));
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
