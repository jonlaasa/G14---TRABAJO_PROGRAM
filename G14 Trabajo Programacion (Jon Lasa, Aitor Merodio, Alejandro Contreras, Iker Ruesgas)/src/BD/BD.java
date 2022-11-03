package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import Datos.Usuario;



public class BD {
	
	private static PreparedStatement pst = null;
	private static Connection conn=null;
	
	static Logger logger= Logger.getLogger( BD.class.getName() );
	
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
	
	
	
	public boolean registrar(Usuario usr) throws Exception {
		
		Connection con = abrirBaseDatos("baseDatos");
		String sql = "INSERT INTO Usuario (Nombre,	Apellidos, Usuario, Contrasenya, DNI, puntosDeusto ) VALUES(?,?,?,?,?,?)";
		
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, usr.getNombre());
			pst.setString(2, usr.getApellido());
			pst.setString(3, usr.getNombreUsuario());
			pst.setString(4, usr.getContrasenya());
			pst.setString(5, usr.getDni());
			pst.setInt(6, 0);
			pst.execute();
			JOptionPane.showMessageDialog(null, "Registro completado");
			return true;
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Registro fallido");
			return false;
		}
		
	}
	
	public boolean login(String usr, String contra ) throws Exception{
		Connection con = abrirBaseDatos("baseDatos");
		String sql ="SELECT Usuario,Contrasenya FROM Usuario where Usuario=?and Contrasenya=?"; 
		PreparedStatement rst = con.prepareStatement(sql);
		ResultSet rs = rst.executeQuery();
		boolean valido=false;
		
		if(rs.next()) {
			valido=true;
		}
		
		
		
		return false;
		
	}
	
	
	
	

}
