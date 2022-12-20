package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.TreeSet;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import Datos.Bus;
import Datos.BusComprado;
import Datos.Compra;
import Datos.Servicio;
import Datos.Usuario;
import Datos.ViajeCombinado;
import Datos.Vuelo;
import Datos.VueloComprado;
import Enum.TipoServicio;
import VentanasCompra.VentanaConfirmacionCompra;

public class BDServicio {


private static Connection conn;
private static PreparedStatement pst;
private final static SimpleDateFormat SDF_FECHA_FOTO = new SimpleDateFormat("yyyy-MM-dd");
	
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
		int codigoCompra = compra.getCodigoCompra();
		
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
				String horaSalidaVuelo = rs.getString("Hora_salida");
				int duracion = rs.getInt("Duracion");
				String origen = rs.getString("Origen");
				String destino = rs.getString("Destino");
				Double precio = rs.getDouble("Precio");
				TipoServicio tipo = TipoServicio.vuelo;
				int plazasRestantes = rs.getInt("Plazas_restantes");
				String companya = rs.getString("Companya_bus");
				
				
				
				Bus busNuevo = new Bus(codigoVuelo, FechaVuelo, horaSalidaVuelo, duracion, origen,
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
	
	//METODO QUE DELVUELVE LOS DIFERENTES ORIGENES DE LOS VUELOS O LOS BUSES
	
			public static ArrayList<String> mostrarDiferentesOrigenes(String servicio){
				BDServicio.abrirBaseDatos("basesDeDatos//serviciosCompanya.db");
				//creamos statement para acceder y arrayList de vuelos VACIO INICIALMENTE
				ArrayList<String> listaOrigenes= new ArrayList<String> () ;
				
				try {
					Statement st = conn.createStatement();
					String sent="";
					
					if(servicio.equals("bus")) {
						sent= "select distinct ORIGEN from bus";
					}else {
						sent= "select distinct ORIGEN from vuelo";
						}
					
					ResultSet rs = st.executeQuery(sent);
					while(rs.next()) {
						String origen = rs.getString("Origen");
						
						listaOrigenes.add(origen);
						
					}
					
				} catch (SQLException e) {
					log(Level.SEVERE, "ERROR AL DEVOLVER VUELOS DE LA BASE DE DATOS", e);
					e.printStackTrace();
				}
				
				BDServicio.cerrarConexion();
				return listaOrigenes;
				
			}
			
	//METODO QUE DELVUELVE LOS DIFERENTES DESTINOS DE LOS VUELOS O LOS BUSES
	
		public static ArrayList<String> mostrarDiferentesDestinos(String servicio){
			BDServicio.abrirBaseDatos("basesDeDatos//serviciosCompanya.db");
			//creamos statement para acceder y arrayList de vuelos VACIO INICIALMENTE
			ArrayList<String> listaDestinos= new ArrayList<String> () ;
			
			try {
				Statement st = conn.createStatement();
				String sent="";
				
				if(servicio.equals("bus") ) {
					 sent= "select distinct DESTINO from bus";
				}else  {
					 sent= "select distinct DESTINO from vuelo";
					}
				
				ResultSet rs = st.executeQuery(sent);
				while(rs.next()) {
					String destino = rs.getString("Destino");
					
					listaDestinos.add(destino);
					
				}
				
			} catch (SQLException e) {
				log(Level.SEVERE, "ERROR AL DEVOLVER VUELOS DE LA BASE DE DATOS", e);
				e.printStackTrace();
			}
			
			BDServicio.cerrarConexion();
			return listaDestinos;
			
		}
		
		
		public static TreeSet<String> mostrarOrigenesCombinados () {
			
			TreeSet<String> listaConOrigenes =  new TreeSet<String> ();
			
			BDServicio.abrirBaseDatos("basesDeDatos//serviciosCompanya.db");
			
			try {
				log(Level.INFO, "INTENTANDO RECUPERAR DESTINOS ORIGEN DE LOS VUELOS PARA LOS VIAJES COMBINADOS", null);
				Statement st = conn.createStatement();
				String ret = "select * from vuelo where cod_vuelo in (select cod_vuelo from viajeCombinado)";
				ResultSet rs = st.executeQuery(ret);
				while (rs.next()) {
					String origenNuevo = rs.getString("origen");
					listaConOrigenes.add(origenNuevo);
					
					
				}
				log(Level.INFO, "DEVOLVIENDO CON EXITO LOS  ORIGEN DE LOS VUELOS PARA LOS VIAJES COMBINADOS", null);
				
				
				
			}catch (SQLException e) {
				log(Level.SEVERE, "ERROR AL DEVOLVER ORIGENES DE LOS VIAJES COMBINADOS", e);
				e.printStackTrace();
			}
			
			BDServicio.cerrarConexion();
			return listaConOrigenes;
		
			
			
		}
		
		
	public static TreeSet<String> mostrarDestinosCombinados () {
			
			TreeSet<String> listaConDestinos =  new TreeSet<String> ();
			
			BDServicio.abrirBaseDatos("basesDeDatos//serviciosCompanya.db");
			
			try {
				log(Level.INFO, "INTENTANDO RECUPERAR DESTINOS ORIGEN DE LOS VUELOS PARA LOS VIAJES COMBINADOS", null);
				Statement st = conn.createStatement();
				String ret = "select * from bus where cod_bus in (select cod_bus from viajeCombinado)";
				ResultSet rs = st.executeQuery(ret);
				while (rs.next()) {
					String destinoNuevo = rs.getString("destino");
					listaConDestinos.add(destinoNuevo);
					
					
				}
				log(Level.INFO, "DEVOLVIENDO CON EXITO LOS  DESTINOS BUS PARA LOS VIAJES COMBINADOS", null);
				
				
				
			}catch (SQLException e) {
				log(Level.SEVERE, "ERROR AL DEVOLVER DESTINOS LOS VIAJES COMBINADOS", e);
				e.printStackTrace();
			}
			
			BDServicio.cerrarConexion();
			return listaConDestinos;
		
			
			
		}
	
	
	//METODO QUE DEVUELVE UNA LISTA CON LOS VIAJES COMBINADOS PARA MOSTRAR EN LA TABLA
	public static ArrayList <ViajeCombinado> mostrarViajesCombinadosTotal() {
		BDServicio.abrirBaseDatos("basesDeDatos//serviciosCompanya.db");
		//creamos statement para acceder y arrayList de vuelos VACIO INICIALMENTE
		ArrayList <ViajeCombinado> listaConCombinados = new ArrayList <ViajeCombinado> ();
		log(Level.INFO, "INTENTANDO ACCEDER A LOS VIAJES COMBINADOS DISPONIBLES", null);
		
		try {
			Statement st = conn.createStatement();
			
			String resp = "select * from viajeCombinado";
			ResultSet rs = st.executeQuery(resp);
			while(rs.next()) {
				int codCombinado = rs.getInt("Cod_viajeCombinado");
				String FechaViaje = rs.getString("Fecha");
				int codVuelo = rs.getInt("cod_vuelo");
				int codBus= rs.getInt("cod_bus");
				
				
				//OBTENEMOS EL CORRESPONDIENTE VUELO Y BUS
				Vuelo vuelo = BDServicio.vueloDesdeCodigo(codVuelo);
				Bus bus = BDServicio.busDesdeCodigo(codBus);
				String horaSalida = vuelo.getHoraSalida();
				int duracionTotal = vuelo.getDuracion() + bus.getDuracion();
				String origen = vuelo.getOrigen();
				String trasbordo = vuelo.getDestino();
				String destino = bus.getDestino();
				double precio = vuelo.getPrecio() + bus.getPrecio();
				int plazasRestantes = 0;
				if(bus.getPlazasRestantes()<vuelo.getPlazasRestantes()) {
					plazasRestantes=bus.getPlazasRestantes();
				}else {
					plazasRestantes=vuelo.getPlazasRestantes();
				}
				
				
				
				
				ViajeCombinado combinadoNuevo = new ViajeCombinado(codCombinado, FechaViaje,horaSalida, duracionTotal, origen, destino, trasbordo,
						precio,TipoServicio.viajeCombinado,plazasRestantes,bus,vuelo);
				listaConCombinados.add(combinadoNuevo);
				
			}
			
		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR AL DEVOLVER VIAJES COMBINADOS DE LA BASE DE DATOS", e);
			e.printStackTrace();
		}
		log(Level.INFO, "DEVOLVIENDO LOS VIAJES COMBINADOS DISPONIBLES", null);
		
		BDServicio.cerrarConexion();
		return listaConCombinados;
		
		
	}
	
	
	
	
	
	
	//METODO QUE DEVUELVE UNA LISTA CON LOS VUELOS PARA MOSTRAR EN LA TABLA
		public static ArrayList <Vuelo> mostrarVuelosTotal() {
			BDServicio.abrirBaseDatos("basesDeDatos//serviciosCompanya.db");
			//creamos statement para acceder y arrayList de vuelos VACIO INICIALMENTE
			ArrayList <Vuelo> listaConVuelos = new ArrayList <Vuelo> ();
			
			try {
				Statement st = conn.createStatement();
				
				String resp = "select * from VUELO";
				ResultSet rs = st.executeQuery(resp);
				while(rs.next()) {
					int codigoVuelo = rs.getInt("Cod_vuelo");
					String FechaVuelo = rs.getString("Fecha");
					String horaSalidaVuelo = rs.getString("Hora_salida");
					int duracion = rs.getInt("Duracion");
					String origen = rs.getString("Origen");
					String destino = rs.getString("Destino");
					Double precio = rs.getDouble("Precio");
					TipoServicio tipo = TipoServicio.vuelo;
					int plazasRestantes = rs.getInt("Plazas_restantes");
					String companya= rs.getString("Companya_vuelo");
					
					
					Vuelo vueloNuevo = new Vuelo(codigoVuelo, FechaVuelo, horaSalidaVuelo, duracion, origen,
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
		
		
		private static Date sumarDias(Date fecha, int dias) {
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(fecha);
			calendar.add(Calendar.DAY_OF_YEAR, dias);
			return calendar.getTime();
		}
		
		//METODO QUE CREA NUEVOS VUELOS CON LOS DATOS RECIBIDOS DESDE LA VENTANA CREAR VUELOS 
		
		public static void crearVuelos (Date fecha, String horaSalida, int duracion ,String origen, String destino, double precio, int plazas,String companya, boolean semanal, boolean mensual)  {
			BDServicio.abrirBaseDatos("basesDeDatos//serviciosCompanya.db");
			String sent="";
			try {
				if (semanal==true) {
					for (int i=0; i<8; i++ ) {	
						Statement st = conn.createStatement();
						Date fechanueva= sumarDias(fecha,i);
						String fechatoString = SDF_FECHA_FOTO.format(fechanueva);
						sent="INSERT INTO VUELO(FECHA,HORA_SALIDA,DURACION,ORIGEN,DESTINO,PRECIO,COMPANYA_vuelo,PLAZAS_RESTANTES) VALUES ('"+fechatoString+"','"+horaSalida+"',"+duracion+",'"+origen+"','"+destino+"',"+precio+",'"+companya+"',"+plazas+")";
						
						st.executeUpdate(sent);
								
					}
					log(Level.INFO, "VUELOS SEMANALES INSERTADOS EN LA BASE DE DATOS", null);
					
				} else {
					for (int i=0; i<32; i++ ) {
						Statement st = conn.createStatement();
						Date fechanueva= sumarDias(fecha,i);
						String fechatoString = SDF_FECHA_FOTO.format(fechanueva);
						sent="INSERT INTO VUELO(FECHA,HORA_SALIDA,DURACION,ORIGEN,DESTINO,PRECIO,COMPANYA_vuelo,PLAZAS_RESTANTES) VALUES ('"+fechatoString+"','"+horaSalida+"',"+duracion+",'"+origen+"','"+destino+"',"+precio+",'"+companya+"',"+plazas+")";
						
						st.executeUpdate(sent);
					}
					log(Level.INFO, "VUELOS MENSUALES INSERTADOS EN LA BASE DE DATOS", null);
				}
				
		} catch(SQLException sql) {
			log(Level.SEVERE, "ERROR AL INSERTAR DATOS DE VUELOS A LA BD", sql);
		}

	}
		//METODO QUE CREA NUEVOS BUSES CON LOS DATOS RECIBIDOS DESDE LA VENTANA CREAR BUSES 
		
		public static void crearBuses (Date fecha, String horaSalida, int duracion ,String origen, String destino, double precio, int plazas,String companya, boolean semanal, boolean mensual)  {
			BDServicio.abrirBaseDatos("basesDeDatos//serviciosCompanya.db");
			String sent="";
			try {
				if (semanal==true) {
					for (int i=0; i<8; i++ ) {	
						Statement st = conn.createStatement();
						Date fechanueva= sumarDias(fecha,i);
						String fechatoString = SDF_FECHA_FOTO.format(fechanueva);
						sent="INSERT INTO BUS(FECHA,HORA_SALIDA,DURACION,ORIGEN,DESTINO,PRECIO,PLAZAS_RESTANTES,COMPANYA_BUS) VALUES ('"+fechatoString+"','"+horaSalida+"',"+duracion+",'"+origen+"','"+destino+"',"+precio+","+plazas+",'"+companya+"')";
						
						st.executeUpdate(sent);
								
					}
					log(Level.INFO, "BUSES SEMANALES INSERTADOS EN LA BASE DE DATOS", null);
					
				} else {
					for (int i=0; i<32; i++ ) {
						Statement st = conn.createStatement();
						Date fechanueva= sumarDias(fecha,i);
						String fechatoString = SDF_FECHA_FOTO.format(fechanueva);
						sent="INSERT INTO BUS(FECHA,HORA_SALIDA,DURACION,ORIGEN,DESTINO,PRECIO,PLAZAS_RESTANTES,COMPANYA_BUS) VALUES ('"+fechatoString+"','"+horaSalida+"',"+duracion+",'"+origen+"','"+destino+"',"+precio+","+plazas+",'"+companya+"')";
						
						st.executeUpdate(sent);
					}
					log(Level.INFO, "BUSES MENSUALES INSERTADOS EN LA BASE DE DATOS", null);
				}
				
		} catch(SQLException sql) {
			log(Level.SEVERE, "ERROR AL INSERTAR DATOS DE BUSES A LA BD", sql);
		}

	}
		
		//METODO QUE CREA NUEVOS VIAJES COMBINADOS MANUALMENTE
		
		public static void crearViajesCombinados ()  {
			
			//DATOS EJEMPLO
			Date fecha= new Date(122,11,23);
			int codigovuelo=1396;
			int codigobus=941;
			

			BDServicio.abrirBaseDatos("basesDeDatos//serviciosCompanya.db");
			String sent="";
			try {
					for (int i=0; i<32; i++ ) {
						Statement st = conn.createStatement();
						Date fechanueva= sumarDias(fecha,i);
						codigobus++;
						codigovuelo++;
						String fechatoString = SDF_FECHA_FOTO.format(fechanueva);
						sent="INSERT INTO VIAJECOMBINADO(FECHA,cod_vuelo,cod_bus) VALUES ('"+fechatoString+"',"+codigobus+","+codigovuelo+")";
						
						st.executeUpdate(sent);
					}
					log(Level.INFO, "VIAJES COMBINADOS MENSUALES INSERTADOS EN LA BASE DE DATOS", null);
				
		}catch(SQLException sql) {
			log(Level.SEVERE, "ERROR AL INSERTAR DATOS DE VIAJES COMBINADOS A LA BD", sql);
		}
	}
	



		//FILTRA LOS VUELOS 
		public static ArrayList<Vuelo> listaServicioVueloFiltrado (String origen, String destino, String orden,String fechaInicio, String fechaFin){
			BDServicio.abrirBaseDatos("basesDeDatos//serviciosCompanya.db");
			//creamos statement para acceder y arrayList de vuelos VACIO INICIALMENTE
			ArrayList <Vuelo> listaConVuelos = new ArrayList <Vuelo> ();
			String sent="";
			
			try {
				Statement st = conn.createStatement();
				if(orden.equals("menor")) {
				 sent= "select * from vuelo where origen='"+origen+"' and destino='"+destino+"' and fecha between '"+fechaInicio
						 +"' and '"+fechaFin+"' order by precio asc";
				}else {
				     sent= "select * from vuelo where origen='"+origen+"' and destino='"+destino+"' and fecha between '"+fechaInicio
							 +"' and '"+fechaFin+"' order by precio desc";
				}
				
				ResultSet rs = st.executeQuery(sent);
				while(rs.next()) {
					int codigoVuelo = rs.getInt("Cod_vuelo");
					String FechaVuelo = rs.getString("Fecha");
					String horaSalidaVuelo = rs.getString("Hora_salida");
					int duracion = rs.getInt("Duracion");
					String origenV = rs.getString("Origen");
					String destinoV = rs.getString("Destino");
					Double precio = rs.getDouble("Precio");
					TipoServicio tipo = TipoServicio.vuelo;
					int plazasRestantes = rs.getInt("Plazas_restantes");
					String companya= rs.getString("Companya_vuelo");
					
					
					Vuelo vueloNuevo = new Vuelo(codigoVuelo, FechaVuelo, horaSalidaVuelo, duracion, origenV,
							destinoV, precio, tipo,plazasRestantes,companya);
					listaConVuelos.add(vueloNuevo);	
					
				}
			}catch(SQLException sql) {
				log(Level.SEVERE, "ERROR EN CONSULTA DE BASE DE DATOS CON FILTRADO DE VUELOS", sql);
			}
			BDServicio.cerrarConexion();
			return listaConVuelos;
		}
		
		
		
		
		
		public static ArrayList<Bus> listaServicioBusFiltrado (String origen, String destino, String orden,String fechaInicio, String fechaFin){
			BDServicio.abrirBaseDatos("basesDeDatos//serviciosCompanya.db");
			//creamos statement para acceder y arrayList de vuelos VACIO INICIALMENTE
			ArrayList <Bus> listaConBus = new ArrayList <Bus> ();
			String sent="";
			
			try {
				Statement st = conn.createStatement();
				if(orden.equals("menor")) {
				 sent= "select * from bus where origen='"+origen+"' and destino='"+destino+"' and fecha between '"+fechaInicio
						 +"' and '"+fechaFin+"' order by precio asc";
				}else {
				     sent= "select * from bus where origen='"+origen+"' and destino='"+destino+"' and fecha between '"+fechaInicio
							 +"' and '"+fechaFin+"' order by precio desc";
				}
				
				ResultSet rs = st.executeQuery(sent);
				while(rs.next()) {
					int codigoBus = rs.getInt("Cod_bus");
					String FechaBus = rs.getString("Fecha");
					String horaSalidaBus = rs.getString("Hora_salida");
					int duracion = rs.getInt("Duracion");
					String origenV = rs.getString("Origen");
					String destinoV = rs.getString("Destino");
					Double precio = rs.getDouble("Precio");
					TipoServicio tipo = TipoServicio.bus;
					int plazasRestantes = rs.getInt("Plazas_restantes");
					String companya= rs.getString("Companya_bus");
					
					
					Bus busNuevo = new Bus(codigoBus, FechaBus, horaSalidaBus, duracion, origenV,
							destinoV, precio, tipo,plazasRestantes,companya);
					listaConBus.add(busNuevo);	
					
				}
			}catch(SQLException sql) {
				log(Level.SEVERE, "ERROR EN CONSULTA DE BASE DE DATOS CON FILTRADO DE BUS", sql);
			}
			BDServicio.cerrarConexion();
			return listaConBus;
		}
		
		
		//FILTRA LOS VIAJES COMBINADOS
		public static ArrayList<ViajeCombinado> listaServicioCombinadoFiltrado (String origen, String destino, String fechaInicio, String fechaFin){
			BDServicio.abrirBaseDatos("basesDeDatos//serviciosCompanya.db");
			ArrayList<ViajeCombinado> listaConViajesFiltradosporFecha = new ArrayList<ViajeCombinado>();
			ArrayList<ViajeCombinado> listaConViajesFiltradosFinal = new ArrayList<ViajeCombinado>();
			try {
				//PRIMERO HAREMOS UNA CONSULTA A LA BD PARA FILTRAR POR FECHA Y CREAR UNA ARRAYLIST CON LOS QUE CUMPLAN
				Statement st = conn.createStatement();
				String sent= "select * from VIAJECOMBINADO where FECHA BETWEEN '"+fechaInicio+"' AND '"+fechaFin+"'";
				ResultSet rs = st.executeQuery(sent);
				while(rs.next()) {
					int codigoViaje = rs.getInt("COD_VIAJECOMBINADO");
					String Fecha = rs.getString("FECHA");
					int codigoVuelo = rs.getInt("cod_vuelo");
					int codigoBus = rs.getInt("cod_bus");
					
					//OBTENEMOS EL CORRESPONDIENTE VUELO Y BUS
					Vuelo vuelo = BDServicio.vueloDesdeCodigo(codigoVuelo);
					Bus bus = BDServicio.busDesdeCodigo(codigoBus);
					String horaSalida = vuelo.getHoraSalida();
					int duracionTotal = vuelo.getDuracion() + bus.getDuracion();
					String origenV = vuelo.getOrigen();
					String trasbordo = vuelo.getDestino();
					String destinoV = bus.getDestino();
					double precio = vuelo.getPrecio() + bus.getPrecio();
					int plazasRestantes = 0;
					if(bus.getPlazasRestantes()<vuelo.getPlazasRestantes()) {
						plazasRestantes=bus.getPlazasRestantes();
					}else {
						plazasRestantes=vuelo.getPlazasRestantes();
					}

					
					ViajeCombinado viajeN = new ViajeCombinado(codigoViaje,Fecha,horaSalida, duracionTotal, origenV, destinoV, trasbordo,
							precio,TipoServicio.viajeCombinado,plazasRestantes,bus,vuelo);
					listaConViajesFiltradosporFecha.add(viajeN);

					} 
					
			}catch(SQLException sql) {
					log(Level.SEVERE, "ERROR EN CONSULTA DE BASE DE DATOS CON FILTRADO DE VIAJES COMBINADOS", sql);
		
				}
			BDServicio.cerrarConexion();
			
			
			//AHORA USAREMOS ESTA LISTA FILTRADA PARA FILTRAR EL ORIGEN Y EL DESTINO 
			for(ViajeCombinado viaje:listaConViajesFiltradosporFecha) {
				if(viaje.getVuelo().getOrigen().equals(origen)&& viaje.getBus().getDestino().equals(destino)) {
					listaConViajesFiltradosFinal.add(viaje);
					
				}
			
		}
			return listaConViajesFiltradosFinal;
			
	}
		
		
		
		
		
	public static int claveRenting() {
		BDServicio.abrirBaseDatos("basesDeDatos//serviciosCompanya.db");
		int clave=0;
		try {
			Statement st = conn.createStatement();
			String sent = "select max(COD_RENTING) from renting";
			ResultSet rs = st.executeQuery(sent);
            if(rs.next()) {
            	clave = rs.getInt(1);
            }
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			log(Level.SEVERE, "ERROR AL INTENTAR OBTENER LA CLAVE CORRESPONDIENTE AL RENTING", e);
		}
		BDServicio.cerrarConexion();
		return clave;
		
		
	}
	
	
	
		
	public static void escribirCompra(Compra compra) {
		
		
		
		//SI LA COMPRA ES UN BUS, ACTUAREMOS DIFERENTE A SI ES UN VUELO O VIAJECOMBINADO
		String sent ="";
		//DATOS EN COMUN PARA TODOS
		int codUsu = compra.getCodigoUsuario();
		int cantidad = compra.getCantidad();
		String fecha = compra.getFechaCompra();
		
		if ( compra instanceof  BusComprado) {
			//Obtenemos el codigo del usuario, compra y fecha
			BusComprado busC = (BusComprado) compra;
			int codBus = busC.getBus().getCodigo();
			double precio = busC.getPrecio();
			sent = "insert into busComprado (COD_USU,COD_BUS_COMPRADO,FECHA_COMPRA,CANTIDAD,PRECIO) VALUES ("+codUsu+","+codBus+", '"+fecha
					+"'"+ ","+cantidad+","+precio+")";
		
				}else {
					if(compra instanceof VueloComprado) {
						VueloComprado vuelo = (VueloComprado) compra;
						
						int codVuelo = vuelo.getVuelo().getCodigo();
						double precio = vuelo.getPrecio();
						
						
						//AQUI INSTERTAMOS EL RENTING DEL COCHE, PARA OBTENEMOS LA ULTIMA  UNA CLAVE Y LA AÑADIMOS EN UN CAMPO,
						//ADEMAS, EN LA BD DE RENTING COCHE LO AÑADIMOS!!!
						
						String zonaVuelo = vuelo.getZonaAsientoVuelo().toString();
						
						//creamos sentencia, PERO PRIMERO OBTENEMOS LA CLAVE QUE LE CORRESPONDE, SI ES QUE HA SELECCIONADO RENTING, SINO
						//-1 si no quiere renting
						
						int claveRenting =-1;
						if(vuelo.getListaRenting().size()!=0) {
							
							//OBTENEMOS LA QUE LE CORRESPONDE
							int nuevaClave = BDServicio.claveRenting()+1;
							claveRenting=nuevaClave;
							
							//AHORA ANYADIMOS EL RENTING CON METODO DE BD
							
						}
						sent = "insert into vueloComprado (COD_USU,COD_VUELO_COMPRADO,FECHA_COMPRA,CANTIDAD,PRECIO,COD_COMPRA_RENTING,ZONA_ASIENTO_VUELO) VALUES ("+codUsu+","+codVuelo+", '"+fecha
								+"'"+ ","+cantidad+","+precio+","+claveRenting+",'"+zonaVuelo+"')";
						
						
					}
					
				}
					
		try {
			BDServicio.abrirBaseDatos("basesDeDatos/serviciosCompanya.db");
			Statement st = conn.createStatement();
			st.executeUpdate(sent);
			log(Level.INFO, "INSERTADA LA COMPRA EN LA BASE DE DATOS", null);
			BDServicio.cerrarConexion();
			
			
			}catch(SQLException sql) {
				log(Level.SEVERE, "ERROR AL INSERTAR COMPRA EN BASE DE DATOS", sql);
				BDServicio.cerrarConexion();
			}
			
		
			
			
		}
	
	
	//METODO PARA OBTENER UN VUELO A PARTIR DE SU CODIGO (LO USAREMOS PARA LOS VIAJES COMBINADOS)
	
	public static Vuelo vueloDesdeCodigo(int codVuelo) {
		
		BDServicio.abrirBaseDatos("basesDeDatos//serviciosCompanya.db");
		Vuelo vuelo = null;
	
		
		try {
			Statement st = conn.createStatement();
			
			String resp = "select * from VUELO where cod_vuelo = "+codVuelo;
			ResultSet rs = st.executeQuery(resp);
			while(rs.next()) {
				int codigoVuelo = rs.getInt("Cod_vuelo");
				String FechaVuelo = rs.getString("Fecha");
				String horaSalidaVuelo = rs.getString("Hora_salida");
				int duracion = rs.getInt("Duracion");
				String origen = rs.getString("Origen");
				String destino = rs.getString("Destino");
				Double precio = rs.getDouble("Precio");
				
				TipoServicio tipo = TipoServicio.vuelo;
				int plazasRestantes = rs.getInt("Plazas_restantes");
				String companya= rs.getString("Companya_vuelo");
				
				
				 vuelo = new Vuelo(codigoVuelo, FechaVuelo, horaSalidaVuelo, duracion, origen,
						destino, precio, tipo,plazasRestantes,companya);
				
				
	
				
				
				
			}
			
		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR AL DEVOLVER BUSQUEDA DE VUELO POR CODIGO DE LA BASE DE DATOS", e);
			e.printStackTrace();
			
		}
		log(Level.INFO, "DEVOLVIENDO VUELOS DE LA BASE DE DATOS", null);
		BDServicio.cerrarConexion();
		return vuelo;
		
		
		
	}
	
	
	
	//OBTENER BUS DESDE CODIGO
	
	public static Bus busDesdeCodigo(int codBus) {
		BDServicio.abrirBaseDatos("basesDeDatos/serviciosCompanya.db");
		//creamos statement para acceder y arrayList de vuelos VACIO INICIALMENTE
		Bus bus = null;
		
		try {
			Statement st = conn.createStatement();
			
			String resp = "select * from bus where cod_bus="+codBus;
			ResultSet rs = st.executeQuery(resp);
			while(rs.next()) {
				int codigoVuelo = rs.getInt("Cod_bus");
				String FechaVuelo = rs.getString("Fecha");
				String horaSalidaVuelo = rs.getString("Hora_salida");
				int duracion = rs.getInt("Duracion");
				String origen = rs.getString("Origen");
				String destino = rs.getString("Destino");
				Double precio = rs.getDouble("Precio");
				TipoServicio tipo = TipoServicio.vuelo;
				int plazasRestantes = rs.getInt("Plazas_restantes");
				String companya = rs.getString("Companya_bus");
				
				
				
				 bus = new Bus(codigoVuelo, FechaVuelo, horaSalidaVuelo, duracion, origen,
						destino, precio, tipo,plazasRestantes,companya);
				 
				
				
				
				
				
				
			}
			
		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR AL DEVOLVER  RESULTADO DE BUSQUEDA DE BUS POR CODIGO  DE LA BASE DE DATOS", e);
			e.printStackTrace();
		}
		
		log(Level.INFO, "DEVOLVIENDO BUS DE LA BASE DE DATOS", null);
		BDServicio.cerrarConexion();
		
		return bus;
		
		
	}
	
	
	
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	
	public static void log( Level level, String msg, Throwable excepcion ) {
		if (logger==null) {  // Logger por defecto sera el local:
			logger = Logger.getLogger( "Log-BD" );  // Nombre del logger
			logger.setLevel( Level.ALL );  // Loguea todos los niveles
//			try {
//				logger.addHandler( new FileHandler( "T&T-log.xml", true ) );  // Y saca el log a fichero xml
//			} catch (Exception e) {
//				logger.log( Level.SEVERE, "No se pudo crear fichero de log", e );
//			}
		}
		if (excepcion==null)
			logger.log( level, msg );
		else
			logger.log( level, msg, excepcion );
	}


	
	

}
