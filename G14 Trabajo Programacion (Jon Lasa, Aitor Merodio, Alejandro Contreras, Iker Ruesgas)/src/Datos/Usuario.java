package Datos;

import java.util.ArrayList;

import Logica_de_Negocio.LongitudStringException;

public class Usuario extends Registro {
	
	
	private String contrasenya; 
	private String dni;
	private int puntos ;
	
	private int codigo;
	
	
	
	//Constructor con parametros
	
	public Usuario(String nombre, String apellido, String usuario, String contrasenya, String dni) throws LongitudStringException {
		super(nombre, apellido, usuario);
		setContrasenya(contrasenya);
		setDni(dni); 
		setPuntos(0);
		
	
		
		
	}
	
	
	//Constructor sin Parametros
	
	public Usuario() {
		super();
		this.contrasenya = "";
		this.dni = "";
		this.puntos = 0;
	
	}


	public String getContrasenya() {
		return contrasenya;
	}


	public void setContrasenya(String contrasenya) throws LongitudStringException {
		if (contrasenya==null|contrasenya.length()<6) {
			throw new LongitudStringException("Parametros usuario/contrasenya tiene que tener mas de 6 caracteres: ");
		}
		else {
			this.contrasenya = contrasenya;
		}
	}


	public String getDni() {
		return dni;
	}

	
	//FALTA EL PATTERN DEL DNI

	public void setDni(String dni) {
		if (dni==null) {
			this.dni="";
		}
		else {
			this.dni = dni;
		}
	}




	public int getPuntos() {
		return puntos;
	}


	public void setPuntos(int puntos) {
		if (puntos<0) {
			this.puntos=0;
		}
		else {
			this.puntos = puntos;
		}
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	


	@Override
	public String toString() {
		return "Usuario: " + "Nombre: " + getNombre() +" Apellido: " + getApellido() + "Nombre usuario: "  + getNombreUsuario() + " [contrasenya=" + contrasenya + ", dni=" + dni  
			 + ", puntos=" + puntos;
	}
	
	
	
	
	
	
	
	

}
