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
	
private static Connection conn=null;
	
	private static Logger logger;
	
	public static  Connection abrirBaseDatos(String base) {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:"+base);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log(Level.INFO, "Conexion establecida",null);
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
		
	
	}
	
	
	//METODO QUE DEVUELVE UNA LISTA CON LOS BUSES PARA MOSTRAR EN LA TABLA
	public static ArrayList <Bus> mostrarBusesTotal() {
		
		//creamos statement para acceder y arrayList de vuelos VACIO INICIALMENTE
		ArrayList <Bus> listaConBus = new ArrayList <Bus> ();
		
		try {
			Statement st = conn.createStatement();
			
			String resp = "select * from buses";
			ResultSet rs = st.executeQuery(resp);
			while(rs.next()) {
				int codigoVuelo = rs.getInt("Codigo");
				long FechaVuelo = rs.getDate("Fecha").getTime();
				int duracion = rs.getInt("Duracion");
				String origen = rs.getString("Origen");
				String destino = rs.getString("Destino");
				Double precio = rs.getDouble("Precio");
				TipoServicio tipo = TipoServicio.vuelo;
				int plazasRestantes = rs.getInt("Plazas_restantes");
				String companya = rs.getString("Compania");
				
				
				
				Bus busNuevo = new Bus(codigoVuelo, FechaVuelo, duracion, origen,
						destino, precio, tipo,plazasRestantes,companya);
				listaConBus.add(busNuevo);
				
				
				
				
			}
			
		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR AL DEVOLVER BUSES DE LA BASE DE DATOS", e);
			e.printStackTrace();
		}
		
		log(Level.INFO, "DEVOLVIENDO BUSES DE LA BASE DE DATOS", null);
		return listaConBus;
		
		
	}
	
	
	
	//METODO QUE DEVUELVE UNA LISTA CON LOS VUELOS PARA MOSTRAR EN LA TABLA
		public static ArrayList <Vuelo> mostrarVuelosTotal() {
			
			//creamos statement para acceder y arrayList de vuelos VACIO INICIALMENTE
			ArrayList <Vuelo> listaConVuelos = new ArrayList <Vuelo> ();
			
			try {
				Statement st = conn.createStatement();
				
				String resp = "select * from vuelos";
				ResultSet rs = st.executeQuery(resp);
				while(rs.next()) {
					int codigoVuelo = rs.getInt("Codigo");
					long FechaVuelo = rs.getDate("Fecha").getTime();
					int duracion = rs.getInt("Duracion");
					String origen = rs.getString("Origen");
					String destino = rs.getString("Destino");
					Double precio = rs.getDouble("Precio");
					TipoServicio tipo = TipoServicio.vuelo;
					int plazasRestantes = rs.getInt("Plazas_restantes");
					
					
					Vuelo vueloNuevo = new Vuelo(codigoVuelo, FechaVuelo, duracion, origen,
							destino, precio, tipo,plazasRestantes);
					listaConVuelos.add(vueloNuevo);
					
					
					
					
				}
				
			} catch (SQLException e) {
				log(Level.SEVERE, "ERROR AL DEVOLVER VUELOS DE LA BASE DE DATOS", e);
				e.printStackTrace();
			}
			
			log(Level.INFO, "DEVOLVIENDO VUELOS DE LA BASE DE DATOS", null);
			return listaConVuelos;
			
			
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
