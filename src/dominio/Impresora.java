package dominio;


import persistence.IEntity;


public class Impresora extends Dispositivo {
	
	private String marca;
	private String modelo;
	
	public Impresora(){}
	
	@Override
	public String getMarca() {
		return marca;
	}

	@Override
	public void setMarca(String m) {
		marca = m;		
	}

	@Override
	public String getModelo() {
		return modelo;
	}

	@Override
	public void setModelo(String m) {
		modelo = m;
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
	

	@Override
	public String toString(){
		return String.format("I%05d" , getNumInventario());			
	}
	
}
