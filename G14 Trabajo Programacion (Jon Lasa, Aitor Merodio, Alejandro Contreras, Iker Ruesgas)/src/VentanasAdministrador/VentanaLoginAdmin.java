package VentanasAdministrador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import VentanasRegistro.VentanaInicio;
import VentanasRegistro.VentanaLogin;

import javax.swing.JTextField;

public class VentanaLoginAdmin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	public  VentanaLoginAdmin() {
		inicializar();
	}
	private void  inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(60, 105, 79, 31);
		contentPane.add(lblUsuario);
		
		
		JLabel lblNewLabel_1 = new JLabel("Contrasea\u00F1a:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(60, 165, 110, 31);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblIniciarSesion = new JLabel("Administrador");
		lblIniciarSesion.setForeground(new Color(255, 128, 0));
		lblIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblIniciarSesion.setBounds(122, 34, 157, 43);
		contentPane.add(lblIniciarSesion);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setBounds(89, 227, 116, 23);
		contentPane.add(btnIniciarSesion);
		

		passwordField = new JPasswordField();
		passwordField.setBounds(180, 172, 136, 20);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(180, 112, 136, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(243, 227, 116, 23);
		contentPane.add(btnVolver);
		
		btnVolver.addActionListener(e -> {
			VentanaLogin vr = null;
			vr = new VentanaLogin();
			vr.setVisible(true);
			dispose();
		});
	}


}

