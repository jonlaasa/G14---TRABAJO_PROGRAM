package TestBD;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.logging.Level;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import BD.BDRegistro;
import BD.BDServicio;
import Datos.Bus;
import Datos.BusComprado;
import Datos.Usuario;
import Datos.ViajeCombinado;
import Datos.Vuelo;
import Datos.VueloComprado;
import Enum.TipoServicio;

public class TestBDServicio {

	
	//en los test probaremos que el funcionamiento de la base de datos y los metodos de bases de datos es correcto
	
	@Before
	public void setUp() throws Exception {
		
		//INICIALIZAR LA BD NO ES NECESARIO YA QUE SE INICIALIZA Y CIERRA EN CADA METODO (ASI LO HEMOS DECIDIDO)
	}


	@Test
	public void testInicializarYCerrarBd() {
		Connection c = BDServicio.abrirBaseDatos("basesDeDatos/serviciosCompanya.db");
		//COMPROBAMOS QUE NO ES NULA
		
		assertNotNull(c);
		
		BDServicio.cerrarConexion();
		
	}

	//IMPORTANTE!!!!!!!!!
	
	///////ESTOS TEST PUEDEN FALLAR YA QUE AL ANYADIR NUEVOS,NO TIENE PORQUE DAR TRUE
	
	//SOLO HABRIA QUE PONER EL INDICADO Y COMPROBAR QUE FUNCIONA!!!!!! TENIENDO EN CUENTA
	
	
	@Test
	public void testMostrarBusesTotal() {
		
		//LLAMAMOS AL METODO
		ArrayList<Bus> listaBus = BDServicio.mostrarBusesTotal();
		
		//primero comprobamos que no es vacia
		
		assertNotNull(listaBus);
		
		//DESPUES COMPROBAMOS LA BASE DE DATOS Y VEMOS QUE EL PRIMERO A MOSTRAR TIENE ORIGEN BARCELONA Y DESTINO Madrid
		//ordenados POR FECHA 
		
		String origenp = listaBus.get(0).getOrigen();
		String destinop = listaBus.get(0).getDestino();
		
		//COMPROBAMOS
		
		assertEquals(origenp, "Barcelona");
		assertEquals(destinop, "Madrid");
		
		//EL ULTIMO TIENE DE ORIGEN BARCELONA Y DE DESTINO Lisboa
		String origenu = listaBus.get(listaBus.size()-1).getOrigen();
		String destinou = listaBus.get(listaBus.size()-1).getDestino();
		
		//COMPROBAMOS
		
		assertEquals(origenu, "Barcelona");
		assertEquals(destinou, "Lisboa");
		
	}
	
	
	@Test
	public void testMostrarOrigenesBus() {
		
		//LLAMAMOS AL METODO CON BUS PRIMERO
		ArrayList<String> listaOrigenesBus  = BDServicio.mostrarDiferentesOrigenes("bus");
		
		//primero comprobamos que no es vacia
		
		assertNotNull(listaOrigenesBus);
		
		//DESPUES, SABEMOS QUE EL PRIMERO ES SEVILLA
		
		String origenPrimero = listaOrigenesBus.get(0);
		assertEquals("Sevilla", origenPrimero);
		
		//EL ULTIMO ES CASTELLON (sin repetir)
		
         String origenUltimo = listaOrigenesBus.get(listaOrigenesBus.size()-1);
		
		assertEquals("Castellon", origenUltimo);
	}
	
	
	@Test
	public void testMostrarOrigenesVuelo() {
		
		//LLAMAMOS AL METODO CON BUS PRIMERO
		ArrayList<String> listaOrigenesVuelo = BDServicio.mostrarDiferentesOrigenes("vuelo");
		
		//primero comprobamos que no es vacia
		
		assertNotNull(listaOrigenesVuelo);
		
		//DESPUES, SABEMOS QUE EL PRIMERO ES SEVILLA
		
		String origenPrimero = listaOrigenesVuelo.get(0);
//		
		assertEquals("Madrid", origenPrimero);
//		
//		//EL ULTIMO ES CADIZ (sin repetir)
//		
		String origenUltimo = listaOrigenesVuelo.get(listaOrigenesVuelo.size()-1);
//		
		assertEquals("Cadiz", origenUltimo);
	}
	
	
	@Test
	public void testMostrarDestinosBus() {
		
		//LLAMAMOS AL METODO CON BUS PRIMERO
		ArrayList<String> listaDestinosBus  = BDServicio.mostrarDiferentesDestinos("bus");
		
		//primero comprobamos que no es vacia
		
		assertNotNull(listaDestinosBus);
		
		//DESPUES, SABEMOS QUE EL PRIMERO ES Lugo
		
		String destinoPrimero = listaDestinosBus.get(0);
		
		assertEquals("Lugo", destinoPrimero);
		
		//EL ULTIMO ES Cadiz (sin repetir)
		
         String destinoUltimo = listaDestinosBus.get(listaDestinosBus.size()-1);
		
		assertEquals("Cadiz", destinoUltimo);
	}
	
