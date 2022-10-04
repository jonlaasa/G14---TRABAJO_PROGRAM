package servicios;

import enumeraciones.TipoServicio;

public class Bus extends Servicio {

	private double distancia;

	public Bus(double precio, TipoServicio tipoServicio, double distancia) {
		super(precio, tipoServicio);
		this.distancia = distancia;
	}

	
	
	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}



	@Override
	public String toString() {
		return "Bus [distancia=" + distancia + "]";
	}
	
	
	
	
}
