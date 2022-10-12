package Datos;

import java.sql.Date;

import Enum.TipoServicio;

public class Bus extends Servicio {

	private String compa�ia;

	
	//Constructor con parametros
	public Bus(int codigo, Date fecha, int duracion,  String origen, String destino, double precio, TipoServicio tipoServicio,
			int plazarRestantes, String compa�ia) {
		super(codigo, fecha, duracion,  origen, destino, precio, tipoServicio, plazarRestantes);
		this.compa�ia = compa�ia;
	}

	
	//Constructor sin parametros, basandonos en el super de SERVICIO
	public Bus(Date fecha, TipoServicio tipoServicio) {
		super(fecha, tipoServicio);
		this.compa�ia = "Sin compa�ia";
	}


	public String getCompa�ia() {
		return compa�ia;
	}


	public void setCompa�ia(String compa�ia) {
		this.compa�ia = compa�ia;
	}


	@Override
	public String toString() {
		return super.toString() + " Compa�ia: " + compa�ia;
	}
	
	
	
	
	
	
	
	
	
}
