package Datos;



import Enum.TipoServicio;

public class ViajeCombinado extends Servicio {
	
	private Vuelo vuelo;
	private Bus bus;
	private String trasbordo;
	
	//Constructor con parametros
	
	public ViajeCombinado(int codigo, String fecha, String horaSalida, int duracion, String origen, String destino, String trasbordo, double precio,
			TipoServicio tipoServicio, int plazarRestantes, Bus bus, Vuelo vuelo) {
		super(codigo, fecha, horaSalida, duracion,  origen, destino, precio, tipoServicio, plazarRestantes);
		this.vuelo=vuelo;
		this.bus=bus;
		this.trasbordo=trasbordo;
	}
	
	
	//Constructor con solo parametros vuelo y bus  usando los de la clase padre de la que hereda (SERVICIO)
	public ViajeCombinado(String fecha,TipoServicio tipoServicio,Vuelo vuelo, Bus bus) {
		super(fecha,tipoServicio);
		this.vuelo = vuelo;
		this.bus=bus;
		this.trasbordo=null;
	}

	

	public ViajeCombinado(String fecha, Vuelo vueloDesdeCodigo, Bus busDesdeCodigo) {
		
		this.setFecha(fecha);
		this.vuelo=vuelo;
		this.bus=bus;
		
	}


	public Vuelo getVuelo() {
		return vuelo;
	}


	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}


	public Bus getBus() {
		return bus;
	}


	public void setBus(Bus bus) {
		this.bus = bus;
	}
	


	public String getTrasbordo() {
		return trasbordo;
	}


	public void setTrasbordo(String trasbordo) {
		this.trasbordo = trasbordo;
	}

	public String toString() {
		return super.toString() + "Trasbordo: "+trasbordo+ "Vuelo: "+vuelo.toString() + ", Bus: "+bus.toString();
	}



	
	
	
	
	
	
	
	
	
	

}
