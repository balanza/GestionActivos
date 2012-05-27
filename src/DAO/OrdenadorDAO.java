package DAO;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import dominio.Aplicacion;
import dominio.ConfiguracionTipo;
import dominio.Ordenador;

public class OrdenadorDAO extends DispositivoDAO<Ordenador> {

	@Override
	public Ordenador find(Integer id) {
		return find(Ordenador.class, id);
	}

	@Override
	public List<Ordenador> findAll() {
		return findAll(Ordenador.class);
	}
	
	@Override
	public void save(Ordenador x){
				
		super.save(x);		
	}
	
	@Override
	public void create(Ordenador o){
		
		ConfiguracionTipo conf = o.getConfiguracionTipo();
		
		
		//copiar datos configuracion
		o.setRam(conf.getRam());
		o.setProcesador(conf.getProcesador());
		
		
		//instalar aplicaciones
		Iterator iter = conf.getDiscoMaster().getAplicaciones().iterator();
		Set<Aplicacion> apps = o.getAplicaciones();
		while(iter.hasNext()){
			Aplicacion app = (Aplicacion)iter.next();
			apps.add(app);
		}
		

		//insert dispositivo
		super.create(o);
	}

}
