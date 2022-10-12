package Datos;

import java.sql.Date;

import Enum.TipoServicio;

public class Bus extends Servicio {

	private String compañia;

	
	//Constructor con parametros
	public Bus(int codigo, Date fecha, int duracion,  String origen, String destino, double precio, TipoServicio tipoServicio,
			int plazarRestantes, String compañia) {
		super(codigo, fecha, duracion,  origen, destino, precio, tipoServicio, plazarRestantes);
		this.compañia = compañia;
	}

	
	//Constructor sin parametros, basandonos en el super de SERVICIO
	public Bus(Date fecha, TipoServicio tipoServicio) {
		super(fecha, tipoServicio);
		this.compañia = "Sin compañia";
	}


	public String getCompañia() {
		return compañia;
	}


	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}


	@Override
	public String toString() {
		return super.toString() + " Compañia: " + compañia;
	}
	
	
	
	
	
	
	
	
	
}
