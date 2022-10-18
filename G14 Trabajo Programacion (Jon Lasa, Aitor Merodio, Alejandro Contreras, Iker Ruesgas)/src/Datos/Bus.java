package Datos;

import java.sql.Date;

import Enum.TipoServicio;

public class Bus extends Servicio {

	private String companya;

	
	//Constructor con parametros
	public Bus(int codigo, Date fecha, int duracion,  String origen, String destino, double precio, TipoServicio tipoServicio,
			int plazarRestantes, String companya) {
		super(codigo, fecha, duracion,  origen, destino, precio, tipoServicio, plazarRestantes);
		this.companya = companya;
	}

	
	//Constructor sin parametros, basandonos en el super de SERVICIO
	public Bus(Date fecha, TipoServicio tipoServicio) {
		super(fecha, tipoServicio);
		this.companya = "Sin companya";
	}


	public String getCompanya() {
		return companya;
	}


	public void setCompanya(String companya) {
		this.companya = companya;
	}


	@Override
	public String toString() {
		return super.toString() + " Companya: " + companya;
	}
	
	
	
	
	
	
	
	
	
}
