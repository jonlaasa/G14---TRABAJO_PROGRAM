package TestDatos;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Datos.Registro;
import Logica_de_Negocio.LongitudStringException;

public class TestRegistro {

	
	Registro r1;
	Registro r3;
	Registro r4;
	Registro r5;
	@Before
	public void setUp() throws Exception {
		r1 = new Registro("Iker", "Sanz", "iker_sanz");
		r3 = new Registro();
		 r4 = new Registro("Asier","Pintos", "a_Pintos");
		 r5 = new Registro ("Borja", "Castri", "bo8castri");

	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testConstructorConParametros() throws LongitudStringException {
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
	
	//HEMOS DISE�ADO  EL CODIGO DE SET NOMBRE DE MODO QUE NUNCA SE PUEDA PONER NULO, DE MODO QUE EN EL GET NUNCA TENDREMOS VALO NULO
	@Test
	public void testGetNombre() throws LongitudStringException {
		
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
	
	@Test
	public void testSetNombre() {
		r5.setNombre("Gorka");
		assertEquals("Gorka", r5.getNombre() );
		
		r5.setNombre("");
		assertEquals("", r5.getNombre() );
		
		r5.setNombre(null);
		assertEquals("", r5.getNombre() );
		
		
	}
	
	
	@Test
	public void testSetApellido() {
		r5.setApellido("Merodio");
		assertEquals("Merodio", r5.getApellido() );
		
		r5.setApellido("");
		assertEquals("", r5.getApellido() );
		
		r5.setApellido(null);
		assertEquals("", r5.getApellido() );
		
		
	}
	
	
	@Test
	public void testSetNombreUsuario() throws LongitudStringException {
		r5.setNombreUsuario("x_krl");
		assertEquals("x_krl", r5.getNombreUsuario() );
		
		r5.setNombreUsuario("");
		assertEquals("", r5.getNombreUsuario() );
		
		r5.setNombreUsuario(null);
		assertEquals("", r5.getNombreUsuario() );
		
		
	}
	
	
	
	
	

}
