package BD;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import Datos.Bus;
import Datos.BusComprado;
import Datos.Compra;
import Datos.RentingCoche;
import Datos.ViajeCombinado;
import Datos.ViajeCombinadoComprado;
import Datos.Vuelo;
import Datos.VueloComprado;
import Enum.TipoServicio;
import Enum.ZonaAsientoVuelo;

public class BDServicio {


private static Connection conn;
private static PreparedStatement pst;
private final static SimpleDateFormat SDF_FECHA_FOTO = new SimpleDateFormat("yyyy-MM-dd");
public static final String baseDatosServicio ="basesDeDatos/serviciosCompanya.db";
public static Date fechaActualDate = new Date(System.currentTimeMillis());
public static String fechaActualString = SDF_FECHA_FOTO.format(fechaActualDate);

	
	private static Logger logger;
	
	public static  Connection abrirBaseDatos(String base) {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:"+base);
			//log(Level.INFO, "Accediendo a la base de datos:" + base, null);
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
			//log(Level.INFO, "Conexion cerrada",null);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	
	public static void compraServicio (Compra compra,String ruta) {
		BDServicio.abrirBaseDatos(ruta);
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
			String anyadir = "Insert into Compra values ("+codigo+", "+"'"+fecha+
					"' ,"+compra.getCantidad()+", '"+tipo+"' ,"+ codigoCompra;
			int valor = st.executeUpdate(anyadir);
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
	public static ArrayList <Bus> mostrarBusesTotal(String ruta) {
		BDServicio.abrirBaseDatos(ruta);
		//creamos statement para acceder y arrayList de vuelos VACIO INICIALMENTE
		ArrayList <Bus> listaConBus = new ArrayList <Bus> ();
		
		try {
			Statement st = conn.createStatement();
			
			String resp = "select * from bus where fecha > '"+fechaActualString +"' and plazas_restantes>0 order by fecha";
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
	
			public static ArrayList<String> mostrarDiferentesOrigenes(String servicio,String ruta){
				BDServicio.abrirBaseDatos(ruta);
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
	
		public static ArrayList<String> mostrarDiferentesDestinos(String servicio,String ruta){
			BDServicio.abrirBaseDatos(ruta);
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
		
		
		public static TreeSet<String> mostrarOrigenesCombinados (String ruta) {
			
			TreeSet<String> listaConOrigenes =  new TreeSet<String> ();
			
			BDServicio.abrirBaseDatos(ruta);
			
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
		
		
	public static TreeSet<String> mostrarDestinosCombinados (String ruta) {
			
		TreeSet<String> listaConDestinos =  new TreeSet<String> ();
			
			BDServicio.abrirBaseDatos(ruta);
			
			try {
				log(Level.INFO, "INTENTANDO RECUPERAR DESTINOS PARA LOS VIAJES COMBINADOS", null);
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
	public static ArrayList <ViajeCombinado> mostrarViajesCombinadosTotal(String ruta) {
		BDServicio.abrirBaseDatos(ruta);
		//creamos statement para acceder y arrayList de vuelos VACIO INICIALMENTE
		ArrayList <ViajeCombinado> listaConCombinados = new ArrayList <ViajeCombinado> ();
		log(Level.INFO, "INTENTANDO ACCEDER A LOS VIAJES COMBINADOS DISPONIBLES", null);
		
		try {
			Statement st = conn.createStatement();
			
			String resp = "select * from viajeCombinado where fecha > '"+fechaActualString+"'"
					+ "order by fecha";
			ResultSet rs = st.executeQuery(resp);
			while(rs.next()) {
				int codCombinado = rs.getInt("Cod_viajeCombinado");
				String FechaViaje = rs.getString("Fecha");
				int codVuelo = rs.getInt("cod_vuelo");
				int codBus= rs.getInt("cod_bus");
				
				
				//OBTENEMOS EL CORRESPONDIENTE VUELO Y BUS
				Vuelo vuelo = BDServicio.vueloDesdeCodigo(codVuelo,ruta);
				Bus bus = BDServicio.busDesdeCodigo(codBus,ruta);
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
		public static ArrayList <Vuelo> mostrarVuelosTotal(String ruta) {
			BDServicio.abrirBaseDatos(ruta);
			//creamos statement para acceder y arrayList de vuelos VACIO INICIALMENTE
			ArrayList <Vuelo> listaConVuelos = new ArrayList <Vuelo> ();
			
			try {
				Statement st = conn.createStatement();
				
				String resp = "select * from VUELO where fecha >'"+fechaActualString +"'  and plazas_restantes>0"
						+ " order by fecha";
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
		
		// POR DEFECTO, LO HAREMOS DURANTE 8 SEMANAS O MESES, (DEPENDE LO ESCOGIDO), AQUI YA ES UNA ELECCION NUESTRA
		
		
		public static void crearVuelos (Date fecha, String horaSalida, int duracion ,String origen, String destino, double precio, int plazas,String companya, boolean semanal, boolean mensual,String ruta)  {
			BDServicio.abrirBaseDatos(ruta);
			String sent="";
			 int sumar=0;
			try {
				if (semanal==true) {
					for (int i=0; i<8; i++ ) {	
						Statement st = conn.createStatement();
						 sumar = sumar+7;
						Date fechanueva= sumarDias(fecha,sumar);
						String fechatoString = SDF_FECHA_FOTO.format(fechanueva);
						sent="INSERT INTO VUELO(FECHA,HORA_SALIDA,DURACION,ORIGEN,DESTINO,PRECIO,COMPANYA_vuelo,PLAZAS_RESTANTES) VALUES ('"+fechatoString+"','"+horaSalida+"',"+duracion+",'"+origen+"','"+destino+"',"+precio+",'"+companya+"',"+plazas+")";
						
						st.executeUpdate(sent);
								
					}
					log(Level.INFO, "VUELOS SEMANALES INSERTADOS EN LA BASE DE DATOS", null);
					
				} else {
					for (int i=0; i<8; i++ ) {
						Statement st = conn.createStatement();
						sumar=sumar+30;
						Date fechanueva= sumarDias(fecha,sumar);
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
		
		public static void crearBuses (Date fecha, String horaSalida, int duracion ,String origen, String destino, double precio, int plazas,String companya, boolean semanal, boolean mensual,String ruta)  {
			BDServicio.abrirBaseDatos(ruta);
			String sent="";
			int sumar=0;
			try {
				if (semanal==true) {
					for (int i=0; i<8; i++ ) {	
						Statement st = conn.createStatement();
						sumar=sumar+7;
						Date fechanueva= sumarDias(fecha,sumar);
						String fechatoString = SDF_FECHA_FOTO.format(fechanueva);
						sent="INSERT INTO BUS(FECHA,HORA_SALIDA,DURACION,ORIGEN,DESTINO,PRECIO,PLAZAS_RESTANTES,COMPANYA_BUS) VALUES ('"+fechatoString+"','"+horaSalida+"',"+duracion+",'"+origen+"','"+destino+"',"+precio+","+plazas+",'"+companya+"')";
						
						st.executeUpdate(sent);
								
					}
					log(Level.INFO, "BUSES SEMANALES INSERTADOS EN LA BASE DE DATOS", null);
					
				} else {
					for (int i=0; i<8; i++ ) {
						Statement st = conn.createStatement();
						sumar=sumar+30;
						Date fechanueva= sumarDias(fecha,sumar);
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
		
		public static void crearViajesCombinados (String ruta)  {
			
			//DATOS EJEMPLO
			Date fecha= new Date(122,11,23);
			int codigovuelo=1396;
			int codigobus=941;
			

			BDServicio.abrirBaseDatos(ruta);
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
		public static ArrayList<Vuelo> listaServicioVueloFiltrado (String origen, String destino, String orden,Date fechaInicio, Date fechaFin,String ruta) throws ParseException{
			BDServicio.abrirBaseDatos(ruta);
			//creamos statement para acceder y arrayList de vuelos VACIO INICIALMENTE
			ArrayList <Vuelo> listaConVuelos = new ArrayList <Vuelo> ();
			String sent="";
			
			try {
				Statement st = conn.createStatement();
				if(orden.equals("menor")) {
				 sent= "select * from vuelo where plazas_restantes>0 order by precio,fecha asc";
				}else {
				     sent= "select * from vuelo where plazas_restantes>0 order by precio desc,fecha asc";
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
				
				
			//UNA VEZ OBTENEMOS TODOS LOS VUELOS, PODEMOS LLAMAR AL METODO RECURSIVO, PARA OBTENER EL FILTRADO CORRECTO
				
				listaConVuelos = Vuelo.vueloFiltrado(listaConVuelos, 0, new ArrayList<Vuelo> (), origen, destino, fechaInicio, fechaFin);
				
				
			}catch(SQLException sql) {
				log(Level.SEVERE, "ERROR EN CONSULTA DE BASE DE DATOS CON FILTRADO DE VUELOS", sql);
			}
			
			BDServicio.cerrarConexion();
			return listaConVuelos;
		}
		
		public static ArrayList<Bus> listaServicioBusFiltrado (String origen, String destino,
				String orden,Date fechaInicio, Date fechaFin,String ruta) throws ParseException{
			BDServicio.abrirBaseDatos(ruta);
			//creamos statement para acceder y arrayList de vuelos VACIO INICIALMENTE
			ArrayList <Bus> listaConBus = new ArrayList <Bus> ();
			String sent="";
			try {
				Statement st = conn.createStatement();
				if(orden.equals("menor")) {
				 sent= "select * from bus where plazas_restantes>0 order by precio,fecha asc";
				}else {
				     sent= "select * from bus where plazas_restantes>0 order by precio desc,fecha asc";
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
				//METODO RECURSIVO PARA FILTRADO
				listaConBus = Bus.busFiltrado(listaConBus, 0, new ArrayList<Bus> (), origen, destino, fechaInicio, fechaFin);
				
			}catch(SQLException sql) {
				log(Level.SEVERE, "ERROR EN CONSULTA DE BASE DE DATOS CON FILTRADO DE BUS", sql);
			}
			BDServicio.cerrarConexion();
			return listaConBus;
		}
		
		
		//FILTRA LOS VIAJES COMBINADOS
		public static ArrayList<ViajeCombinado> listaServicioCombinadoFiltrado (String origen, String destino, String fechaInicio, String fechaFin,String ruta){
			BDServicio.abrirBaseDatos(ruta);
			ArrayList<ViajeCombinado> listaConViajesFiltradosporFecha = new ArrayList<ViajeCombinado>();
			ArrayList<ViajeCombinado> listaConViajesFiltradosFinal = new ArrayList<ViajeCombinado>();
			try {
				//PRIMERO HAREMOS UNA CONSULTA A LA BD PARA FILTRAR POR FECHA Y CREAR UNA ARRAYLIST CON LOS QUE CUMPLAN
				Statement st = conn.createStatement();
				String sent= "select * from VIAJECOMBINADO where FECHA BETWEEN '"+fechaInicio+"' AND '"+fechaFin+"' order by fecha asc";
				ResultSet rs = st.executeQuery(sent);
				while(rs.next()) {
					int codigoViaje = rs.getInt("COD_VIAJECOMBINADO");
					String Fecha = rs.getString("FECHA");
					int codigoVuelo = rs.getInt("cod_vuelo");
					int codigoBus = rs.getInt("cod_bus");
					
					//OBTENEMOS EL CORRESPONDIENTE VUELO Y BUS
					Vuelo vuelo = BDServicio.vueloDesdeCodigo(codigoVuelo,ruta);
					Bus bus = BDServicio.busDesdeCodigo(codigoBus,ruta);
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
		
		
		
		
		
	public static int claveRenting(String ruta) {
		BDServicio.abrirBaseDatos(ruta);
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
	
	
	
		
	public static void escribirCompra(Compra compra,String ruta) {
		
		
		
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
							claveRenting=BDServicio.claveRenting(ruta)+1;
							
							//AHORA ANYADIMOS EL RENTING CON METODO DE BD
							
						}
						sent = "insert into vueloComprado (COD_USU,COD_VUELO_COMPRADO,FECHA_COMPRA,CANTIDAD,PRECIO,COD_COMPRA_RENTING,ZONA_ASIENTO_VUELO) VALUES ("+codUsu+","+codVuelo+", '"+fecha
								+"'"+ ","+cantidad+","+precio+","+claveRenting+",'"+zonaVuelo+"')";
						

						//CREAMOS STRING PARA INTRODUCIR TAMBIEN LA COMPRA DE RENTING;
						String claseCoche ="";
						int dias=-1;
						if(vuelo.getListaRenting().size()!=0) {
							claseCoche=vuelo.getListaRenting().get(0).getClaseCoche().toString();
							dias= vuelo.getListaRenting().get(0).getDiasAlquilado();
							
						}
						
						String rent = "insert into renting values ("+claveRenting+", '"+claseCoche+"' ,"+dias+")";
						
						//AHORA CREAMOS NUEVO STATEMENT.
						BDServicio.abrirBaseDatos(ruta);
						try {
							Statement sta = conn.createStatement();
							if(vuelo.getListaRenting().size()!=0) {
								sta.executeUpdate(rent);
								log(Level.INFO, "INTRODUCIDA LA COMPRA DEL RENTING A LA BASE DE DATOS", null);
							}
				
							sta.close();
							BDServicio.cerrarConexion();
							
						} catch (SQLException e) {
							e.printStackTrace();
						}
						
						
					}
					else {
						
						//ES UN VIAJE COMBINADO!!!
						
						ViajeCombinadoComprado viajeC = (ViajeCombinadoComprado) compra;
						int codCombinado = viajeC.getViajeCombinado().getCodigo();
						double precio = viajeC.getPrecio();
						
						
						sent = "insert into viajeCombinadoComprado (COD_USU,COD_VIAJEC,"
								+ "FECHA_COMPRA,CANTIDAD,PRECIO) VALUES ("+codUsu+","+codCombinado+", '"+fecha
								+"'"+ ","+cantidad+","+precio+")";
						
						
						
						
						
					}
					
				}
					
		try {
			BDServicio.abrirBaseDatos(ruta);
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
	
	public static Vuelo vueloDesdeCodigo(int codVuelo,String ruta) {
		
		BDServicio.abrirBaseDatos(ruta);
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
		//log(Level.INFO, "DEVOLVIENDO VUELO DE LA BASE DE DATOS", null);
		BDServicio.cerrarConexion();
		return vuelo;
		
		
		
	}
	
	//METODO PARA OBTENER UN VIAJE COMBINADO A PARTIR DE SU CODIGO (LO USAREMOS PARA LOS VIAJES COMBINADOS COMPRADOS)
	
	public static ViajeCombinado viajeDesdeCodigo(int codViajeC,String ruta) {
		
		BDServicio.abrirBaseDatos(ruta);
		ViajeCombinado viajeC  = null;
	
		
		try {
			Statement st = conn.createStatement();
			
			String resp = "select * from viajeCombinado where COD_VIAJECOMBINADO = "+codViajeC;
			ResultSet rs = st.executeQuery(resp);
			while(rs.next()) {
				int codigoVuelo = rs.getInt("Cod_vuelo");
				//obtenemos el vuelo
				
				Vuelo vuelo = BDServicio.vueloDesdeCodigo(codigoVuelo,ruta);
				
				int codigoBus = rs.getInt("cod_bus");
				
				Bus bus = BDServicio.busDesdeCodigo(codigoBus,ruta);
				String FechaVuelo = rs.getString("Fecha");
				
				String horaSalidaVuelo =  vuelo.getHoraSalida();
				int duracion = vuelo.getDuracion() + bus.getDuracion();
				
				String origen = vuelo.getOrigen();
				
				String destino = bus.getDestino();
				
				String transbordo = vuelo.getDestino();
				
				Double precio = vuelo.getPrecio()+bus.getPrecio();
				
				int plazasRestantes = vuelo.getPlazasRestantes();

				  viajeC = new ViajeCombinado(codViajeC, FechaVuelo, horaSalidaVuelo, duracion, origen,
						destino, transbordo,precio,TipoServicio.viajeCombinado,plazasRestantes,bus,vuelo);	
			}
			
		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR AL DEVOLVER BUSQUEDA DE VIAJE COMBINADO POR CODIGO DE LA BASE DE DATOS", e);
			e.printStackTrace();
			
		}
		//log(Level.INFO, "DEVOLVIENDO VUELO DE LA BASE DE DATOS", null);
		BDServicio.cerrarConexion();
		return viajeC;
		
		
		
	}
	

	//METODO PARA OBTENER VUELOS COMPRADOS DE CADA USUARIO (DADO SU CODIGO DE USUARIO) PARA MOSTRAR EN EL PERFIL
	
	public static ArrayList<VueloComprado> vuelosCompradosUsuario(int codUsuario,String ruta) {
		
		BDServicio.abrirBaseDatos(ruta);
		ArrayList<VueloComprado> vuelosUsuarios= new ArrayList<>();
	
		
		try {
			Statement st = conn.createStatement();
			
			String resp = "select * from vueloComprado where cod_usu = "+codUsuario;
			ResultSet rs = st.executeQuery(resp);
			while(rs.next()) {
				int codigoVuelo = rs.getInt("Cod_vuelo_comprado");
				
				//OBTENEMOS EL VUELO 
				
				Vuelo vuelo = vueloDesdeCodigo(codigoVuelo,ruta);
				
				String zonaAsiento = rs.getString("zona_asiento_vuelo");
				
				
				String FechaCompra = rs.getString("Fecha_compra");
				int cantidad = rs.getInt("Cantidad");
				
				//el servicio renting es algo aparte, no nos interesa para mostrarlo en el perfil
				
				//el codigo de compra tampoco es necesario mostrarle al usuario 
				
				//ESTO ESTARA CONFIGURADO EN EL TOSTRING DE CADA CLASE, YA QUE ES ESTO LO QUE USAREMOS PARA MOSTRAR
				 VueloComprado vueloComprado = new VueloComprado(codUsuario, cantidad, FechaCompra, TipoServicio.vuelo, -1,vuelo,
						new ArrayList<RentingCoche>(),ZonaAsientoVuelo.valueOf(zonaAsiento));
				 
				//añadimos
				 
				 vuelosUsuarios.add(vueloComprado);

				
			}
			
		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR AL DEVOLVER BUSQUEDA DE VUELO POR CODIGO DE LA BASE DE DATOS", e);
			e.printStackTrace();
			
		}
		//log(Level.INFO, "DEVOLVIENDO VUELO DE LA BASE DE DATOS", null);
		BDServicio.cerrarConexion();
		return vuelosUsuarios;
		
		
		
	}
	
	//METODO PARA OBTENER BUSES COMPRADOS DE CADA USUARIO (DADO SU CODIGO DE USUARIO) PARA MOSTRAR EN EL PERFIL
	
	public static ArrayList<BusComprado> busesCompradosUsuario(int codUsuario,String ruta) {
		
		BDServicio.abrirBaseDatos(ruta);
		ArrayList<BusComprado> busesUsuarios= new ArrayList<>();
	
		
		try {
			Statement st = conn.createStatement();
			
			String resp = "select * from busComprado where cod_usu = "+codUsuario;
			ResultSet rs = st.executeQuery(resp);
			while(rs.next()) {
				int codigoBus = rs.getInt("Cod_bus_comprado");
				
				//OBTENEMOS EL BUS 
				
				Bus bus = busDesdeCodigo(codigoBus,ruta);
				
				String FechaCompra = rs.getString("Fecha_compra");
				int cantidad = rs.getInt("Cantidad");
				
				
				//el codigo de compra tampoco es necesario mostrarle al usuario 
				
				//ESTO ESTARA CONFIGURADO EN EL TOSTRING DE CADA CLASE, YA QUE ES ESTO LO QUE USAREMOS PARA MOSTRAR
				 BusComprado vueloComprado = new BusComprado(codUsuario, cantidad, FechaCompra,-1, TipoServicio.bus, -1,bus);
				 
				 
				 
				//añadimos
				 
				 busesUsuarios.add(vueloComprado);

				
			}
			
		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR AL DEVOLVER BUSQUEDA DE BUS POR CODIGO DE LA BASE DE DATOS", e);
			e.printStackTrace();
			
		}
		//log(Level.INFO, "DEVOLVIENDO BUSES COMPRADOS DE LA BASE DE DATOS", null);
		BDServicio.cerrarConexion();
		return busesUsuarios;
	
	}
	
	
	
	
	//METODO PARA OBTENER VIAJES COMBINADOS  COMPRADOS DE CADA USUARIO (DADO SU CODIGO DE USUARIO) PARA MOSTRAR EN EL PERFIL
	
		public static ArrayList<ViajeCombinadoComprado> viajesCombinadosCompradosUsuario(int codUsuario,String ruta) {
			
			BDServicio.abrirBaseDatos(ruta);
			ArrayList<ViajeCombinadoComprado> combinadosUsuarios= new ArrayList<>();
		
			
			try {
				Statement st = conn.createStatement();
				
				String resp = "select * from viajeCombinadoComprado where cod_usu = "+codUsuario;
				ResultSet rs = st.executeQuery(resp);
				while(rs.next()) {
					int codigoViajeCombinado = rs.getInt("Cod_viajec");
					
					//OBTENEMOS EL VIAJE COMBINADO
					
					ViajeCombinado viajeC = viajeDesdeCodigo(codigoViajeCombinado,ruta);
					String FechaCompra = rs.getString("Fecha_compra");
					int cantidad = rs.getInt("Cantidad");
					
					
					
					//el codigo de compra tampoco es necesario mostrarle al usuario 
					
					//ESTO ESTARA CONFIGURADO EN EL TOSTRING DE CADA CLASE, YA QUE ES ESTO LO QUE USAREMOS PARA MOSTRAR
					 ViajeCombinadoComprado viajeComprado = new ViajeCombinadoComprado(codUsuario, cantidad, FechaCompra,TipoServicio.viajeCombinado, -1,viajeC);
					 
					 
					 
					//añadimos
					 
					 combinadosUsuarios.add(viajeComprado);

					
				}
				
			} catch (SQLException e) {
				log(Level.SEVERE, "ERROR AL DEVOLVER BUSQUEDA DE VIAJE COMBINADO POR CODIGO DE LA BASE DE DATOS", e);
				e.printStackTrace();
				
			}
			//log(Level.INFO, "DEVOLVIENDO VIAJES COMBINADOS COMPRADOS DE LA BASE DE DATOS", null);
			BDServicio.cerrarConexion();
			return combinadosUsuarios;
		
		}

	//OBTENER BUS DESDE CODIGO
	
	public static Bus busDesdeCodigo(int codBus,String ruta) {
		BDServicio.abrirBaseDatos(ruta);
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
		
		//log(Level.INFO, "DEVOLVIENDO BUS DE LA BASE DE DATOS", null);
		BDServicio.cerrarConexion();
		
		return bus;
		
		
	}
	
	public static void restarPlaza(int codServicio, int plazasNuevas, TipoServicio tipo,String ruta) {
		BDServicio.abrirBaseDatos(ruta);
		String sent ="";
		
		if(tipo.equals(TipoServicio.vuelo)) {
			sent="update vuelo set plazas_restantes="+plazasNuevas + " where cod_vuelo="+codServicio;
			
		}else {
			sent="update bus set plazas_restantes="+plazasNuevas + " where cod_bus="+codServicio;
			
		}
		
		
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(sent);
			
		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR AL ACTUALIZAR LAS PLAZAS RESTANTES", e);
			e.printStackTrace();
		}
		
		//log(Level.INFO, "DEVOLVIENDO BUS DE LA BASE DE DATOS", null);
		BDServicio.cerrarConexion();
	
	}
	
	
	
	
	
	//METODOS DE ESTADISTICA DEL ADMINISTRADOR:
		
		//ESTOS METODOS SON LLAMADOS DESDE LA VENTANA DE MOSTRAR ESTADISTICA Y RECIBEN COMO PARAMETRO EL TIPO DE SERVICIO
	
	//1-MEDIA DE PRECIO DE COMPRA
	
	public static String mediaCompras(String servicio,String ruta) {
		BDServicio.abrirBaseDatos(ruta);
		String resp="";
		Double precioMedio=0.0;
		try {
			Statement st = conn.createStatement();
			if (servicio=="VUELO") {
				resp="select avg(CANTIDAD*PRECIO) FROM VUELOCOMPRADO";
			} else if (servicio=="BUS") {
				resp="select avg(CANTIDAD*PRECIO) FROM BUSCOMPRADO";
			} else {
				resp="select avg(CANTIDAD*PRECIO) FROM VIAJECOMBINADOCOMPRADO";
			}
			
			ResultSet rs = st.executeQuery(resp);
			
			precioMedio= rs.getDouble(1);
			
			
		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR AL DEVOLVER RESULTADO DE PRECIO MEDIO", e);
			e.printStackTrace();
		}
		
		log(Level.INFO, "DEVOLVIENDO PRECIO MEDIO", null);
		BDServicio.cerrarConexion();
		return precioMedio.toString();
	}
	
	//2-COMPRA MAS CARA
	
	public static String compraMax(String servicio,String ruta) {
		BDServicio.abrirBaseDatos(ruta);
		String resp="";
		Double precio=0.0;
		try {
			Statement st = conn.createStatement();
			if (servicio=="VUELO") {
				resp="select max(CANTIDAD*PRECIO) FROM VUELOCOMPRADO";
			} else if (servicio=="BUS") {
				resp="select max(CANTIDAD*PRECIO) FROM BUSCOMPRADO";
			} else {
				resp="select max(CANTIDAD*PRECIO) FROM VIAJECOMBINADOCOMPRADO";
			}
			
			ResultSet rs = st.executeQuery(resp);
			
			precio= rs.getDouble(1);
			
			
		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR AL DEVOLVER RESULTADO DE PRECIO MAXIMO", e);
			e.printStackTrace();
		}
		
		log(Level.INFO, "DEVOLVIENDO PRECIO MAXIMO", null);
		BDServicio.cerrarConexion();
		return precio.toString();
	}
	
	
	//3-COMPRA MAS BARATA
	
	public static String compraMin(String servicio,String ruta) {
		BDServicio.abrirBaseDatos(ruta);
		String resp="";
		Double precio=0.0;
		try {
			Statement st = conn.createStatement();
			if (servicio=="VUELO") {
				resp="select min(CANTIDAD*PRECIO) FROM VUELOCOMPRADO";
			} else if (servicio=="BUS") {
				resp="select min(CANTIDAD*PRECIO) FROM BUSCOMPRADO";
			} else {
				resp="select min(CANTIDAD*PRECIO) FROM VIAJECOMBINADOCOMPRADO";
			}
			
			ResultSet rs = st.executeQuery(resp);
			
			precio= rs.getDouble(1);
			
			
		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR AL DEVOLVER RESULTADO DE PRECIO MINIMO", e);
			e.printStackTrace();
		}
		
		log(Level.INFO, "DEVOLVIENDO PRECIO MINIMO", null);
		BDServicio.cerrarConexion();
		return precio.toString();
	}
	
	//4-USUARIO QUE MAS COMPRA
	
	public static String usuarioMasCompra(String servicio,String ruta) {
		BDServicio.abrirBaseDatos(ruta);
		String resp="";
		String usuario="";
		try {
			Statement st = conn.createStatement();
			if (servicio=="VUELO") {
				resp="SELECT COD_USU FROM VUELOCOMPRADO GROUP BY COD_USU,COD_VUELO_COMPRADO HAVING(max(COD_VUELO_COMPRADO));";
			} else if (servicio=="BUS")  {
				resp="SELECT COD_USU FROM BUSCOMPRADO GROUP BY COD_USU,COD_BUS_COMPRADO HAVING(max(COD_BUS_COMPRADO));";     
			} else {
				resp="SELECT COD_USU FROM VIAJECOMBINADOCOMPRADO GROUP BY COD_USU,COD_VIAJEC HAVING(max(COD_VIAJEC));";
			}
			
			ResultSet rs = st.executeQuery(resp);
			
			usuario= rs.getString(1);
			
			
		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR AL DEVOLVER RESULTADO USUARIO QUE MAS COMPRA", e);
			e.printStackTrace();
		}
		
		log(Level.INFO, "DEVOLVIENDO USUARIO QUE MAS COMPRA", null);
		BDServicio.cerrarConexion();
		return "COD_USUARIO: "+usuario;
	}
	
	
	//5-DESTINO MAS VISITADO
	
	public static String destinoMasvisitado(String servicio,String ruta) {
		BDServicio.abrirBaseDatos(ruta);
		String resp="";
		String destino="";
		try {
			Statement st = conn.createStatement();
			if (servicio=="VUELO") {
				resp="SELECT V.DESTINO FROM VUELO V,VUELOCOMPRADO VC WHERE V.COD_VUELO=VC.COD_VUELO_COMPRADO GROUP BY DESTINO,COD_VUELO HAVING(max(COD_VUELO));";
			} else  {
				resp="SELECT B.DESTINO FROM BUS B,BUSCOMPRADO BC WHERE B.COD_BUS=BC.COD_BUS_COMPRADO GROUP BY DESTINO,COD_BUS HAVING(max(COD_BUS));";     //POR LOGICA EL DESTINO MAS VISITADO DEL BUS SERA EL MISMO QUE EL DE LOS VIAJES COMBINADOS
			}
			
			ResultSet rs = st.executeQuery(resp);
			
			destino= rs.getString(1);
			
			
		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR AL DEVOLVER RESULTADO DESTINO MAS VISITADO", e);
			e.printStackTrace();
		}
		
		log(Level.INFO, "DEVOLVIENDO DESTINO MAS VISITADO", null);
		BDServicio.cerrarConexion();
		return destino;
	}
	
	
	//6-COMPRAS POR CADA MES(DEVUELVE ARRAYLIST)
	
	public static ArrayList<Integer> comprasAnualesTotales(String ruta) {
		BDServicio.abrirBaseDatos(ruta);
		String resp="";
		ArrayList<Integer> resultados= new ArrayList<Integer>();
		ArrayList<Integer> resultados2= new ArrayList<Integer>();
		ArrayList<Integer> resultados3= new ArrayList<Integer>();
		try {
			Statement st = conn.createStatement();
			int indice=0;
			int comprasMes=0;
			for (int i=1; i<13; i++) {
				String mes = String.format("%02d", i);
				resp="SELECT COUNT(*) FROM VUELOCOMPRADO WHERE FECHA_COMPRA LIKE '2022/"+mes+"%';";
				ResultSet rs = st.executeQuery(resp);
				comprasMes = rs.getInt(1);
				resultados.add(indice,comprasMes);
				indice++;
			}
			indice=0;
			for (int i=1; i<13; i++) {
				String mes = String.format("%02d", i);
				resp="SELECT COUNT(*) FROM BUSCOMPRADO WHERE FECHA_COMPRA LIKE '2022/"+mes+"%';";
				ResultSet rs = st.executeQuery(resp);
				comprasMes = rs.getInt(1);
				int valorAnterior= resultados.get(indice);
				comprasMes=comprasMes+valorAnterior;
				resultados2.add(indice,comprasMes);
				indice++;
			}
			indice=0;
			for (int i=1; i<13; i++) {
				String mes = String.format("%02d", i);
				resp="SELECT COUNT(*) FROM VIAJECOMBINADOCOMPRADO WHERE FECHA_COMPRA LIKE '2022/"+mes+"%';";
				ResultSet rs = st.executeQuery(resp);
				comprasMes = rs.getInt(1);
				int valorAnterior= resultados2.get(indice);
				comprasMes=comprasMes+valorAnterior;
				resultados3.add(indice,comprasMes);
				indice++;
			}
			
		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR AL DEVOLVER COMPRAS ANUALES", e);
			e.printStackTrace();
		}
		
		log(Level.INFO, "DEVOLVIENDO COMPRAS ANUALES", null);
		BDServicio.cerrarConexion();
		return resultados3;
	}
	
	//7-COMPRAS POR CADA TIPO DE SERVICIO (DEVUELVE ARRAYLIST: ORDEN VUELO,BUS,VIAJECOMBINADO)
	
	public static ArrayList<Integer> comprasServicio(String ruta) {
		BDServicio.abrirBaseDatos(ruta);
		String resp="";
		ArrayList<Integer> resultados= new ArrayList<Integer>();
		ArrayList<String> servicios= new ArrayList<String>();
		servicios.add("VUELOCOMPRADO");
		servicios.add("BUSCOMPRADO");
		servicios.add("VIAJECOMBINADOCOMPRADO");
		try {
			Statement st = conn.createStatement();
			int indice=0;
			
			for (String servicio:servicios) {
				resp="SELECT COUNT(*) FROM "+servicio+";";
				ResultSet rs = st.executeQuery(resp);
				int numeroCompras = rs.getInt(1);
				resultados.add(indice,numeroCompras);
				indice++;
				
			}
			
		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR AL DEVOLVER COMPRAS POR SERVICIO", e);
			e.printStackTrace();
		}
		
		log(Level.INFO, "DEVOLVIENDO COMPRAS POR SERVICIO", null);
		BDServicio.cerrarConexion();
		return resultados;
	}
	
	//8-COMPRAS POR CADA DESTINO(DEVUELVE ARRAYLIST: ORDEN BARCELONA, MADRID, VALENCIA, LUGO, MURCIA, BILBAO, CADIZ, LISBOA, SANTANDER, CASTELLON)

	
	public static ArrayList<Integer> comprasDestino(String ruta) {
		BDServicio.abrirBaseDatos(ruta);
		String resp="";
		ArrayList<Integer> resultados= new ArrayList<Integer>();
		ArrayList<Integer> resultados2= new ArrayList<Integer>();

		ArrayList<String> destinos= new ArrayList<String>();
		destinos.add("Barcelona");
		destinos.add("Madrid");
		destinos.add("Valencia");
		destinos.add("Lugo");
		destinos.add("Murcia");
		destinos.add("Bilbao");
		destinos.add("Cadiz");
		destinos.add("Lisboa");
		destinos.add("Santander");
		destinos.add("Castellon");
		
		try {
			Statement st = conn.createStatement();
			int indice=0;
			for (String destino:destinos) {
				resp="SELECT COUNT(*) FROM VUELO V,VUELOCOMPRADO VC WHERE V.COD_VUELO=VC.COD_VUELO_COMPRADO AND V.DESTINO='"+destino+"';";
				ResultSet rs = st.executeQuery(resp);
				int numeroCompras = rs.getInt(1);
				resultados.add(indice,numeroCompras);
				indice++;
			}
			indice=0;
			for (String destino:destinos) {
				resp="SELECT COUNT(*) FROM BUS B,BUSCOMPRADO BC WHERE B.COD_BUS=BC.COD_BUS_COMPRADO AND B.DESTINO='"+destino+"';";
				ResultSet rs = st.executeQuery(resp);
				int numeroCompras = rs.getInt(1);
				int valorAnterior= resultados.get(indice);
				numeroCompras=numeroCompras+valorAnterior;
				resultados2.add(indice,numeroCompras);
				indice++;
			}
		} catch (SQLException e) {
			log(Level.SEVERE, "ERROR AL DEVOLVER COMPRAS POR DESTINO", e);
			e.printStackTrace();
		}
		
		log(Level.INFO, "DEVOLVIENDO COMPRAS POR DESTINO", null);
		BDServicio.cerrarConexion();
		return resultados2;
	}
	
	
	
	public static  ArrayList <Vuelo> verVuelo(String ruta) throws SQLException {
		
		BDServicio.abrirBaseDatos(ruta);
		String sql = "SELECT * FROM vuelo";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ArrayList <Vuelo> listaConVuelos = new ArrayList <Vuelo> ();
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
			
			try {
				Vuelo vueloNuevo = new Vuelo(codigoVuelo, FechaVuelo, horaSalidaVuelo, duracion, origenV,destinoV, precio, tipo,plazasRestantes,companya);
				listaConVuelos.add(vueloNuevo);	
				
			}catch (Exception e) {
				// TODO: handle exception
				return null;
			}
			
		}
		return listaConVuelos;
		
		
	}



	public static  ArrayList <Bus> verBus(String ruta) throws SQLException {
	
		BDServicio.abrirBaseDatos(ruta);
		String sql = "SELECT * FROM bus";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ArrayList <Bus> listaConBus = new ArrayList <Bus> ();
		while(rs.next()) {
			int codigoVuelo = rs.getInt("COD_BUS");
			String FechaVuelo = rs.getString("FECHA");
			String horaSalidaVuelo = rs.getString("HORA_SALIDA");
			int duracion = rs.getInt("DURACION");
			String origenV = rs.getString("ORIGEN");
			String destinoV = rs.getString("DESTINO");
			Double precio = rs.getDouble("PRECIO");
			TipoServicio tipo = TipoServicio.vuelo;
			int plazasRestantes = rs.getInt("PLAZAS_RESTANTES");
			String companya= rs.getString("COMPANYA_BUS");
		
		try {
			Bus busNuevo = new Bus(codigoVuelo, FechaVuelo, horaSalidaVuelo, duracion, origenV,destinoV, precio, tipo,plazasRestantes,companya);
			listaConBus.add(busNuevo);	
			
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
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
