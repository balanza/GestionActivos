package dominio;

import java.util.Date;

import DAO.DispositivoDAO;

import persistence.IEntity;

public class Accion implements IEntity{
	
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
	
	public void setFecha(Date fecha){
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
	
	public Dispositivo getDispositivo(){
		try{
			DispositivoDAO<Dispositivo> dao = new DispositivoDAO<Dispositivo>();
			return dao.find(getPrimaryKey().getNumInventario());
		} catch(Exception e){
			return null;
		}		
	}

	@Override
	public int compareTo(IEntity e) {
		if(!(e instanceof Accion)){
			return 1;
		} else {
			Accion accion = (Accion)e;
			if(accion.getPrimaryKey().getNumInventario()==this.getPrimaryKey().getNumInventario()){
				if(accion.getPrimaryKey().getNumSecuencia()==this.getPrimaryKey().getNumSecuencia()){
					return 0;
				} else if(accion.getPrimaryKey().getNumSecuencia()>this.getPrimaryKey().getNumSecuencia()){
					return 1;
				} else {
					return -1;					
				}
			} else if(accion.getPrimaryKey().getNumInventario()>this.getPrimaryKey().getNumInventario()){
				return 1;
			} else {
				return -1;
			}
		}
		
	}

	@Override
	public int getId() {
		try{
			return this.getPrimaryKey().getNumSecuencia();
		} catch(Exception ignore){
			return 0;
		}
		
		
	}

	@Override
	public String getLabel() {
		return this.toString();
	}
	
	@Override
	public String toString() {
		return this.getPrimaryKey().getNumInventario() + "_" + this.getPrimaryKey().getNumSecuencia();
	}
	

}


