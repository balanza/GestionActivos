package dominio;

public class AccionCambioDestino extends Accion {

	private String nuevaIp;
	private Departamento departamento;
	private PersonaContacto contacto;
	
	public AccionCambioDestino(){}
	
	public String getNuevaIp(){
		return nuevaIp;		
	}
	
	public void setNuevaIp(String ip){
		this.nuevaIp = ip;
	}

	public Departamento getDepartamento(){
		return departamento;		
	}
	
	public void setDepartamento(Departamento departamento){
		this.departamento = departamento;
	}
	
	public PersonaContacto getContacto(){
		return contacto;		
	}
	
	public void setContacto(PersonaContacto contacto){
		this.contacto = contacto;
	}
	
}
