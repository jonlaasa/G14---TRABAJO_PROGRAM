package BD;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ProcessHandle.Info;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import Datos.Administrador;
import Datos.Usuario;



public class BDRegistro {
	
	private static PreparedStatement pst = null;
	private static Connection conn=null;
	
	private static Logger logger;

	
	
	public static  Connection abrirBaseDatos(String base){
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:"+base);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log(Level.INFO, "Conexion establecida",null);
		return conn;

		
	}
	
	

	public static void cerrarConexion () {
		
		
		try {
			log(Level.INFO, "Conexion cerrada",null);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	
	
	public static boolean registrar(Usuario usr) throws Exception {
		
		Connection con = abrirBaseDatos("basesDeDatos\\serviciosUsuarios.db");
		String sql = "INSERT INTO Usuario (Nombre,	Apellidos, nombreUsuario, Contrasenya, DNI, puntosDeusto,Mail ) VALUES(?,?,?,?,?,?,?)";
	
		try {

			pst=con.prepareStatement(sql);
			pst.setString(1, usr.getNombre());
			pst.setString(2, usr.getApellido());
			pst.setString(3, usr.getNombreUsuario());
			pst.setString(4, usr.getContrasenya());
			pst.setString(5, usr.getDni());
			pst.setInt(6, 0);
			pst.setString(7, usr.getCorreoElectronico());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Registro completado");
			return true;
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Registro fallido");
			return false;
		}
		
	}
	
	public static boolean login(String usr, String contra ) throws Exception{
		Connection con = abrirBaseDatos("basesDeDatos\\serviciosUsuarios.db");
		String sql ="SELECT nombreUsuario,Contrasenya FROM Usuario where nombreUsuario=?and Contrasenya=?"; 
		PreparedStatement rst = con.prepareStatement(sql);
		rst.setString(1, usr);
		rst.setString(2, contra);
		ResultSet rs = rst.executeQuery();

		
		
		if(rs.next()) {
			cerrarConexion();
			return true;
		}else {
			cerrarConexion();
			return false;
		}
		
	}
		
		public static boolean loginAdmin(String usr, String contra ){
			Connection con = abrirBaseDatos("basesDeDatos\\serviciosUsuarios.db");
			String sql ="SELECT Usuario,Contrasenya FROM Admin where Usuario=? and Contrasenya=?"; 
			PreparedStatement rst;
			try {
				rst = con.prepareStatement(sql);
				rst.setString(1, usr);
				rst.setString(2, contra);
				ResultSet rs = rst.executeQuery();
				if(rs.next()) {
					log(Level.INFO, "Sesion iniciada con administrador: " + rs.getString("Usuario"), null);
					return true;
				}else {
					log(Level.SEVERE, "No existe ADMINISTRADOR con usuario "+usr, null);
					return false;
				}
			} catch (SQLException e) {
			
				e.printStackTrace();
				log(Level.SEVERE, "Error al establecer conexion ", e);
				return false;
			}

			
		
		
		
	}
		
		
		public void setLogger(Logger logger) {
			this.logger = logger;
		}
		
		public static void log( Level level, String msg, Throwable excepcion ) {
			if (logger==null) {  // Logger por defecto sera el local:
				logger = Logger.getLogger( "Log-BD" );  // Nombre del logger
				logger.setLevel( Level.ALL );  // Loguea todos los niveles
//				try {
//					logger.addHandler( new FileHandler( "T&T-log.xml", true ) );  // Y saca el log a fichero xml
//				} catch (Exception e) {
//					logger.log( Level.SEVERE, "No se pudo crear fichero de log", e );
//				}
			}
			if (excepcion==null)
				logger.log( level, msg );
			else
				logger.log( level, msg, excepcion );
		}


	
		public static Usuario obtenerUsuario(String usr) throws SQLException{
			Connection con = abrirBaseDatos("basesDeDatos\\serviciosUsuarios.db");
			String sql = "select * from Usuario where nombreUsuario='"+usr+"'";
			
			Statement st = con.createStatement();
			ResultSet rst = st.executeQuery(sql);
			
			while(rst.next()) {
				int id = rst.getInt("id");
				String nombre = rst.getString("Nombre");
				String apellido = rst.getString("Apellidos");
				String contrasenya = rst.getString("Contrasenya");
				String dni = rst.getString("DNI");
				int puntos = rst.getInt("puntosDeusto");
				String mail = rst.getString("Mail");
				Usuario usuario = new Usuario(id,nombre,apellido,usr,contrasenya,mail,dni,puntos);
				return usuario;
			}
			return null;
			}
	
	

		
		public static Administrador obtenerAdministrador(String admin) throws SQLException {
			Connection con = abrirBaseDatos("basesDeDatos\\serviciosUsuarios.db");
			String sql = "select * from admin where usuario='"+admin+"'";
			Statement st = con.createStatement();
			ResultSet rst = st.executeQuery(sql);
			
			while(rst.next()) {
				int id=rst.getInt("id");
				String nombre=rst.getString("nombre");
				String apellido=rst.getString("apellido");
				String contrasenya = rst.getString("contrasenya");
				Administrador administradorActual = new Administrador(nombre,apellido,admin,contrasenya,id);
				return administradorActual;
			}
			return null;
			}
		
		public static boolean crearAdmin(Administrador admin) throws SQLException{
			Connection con = abrirBaseDatos("basesDeDatos\\serviciosUsuarios.db");
			String sql = "insert into Admin (nombre,apellido,usuario,contrasenya) values(?,?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			try {
				pst.setString(1, admin.getNombre());
				pst.setString(2, admin.getApellido());
				pst.setString(3, admin.getNombreUsuario());
				pst.setString(4, admin.getContrasenya());
			}catch (Exception e) {
				// TODO: handle exception
			}		
			return false;			
		}
		
		public static ArrayList<Usuario> mostrarUsuariosTotal() throws SQLException{
			Connection con = abrirBaseDatos("basesDeDatos\\serviciosUsuarios.db");
			String sql = "select * from Usuario";
			ArrayList<Usuario> lista=new ArrayList<Usuario>();
			Statement st = con.createStatement();
			ResultSet rst = st.executeQuery(sql);
			
			while(rst.next()) {
				int id = rst.getInt("id");
				String usr = rst.getString("nombreUsuario");
				String nombre = rst.getString("Nombre");
				String apellido = rst.getString("Apellidos");
				String contrasenya = rst.getString("Contrasenya");
				String dni = rst.getString("DNI");
				int puntos = rst.getInt("puntosDeusto");
				String mail = rst.getString("Mail");
				lista.add(new Usuario(id,nombre,apellido,usr,contrasenya,mail,dni,puntos));
			}
			
			return lista;
			
			
		}
		

		
		public static ArrayList<Administrador> mostrarAdministradoresTotal() throws SQLException{
		Connection con = abrirBaseDatos("basesDeDatos\\serviciosUsuarios.db");
		String sql = "select * from Admin";
		ArrayList<Administrador> lista=new ArrayList<Administrador>();
		Statement st = con.createStatement();
		ResultSet rst = st.executeQuery(sql);
		
		while(rst.next()) {
			int id=rst.getInt("id");
			String nombre=rst.getString("nombre");
			String apellido=rst.getString("apellido");
			String contrasenya = rst.getString("contrasenya");
			String admin = rst.getString("usuario");
			lista.add(new Administrador(nombre,apellido,admin,contrasenya,id));
		}
		return lista;
	}
		
		
		public static int obtenerPuntos(int codigoUsuario) {
			
			Connection con = abrirBaseDatos("basesDeDatos\\serviciosUsuarios.db");
			int puntos=0;
			log(Level.INFO, "OBTENENIENDO LOS PUNTOS DEL USUARIO", null);
			try {
				Statement st = con.createStatement();
				String sent = "select puntosDeusto from Usuario where id =" + codigoUsuario	;
				ResultSet rs = st.executeQuery(sent);
				if(rs.next()) {
					
					puntos= rs.getInt(0);
				}
				log(Level.INFO, "PUNTOS DEL USUARIO OBTENIDOS", null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				log(Level.SEVERE, "ERROR AL INTENTAR OBTENER LOS PUNTOS DEL USUARIO", e);
				e.printStackTrace();
			}
			BDRegistro.cerrarConexion();

			
			return puntos;
		
			
			
			
		}
		
		
		public static void actualizarPuntos (int codUsuario, int puntos) {
			
			Connection con = abrirBaseDatos("basesDeDatos\\serviciosUsuarios.db");
			
			//OBTENEMOS CUANTOS PUNTOS TENIA ANTES
			
			int puntosAnteriores = BDRegistro.obtenerPuntos(codUsuario);
			
			try {
				Statement st = con.createStatement();
				String sent = "update usuario set puntos= "+ puntos+ " where id ="+codUsuario;
				st.executeUpdate(sent);
				log(Level.INFO, "ACTUALIZADOS LOS PUNTOS DEL USUARIO", null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				log(Level.SEVERE, "ERROR AL INTENTAR ACTUALIZAR LOS PUNTOS DEL USUARIO", e);
				e.printStackTrace();
			}
			
			BDRegistro.cerrarConexion();
			
			
		}
		
		
	
		
		
		
		
		
}
