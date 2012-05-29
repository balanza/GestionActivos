package GUI.DataTableModel;

import java.util.Arrays;
import java.util.Date;
import java.util.Vector;

import DAO.AccionAmpliacionDAO;
import DAO.DispositivoDAO;

import dominio.AccionAmpliacion;
import dominio.AccionPK;
import dominio.Dispositivo;

public class AccionAmpliacionDataTableModel extends abstractDataTableModel<AccionAmpliacion> {

	public AccionAmpliacionDataTableModel() {
		super(new String[] {"NUM_SECUENCIA", "DISPOSITIVO", "FECHA", "NUEVA RAM", "NUEVO PROCESADOR", "DESCRIPCION"});
		dao = new AccionAmpliacionDAO();
	}

	@Override
	public void add(AccionAmpliacion accion) throws Exception {
		@SuppressWarnings("rawtypes")
		AccionPK pk = accion.getPrimaryKey();
		Vector<Comparable> row = new Vector<Comparable>();
		row.add(pk.getNumSecuencia());
		DispositivoDAO dao = new DispositivoDAO();
		Dispositivo disp = (Dispositivo) dao.find(pk.getNumInventario());
		row.add(disp);
		row.add(accion.getFecha());
		row.add(accion.getNuevaRam());
		row.add(accion.getNuevoProcesador());
		row.add(accion.getDescripcion());		
		this.addRow(row);

	}

	@Override
	public AccionAmpliacion getByRowIndex(int row) {
		AccionAmpliacion e = new AccionAmpliacion();
		AccionPK pk;
		int numSecuencia;
		Dispositivo dispositivo;
		try {
			numSecuencia = (Integer)getValueAt(row, 0);
			dispositivo = (Dispositivo)getValueAt(row, 1);
			pk= new AccionPK(dispositivo.getNumInventario(), numSecuencia);
		} catch (Exception ignore) {
			dispositivo = (Dispositivo)getValueAt(row, 1);
			numSecuencia = ((AccionAmpliacionDAO)dao).getLast(dispositivo) + 1;
			pk= new AccionPK(dispositivo.getNumInventario(), numSecuencia);
		}
		
		
		{
			
			e.setPrimaryKey(pk);
			e.setFecha((Date)getValueAt(row, 2));
			Integer ram;
			try{
				ram = Integer.parseInt(((String)getValueAt(row, 3)).trim());
			}catch(Exception ignore){
				ram = (Integer)getValueAt(row, 3);
			}
			e.setNuevaRam(ram == null ? 0 : ram);
			e.setNuevoProcesador((String)getValueAt(row, 4));
			e.setDescripcion((String)getValueAt(row, 5));
		}
		return e;
	}
	
	@Override
	public boolean isValid(AccionAmpliacion e){
		return e.getPrimaryKey() != null && (e.getNuevaRam()>0 || e.getNuevoProcesador().length()>0); 
	}

	
	@Override
	public boolean isCellEditable(int row, int cell){
		return (getValueAt(row, 0)) == null; 
	}
}
