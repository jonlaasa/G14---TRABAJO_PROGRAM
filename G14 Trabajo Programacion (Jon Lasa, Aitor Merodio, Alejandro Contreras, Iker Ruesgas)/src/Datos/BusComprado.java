package Datos;

import java.util.Date;

import Enum.TipoServicio;

public class BusComprado extends Compra {
	
	private Bus bus;
	private String asiento;
	
	//Constructor con parametros
	public BusComprado(int codigoUsuario, int cantidad, Date fechaCompra, Bus bus, String asiento) {
		super(codigoUsuario, cantidad, fechaCompra);
		this.bus = bus;
		this.asiento = asiento;
	}
	
	//Constructor sin asiento asignado
	
	public BusComprado (int codigoUsuario, int cantidad, Date fechaCompra,Bus bus) {
		super(codigoUsuario,cantidad,fechaCompra);
		this.bus = bus;
		this.asiento = "000";
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public String getAsiento() {
		return asiento;
	}

	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}
	
	public String toString() {
		return super.toString() + "Bus: " + bus +" Asiento :" + asiento;
	}

	

}
