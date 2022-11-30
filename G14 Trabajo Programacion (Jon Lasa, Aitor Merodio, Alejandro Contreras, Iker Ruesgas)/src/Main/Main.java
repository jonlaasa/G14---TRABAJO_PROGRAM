
package Main;



import java.sql.SQLException;

import BD.BDRegistro;
import VentanasCompra.VentanaBus;
import VentanasCompra.VentanaVuelo;
import VentanasCompra.VentanaVuelo;
import VentanasMenu.VentanaMenu;
import VentanasMenu.VentanaPerfil;
import VentanasRegistro.VentanaInicio;
import VentanasRegistro.VentanaLogin;
import VentanasRegistro.VentanaMetodoPago;

public class Main {

	public static void main(String[] args) throws SQLException {
//		BDRegistro.abrirBaseDatos("basesDeDatos\\serviciosUsuarios.db");
		VentanaInicio v = new VentanaInicio();
		v.setVisible(true);
//		BDRegistro.obtenerUsuario("alberto");
		 

	}
}
