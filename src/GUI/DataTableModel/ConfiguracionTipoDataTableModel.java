package GUI.DataTableModel;

import java.util.Vector;

import DAO.*;

import dominio.*;

public class ConfiguracionTipoDataTableModel extends abstractDataTableModel<ConfiguracionTipo> {

	public ConfiguracionTipoDataTableModel() {
		super(new String[] {"ID", "MARCA", "MODELO", "PROCESADOR", "RAM", "DISCOMASTER"});
		dao = new ConfiguracionTipoDAO();
	}

	@Override
	public void add(ConfiguracionTipo app) throws Exception {
		@SuppressWarnings("rawtypes")
		Vector<Object> row = new Vector<Object>();
		row.add(app.getIdConfiguracionTipo());
		row.add(app.getMarca().trim());
		row.add(app.getModelo().trim());
		row.add(app.getProcesador().trim());
		row.add(app.getRam());
		row.add( app.getDiscoMaster());
		
		this.addRow(row);

	}

	@Override
	public ConfiguracionTipo getByRowIndex(int row) {
		ConfiguracionTipo e = new ConfiguracionTipo();
		int id;
		try {
			id = (Integer) getValueAt(row, 0);
		} catch (Exception ignore) {
			id = 0;
		}
		
		{
			if(id > 0){
				e.setIdConfiguracionTipo(id);
			}

			e.setMarca((String)getValueAt(row, 1));
			e.setModelo((String)getValueAt(row, 2));
			e.setProcesador((String)getValueAt(row, 3));
			int ram;
			try{
				ram = (Integer)getValueAt(row, 4);
			}catch(Exception ignore){
				ram = 0;
			}
			e.setRam(ram);
			e.setDiscoMaster((DiscoMaster) getValueAt(row, 5));
			//TODO: typecheck
		}
		
		return e;
	}
	
	@Override
	public boolean isValid(ConfiguracionTipo e){
		return e.getMarca().length() > 0 && e.getModelo().length()>0 && e.getProcesador().length() > 0 && e.getRam()>0;
	}

}
