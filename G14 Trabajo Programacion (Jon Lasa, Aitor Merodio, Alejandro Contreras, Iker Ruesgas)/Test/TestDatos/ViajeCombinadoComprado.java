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

public class ViajeCombinadoComprado {
	
	Datos.ViajeCombinadoComprado vcc1;
	Datos.ViajeCombinadoComprado vcc2;
	Datos.ViajeCombinadoComprado vcc3;
	

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
		//INICIALIZAMOS PARA REALIZAR LAS PRUEBAS
		

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
		
		
		
		
		//creamos los VIAJES COMBINADOS COMPRADOS
		
		vcc1 = new Datos.ViajeCombinadoComprado(4, 6, "2023-01-01", TipoServicio.viajeCombinado, 20, vc1);
		vcc2 = new Datos.ViajeCombinadoComprado(1, 9, "2023-03-03", TipoServicio.viajeCombinado, 10, vc2);
		vcc3 = new Datos.ViajeCombinadoComprado(1, 7, "2023-02-02", TipoServicio.viajeCombinado, 1, vc3);
		
	
	}
	@Test
	public void testConstructorConArgumentos() {
		
		assertEquals(4, vcc1.getCodigoUsuario());
		assertEquals(6, vcc1.getCantidad());
		assertEquals("2023-01-01", vcc1.getFechaCompra());
		assertEquals(TipoServicio.viajeCombinado, vcc1.getTipoServicio());
		assertEquals(20, vcc1.getCodigoCompra());
		
		//COMPROBAMOS EL CODIGO DEL VIAJE COMBINADO, CON ESO BASTARIA
		
		assertEquals(1, vcc1.getViajeCombinado().getCodigo());
		
		
		assertEquals(1, vcc2.getCodigoUsuario());
		assertEquals(9, vcc2.getCantidad());
		assertEquals("2023-03-03", vcc2.getFechaCompra());
		assertEquals(TipoServicio.viajeCombinado, vcc2.getTipoServicio());
		assertEquals(10, vcc2.getCodigoCompra());
		
		//COMPROBAMOS EL CODIGO DEL VIAJE COMBINADO, CON ESO BASTARIA
		
		assertEquals(0, vcc2.getViajeCombinado().getCodigo());
		
		
		
		assertEquals(1, vcc3.getCodigoUsuario());
		assertEquals(7, vcc3.getCantidad());
		assertEquals("2023-02-02", vcc3.getFechaCompra());
		assertEquals(TipoServicio.viajeCombinado, vcc3.getTipoServicio());
		assertEquals(1, vcc3.getCodigoCompra());
		
		//COMPROBAMOS EL CODIGO DEL VIAJE COMBINADO, CON ESO BASTARIA
		
		assertEquals(0, vcc3.getViajeCombinado().getCodigo());

	}
	
	
	
	//AHORA COMPROBAMOS LOS METODOS GET Y SET
	
	@Test
	public void testGetViajeCombinado() {
		
		
		//para ello de cada uno comprobamos la fecha y hora de salida que sea correcta como prueba
		
		// vc1 = "2023-4-11", "9:15"
		assertEquals("2023-4-11",vcc1.getViajeCombinado().getFecha());
		assertEquals("9:15",vcc1.getViajeCombinado().getHoraSalida());
		// vc2 = "", ""
		assertEquals("",vcc2.getViajeCombinado().getFecha());
		assertEquals("",vcc2.getViajeCombinado().getHoraSalida());
		
		
		//vc3 = "2023-11-12", ""
		
		
		assertEquals("2023-11-12",vcc3.getViajeCombinado().getFecha());
		assertEquals("",vcc3.getViajeCombinado().getHoraSalida());

	}
	
	
	@Test
	public void testSetViajeCombinado() {
		
		
		//para ello de cada uno comprobamos la fecha y hora de salida que sea correcta como prueba
		ViajeCombinado vc4 = new ViajeCombinado(1, "2022-5-11", "8:15", 5200, "Madrid", "Castellon", "Bilbao",
				100, TipoServicio.viajeCombinado, 100, b1, v1);

		ViajeCombinado vc5  = new ViajeCombinado(0, "2021-8-21", "22:00", 0, "", "", "", 0, TipoServicio.viajeCombinado, 0, b2, v2);
		
		
		vcc1.setViajeCombinado(vc4);
		
		// vc4 =  "2022-5-11", "8:15"
		assertEquals("2022-5-11",vcc1.getViajeCombinado().getFecha());
		assertEquals("8:15",vcc1.getViajeCombinado().getHoraSalida());
		
		vcc1.setViajeCombinado(vc5);
		
		
		
		// vc5  = "2021-8-21", "22:00"
		assertEquals("2021-8-21",vcc1.getViajeCombinado().getFecha());
		assertEquals( "22:00",vcc1.getViajeCombinado().getHoraSalida());
		
		
	}
	
	
	
	@Test
	public void testGetPrecio() {
		
		
		//el precio del primer viaje combinado comprado seria el (precio del bus + precio del vuelo ) * cantidad
		//el primero = (89 + 200) * 6 = 1734
		
		assertEquals(1734, (int)vcc1.getPrecio());
		
		
		// en el caso del segundo = (0+0) * 9 =0
		
		
		assertEquals(0, (int)vcc2.getPrecio());
		
	}
	
	
	@Test
	public void testSetPrecio() {
		//PRIMERO MODIFICAMOS POR EJEMPLO EL VUELO DE UN VIAJE COMBINADO
		
		Vuelo v5= new Vuelo(5,"2023-4-11","9:15",200,"Madrid","Bilbao",100,TipoServicio.vuelo,100,"Ryanair");
		
		vc1.setVuelo(v5);
		
		vcc1.setViajeCombinado(vc1);
		
		//PONEMOS NUEVO PRECIO
		
		vcc1.setPrecio();
		
		
		//el precio del primer viaje combinado comprado ahora seria 
		//el primero = (100 + 200) * 6 = 1800
		
		assertEquals(1800, (int)vcc1.getPrecio());
		
		
		//AHORA POR EJEMPLO MODIFICAMOS EL precio del  BUS 
		
		Bus b5 = new Bus(002,"2023-06-23","18:00", 5000,"Bilbao", "Castellon", 100.0,TipoServicio.bus, 100, "Alsa");
		
		vc2.setBus(b5);
		
		vcc2.setViajeCombinado(vc2);
		
		vcc2.setPrecio();
		
		// en el caso del segundo = (0+100) * 9 =900
		
		
		assertEquals(900, (int)vcc2.getPrecio());
		
		
		
		
		//finalmente comprobaremos modificando la cantidad
		
		
		vcc1.setCantidad(3);
		
		vcc1.setPrecio();
		
		//por tanto ahora el precio seria 300*3 = 900
		
		
		assertEquals(900, (int)vcc1.getPrecio());
		
	}
	
	
	
	

}
