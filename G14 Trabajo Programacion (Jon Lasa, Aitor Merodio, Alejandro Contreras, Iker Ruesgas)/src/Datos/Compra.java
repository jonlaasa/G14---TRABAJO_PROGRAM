package Datos;

import java.util.Date;

import Enum.TipoServicio;

public class Compra {
	
	
	private int codigoUsuario;
	private int cantidad;
	private long fechaCompra;
	private TipoServicio tipoServicio;
	private int codigoServicio;
	
	
	//Constructor con parametros
	
	public Compra(int codigoUsuario, int cantidad, long fechaCompra,TipoServicio tipoServicio, int codigoServicio) {
		super();
		this.codigoUsuario = codigoUsuario;
		this.cantidad = cantidad;
		this.fechaCompra = fechaCompra;
		this.tipoServicio = tipoServicio;
		this.codigoServicio=codigoServicio;
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


	public long getFechaCompra() {
		return fechaCompra;
	}


	public void setFechaCompra(long fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	
	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}


	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	
	


	public int getCodigoServicio() {
		return codigoServicio;
	}


	public void setCodigoServicio(int codigoServicio) {
		this.codigoServicio = codigoServicio;
	}


	@Override
	public String toString() {
		return "Compra [codigoUsuario=" + codigoUsuario + ", cantidad=" + cantidad + ", fechaCompra=" + fechaCompra
				+ "]";
	}
	
	
	
	
	
	

}
