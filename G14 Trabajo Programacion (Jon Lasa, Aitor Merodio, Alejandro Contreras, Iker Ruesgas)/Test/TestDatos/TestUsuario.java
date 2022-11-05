package TestDatos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Datos.MetodoPago;
import Datos.Registro;
import Datos.Usuario;
import Logica_de_Negocio.LongitudStringException;

public class TestUsuario {
	
	Usuario u1;
	Usuario u5;
	Usuario u6;

	@Before
	public void setUp() throws Exception {
		
		u1= new Usuario ("Alejandro", "Contreras","a_contreras" ,"ab236", "76743324J");
		u5= new Usuario("Mikel", "Ortiz","mikel" ,"erte", "76675643L");
		u6 = new Usuario();
		
		
	}


	@Test
	public void testConstructorConParametros() throws LongitudStringException {
		assertEquals("Alejandro", u1.getNombre());
		assertEquals("Contreras", u1.getApellido());
		assertEquals("a_contreras", u1.getNombreUsuario());
		assertEquals("ab236", u1.getContrasenya());
		assertEquals("76743324J", u1.getDni());
		
		//No comprobamos aqui el MetodoPago, ya que no seran iguales, por el "System.currentTimeMillis, variara por muy poco 
		
		//Comprobamos con valores vacios.
		Usuario u2 = new Usuario ("","","","", "");
		assertEquals("", u2.getNombre());
		assertEquals("", u2.getApellido());
		assertEquals("", u2.getNombreUsuario());
		assertEquals("", u2.getContrasenya());
		assertEquals("", u2.getDni());
		
		//No comprobamos aqui el MetodoPago, ya que no seran iguales, por el "System.currentTimeMillis, variara por muy poco 
		
		
		//No comprobamos con null, ya que si se da, lo sustituimos a traves del set. 
		
		
		Usuario u3 = new Usuario (null,null,null,null, null);
		assertEquals("", u3.getNombre());
		assertEquals("", u3.getApellido());
		assertEquals("", u3.getNombreUsuario());
		assertEquals("", u3.getContrasenya());
		assertEquals("", u3.getDni());
		
		
		
	}
	
	//Constructor sin parametros
	
	@Test
	public void testConstructorSinParametros() {
		Usuario u4 = new Usuario();
		assertEquals("", u4.getNombre());
		assertEquals("", u4.getApellido());
		assertEquals("", u4.getNombreUsuario());
		assertEquals("", u4.getContrasenya());
		assertEquals("", u4.getDni());
		
	}
	
	

	//HEMOS DISEÑADO  EL CODIGO DE SET NOMBRE DE MODO QUE NUNCA SE PUEDA PONER NULO, DE MODO QUE EN EL GET NUNCA TENDREMOS VALO NULO
	@Test
	public void testGetContrasenya() {
		assertEquals("erte", u5.getContrasenya() );
		assertEquals("",u6.getNombre() );
		
		
	}
	
	@Test
	
	public void testSetContrasenya() throws LongitudStringException {
		u6.setContrasenya("aaaaa");
		assertEquals("aaaaa", u6.getContrasenya());
		
		u6.setContrasenya("");
		assertEquals("",u6.getContrasenya() );
		
		u6.setContrasenya(null);
		assertEquals("",u6.getContrasenya() );
		
	}
	
	@Test
	public void testGetDni() {
		assertEquals("76675643L", u5.getDni() );
		
		assertEquals("",u6.getDni() );
		
		
	}
	
	@Test
	public void testsetDni() {
		u6.setDni("76675653H");
		assertEquals("76675653H", u6.getDni());
		
		u6.setDni("");
		assertEquals("",u6.getDni() );
		
		u6.setDni(null);
		assertEquals("",u6.getDni() );

		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	

}
