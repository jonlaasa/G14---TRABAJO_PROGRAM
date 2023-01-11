package Datos;



import Enum.TipoServicio;


public class Servicio  {
	private int codigo;
	private String fecha;
	private String horaSalida;
	//Duracion en segundos
	private int duracion;
	private String origen;
	private String destino;
	private double precio;
	private TipoServicio tipoServicio;
	private int plazasRestantes;
	
	//Constructor con parametros
	public Servicio(int codigo, String fecha, String horaSalida,int duracion, String origen, String destino, double precio, TipoServicio tipoServicio, int plazas)  {
		super();
		setCodigo(codigo);
		setFecha(fecha);
		setHoraSalida(horaSalida);
		setDuracion(duracion);
		setOrigen(origen);
		setDestino(destino);
		setPrecio(precio);
		setTipoServicio(tipoServicio);
		setPlazasRestantes(plazas);
	}
	
	//Constructor sin id y tipoServicio
	public Servicio(String fecha, String horaSalida, int duracion, String origen, String destino, double precio,int plazas)  {
		super();
		setFecha(fecha);
		setDuracion(duracion);
		setOrigen(origen);
		setDestino(destino);
		setPrecio(precio);
		setPlazasRestantes(plazas);
	}
	
	//Por defecto 100 plazas restantes
	
	
	public Servicio(int codigo, String fecha, String horaSalida,int duracion, String origen, String destino, double precio, TipoServicio tipoServicio) {
		super();
		setCodigo(codigo);
		setFecha(fecha);
		setHoraSalida(horaSalida);
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
	        setFecha(fecha);
			setHoraSalida("");
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
	
	
	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
 
	    this.horaSalida=horaSalida;
	    
	    
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
		return "Servicio:  TipoServicio= "+ tipoServicio +  "fecha= " + fecha + "Hora Salida= " + horaSalida+ "Duracion en segundos= " + duracion +  ", origen=" + origen + ", destino=" + destino
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
		String str = String.valueOf(precio);
		int intNumber = Integer.parseInt(str.substring(0, str.indexOf('.')));
		int decNumberInt = Integer.parseInt(str.substring(str.indexOf('.') + 1));
		if (decNumberInt == 0) {
			return String.format(intNumber + "€");
		}else {
			return String.format(precio + "€");
		}
	}


}
