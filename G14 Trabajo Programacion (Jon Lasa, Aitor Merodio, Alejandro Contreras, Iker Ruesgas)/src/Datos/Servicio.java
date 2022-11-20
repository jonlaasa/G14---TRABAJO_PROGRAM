package Datos;

import java.sql.Date;

import Enum.TipoServicio;
import logicaDeNegocio.DuracionException;
import logicaDeNegocio.FechaException;
import logicaDeNegocio.PlazasRestantesException;
import logicaDeNegocio.PrecioException;


public class Servicio {
	private int codigo;
	private long fecha;
	//Duracion en minutos
	private int duracion;
	private String origen;
	private String destino;
	private double precio;
	private TipoServicio tipoServicio;
	private int plazasRestantes;
	
	//Constructor con parametros
	public Servicio(int codigo, long fecha,int duracion, String origen, String destino, double precio, TipoServicio tipoServicio, int plazas)  {
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
	
	
	//Por defecto 100 plazas restantes
	
	
	public Servicio(int codigo, long fecha,int duracion, String origen, String destino, double precio, TipoServicio tipoServicio) {
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
	public Servicio(long fecha, TipoServicio tipoServicio)  {
		super();
	         setCodigo(codigo);
			setFecha(0);
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


	public long getFecha() {
		return fecha;
	}

	public void setFecha(long fecha) {
 
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
	
	
	
	//ESTO IGUAL NO ES NECESARIO

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
