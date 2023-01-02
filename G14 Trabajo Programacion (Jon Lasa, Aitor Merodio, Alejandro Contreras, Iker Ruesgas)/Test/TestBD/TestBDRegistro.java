package TestBD;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import BD.BDRegistro;
import BD.BDServicio;
import Datos.Administrador;
import Datos.Usuario;

public class TestBDRegistro {
	
	@Test
	public void testInicializarYCerrarBd() {
		Connection c = BDServicio.abrirBaseDatos("basesDeDatos/serviciosUsuarios.db");
		//COMPROBAMOS QUE NO ES NULA
		
		assertNotNull(c);
		
		BDServicio.cerrarConexion();
		
	}
	
	
	
//	@Test
//	public void testRegistrarYObtenerUsuario() {
//		//CREAMOS UN USUARIO Y LO REGISTRAMOS
//		
//		Usuario nuevoUsuario = new Usuario (20, "iker","ruesgas","iruesgas","ruesgasi", "iker.ruesgas@gmail.es", "79123456M",50);
//		//LUEGO LO BUSCAMOS EN LA BASE DE DATOS Y COMPROBAMOS QUE LO RECOGE CORRECTAMENTE
//		Usuario buscado= null;
//		try {
//			BDRegistro.registrar(nuevoUsuario);
//			buscado = BDRegistro.obtenerUsuario("iruesgas");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		assertNotNull(buscado);
//	
//		
//	}
	
	
	@Test
	public void testLoginUsuario() {
		
		
		// BUSCAMOS EN LA BASE DE DATOS Y COMPROBAMOS QUE HACE EL LOGIN CORRECTAMENTE
		boolean registrado=false;
		try {
			registrado=BDRegistro.login("iruesgas", "ruesgasi");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(registrado);
	
		
	}
	
	@Test
	public void testLoginAdmin() {
		
		// BUSCAMOS EN LA BASE DE DATOS Y COMPROBAMOS QUE EL LOGIN DE ADMIN LO RECOGE CORRECTAMENTE
		boolean registrado=false;
		try {
			registrado=BDRegistro.loginAdmin("admin", "admin");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(registrado);
	
		
	}
	
	
	@Test
	public void testObtenerAdmin() {
		
		// BUSCAMOS EN LA BASE DE DATOS EL ADMINISTRADOR
		Administrador admin=null;
		try {
			admin=BDRegistro.obtenerAdministrador("admin");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(admin);
	
		
	}
		
		
		
//		@Test
//		public void testCrearAdmin() {
//			//CREAMOS UN ADMIN Y LO REGISTRAMOS
//		
////			
//		Administrador nuevoAdmin = new Administrador ( "iker","ruesgas","iru","ruesgas",50);
//		//LUEGO LO BUSCAMOS EN LA BASE DE DATOS Y COMPROBAMOS QUE LO RECOGE CORRECTAMENTE
//		boolean result = true;
//		try {
//			result= BDRegistro.crearAdmin(nuevoAdmin);
//			
//			
//		}
//		 catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			}
//		assertFalse(result);
//	
//		
//}
	
	
	@Test
	public void testMostrarUsuariosTotal() {
		
		// OBTENEMOS USUARIOS
		ArrayList<Usuario> listaUsuarios =  new ArrayList<>();
		
		try {
			listaUsuarios = BDRegistro.mostrarUsuariosTotal();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ahora miramos la bd y vemos que el primero tiene nombre de usuario alejandro.
		
		String nusuarioPrimero = listaUsuarios.get(0).getNombreUsuario();
		assertEquals("alejandro", nusuarioPrimero);
		
		//el ultimo tiene el nombre iker 
		String nombreUltimo = listaUsuarios.get(listaUsuarios.size()-1).getNombre();
		assertEquals(nombreUltimo, "iker");

	}
	
	
	@Test
	public void testMostrarAdministradoresTotal() {
		
		// OBTENEMOS USUARIOS
		ArrayList<Administrador> listaAdministradores =  new ArrayList<>();
		
		try {
			listaAdministradores = BDRegistro.mostrarAdministradoresTotal();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ahora miramos la bd y vemos que el primero (y ultimo) tiene nombre de usuario admin.
		
		String nAdminPrimero = listaAdministradores.get(0).getNombreUsuario();
		assertEquals("admin", nAdminPrimero);
		
	}
	
	
	
	@Test
	public void testObtenerPuntosUsuario() {
		
		// OBTENEMOS PUNTOS DEL USUARIO alejandro con el codigo de usuario 2
		int puntosUsuarioAle = -1;
		
		try {
			puntosUsuarioAle = BDRegistro.obtenerPuntos(2);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ahora miramos la bd y vemos que el  tiene 0 puntos;
		
		assertEquals(0, puntosUsuarioAle);
		
		//COMPROBAMOS TAMBIEN CON JONLASA, TIENE ID 5 Y 179 PUNTOS
		
		int puntosJon = -1;
		
		try {
			puntosJon = BDRegistro.obtenerPuntos(5);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		assertEquals(179, puntosJon);	

	}
	
	
	
	@Test
	public void testActualizarPuntosUsuario() {
		
		// actualizamos los  PUNTOS DEL USUARIO alejandro con el codigo de usuario 2 a 50. 
		int puntosUsuarioActualizadosAle = -1;
		
		try {
			//ACTUALIZAMOS
			BDRegistro.actualizarPuntos(2, 50);
			//OBTENEMOS
			
			puntosUsuarioActualizadosAle=BDRegistro.obtenerPuntos(2);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ahora miramos la bd y vemos que el  tiene 0 puntos;
		
		assertEquals(50, puntosUsuarioActualizadosAle);
			

	}
	
	
	
	}
	

