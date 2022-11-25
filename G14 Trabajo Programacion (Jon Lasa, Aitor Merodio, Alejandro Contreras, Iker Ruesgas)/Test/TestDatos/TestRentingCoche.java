package TestDatos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Datos.RentingCoche;
import Enum.ClaseCoche;

public class TestRentingCoche {

	RentingCoche rc1;
	RentingCoche rc2;
	

	@Before
	public void setUp() throws Exception {
		rc1 = new RentingCoche(3,ClaseCoche.gamaBaja);
		rc2= new RentingCoche();
	}
	

	
	@Test
	public void testConstructorConParametros() {
		assertEquals(60, (int)rc1.getPrecio());
		assertEquals(3, rc1.getDiasAlquilado());
		assertEquals(ClaseCoche.gamaBaja, rc1.getClaseCoche());
	}
	
	@Test
	public void testConstructorSinParametros() {
		assertEquals(0, (int)rc2.getPrecio());
		assertEquals(0, rc2.getDiasAlquilado());
		assertEquals(ClaseCoche.gamaBaja, rc2.getClaseCoche());
	}
	
	
	//Metodos get y set
	
	
	@Test
	public void testGetPrecio() {
		assertEquals(60, (int)rc1.getPrecio());
		assertEquals(0, (int)rc2.getPrecio());
		
	}
	@Test
	public void testSetPrecio() {
		
		//Le cambiamos el numero de dias a 4
		rc1.setDiasAlquilado(4);
		rc1.setPrecio();
		assertEquals(80, (int)rc1.getPrecio());
		
		rc1.setDiasAlquilado(0);
		rc1.setPrecio();
		assertEquals(0, (int)rc1.getPrecio());
	
	}
	
	@Test
	public void testGetDiasAlquilado() {
		assertEquals(3, rc1.getDiasAlquilado());
		assertEquals(0, (int)rc2.getDiasAlquilado());
		
	}
	
	@Test
	public void testSetDiasAlquilado() {
		rc1.setDiasAlquilado(4);
		
		assertEquals(4, rc1.getDiasAlquilado());
		
		rc1.setDiasAlquilado(0);
		
		assertEquals(0, (int)rc1.getDiasAlquilado());
		
	}
	
	@Test
	public void testGetClaseCoche() {
		assertEquals(ClaseCoche.gamaBaja, rc1.getClaseCoche());
		assertEquals(ClaseCoche.gamaBaja, rc2.getClaseCoche());
		
	}
	
	public void testSetClaseCoche() {
		rc1.setClaseCoche(ClaseCoche.gamaMedia);
		assertEquals(ClaseCoche.gamaMedia, rc1.getClaseCoche());
		
		rc1.setClaseCoche(ClaseCoche.gamaAlta);
		assertEquals(ClaseCoche.gamaAlta, rc1.getClaseCoche());
		
	}
	
	
	
	
	
	
	
	
	
	

}
