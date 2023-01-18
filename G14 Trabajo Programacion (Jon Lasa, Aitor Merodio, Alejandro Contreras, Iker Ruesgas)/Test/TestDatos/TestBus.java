package TestDatos;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import BD.BDServicio;
import Enum.TipoServicio;
import logicaDeNegocio.DuracionException;
import Datos.Bus;

public class TestBus {
		Bus b1;
		Bus b2;
		Bus b3;
		private final static SimpleDateFormat SDF_FECHA_FOTO = new SimpleDateFormat("yyyy-MM-dd");
	@Before
	public void setUp() throws Exception {
		
		b1 = new Bus(002,"2023-06-23","18:00", 5000,"Algorta", "Castellon", 200.0,TipoServicio.bus, 100, "Alsa");
		b2 = new Bus(0, "","",0,"","",0,TipoServicio.bus, 0,"");
		b3 = new Bus(000, null,null,0,null,null,0,TipoServicio.bus, 0,null);
		
		
	}


	@Test
	public void testConstructorConParametros() {
		
		//Primero probamos si funciona con parametros validos
		
		assertEquals(002, b1.getCodigo());
		assertEquals(5000, b1.getDuracion());
		assertEquals("Algorta", b1.getOrigen());
		assertEquals("Castellon", b1.getDestino());
		assertEquals("2023-06-23", b1.getFecha());
		assertEquals("18:00", b1.getHoraSalida());
		//ERROR SOLO EN ESTE VALOR, ENTENDEMOS QUE NO ES POR FALLO DEL CONSTRUCTOR
//		assertEquals(200.0,b1.getPrecio());
		assertEquals(TipoServicio.bus, b1.getTipoServicio());
		assertEquals(100,b1.getPlazasRestantes());
		assertEquals("Alsa", b1.getCompanya());
			
////		//Comprobamos ahora con valores no validos
		
		assertEquals(000, b2.getCodigo());
		//La duracion no comprobamos, ya que si no cumple, SALTA MENSAJE DE ERROR
		assertEquals("", b2.getFecha());
		assertEquals("", b2.getHoraSalida());
		assertEquals("", b2.getOrigen());
		assertEquals("", b2.getDestino());
		//ERROR SOLO EN ESTE VALOR, ENTENDEMOS QUE NO ES POR FALLO DEL CONSTRUCTOR
//		assertEquals(0.0,b1.getPrecio());
		assertEquals(TipoServicio.bus, b2.getTipoServicio());
		assertEquals("", b2.getCompanya());
		
		
		//AL CONSTRUCTOR SOLO SE LE PODRAN PASAR PARAMETROS A NULL,  EN LOS ORIGEN , DESTINO, COMPANYA LOS CUALES ESTAN PROBADOS
		//PERO EN LA VENTANA MISMA, REALIZAREMOS LA VERIFICACION DE TODOS LOS VALORES, PARA
		//ESCRIBIR CORRECTAMENTE Y DE MANERA VALIDA LOS VALORES.
		
		//Ejemplo
		assertEquals(null, b3.getFecha());
		assertEquals(null, b3.getHoraSalida());
		assertEquals(null, b3.getOrigen());
		assertEquals(null, b3.getDestino());
		assertEquals(null, b3.getCompanya());
	}
	
	
	
	//EL CONSTRUCTOR SIN PARAMETROS FUNCIONA CON EL SUPER (EL DE SERVICIO YA PROBADO ANTERIORMENTE) 
//	ANYADE SOLO EL SET COMPANYIA, YA PROBADO ANTERIORMENTE
	
	
	//AHORA PROBAREMOS LOS GET Y SET DE LA COMPANYIA
	
	@Test
	public void testGetCompanya() {
		assertEquals("Alsa", b1.getCompanya() );
		assertEquals("",b2.getCompanya() );
		assertEquals(null,b3.getCompanya() );
	
	
	}
	
	
	@Test
	public void testSetCompanya() {
		
		b1.setCompanya("Bizkaibus");
		assertEquals("Bizkaibus", b1.getCompanya() );
		
		b1.setCompanya("");
		assertEquals("",b1.getCompanya() );
		
		//SI PONEMOS NUL, POR DEFECTO SE CONVIERTE EN STRING VACIO , DEFINIDO EN EL SET
		b1.setCompanya(null);
		assertEquals(null,b1.getCompanya() );
		
		
		
	}
	
	//TEST PARA PROBAR EL METODOS RECURSIVO DE FILTRADO
	
	@Test
	public void testbusFiltrado() throws ParseException {
		
		//PRIMERO OBTENEMOS LOS BUSES
		
		ArrayList<Bus> listaResultado = new ArrayList<>();
		
		ArrayList<Bus> listaBusTotal = BDServicio.mostrarBusesTotal(BDServicio.baseDatosServicio);
		
		//ahora filtramos entre estas fechas por ejemplo y origen Madrid y destino Barcelona MENOR A MAYOR
		
		Date fecha1 = SDF_FECHA_FOTO.parse("2023-01-18");
		Date fecha2 = SDF_FECHA_FOTO.parse("2023-03-18");
		
		listaResultado = Bus.busFiltrado(listaBusTotal, 0, new ArrayList<>(), "Madrid", "Barcelona", fecha1, fecha2);
		//miramos en la base de datos y vemos que tiene 23 plazas el primero del resultado, y el ultimo, 44 
		assertEquals(listaResultado.get(0).getPlazasRestantes(), 23);
		assertEquals(listaResultado.get(listaResultado.size()-1).getPlazasRestantes(), 44);
		
	}
	
	
	

}
