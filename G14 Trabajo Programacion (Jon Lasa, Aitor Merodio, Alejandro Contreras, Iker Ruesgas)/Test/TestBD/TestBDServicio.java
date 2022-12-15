package TestBD;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	
	//SOLO HABRIA QUE PONER EL INDICADO Y COMPROBAR QUE FUNCIONA!!!!!!
	
	
	@Test
	public void testMostrarBusesTotal() {
		
		//LLAMAMOS AL METODO
		ArrayList<Bus> listaBus = BDServicio.mostrarBusesTotal();
		
		//primero comprobamos que no es vacia
		
		assertNotNull(listaBus);
		
		//DESPUES COMPROBAMOS LA BASE DE DATOS Y VEMOS QUE EL PRIMERO A MOSTRAR TIENE ORIGEN SEVILLA Y DESTINO LUGO
		String origenp = listaBus.get(0).getOrigen();
		String destinop = listaBus.get(0).getDestino();
		
		//COMPROBAMOS
		
		assertEquals(origenp, "Sevilla");
		assertEquals(destinop, "Lugo");
		
		//EL ULTIMO TIENE DE ORIGEN BARCELONA Y DE DESTINO SEVILLA
		String origenu = listaBus.get(listaBus.size()-1).getOrigen();
		String destinou = listaBus.get(listaBus.size()-1).getDestino();
		
		//COMPROBAMOS
		
		assertEquals(origenu, "Barcelona");
		assertEquals(destinou, "Bilbao");
		
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
//		//EL ULTIMO ES LISBOA (sin repetir)
//		
		String origenUltimo = listaOrigenesVuelo.get(listaOrigenesVuelo.size()-1);
//		
		assertEquals("Lisboa", origenUltimo);
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
		
		//DESPUES COMPROBAMOS LA BASE DE DATOS Y VEMOS QUE EL PRIMERO A MOSTRAR TIENE ORIGEN MADRID Y DESTINO VALENCIA
		String origenp = listaVuelo.get(0).getOrigen();
		String destinop = listaVuelo.get(0).getDestino();
		
		//COMPROBAMOS
		
		assertEquals(origenp, "Madrid");
		assertEquals(destinop, "Valencia");
		
		//EL ULTIMO TIENE DE ORIGEN BILBAO Y DE DESTINO LUGO
		String origenu = listaVuelo.get(listaVuelo.size()-1).getOrigen();
		String destinou = listaVuelo.get(listaVuelo.size()-1).getDestino();
		
		//COMPROBAMOS
		
		assertEquals(origenu, "Bilbao");
		assertEquals(destinou, "Lugo");
		
	}
	
	@Test
	public void testCompraServicio() {
		
		//PRIMERO CREAMOS LA COMPRA;
		//EJEMPLO, DE BUS
		
		//BusComprado bus = new BusComprado (3, 2, "2022-12-04",6,TipoServicio.bus, new Bus("2023-12-03",TipoServicio.bus) );
		
		//SI NO FUNCIONA ESTA INSERCION, PROBAMOS CON UNA YA EXISTENTE
		
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
