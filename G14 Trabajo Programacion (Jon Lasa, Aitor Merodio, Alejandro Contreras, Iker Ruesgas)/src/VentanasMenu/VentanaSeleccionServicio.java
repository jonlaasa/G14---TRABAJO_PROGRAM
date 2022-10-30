package VentanasMenu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import VentanasRegistro.VentanaDescripcion;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaSeleccionServicio extends JFrame {

	private JPanel contentPane;
	
	
	
	public VentanaSeleccionServicio() {
		inicializar();
	}

	/**
	 * Create the frame.
	 */
	private void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JLabel lblNewLabel_1 = new JLabel("\u00A1BIENVENIDO: \"Nombre del usuario\"!        ");
		lblNewLabel_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(166, 24, 379, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblSeleccionaUnaOpcion = new JLabel("Selecciona una opcion de nuestros servicios");
		lblSeleccionaUnaOpcion.setForeground(new Color(255, 128, 64));
		lblSeleccionaUnaOpcion.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblSeleccionaUnaOpcion.setBounds(155, 56, 356, 21);
		contentPane.add(lblSeleccionaUnaOpcion);
		
		JButton btnVuelo = new JButton("COMPRAR VUELO");
		btnVuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVuelo.setBounds(27, 128, 162, 69);
		contentPane.add(btnVuelo);
		
		JButton btnBus = new JButton("COMPRAR BUS");
		btnBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBus.setBounds(261, 215, 181, 69);
		contentPane.add(btnBus);
		
		JButton btnCombinado = new JButton("COMPRAR VIAJE. COMB");
		btnCombinado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCombinado.setBounds(464, 127, 189, 71);
		contentPane.add(btnCombinado);
		
		JButton btnPerfil = new JButton("PERFIL");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPerfil.setBounds(305, 351, 116, 33);
		contentPane.add(btnPerfil);
		
		JButton btnInfoApp = new JButton("INFO DE LA APP");
		btnInfoApp.setBounds(562, 312, 112, 23);
		contentPane.add(btnInfoApp);
		
		btnInfoApp.addActionListener((e) -> {
			
			VentanaDescripcion vd = new VentanaDescripcion ();
			vd.setVisible(true);
			
		});
		JButton btnConsulta = new JButton("CONSULTA ANALITICA DE DATOS");
		btnConsulta.setBounds(27, 346, 213, 33);
		contentPane.add(btnConsulta);
		
		JButton btnPolitica = new JButton("POLITICA PRIVACIDAD");
		btnPolitica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPolitica.setBounds(518, 351, 156, 23);
		contentPane.add(btnPolitica);
		
	}
}
