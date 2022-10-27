package VentanasMenu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
		
		JButton btnNewButton = new JButton("COMPRAR VUELO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(27, 128, 162, 69);
		contentPane.add(btnNewButton);
		
		JButton btnComprarBus = new JButton("COMPRAR BUS");
		btnComprarBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComprarBus.setBounds(261, 215, 181, 69);
		contentPane.add(btnComprarBus);
		
		JButton btnNewButton_1 = new JButton("COMPRAR VIAJE. COMB");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(464, 127, 189, 71);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("PERFIL");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(305, 351, 116, 33);
		contentPane.add(btnNewButton_2);
		
		JButton btnInfoApp = new JButton("INFO DE LA APP");
		btnInfoApp.setBounds(562, 312, 112, 23);
		contentPane.add(btnInfoApp);
		
		JButton btnConsulta = new JButton("CONSULTA ANALITICA DE DATOS");
		btnConsulta.setBounds(27, 346, 213, 33);
		contentPane.add(btnConsulta);
		
		JButton btnNewButton_3 = new JButton("POLITICA PRIVACIDAD");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(518, 351, 156, 23);
		contentPane.add(btnNewButton_3);
		
	}
}
