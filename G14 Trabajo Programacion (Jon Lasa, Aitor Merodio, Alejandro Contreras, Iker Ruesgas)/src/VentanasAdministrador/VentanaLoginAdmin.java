package VentanasAdministrador;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import BD.BDRegistro;
import Datos.Administrador;
import VentanasRegistro.VentanaLogin;

import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class VentanaLoginAdmin extends JFrame {

	private JPanel contentPane;
	private JPasswordField contrasenya;
	private JTextField usuario;

	public  VentanaLoginAdmin() {
		inicializar();
	}
	private void  inicializar() {
		
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblUsuario = new JLabel("Administrador:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuario.setBounds(168, 181, 146, 31);
		contentPane.add(lblUsuario);
		

		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(168, 261, 110, 31);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblIniciarSesion = new JLabel("Administrador");
		lblIniciarSesion.setForeground(new Color(255, 128, 0));
		lblIniciarSesion.setFont(new Font("Eras Light ITC", Font.BOLD, 26));
		lblIniciarSesion.setBounds(244, 60, 218, 64);
		contentPane.add(lblIniciarSesion);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setBounds(190, 356, 124, 23);
		contentPane.add(btnIniciarSesion);
		

		contrasenya = new JPasswordField();
		contrasenya.setBounds(321, 268, 203, 20);
		contentPane.add(contrasenya);
		
		usuario = new JTextField();
		usuario.setBounds(321, 188, 203, 20);
		contentPane.add(usuario);
		usuario.setColumns(10);
		

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(380, 356, 124, 23);
		contentPane.add(btnVolver);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaLoginAdmin.class.getResource("/ImagenesPNG/pngegg (1).png")));
		lblNewLabel.setBounds(125, 177, 46, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(VentanaLoginAdmin.class.getResource("/ImagenesPNG/logoLlave.png")));
		lblNewLabel_2.setBounds(125, 246, 85, 64);
		contentPane.add(lblNewLabel_2);
		
		
		
		
		btnVolver.addActionListener(e -> {
			VentanaLogin vr = null;
			vr = new VentanaLogin();
			vr.setVisible(true);
			dispose();
			
			
		
		});
		
		btnIniciarSesion.addActionListener(e->{
			String usr=usuario.getText();
			String contra=contrasenya.getText();
			
			
			try {
				if(BDRegistro.loginAdmin(usr, contra,BDRegistro.baseDatos)==true) {
					Administrador administradorActual = BDRegistro.obtenerAdministrador(usr,BDRegistro.baseDatos);
					JOptionPane.showMessageDialog(null, "Inicio de sesion correcto");
					VentanaInicioAdmin vr = null;
					vr = new VentanaInicioAdmin(administradorActual);
					vr.setVisible(true);
					dispose();	
				}
				else JOptionPane.showMessageDialog(null, "Inicio de sesion incorrecto");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
			
			
			
			
		});
		
		JOptionPane.showMessageDialog(null, "Apartado exclusivo para Administradores");
	}
}
