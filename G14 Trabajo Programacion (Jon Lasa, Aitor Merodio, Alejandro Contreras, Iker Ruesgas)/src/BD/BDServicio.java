package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import Datos.Bus;
import Datos.Compra;
import Datos.Usuario;
import Datos.Vuelo;
import Enum.TipoServicio;

public class BDServicio {
	
private static Connection conn;
	
	private static Logger logger;
	
	public static  Connection abrirBaseDatos(String base) {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:"+base);
			log(Level.INFO, "Accediendo a la base de datos:" + base, null);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (SQLException e) {
			log(Level.SEVERE, "ERROR AL INTENTAR ACCEDER A LA BASE DE DATOS", e);
			e.printStackTrace();
		}
		return conn;

		
	}
	
	

	public static void cerrarConexion () {
		
		
		try {
			log(Level.INFO, "Conexion cerrada",null);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	
	public static void compraServicio (Compra compra) {
		BDServicio.abrirBaseDatos("basesDeDatos/serviciosCompanya.bd");
		//Primero obtenemos el tipoDeServicio
		TipoServicio tipoServicio=compra.getTipoServicio();
		//Obtenemos el codigo UNICO del usuario
		
		int codigo = compra.getCodigoUsuario();
		Date fecha = new Date(compra.getFechaCompra());
		String tipo = compra.getTipoServicio().toString();
		int codigoCompra = compra.getCodigoServicio();
		
		//String de añadir
		
		try {
			Statement st = conn.createStatement();
			String añadir = "Insert into Compra values ("+codigo+", "+"'"+fecha+
					"' ,"+compra.getCantidad()+", '"+tipo+"' ,"+ codigoCompra;
			int valor = st.executeUpdate(añadir);
			if(valor==0) {
				log(Level.SEVERE,"Compra no ha podido ser registrada",null);
				
			}else {
				log(Level.INFO,"Compra registrada con exito",null);
			}
			
			
		} catch (SQLException e) {
			log(Level.INFO,"Error al intentar acceder a la base de datos",null);
			e.printStackTrace();
		}
		
		BDServicio.cerrarConexion();
		
	
	}
	
	
	//METODO QUE DEVUELVE UNA LISTA CON LOS BUSES PARA MOSTRAR EN LA TABLA
	public static ArrayList <Bus> mostrarBusesTotal() {
		BDServicio.abrirBaseDatos("basesDeDatos/serviciosCompanya.db");
		//creamos statement para acceder y arrayList de vuelos VACIO INICIALMENTE
		ArrayList <Bus> listaConBus = new ArrayList <Bus> ();
		
		try {
			Statement st = conn.createStatement();
			
			String resp = "select * from bus";
			ResultSet rs = st.executeQuery(resp);
			while(rs.next()) {
				int codigoVuelo = rs.getInt("Cod_bus");
				String FechaVuelo = rs.getString("Fecha");
				int duracion = rs.getInt("Duracion");
				String origen = rs.getString("Origen");
				String destino = rs.getString("Destino");
				Double precio = rs.getDouble("Precio");
				TipoServicio tipo = TipoServicio.vuelo;
				int plazasRestantes = rs.getInt("Plazas_restantes");
				String companya = rs.getString("Companya_bus");
				
				
				
				Bus busNuevo = new Bus(codigoVuelo, FechaVuelo, duracion, origen,
						destino, precio, tipo,plazasRestantes,companya);
				listaConBus.add(busNuevo);
				
				
				
				
			}
			
		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR AL DEVOLVER BUSES DE LA BASE DE DATOS", e);
			e.printStackTrace();
		}
		
		log(Level.INFO, "DEVOLVIENDO BUSES DE LA BASE DE DATOS", null);
		BDServicio.cerrarConexion();
		return listaConBus;
		
		
	}
	
	
	
	//METODO QUE DEVUELVE UNA LISTA CON LOS VUELOS PARA MOSTRAR EN LA TABLA
		public static ArrayList <Vuelo> mostrarVuelosTotal() {
			BDServicio.abrirBaseDatos("basesDeDatos//serviciosCompanya.db");
			//creamos statement para acceder y arrayList de vuelos VACIO INICIALMENTE
			ArrayList <Vuelo> listaConVuelos = new ArrayList <Vuelo> ();
			
			try {
				Statement st = conn.createStatement();
				
				String resp = "select * from vuelo";
				ResultSet rs = st.executeQuery(resp);
				while(rs.next()) {
					int codigoVuelo = rs.getInt("Cod_vuelo");
					String FechaVuelo = rs.getString("Fecha");
					int duracion = rs.getInt("Duracion");
					String origen = rs.getString("Origen");
					String destino = rs.getString("Destino");
					Double precio = rs.getDouble("Precio");
					TipoServicio tipo = TipoServicio.vuelo;
					int plazasRestantes = rs.getInt("Plazas_restantes");
					String companya= rs.getString("Companya_vuelo");
					
					
					Vuelo vueloNuevo = new Vuelo(codigoVuelo, FechaVuelo, duracion, origen,
							destino, precio, tipo,plazasRestantes,companya);
					listaConVuelos.add(vueloNuevo);
					
					
					
					
				}
				
			} catch (SQLException e) {
				log(Level.SEVERE, "ERROR AL DEVOLVER VUELOS DE LA BASE DE DATOS", e);
				e.printStackTrace();
			}
			
			BDServicio.cerrarConexion();
			return listaConVuelos;
			
			
		}
		
		
		//FALTA LAS FECHAS
		public static ArrayList<Vuelo> listaServicioVueloFiltrado (String origen, String destino, String orden){
			BDServicio.abrirBaseDatos("basesDeDatos//serviciosCompanya.db");
			//creamos statement para acceder y arrayList de vuelos VACIO INICIALMENTE
			ArrayList <Vuelo> listaConVuelos = new ArrayList <Vuelo> ();
			String sent="";
			
			try {
				Statement st = conn.createStatement();
				if(orden.equals("menor")) {
				 sent= "select * from vuelo where origen='"+origen+"' and destino='"+destino+"' order by precio asc";
				}else {
				     sent= "select * from vuelo where origen='"+origen+"' and destino='"+destino+"' order by precio desc";
				}
				
				ResultSet rs = st.executeQuery(sent);
				while(rs.next()) {
					int codigoVuelo = rs.getInt("Cod_vuelo");
					String FechaVuelo = rs.getString("Fecha");
					int duracion = rs.getInt("Duracion");
					String origenV = rs.getString("Origen");
					String destinoV = rs.getString("Destino");
					Double precio = rs.getDouble("Precio");
					TipoServicio tipo = TipoServicio.vuelo;
					int plazasRestantes = rs.getInt("Plazas_restantes");
					String companya= rs.getString("Companya_vuelo");
					
					
					Vuelo vueloNuevo = new Vuelo(codigoVuelo, FechaVuelo, duracion, origenV,
							destinoV, precio, tipo,plazasRestantes,companya);
					listaConVuelos.add(vueloNuevo);	
					
				}
			}catch(SQLException sql) {
				log(Level.SEVERE, "ERROR EN CONSULTA DE BASE DE DATOS CON FILTRADO DE VUELOS", sql);
			}

			return listaConVuelos;
		}
		
		
		
		
		
		public static ArrayList<Bus> listaServicioBusFiltrado (String origen, String destino, String orden){
			BDServicio.abrirBaseDatos("basesDeDatos//serviciosCompanya.db");
			//creamos statement para acceder y arrayList de vuelos VACIO INICIALMENTE
			ArrayList <Bus> listaConBus = new ArrayList <Bus> ();
			String sent="";
			
			try {
				Statement st = conn.createStatement();
				if(orden.equals("menor")) {
				 sent= "select * from bus where origen='"+origen+"' and destino='"+destino+"' order by precio asc";
				}else {
				     sent= "select * from bus where origen='"+origen+"' and destino='"+destino+"' order by precio desc";
				}
				
				ResultSet rs = st.executeQuery(sent);
				while(rs.next()) {
					int codigoBus = rs.getInt("Cod_bus");
					String FechaBus = rs.getString("Fecha");
					int duracion = rs.getInt("Duracion");
					String origenV = rs.getString("Origen");
					String destinoV = rs.getString("Destino");
					Double precio = rs.getDouble("Precio");
					TipoServicio tipo = TipoServicio.bus;
					int plazasRestantes = rs.getInt("Plazas_restantes");
					String companya= rs.getString("Companya_vuelo");
					
					
					Bus busNuevo = new Bus(codigoBus, FechaBus, duracion, origenV,
							destinoV, precio, tipo,plazasRestantes,companya);
					listaConBus.add(busNuevo);	
					
				}
			}catch(SQLException sql) {
				log(Level.SEVERE, "ERROR EN CONSULTA DE BASE DE DATOS CON FILTRADO DE BUS", sql);
			}

			return listaConBus;
		}
		
	
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	public static void log( Level level, String msg, Throwable excepcion ) {
		if (logger==null) {  // Logger por defecto sera el local:
			logger = Logger.getLogger( "Log-BD" );  // Nombre del logger
			logger.setLevel( Level.ALL );  // Loguea todos los niveles
			try {
				logger.addHandler( new FileHandler( "T&T-log.xml", true ) );  // Y saca el log a fichero xml
			} catch (Exception e) {
				logger.log( Level.SEVERE, "No se pudo crear fichero de log", e );
			}
		}
		if (excepcion==null)
			logger.log( level, msg );
		else
			logger.log( level, msg, excepcion );
	}


	
	

}
