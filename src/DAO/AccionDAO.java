package DAO;

import java.util.List;

import dominio.Accion;
import dominio.AccionBaja;

public class AccionDAO<T> extends abstractDAO<Accion> {

	@Override
	public Accion find(Integer id) {
		return find(Accion.class, id);
	}

	@Override
	public List<Accion> findAll() {
		return findAll(Accion.class);
	}


	
}
