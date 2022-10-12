package Datos;

import java.sql.Date;

import Enum.TipoServicio;

public class Servicio {
	private int codigo;
	private Date fecha;
	//Duracion en minutos
	private int duracion;
	private String origen;
	private String destino;
	private double precio;
	private TipoServicio tipoServicio;
	private int plazarRestantes;
	
	//Constructor con parametros
	public Servicio(int codigo, Date fecha, int duracion,  String origen, String destino, double precio, TipoServicio tipoServicio,
			int plazarRestantes) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.duracion= duracion;
		this.origen = origen;
		this.destino = destino;
		this.precio = precio;
		this.tipoServicio = tipoServicio;
		this.plazarRestantes = plazarRestantes;
	}
	
	
	//Por defecto 100 plazas restantes
	
	
	public Servicio(int codigo, Date fecha,int duracion, String origen, String destino, double precio, TipoServicio tipoServicio) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.duracion = duracion;
		this.origen = origen;
		this.destino = destino;
		this.precio = precio;
		this.tipoServicio = tipoServicio;
		this.plazarRestantes = 100;
	}
	
	//Constructor con tipoServicio y fecha solo
	public Servicio(Date fecha, TipoServicio tipoServicio) {
		super();
		this.codigo = 0000;
		this.fecha = fecha;
		this.duracion=0;
		this.origen = "";
		this.destino = "";
		this.precio = 0;
		this.tipoServicio = tipoServicio;
		this.plazarRestantes = 100;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	


	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
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


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}


	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}


	public int getPlazarRestantes() {
		return plazarRestantes;
	}


	public void setPlazarRestantes(int plazarRestantes) {
		this.plazarRestantes = plazarRestantes;
	}


	@Override
	public String toString() {
		return "Servicio:  TipoServicio= "+ tipoServicio +  "fecha= " + fecha +  "Duracion en minutos= " + duracion +  ", origen=" + origen + ", destino=" + destino
				+ ", precio=" + precio + ", plazarRestantes=" + plazarRestantes
				+ "]";
	}
	
	
	
	
	
	
	
	
	

	

}
