package DAO;

import java.util.List;
import dominio.*;

public class ConfiguracionTipoDAO extends abstractDAO<ConfiguracionTipo> {

	@Override
	public ConfiguracionTipo find(Integer id) {
		return find(ConfiguracionTipo.class, id);
	}

	@Override
	public List<ConfiguracionTipo> findAll() {
		return findAll(ConfiguracionTipo.class);
	}

}
