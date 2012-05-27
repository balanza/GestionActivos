package dominio;

import java.util.HashSet;
import java.util.Set;

import persistence.IEntity;

public class ConfiguracionTipo implements IEntity{
	
	private int idConfiguracionTipo;
	private DiscoMaster discoMaster;
	private int ram;
	private String marca;
	private String modelo;
	private String procesador;
	private Set<Ordenador> ordenadores = new HashSet<Ordenador>();
	
	
	public ConfiguracionTipo(){}
	
	
	public int getIdConfiguracionTipo(){
		return idConfiguracionTipo;		
	}
	
	public void setIdConfiguracionTipo(int id){
		idConfiguracionTipo = id;
	}
	
	public DiscoMaster getDiscoMaster(){
		return discoMaster;		
	}
	
	public void setDiscoMaster(DiscoMaster disco){
		discoMaster = disco;
	}	

	public String getMarca(){
		return marca;		
	}
	
	public void setMarca(String marca){
		this.marca = marca;
	}

	public String getModelo(){
		return modelo;		
	}
	
	public void setModelo(String modelo){
		this.modelo = modelo;
	}
	
	public String getProcesador(){
		return procesador;		
	}
	
	public void setProcesador(String procesador){
		this.procesador = procesador;
	}

	public int getRam(){
		return ram;		
	}
	
	public void setRam(int ram){
		this.ram = ram;
	}	
	
	public Set<Ordenador> getOrdenadores(){
		return ordenadores;		
	}

	public void setOrdenadores(Set<Ordenador> ordenadores){
		this.ordenadores = ordenadores; //correcto?
	}


	@Override
	public int getId() {
		return getIdConfiguracionTipo();
	}


	@Override
	public String getLabel() {
		return getMarca() + " " + getModelo() + " (" + getProcesador() + ")";   
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
