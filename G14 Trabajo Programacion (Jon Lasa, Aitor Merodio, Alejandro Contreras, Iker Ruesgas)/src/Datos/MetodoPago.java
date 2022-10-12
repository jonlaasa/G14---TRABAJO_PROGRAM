package Datos;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import Enum.TipoPago;

public class MetodoPago {
	 //CAMBIARIA A UNA ENUM CON (PAPYPAL O CREDITO)
	private TipoPago tipoPago;
	
	private String numeroTarjeta;
	
	private String nombreCompleto;
	
	private String fechaCaducidad;
	
	private String codigoSeguridad;
	
	private String provincia;
	
	private String ciudad;
	
	private String direccion;
	
	SimpleDateFormat formatoCaducidad =new SimpleDateFormat("MM/YY");

	public MetodoPago(TipoPago tipoPago, String numeroTarjeta, String nombreCompleto, String fechaCaducidad,
			String codigoSeguridad, String provincia, String ciudad, String direccion) {
		super();
		this.tipoPago = tipoPago;
		this.numeroTarjeta = numeroTarjeta;
		this.nombreCompleto = nombreCompleto;
		this.fechaCaducidad = fechaCaducidad;
		this.codigoSeguridad = codigoSeguridad;
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.direccion = direccion;
	}


	
	public MetodoPago() {
		this.tipoPago = TipoPago.TARJETA_CREDITO;
		this.numeroTarjeta = "0000 0000 0000 0000";
		this.nombreCompleto = "";
		this.fechaCaducidad =formatoCaducidad.format(System.currentTimeMillis());
		this.codigoSeguridad = "000";
		this.provincia = "";
		this.ciudad = "";
		this.direccion = "";
	}



	public TipoPago getTipoPago() {
		return tipoPago;
	}



	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
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



	public String getFechaCaducidad() {
		return fechaCaducidad;
	}



	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}



	public String getCodigoSeguridad() {
		return codigoSeguridad;
	}



	public void setCodigoSeguridad(String codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}



	public String getProvincia() {
		return provincia;
	}



	public void setProvincia(String provincia) {
		this.provincia = provincia;
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



	public SimpleDateFormat getFormatoCaducidad() {
		return formatoCaducidad;
	}



	public void setFormatoCaducidad(SimpleDateFormat formatoCaducidad) {
		this.formatoCaducidad = formatoCaducidad;
	}
	
	
	

}
