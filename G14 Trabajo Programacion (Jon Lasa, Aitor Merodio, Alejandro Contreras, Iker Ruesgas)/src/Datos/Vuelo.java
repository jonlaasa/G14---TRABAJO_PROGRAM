package Datos;

import java.sql.Date;

import Enum.TipoServicio;
import Enum.ZonaAsientoVuelo;

public class Vuelo extends Servicio
{
	
	private String companya;
	
	//Constructor de vuelo con parametros
	public Vuelo(int codigo, String fecha, String horaSalida, int duracion, String origen, String destino, double precio,
			TipoServicio tipoServicio, int plazas, String companya 
			) {
		super(codigo, fecha, horaSalida, duracion, origen, destino, precio, tipoServicio, plazas);
		this.companya = companya;
	}
	
	//Constructor sin codigo
	
	public Vuelo( String fecha, String horaSalida, int duracion, String origen, String destino, double precio,
			 int plazas, String companya ) {
		this.companya = companya;
		
	}
	 //Constructor de vuelo sin compañia

	public Vuelo(int codigo, String fecha, String horaSalida, int duracion, String origen, String destino, double precio,
			TipoServicio tipoServicio, int plazas) {
		super(codigo, fecha, horaSalida, duracion, origen, destino, precio, tipoServicio, plazas);
		this.companya="Sin companya";
	}
	
	//Constructor sin parametros, basandonos en el super de SERVICIO
		public Vuelo(String fecha, TipoServicio tipoServicio) {
			super(fecha,tipoServicio);
			setCompanya("Sin companya");
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
		return super.toString() +  "Vuelo [companya=" + companya + "]";
	}


		

	
}