	@Test
	public void testMostrarDestinosVuelo() {
		
		//LLAMAMOS AL METODO CON BUS PRIMERO
		ArrayList<String> listaDestinosVuelo  = BDServicio.mostrarDiferentesDestinos("vuelo");
		
		//primero comprobamos que no es vacia
		
		assertNotNull(listaDestinosVuelo);
		
		//DESPUES, SABEMOS QUE EL PRIMERO ES Valencia
		
		String destinoPrimero = listaDestinosVuelo.get(0);
		
		assertEquals("Valencia", destinoPrimero);
		
		//EL ULTIMO ES Lugo (sin repetir)
		
         String destinoUltimo = listaDestinosVuelo.get(listaDestinosVuelo.size()-1);
		
		assertEquals("Lugo", destinoUltimo);
	}
	
	
	@Test
	public void testMostrarVuelosTotal() {
		
		//LLAMAMOS AL METODO
		ArrayList<Vuelo> listaVuelo = BDServicio.mostrarVuelosTotal();
		
		//primero comprobamos que no es vacia
		
		assertNotNull(listaVuelo);
		
		//DESPUES COMPROBAMOS LA BASE DE DATOS Y VEMOS QUE EL PRIMERO A MOSTRAR TIENE ORIGEN Valencia Y DESTINO Cadiz
		String origenp = listaVuelo.get(0).getOrigen();
		String destinop = listaVuelo.get(0).getDestino();
		
		//COMPROBAMOS
		
		assertEquals(origenp, "Valencia");
		assertEquals(destinop, "Cadiz");
		
		//EL ULTIMO TIENE DE ORIGEN Barcelona Y DE DESTINO Bilbao
		String origenu = listaVuelo.get(listaVuelo.size()-1).getOrigen();
		String destinou = listaVuelo.get(listaVuelo.size()-1).getDestino();
		
		//COMPROBAMOS
		
		assertEquals(origenu, "Barcelona");
		assertEquals(destinou, "Bilbao");
		
	}
	
	@Test
	public void testCompraServicio() {
		
		
		//PROBAMOS CON UNA YA EXISTENTE
		
		//INSERTAMOS
		// BDServicio.compraServicio(bus);
		 
		 //AHORA MIRAMOS SI EXISTE (ya creado, con codigo de compra 0 )
		 
		 boolean existe = false;
		 
		 Connection conn = BDServicio.abrirBaseDatos("basesDeDatos/serviciosCompanya.bd");
		 try {
				Statement st = conn.createStatement();
				
				//BUSCAMOS
				
				String sent = "select * from bus where cod_compra= 0";
				
				ResultSet rs = st.executeQuery(sent);
				if(rs.next()) {
					existe=true;
				}
				
			
				//COMPROBAMOS
			assertTrue(existe);
				
				
				
		 }catch (SQLException e) {
			// TODO: handle exception
		}
		
		BDServicio.cerrarConexion();
		
	}
	
