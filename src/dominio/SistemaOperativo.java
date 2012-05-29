package dominio;

import java.util.HashSet;
import java.util.Set;

import persistence.IEntity;

public class SistemaOperativo implements IEntity {
	
	private int idSistemaOperativo;
	private String descripcion;
	private String nombre;
	private String version;
	private Set<DiscoMaster> discos = new HashSet<DiscoMaster>();
	
	public SistemaOperativo(){}
	
	public int getIdSistemaOperativo(){
		return idSistemaOperativo;		
	}
	
	public void setIdSistemaOperativo(int idSistemaOperativo){
		this.idSistemaOperativo = idSistemaOperativo;
	}
	
	public String getDescripcion(){
		return descripcion;		
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	
	public String getNombre(){
		return nombre;		
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getVersion(){
		return version;		
	}
	
	public void setVersion(String version){
		this.version = version;
	}
	
	public Set<DiscoMaster> getDiscos(){
		return discos;		
	}
	
	public void setDiscos(Set<DiscoMaster> discos){
		this.discos = discos;		
	}

	@Override
	public int compareTo(IEntity e) {
		if(!(e instanceof SistemaOperativo)){
			return 1;
		} else if(getId() > e.getId()){
			return 1;
		} else if(getId() < e.getId()){
			return -1;
		} else return 0;
	}

	@Override
	public int getId() {
		return getIdSistemaOperativo();
	}

	@Override
	public String getLabel() {
		return String.format("%s %s", getNombre(), getVersion());
	}

}
