package Datos;

import Enum.ClaseCoche;
import Enum.TipoServicio;

public class RentingCoche {
	
	private double precio;
	private int diasAlquilado;
	private ClaseCoche claseCoche;
	
	//Constructor con parametros
	public RentingCoche(int diasAlquilado, ClaseCoche claseCoche) {
		this.diasAlquilado = diasAlquilado;
		this.claseCoche = claseCoche;
		setPrecio();
	}
	
	//Constructor vacio, con valores por defecto.
	public RentingCoche() {
		this.diasAlquilado = 0;
		this.claseCoche = ClaseCoche.gamaBaja;
		setPrecio();
	}
	
	

	public double getPrecio() {
		return precio;
	}

	public void setPrecio() {
		this.precio = diasAlquilado * claseCoche.precio();
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

	@Override
	public String toString() {
		return "RentingCoche [precio=" + precio + ", diasAlquilado=" + diasAlquilado + ", claseCoche=" + claseCoche
				+ "]";
	}

	

	
	
}
