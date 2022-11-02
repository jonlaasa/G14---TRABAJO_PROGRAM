package TestDatos;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import Datos.Servicio;
import Enum.TipoServicio;
import Logica_de_Negocio.FechaException;
import Logica_de_Negocio.PlazasRestantesException;
import Logica_de_Negocio.PrecioException;

public class TestServicio {

	Servicio s1;
	Servicio s2;
	Servicio s3;
	Servicio s4;
	Servicio s5;
	Servicio s6;
	TipoServicio tiposervicio;

	@Before
	public void setUp() throws Exception {
		
		s1 = new Servicio(001, "2023/05/02",6300,"Bilbao", "Barcelona", 50 , TipoServicio.vuelo ,96);
		s2 = new Servicio(932, "2022/11/10",3000,"Santander", "Valencia", 45, TipoServicio.bus, 45);
		s3 = new Servicio("2024/08/30",TipoServicio.viajeCombinado);
		s4 = new Servicio();
		s5 = new Servicio(0, "",0,"","",0,TipoServicio.bus,0);
		s6 = new Servicio(0,null,0,null,null,0,TipoServicio.bus,0);
	}
	

	@Test
	public void testConstructorConParametros() {
		assertEquals(001, s1.getCodigo());
		assertEquals("2023/05/02", s1.getFecha());
		assertEquals(6300, s1.getDuracion());
		assertEquals("Bilbao", s1.getOrigen());
		assertEquals("Barcelona", s1.getDestino());
		assertEquals(50, s1.getPrecio());
		assertEquals(TipoServicio.vuelo, s1.getTipoServicio());
		assertEquals(96, s1.getPlazasRestantes());
		
		
		//Comprobamos con valores vacios.
		assertEquals(0, s5.getCodigo());
		assertEquals("", s5.getFecha());
		assertEquals(0, s5.getDuracion());
		assertEquals("", s5.getOrigen());
		assertEquals("", s5.getDestino());
		assertEquals(0, s5.getPrecio());
		assertEquals(TipoServicio.bus, s5.getTipoServicio());
		assertEquals(0, s5.getPlazasRestantes());
	
		//Comprobamos con null
		assertEquals(0, s6.getCodigo());
		assertEquals(null, s6.getFecha());
		assertEquals(0, s6.getDuracion());
		assertEquals(null, s6.getOrigen());
		assertEquals(null, s6.getDestino());
		assertEquals(0, s6.getPrecio());
		assertEquals(TipoServicio.bus, s6.getTipoServicio());
		assertEquals(0, s6.getPlazasRestantes());

		
	}
	
	@Test
	public void testConstructorFechaTipoServicio() {
		assertEquals("2024/08/30", s3.getFecha());
		assertEquals(TipoServicio.viajeCombinado, s3.getTipoServicio());
	}
	
	//Constructor sin parametros
//	@Test
//	public void testConstructorSinParametros() {
//
//		assertEquals("", s6.getCodigo());
//		assertEquals("", s6.getFecha());
//		assertEquals("", s6.getDuracion());
//		assertEquals("", s6.getOrigen());
//		assertEquals("", s6.getDestino());
//		assertEquals("", s6.getPrecio());
//		assertEquals("", s6.getTipoServicio());
//		assertEquals("", s6.getPlazarRestantes());
//	}
	
	//Getters y setters de cada parametro
	//En los parametros origen,destino y fecha ya hemos predefinido el caso null en los constructores
	
	@Test
	public void testGetCodigo() {
		assertEquals(001, s1.getCodigo() );
		assertEquals(0,s5.getCodigo() );
	}
	
	@Test
	
	public void testSetCodigo() {
		s1.setCodigo(04637);
		assertEquals(04637, s1.getCodigo());
		s1.setCodigo(0);
		assertEquals(0,s1.getCodigo() );
	}
	
	@Test
	public void testGetFecha() {
		assertEquals("2023/05/02", s1.getFecha() );
		assertEquals("",s5.getFecha() );
	}
	
	@Test
	
	public void testSetFecha() {
		
		try {
			s1.setFecha("2040/03/20");
			assertEquals("2040/03/20", s1.getFecha());
		} catch (FechaException | ParseException e1) {
			e1.printStackTrace();
		}
		
		try {
			s1.setFecha("");		
			assertEquals("",s1.getFecha() );
		} catch (FechaException | ParseException e) {
			e.printStackTrace();
		}

		try {
			s1.setFecha(null);
			assertEquals("",s1.getFecha() );
		} catch (FechaException | ParseException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testGetOrigenDestino() {
		assertEquals("Bilbao", s1.getOrigen() );
		assertEquals("Barcelona", s1.getDestino() );
		assertEquals("", s5.getDestino() );
		assertEquals("",s5.getOrigen() );
		assertEquals(null, s6.getDestino() );
		assertEquals(null,s6.getOrigen() );
	}
	
	@Test
	
	public void testSetOrigenDestino() {
		s1.setOrigen("Madrid");
		s1.setDestino("Malaga");
		assertEquals("Madrid", s1.getOrigen());
		assertEquals("Malaga", s1.getDestino());
		
		s1.setOrigen("");
		s1.setDestino("");
		assertEquals("", s1.getOrigen());
		assertEquals("", s1.getDestino());
		
		s1.setOrigen(null);
		s1.setDestino(null);
		assertEquals("", s1.getOrigen());
		assertEquals("", s1.getDestino());
	}

	public void testGetPrecio() {
		assertEquals(50, s1.getPrecio() );
		assertEquals(0, s5.getPrecio() );

	}
	
	public void testSetprecio() throws PrecioException {
		s1.setPrecio(46);
		assertEquals(46, s1.getPrecio());
		
		s1.setPrecio(0);
		assertEquals(0, s1.getPrecio());
	}
	
	@Test
	
	public void testSetPlazasRestantes() throws PlazasRestantesException {
		s1.setPlazasRestantes(88);
		assertEquals(88, s1.getPlazasRestantes());
		s1.setPlazasRestantes(0);
		assertEquals(0,s1.getPlazasRestantes() );
	}
	
	@Test
	public void testGetPlazasRestantes() {
		assertEquals(96, s1.getPlazasRestantes() );
		assertEquals(0,s5.getPlazasRestantes());
	}
	//Funciones
	@Test
	public void testGetDuracionString() throws Exception {
		s4.setDuracion(2700);
		assertEquals("45 minutos",s4.getDuracionString());
		s4.setDuracion(3600);
		assertEquals("1 hora",s4.getDuracionString());
		s4.setDuracion(3660);
		assertEquals("1 hora, 1 minuto",s4.getDuracionString());
		s4.setDuracion(6300);
		assertEquals("1 hora, 45 minutos",s4.getDuracionString());
		s4.setDuracion(10800+1200);
		assertEquals("3 horas, 20 minutos",s4.getDuracionString());
		s4.setDuracion(3600*25);
		assertEquals("25 horas",s4.getDuracionString());
		s4.setDuracion(3600*4+60);
		assertEquals("4 horas, 1 minuto",s4.getDuracionString());
	}
	
	

}
