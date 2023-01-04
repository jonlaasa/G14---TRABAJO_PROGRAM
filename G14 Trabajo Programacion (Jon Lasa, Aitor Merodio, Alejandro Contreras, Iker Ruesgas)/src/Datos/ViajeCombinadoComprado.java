package Datos;

import java.util.ArrayList;
import java.util.Date;

import Enum.TipoServicio;

public class ViajeCombinadoComprado extends Compra implements PrecioCompra {
	
	
	private ViajeCombinado viajeCombinado;
	private double precio;
	
	//Constructor con parametros
	public ViajeCombinadoComprado(int codigoUsuario, int cantidad, String fechaCompra,TipoServicio tipo, int codigoCompra,
			ViajeCombinado viajeCombinado) {
		super(codigoUsuario, cantidad, fechaCompra,tipo, codigoCompra);
		this.viajeCombinado = viajeCombinado;
		setPrecio();
		
	}
	


	public ViajeCombinado getViajeCombinado() {
		return viajeCombinado;
	}

	public void setViajeCombinado(ViajeCombinado viajeCombinado) {
		this.viajeCombinado = viajeCombinado;
	}

	

	@Override
	public String toString() {
		return super.toString()+ "ViajeCombinadoComprado [viajeCombinado=" + viajeCombinado;
	}

	@Override
	public double getPrecio() {
		// TODO Auto-generated method stub
		return this.precio;
	}

	@Override
	public void setPrecio() {
		// TODO Auto-generated method stub
		double precioVuelo = this.viajeCombinado.getVuelo().getPrecio();
		double precioBus = this.viajeCombinado.getBus().getPrecio();
		this.precio=(precioVuelo+precioBus)*getCantidad();
		
		
	}
	
	
	
	
	
	
	
	
	

}
