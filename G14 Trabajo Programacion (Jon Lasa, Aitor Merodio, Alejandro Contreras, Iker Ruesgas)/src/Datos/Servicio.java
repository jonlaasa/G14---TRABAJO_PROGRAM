package Datos;

//import java.sql.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import java.util.Date;

import Enum.TipoServicio;
import Logica_de_Negocio.DuracionException;
import Logica_de_Negocio.FechaException;
import Logica_de_Negocio.PlazasRestantesException;
import Logica_de_Negocio.PrecioException;


public class Servicio {
	private int codigo;
	private String fecha;
	//Duracion en minutos
	private int duracion;
	private String origen;
	private String destino;
	private double precio;
	private TipoServicio tipoServicio;
	private int plazasRestantes;
	
	//Constructor con parametros
	public Servicio(int codigo, String fecha,int duracion, String origen, String destino, double precio, TipoServicio tipoServicio, int plazas) throws FechaException, ParseException, DuracionException, PrecioException, PlazasRestantesException {
		super();
		setCodigo(codigo);
		this.fecha=fecha;
		setDuracion(duracion);
		setOrigen(origen);
		setDestino(destino);
		setPrecio(precio);
		setTipoServicio(tipoServicio);
		setPlazasRestantes(plazas);
	}
	
	
	//Por defecto 100 plazas restantes
	
	
	public Servicio(int codigo, String fecha,int duracion, String origen, String destino, double precio, TipoServicio tipoServicio) throws FechaException, ParseException, DuracionException, PrecioException, PlazasRestantesException {
		super();
		setCodigo(codigo);
		setFecha(fecha);
		setDuracion(duracion);
		setOrigen(origen);
		setDestino(destino);
		setPrecio(precio);
		setTipoServicio(tipoServicio);
		setPlazasRestantes(100);
	}
	
	//Constructor sin parametros
	public Servicio() {}
		
	//Constructor con tipoServicio y fecha solo
	public Servicio(String fecha, TipoServicio tipoServicio) throws FechaException, ParseException, DuracionException, PrecioException, PlazasRestantesException {
		super();
	         setCodigo(codigo);
			setFecha("");
			setDuracion(0);
			setOrigen("");
			setDestino("");
			setPrecio(0);
			setTipoServicio(tipoServicio);
			setPlazasRestantes(100);
		}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		if (codigo<0) {
			codigo=000;
			
		}
			this.codigo = codigo;
	}


	public String getFecha() {
		
		return fecha;
	}

	public void setFecha(String fecha) throws FechaException, ParseException {
    
	if (fecha==null) {
		this.fecha="";
	}
	else {
	
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
		Date date = formato.parse(fecha); // Convierte String a Date
		String hoy = LocalDateTime.now().toString(); // Convierte Date a String
		Date now = formato.parse(hoy);
		int diferencia;
		diferencia= date.compareTo(now);
		if (diferencia<=0) {
			throw new FechaException( "Fecha incorrecta: " + fecha);
		}
			this.fecha = fecha;
		}
	}
	

	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) throws DuracionException {
	if (duracion<0) {
		this.duracion=0;
		throw new DuracionException( "Duracion incorrecta: " + getDuracionString());
	}
		this.duracion = duracion;
	}


	public void setOrigen(String origen) {
		if (origen==null) {
			this.origen="";
		}
		else {
			this.origen = origen;
	}
	}


	public String getOrigen() {
		return origen;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		if (destino==null) {
			this.destino="";
		}
		else {
			this.destino = destino;
	}
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) throws PrecioException {
		if (precio<0) {
			throw new PrecioException( "Precio incorrecta: " + precio);
		}
		this.precio = precio;
	}


	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}


	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}


	public int getPlazasRestantes() {
		return plazasRestantes;
	}


	public void setPlazasRestantes(int plazasRestantes) throws PlazasRestantesException {
		if (plazasRestantes>100 | plazasRestantes <0) {
			throw new PlazasRestantesException("Número de plazas incorrecto: "+ plazasRestantes);
		}
			this.plazasRestantes = plazasRestantes;
	}


	@Override
	public String toString() {
		return "Servicio:  TipoServicio= "+ tipoServicio +  "fecha= " + fecha +  "Duracion en minutos= " + duracion +  ", origen=" + origen + ", destino=" + destino
				+ ", precio=" + precio + ", plazasRestantes=" + plazasRestantes
				+ "]";
	}
	

	public String getDuracionString() {
		int horas = duracion / 3600;
		int minutos = (duracion % 3600) / 60;
		if (horas<1) {
			return String.format( minutos +" minutos");
		}else if (horas<2) {
			if (minutos==1) {
				return String.format( horas + " hora, " + minutos +" minuto");
			}else if (minutos==0) {
				return String.format( horas + " hora");
			}else {
				return String.format( horas + " hora, " + minutos +" minutos");
			}
		}else{
			if (minutos<1) {
				return String.format( horas + " horas");
			}else if (minutos==1) {
				return String.format( horas + " horas, " + minutos +" minuto");
			}else {
				return String.format( horas + " horas, " + minutos +" minutos");
			}
		}
	}
	
	
	
	
	
	

	

}