	//TEST PARA COMPROBAR LOS ORIGENES DE LOS VIAJES COMBINADOS
	@Test
	public void testMostrarOrigenesCombinados() {
		
		//LLAMAMOS AL METODO CON BUS PRIMERO
		TreeSet<String> listaOrigenesCombinados  = BDServicio.mostrarOrigenesCombinados();
		
		//primero comprobamos que no es vacia
		
		assertNotNull(listaOrigenesCombinados);
		
		//DESPUES, SABEMOS QUE EL PRIMERO ES Barcelona
		
		String origenPrimero = listaOrigenesCombinados.first();
		assertEquals("Barcelona", origenPrimero);
		
		//EL ULTIMO ES VALENCIA (sin repetir)
		
         String origenUltimo = listaOrigenesCombinados.last();
		
		assertEquals("Valencia", origenUltimo);
	}
	
	//TEST PARA COMPROBAR LOS DESTINOS DE LOS VIAJES COMBINADOS
	
	
	@Test
	public void testMostrarDestinosCombinados() {
		
		//LLAMAMOS AL METODO CON BUS PRIMERO
		TreeSet<String> listaDestinosCombinados  = BDServicio.mostrarDestinosCombinados();
		
		//primero comprobamos que no es vacia
		
		assertNotNull(listaDestinosCombinados);
		
		//DESPUES, SABEMOS QUE EL PRIMERO ES Barcelona (ORDENADOS DE MANERA ALFABETICA)
		
		String destinoPrimero = listaDestinosCombinados.first();
		assertEquals("Barcelona", destinoPrimero);
		
		//EL ULTIMO ES VALENCIA (sin repetir) esta ordenado de manera alfabetica
		
         String origenUltimo = listaDestinosCombinados.last();
		
		assertEquals("Valencia", origenUltimo);
	}
	
	//TEST PARA MOSTRAR VIAJE COMBINADOS TOTAL
	@Test
	public void testMostrarViajeCombinadoTotal() {
		
		//LLAMAMOS AL METODO
		ArrayList<ViajeCombinado> listaViaje = BDServicio.mostrarViajesCombinadosTotal();
		
		//primero comprobamos que no es vacia
		
		//ESTAN ORDENADOS POR FECHA
		
		assertNotNull(listaViaje);
		
		//DESPUES COMPROBAMOS LA BASE DE DATOS Y VEMOS QUE EL PRIMERO A MOSTRAR TIENE ORIGEN Valencia Y DESTINO Cadiz
		String origenp = listaViaje.get(0).getOrigen();
		String destinop = listaViaje.get(0).getDestino();
		
		//COMPROBAMOS
		
		assertEquals(origenp, "Barcelona");
		assertEquals(destinop, "Santander");
		
		//EL ULTIMO TIENE DE ORIGEN Barcelona Y DE DESTINO Bilbao
		String origenu = listaViaje.get(listaViaje.size()-1).getOrigen();
		String destinou = listaViaje.get(listaViaje.size()-1).getDestino();
		
		//COMPROBAMOS
		
		assertEquals(origenu, "Valencia");
		assertEquals(destinou, "Bilbao");
		
	}
	
	
	
