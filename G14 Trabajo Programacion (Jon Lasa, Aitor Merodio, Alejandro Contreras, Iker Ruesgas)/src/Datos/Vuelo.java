package Datos;

import java.sql.Date;

import Enum.TipoServicio;
import Enum.TipoVuelo;
import Enum.ZonaAsientoVuelo;

public class Vuelo extends Servicio
{
	
	private String companya;
	

	
	//Constructor de vuelo con parametros
	public Vuelo(int codigo, String fecha, int duracion, String origen, String destino, double precio,
			TipoServicio tipoServicio, int plazas, String companya 
			) {
		super(codigo, fecha, duracion, origen, destino, precio, tipoServicio, plazas);
		this.companya = companya;
	}
	
	
	
	 //Constructor de vuelo sin compañia

	public Vuelo(int codigo, String fecha, int duracion, String origen, String destino, double precio,
			TipoServicio tipoServicio, int plazas) {
		super(codigo, fecha, duracion, origen, destino, precio, tipoServicio, plazas);
		this.companya="Sin compañia";
	}
	
	//Constructor sin parametros, basandonos en el super de SERVICIO
		public Vuelo(String fecha, TipoServicio tipoServicio) {
			super(fecha, tipoServicio);
			setCompanya("Sin compa�ia");
		}






	//Constructor Fecha y Tipo de Servicio
	


	public String getCompanya() {
		return companya;
	}


	

	public void setCompanya(String companya) {
		this.companya = companya;
	}



	@Override
	public String toString() {
		return "Vuelo [companya=" + companya + "]";
	}


		

	
}
