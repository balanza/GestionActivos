package DAO;

import java.util.List;
import dominio.Empresa;
import dominio.Prioridad;

public class PrioridadDAO extends abstractDAO<Prioridad> {

	@Override
	public Prioridad find(Integer id) {
		return find(Prioridad.class, id);
	}

	@Override
	public List<Prioridad> findAll() {
		return findAll(Prioridad.class);
	}

	
	
}
