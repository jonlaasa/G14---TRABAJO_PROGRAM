package Datos;

import java.sql.Date;
import java.text.ParseException;

import Enum.TipoServicio;
import logicaDeNegocio.DuracionException;
import logicaDeNegocio.FechaException;
import logicaDeNegocio.PlazasRestantesException;
import logicaDeNegocio.PrecioException;

public class Bus extends Servicio {

	private String companya;

	
	//Constructor con parametros
	public Bus(int codigo, long fecha, int duracion,  String origen, String destino, double precio, TipoServicio tipoServicio,
			int plazarRestantes, String companya) throws FechaException, ParseException, DuracionException, PrecioException, PlazasRestantesException {
		super(codigo, fecha, duracion,  origen, destino, precio, tipoServicio, plazarRestantes);
		setCompanya(companya);
	}

	
	//Constructor sin parametros, basandonos en el super de SERVICIO
	public Bus(long fecha, TipoServicio tipoServicio) {
		super(fecha, tipoServicio);
		setCompanya("Sin compa�ia");
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
