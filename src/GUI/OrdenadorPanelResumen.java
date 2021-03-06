package GUI;

import dominio.Aplicacion;
import dominio.ConfiguracionTipo;
import dominio.Departamento;
import dominio.Empresa;
import dominio.Ordenador;
import dominio.PersonaContacto;
import dominio.Prioridad;
import DAO.AplicacionDAO;
import DAO.ConfiguracionTipoDAO;
import DAO.DepartamentoDAO;
import DAO.EmpresaDAO;
import DAO.PersonaContactoDAO;
import DAO.PrioridadDAO;
import GUI.DataTableModel.OrdenadorDataTableModel;
import GUI.components.CalendarCellEditor;
import GUI.components.EntityMultipleSelectorCellEditor;
import GUI.components.EntityMultipleSelectorCellRenderer;
import GUI.components.EntitySingleSelectorCellEditor;

public class OrdenadorPanelResumen extends PanelResumen<Ordenador> {

	public OrdenadorPanelResumen() {
		super(new OrdenadorDataTableModel());
	}
	
	@Override
	protected void setRenders(){
		try {
			
			
			
			datatable.getColumnModel().getColumn(5).setCellEditor(new EntitySingleSelectorCellEditor<Departamento>(new DepartamentoDAO()));
			datatable.getColumnModel().getColumn(4).setCellEditor(new EntitySingleSelectorCellEditor<Empresa>(new EmpresaDAO()));
			datatable.getColumnModel().getColumn(6).setCellEditor(new EntitySingleSelectorCellEditor<PersonaContacto>(new PersonaContactoDAO()));
			
			datatable.getColumnModel().getColumn(7).setCellEditor(new CalendarCellEditor());
			datatable.getColumnModel().getColumn(8).setCellEditor(new CalendarCellEditor());
			datatable.getColumnModel().getColumn(9).setCellEditor(new CalendarCellEditor());
			datatable.getColumnModel().getColumn(11).setCellEditor(new CalendarCellEditor());
			
			datatable.getColumnModel().getColumn(17).setCellEditor(new EntitySingleSelectorCellEditor<ConfiguracionTipo>(new ConfiguracionTipoDAO()));

			datatable.getColumnModel().getColumn(14).setCellEditor(new EntitySingleSelectorCellEditor<Prioridad>(new PrioridadDAO()));
			
			datatable.getColumnModel().getColumn(18).setCellEditor(new EntityMultipleSelectorCellEditor<Aplicacion>(new AplicacionDAO()));
			datatable.getColumnModel().getColumn(18).setCellRenderer(new EntityMultipleSelectorCellRenderer());
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
