package dominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import DAO.AccionBajaDAO;

import persistence.IEntity;


public abstract class Dispositivo implements IEntity {
	
	int numInventario;
	String numSerie = "";
	Date fechaInstalacion;
	Date fechaFinGarantia;
	Date fechaCompra;
	Prioridad prioridad;
	String ip = "";
	String observaciones = "";
	float precioCompra;
	PersonaContacto personaContacto;
	Departamento departamento;
	Empresa empresa;
	
	public Dispositivo(){}
	
	public int getNumInventario(){
		return numInventario;
	}
	
	public void setNumInventario(int n){
		numInventario = n;
	}
	
	public String getNumSerie(){
		return numSerie;
	}
	
	public void setNumSerie(String n){
		numSerie = n;
	}
	
	public Date getFechaInstalacion(){
		return fechaInstalacion;
	}
	
	public void setFechaInstalacion(Date d){
		fechaInstalacion = d;
	}

	public Date getFechaFinGarantia(){
		return fechaFinGarantia;
	}
	
	public void setFechaFinGarantia(Date d){
		fechaFinGarantia = d;
	}
	public Date getFechaCompra(){
		return fechaCompra;
	}
	
	@SuppressWarnings("deprecation")
	public void setFechaCompra(Date d){
		fechaCompra = d;
	}
	
	public Prioridad getPrioridad(){
		return prioridad;
	}
	
	public void setPrioridad(Prioridad n){
		prioridad = n;
	}
	
	public String getIp(){
		return ip.trim();
	}
	
	public void setIp(String n){
		if(n == null){
			n = "";
		}
		ip = n;
	}
	
	public String getObservaciones(){
		return observaciones.trim();
	}
	
	public void setObservaciones(String n){
		if(n == null){
			n = "";
		}
		observaciones = n;
	}
	
	public float getPrecioCompra(){
		return precioCompra;
	}
	
	public void setPrecioCompra(float n){
		precioCompra = n;
	}
	
	public  Date getFechaBaja(){
		AccionBajaDAO dao = new AccionBajaDAO();
		Date f = null;
		int sec = 0; 
		for(AccionBaja a : dao.findAll()){
			if(a.getPrimaryKey().getNumInventario() == getId() && a.getPrimaryKey().getNumSecuencia() > sec){
				sec = a.getPrimaryKey().getNumSecuencia();
				f = a.getFechaBaja();
			}
		}
		return f;
	}	
	
	
	public  PersonaContacto getPersonaContacto(){
		return this.personaContacto;
	}	
	
	public  void  setPersonaContacto(PersonaContacto p){
		this.personaContacto = p;
	}
	
	public  Departamento getDepartamento(){
		return this.departamento;
	}	
	public  void  setDepartamento(Departamento d){
		this.departamento = d;
	}
		
	public  Empresa getEmpresa(){
		return this.empresa;
	}	
	public  void  setEmpresa(Empresa e){
		this.empresa = e;
	}
	
	
	public  String getMarca(){return "";}
	public  void setMarca(String m){}
	
	public  String getModelo(){return "";}
	public  void setModelo(String m){}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return getNumInventario();
	}

	@Override
	public String getLabel() {
		return String.format("%s %s %s", getNumSerie(),getMarca(), getModelo()) ;
	}
	

	@Override
	public String toString() {
		return getLabel();
	}
}
