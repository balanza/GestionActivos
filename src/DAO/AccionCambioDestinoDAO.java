package DAO;

import java.util.List;

import javax.jws.HandlerChain;

import dominio.*;


public class AccionCambioDestinoDAO extends AccionDAO<AccionCambioDestino>{//abstractDAO<AccionBaja> {

	@Override
	public AccionCambioDestino find(Integer id) {
		return (AccionCambioDestino) find(AccionCambioDestino.class, id);
	}

	@Override
	public List<AccionCambioDestino> findAll() {
		return findAll(AccionCambioDestino.class);
	}
	
	public void save (AccionCambioDestino accion){
				
		Dispositivo o = accion.getDispositivo();
		Departamento dep = accion.getDepartamento();
		o.setDepartamento(dep);
		PersonaContacto pers = accion.getContacto();
		o.setPersonaContacto(pers);
		
		
				
		super.save(accion);
		
		
	}
	
	
	
}
