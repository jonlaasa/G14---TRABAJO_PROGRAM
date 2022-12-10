package TestDatos;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Datos.RentingCoche;
import Datos.Vuelo;
import Datos.VueloComprado;
import Enum.ClaseCoche;
import Enum.TipoServicio;
import Enum.ZonaAsientoVuelo;

public class TestVueloComprado {
	
	VueloComprado vc1;
	VueloComprado vc2;
	VueloComprado vc3;
	Vuelo v1;
	Vuelo v2;
	ArrayList<RentingCoche> listaCoche1;
	ArrayList<RentingCoche> listaCoche2;
	


	@Before
	public void setUp() throws Exception {
		
		//PRIMERO CREAMOS VUELOS PARA INTRODUCIRLOS EN EL VUELOCOMPRADO
		
		 v1 = new Vuelo (1,"2022-12-11","18:00", 0,"Bilbao","Valencia", 30, TipoServicio.vuelo,
				100,"Vueling");
		
		 v2 = new Vuelo (1,"2023-01-11","17:00", 2,"Madrid","Barcelona", 40, TipoServicio.vuelo,
				100,"Iberia");

		
//		//CREAMOS OBJETOS DE LA CLASE RENTING COCHE
//		
		 RentingCoche rc2 = new RentingCoche (2,ClaseCoche.gamaMedia);
//		
		 listaCoche1 = new 	ArrayList<RentingCoche>();
		 listaCoche1.add(rc2);
//		
		 listaCoche2 = new 	ArrayList<RentingCoche>();
//
//		
//		
//		
//		
//		//CREAMOS LOS VUELOS COMPRADOS
//		
		 vc1 = new VueloComprado (005, 20, "2022-11-12", TipoServicio.vuelo,222,v1,listaCoche1,
				 ZonaAsientoVuelo.central);
//		
		 vc2 = new VueloComprado (004, 2, "2022-12-12", TipoServicio.vuelo,223,v2,listaCoche2,
				 ZonaAsientoVuelo.delantera);
//		
//		
		 //CON CONSTRUCTOR SIN ASIENTO Y LISTA VACIA
//		
		 vc3 = new VueloComprado (006, 4, "2022-12-12", TipoServicio.vuelo,223,v2);
//		
	}

	@Test
	public void testConstructorConParametrosCompletos() {
		
		//PROBAMOS PARA VC1 Y VC2
		
		assertEquals(005, vc1.getCodigoUsuario());
		assertEquals(20, vc1.getCantidad());
		assertEquals("2022-11-12", vc1.getFechaCompra());
		assertEquals(TipoServicio.vuelo, vc1.getTipoServicio());
		assertEquals(222, vc1.getCodigoCompra());
		assertEquals(v1, vc1.getVuelo());
		assertEquals(listaCoche1, vc1.getListaRenting());
		assertEquals(ZonaAsientoVuelo.central, vc1.getZonaAsientoVuelo());
//		
//		

		assertEquals(004, vc2.getCodigoUsuario());
		assertEquals(2, vc2.getCantidad());
		assertEquals("2022-12-12", vc2.getFechaCompra());
		assertEquals(TipoServicio.vuelo, vc2.getTipoServicio());
		assertEquals(223, vc2.getCodigoCompra());
		assertEquals(v2, vc2.getVuelo());
		assertEquals(listaCoche2, vc2.getListaRenting());
		assertEquals(ZonaAsientoVuelo.delantera, vc2.getZonaAsientoVuelo());
//		
//		
		
	}
	
	@Test
	public void testConstructorSinParametrosPrecio() {
			
		
	}
	
	
	//TEST PARA COMPROBAR EL PRECIO
	
	@Test
	public void testConstructorConParametrosPrecio() {
			
		
	}
	
	//FALTAN LOS DE GET Y SET
	
	
	
	
	
	
	
	
	
	

}
