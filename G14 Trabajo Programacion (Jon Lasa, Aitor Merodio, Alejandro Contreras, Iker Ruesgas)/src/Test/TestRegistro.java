package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Datos.Registro;

public class TestRegistro {

	
	Registro r1;
	Registro r3;
	Registro r4;
	@Before
	public void setUp() throws Exception {
		r1 = new Registro("Iker", "Sanz", "iker_sanz");
		r3 = new Registro();
		 r4 = new Registro("Asier","Pintos", "a_Pintos");
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testConstructorConParametros() {
		assertEquals("Iker", r1.getNombre() );
		assertEquals("Sanz", r1.getApellido() );
		assertEquals("iker_sanz", r1.getNombreUsuario() );
		
		Registro r2 = new Registro("", "", "");
		
		assertEquals("", r2.getNombre() );
		assertEquals("", r2.getApellido() );
		assertEquals("", r2.getNombreUsuario() );
	
		
	}
	
	
	@Test
	public void testConstructorSinParametros() {
		
		assertEquals("", r3.getNombre() );
		assertEquals("", r3.getApellido() );
		assertEquals("", r3.getNombreUsuario() );
		
	}
	
	//HEMOS DISEÑADO  EL CODIGO DE SET NOMBRE DE MODO QUE NUNCA SE PUEDA PONER NULO, DE MODO QUE EN EL GET NUNCA TENDREMOS VALO NULO
	@Test
	public void testGetNombre() {
		
		Registro r4 = new Registro("Asier","Pintos", "a_Pintos");
		
		assertEquals("Asier", r4.getNombre() );
		assertEquals("", r3.getNombre() );
		
		
	}
	
	
	@Test
	public void testGetApellido() {
		assertEquals("Pintos", r4.getApellido() );
		assertEquals("", r3.getApellido() );
		
		
	}
	
	
	@Test
	public void testGetNombreUsuario() {
		assertEquals("a_Pintos", r4.getNombreUsuario() );
		assertEquals("", r3.getNombreUsuario() );
		
		
	}
	
	
	

}
