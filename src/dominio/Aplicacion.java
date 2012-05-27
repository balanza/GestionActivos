package dominio;

import java.util.HashSet;
import java.util.Set;

import persistence.IEntity;

public class Aplicacion implements IEntity{

	private int idAplicacion;
	private String nombre;
	private String version;
	private Set<DiscoMaster> discos = new HashSet<DiscoMaster>();
	
	public Aplicacion(){}
	
	public int getIdAplicacion(){
		return idAplicacion;
	}
	
	public void setIdAplicacion(int id){
		this.idAplicacion = id;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre= nombre;
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
	public int getId() {
		return getIdAplicacion();
	}

	@Override
	public String getLabel() {
		return getNombre();
	}
	
	
	@Override
	public int compareTo(IEntity o) {
		if(!(this.getClass().isInstance(o))){
			return 1; //siempre mayor de un objeto de un tipo diferente			
		} else if (this.getId() == o.getId()){
			return 0;					
		} else if (o.getId() > this.getId()){
			return 1;					
		} else {
			return -1;					
		}
	}
	
	
	
}
