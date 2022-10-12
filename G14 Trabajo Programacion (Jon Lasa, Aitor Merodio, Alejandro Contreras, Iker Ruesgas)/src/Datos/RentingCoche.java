package Datos;

import Enum.ClaseCoche;
import Enum.TipoServicio;
import Enum.TipoServicioAdic;

public class RentingCoche extends ServicioAdicional {

	private int diasAlquilado;
	private ClaseCoche claseCoche;
	
	//Constructor con parametros
	public RentingCoche(int precio, TipoServicioAdic servicioAdicional, int diasAlquilado, ClaseCoche claseCoche) {
		super(precio, servicioAdicional);
		this.diasAlquilado = diasAlquilado;
		this.claseCoche = claseCoche;
	}
	
	//Constructor solo con tipo de servicio Adicional (gamaBaja por defecto y dias alquilados: 0.
	public RentingCoche(TipoServicioAdic servicioAdicional) {
		super (servicioAdicional);
		this.diasAlquilado = 0;
		this.claseCoche = ClaseCoche.gamaBaja;
	}
	
	

	public int getDiasAlquilado() {
		return diasAlquilado;
	}

	public void setDiasAlquilado(int diasAlquilado) {
		this.diasAlquilado = diasAlquilado;
	}

	public ClaseCoche getClaseCoche() {
		return claseCoche;
	}

	public void setClaseCoche(ClaseCoche claseCoche) {
		this.claseCoche = claseCoche;
	}

	
	
	public String toString () {
		
		return super.toString() + "Dias alquilados: "+ diasAlquilado+ " Clase del coche : " + claseCoche;
		
	}
	
	
	
	
	

	
	
}
