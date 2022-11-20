package Datos;

import java.util.ArrayList;
import java.util.Date;

import Enum.TipoServicio;

public class VueloComprado extends Compra {
	
	private Vuelo vuelo;
	private ArrayList<RentingCoche> listaRenting; 
	private String asiento;
	
	//Constructor con Parametros
	public VueloComprado(int codigoUsuario, int cantidad, long fechaCompra, TipoServicio tipo,int codigoCompra,  Vuelo vuelo,
			ArrayList<RentingCoche> listaRenting, String asiento) {
		super(codigoUsuario, cantidad, fechaCompra, tipo,codigoCompra);
		this.vuelo = vuelo;
		this.listaRenting = listaRenting;
		this.asiento = asiento;
	}
	
	
	//Constructor sin asiento asignado y lista vacia
	
	public VueloComprado(int codigoUsuario, int cantidad, long fechaCompra, TipoServicio tipoServicio,int codigoCompra, Vuelo vuelo) {
		super(codigoUsuario, cantidad, fechaCompra,tipoServicio,codigoCompra);
		this.listaRenting= new ArrayList<RentingCoche> ();
		this.asiento = "000";
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	
	public ArrayList<RentingCoche> getListaRenting() {
		return listaRenting;
	}

	public void setListaRenting(ArrayList<RentingCoche> listaRenting) {
		this.listaRenting = listaRenting;
	}

	public String getAsiento() {
		return asiento;
	}

	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}

	@Override
	public String toString() {
		return  super.toString()+ "VueloComprado [vuelo=" + vuelo + ", listaRenting=" + listaRenting + ", asiento=" + asiento + "]";
	}
	
	

}
