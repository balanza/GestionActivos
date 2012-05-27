package GUI.DataTableModel;

import java.util.Vector;

import DAO.AplicacionDAO;

import dominio.Aplicacion;
import dominio.Departamento;

public class AplicacionDataTableModel extends abstractDataTableModel<Aplicacion> {

	public AplicacionDataTableModel() {
		super(new String[] {"ID_APLICACION", "NOMBRE", "VERSION"});
		dao = new AplicacionDAO();
	}

	@Override
	public void add(Aplicacion app) throws Exception {
		@SuppressWarnings("rawtypes")
		Vector<Comparable> row = new Vector<Comparable>();
		row.add(app.getIdAplicacion());
		row.add(app.getNombre());
		row.add(app.getVersion());
		
		this.addRow(row);

	}

	@Override
	public Aplicacion getByRowIndex(int row) {
		Aplicacion e = new Aplicacion();
		int id;
		try {
			id = (Integer) getValueAt(row, 0);
		} catch (Exception ignore) {
			id = 0;
		}
		
		{
			if(id > 0){
				e.setIdAplicacion(id);
			}

			e.setNombre((String)getValueAt(row, 1));	
			e.setVersion((String)getValueAt(row, 2));
		}
		
		return e;
	}
	
	@Override
	public boolean isValid(Aplicacion e){
		return e.getNombre().length() > 0;
	}

}
