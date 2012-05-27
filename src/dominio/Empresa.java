package dominio;

import java.util.Set;

import persistence.IEntity;


public class Empresa implements IEntity{
	
	private int id;
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	private String poblacion;
	private Set<Dispositivo> dispositivos;

	
	public int getId(){
		return this.id;		
	} 
	
	public void setId(int id){
		this.id=id;
	}

	public String getNombre(){
		return this.nombre;		
	} 
	
	public void setNombre(String value){
		this.nombre = value;
	}

	public String getDireccion(){
		return this.direccion;		
	} 
	
	public void setDireccion(String value){
		this.direccion = value;
	}
	
	public String getTelefono(){
		return this.telefono;		
	} 
	
	public void setTelefono(String value){
		this.telefono = value;
	}

	public String getEmail(){
		return this.email;		
	} 
	
	public void setEmail(String value){
		this.email = value;
	}

	public String getPoblacion(){
		return this.poblacion;		
	} 
	
	public void setPoblacion(String value){
		this.poblacion = value;
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
