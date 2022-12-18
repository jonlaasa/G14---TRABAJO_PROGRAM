package Datos;

import java.util.ArrayList;
import java.util.Date;

import Enum.TipoServicio;

public class ViajeCombinadoComprado extends Compra {
	
	
	private ViajeCombinado viajeCombinado;
	
	//Constructor con parametros
	public ViajeCombinadoComprado(int codigoUsuario, int cantidad, String fechaCompra,TipoServicio tipo, int codigoCompra, ViajeCombinado viajeCombinado,
			ArrayList<Compra> transporte) {
		super(codigoUsuario, cantidad, fechaCompra,tipo, codigoCompra);
		this.viajeCombinado = viajeCombinado;
		
	}
	
	//Constructor con transporte vacio para poder a�adirle nosotros?  
	
	public ViajeCombinadoComprado(int codigoUsuario, int cantidad, String fechaCompra,TipoServicio tipo, int codigoCompra, ViajeCombinado viajeCombinado) {
		super(codigoUsuario, cantidad, fechaCompra,tipo,codigoCompra);
		this.viajeCombinado = viajeCombinado;
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
	
	
	
	
	
	
	
	
	

}
