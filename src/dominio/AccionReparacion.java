package dominio;


public class AccionReparacion extends Accion {

	private int nuevaRam = -1;
	private String nuevoProcesador;
	
	public AccionReparacion(){
		super();
	}
	
/*	public Ampliacion(int numInventario, int numSecuencia){
		super(numInventario, numSecuencia);
	}*/
	
	
	public int getNuevaRam() {
		return nuevaRam;
	}

	public void setNuevaRam(int ram) {
		this.nuevaRam = ram;
		
	}
	
	public String getNuevoProcesador() {
		return nuevoProcesador == null ? "" : nuevoProcesador;
	}


	public void setNuevoProcesador(String procesador) {
		this.nuevoProcesador = procesador;
		
	}
}
