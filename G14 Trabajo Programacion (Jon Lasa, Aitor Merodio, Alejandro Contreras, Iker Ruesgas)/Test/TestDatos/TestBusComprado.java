package TestDatos;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Datos.Bus;
import Datos.BusComprado;
import Datos.Compra;
import Enum.TipoServicio;

public class TestBusComprado {
	
	BusComprado bc1;
	BusComprado bc2;

	@Before
	public void setUp() throws Exception {
		bc1 = new BusComprado(005, 20, "2022-11-12",222, TipoServicio.bus, new Bus(1,"2022-12-11","18:00", 0,"Algorta","Muskiz", 30, TipoServicio.bus,
				30,"Alsa") );
		bc2 = new BusComprado(000, 0, "2",0, TipoServicio.bus, new Bus("",TipoServicio.bus) );
		
		
		
		
	}


	@Test
	public void testConstructorBusCompradoConArgumentosNormales() {
		//SOLO ES NECESARIO COMPROBAR LOS ATRIBUTOS DE BUS Y PRECIO, LOS DEMAS, EN EL TEST DE COMPRA
		Bus bcb1 = bc1.getBus();
		assertEquals(1, bcb1.getCodigo());
		assertEquals("2022-12-11", bcb1.getFecha());
		assertEquals("18:00", bcb1.getHoraSalida());
		assertEquals(0, bcb1.getDuracion());
		assertEquals("Algorta", bcb1.getOrigen());
		assertEquals("Muskiz", bcb1.getDestino());
		assertEquals(30,(int)bcb1.getPrecio());
		assertEquals(TipoServicio.bus, bcb1.getTipoServicio());
		assertEquals(30,bcb1.getPlazasRestantes());
		assertEquals("Alsa", bcb1.getCompanya());
	}
	

	@Test
	public void testConstructorBusCompradoConArgumentosEspeciales() {
		//SOLO ES NECESARIO COMPROBAR LOS ATRIBUTOS DE BUS Y PRECIO, LOS DEMAS, EN EL TEST DE COMPRA
		Bus bcb2 = bc2.getBus();
		assertEquals(0, bcb2.getCodigo());
		assertEquals("", bcb2.getFecha());
		assertEquals("", bcb2.getHoraSalida());
		assertEquals(0, bcb2.getDuracion());
		assertEquals("", bcb2.getOrigen());
		assertEquals("", bcb2.getDestino());
		assertEquals(0,(int)bcb2.getPrecio());
		assertEquals(TipoServicio.bus, bcb2.getTipoServicio());
		assertEquals(100,bcb2.getPlazasRestantes());
		assertEquals("Sin companya", bcb2.getCompanya());
	}
	
	
	//AHORA SOLO NOS INTERESA COMPROBAR QUE FUNCIONA EL METODO DE SET Y GET PRECIO
	
	@Test
	public void testGetPrecio() {
		//EL PRECIO DEL PRMER BUS SERIA: 600 (20*30)
		assertEquals(600, (int)bc1.getPrecio());
		
		//EL DEL SEGUNDO 0, YA QUE SU CANTIDAD ES 0 
		assertEquals(0, (int)bc2.getPrecio());
		
		
	}
	
	@Test
	public void testSetPrecio() {
		//EL PRECIO DEL PRMER BUS CON CANTIDAD 10 SERIA 300
		bc1.setCantidad(10);
		bc1.setPrecio();
		assertEquals(300, (int)bc1.getPrecio());
		
		
		
	}
	
	
	
	
	
	
	

}
