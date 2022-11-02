package BD;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

import Datos.Usuario;


public class usuariosSQL extends BD{
	
	private static Connection conn = null;
	private static PreparedStatement pst = null;
	private static ResultSet rs=  null;
	private static Properties properties = new Properties();
	
	
	
	
	
	
	
	
	
	
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
		
		
		
		JOptionPane.showMessageDialog(null, "Inicio de sesion");
		return true;
	}catch(SQLException e){
		JOptionPane.showMessageDialog(null, "Inicio de sesion fallido");
		return false;
	}
		
		
	
	
}
}

