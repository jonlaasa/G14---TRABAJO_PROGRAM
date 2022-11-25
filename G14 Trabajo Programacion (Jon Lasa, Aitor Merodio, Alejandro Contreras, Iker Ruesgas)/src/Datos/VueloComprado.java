package Datos;

import java.util.ArrayList;
import java.util.Date;

import Enum.TipoServicio;
import Enum.TipoVuelo;
import Enum.ZonaAsientoVuelo;

public class VueloComprado extends Compra {
	
	private Vuelo vuelo;
	private ArrayList<RentingCoche> listaRenting; 
	private TipoVuelo tipoVuelo;
	private ZonaAsientoVuelo zonaAsientoVuelo;
	
	//Constructor con Parametros
	public VueloComprado(int codigoUsuario, int cantidad, long fechaCompra, TipoServicio tipo,int codigoCompra,  Vuelo vuelo,
			ArrayList<RentingCoche> listaRenting, String asiento, TipoVuelo tipoVuelo,ZonaAsientoVuelo zonaAsientoVuelo) {
		super(codigoUsuario, cantidad, fechaCompra, tipo,codigoCompra);
		this.vuelo = vuelo;
		this.listaRenting = listaRenting;
		this.tipoVuelo=tipoVuelo;
		this.zonaAsientoVuelo=zonaAsientoVuelo;
	}
	
	
	//Constructor sin asiento asignado y lista vacia
	
	public VueloComprado(int codigoUsuario, int cantidad, long fechaCompra, TipoServicio tipoServicio,int codigoCompra, Vuelo vuelo) {
		super(codigoUsuario, cantidad, fechaCompra,tipoServicio,codigoCompra);
		this.listaRenting= new ArrayList<RentingCoche> ();
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

	
	public TipoVuelo getTipoVuelo() {
		return tipoVuelo;
	}


	public void setTipoVuelo(TipoVuelo tipoVuelo) {
		this.tipoVuelo = tipoVuelo;
	}


	public ZonaAsientoVuelo getZonaAsientoVuelo() {
		return zonaAsientoVuelo;
	}


	public void setZonaAsientoVuelo(ZonaAsientoVuelo zonaAsientoVuelo) {
		this.zonaAsientoVuelo = zonaAsientoVuelo;
	}


	@Override
	public String toString() {
		return "VueloComprado [vuelo=" + vuelo + ", listaRenting=" + listaRenting + ", tipoVuelo=" + tipoVuelo
				+ ", zonaAsientoVuelo=" + zonaAsientoVuelo + "]";
	}


}
