package Datos;

import java.sql.Date;
import java.text.ParseException;

import Enum.TipoServicio;
import Logica_de_Negocio.DuracionException;
import Logica_de_Negocio.FechaException;
import Logica_de_Negocio.PlazasRestantesException;
import Logica_de_Negocio.PrecioException;

public class Bus extends Servicio {

	private String companya;

	
	//Constructor con parametros
	public Bus(int codigo, String fecha, int duracion,  String origen, String destino, double precio, TipoServicio tipoServicio,
			int plazarRestantes, String companya) throws FechaException, ParseException, DuracionException, PrecioException, PlazasRestantesException {
		super(codigo, fecha, duracion,  origen, destino, precio, tipoServicio, plazarRestantes);
		setCompanya(companya);
	}

	
	//Constructor sin parametros, basandonos en el super de SERVICIO
	public Bus(String fecha, TipoServicio tipoServicio) throws FechaException, ParseException, DuracionException, PrecioException, PlazasRestantesException {
		super(fecha, tipoServicio);
		setCompanya("Sin compañia");
	}


	public String getCompanya() {
		return companya;
	}


	public void setCompanya(String companya) {
		if(companya ==null) {
			this.companya="";
		}
		else {
			this.companya = companya;
		}
	}


	@Override
	public String toString() {
		return super.toString() + " Companya: " + companya;
	}
	
	
	
	
	
	
	
	
	
}
