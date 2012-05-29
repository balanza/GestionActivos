package DAO;

import java.util.List;

import javax.jws.HandlerChain;

import dominio.*;


public class AccionBajaDAO extends AccionDAO<AccionBaja>{//abstractDAO<AccionBaja> {


	@Override 
	public AccionBaja find(Integer id) { //last one
		List result = query(String.format("from AccionBaja a where a.numInventario = %d order by a.numSecuencia desc",  id));
		return (AccionBaja) result.get(0);
	}
	@Override
	public List<AccionBaja> findAll() {
		return findAll(AccionBaja.class);
	}
	
	public AccionBaja find(Integer secuencia, Integer inventario){
		List result = query(String.format("from accionbaja b where numsecuencia = %d and numinventario = %d", secuencia , inventario));
		return (AccionBaja) result.get(0);
	}
	
	public void save (AccionBaja accion){
				
		//accion.getDispositivo().setFechaBaja(accion.getFechaBaja());
		
		super.save(accion);
		
		
	}
	
	
	
}
