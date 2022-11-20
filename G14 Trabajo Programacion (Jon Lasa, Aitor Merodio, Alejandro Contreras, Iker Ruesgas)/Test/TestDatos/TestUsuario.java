package TestDatos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Datos.MetodoPago;
import Datos.Registro;
import Datos.Usuario;
import logicaDeNegocio.LongitudStringException;

public class TestUsuario {
	
	Usuario u1;
	Usuario u5;
	Usuario u6;
	Usuario u10= new Usuario(null,null,null,null, null, null);

	
	
	//LA GESTION DE EMAIL, DNI ETC CORRECTOS, LOS HAREMOS EN LA VENTANA DONDE SE METARAN LOS VALORES, POR LO TANTO,
	//AQUI NO HAREMOS DICHA COMPROBACIÓN.
	@Before
	public void setUp()  {
		
		u1= new Usuario ("Alejandro", "Contreras","a_contreras" ,"ab236","jon@hotmail.es", "76743324J");
		u5= new Usuario("Mikel", "Ortiz","mikel" ,"erte","mikel78@gmail.es", "76675643L");
		u6 = new Usuario();
		
		
	}


	@Test
	public void testConstructorConParametros() {
		assertEquals("Alejandro", u1.getNombre());
		assertEquals("Contreras", u1.getApellido());
		assertEquals("a_contreras", u1.getNombreUsuario());
		assertEquals("ab236", u1.getContrasenya());
		assertEquals("jon@hotmail.es", u1.getCorreoElectronico());
		
		assertEquals("76743324J", u1.getDni());
		
		//No comprobamos aqui el MetodoPago, ya que no seran iguales, por el "System.currentTimeMillis, variara por muy poco 
		
		//Comprobamos con valores vacios.
		Usuario u2 = new Usuario ("","","","", "","");
		assertEquals("", u2.getNombre());
		assertEquals("", u2.getApellido());
		assertEquals("", u2.getNombreUsuario());
		assertEquals("", u2.getContrasenya());
		assertEquals("", u2.getCorreoElectronico());	
		assertEquals("", u2.getDni());
		
		
		
		
		
		//Comprobamos con null. 
		
		
		Usuario u3 = new Usuario (null,null,null,null, null, null);
		assertEquals(null, u3.getNombre());
		assertEquals(null, u3.getApellido());
		assertEquals(null, u3.getNombreUsuario());
		assertEquals(null, u3.getContrasenya());
		assertEquals(null, u3.getCorreoElectronico());
		assertEquals(null, u3.getDni());
		
		
		
	}
	
	//Constructor sin parametros
	
	@Test
	public void testConstructorSinParametros() {
		Usuario u4 = new Usuario();
		assertEquals("", u4.getNombre());
		assertEquals("", u4.getApellido());
		assertEquals("", u4.getNombreUsuario());
		assertEquals("", u4.getContrasenya());
		assertEquals("", u4.getCorreoElectronico());
		assertEquals("", u4.getDni());
		
	}
	
	

	//LA COMPROBACION PARA ESCRIBIR LA HAREMOS CON LOS METODOS DE UTLS, 
	//POR ELLO LOS METODOS GET Y SET SEGUIRAN EL FUNCIONAMIENTO HABITUAL
	
	
	//LOS METODOS DE GET NOMBRE USUARIO... ESTAN EN EL TEST DE REGISTRO
	@Test
	public void testGetContrasenya() {
		assertEquals("erte", u5.getContrasenya() );
		assertEquals("",u6.getContrasenya() );
		assertEquals(null,u10.getContrasenya() );
		
		
		
	}
	
	@Test
	
	public void testSetContrasenya() {
		u6.setContrasenya("aaaaa");
		assertEquals("aaaaa", u6.getContrasenya());
		
		u6.setContrasenya("");
		assertEquals("",u6.getContrasenya() );
		
		u6.setContrasenya(null);
		assertEquals(null,u6.getContrasenya() );
		
		
		
	}
	
	@Test
	public void testGetDni() {
		assertEquals("76675643L", u5.getDni() );
		assertEquals("",u6.getDni() );
		assertEquals(null,u10.getDni() );
		
		
	}
	
	@Test
	public void testsetDni() {
		u6.setDni("76675653H");
		assertEquals("76675653H", u6.getDni());
		
		u6.setDni("");
		assertEquals("",u6.getDni() );
		
		u6.setDni(null);
		assertEquals(null,u6.getDni() );

		
	}
	
	
	
	@Test
	public void testGetCorreoElectronico() {
		assertEquals("mikel78@gmail.es", u5.getCorreoElectronico() );
		assertEquals("",u6.getCorreoElectronico() );
		assertEquals(null,u10.getCorreoElectronico() );
		
		
		
	}
	
	@Test
	public void testsetCorreoElectronico() {
		u6.setCorreoElectronico("mikeltxo@opendeusto.eus");
		assertEquals("mikeltxo@opendeusto.eus", u6.getCorreoElectronico());
		
		u6.setCorreoElectronico("");
		assertEquals("",u6.getCorreoElectronico() );
		
		u6.setCorreoElectronico(null);
		assertEquals(null,u6.getCorreoElectronico() );

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
