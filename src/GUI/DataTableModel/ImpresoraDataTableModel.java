package GUI.DataTableModel;

import java.util.*;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;


import dominio.*;
import DAO.DepartamentoDAO;
import DAO.DispositivoDAO;
import DAO.EmpresaDAO;
import DAO.ImpresoraDAO;
import DAO.PersonaContactoDAO;


public class ImpresoraDataTableModel extends DispositivoDataTableModel<Impresora> {

	public ImpresoraDataTableModel(){
		super( new String[]{"MARCA", "MODELO"});
		dao = new ImpresoraDAO();//new ImpresoraDAO();
	}
	

		
	@Override
	public void add(Impresora o) throws Exception{

	
		
		@SuppressWarnings("rawtypes")
		Vector<Object> row = new Vector<Object>();
		row.add(o.getNumInventario());
		row.add(o.getDepartamento());
		row.add(o.getEmpresa());
		row.add(o.getPersonaContacto());
		row.add(o.getNumSerie());
		row.add(o.getFechaCompra());
		row.add(o.getFechaFinGarantia());
		row.add(o.getFechaInstalacion());
		row.add(o.getIp());
		
		
		row.add(o.getMarca());
		row.add(o.getModelo());
		
		
		
		this.addRow(row);
	}



	@Override
	public Impresora getByRowIndex(int row) {
		Impresora e = new Impresora();
		int id;
		try {
			id = (Integer) getValueAt(row, 0);
		} catch (Exception ignore) {
			id = 0;
		}
		
		{
			if(id > 0){
				e.setNumInventario(id);
			}
			
		     //Related objects
            //DepartamentoDAO dep = new DepartamentoDAO();
            {
            	e.setDepartamento((Departamento)getValueAt(row, 1));
            }
            //EmpresaDAO emp = new EmpresaDAO();
            {
            	e.setEmpresa((Empresa)getValueAt(row,2));
            }
            //PersonaContactoDAO pers = new PersonaContactoDAO();
            {
            	e.setPersonaContacto((PersonaContacto)getValueAt(row,3));
            }
			
			e.setNumSerie((String)getValueAt(row, 4));
			e.setFechaCompra((String)getValueAt(row, 5));
			e.setFechaFinGarantia((String)getValueAt(row, 6));
			e.setFechaInstalacion((String)getValueAt(row, 7));
			e.setIp((String)getValueAt(row, 8));
			
			e.setMarca((String)getValueAt(row, 9));
			e.setModelo((String)getValueAt(row, 10));
		}
		
		return  e;
	}







	
	
}
