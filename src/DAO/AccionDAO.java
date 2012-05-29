package DAO;

import java.util.List;

import org.hibernate.HibernateException;

import persistence.UtilityHibernate;

import dominio.Accion;
import dominio.AccionAmpliacion;
import dominio.AccionBaja;
import dominio.Dispositivo;

public class AccionDAO<T> extends abstractDAO {

	@Override 
	public T find(Integer id) { //last one
		List result = query(String.format("select top 1 * from accion a where a.numinventario = %d order by a.numsecuencia desc",  id));
		return (T) result.get(0);
	}
	
	

	@Override
	public List<T> findAll() {
		return findAll(Accion.class);
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
