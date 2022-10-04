package Datos;

public class Administrador {
	
	private String nombreUsuario;
	private String contraseña;
	
	public Administrador(String nombreUsuario, String contraseña) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Administrador [nombre del Usuario=" + nombreUsuario + ", Contraseña=" + contraseña + "]";
	}
	
	
	
	

}
