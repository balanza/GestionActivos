package DAO;

import java.util.List;

import javax.jws.HandlerChain;

import dominio.*;


public class AccionCambioDestinoDAO extends abstractDAO<AccionCambioDestino>{//abstractDAO<AccionBaja> {

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
		
		DispositivoDAO d = new DispositivoDAO();
		d.update(o);
				
		super.save(accion);
		
		
	}
	
	//ultima accion por un dispositivo concreto
	public int getLast(Dispositivo d){
		List result = query("select cast(max(numSecuencia) as integer) from Accion where numInventario="+ d.getNumInventario());
		
		if(result != null && result.get(0) != null){
			return (Integer)(result.get(0));
		} else {
			return 0;
		}
	}

	
	
	
}
