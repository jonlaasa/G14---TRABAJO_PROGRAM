package VentanasAdministrador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import BD.BDRegistro;
import VentanasMenu.ini;
import VentanasRegistro.VentanaInicio;
import VentanasRegistro.VentanaLogin;

import javax.swing.JTextField;

public class VentanaLoginAdmin extends JFrame {

	private JPanel contentPane;
	private JPasswordField contrasenya;
	private JTextField usuario;
	private JPasswordField codAcceso;

	public  VentanaLoginAdmin() {
		inicializar();
	}
	private void  inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(60, 84, 79, 31);
		contentPane.add(lblUsuario);
		

		
		JLabel lblNewLabel_1 = new JLabel("Contrasea\u00F1a:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(60, 143, 110, 31);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblIniciarSesion = new JLabel("Administrador");
		lblIniciarSesion.setForeground(new Color(255, 128, 0));
		lblIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblIniciarSesion.setBounds(190, 22, 157, 43);
		contentPane.add(lblIniciarSesion);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setBounds(105, 263, 116, 23);
		contentPane.add(btnIniciarSesion);
		

		contrasenya = new JPasswordField();
		contrasenya.setBounds(180, 150, 136, 20);
		contentPane.add(contrasenya);
		
		usuario = new JTextField();
		usuario.setBounds(180, 91, 136, 20);
		contentPane.add(usuario);
		usuario.setColumns(10);
		

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(292, 263, 116, 23);
		contentPane.add(btnVolver);
		
		JLabel lblCodAcceso = new JLabel("Codigo acceso:");
		lblCodAcceso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodAcceso.setBounds(60, 204, 110, 23);
		contentPane.add(lblCodAcceso);
		
		codAcceso = new JPasswordField();
		codAcceso.setBounds(180, 207, 136, 20);
		contentPane.add(codAcceso);
		
		btnVolver.addActionListener(e -> {
			VentanaLogin vr = null;
			vr = new VentanaLogin();
			vr.setVisible(true);
			dispose();
		});
		
		btnIniciarSesion.addActionListener(e->{
			String usr=usuario.getText();
			String contra=contrasenya.getText();
			String cod = codAcceso.getText();
			int codigo = Integer.parseInt(cod);
			BDRegistro bd = new BDRegistro();
			
			try {
				if(bd.loginAdmin(usr, contra, codigo)==true) {
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
