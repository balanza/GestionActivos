package GUI.DataTableModel;

import java.util.Set;
import java.util.Vector;

import DAO.*;

import dominio.*;

public class DiscoMasterDataTableModel extends abstractDataTableModel<DiscoMaster> {

	public DiscoMasterDataTableModel() {
		super(new String[] {"ID","SISTEMAS", "APLICACIONES", "DESCRIPCION"});
		dao = new DiscoMasterDAO();
	}

	@Override
	public void add(DiscoMaster disco) throws Exception {
		@SuppressWarnings("rawtypes")
		Vector<Object> row = new Vector<Object>();
		row.add(disco.getIdDiscoMaster());
		row.add(disco.getSistemasOperativos());
		row.add(disco.getAplicaciones());
		row.add(disco.getDescripcion());
		
		this.addRow(row);

	}

	@Override
	public DiscoMaster getByRowIndex(int row) {
		DiscoMaster e = new DiscoMaster();
		int id;
		try {
			id = (Integer) getValueAt(row, 0);
		} catch (Exception ignore) {
			id = 0;
		}
		
		{
			if(id > 0){
				e.setIdDiscoMaster(id);
			}

			e.setSistemasOperativos((Set<SistemaOperativo>)getValueAt(row, 1));
			e.setAplicaciones((Set<Aplicacion>)getValueAt(row, 2));
			e.setDescripcion((String)getValueAt(row, 3));
			//TODO: typecheck
		}
		
		return e;
	}
	
	@Override
	public boolean isValid(DiscoMaster e){
		return true;
	}

}
