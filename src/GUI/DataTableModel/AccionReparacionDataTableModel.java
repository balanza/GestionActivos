package GUI.DataTableModel;

import java.util.Date;
import java.util.Vector;

import DAO.AccionAmpliacionDAO;
import DAO.AccionReparacionDAO;
import DAO.DispositivoDAO;

import dominio.AccionAmpliacion;
import dominio.AccionPK;
import dominio.AccionReparacion;
import dominio.Dispositivo;

public class AccionReparacionDataTableModel extends abstractDataTableModel<AccionReparacion> {

	public AccionReparacionDataTableModel() {
		super(new String[] {"NUM_SECUENCIA", "DISPOSITIVO", "FECHA", "DESCRIPCION"});
		dao = new AccionReparacionDAO();
	}

	@Override
	public void add(AccionReparacion accion) throws Exception {
		@SuppressWarnings("rawtypes")
		AccionPK pk = accion.getPrimaryKey();
		Vector<Comparable> row = new Vector<Comparable>();
		row.add(pk.getNumSecuencia());
		DispositivoDAO dao = new DispositivoDAO();
		Dispositivo disp = (Dispositivo) dao.find(pk.getNumInventario());
		row.add(disp);
		row.add(accion.getFecha());
		row.add(accion.getDescripcion());		
		this.addRow(row);

	}

	@Override
	public AccionReparacion getByRowIndex(int row) {
		AccionReparacion e = new AccionReparacion();
		AccionPK pk;
		int numSecuencia;
		Dispositivo dispositivo;
		try {
			numSecuencia = (Integer)getValueAt(row, 0);
			dispositivo = (Dispositivo)getValueAt(row, 1);
			pk= new AccionPK(dispositivo.getNumInventario(), numSecuencia);
		} catch (Exception ignore) {
			dispositivo = (Dispositivo)getValueAt(row, 1);
			numSecuencia = ((AccionReparacionDAO)dao).getLast(dispositivo) + 1;
			pk= new AccionPK(dispositivo.getNumInventario(), numSecuencia);
		}
		
		
		{
			
			e.setPrimaryKey(pk);
			e.setFecha((Date)getValueAt(row, 2));
			e.setDescripcion((String)getValueAt(row, 3));
		}
		return e;
	}
	
	@Override
	public boolean isValid(AccionReparacion e){
		return e.getPrimaryKey() != null;
	}


	@Override
	public boolean isCellEditable(int row, int cell){
		return (getValueAt(row, 0)) == null; 
	}
	
}
