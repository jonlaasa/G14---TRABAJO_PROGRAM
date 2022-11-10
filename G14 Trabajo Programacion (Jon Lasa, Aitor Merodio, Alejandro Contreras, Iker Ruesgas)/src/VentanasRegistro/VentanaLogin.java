package VentanasRegistro;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.BD;
import VentanasAdministrador.VentanaLoginAdmin;
import VentanasMenu.ini;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField contrasenya;
	private JTextField usuario;

	public   VentanaLogin () {
		inicializar();
	}
	private void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(90, 105, 79, 31);
		contentPane.add(lblUsuario);
		
		JLabel lblNewLabel_1 = new JLabel("Contrasea\u00F1a:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(90, 165, 110, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblIniciarSesion = new JLabel("Iniciar Sesion");
		lblIniciarSesion.setForeground(new Color(255, 128, 0));
		lblIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblIniciarSesion.setBounds(173, 32, 157, 43);
		contentPane.add(lblIniciarSesion);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setBounds(20, 266, 116, 23);
		contentPane.add(btnIniciarSesion);
		
		JButton btnAdmin = new JButton("Administrador");
		btnAdmin.setBounds(146, 266, 116, 23);
		contentPane.add(btnAdmin);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(269, 266, 116, 23);
		contentPane.add(btnRegistrarse);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(395, 266, 116, 23);
		contentPane.add(btnVolver);
		
		contrasenya = new JPasswordField();
		contrasenya.setBounds(222, 172, 122, 20);
		contentPane.add(contrasenya);
		
		usuario = new JTextField();
		usuario.setBounds(222, 112, 122, 20);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		
		
		//UTILIZACION DE JAVA FUNCIONAL 

		btnVolver.addActionListener(e -> {
			VentanaInicio vr = null;
			vr = new VentanaInicio();
			vr.setVisible(true);
			dispose();
		});
		

		btnRegistrarse.addActionListener(e -> {
			VentanaRegistro vr = null;
			vr = new VentanaRegistro();
			vr.setVisible(true);
			dispose();
		});
		
		
		btnAdmin.addActionListener(e -> {
			VentanaLoginAdmin vr = null;
			vr = new VentanaLoginAdmin();
			vr.setVisible(true);
			dispose();
		});
		
		btnIniciarSesion.addActionListener(e->{
			String usr=usuario.getText();
			String contra=contrasenya.getText();
			BD bd = new BD();
			
			try {
				if(bd.login(usr, contra)==true) {
					JOptionPane.showMessageDialog(null, "Inicio de sesion correcto");
					ini vr = null;
					vr = new ini();
					vr.setVisible(true);
					dispose();	
				}
				else JOptionPane.showMessageDialog(null, "Inicio de sesion incorrecto");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
			
			
			
		});
	}
}




