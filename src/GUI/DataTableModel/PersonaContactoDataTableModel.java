package GUI.DataTableModel;

import java.util.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dominio.Departamento;
import dominio.Empresa;
import dominio.PersonaContacto;
import DAO.DepartamentoDAO;
import DAO.EmpresaDAO;
import DAO.PersonaContactoDAO;


public class PersonaContactoDataTableModel extends abstractDataTableModel<PersonaContacto> {

	public PersonaContactoDataTableModel(){
		super( new String[]{"ID CONTACTO", "NOMBRE"});
		dao = new PersonaContactoDAO();
	}
	

	
	
	@Override
	public void add(PersonaContacto o) throws Exception{
	
		@SuppressWarnings("rawtypes")
		Vector<Comparable> row = new Vector<Comparable>();
		row.add(o.getId());
		row.add(o.getNombre());
		
		this.addRow(row);
	}







	@Override
	public PersonaContacto getByRowIndex(int row) {
		PersonaContacto e = new PersonaContacto();
		int id;
		try {
			id = (Integer) getValueAt(row, 0);
		} catch (Exception ignore) {
			id = 0;
		}
		
		{
			if(id > 0){
				e.setId(id);
			}

			e.setNombre((String)getValueAt(row, 1));	
		}
		
		return e;
	}



	@Override
	public boolean isValid(PersonaContacto e){
		return e.getNombre().length() > 0;
	}
	
}
