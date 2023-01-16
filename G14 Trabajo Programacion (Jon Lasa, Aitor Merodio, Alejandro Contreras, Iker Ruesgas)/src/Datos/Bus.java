package Datos;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Enum.TipoServicio;


public class Bus extends Servicio {
	
	//Clase bus la cual hereda de Servicio
	
	//El bus tendra un atributo String compañia

	private String companya;
	private final static SimpleDateFormat SDF_FECHA_FOTO = new SimpleDateFormat("yyyy-MM-dd");
	

	
	//Constructor con parametros
	public Bus(int codigo, String fecha, String horaSalida, int duracion,  String origen, String destino, double precio, TipoServicio tipoServicio,
			int plazarRestantes, String companya)  {
		super(codigo, fecha, horaSalida, duracion,  origen, destino, precio, tipoServicio, plazarRestantes);
		setCompanya(companya);
	}
	
	//Constructor sin id y tipoServicio
		public Bus(String fecha, String horaSalida, int duracion,  String origen, String destino, double precio,
				int plazasRestantes, String companya)  {
			super(fecha, horaSalida, duracion,  origen, destino, precio, plazasRestantes);
			setCompanya(companya);
		}

	
	//Constructor sin parametros, basandonos en el super de SERVICIO
	public Bus(String fecha, TipoServicio tipoServicio) {
		super(fecha, tipoServicio);
		setCompanya("Sin companya");
	}

	//Get y set de la clase bus

	public String getCompanya() {
		return companya;
	}


	public void setCompanya(String companya) {
		this.companya = companya;
	
	}

	// Metodo toString

	@Override
	public String toString() {
		return super.toString() + " Companya: " + companya;
	}
	
	
	
	//METODO RECURSIVO PARA OBTENER DESDE UNOS BUSES ENTRE FECHAS, CUALES COINCIDEN CON EL ORIGEN Y DESTINO
	//INICIALMENTE PONDREMOS LA LISTACONFILTRADO VACIA, PARA IR AÑADIENDOLE VUELOS Y INDICE 0
	public static ArrayList<Bus> busFiltrado(ArrayList<Bus> listaConBusesTotal, int indice,
			ArrayList<Bus> listaConFiltrado,String origen, String destino, java.util.Date fechaInicio, java.util.Date fechaFin) throws ParseException{
		
		
		//CASO BASE
		if(indice==listaConBusesTotal.size()) {
			return listaConFiltrado;
		}
		//OTRO CASO BASE, ESTA VACIA
		else {
			if(listaConBusesTotal.size()==0) {
				return listaConFiltrado;
			}
			else {
				//obtenemos el vuelo que toca
				
				Bus vuelo = listaConBusesTotal.get(indice);
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
				return busFiltrado(listaConBusesTotal, indice+1, listaConFiltrado,origen,destino,fechaInicio,fechaFin);
			}
			
		}
	
	}
	
	

	
	
	
	
	
	
	
	
	
}
