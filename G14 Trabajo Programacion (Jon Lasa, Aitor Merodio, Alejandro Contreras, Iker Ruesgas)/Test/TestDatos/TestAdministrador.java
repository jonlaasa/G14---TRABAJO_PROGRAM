package TestDatos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Datos.Administrador;

public class TestAdministrador {
	
	Administrador a1;
	Administrador a2;
	Administrador a3;
	@Before
	public void setUp() throws Exception {
		
		a1= new Administrador("jon", "hernandez","administr_ador","ixr", 5);
		a2= new Administrador();
		a3= new Administrador(null,null,null,null,-1);
	}




	@Test
	public void testConstructorConParametrosCompletos() {
		assertEquals("jon",a1.getNombre());
		assertEquals("hernandez",a1.getApellido());
		assertEquals("administr_ador",a1.getNombreUsuario());
		assertEquals("ixr", a1.getContrasenya());
		assertEquals(5,a1.getCodAcceso());
		
	}
	
	@Test
	public void testConstructorSinParametros() {
		assertEquals("",a2.getNombre());
		assertEquals("",a2.getApellido());
		assertEquals("",a2.getNombreUsuario());
		assertEquals("sin contrasenya",a2.getContrasenya());
		assertEquals(000,a2.getCodAcceso());
		
	}
	
	
	@Test
	public void testConstructorConNullONovalido() {
		assertEquals(null,a3.getNombre());
		assertEquals(null,a3.getApellido());
		assertEquals(null,a3.getNombreUsuario());
		assertEquals(-1,a3.getCodAcceso());
		
		
		
	}
	
	
	//Ahora comprobaremos los get y set de clase, solo del codigoAcceso y contrasenya
	//Los demas metodos estan ya comprobados en el test de Registro
	
	@Test
	public void testGetCodigoAcceso() {
		assertEquals(5,a1.getCodAcceso());
		assertEquals(000,a2.getCodAcceso());
		assertEquals(-1,a3.getCodAcceso());
		

	}
	
	
	@Test
	public void testSetCodigoAcceso() {
		a1.setCodAcceso(22);
		assertEquals(22,a1.getCodAcceso());
		a1.setCodAcceso(0);
		assertEquals(0,a1.getCodAcceso());
		
		//No podemos poner null en un INT
		
		a1.setCodAcceso(-1);
		assertEquals(-1,a1.getCodAcceso());
		

	}
	
	@Test
	public void testGetContranseya() {
		assertEquals("ixr",a1.getContrasenya());
		assertEquals("sin contrasenya",a2.getContrasenya());
	     assertEquals(null,a3.getContrasenya());

	}
	

	@Test
	public void testSetContranseya() {
		
		a1.setContrasenya("contra1");
		assertEquals("contra1",a1.getContrasenya());
		
		a2.setContrasenya("");
		assertEquals("",a2.getContrasenya());
		
		a3.setContrasenya(null);
	     assertEquals(null,a3.getContrasenya());
		

	}
	
	
	
	
	
	
	
	
	

}
