package Datos;

public class VueloConTicket {
	
	private Vuelo vuelo;
	private String asiento;
	
	//Constructor con Parametros
	public VueloConTicket(Vuelo vuelo, String asiento) {
		super();
		this.vuelo = vuelo;
		this.asiento = asiento;
	}
	
	//Constructor sin asiento asignado
	
	public VueloConTicket (Vuelo vuelo) {
		super();
		this.vuelo = vuelo;
		this.asiento = "000";
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public String getAsiento() {
		return asiento;
	}

	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}
	
	public String toString() {
		return "Vuelo: " + vuelo +" Asiento :" + asiento;
	}

}