	//TEST PARA MOSTRAR VUELOS CON FILTRO
	@Test
	public void testServicioVueloFiltrado() {
		
		//LLAMAMOS AL METODO CON UN EJEMPLO (DE VALENCIA A MADRID DE MAYOR A MENOR, ENTRE EL 20 DE DICIEMBRE DE
		//2022 Y EL 1 DE JUNIO DE 2023 
		ArrayList<Vuelo> listaVuelosFiltrado = BDServicio.listaServicioVueloFiltrado("Madrid", "Valencia", "mayor", "2022-12-20", "2023-06-01");
		
		//primero comprobamos que no es vacia
		
		//ESTAN ORDENADOS POR FECHA
		
		assertNotNull(listaVuelosFiltrado);
		
		//DESPUES COMPROBAMOS LA BASE DE DATOS Y VEMOS QUE EL PRIMERO A MOSTRAR TIENE ORIGEN Valencia Y DESTINO Cadiz
		String origenp = listaVuelosFiltrado.get(0).getOrigen();
		String destinop = listaVuelosFiltrado.get(0).getDestino();
		
		//COMPROBAMOS
		
		assertEquals(origenp, "Madrid");
		assertEquals(destinop, "Valencia");
		
		// LA BUSQUEDA SOLO DEBERIA DEVOLVER UN UNICO VUELO,POR TANTO COMPROBAMOS
		
		assertEquals(1, listaVuelosFiltrado.size());
		
	}
	
	//TEST PARA COMPROBAR FILTRO DE BUS
	
	@Test
	public void testServicioBusFiltrado() {
		
		//LLAMAMOS AL METODO CON UN EJEMPLO (DE Sevilla A Lugo DE MAYOR A MENOR, ENTRE EL 20 DE DICIEMBRE DE
		//2022 Y EL 22 DE DICIEMBRE DE 2023 
		ArrayList<Bus> listaBusFiltrado = BDServicio.listaServicioBusFiltrado("Sevilla", "Lugo",
				"mayor", "2022-12-20", "2023-12-20");
		
		//primero comprobamos que no es vacia
		
		//ESTAN ORDENADOS POR FECHA
		
		assertNotNull(listaBusFiltrado);
		
		//DESPUES COMPROBAMOS LA BASE DE DATOS Y VEMOS QUE EL PRIMERO A MOSTRAR TIENE ORIGEN Valencia Y DESTINO Cadiz
		String origenp = listaBusFiltrado.get(0).getOrigen();
		String destinop = listaBusFiltrado.get(0).getDestino();
		
		//COMPROBAMOS
		
		assertEquals(origenp, "Sevilla");
		assertEquals(destinop, "Lugo");
		
		// LA BUSQUEDA SOLO DEBERIA DEVOLVER UN UNICO VUELO,POR TANTO COMPROBAMOS
		
		assertEquals(1, listaBusFiltrado.size());
		
	}
	
	
	//FALTA EL FILTRADO DE LOS VIAJES COMBINADOS TAMBIEN.
	
