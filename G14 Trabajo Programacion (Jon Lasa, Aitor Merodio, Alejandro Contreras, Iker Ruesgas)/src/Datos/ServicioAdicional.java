package Datos;

import Enum.TipoServicioAdic;

public class ServicioAdicional {
	
	private int precio;
	private TipoServicioAdic servicioAdicional;
	
	//Constructor con parametros
	public ServicioAdicional(int precio, TipoServicioAdic servicioAdicional) {
		super();
		this.precio = precio;
		this.servicioAdicional = servicioAdicional;
	}
	
	//Constructor sin precio
	public ServicioAdicional(TipoServicioAdic servicioAdicional) {
		super();
		this.precio = 0;
		this.servicioAdicional = servicioAdicional;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public TipoServicioAdic getServicioAdicional() {
		return servicioAdicional;
	}

	public void setServicioAdicional(TipoServicioAdic servicioAdicional) {
		this.servicioAdicional = servicioAdicional;
	}

	@Override
	public String toString() {
		return "ServicioAdicional: servicioAdicional=" + servicioAdicional + " precio= " + precio;
	}
	
	
	
	
	
	
	
	

}
