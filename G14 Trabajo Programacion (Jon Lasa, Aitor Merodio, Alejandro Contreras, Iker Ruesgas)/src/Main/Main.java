
package Main;



import java.sql.SQLException;

import BD.BDRegistro;
import VentanasCompra.VentanaBus;
import VentanasCompra.VentanaVuelo;
import VentanasCompra.VentanaVuelo;
import VentanasMenu.VentanaMenu;
import VentanasMenu.VentanaPerfil;
import VentanasRegistro.VentanaInicio;

public class Main {

	public static void main(String[] args) throws SQLException {
//		BDRegistro.abrirBaseDatos("basesDeDatos\\serviciosUsuarios.db");
//		VentanaPerfil v = new VentanaPerfil();
//		v.setVisible(true);
		BDRegistro.obtenerUsuario("alberto");
		

	}
}
