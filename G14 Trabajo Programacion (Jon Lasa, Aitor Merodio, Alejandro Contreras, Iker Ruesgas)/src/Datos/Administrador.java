package Datos;



public class Administrador extends Registro {
	
	//CLASE ADMINISTRADOR, LA CUAL PODRA AÑADIR SERVICIOS A LA BASE
	
	private int codAcceso;
	
	//hereda de Registro + codigo de Acceso a modo de identificador
	
	
	//Contructor con parametros

	public Administrador(String nombre, String apellido, String nombreUsuario, int codAcceso){
		super(nombre, apellido, nombreUsuario);
		this.codAcceso = codAcceso;
	}
	
	//Constructor sin parametros
	
	public Administrador() {
		super();
		this.codAcceso = 000;
	}
	
	//Metodos get y set


	public int getCodAcceso() {
		return codAcceso;
	}


	public void setCodAcceso(int codAcceso) {
		this.codAcceso = codAcceso;
	}
	
	//Metodo toString
	
	
	public String toString () {
		
		return super.toString() + "Codigo acceso: " + codAcceso;
	}
	

}
