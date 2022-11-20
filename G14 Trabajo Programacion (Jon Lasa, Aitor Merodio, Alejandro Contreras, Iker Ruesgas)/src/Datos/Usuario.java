package Datos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import logicaDeNegocio.LongitudStringException;
import logicaDeNegocio.StringValidoException;

public class Usuario extends Registro {
	
	
	private String contrasenya; 
	private String dni;
	private int puntos ;
	
	private String correoElectronico;
	private int codigo;
	
	
	
	//Constructor con parametros
	
	public Usuario(String nombre, String apellido, String usuario, String contrasenya, String correoElectronico,String dni)  {
		super(nombre, apellido, usuario);
		setContrasenya(contrasenya);
		setCorreoElectronico(correoElectronico);
		setDni(dni); 
		setPuntos(0);
		
	
		
		
	}
	
	
	//Constructor sin Parametros
	
	public Usuario() {
		super();
		this.contrasenya = "";
		this.correoElectronico="";
		this.dni = "";
		this.puntos = 0;
	
	}


	public String getContrasenya() {
		return contrasenya;
	}


	public void setContrasenya(String contrasenya)  {
		
			this.contrasenya = contrasenya;
		
	}


	public String getDni() {
		return dni;
	}

	
	//FALTA EL PATTERN DEL DNI

	public void setDni(String dni) {
		
		
			this.dni = dni;
		
	}




	public int getPuntos() {
		return puntos;
	}


	public void setPuntos(int puntos) {
	
			this.puntos = puntos;
		
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	

	public String getCorreoElectronico() {
		return correoElectronico;
	}


	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}


	@Override
	public String toString() {
		return "Usuario: " + "Nombre: " + getNombre() +" Apellido: " + getApellido() + "Nombre usuario: "  + getNombreUsuario() + " [contrasenya=" + contrasenya + ", dni=" + dni  
			 + ", puntos=" + puntos;
	}
	
	
	
	
	
	
	
	

}
