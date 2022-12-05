package Datos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.DataTruncation;
import java.sql.Date;

import Enum.TipoServicio;
import logicaDeNegocio.DuracionException;
import logicaDeNegocio.FechaException;
import logicaDeNegocio.PlazasRestantesException;
import logicaDeNegocio.PrecioException;


public class Servicio  {
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
	public Servicio(int codigo, String fecha,int duracion, String origen, String destino, double precio, TipoServicio tipoServicio, int plazas)  {
		super();
		setCodigo(codigo);
		setFecha(fecha);
		setDuracion(duracion);
		setOrigen(origen);
		setDestino(destino);
		setPrecio(precio);
		setTipoServicio(tipoServicio);
		setPlazasRestantes(plazas);
	}
	
	//Constructor sin id y tipoServicio
	public Servicio(String fecha,int duracion, String origen, String destino, double precio,int plazas)  {
		super();
		setFecha(fecha);
		setDuracion(duracion);
		setOrigen(origen);
		setDestino(destino);
		setPrecio(precio);
		setPlazasRestantes(plazas);
	}
	
	//Por defecto 100 plazas restantes
	
	
	public Servicio(int codigo, String fecha,int duracion, String origen, String destino, double precio, TipoServicio tipoServicio) {
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
	public Servicio(String fecha, TipoServicio tipoServicio)  {
	         setCodigo(0);
			setFecha("");
			setDuracion(0);
			setOrigen("");
			setDestino("");
			setPrecio(0);
			setTipoServicio(tipoServicio);
			setPlazasRestantes(100);
		}


	
	
	//IMPORTANTE, LA VALIDACION DE LOS VALORES, LA HAREMOS EN LAS VENTANAS, AL PULSAR LOS BOTONES PARA CONFRIMAR LOS DATOS
	//AHI GESTIONAREMOS LAS EXCPECIONES
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
 
	    this.fecha=fecha;
	    
	    
	}
	

	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion)  {
	
		this.duracion=duracion;
	

	}
	public void setOrigen(String origen) {
			this.origen = origen;
	}
	


	public String getOrigen() {
		return origen;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
	
			this.destino = destino;
	
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio)  {
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


	public void setPlazasRestantes(int plazasRestantes)  {
		
			this.plazasRestantes = plazasRestantes;
	}


	@Override
	public String toString() {
		return "Servicio:  TipoServicio= "+ tipoServicio +  "fecha= " + fecha +  "Duracion en minutos= " + duracion +  ", origen=" + origen + ", destino=" + destino
				+ ", precio=" + precio + ", plazasRestantes=" + plazasRestantes
				+ "]";
	}
	
	
	
	//METODOS DE VISUALIZACION DE DATOS

	public String getDuracionString() {
		int horas = duracion / 3600;
		int minutos = (duracion % 3600) / 60;
		if (horas<1) {
			return String.format( minutos +" mins");
		}else if (horas<2) {
			if (minutos==1) {
				return String.format( horas + " h, " + minutos +" min");
			}else if (minutos==0) {
				return String.format( horas + " h");
			}else {
				return String.format( horas + " h, " + minutos +" mins");
			}
		}else{
			if (minutos<1) {
				return String.format( horas + " hrs");
			}else if (minutos==1) {
				return String.format( horas + " hrs, " + minutos +" min");
			}else {
				return String.format( horas + " hrs, " + minutos +" mins");
			}
		}
	}
	
	public String getPrecioString() {
		BigDecimal bd = new BigDecimal(String.valueOf(precio));
		BigDecimal parteDecimal = bd.subtract(bd.setScale(0, RoundingMode.FLOOR)).movePointRight(bd.scale());
		if (parteDecimal == bd.ZERO) {
			int precioRedondeado = (int) Math.round(precio);
			return String.format(precioRedondeado + "€");
		}else {
			return String.format(precio + "€");
		}
	}
	
 

}
