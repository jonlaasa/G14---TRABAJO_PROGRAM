package TestDatos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Datos.Bus;
import Datos.ViajeCombinado;
import Datos.Vuelo;
import Enum.TipoServicio;

public class TestViajeCombinado {
	
	ViajeCombinado vc1;
	ViajeCombinado vc2;
	ViajeCombinado vc3; 
	
	Vuelo v1;
	Vuelo v2;
	Vuelo v3;
	
	Bus b1;
	Bus b2;
	Bus b3; 
	


	@Before
	public void setUp() throws Exception {
		
		v1= new Vuelo(5,"2023-4-11","9:15",200,"Madrid","Bilbao",89,TipoServicio.vuelo,100,"Ryanair");
		v2= new Vuelo(-1,"","",0,"","",0,TipoServicio.vuelo,0,"");
		v3=new Vuelo (5,null,null,200,null,null,78,null,200,null);
		
		b1 = new Bus(002,"2023-06-23","18:00", 5000,"Bilbao", "Castellon", 200.0,TipoServicio.bus, 100, "Alsa");
		b2 = new Bus(0, "","",0,"","",0,TipoServicio.bus, 0,"");
		b3 = new Bus(000, null,null,0,null,null,0,TipoServicio.bus, 0,null);
		
		
		vc1 = new ViajeCombinado(1, "2023-4-11", "9:15", 5200, "Madrid", "Castellon", "Bilbao",
				100, TipoServicio.viajeCombinado, 100, b1, v1);
		
		
		
		
		vc2 = new ViajeCombinado(0, "", "", 0, "", "", "", 0, TipoServicio.viajeCombinado, 0, b2, v2);
		
		
		
		vc3 = new ViajeCombinado("2023-11-12", TipoServicio.viajeCombinado, v3, b3);
	
	}


	@Test
	public void testConstructorConParametrosCompleto() {
		
		assertEquals(0, vc2.getCodigo());
		assertEquals("2023-4-11", vc1.getFecha());
		assertEquals("9:15", vc1.getHoraSalida());
		assertEquals(5200, vc1.getDuracion());
		assertEquals("Madrid", vc1.getOrigen());
		assertEquals("Castellon", vc1.getDestino());
		assertEquals("Bilbao", vc1.getTrasbordo());
		assertEquals(100, vc1.getPlazasRestantes());
		assertEquals(TipoServicio.viajeCombinado, vc1.getTipoServicio());
		assertEquals(100, (int)vc1.getPrecio());
		
		//COMPROBAMOS QUE EL CODIGO DEL BUS Y VUELO ES EL MISMO, CON ESO SERIA SUFICIENTE
		assertEquals(5, vc1.getVuelo().getCodigo());
		assertEquals(002, vc1.getBus().getCodigo());
		
		
		
		//LO MISMO CON EL VUELO 2
		assertEquals(1, vc1.getCodigo());
		assertEquals("", vc2.getFecha());
		assertEquals("", vc2.getHoraSalida());
		assertEquals(0, vc2.getDuracion());
		assertEquals("", vc2.getOrigen());
		assertEquals("", vc2.getDestino());
		assertEquals("", vc2.getTrasbordo());
		assertEquals(0, vc2.getPlazasRestantes());
		assertEquals(TipoServicio.viajeCombinado, vc2.getTipoServicio());
		assertEquals(0, (int)vc2.getPrecio());
		
		//COMPROBAMOS QUE EL CODIGO DEL BUS Y VUELO ES EL MISMO, CON ESO SERIA SUFICIENTE
		assertEquals(-1, vc2.getVuelo().getCodigo());
		assertEquals(0, vc2.getBus().getCodigo());
		
		
		
		
	}
	
	

	
	@Test
	public void testConstructorConAlgunosParametros() {
		
		assertEquals(1, vc1.getCodigo());
		assertEquals("", vc2.getFecha());
		assertEquals("", vc2.getHoraSalida());
		assertEquals(0, vc2.getDuracion());
		assertEquals("", vc2.getOrigen());
		assertEquals("", vc2.getDestino());
		assertEquals("", vc2.getTrasbordo());
		assertEquals(0, vc2.getPlazasRestantes());
		assertEquals(TipoServicio.viajeCombinado, vc2.getTipoServicio());
		assertEquals(0, (int)vc2.getPrecio());
		
		//COMPROBAMOS QUE EL CODIGO DEL BUS Y VUELO ES EL MISMO, CON ESO SERIA SUFICIENTE
		assertEquals(5, vc3.getVuelo().getCodigo());
		assertEquals(000, vc3.getBus().getCodigo());
		
		
	}
	
	
	//AHORA COMPROBAMOS METDOSO GET Y SET
	
	
	
