package DAO;

import java.util.List;

import javax.jws.HandlerChain;

import dominio.*;


public class AccionAmpliacionDAO extends abstractDAO<AccionAmpliacion>{//abstractDAO<AccionBaja> {

	@Override
	public AccionAmpliacion find(Integer id) {
		return (AccionAmpliacion) find(AccionAmpliacion.class, id);
	}

	@Override
	public List<AccionAmpliacion> findAll() {
		return findAll(AccionAmpliacion.class);
	}
	

	@Override
	public void save(AccionAmpliacion accion) {
				
		Ordenador o = (Ordenador)accion.getDispositivo();
		String procesador = accion.getNuevoProcesador();
		int ram = accion.getNuevaRam();
		if(ram > 0){
			o.setRam(ram);
		}
		if(procesador.length()>0){
			o.setProcesador(procesador);
		}
		OrdenadorDAO d = new OrdenadorDAO();
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
