
package Datos;


import Enum.TipoServicio;

public class BusComprado extends Compra implements PrecioCompra {
	
	private Bus bus;
	private double precio;
	
	//Constructor con parametros
	public BusComprado(int codigoUsuario, int cantidad, String fechaCompra,int codigoCompra, TipoServicio tipoServicio, Bus bus) {
		super(codigoUsuario, cantidad, fechaCompra,tipoServicio, codigoCompra);
		this.bus = bus;
		setPrecio();
		
	}
	
	//Constructor sin asiento asignado
	
	public BusComprado (int codigoUsuario, int cantidad, String fechaCompra, int codigoCompra, TipoServicio tipoServicio, int codigoServicio,Bus bus) {
		super(codigoUsuario,cantidad,fechaCompra, tipoServicio,codigoCompra);
		this.bus = bus;
		setPrecio();
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	//Metodos de la interfaz, los cuales cambiaran de vuelo a bus a viaje comb...
		public double getPrecio() {
			return precio;
		}


		public void setPrecio( ) {
			//Calculamos el precio
			this.precio=(getBus().getPrecio()) * getCantidad();
		}

	
	public String toString() {
		return "Origen: "+bus.getOrigen()+" "+ "Destino: "+bus.getDestino()+" " + "Fecha:"+bus.getFecha()+" Cantidad: "+ getCantidad();
	}

	

}
