package Datos;

import logicaDeNegocio.LongitudStringException;

public class Administrador extends Registro {
	
	private int codAcceso;

	public Administrador(String nombre, String apellido, String nombreUsuario, int codAcceso) throws LongitudStringException{
		super(nombre, apellido, nombreUsuario);
		this.codAcceso = codAcceso;
	}
	
	
	public Administrador() {
		super();
		this.codAcceso = 000;
	}


	public int getCodAcceso() {
		return codAcceso;
	}


	public void setCodAcceso(int codAcceso) {
		this.codAcceso = codAcceso;
	}
	
	
	public String toString () {
		
		return super.toString() + "Codigo acceso: " + codAcceso;
	}
	

}
