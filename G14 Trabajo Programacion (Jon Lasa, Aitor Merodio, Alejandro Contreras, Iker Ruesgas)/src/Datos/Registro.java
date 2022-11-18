package Datos;

import javax.swing.JOptionPane;

import logicaDeNegocio.LongitudStringException;

public class Registro {
	
	private String nombre;
	private String apellido;
	private String nombreUsuario;
	
	
	// Constructor con parametros
	public Registro(String nombre, String apellido, String nombreUsuario)  {
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
		this.nombre = nombre;
		
		
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido){
		
			this.apellido = apellido;
		
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario){
	
			this.nombreUsuario = nombreUsuario;
		
		
		
	}
	
	
	

	
	
	public String toString () {
		
		return "Nombre: " + nombre + " Apellido: " + apellido + " Usuario: " + nombreUsuario;
	}
	
	
	

}
