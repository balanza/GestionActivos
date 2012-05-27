package GUI.DataTableModel;

import java.util.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dominio.Empresa;
import DAO.EmpresaDAO;


public class EmpresaDataTableModel extends abstractDataTableModel<Empresa> {

	public EmpresaDataTableModel(){
		super( new String[]{"ID EMPRESA", "NOMBRE", "DIRECCION", "POBLACION", "TELEFONO", "EMAIL"});
		dao = new EmpresaDAO();
	}
	

	
	
	@Override
	public void add(Empresa o) throws Exception{
		if(!(o instanceof Empresa)){
			throw new Exception("Expected object of type Empresa");
		}
		Empresa e = (Empresa) o;
		@SuppressWarnings("rawtypes")
		Vector<Comparable> row = new Vector<Comparable>();
		row.add(e.getId());
		row.add(e.getNombre());
		row.add(e.getDireccion());
		row.add(e.getPoblacion());
		row.add(e.getTelefono());
		row.add(e.getEmail());
		
		this.addRow(row);
	}







	@Override
	public Empresa getByRowIndex(int row) {
		Empresa e = new Empresa();
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
			e.setDireccion((String)getValueAt(row, 2));
			e.setPoblacion((String)getValueAt(row, 3));
			e.setTelefono((String)getValueAt(row, 4));
			e.setEmail((String)getValueAt(row, 5));			
		}
		
		return e;
	}



	@Override
	public boolean isValid(Empresa e){
		return e.getNombre().length() > 0;
	}
	
}
