package Datos;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import Enum.TipoServicio;

public class Vuelo extends Servicio
{
	
	private String companya;
	private final static SimpleDateFormat SDF_FECHA_FOTO = new SimpleDateFormat("yyyy-MM-dd");
	
	//Constructor de vuelo con parametros
	public Vuelo(int codigo, String fecha, String horaSalida, int duracion, String origen, String destino, double precio,
			TipoServicio tipoServicio, int plazas, String companya 
			) {
		super(codigo, fecha, horaSalida, duracion, origen, destino, precio, tipoServicio, plazas);
		this.companya = companya;
	}
	
	//Constructor sin codigo
	
	public Vuelo( String fecha, String horaSalida, int duracion, String origen, String destino, double precio,
			 int plazas, String companya ) {
		this.companya = companya;
		
	}
	 //Constructor de vuelo sin compañia

	public Vuelo(int codigo, String fecha, String horaSalida, int duracion, String origen, String destino, double precio,
			TipoServicio tipoServicio, int plazas) {
		super(codigo, fecha, horaSalida, duracion, origen, destino, precio, tipoServicio, plazas);
		this.companya="Sin companya";
	}
	
	//Constructor sin parametros, basandonos en el super de SERVICIO
		public Vuelo(String fecha, TipoServicio tipoServicio) {
			super(fecha,tipoServicio);
			setCompanya("Sin companya");
		}






	//Constructor Fecha y Tipo de Servicio
	


	public String getCompanya() {
		return companya;
	}


	

	public void setCompanya(String companya) {
		this.companya = companya;
	}



	@Override
	public String toString() {
		return super.toString() +  "Vuelo [companya=" + companya + "]";
	}
	
	//METODO RECURSIVO PARA OBTENER DESDE UNOS VUELOS ENTRE FECHAS, CUALES COINCIDEN CON EL ORIGEN Y DESTINO
	//INICIALMENTE PONDREMOS LA LISTACONFILTRADO VACIA, PARA IR AÑADIENDOLE VUELOS Y INDICE 0
	public static ArrayList<Vuelo> vueloFiltrado(ArrayList<Vuelo> listaConVuelosTotal, int indice,
			ArrayList<Vuelo> listaConFiltrado,String origen, String destino, java.util.Date fechaInicio, java.util.Date fechaFin) throws ParseException{
		
		
		//CASO BASE
		if(indice==listaConVuelosTotal.size()) {
			System.out.println(listaConFiltrado);
			return listaConFiltrado;
		}
		//OTRO CASO BASE, ESTA VACIA
		else {
			if(listaConVuelosTotal.size()==0) {
				return listaConFiltrado;
			}
			else {
				//obtenemos el vuelo que toca
				
				Vuelo vuelo = listaConVuelosTotal.get(indice);
				//COMPROBAMOS SI ESTA DENTRO DE LOS PARAMETROS
				
				//LA FECHA LA PARSEAMOS 
				java.util.Date fechaVuelo = SDF_FECHA_FOTO.parse(vuelo.getFecha());
				
				//AHORA HACEMOS EL IF
				if(fechaVuelo.compareTo(fechaInicio)>=0 && fechaVuelo.compareTo(fechaFin)<=0) {
					if(vuelo.getOrigen().equals(origen) && vuelo.getDestino().equals(destino)) {
						listaConFiltrado.add(vuelo);
					}
					//ENTONCES LO AÑADIMOS A LA LISTA ACTUAL
				
				}	
				return vueloFiltrado(listaConVuelosTotal, indice+1, listaConFiltrado,origen,destino,fechaInicio,fechaFin);
			}
			
		}
	
	}
	
	


		

	
}
