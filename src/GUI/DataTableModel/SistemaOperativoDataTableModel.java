package GUI.DataTableModel;

import java.util.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dominio.*;
import DAO.*;


public class SistemaOperativoDataTableModel extends abstractDataTableModel<SistemaOperativo> {

	public SistemaOperativoDataTableModel(){
		super( new String[]{"ID SISTEMA OPERATIVO", "NOMBRE", "VERSION", "DESCRIPCION"});
		dao = new SistemaOperativoDAO();
	}
	

	
	
	@Override
	public void add(SistemaOperativo o) throws Exception{
	
		@SuppressWarnings("rawtypes")
		Vector<Comparable> row = new Vector<Comparable>();
		row.add(o.getId());
		row.add(o.getNombre());
		row.add(o.getVersion());
		row.add(o.getDescripcion());
		
		this.addRow(row);
	}







	@Override
	public SistemaOperativo getByRowIndex(int row) {
		SistemaOperativo e = new SistemaOperativo();
		int id;
		try {
			id = (Integer) getValueAt(row, 0);
		} catch (Exception ignore) {
			id = 0;
		}
		
		{
			if(id > 0){
				e.setIdSistemaOperativo(id);
			}

			e.setNombre((String)getValueAt(row, 1));	
			e.setVersion((String)getValueAt(row, 2));	
			e.setDescripcion((String)getValueAt(row, 3));	
		}
		
		return e;
	}



	@Override
	public boolean isValid(SistemaOperativo e){
		return e.getNombre().length() > 0;
	}
	
}
