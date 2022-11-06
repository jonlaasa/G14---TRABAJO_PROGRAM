package Datos;

import java.sql.Date;

import Enum.TipoServicio;
import Enum.TipoVuelo;
import Enum.ZonaAsientoVuelo;

public class Vuelo extends Servicio {
	
	private String companya;
	private TipoVuelo tipoVuelo;
	private ZonaAsientoVuelo zonaAsientoVuelo;

	//Constructor con parametros
	public Vuelo(int codigo, Date fecha, int duracion,  String origen, String destino, double precio, TipoServicio tipoServicio,
			int plazarRestantes, String companya, TipoVuelo tipoVuelo, ZonaAsientoVuelo zonaAsientoVuelo) {
		this.companya = companya;
		this.tipoVuelo = tipoVuelo;
		this.zonaAsientoVuelo = zonaAsientoVuelo;
	}

	
	//Constructor Fecha y Tipo de Servicio
	public Vuelo(Date fecha, TipoServicio tipoServicio) {
		this.companya = "Sin companya";
	}


	public String getCompanya() {
		return companya;
	}


	public void setCompanya(String companya) {
		this.companya = companya;
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
		return super.toString() + "Companya: "+ companya + "TipoVuelo: " + tipoVuelo + "ZonaAsientoVuelo: " + zonaAsientoVuelo;
	}
				

	
}
