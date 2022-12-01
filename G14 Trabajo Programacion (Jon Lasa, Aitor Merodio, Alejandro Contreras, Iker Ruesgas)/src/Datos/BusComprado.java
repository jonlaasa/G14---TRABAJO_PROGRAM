package Datos;

import java.util.Date;

import Enum.TipoServicio;

public class BusComprado extends Compra implements PrecioCompra {
	
	private Bus bus;
	private String asiento;
	private double precio;
	
	//Constructor con parametros
	public BusComprado(int codigoUsuario, int cantidad, long fechaCompra, TipoServicio tipoServicio, int codigoServicio, Bus bus, String asiento) {
		super(codigoUsuario, cantidad, fechaCompra,tipoServicio, codigoServicio);
		this.bus = bus;
		this.asiento = asiento;
		setPrecio();
		
	}
	
	//Constructor sin asiento asignado
	
	public BusComprado (int codigoUsuario, int cantidad, long fechaCompra, TipoServicio tipoServicio, int codigoServicio,Bus bus) {
		super(codigoUsuario,cantidad,fechaCompra, tipoServicio,  codigoServicio);
		this.bus = bus;
		this.asiento = "000";
		setPrecio();
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
	
	
	//Metodos de la interfaz, los cuales cambiaran de vuelo a bus a viaje comb...
		public double getPrecio() {
			return precio;
		}


		public void setPrecio( ) {
			//Calculamos el precio
		}

	
	public String toString() {
		return super.toString() + "Bus: " + bus +" Asiento :" + asiento;
	}

	

}
