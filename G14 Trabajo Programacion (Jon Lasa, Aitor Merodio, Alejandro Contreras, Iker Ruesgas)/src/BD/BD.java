package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class BD {
	
	
	private static Connection conn;
	
	static Logger logger= Logger.getLogger( BD.class.getName() );
	
	public static  Connection abrirBaseDatos(String nombrebD) {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:"+ nombrebD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.log(Level.INFO, "Conexion establecida");
		return conn;

		
	}
	
	

	public static void cerrarConexion () {
		
		
		try {
			logger.log(Level.INFO, "Conexion cerrada");
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	
	
	
	
	
	
	
	
	
	

}
