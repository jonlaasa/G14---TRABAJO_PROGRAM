package servicios;

import enumeraciones.TipoExcursion;
import enumeraciones.TipoServicio;

public class Excursion extends Servicio {


	private TipoExcursion tipoExcursion;
	private int duracion;
	
	
	public Excursion(double precio, TipoServicio tipoServicio, TipoExcursion tipoExcursion, int duracion) {
		super(precio, tipoServicio);
		this.tipoExcursion = tipoExcursion;
		this.duracion = duracion;
	}


	public TipoExcursion getTipoExcursion() {
		return tipoExcursion;
	}

	public void setTipoExcursion(TipoExcursion tipoExcursion) {
		this.tipoExcursion = tipoExcursion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	@Override
	public String toString() {
		return "Excursion [tipoExcursion=" + tipoExcursion + ", duracion=" + duracion + "]";
	}
	
	
	
	
	
	
	
}
