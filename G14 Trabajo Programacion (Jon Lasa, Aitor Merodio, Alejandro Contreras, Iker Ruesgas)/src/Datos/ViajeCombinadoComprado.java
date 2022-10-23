package Datos;

import java.util.ArrayList;
import java.util.Date;

public class ViajeCombinadoComprado extends Compra {
	
	
	private ViajeCombinado viajeCombinado;
	private ArrayList<Compra> transporte;
	
	//Constructor con parametros
	public ViajeCombinadoComprado(int codigoUsuario, int cantidad, Date fechaCompra, ViajeCombinado viajeCombinado,
			ArrayList<Compra> transporte) {
		super(codigoUsuario, cantidad, fechaCompra);
		this.viajeCombinado = viajeCombinado;
		this.transporte = transporte;
	}
	
	//Constructor con transporte vacio para poder añadirle nosotros?  
	
	public ViajeCombinadoComprado(int codigoUsuario, int cantidad, Date fechaCompra, ViajeCombinado viajeCombinado) {
		super(codigoUsuario, cantidad, fechaCompra);
		this.viajeCombinado = viajeCombinado;
		this.transporte =  new ArrayList<Compra> ();
	}

	public ViajeCombinado getViajeCombinado() {
		return viajeCombinado;
	}

	public void setViajeCombinado(ViajeCombinado viajeCombinado) {
		this.viajeCombinado = viajeCombinado;
	}

	public ArrayList<Compra> getTransporte() {
		return transporte;
	}

	public void setTransporte(ArrayList<Compra> transporte) {
		this.transporte = transporte;
	}

	@Override
	public String toString() {
		return super.toString()+ "ViajeCombinadoComprado [viajeCombinado=" + viajeCombinado + ", transporte=" + transporte + "]";
	}
	
	
	
	
	
	
	
	
	

}
