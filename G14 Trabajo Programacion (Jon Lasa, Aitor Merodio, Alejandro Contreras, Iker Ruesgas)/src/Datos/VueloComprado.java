package Datos;

import java.util.ArrayList;
import java.util.Date;

import Enum.TipoServicio;
import Enum.ZonaAsientoVuelo;

public class VueloComprado extends Compra implements PrecioCompra {
	
	private Vuelo vuelo;
	private ArrayList<RentingCoche> listaRenting; 
	private ZonaAsientoVuelo zonaAsientoVuelo;
	private double precio;
	
	//Constructor con Parametros
	public VueloComprado(int codigoUsuario, int cantidad, String fechaCompra, TipoServicio tipo,int codigoCompra,  Vuelo vuelo,
			ArrayList<RentingCoche> listaRenting,ZonaAsientoVuelo zonaAsientoVuelo) {
		super(codigoUsuario, cantidad, fechaCompra, tipo,codigoCompra);
		this.vuelo = vuelo;
		this.listaRenting = listaRenting;
		this.zonaAsientoVuelo=zonaAsientoVuelo;
		setPrecio();
		
		
	}
	
	
	//Constructor sin ZONA asignado y lista vacia
	
	public VueloComprado(int codigoUsuario, int cantidad, String fechaCompra, TipoServicio tipoServicio,int codigoCompra, Vuelo vuelo) {
		super(codigoUsuario, cantidad, fechaCompra,tipoServicio,codigoCompra);
		this.vuelo=vuelo;
		this.listaRenting= new ArrayList<RentingCoche> ();
		this.zonaAsientoVuelo= zonaAsientoVuelo.trasera;
		
		setPrecio();
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	
	public ArrayList<RentingCoche> getListaRenting() {
		return listaRenting;
	}

	public void setListaRenting(ArrayList<RentingCoche> listaRenting) {
		this.listaRenting = listaRenting;
	}

	public ZonaAsientoVuelo getZonaAsientoVuelo() {
		return zonaAsientoVuelo;
	}


	public void setZonaAsientoVuelo(ZonaAsientoVuelo zonaAsientoVuelo) {
		this.zonaAsientoVuelo = zonaAsientoVuelo;
	}
	
	
	//Metodos de la interfaz, los cuales cambiaran de vuelo a bus a viaje comb...
	public double getPrecio() {
		return precio;
	}


	public void setPrecio( ) {
		//CANTIDAD POR PRECIO DEL avion * cantidad + renting + zona vuelo ...
		double vueloSuma = getCantidad() * (getVuelo().getPrecio());
	
		double sumaZonaAsiento = getZonaAsientoVuelo().precio();
		
		
		
		//PARA CALCULAR EL RENTING
		double sumaRenting = 0;
		if(listaRenting.size()==0) {
			sumaRenting=0;
		}else {
			RentingCoche renting = listaRenting.get(0);
			sumaRenting=renting.getPrecio();
		}
		//FINALMENTE PONEMOS EL PRECIO
		
		this.precio=vueloSuma + sumaZonaAsiento + sumaRenting;
		
		
	}


	@Override
	public String toString() {
		return "VueloComprado [vuelo=" + vuelo + ", listaRenting=" + listaRenting 
				+ ", zonaAsientoVuelo=" + zonaAsientoVuelo + "]";
	}


}