	@Test
	public void testServicioCombinadoFiltrado() {
		
		//LLAMAMOS AL METODO CON UN EJEMPLO (DE Sevilla A Lugo DE MAYOR A MENOR, ENTRE EL 1 DE DICIEMBRE  DE
		//2022 Y EL 1 DE ENERO DE 2023 
		ArrayList<ViajeCombinado> listaViajeCFiltrado = BDServicio.listaServicioCombinadoFiltrado("Barcelona", "Santander",
				 "2022-12-01", "2023-01-01");
		
		//primero comprobamos que no es vacia
		

		// ESTAN ORDENADOS POR FECHA
		
		assertNotNull(listaViajeCFiltrado);
//		
		//DESPUES COMPROBAMOS LA BASE DE DATOS Y VEMOS QUE SOLO TIENE UNO VALIDO
		String origenp = listaViajeCFiltrado.get(0).getOrigen();
		String destinop = listaViajeCFiltrado.get(0).getDestino();
//		
//		//COMPROBAMOS
//		

		assertEquals(origenp, "Barcelona");
		assertEquals(destinop, "Santander");
//		
		// LA BUSQUEDA SOLO DEBERIA DEVOLVER UN UN VIAJE COMBINADO, (SOLO HAY UNO CON ESAS CONDICIONES),POR TANTO COMPROBAMOS
//		
		assertEquals(1, listaViajeCFiltrado.size());
		
		
		//PROBAMOS VALENCIA BILBAO (1 DE ENERO DE 2023 - 1 DE ENERO DE 2024)
		
		ArrayList<ViajeCombinado> listaViajeCFiltrado2 = BDServicio.listaServicioCombinadoFiltrado("Valencia", "Bilbao",
				 "2023-01-01", "2024-01-01");
		
		//primero comprobamos que no es vacia
		

		// ESTAN ORDENADOS POR FECHA
		
		assertNotNull(listaViajeCFiltrado2);
		String origenp2 = listaViajeCFiltrado2.get(1).getOrigen();
		String destinop2 = listaViajeCFiltrado2.get(11).getDestino();
		assertEquals(origenp2, "Valencia");
		assertEquals(destinop2, "Bilbao");
		
		// LA BUSQUEDA SOLO DEBERIA DEVOLVER 46 VIAJE COMBINADO, ,POR TANTO COMPROBAMOS 
		//IMPORTANTE!! PUEDE DAR ERROR A MEDIDA QUE HAY MAS VUELOS!!!
		
		assertEquals(46, listaViajeCFiltrado2.size());
		
		
	}
	

	
	//TEST PARA COMPROBAR CUAL ES LA SIGUIENTE CLAVE VALIDA PARA LA TABLA DE RENTING
	//PARA ELLO OBTENEMOS CUAL ES LA ULTIMA
	
	@Test
	public void testClaveRenting() {
		
		//LLAMAMOS AL METODO Y OBTENEMOS LA CLAVE
			int clave = BDServicio.claveRenting();
		
		//primero comprobamos que no es null
		
		
		assertNotNull(clave);
		
		//DESPUES COMPROBAMOS LA BASE DE DATOS Y VEMOS QUE EL ultimo ES: 1(ACTUAL)
		//esto ira variando, por lo tanto hay que mirar la base de datos y cambiar el 1 por el que tocaria en el momento
		//que hacemos el test
		
		
		assertEquals(1, clave);
		
		
	}
	
	//TEST PARA COMPROBAR EL FUNCIONAMENTO DEL METODO, QUE DANDO UN CODIGO DE VUELO, DEBERIA DEVOLVER EL VUELO (ACCEDIENDO A LA BD)
	
