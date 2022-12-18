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
	public void testConstructorSinParametrosRentingYZona() {
		assertEquals(006, vc3.getCodigoUsuario());
		assertEquals(4, vc3.getCantidad());
		assertEquals("2022-12-12", vc3.getFechaCompra());
		assertEquals(TipoServicio.vuelo, vc2.getTipoServicio());
		assertEquals(223, vc3.getCodigoCompra());
		assertEquals(v2, vc2.getVuelo());
		//COMPROBAMOS QUE ESTA VACIA LA LISTA POR DEFECTO
		assertEquals(0, vc3.getListaRenting().size());
		//COMPROBAMOS QUE POR DEFECTO ASIGNA ZONA TRASERA
		
		assertEquals(ZonaAsientoVuelo.trasera, vc3.getZonaAsientoVuelo());
	}
	
	
	//GET Y SET DE LISTA RENTING Y ZONA ASIENTO
	
	@Test
	public void testGetlistaRenting() {
		
		//sabemos que el vc1 tiene coche de gama media para dos dias
		
		assertEquals(ClaseCoche.gamaMedia, vc1.getListaRenting().get(0).getClaseCoche());
		assertEquals(2, vc1.getListaRenting().get(0).getDiasAlquilado());
		
		
		//EN EL CASO DEL SEGUNDO, no tiene por lo tanto la longitud de la lista es 0
		
		assertEquals(0, vc2.getListaRenting().size());
			
		
	}
	
	@Test
	public void testSetlistaRenting() {
		//CREAMOS UN RENTING COCHE Y LO AÑANDIMOS A LA LISTA
		RentingCoche rc5 = new RentingCoche(5,ClaseCoche.gamaAlta);
		ArrayList<RentingCoche> listaCoche3 = new ArrayList<RentingCoche>();
		listaCoche3.add(rc5);
		
		//hacemos el set
		
		vc1.setListaRenting(listaCoche3);
		
		assertEquals(ClaseCoche.gamaAlta, vc1.getListaRenting().get(0).getClaseCoche());
		assertEquals(5, vc1.getListaRenting().get(0).getDiasAlquilado());
		
		
		//LE AÑADIMOS LISTA VACIA Y COMPROBAMOS
		
		ArrayList<RentingCoche> listaCoche4 = new ArrayList<RentingCoche>();
		vc1.setListaRenting(listaCoche4);
		
		assertEquals(0, vc1.getListaRenting().size());
		
	}
	
	

	@Test
	public void testGetZonaAsiento() {
		
		//sabemos que el vc1 tiene zona central
		
		assertEquals(ZonaAsientoVuelo.central, vc1.getZonaAsientoVuelo());
		
		//sabemos que el vc2 tiene zona delantera
		assertEquals(ZonaAsientoVuelo.delantera, vc2.getZonaAsientoVuelo());
			
		
	}
	
	@Test
	public void testSetZonaAsiento() {
		
		
		vc1.setZonaAsientoVuelo(ZonaAsientoVuelo.trasera);
		
		assertEquals(ZonaAsientoVuelo.trasera, vc1.getZonaAsientoVuelo());
		
		vc2.setZonaAsientoVuelo(ZonaAsientoVuelo.trasera);
		assertEquals(ZonaAsientoVuelo.trasera, vc2.getZonaAsientoVuelo());
			
		
	}
	
	
	
	
	//AHORA COMPROBAREMOS EL PRECIO
	
	@Test
	public void testGetPrecio() {
		//EL PRECIO DEL PRMER BUS SERIA: 680 =  (30*20) EL VUELO + 10 POR LA ZONA CENTRAL + 2 *35
		assertEquals((int)vc1.getPrecio(),680);
		
		//EL DEL SEGUNDO seria:105  (40*2 del vuelo, +35 por la zona delantera, + 0 por el renting ya que la lista esta vacia)
		assertEquals(110, (int)vc2.getPrecio());
		
		
	}
	
	@Test
	public void testSetPrecio() {
		//por ejemplo le cambiamos al primer vuelo el precio a 50 y el total del vueloComprado seria =1080
		
		v1.setPrecio(50);
		vc1.setPrecio();
		
		assertEquals((int)vc1.getPrecio(),1080);
		
		//LE cambiamos al segundo vuelo comprado la zona a trasera, y el total seria 80
		
		vc2.setZonaAsientoVuelo(ZonaAsientoVuelo.trasera);
		vc2.setPrecio();
		assertEquals((int)vc2.getPrecio(),80);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
