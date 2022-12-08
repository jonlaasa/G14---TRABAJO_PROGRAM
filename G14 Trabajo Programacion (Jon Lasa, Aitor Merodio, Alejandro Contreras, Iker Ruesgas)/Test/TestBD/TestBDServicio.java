package TestBD;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import BD.BDServicio;
import Datos.Bus;

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
		
		//EL ULTIMO TIENE DE ORIGEN MURCIA Y DE DESTINO SEVILLA
		String origenu = listaBus.get(listaBus.size()-1).getOrigen();
		String destinou = listaBus.get(listaBus.size()-1).getDestino();
		
		//COMPROBAMOS
		
		assertEquals(origenu, "Murcia");
		assertEquals(destinou, "Sevilla");
		
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
//		//EL ULTIMO ES CASTELON (sin repetir)
//		
		String origenUltimo = listaOrigenesVuelo.get(listaOrigenesVuelo.size()-1);
//		
		assertEquals("Castellon", origenUltimo);
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
		
		//EL ULTIMO ES Sevilla (sin repetir)
		
         String destinoUltimo = listaDestinosVuelo.get(listaDestinosVuelo.size()-1);
		
		assertEquals("Sevilla", destinoUltimo);
	}
	
	
	
	
	
	
	
	
	
	

}
