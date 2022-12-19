package Datos;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Enum.TipoServicio;

public class ViajeCombinado extends Servicio implements Comparable<ViajeCombinado> {
	
	private Vuelo vuelo;
	private Bus bus;
	private final static SimpleDateFormat SDF_FECHA_FOTO = new SimpleDateFormat("yyyy/MM/dd");
	
	//Constructor con parametros
	
	public ViajeCombinado(int codigo, String fecha, String horaSalida, int duracion, String origen, String destino, double precio,
			TipoServicio tipoServicio, int plazarRestantes, Bus bus, Vuelo vuelo) {
		super(codigo, fecha, horaSalida, duracion,  origen, destino, precio, tipoServicio, plazarRestantes);
		this.vuelo=vuelo;
		this.bus=bus;
	}
	
	
	//Constructor con solo parametros vuelo y bus  usando los de la clase padre de la que hereda (SERVICIO)
	public ViajeCombinado(String fecha,TipoServicio tipoServicio,Vuelo vuelo, Bus bus) {
		super(fecha,tipoServicio);
		this.vuelo = vuelo;
		this.bus=bus;
	}

	

	public Vuelo getVuelo() {
		return vuelo;
	}


	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}


	public Bus getBus() {
		return bus;
	}


	public void setBus(Bus bus) {
		this.bus = bus;
	}


	public String toString() {
		return super.toString() + "Vuelo: "+vuelo.toString() + ", Bus: "+bus.toString();
	}


	@Override
	public int compareTo(ViajeCombinado o) {
		Double precio1 = this.getPrecio();
		Double precio2 = o.getPrecio();
		
		if(precio1>precio2) {
			return 1;
		}
		else {
			if(precio1<precio2) {
				return -1;
			}else {
				return 0;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
