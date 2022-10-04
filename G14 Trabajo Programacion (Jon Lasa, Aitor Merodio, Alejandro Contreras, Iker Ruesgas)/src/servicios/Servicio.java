package servicios;

import enumeraciones.TipoServicio;

public class Servicio {
	
	private double precio;
	private TipoServicio tipoServicio;
	
	
	
	public Servicio(double precio, TipoServicio tipoServicio) {
		super();
		this.precio = precio;
		this.tipoServicio = tipoServicio;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}


	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}


	@Override
	public String toString() {
		return "Servicio [precio=" + precio + ", tipoServicio=" + tipoServicio + "]";
	}
	
	

}
