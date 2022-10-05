package Datos;

public class Administrador {
	
	private String nombreUsuario;
	private String contrasenya;
	
	public Administrador(String nombreUsuario, String contrasenya) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasenya = contrasenya;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	@Override
	public String toString() {
		return "Administrador [nombre del Usuario=" + nombreUsuario + ", Contrasenya=" + contrasenya + "]";
	}
	
	
	
	

}
