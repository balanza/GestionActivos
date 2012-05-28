package dominio;

import java.io.Serializable;

public class AccionPK implements Serializable {
	
	private int numInventario;
	private int numSecuencia; 

	public AccionPK(int numInventario, int numSecuencia){
		setNumInventario(numInventario);
		setNumSecuencia(numSecuencia);
	}
	
	public AccionPK(){}
	
	
	public int getNumInventario(){
		return numInventario;		
	}
	
	public void setNumInventario(int num){
		this.numInventario = num;
	}

	public int getNumSecuencia(){
		return numSecuencia;		
	}
	
	public void setNumSecuencia(int num){
		this.numSecuencia = num;
	}
	
	@Override
	public boolean equals(Object arg0) {
		if(arg0 == null) return false;
		if(!(arg0 instanceof AccionPK)) return false;
		AccionPK arg1 = (AccionPK) arg0;
		return (this.numInventario == arg1.getNumInventario())	&& (this.numSecuencia == arg1.getNumSecuencia());
	}
	
	@Override
	public int hashCode() {
		int hsCode;
		hsCode = ((Integer)numInventario).hashCode();
		hsCode = 19 * hsCode+ ((Integer)numSecuencia).hashCode();
		return hsCode;
	}
	
}
