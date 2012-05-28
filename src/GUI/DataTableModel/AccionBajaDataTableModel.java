package GUI.DataTableModel;

import java.sql.Date;
import java.util.Vector;

import DAO.AccionBajaDAO;
import DAO.AplicacionDAO;

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
		row.add(pk.getNumInventario());
		row.add(accion.getFecha());
		row.add(accion.getFechaBaja());
		row.add(accion.getDescripcion());		
		this.addRow(row);

	}

	@Override
	public AccionBaja getByRowIndex(int row) {
		AccionBaja e = new AccionBaja();
		AccionPK pk;
		try {
			int numSecuencia = (Integer)getValueAt(row, 0);
			Dispositivo dispositivo = (Dispositivo)getValueAt(row, 1);
			pk= new AccionPK(dispositivo.getNumInventario(), numSecuencia);
		} catch (Exception ignore) {
			pk=null;
		}
		
		
		{
			if(pk != null){
				e.setPrimaryKey(pk);
			}
	
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
