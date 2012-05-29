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
import DAO.PrioridadDAO;


public class ImpresoraDataTableModel extends DispositivoDataTableModel<Impresora> {

	public ImpresoraDataTableModel(){
		super( new String[]{});
		dao = new ImpresoraDAO();//new ImpresoraDAO();
	}
	

		
	@Override
	public void add(Impresora o) throws Exception{

	
		
		@SuppressWarnings("rawtypes")
		Vector<Object> row = new Vector<Object>();
		row.add(o.getNumInventario());
		row.add(o.getMarca());
		row.add(o.getModelo());
		row.add(o.getNumSerie());
		row.add(o.getEmpresa());
		row.add(o.getDepartamento());
		row.add(o.getPersonaContacto());
		row.add(o.getFechaInstalacion());		
		row.add(o.getFechaFinGarantia());
		row.add(o.getFechaCompra());
		row.add(o.getPrecioCompra());
		row.add(o.getFechaBaja());		
		row.add(o.getIp());
		row.add(o.getObservaciones());
		Prioridad p = o.getPrioridad();
		if(p == null){
			PrioridadDAO dao = new PrioridadDAO();
			p=dao.find(0);
		}
		row.add(p);
		
		
		
		
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
			
			e.setMarca((String)getValueAt(row, 1));
			e.setModelo((String)getValueAt(row, 2));
			e.setNumSerie((String)getValueAt(row, 3));
			e.setEmpresa((Empresa)getValueAt(row,4));
			e.setDepartamento((Departamento)getValueAt(row, 5));
			e.setPersonaContacto((PersonaContacto)getValueAt(row,6));
			e.setFechaInstalacion((Date)getValueAt(row, 7));		
			e.setFechaFinGarantia((Date)getValueAt(row, 8));
			e.setFechaCompra((Date)getValueAt(row, 9));
			Float precio;
			try{
				precio = Float.parseFloat((String)getValueAt(row, 10));
			}catch(Exception ex){
				precio = (Float)getValueAt(row, 10);
			}
			e.setPrecioCompra(precio == null ? (float) 0 : precio);	
			e.setIp((String)getValueAt(row, 12));
			e.setObservaciones((String)getValueAt(row, 13));
			e.setPrioridad((Prioridad) getValueAt(row, 14));
			
		}
		
		return  e;
	}





	@Override
	public boolean isCellEditable(int row, int cell){
		boolean isNew = (getValueAt(row, 0)) == null;
		Integer[] notInsert = new Integer[]{0,11};
		Integer[] notUpdate = new Integer[]{0,5,11};
		
		return (isNew && !Arrays.asList(notInsert).contains(cell)) || (!isNew && !Arrays.asList(notUpdate).contains(cell)); 
	}


	
	
}
