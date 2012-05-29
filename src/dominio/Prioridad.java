package dominio;

import persistence.IEntity;

public class Prioridad implements IEntity {
	
	private int idPrioridad;
	private String nombre;
	
	public Prioridad(){}
	
	public int getIdPrioridad(){
		return idPrioridad;
	}
	
	public void setIdPrioridad(int p){
		this.idPrioridad = p;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String n){
		this.nombre = n;
	}

	@Override
	public int compareTo(IEntity p) {
		if(getId() == p.getId()){
			return 0;
		} else {return 1;}
	}
	

	@Override
	public int getId() {
		return getIdPrioridad(); 
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return toString();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNombre();
	}
	
	

}
