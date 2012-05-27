package dominio;

import java.util.HashSet;
import java.util.Set;

import persistence.IEntity;

public class DiscoMaster implements IEntity {
	
	private int idDiscoMaster;
	private String descripcion;
	private Set<ConfiguracionTipo> configuraciones = new HashSet<ConfiguracionTipo>();
	private Set<SistemaOperativo> sistemasOperativos = new HashSet<SistemaOperativo>();
	private Set<Aplicacion> aplicaciones = new HashSet<Aplicacion>();
	
	
	public DiscoMaster(){}
		
	public int getIdDiscoMaster(){
		return idDiscoMaster;		
	}
	
	public void setIdDiscoMaster(int idDiscoMaster){
		this.idDiscoMaster = idDiscoMaster;
	}
	
	public String getDescripcion(){
		return descripcion;		
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	
	
	public Set<ConfiguracionTipo> getConfiguraciones(){
		return configuraciones;		
	}

	public void setConfiguraciones(Set<ConfiguracionTipo> configuraciones){
		this.configuraciones = configuraciones; //correcto?
	}
	
	public Set<SistemaOperativo> getSistemasOperativos(){
		return sistemasOperativos;		
	}

	public void setSistemasOperativos(Set<SistemaOperativo> sistemas){
		this.sistemasOperativos = sistemas; //correcto?
	}
	
	public Set<Aplicacion> getAplicaciones(){
		return aplicaciones;		
	}

	public void setAplicaciones(Set<Aplicacion> aplicaciones){
		this.aplicaciones = aplicaciones; //correcto?
	}

	@Override
	public int compareTo(IEntity o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getId() {
		return getIdDiscoMaster();
	}

	@Override
	public String getLabel() {
		return  getIdDiscoMaster() + "";
	}
	
	
}

