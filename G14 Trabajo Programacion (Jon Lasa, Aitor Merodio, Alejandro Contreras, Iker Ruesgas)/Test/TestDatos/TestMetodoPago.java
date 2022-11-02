package TestDatos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Datos.MetodoPago;


public class TestMetodoPago {
	
	MetodoPago m1;
	MetodoPago m2;
	MetodoPago m3;
	
	@Before
	public void setUp() throws Exception {
		
		m1 = new MetodoPago(003,"1200 4678 8899 1010","Jon Lasa Ortega","08/24", 911 ,"Bilbao","calle Pio Baroja 4");
		m2 = new MetodoPago(0, null,null,null, 0, null, null);
		m3 = new MetodoPago();
	}
	

	@Test
	public void testConstructorConParametros() {
		assertEquals(003, m1.getCodigoUsuario());
		assertEquals("1200 4678 8899 1010", m1.getNumeroTarjeta());
		assertEquals("Jon Lasa Ortega", m1.getNombreCompleto());
		assertEquals("08/24", m1.getFechaCaducidad());
		assertEquals(911, m1.getCodigoSeguridad());
		assertEquals("Bilbao", m1.getCiudad());
		assertEquals("Calle Pio Baroja 4", m1.getDireccion());
		
	
		//Comprobamos constructor con null
		assertEquals(000, m3.getCodigoUsuario());
		assertEquals("0000 0000 0000 0000", m3.getNumeroTarjeta());
		assertEquals("", m3.getNombreCompleto());
		assertEquals("00/00", m3.getFechaCaducidad());
		assertEquals(000, m3.getCodigoSeguridad());
		assertEquals("", m3.getCiudad());
		assertEquals("", m3.getDireccion());
		
	}
	
	@Test
	public void testConstructorParametrosVacios() {
		assertEquals(0, m3.getCodigoUsuario());
		assertEquals("0", m3.getNumeroTarjeta());
		assertEquals("0", m3.getNombreCompleto());
		assertEquals("0", m3.getFechaCaducidad());
		assertEquals("0", m3.getCodigoSeguridad());
		assertEquals("0", m3.getCiudad());
		assertEquals("0", m3.getDireccion());
	}
	
	//Getters y setters de cada parametro
	//En los parametros origen,destino y fecha ya hemos predefinido el caso null en los constructores
	
	@Test
	public void testGetCodigoUsuario() {
		assertEquals(003, m1.getCodigoUsuario() );
		assertEquals(0,m2.getCodigoUsuario() );
	}
	
	@Test
	
	public void testSetCodigoUsuario() {
		m1.setCodigoUsuario(220);
		assertEquals(220, m1.getCodigoUsuario());
		m2.setCodigoUsuario(0);
		assertEquals(0,m1.getCodigoUsuario() );
	}
}
