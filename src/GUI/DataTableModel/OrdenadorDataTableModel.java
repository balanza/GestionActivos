package GUI.DataTableModel;

import java.util.*;

import javax.swing.JTable;

import org.hibernate.Session;

import persistence.UtilityHibernate;


import dominio.*;
import DAO.DispositivoDAO;
import DAO.OrdenadorDAO;


public class OrdenadorDataTableModel extends DispositivoDataTableModel<Ordenador> {

	public OrdenadorDataTableModel(){
		super( new String[]{});
		dao = new OrdenadorDAO();//new ImpresoraDAO();
	}
	

		
	@Override
	public void add(Ordenador o) throws Exception{

		Session session = UtilityHibernate.getSessionFactory().openSession();
		session.update(o);
		
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
		
		session.close();
		
		
		
		
		this.addRow(row);
	}

	@Override
	public Ordenador getByRowIndex(int row) {
		Ordenador e = new Ordenador();
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
			
		}
		
		return  e;
	}



}
