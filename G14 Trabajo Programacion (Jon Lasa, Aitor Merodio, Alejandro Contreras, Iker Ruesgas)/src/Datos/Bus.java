package Datos;




import Enum.TipoServicio;


public class Bus extends Servicio {
	
	//Clase bus la cual hereda de Servicio
	
	//El bus tendra un atributo String compañia

	private String companya;

	
	//Constructor con parametros
	public Bus(int codigo, String fecha, String horaSalida, int duracion,  String origen, String destino, double precio, TipoServicio tipoServicio,
			int plazarRestantes, String companya)  {
		super(codigo, fecha, horaSalida, duracion,  origen, destino, precio, tipoServicio, plazarRestantes);
		setCompanya(companya);
	}
	
	//Constructor sin id y tipoServicio
		public Bus(String fecha, String horaSalida, int duracion,  String origen, String destino, double precio,
				int plazasRestantes, String companya)  {
			super(fecha, horaSalida, duracion,  origen, destino, precio, plazasRestantes);
			setCompanya(companya);
		}

	
	//Constructor sin parametros, basandonos en el super de SERVICIO
	public Bus(String fecha, TipoServicio tipoServicio) {
		super(fecha, tipoServicio);
		setCompanya("Sin companya");
	}

	//Get y set de la clase bus

	public String getCompanya() {
		return companya;
	}


	public void setCompanya(String companya) {
		this.companya = companya;
	
	}

	// Metodo toString

	@Override
	public String toString() {
		return super.toString() + " Companya: " + companya;
	}
	
	
	
	
	
	
	
	
	
}
