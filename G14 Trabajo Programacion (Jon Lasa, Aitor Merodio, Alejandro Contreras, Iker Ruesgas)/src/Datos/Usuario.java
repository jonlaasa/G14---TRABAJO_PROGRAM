package Datos;

import java.util.ArrayList;

public class Usuario extends Registro {
	
	private String contrasenya; 
	private String dni;
	private MetodoPago metodoPago;
	private ArrayList<VueloConTicket> vuelos;
	private ArrayList<BusConTicket> buses;
	private ArrayList<ViajeCombinado> viajesConbinados;
	private int puntos ;
	private int codigo;
	
	private static int claveClase=1;
	
	
	//Constructor con parametros
	
	public Usuario(String nombre, String apellido, String usuario, String contrasenya, String dni, int clave,
			MetodoPago metodoPago, ArrayList<VueloConTicket> vuelos, ArrayList<BusConTicket> buses,
			ArrayList<ViajeCombinado> viajesConbinados) {
		super(nombre, apellido, usuario);
		this.contrasenya = contrasenya;
		this.dni = dni;
		this.metodoPago = metodoPago;
		this.vuelos = vuelos;
		this.buses = buses;
		this.viajesConbinados = viajesConbinados;
		this.puntos = 0;
		this.codigo=claveClase;
		claveClase++;
		
	
		
		
	}
	
	
	//Constructor con listaVacias
	
	public Usuario(String nombre, String apellido, String usuario, String contrasenya, String dni, int clave,
			MetodoPago metodoPago) {
		super(nombre, apellido, usuario);
		this.contrasenya = contrasenya;
		this.dni = dni;
		this.metodoPago = metodoPago;
		this.vuelos = new ArrayList<VueloConTicket> ();
		this.buses = new ArrayList<BusConTicket> () ;
		this.viajesConbinados = new ArrayList<ViajeCombinado> ();
		this.puntos = 0;
		this.codigo=claveClase;
		claveClase++;
		
	
		
		
	}
	
	
	//Constructor sin Parametros
	
	public Usuario() {
		super();
		this.contrasenya = "";
		this.dni = "";
		this.metodoPago = new MetodoPago();
		this.vuelos = new ArrayList<VueloConTicket> ();
		this.buses = new ArrayList<BusConTicket> () ;
		this.viajesConbinados = new ArrayList<ViajeCombinado> ();
		this.puntos = 0;
		this.codigo=claveClase;
		claveClase++;
	
	}


	public String getContrasenya() {
		return contrasenya;
	}


	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public MetodoPago getMetodoPago() {
		return metodoPago;
	}


	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}


	public ArrayList<VueloConTicket> getVuelos() {
		return vuelos;
	}


	public void setVuelos(ArrayList<VueloConTicket> vuelos) {
		this.vuelos = vuelos;
	}


	public ArrayList<BusConTicket> getBuses() {
		return buses;
	}


	public void setBuses(ArrayList<BusConTicket> buses) {
		this.buses = buses;
	}


	public ArrayList<ViajeCombinado> getViajesConbinados() {
		return viajesConbinados;
	}


	public void setViajesConbinados(ArrayList<ViajeCombinado> viajesConbinados) {
		this.viajesConbinados = viajesConbinados;
	}


	public int getPuntos() {
		return puntos;
	}


	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public static int getClaveClase() {
		return claveClase;
	}


	public static void setClaveClase(int claveClase) {
		Usuario.claveClase = claveClase;
	}


	@Override
	public String toString() {
		return "Usuario: " + "Nombre: " + getNombre() +" Apellido: " + getApellido() + "Nombre usuario: "  + getNombreUsuario() + " [contrasenya=" + contrasenya + ", dni=" + dni + ", metodoPago=" + metodoPago + ", vuelos="
				+ vuelos + ", buses=" + buses + ", viajesConbinados=" + viajesConbinados + ", puntos=" + puntos;
	}
	
	
	
	
	
	
	
	

}
