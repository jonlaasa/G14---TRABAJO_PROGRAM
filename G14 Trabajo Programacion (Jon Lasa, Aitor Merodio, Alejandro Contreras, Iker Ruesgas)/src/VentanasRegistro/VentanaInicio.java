package VentanasRegistro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	
	
	public  VentanaInicio () {
		inicializar();
	}

	private void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrarse.setBounds(176, 343, 127, 23);
		contentPane.add(btnRegistrarse);

		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setBounds(404, 343, 127, 23);
		contentPane.add(btnIniciarSesion);

		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBienvenido.setForeground(new Color(255, 128, 0));
		lblBienvenido.setBounds(286, 35, 127, 71);
		contentPane.add(lblBienvenido);

		JLabel lblNewLabel = new JLabel("*LOGO*");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(268, 169, 209, 86);
		contentPane.add(lblNewLabel);

		btnRegistrarse.addActionListener(e -> {
			VentanaRegistro vr = null;
			vr = new VentanaRegistro();
			vr.setVisible(true);
			dispose();
		});

		btnIniciarSesion.addActionListener(e -> {
			VentanaLogin vr = null;
			vr = new VentanaLogin();
			vr.setVisible(true);
			dispose();
		});

	}
}
