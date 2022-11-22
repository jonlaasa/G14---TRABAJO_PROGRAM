package TestDatos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Datos.MetodoPago;


public class TestMetodoPago {
	
	MetodoPago m1;
	MetodoPago m2;
	MetodoPago m3;
	long ahora= System.currentTimeMillis();
	
	@Before
	public void setUp() throws Exception {
		
		m1 = new MetodoPago(003,"1200 4678 8899 1010","Jon Lasa Ortega",ahora, 911 ,"Bilbao","calle Pio Baroja 4");
		m2 = new MetodoPago(0, null,null,0, 0,null, null);
		m3 = new MetodoPago();
	}
	

	@Test
	public void testConstructorConParametros() {
		assertEquals(003, m1.getCodigoUsuario());
		assertEquals("1200 4678 8899 1010", m1.getNumeroTarjeta());
		assertEquals("Jon Lasa Ortega", m1.getNombreCompleto());
		assertEquals(ahora, m1.getFechaCaducidad());
		assertEquals(911, m1.getCodigoSeguridad());
		assertEquals("Bilbao", m1.getCiudad());
		assertEquals("calle Pio Baroja 4", m1.getDireccion());
		
	
		//Comprobamos constructor con null
		assertEquals(0, m2.getCodigoUsuario());
		assertEquals(null, m2.getNumeroTarjeta());
		assertEquals(null, m2.getNombreCompleto());
		assertEquals(0, m2.getFechaCaducidad());
		assertEquals(0, m2.getCodigoSeguridad());
		assertEquals(null, m2.getCiudad());
		assertEquals(null, m2.getDireccion());
		
	}
	
	@Test
	public void testConstructorParametrosVacios() {
		assertEquals(0000, m3.getCodigoUsuario());
		assertEquals("0000 0000 0000 0000", m3.getNumeroTarjeta());
		assertEquals("", m3.getNombreCompleto());
		assertEquals(0, m3.getFechaCaducidad());
		assertEquals(000, m3.getCodigoSeguridad());
		assertEquals("", m3.getCiudad());
		assertEquals("", m3.getDireccion());
	}
	
	//Getters y setters de cada parametro
	
	
	
	@Test
	public void testGetCodigoUsuario() {
		assertEquals(003, m1.getCodigoUsuario() );
		assertEquals(0,m2.getCodigoUsuario() );
		assertEquals(0000,m3.getCodigoUsuario() );
		
	}
	
	@Test
	
	public void testSetCodigoUsuario() {
		m1.setCodigoUsuario(220);
		assertEquals(220, m1.getCodigoUsuario());
		m2.setCodigoUsuario(0);
		assertEquals(0,m2.getCodigoUsuario() );
		
	}
	
	@Test
	public void testGetNumeroTarjeta() {
		assertEquals("1200 4678 8899 1010", m1.getNumeroTarjeta() );
		assertEquals(null,m2.getNumeroTarjeta() );
		assertEquals("0000 0000 0000 0000",m3.getNumeroTarjeta() );
		
	}
	
	
	@Test
	public void testSetNumeroTarjeta () {
		m1.setNumeroTarjeta("1201 4678 8899 1010");
		assertEquals("1201 4678 8899 1010", m1.getNumeroTarjeta());
		m2.setNumeroTarjeta("");
		assertEquals("0000 0000 0000 0000",m3.getNumeroTarjeta() );
		m2.setNumeroTarjeta(null);
		assertEquals(null,m2.getNumeroTarjeta() );
		
		
	}
	
	
	
	
	@Test
	public void testGetNombreCompleto() {
		assertEquals("Jon Lasa Ortega", m1.getNombreCompleto() );
		assertEquals(null,m2.getNombreCompleto() );
		assertEquals("",m3.getNombreCompleto() );
		
	}
	
	
	@Test
	public void testSetNombreCompleto () {
		m1.setNombreCompleto("Iker Ruesgas Escalante");
		assertEquals("Iker Ruesgas Escalante", m1.getNombreCompleto());
		m2.setNombreCompleto("");
		assertEquals("",m2.getNombreCompleto() );
		m2.setNombreCompleto(null);
		assertEquals(null,m2.getNombreCompleto() );
		
	}
	
	
	
	@Test
	public void testGetFechaCaducidad () {
		assertEquals(ahora, m1.getFechaCaducidad() );
		assertEquals(0,m2.getFechaCaducidad() );
		
		
	}
	
	
	@Test
	public void testSetFechaCaducidad () {
		m1.setFechaCaducidad(1788589);
		assertEquals(1788589, m1.getFechaCaducidad());
		m2.setFechaCaducidad(0);
		assertEquals(0,m2.getFechaCaducidad() );
		
	}
	
	
	
	
	@Test
	public void testGetCodigoSeguridad () {
		assertEquals(911, m1.getCodigoSeguridad() );
		assertEquals(0,m2.getCodigoSeguridad() );
		
		
	}
	
	
	@Test
	public void testSetCodigoSeguridad () {
		m1.setCodigoSeguridad(234);
		assertEquals(234, m1.getCodigoSeguridad());
		m2.setCodigoSeguridad(0);
		assertEquals(0,m2.getCodigoSeguridad() );
		
	}
	
	

	@Test
	public void testGetCiudad () {
		assertEquals("Bilbao", m1.getCiudad() );
		assertEquals(null,m2.getCiudad() );
		assertEquals("",m3.getCiudad() );
		
		
	}
	
	
	@Test
	public void testSetCiudad() {
		m1.setCiudad("La Rioja");
		assertEquals("La Rioja", m1.getCiudad());
		m2.setCiudad("");
		assertEquals("",m2.getCiudad() );
		m2.setCiudad(null);
		assertEquals(null,m2.getCiudad() );
		
		
	}
	
	
	@Test
	public void testGetDireccion () {
		assertEquals("calle Pio Baroja 4", m1.getDireccion() );
		assertEquals(null,m2.getDireccion() );
		assertEquals("",m3.getDireccion() );
		
		
	}
	
	
	@Test
	public void testSetDireccion() {
		m1.setDireccion("Satistegi 4");
		assertEquals("Satistegi 4", m1.getDireccion());
		m2.setDireccion("");
		assertEquals("",m2.getDireccion() );
		m2.setDireccion(null);
		assertEquals(null,m2.getDireccion() );
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
