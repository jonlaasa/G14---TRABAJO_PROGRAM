package Datos;

import java.util.Date;

public class Compra {
	
	
	private int codigoUsuario;
	private int cantidad;
	private Date fechaCompra;
	
	
	//Constructor con parametros
	
	public Compra(int codigoUsuario, int cantidad, Date fechaCompra) {
		super();
		this.codigoUsuario = codigoUsuario;
		this.cantidad = cantidad;
		this.fechaCompra = fechaCompra;
	}


	public int getCodigoUsuario() {
		return codigoUsuario;
	}


	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public Date getFechaCompra() {
		return fechaCompra;
	}


	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}


	@Override
	public String toString() {
		return "Compra [codigoUsuario=" + codigoUsuario + ", cantidad=" + cantidad + ", fechaCompra=" + fechaCompra
				+ "]";
	}
	
	
	
	
	
	

}