	@Test
	public void testVueloDesdeCodigo() {
		
		//INICIALIZAMOS
		Vuelo v1= null;
		Vuelo v2= null;
		Vuelo v3 = null;
		
		//DOS CODIGOS AL AZAR.
		int cod1 = 3;
		int cod2= 100;
		int cod3= -40;
		//LLAMAMOS AL METODO Y OBTENEMOS LOS VUELOS 
			v1 = BDServicio.vueloDesdeCodigo(cod1);
			v2 = BDServicio.vueloDesdeCodigo(cod2);
			v3 = BDServicio.vueloDesdeCodigo(cod3);
			
			//UNA VEZ LOS OBTENEMOS, MIRAMOS LA BD, Y POR EJEMPLO COMPROBAMOS SU HORA DE SALIDA
			// el de v1 deberia ser: 13:15
			//el de v2 deberia ser : 14:00
			
			assertEquals("13:15", v1.getHoraSalida());
			assertEquals("14:00", v2.getHoraSalida());
			
			
			//el vuelo v3 deberia ser nulo, ya que no existe vuelo con ese codigo
			
			assertNull(v3);
			
			
			
		
	}
	
	
	
	
	//TEST PARA COMPROBAR EL FUNCIONAMENTO DEL METODO, QUE DANDO UN CODIGO DE BUS, DEBERIA DEVOLVER EL BUS (ACCEDIENDO A LA BD)
	@Test
	public void testBusDesdeCodigo() {
		
		//INICIALIZAMOS
		Bus b1= null;
		Bus b2= null;
		Bus b3 = null;
		
		//DOS CODIGOS AL AZAR.
		int cod1 = 5;
		int cod2= 80;
		int cod3= -20;
		//LLAMAMOS AL METODO Y OBTENEMOS LOS VUELOS 
			b1 = BDServicio.busDesdeCodigo(cod1);
			b2 = BDServicio.busDesdeCodigo(cod2);
			b3 = BDServicio.busDesdeCodigo(cod3);
			
			//UNA VEZ LOS OBTENEMOS, MIRAMOS LA BD, Y POR EJEMPLO COMPROBAMOS SU HORA DE SALIDA
			// el de b1 deberia ser: 14:45
			//el de b2 deberia ser : 15:00
			
			assertEquals("14:45", b1.getHoraSalida());
			assertEquals("15:00", b2.getHoraSalida());
			
			
			//el bus b3 deberia ser nulo, ya que no existe bus con ese codigo
			
	
			assertNull(b3);
	}
	//TEST PARA COMPROBAR EL FUNCIONAMENTO DEL METODO, QUE DANDO UN CODIGO DE USUARIO, DEBERIA DEVOLVER LOS VUELOS COMPRADOS 
	@Test	
	public void testVuelosCompradosUsuarios() {

		//OBTENEMOS EL USUARIO JONLASA POR EJEMPLO
		Usuario u= null;
		try {
			u = BDRegistro.obtenerUsuario("jonlasa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//LLAMAMOS AL METODO Y OBTENEMOS SUS VUELOS COMPRADOS
		
		ArrayList<VueloComprado> listaConComprados = BDServicio.vuelosCompradosUsuario(u.getCodigo());
		
		//AHORA MIRAMOS LA BASE DE DATOS Y COMPROBAMOS QUE EL PRIMERO DE LOS VUELOS COMPRADOS TIENE
		//CODVUELO = 4 Y PRECIO =70.
		
		//EL PRIMERO 
		
		VueloComprado vueloPrimero = listaConComprados.get(0);
		
		assertEquals(4,vueloPrimero.getVuelo().getCodigo() );
		assertEquals(70,(int)vueloPrimero.getPrecio() );
		
		//SIN EMBARGO EL USUARIO ALEJANDRO NO HA COMPRADO NINGUNO
		Usuario usuario2 = null;
		try {
			 usuario2 = BDRegistro.obtenerUsuario("alejandro");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//lista de sus vuelos comprados
		
		ArrayList<VueloComprado> listaConVuelosUsuario2 = BDServicio.vuelosCompradosUsuario(usuario2.getCodigo());
		
		assertEquals(0, listaConVuelosUsuario2.size());

	}
	@Test
	//TEST PARA COMPROBAR EL FUNCIONAMENTO DEL METODO, QUE DANDO UN CODIGO DE USUARIO, DEBERIA DEVOLVER LOS BUSES COMPRADOS 
	public void testBusesCompradosUsuarios() {

		//OBTENEMOS EL USUARIO JONLASA POR EJEMPLO
		Usuario u= null;
		try {
			u = BDRegistro.obtenerUsuario("jonlasa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//LLAMAMOS AL METODO Y OBTENEMOS SUS Buses COMPRADOS
		
		ArrayList<BusComprado> listaConComprados = BDServicio.busesCompradosUsuario(u.getCodigo());
		
		//AHORA MIRAMOS LA BASE DE DATOS Y COMPROBAMOS QUE EL PRIMERO DE LOS VUELOS COMPRADOS TIENE
		//CODBUS = 4 Y PRECIO =70.
		
		//EL PRIMERO 
		
		BusComprado busPrimero = listaConComprados.get(0);
		
		assertEquals(5,busPrimero.getBus().getCodigo() );
		assertEquals(160,(int)busPrimero.getPrecio() );
		
		//SIN EMBARGO EL USUARIO ALEJANDRO NO HA COMPRADO NINGUNO
		Usuario usuario2 = null;
		try {
			 usuario2 = BDRegistro.obtenerUsuario("alejandro");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//lista de sus vuelos comprados
		
		ArrayList<BusComprado> listaConVuelosUsuario2 = BDServicio.busesCompradosUsuario(usuario2.getCodigo());
		
		assertEquals(0, listaConVuelosUsuario2.size());

	}
	
	
	
	//TEST PARA COMPROBAR LAS CONSULTAS DE LA VENTANA ESTADISTICA
	
	@Test
	public void testmediaCompras() {
		
		//LLAMAMOS AL METEDO Y LE PASAMOS COMO PARAMETRO UN SERVICIO string (EJEMPLO: VUELO)
		String media = BDServicio.mediaCompras("VUELO");
		
		//PRIMERO COMPROBAMOS QUE NO SEA NULL
		assertNotNull(media);
		
		//DESPUES COMPROBAMOS SI LA MEDIA ES IGUAL A LA MEDIA CALCULADA A MANO DE LA BASE DE DATOS
			//esto ira variando, por lo tanto hay que mirar la base de datos y cambiar 
			//que hacemos el test
		
		//Despues de calcular la media de los vuelos comprados nos da 300
		assertEquals("300.0", media);
	}
	
	@Test
	public void testcompraMax() {
		
		//LLAMAMOS AL METEDO Y LE PASAMOS COMO PARAMETRO UN SERVICIO string (EJEMPLO: VUELO)
		String max = BDServicio.compraMax("VUELO");
		
		//PRIMERO COMPROBAMOS QUE NO SEA NULL
		assertNotNull(max);
		
		//DESPUES COMPROBAMOS SI EL MAXIMO ES EL MISMO QUE EL DE LA BASE DE DATOS
			//esto ira variando, por lo tanto hay que mirar la base de datos y cambiar 
			//que hacemos el test
		
		//El valor mas alto de la tabla vuelo comprados es 380
		assertEquals("380.0", max);
	}
	
	@Test
	public void testcompraMin() {
		
		//LLAMAMOS AL METEDO Y LE PASAMOS COMO PARAMETRO UN SERVICIO string (EJEMPLO: VUELO)
		String min = BDServicio.compraMin("VUELO");
		
		//PRIMERO COMPROBAMOS QUE NO SEA NULL
		assertNotNull(min);
		
		//DESPUES COMPROBAMOS SI EL MINIMO ES EL MISMO QUE EL DE LA BASE DE DATOS
			//esto ira variando, por lo tanto hay que mirar la base de datos y cambiar 
			//que hacemos el test
		
		//El valor mas bajo de la tabla vuelo comprados es 140
		assertEquals("140.0", min);
	}
	
	@Test
	public void testusuarioMasCompra() {
		
		//LLAMAMOS AL METEDO Y LE PASAMOS COMO PARAMETRO UN SERVICIO string (EJEMPLO: VUELO)
		String usuario = BDServicio.usuarioMasCompra("VUELO");
		
		//PRIMERO COMPROBAMOS QUE NO SEA NULL
		assertNotNull(usuario);
		
		//DESPUES COMPROBAMOS SI EL USUARIO QUE MAS COMPRA ES EL MISMO QUE EL DE LA BASE DE DATOS
			//esto ira variando, por lo tanto hay que mirar la base de datos y cambiar 
			//que hacemos el test
		
		//El usuario que mas vuelos compra es el usuario 5 (El formato de string es asi porque asi lo hemos decidido)
		assertEquals("COD_USUARIO: 5", usuario);
	}
	
	@Test
	public void testdestinoMasvisitado() {
		
		//LLAMAMOS AL METEDO Y LE PASAMOS COMO PARAMETRO UN SERVICIO string (EJEMPLO: VUELO)
		String destino = BDServicio.destinoMasvisitado("VUELO");
		
		//PRIMERO COMPROBAMOS QUE NO SEA NULL
		assertNotNull(destino);
		
		//DESPUES COMPROBAMOS SI EL DESTINO ES EL MISMO QUE EL DE LA BASE DE DATOS
			//esto ira variando, por lo tanto hay que mirar la base de datos y cambiar 
			//que hacemos el test
		
		//El destino mas visitados por vuelos es Cadiz
		assertEquals("Cadiz", destino);
	}
	
	@Test
	public void testcomprasAnualesTotales() {
		
		//LLAMAMOS AL METEDO PARA CREAR UNA ARRAYLIST DE ENTEROS
		ArrayList<Integer> compras = BDServicio.comprasAnualesTotales();
		
		//PRIMERO COMPROBAMOS QUE NO SEA NULL
		assertNotNull(compras);
		
		//DESPUES COMPROBAMOS SI LA LISTA COPRRESPONDE CON LOS DATOS DE LA BASE DE DATOS
			//esto ira variando, por lo tanto hay que mirar la base de datos y cambiar 
			//que hacemos el test
		
		//SEGUN LA BASE DE DATOS LAS COMPRAS ANUALES REALIZADAS SON LAS SIGUIENTES (ORDENADAS POR MES): 0,0,2,0,0,0,0,1,0,0,1,9
			//CREAMOS UN ARRAYLIST CON ESTOS DATOS:
		ArrayList<Integer> datosBD= new ArrayList<>();
		datosBD.addAll(Arrays.asList(0,0,2,0,0,0,0,1,0,0,1,9));
		assertEquals(datosBD, compras);
	}
	
	@Test
	public void testcomprasServicio() {
		
		//LLAMAMOS AL METEDO PARA CREAR UNA ARRAYLIST DE ENTEROS
		ArrayList<Integer> compras = BDServicio.comprasServicio();
		
		//PRIMERO COMPROBAMOS QUE NO SEA NULL
		assertNotNull(compras);
		
		//DESPUES COMPROBAMOS SI LA LISTA COPRRESPONDE CON LOS DATOS DE LA BASE DE DATOS
			//esto ira variando, por lo tanto hay que mirar la base de datos y cambiar 
			//que hacemos el test
		
		//SEGUN LA BASE DE DATOS LAS COMPRAS POR SERVICIO SON LAS SIGUIENTES (ORDENADAS POR VUELO,BUS Y VIAJE COMBINADO): 9,2,2
			//CREAMOS UN ARRAYLIST CON ESTOS DATOS:
		ArrayList<Integer> datosBD= new ArrayList<>();
		datosBD.addAll(Arrays.asList(9,2,3));
		assertEquals(datosBD, compras);
	}
	
	@Test
	public void testcomprasDestino() {
		
		//LLAMAMOS AL METEDO PARA CREAR UNA ARRAYLIST DE ENTEROS
		ArrayList<Integer> compras = BDServicio.comprasDestino();
		
		//PRIMERO COMPROBAMOS QUE NO SEA NULL
		assertNotNull(compras);
		
		//DESPUES COMPROBAMOS SI LA LISTA COPRRESPONDE CON LOS DATOS DE LA BASE DE DATOS
			//esto ira variando, por lo tanto hay que mirar la base de datos y cambiar 
			//que hacemos el test
		
		//SEGUN LA BASE DE DATOS LAS COMPRAS POR DESTINO SON LAS SIGUIENTES (ORDENADAS A NUESTRO CRITERIO): 0,7,0,0,0,0,2,2,0,0
			//CREAMOS UN ARRAYLIST CON ESTOS DATOS:
		ArrayList<Integer> datosBD= new ArrayList<>();
		datosBD.addAll(Arrays.asList(0,7,0,0,0,0,2,2,0,0));
		assertEquals(datosBD, compras);
	}
	
	
	
	
	
	

	
	
	
	
	

}
