package DAO;

import java.util.List;

import javax.jws.HandlerChain;

import dominio.*;


public class AccionReparacionDAO extends AccionDAO<AccionReparacion>{//abstractDAO<AccionBaja> {

	@Override
	public AccionReparacion find(Integer id) {
		return (AccionReparacion) find(AccionReparacion.class, id);
	}

	@Override
	public List<AccionReparacion> findAll() {
		return findAll(AccionReparacion.class);
	}
	
	
	
	
	
}
