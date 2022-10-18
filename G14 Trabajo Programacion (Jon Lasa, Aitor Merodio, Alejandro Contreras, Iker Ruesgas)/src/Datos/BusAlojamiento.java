package Datos;

import Enum.TipoServicioAdic;

public class BusAlojamiento extends ServicioAdicional {
	
	 //Distancia apriximada en kilometros hasta alojamiento;
	private double distancia;
	
	//Constructor con parametros;

	public BusAlojamiento(int precio, TipoServicioAdic servicioAdicional, double distancia) {
		super(precio, servicioAdicional);
		this.distancia = distancia;
	}
	
	
	//Constructor sin parametros
	
	public BusAlojamiento (TipoServicioAdic servicioAdicional) {
		super (servicioAdicional);
		this.distancia = 0;
	}


	public double getDistancia() {
		return distancia;
	}


	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	
	
	public String toString () {
		
		
		return super.toString() + "Distancia: " + distancia;
	}
	
	
	

}
