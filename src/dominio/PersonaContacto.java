package dominio;

import java.util.Set;

import persistence.IEntity;

public class PersonaContacto implements IEntity {

	private int id;
	private String nombre;
	private String telefono;
	private Set<Dispositivo> dispositivos;
	
	public int getId(){
		return this.id;		
	} 
	
	public void setId(int value){
		this.id = value;
	}
	
	public String getNombre(){
		return this.nombre;		
	} 
	
	public void setNombre(String value){
		this.nombre = value;
	}
	
	public String getTelefono(){
		return this.telefono;		
	} 
	
	public void setTelefono(String value){
		this.telefono = value;
	}
	
	public Set<Dispositivo> getDispositivos(){
		return this.dispositivos;
	}
	
	public void  setDispositivos(Set<Dispositivo> dispositivos){
		this.dispositivos = dispositivos;
	}
	
	@Override
	public String getLabel() {
		return getNombre();
	}
	

	@Override
	public String toString() {
		return getLabel();
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
