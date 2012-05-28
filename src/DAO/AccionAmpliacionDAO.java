package DAO;

import java.util.List;

import javax.jws.HandlerChain;

import dominio.*;


public class AccionAmpliacionDAO extends AccionDAO<AccionAmpliacion>{//abstractDAO<AccionBaja> {

	@Override
	public AccionAmpliacion find(Integer id) {
		return (AccionAmpliacion) find(AccionAmpliacion.class, id);
	}

	@Override
	public List<AccionAmpliacion> findAll() {
		return findAll(AccionAmpliacion.class);
	}
	
	public void save (AccionAmpliacion accion){
				
		Ordenador o = (Ordenador)accion.getDispositivo();
		String procesador = accion.getNuevoProcesador();
		int ram = accion.getNuevaRam();
		if(ram > 0){
			o.setRam(ram);
		}
		if(procesador.length()>0){
			o.setProcesador(procesador);
		}
		
				
		super.save(accion);
		
		
	}
	
	
	
}
