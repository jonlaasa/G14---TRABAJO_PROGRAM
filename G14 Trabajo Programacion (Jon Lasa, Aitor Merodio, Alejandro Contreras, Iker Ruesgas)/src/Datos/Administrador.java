package Datos;

public class Administrador {
	
	private String nombreUsuario;
	private String contrase�a;
	
	public Administrador(String nombreUsuario, String contrase�a) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrase�a = contrase�a;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	@Override
	public String toString() {
		return "Administrador [nombre del Usuario=" + nombreUsuario + ", Contrase�a=" + contrase�a + "]";
	}
	
	
	
	

}
