package Datos;


public class Registro {
	
	//Clase registro, la cual usaremos como padre para USUARIO Y ADMINISTRADOR
	
	
	//Parametros, nombre, apellido y nombre de usuario
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
	
	
	//Constructor sin parametros
	
	public Registro() {
		super();
	this.nombre = "";
	this.apellido = "";
	this.nombreUsuario = "";
}

	//Metodos get y set de los atributos de la clase

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
	
	
	

	//Metodo toString
	
	public String toString () {
		
		return "Nombre: " + nombre + " Apellido: " + apellido + " Usuario: " + nombreUsuario;
	}
	
	
	

}
