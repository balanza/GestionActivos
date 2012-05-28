package DAO;

import java.util.List;

import javax.jws.HandlerChain;

import dominio.*;


public class AccionBajaDAO extends AccionDAO<AccionBaja>{//abstractDAO<AccionBaja> {

	@Override
	public AccionBaja find(Integer id) {
		return (AccionBaja) find(AccionBaja.class, id);
	}

	@Override
	public List<AccionBaja> findAll() {
		return findAll(AccionBaja.class);
	}
	
	public void save (AccionBaja accion){
				
		//accion.getDispositivo().setFechaBaja(accion.getFechaBaja());
		
		super.save(accion);
		
		
	}
	
	
	
}
