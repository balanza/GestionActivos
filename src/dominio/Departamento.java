package dominio;

import java.util.Set;

import persistence.IEntity;

public class Departamento implements IEntity{

	private int codigo;
	private String nombre;
	private Set<Dispositivo> dispositivos;
	
	public int getCodigo(){
		return this.codigo;		
	} 
	
	public void setCodigo(int value){
		this.codigo = value;
	}
	
	public String getNombre(){
		return this.nombre;		
	} 
	
	public void setNombre(String value){
		this.nombre = value;
	}
	
	public Set<Dispositivo> getDispositivos(){
		return this.dispositivos;
	}
	
	public void  setDispositivos(Set<Dispositivo> dispositivos){
		this.dispositivos = dispositivos;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return getCodigo();
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
