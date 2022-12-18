package Datos;



public class Administrador extends Registro {
	
	//CLASE ADMINISTRADOR, LA CUAL PODRA AÑADIR SERVICIOS A LA BASE
	
	private int id;
	private String contrasenya;
	
	
	//hereda de Registro + codigo de Acceso a modo de identificador
	
	
	//Contructor con parametros

	public Administrador(String nombre, String apellido, String nombreUsuario,String contrasenya,int id){
		super(nombre, apellido, nombreUsuario);
		this.id=id;
		this.contrasenya=contrasenya;
		
	}
	
	//Constructor sin id
	
		public Administrador(String nombre, String apellido, String nombreUsuario,String contrasenya) {
			super(nombre, apellido, nombreUsuario);
			this.contrasenya=contrasenya;
		}
	
	
	//Constructor sin parametros
	
	public Administrador() {
		super();
		this.id=000;
		this.contrasenya="sin contrasenya";
	}
	
	//Metodos get y set


	public int getCodAcceso() {
		return id;
	}


	public void setCodAcceso(int codAcceso) {
		this.id = codAcceso;
	}
	
	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
	//Metodo toString
	
	


	public String toString () {
		
		return super.toString() + "Codigo acceso: " + id;
	}
	

}
