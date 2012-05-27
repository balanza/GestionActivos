package dominio;

import java.util.Date;

public abstract class Accion {
	
	private AccionPK primaryKey;
	private Date fecha;
	private String descripcion;
	private Ordenador ordenador;
	
	/*public Accion(int numInventario, int numSecuencia){
		primaryKey = new AccionPK(numInventario, numSecuencia);
	}*/
	
	public Accion(){}
	
	public AccionPK getPrimaryKey(){
		return primaryKey;
	}

	public void setPrimaryKey(AccionPK pk){
		this.primaryKey = pk;
	}

	public Date getFecha(){
		return fecha;		
	}
	
	public void setFecia(Date fecha){
		this.fecha = fecha;
	}

	public String getDescripcion(){
		return descripcion;		
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion ;
	}
	
	public Ordenador getOrdenador(){
		return ordenador;		
	}
	
	public void setOrdenador(Ordenador ordenador){
		this.ordenador = ordenador;
	}
	

}

