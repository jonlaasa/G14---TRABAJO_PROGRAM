package Datos;

import java.util.Date;

import Enum.TipoServicio;

public class BusConTicket {
	
	private Bus bus;
	private String asiento;
	
	//Constructor con parametros
	public BusConTicket(Bus bus, String asiento) {
		super();
		this.bus = bus;
		this.asiento = asiento;
	}
	
	//Constructor sin asiento asignado
	
	public BusConTicket (Bus bus) {
		super();
		this.bus = bus;
		this.asiento = "AAA";
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
		return "Bus: " + bus +" Asiento :" + asiento;
	}

	

}
