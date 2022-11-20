package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import Datos.Compra;
import Datos.Usuario;
import Enum.TipoServicio;

public class BDServicio {
	
private static Connection conn=null;
	
	private static Logger logger;
	
	public static  Connection abrirBaseDatos(String base) {
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
	
	
	public static void compraServicio (Compra compra) {
		//Primero obtenemos el tipoDeServicio
		TipoServicio tipoServicio=compra.getTipoServicio();
		//Obtenemos el codigo UNICO del usuario
		
		int codigo = compra.getCodigoUsuario();
		Date fecha = new Date(compra.getFechaCompra());
		String tipo = compra.getTipoServicio().toString();
		int codigoCompra = compra.getCodigoServicio();
		
		//String de añadir
		
		try {
			Statement st = conn.createStatement();
			String añadir = "Insert into Compra values ("+codigo+", "+"'"+fecha+
					"' ,"+compra.getCantidad()+", '"+tipo+"' ,"+ codigoCompra;
			int valor = st.executeUpdate(añadir);
			if(valor==0) {
				log(Level.SEVERE,"Compra no ha podido ser registrada",null);
				
			}else {
				log(Level.INFO,"Compra registrada con exito",null);
			}
			
			
		} catch (SQLException e) {
			log(Level.INFO,"Error al intentar acceder a la base de datos",null);
			e.printStackTrace();
		}
		
	
	}
	
	
	
	
	
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	public static void log( Level level, String msg, Throwable excepcion ) {
		if (logger==null) {  // Logger por defecto sera el local:
			logger = Logger.getLogger( "Log-BD" );  // Nombre del logger
			logger.setLevel( Level.ALL );  // Loguea todos los niveles
			try {
				logger.addHandler( new FileHandler( "T&T-log.xml", true ) );  // Y saca el log a fichero xml
			} catch (Exception e) {
				logger.log( Level.SEVERE, "No se pudo crear fichero de log", e );
			}
		}
		if (excepcion==null)
			logger.log( level, msg );
		else
			logger.log( level, msg, excepcion );
	}


	
	

}
