package Datos;

import javax.swing.JOptionPane;

import logicaDeNegocio.LongitudStringException;

public class Registro {
	
	private String nombre;
	private String apellido;
	private String nombreUsuario;
	
	
	// Constructor con parametros
	public Registro(String nombre, String apellido, String nombreUsuario) throws LongitudStringException {
		super();
		setNombre(nombre);
		setApellido(apellido);
		setNombreUsuario(nombreUsuario);
	}
	
	
	public Registro() {
		super();
	this.nombre = "";
	this.apellido = "";
	this.nombreUsuario = "";
}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		if (nombre==null) {
			this.nombre="";
		}
		else {
			this.nombre = nombre;
		}
		
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido){
		if (apellido==null) {
			this.apellido="";
		}
		else {
			this.apellido = apellido;
		}
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario){
		if (nombreUsuario==null) {
			this.nombreUsuario=null;
		}
		else {
			this.nombreUsuario = nombreUsuario;
		}
		
		
	}

	
	
	public String toString () {
		
		return "Nombre: " + nombre + " Apellido: " + apellido + " Usuario: " + nombreUsuario;
	}
	
	
	

}
