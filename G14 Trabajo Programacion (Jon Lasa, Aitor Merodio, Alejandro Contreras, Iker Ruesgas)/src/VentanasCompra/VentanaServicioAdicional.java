package VentanasCompra;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.BusComprado;
import Datos.Compra;
import Datos.Servicio;
import Datos.Usuario;
import Datos.Vuelo;
import VentanasMenu.VentanaMenu;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class VentanaServicioAdicional extends JFrame {

	private JPanel contentPane;
	
	
	public VentanaServicioAdicional(Usuario usuarioActual, Vuelo vuelo, int cantidad) {
		
		inicializar(usuarioActual,vuelo, cantidad);
	}


	private void inicializar(Usuario usuarioActual ,Vuelo vuelo, int cantidad) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SERVICIOS ADICIONALES PARA VUELO");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(206, 11, 326, 42);
		contentPane.add(lblNewLabel);
		
		//LLENAMOS EL COMBO CON LAS OPCIONES
		String [] listaZonas = new String [] {"ZONA TRASERA (+0 EU)","ZONA CENTRAL (+10 EU)", "ZONA DELANTERA (+30 EU)"};
		JComboBox comboAsiento = new JComboBox(listaZonas);
		comboAsiento.setBounds(38, 106, 150, 22);
		contentPane.add(comboAsiento);
		
	
		JLabel lblNewLabel_1 = new JLabel("SELECCION DE ZONA DE ASIENTO");
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setBounds(28, 81, 189, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel imagenAsiento = new JLabel("");
		imagenAsiento.setBounds(299, 59, 347, 85);
		contentPane.add(imagenAsiento);
		imagenAsiento.setIcon(new ImageIcon("imagenes//asientoo.jpg"));
		
		JLabel mRenting = new JLabel("SERVICIO DE RENTING DE COCHE (OPCIONAL) RECOGER EL COCHE CUANDO QUIERA, EN EL AEROPUERTO DESTINO");
		mRenting.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		mRenting.setForeground(new Color(255, 128, 0));
		mRenting.setBounds(28, 164, 618, 27);
		contentPane.add(mRenting);
		
		//LLENAMOS EL COMBO DE OPCIONES (3 CLASE/GAMAS POSIBLES)
		String [] listaClase = new String [] {"NINGUNO","C","B","A"};
		JComboBox comboOpcion = new JComboBox(listaClase);
		comboOpcion.setBounds(28, 343, 127, 22);
		contentPane.add(comboOpcion);
		
		JLabel mClase = new JLabel("OPCION ESCOGIDA");
		mClase.setForeground(new Color(255, 128, 0));
		mClase.setBounds(28, 318, 127, 14);
		contentPane.add(mClase);
		
		JLabel lblNumeroDeDias = new JLabel("NUMERO DE DIAS");
		lblNumeroDeDias.setForeground(new Color(255, 128, 0));
		lblNumeroDeDias.setBounds(184, 318, 127, 14);
		contentPane.add(lblNumeroDeDias);
		
		String [] listaDias = new String [] {"1","2","3","4","5","6","7","8","9"};
		
		JComboBox comboDias = new JComboBox(listaDias);
		comboDias.setBounds(194, 343, 73, 22);
		contentPane.add(comboDias);
		
		JButton continuar = new JButton("CONTINUAR");
		continuar.setBounds(448, 343, 109, 23);
		contentPane.add(continuar);
		
		JButton atras = new JButton("ATRAS");
		atras.setBounds(581, 347, 81, 18);
		contentPane.add(atras);
		
	}	
}