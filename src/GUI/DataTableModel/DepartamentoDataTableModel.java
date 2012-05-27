package GUI.DataTableModel;

import java.util.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dominio.Departamento;
import dominio.Empresa;
import DAO.DepartamentoDAO;
import DAO.EmpresaDAO;


public class DepartamentoDataTableModel extends abstractDataTableModel<Departamento> {

	public DepartamentoDataTableModel(){
		super( new String[]{"CODIGO", "NOMBRE"});
		dao = new DepartamentoDAO();
	}
	

	
	
	@Override
	public void add(Departamento o) throws Exception{
	
		@SuppressWarnings("rawtypes")
		Vector<Comparable> row = new Vector<Comparable>();
		row.add(o.getId());
		row.add(o.getNombre());
		
		this.addRow(row);
	}







	@Override
	public Departamento getByRowIndex(int row) {
		Departamento e = new Departamento();
		int id;
		try {
			id = (Integer) getValueAt(row, 0);
		} catch (Exception ignore) {
			id = 0;
		}
		
		{
			if(id > 0){
				e.setCodigo(id);
			}

			e.setNombre((String)getValueAt(row, 1));	
		}
		
		return e;
	}



	@Override
	public boolean isValid(Departamento e){
		return e.getNombre().length() > 0;
	}
	
}
