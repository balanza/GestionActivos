package GUI.DataTableModel;

import java.util.Date;
import java.util.Vector;

import DAO.AccionBajaDAO;
import DAO.AccionDAO;
import DAO.AplicacionDAO;
import DAO.DispositivoDAO;

import dominio.AccionPK;
import dominio.AccionBaja;
import dominio.Departamento;
import dominio.Dispositivo;

public class AccionBajaDataTableModel extends abstractDataTableModel<AccionBaja> {

	public AccionBajaDataTableModel() {
		super(new String[] {"NUM_SECUENCIA", "DISPOSITIVO", "FECHA", "FECHA BAJA", "DESCRIPCION"});
		dao = new AccionBajaDAO();
	}

	@Override
	public void add(AccionBaja accion) throws Exception {
		@SuppressWarnings("rawtypes")
		AccionPK pk = accion.getPrimaryKey();
		Vector<Comparable> row = new Vector<Comparable>();
		row.add(pk.getNumSecuencia());
		DispositivoDAO dao = new DispositivoDAO();
		Dispositivo disp = (Dispositivo) dao.find(pk.getNumInventario());
		row.add(disp);
		row.add(accion.getFecha());
		row.add(accion.getFechaBaja());
		row.add(accion.getDescripcion());		
		this.addRow(row);

	}

	@Override
	public AccionBaja getByRowIndex(int row) {
		AccionBaja e = new AccionBaja();
		AccionPK pk;
		int numSecuencia;
		Dispositivo dispositivo;
		try {
			numSecuencia = (Integer)getValueAt(row, 0);
			dispositivo = (Dispositivo)getValueAt(row, 1);
			pk= new AccionPK(dispositivo.getNumInventario(), numSecuencia);
		} catch (Exception ignore) {
			dispositivo = (Dispositivo)getValueAt(row, 1);
			numSecuencia = ((AccionBajaDAO)dao).getLast(dispositivo) + 1;
			pk= new AccionPK(dispositivo.getNumInventario(), numSecuencia);
		}
		
		
		{
			
			e.setPrimaryKey(pk);
			e.setFecha((Date)getValueAt(row, 2));
			e.setFechaBaja((Date)getValueAt(row, 3));
			e.setDescripcion((String)getValueAt(row, 4));
		}
		return e;
	}
	
	@Override
	public boolean isValid(AccionBaja e){
		return e.getFechaBaja() != null; 
	}

}
