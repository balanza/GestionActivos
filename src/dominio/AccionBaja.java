package dominio;

import java.util.Date;

import persistence.IEntity;

public class AccionBaja extends Accion {

	private Date fechaBaja;
	
	public AccionBaja(){}
	
	public Date getFechaBaja(){
		return fechaBaja;		
	}
	
	public void setFechaBaja(Date fechaBaja){
		this.fechaBaja = fechaBaja;
	}

	
}
