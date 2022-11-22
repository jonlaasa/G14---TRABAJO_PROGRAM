package TestBD;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import BD.BD;
import Datos.Usuario;
import logicaDeNegocio.LongitudStringException;

public class TestBD {

	@Before
	public void setUp() throws Exception {
		
		BD.abrirBaseDatos("baseDatos");
	}

	@After
	public void tearDown() throws Exception {
		BD.cerrarConexion();
	}

//	@Test
//	public void test() throws Exception {
//		BD bd = new BD();
//		Usuario usr = new Usuario();
//		assertTrue(bd.registrar(usr));
//		
//	}
	
	
	
	

}
