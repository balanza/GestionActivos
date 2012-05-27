package DAO;

import java.util.List;
import dominio.*;

public class AplicacionDAO extends abstractDAO<Aplicacion> {

	@Override
	public Aplicacion find(Integer id) {
		return find(Aplicacion.class, id);
	}

	@Override
	public List<Aplicacion> findAll() {
		return findAll(Aplicacion.class);
	}

}
