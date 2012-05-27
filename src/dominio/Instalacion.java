package dominio;

import java.util.Date;

public class Instalacion {
	
	private Date fecha;
	private Aplicacion aplicacion;
	private Ordenador ordenador;
	
	public Instalacion(){}
	
	public Date getFecha(){
		return fecha;		
	}
	
	public void setFecha(Date fecha){
		this.fecha = fecha;
	}
	
	public Aplicacion getAplicacion (){
		return aplicacion;		
	}
	
	public void setAplicacion(Aplicacion aplicacion){
		this.aplicacion = aplicacion;
	}
	
	public Ordenador getOrdenador(){
		return ordenador;		
	}
	
	public void setOrdenador(Ordenador ordenador){
		this.ordenador = ordenador;
	}
	
	

}