	@Test
	public void testGetVuelo() {
		
		//CON COMPROBAR EL CODIGO Y FECHA BASTARIA
		
		assertEquals(5, vc1.getVuelo().getCodigo());
		assertEquals(-1, vc2.getVuelo().getCodigo());
		assertEquals(5, vc3.getVuelo().getCodigo());
		
		
		assertEquals("2023-4-11", vc1.getVuelo().getFecha());
		assertEquals("", vc2.getVuelo().getFecha());
		assertEquals(null, vc3.getVuelo().getFecha());
		
	}
	
	
	@Test
	public void testSetVuelo() {
		
		//primero creamos dos nuevos vuelos
		
		Vuelo v4= new Vuelo(20,"2022-4-11","8:15",200,"Madrid","Bilbao",89,TipoServicio.vuelo,100,"Iberia");
		Vuelo v5= new Vuelo(200,"2021-12-31","",100,"","",0,TipoServicio.vuelo,0,"");
		
		vc1.setVuelo(v4);
		vc2.setVuelo(v5);
		
		
		//CON COMPROBAR EL CODIGO Y FECHA BASTARIA
		
		assertEquals(20, vc1.getVuelo().getCodigo());
		assertEquals(200, vc2.getVuelo().getCodigo());
	
		
		
		assertEquals("2022-4-11", vc1.getVuelo().getFecha());
		assertEquals("2021-12-31", vc2.getVuelo().getFecha());

	}
	
	
	@Test
	public void testGetBus() {
		
		//CON COMPROBAR EL CODIGO Y FECHA BASTARIA
		
		assertEquals(002, vc1.getBus().getCodigo());
		assertEquals(0, vc2.getBus().getCodigo());
		assertEquals(000, vc3.getBus().getCodigo());
		
		
		assertEquals("2023-06-23", vc1.getBus().getFecha());
		assertEquals("", vc2.getBus().getFecha());
		assertEquals(null, vc3.getBus().getFecha());
		
	}
	
	
	@Test
	public void testSetBus() {
		
		//primero creamos dos nuevos vuelos
		
		Bus b4 = new Bus(006,"2021-06-23","18:00", 4000,"Bilbao", "Madrid", 200.0,TipoServicio.bus, 50, "Alsa");
		Bus b5 = new Bus(010,"2023-05-23","17:00", 5000,"Madrid", "Castellon", 100.0,TipoServicio.bus, 100, "Alsa");
		
		vc1.setBus(b4);
		vc2.setBus(b5);
		
		
		//CON COMPROBAR EL CODIGO Y FECHA BASTARIA
		
		assertEquals(006, vc1.getBus().getCodigo());
		assertEquals(010, vc2.getBus().getCodigo());
	
		assertEquals("2021-06-23", vc1.getBus().getFecha());
		assertEquals("2023-05-23", vc2.getBus().getFecha());

	}
	
	
	@Test
	public void testGetTransbordo() {
		
		//CON COMPROBAR EL CODIGO Y FECHA BASTARIA
		
		assertEquals("Bilbao", vc1.getTrasbordo());
		assertEquals("", vc2.getTrasbordo());
		assertEquals(null, vc3.getTrasbordo());
	
		
	}
	
	@Test
	public void testSetTransbordo() {
		
		//CON COMPROBAR EL CODIGO Y FECHA BASTARIA
		
		vc1.setTrasbordo("Donosti");
		vc2.setTrasbordo("Malaga");
		vc3.setTrasbordo("Zaragoza");
		
		assertEquals("Donosti", vc1.getTrasbordo());
		assertEquals("Malaga", vc2.getTrasbordo());
		assertEquals("Zaragoza", vc3.getTrasbordo());
	
	}
	
	
	
	
	
	
	
	
	
	
	

}
