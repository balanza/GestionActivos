package GUI.DataTableModel;

import java.util.Date;
import java.util.Vector;

import DAO.AccionAmpliacionDAO;
import DAO.AccionCambioDestinoDAO;
import DAO.DispositivoDAO;

import dominio.AccionAmpliacion;
import dominio.AccionCambioDestino;
import dominio.AccionPK;
import dominio.Departamento;
import dominio.Dispositivo;
import dominio.PersonaContacto;

public class AccionCambioDestinoDataTableModel extends abstractDataTableModel<AccionCambioDestino> {

	public AccionCambioDestinoDataTableModel() {
		super(new String[] {"NUM_SECUENCIA", "DISPOSITIVO", "FECHA", "NUEVO DEPARTAMENTO", "NUEVO CONTACTO", "DESCRIPCION"});
		dao = new AccionCambioDestinoDAO();
	}

	@Override
	public void add(AccionCambioDestino accion) throws Exception {
		@SuppressWarnings("rawtypes")
		AccionPK pk = accion.getPrimaryKey();
		Vector<Comparable> row = new Vector<Comparable>();
		row.add(pk.getNumSecuencia());
		DispositivoDAO dao = new DispositivoDAO();
		Dispositivo disp = (Dispositivo) dao.find(pk.getNumInventario());
		row.add(disp);
		row.add(accion.getFecha());
		row.add(accion.getDepartamento());
		row.add(accion.getContacto());
		row.add(accion.getDescripcion());		
		this.addRow(row);

	}

	@Override
	public AccionCambioDestino getByRowIndex(int row) {
		AccionCambioDestino e = new AccionCambioDestino();
		AccionPK pk;
		int numSecuencia;
		Dispositivo dispositivo;
		try {
			numSecuencia = (Integer)getValueAt(row, 0);
			dispositivo = (Dispositivo)getValueAt(row, 1);
			pk= new AccionPK(dispositivo.getNumInventario(), numSecuencia);
		} catch (Exception ignore) {
			dispositivo = (Dispositivo)getValueAt(row, 1);
			numSecuencia = ((AccionCambioDestinoDAO)dao).getLast(dispositivo) + 1;
			pk= new AccionPK(dispositivo.getNumInventario(), numSecuencia);
		}
		
		
		{
			
			e.setPrimaryKey(pk);
			e.setFecha((Date)getValueAt(row, 2));
			e.setDepartamento((Departamento)getValueAt(row, 3));
			e.setContacto((PersonaContacto)getValueAt(row, 4));			
			e.setDescripcion((String)getValueAt(row, 5));
		}
		return e;
	}
	
	@Override
	public boolean isValid(AccionCambioDestino e){
		return e.getPrimaryKey() != null && e.getDepartamento() != null && e.getContacto() != null; 
	}

}
