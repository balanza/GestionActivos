package dominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import persistence.IEntity;


public abstract class Dispositivo implements IEntity {
	
	int numInventario;
	String numSerie;
	String fechaInstalacion;
	String fechaFinGarantia;
	String fechaCompra;
	int prioridad;
	Date fechaBaja;
	String ip;
	String observaciones;
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
	
	public String getFechaInstalacion(){
		return fechaInstalacion;
	}
	
	public void setFechaInstalacion(String d){
		fechaInstalacion = d;
	}

	public String getFechaFinGarantia(){
		return fechaFinGarantia;
	}
	
	public void setFechaFinGarantia(String d){
		fechaFinGarantia = d;
	}
	public String getFechaCompra(){
		return fechaCompra;
	}
	
	@SuppressWarnings("deprecation")
	public void setFechaCompra(String d){
		fechaCompra = d;
	}
	
	public int getPrioridad(){
		return prioridad;
	}
	
	public void setPrioridad(int n){
		prioridad = n;
	}
	
	public String getIp(){
		return ip;
	}
	
	public void setIp(String n){
		ip = n;
	}
	
	public String getObservaciones(){
		return observaciones;
	}
	
	public void setObservaciones(String n){
		observaciones = n;
	}
	
	public float getPrecioCompra(){
		return precioCompra;
	}
	
	public void setPrecioCompra(float n){
		precioCompra = n;
	}
	
	public  Date getFechaBaja(){
		return null;
		//TODO: calcolare  
	}	
	public  void setFechaBaja(Date d){
		//TODO: calcolare 
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
		return String.format("%d %s %s", getNumSerie(),getMarca(), getModelo()) ;
	}
	

	@Override
	public String toString() {
		return getLabel();
	}
}