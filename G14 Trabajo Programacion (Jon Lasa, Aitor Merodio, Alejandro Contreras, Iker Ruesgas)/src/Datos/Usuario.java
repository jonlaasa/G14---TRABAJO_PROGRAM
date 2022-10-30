package Datos;

import java.util.ArrayList;

public class Usuario extends Registro {
	
	
	private String contrasenya; 
	private String dni;
	private MetodoPago metodoPago;
	private int puntos ;
	
	private int codigo;
	
	private static int claveClase=1;
	
	
	//Constructor con parametros
	
	public Usuario(String nombre, String apellido, String usuario, String contrasenya, String dni,
			MetodoPago metodoPago) {
		super(nombre, apellido, usuario);
		setContrasenya(contrasenya);
		setDni(dni); 
		setMetodoPago(metodoPago);
		setPuntos(0);
		this.codigo=claveClase;
		claveClase++;
		
	
		
		
	}
	
	
	//Constructor sin Parametros
	
	public Usuario() {
		super();
		this.contrasenya = "";
		this.dni = "";
		this.metodoPago = new MetodoPago();
		this.puntos = 0;
		this.codigo=claveClase;
		claveClase++;
	
	}


	public String getContrasenya() {
		return contrasenya;
	}


	public void setContrasenya(String contrasenya) {
		if (contrasenya==null) {
			this.contrasenya="";
		}
		else {
			this.contrasenya = contrasenya;
		}
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		if (dni==null) {
			this.dni="";
		}
		else {
			this.dni = dni;
		}
	}


	public MetodoPago getMetodoPago() {
		return metodoPago;
	}


	public void setMetodoPago(MetodoPago metodoPago) {
		if (metodoPago==null) {
			this.metodoPago=new MetodoPago();
		}
		else {
			this.metodoPago = metodoPago;
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


	public static int getClaveClase() {
		return claveClase;
	}


	public static void setClaveClase(int claveClase) {
		Usuario.claveClase = claveClase;
	}


	@Override
	public String toString() {
		return "Usuario: " + "Nombre: " + getNombre() +" Apellido: " + getApellido() + "Nombre usuario: "  + getNombreUsuario() + " [contrasenya=" + contrasenya + ", dni=" + dni + ", metodoPago=" + metodoPago 
			 + ", puntos=" + puntos;
	}
	
	
	
	
	
	
	
	

}
