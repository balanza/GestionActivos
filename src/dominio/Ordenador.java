package dominio;

import java.util.HashSet;
import java.util.Set;

import persistence.IEntity;

public class Ordenador extends Dispositivo{

	private int ram = -1;
	private String procesador;
	private ConfiguracionTipo configuracion;
	private Set<Aplicacion> aplicaciones;
	
	
	
	public Ordenador(){
		aplicaciones = new HashSet<Aplicacion>();
	}
		
	public int getRam() {
		if(ram == -1 && configuracion != null){
			return configuracion.getRam();
		} else {
			return ram;
		}
	}

	public void setRam(int ram) {
		this.ram = ram;
		
	}
	
	public String getProcesador() {
		// TODO  *se null*  derivare da ConfiguracionTipo
		if(procesador == "" && configuracion != null){
			return configuracion.getProcesador();
		} else {
			return procesador;
		}
	}


	public void setProcesador(String procesador) {
		this.procesador = procesador;
		
	}
	
	@Override
	public String getMarca() {
		if(configuracion != null){
			return configuracion.getMarca().trim();
		} else {
			return "";
		}
	}


	@Override
	public String getModelo() {
		if(configuracion != null){
			return configuracion.getModelo();
		} else {
			return "";
		}
	}

	@Override
	public void setModelo(String m) {
		// TODO derivare da ConfiguracionTipo
		
	}
	
	public ConfiguracionTipo getConfiguracionTipo(){
		return configuracion;
	}
	
	public void setConfiguracionTipo(ConfiguracionTipo configuracion){
		this.configuracion = configuracion;		
	}
	
	public Set<Aplicacion> getAplicaciones(){
		if(aplicaciones == null){
			aplicaciones = new HashSet<Aplicacion>();
		}
		return aplicaciones;
	}
	
	public void setAplicaciones(Set<Aplicacion> apps){
		aplicaciones = apps;
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
