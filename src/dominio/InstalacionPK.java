package dominio;

import java.io.Serializable;

public class InstalacionPK implements Serializable {

	private int numInventario;
	private int idAplicacion; 

	public InstalacionPK(int numInventario, int idAplicacion){
		setNumInventario(numInventario);
		setIdAplicacion(idAplicacion);
	}
	
	
	public int getNumInventario(){
		return numInventario;		
	}
	
	public void setNumInventario(int num){
		this.numInventario = num;
	}

	public int getIdAplicacion(){
		return idAplicacion;		
	}
	
	public void setIdAplicacion(int num){
		this.idAplicacion = num;
	}
	
	@Override
	public boolean equals(Object arg0) {
		if(arg0 == null) return false;
		if(!(arg0 instanceof InstalacionPK)) return false;
		InstalacionPK arg1 = (InstalacionPK) arg0;
		return (this.numInventario == arg1.getNumInventario())	&& (this.idAplicacion == arg1.getIdAplicacion());
	}
	
	@Override
	public int hashCode() {
		int hsCode;
		hsCode = ((Integer)numInventario).hashCode();
		hsCode = 19 * hsCode+ ((Integer)idAplicacion).hashCode();
		return hsCode;
	}
	
	
}
