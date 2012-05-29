package GUI.DataTableModel;

import java.util.*;

import javax.swing.JTable;

import org.hibernate.Session;

import persistence.UtilityHibernate;


import dominio.*;
import DAO.DispositivoDAO;
import DAO.OrdenadorDAO;
import DAO.PrioridadDAO;


public class OrdenadorDataTableModel extends DispositivoDataTableModel<Ordenador> {

	public OrdenadorDataTableModel(){
		super( new String[]{"PROCESADOR","RAM", "CONFIGURACION", "APLICACIONES"});
		dao = new OrdenadorDAO();
	}
	

		
	@Override
	public void add(Ordenador o) throws Exception{

		/*Session session = UtilityHibernate.getSessionFactory().openSession();
		session.update(o);*/
		
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
		row.add(o.getPrioridad());
		row.add(o.getProcesador());
		row.add(o.getRam());		
		row.add(o.getConfiguracionTipo());		
		row.add(o.getAplicaciones());
		
		//session.close();
				
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
			
			//no todos los campos se puede editar!

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
			Prioridad p;
			try{
				PrioridadDAO dao = new PrioridadDAO();
				p = dao.find(((Prioridad) getValueAt(row, 14)).getId());
			}catch(Exception ex){
				p = null;
			}
			e.setPrioridad((Prioridad) getValueAt(row, 14));
			e.setConfiguracionTipo((ConfiguracionTipo)getValueAt(row, 17));		
			e.setAplicaciones((Set<Aplicacion>)getValueAt(row, 18));
			
		}
		
		return  e;
	}

	
	@Override
	public boolean isCellEditable(int row, int cell){
		boolean isNew = (getValueAt(row, 0)) == null;
		Integer[] notInsert = new Integer[]{0,1,2,11,15,16,18};
		Integer[] notUpdate = new Integer[]{0,5,11,15,16};
		
		return (isNew && !Arrays.asList(notInsert).contains(cell)) || (!isNew && !Arrays.asList(notUpdate).contains(cell)); 
	}


}
