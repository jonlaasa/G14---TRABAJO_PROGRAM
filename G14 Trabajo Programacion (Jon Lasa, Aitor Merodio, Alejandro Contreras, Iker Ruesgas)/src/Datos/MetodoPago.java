package Datos;

import java.text.SimpleDateFormat;
import java.time.LocalDate;


public class MetodoPago {
	 //CAMBIARIA A UNA ENUM CON (PAPYPAL O CREDITO)
	
	private String numeroTarjeta;
	
	private String nombreCompleto;
	
	private long fechaCaducidad;
	
	private int codigoSeguridad;
	
	private String ciudad;
	
	private String direccion;
	
	private int codigoUsuario;
	
	SimpleDateFormat formatoCaducidad =new SimpleDateFormat("MM/YY");

	public MetodoPago( int codigoUsuario, String numeroTarjeta, String nombreCompleto, long fechaCaducidad,
			int codigoSeguridad, String ciudad, String direccion) {
		super();
		
		this.codigoUsuario = codigoUsuario;
		this.numeroTarjeta = numeroTarjeta;
		this.nombreCompleto = nombreCompleto;
		this.fechaCaducidad = fechaCaducidad;
		this.codigoSeguridad = codigoSeguridad;
		
		this.ciudad = ciudad;
		this.direccion = direccion;
	}


	
	public MetodoPago() {
		
		this.codigoUsuario=000;
		this.numeroTarjeta = "0000 0000 0000 0000";
		this.nombreCompleto = "";
		this.fechaCaducidad =0;
		this.codigoSeguridad = 000;
		this.ciudad = "";
		this.direccion = "";
	}





	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}



	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}



	public String getNombreCompleto() {
		return nombreCompleto;
	}



	public void setNombreCompleto(String nombreCompleto) {
		
	this.nombreCompleto = nombreCompleto;
	}



	public long getFechaCaducidad() {
		return fechaCaducidad;
	}



	public void setFechaCaducidad(long fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}



	public int getCodigoSeguridad() {
		return codigoSeguridad;
	}



	public void setCodigoSeguridad(int codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}


	public String getCiudad() {
		return ciudad;
	}



	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		
		this.direccion = direccion;
	}





	public int getCodigoUsuario() {
		return codigoUsuario;
	}



	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}



	@Override
	public String toString() {
		return "MetodoPago [numeroTarjeta=" + numeroTarjeta + ", nombreCompleto=" + nombreCompleto + ", fechaCaducidad="
				+ fechaCaducidad + ", codigoSeguridad=" + codigoSeguridad + ", ciudad="
				+ ciudad + ", direccion=" + direccion + ", formatoCaducidad=" + formatoCaducidad + "]";
	}
	
	
	
	
	
	

}
