package TestBD;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import Datos.ViajeCombinado;
import Datos.Vuelo;
import Enum.TipoServicio;

public class TestBDServicio {

	
	//en los test probaremos que el funcionamiento de la base de datos y los metodos de bases de datos es correcto
	@Before
	public void setUp() throws Exception {
		
		//INICIALIZAR LA BD NO ES NECESARIO YA QUE SE INICIALIZA Y CIERRA EN CADA METODO (ASI LO HEMIS DECIDIDO)
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
	
	
	
	
	
	
	
	

}
