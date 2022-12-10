package Datos;

import java.util.Date;

import Enum.TipoServicio;

public class Compra {
	
	
	private int codigoUsuario;
	private int cantidad;
	private String fechaCompra;
	private TipoServicio tipoServicio;
	private int codigoCompra;
	
	
	//Constructor con parametros
	
	public Compra(int codigoUsuario, int cantidad, String fechaCompra,TipoServicio tipoServicio, int codigoCompra) {
		super();
		this.codigoUsuario = codigoUsuario;
		this.cantidad = cantidad;
		this.fechaCompra = fechaCompra;
		this.tipoServicio = tipoServicio;
		this.codigoCompra=codigoCompra;
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


	public String getFechaCompra() {
		return fechaCompra;
	}


	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	
	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}


	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	
	public int getCodigoCompra() {
		return codigoCompra;
	}



	public void setCodigoCompra(int codigoCompra) {
		this.codigoCompra = codigoCompra;
	}



	@Override
	public String toString() {
		return "Compra [codigoUsuario=" + codigoUsuario + ", cantidad=" + cantidad + ", fechaCompra=" + fechaCompra
				+ "]";
	}
	
	
	
	
	
	

}
