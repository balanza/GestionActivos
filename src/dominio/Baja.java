package dominio;

import java.util.Date;

public class Baja extends Accion {

	private Date fechaBaja;
	
	public Baja(){}
	
	public Date getFechaBaja(){
		return fechaBaja;		
	}
	
	public void setFecia(Date fechaBaja){
		this.fechaBaja = fechaBaja;
	}
}
