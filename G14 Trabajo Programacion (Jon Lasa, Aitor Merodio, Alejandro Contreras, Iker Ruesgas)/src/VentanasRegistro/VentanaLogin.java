package VentanasRegistro;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.BDRegistro;
import BD.BDServicio;
import Datos.Usuario;
import VentanasAdministrador.VentanaLoginAdmin;
import VentanasMenu.VentanaMenu;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.logging.Level;

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
		this.setLocationRelativeTo(null); 

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(90, 105, 79, 31);
		contentPane.add(lblUsuario);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña:");
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
			BDRegistro.log(Level.INFO, "Volviendo a ventana de inicio" , null);
			VentanaInicio vr = null;
			vr = new VentanaInicio();
			vr.setVisible(true);
			dispose();
		});
		

		btnRegistrarse.addActionListener(e -> {
			BDRegistro.log(Level.INFO, "Accediendo a REGISTRO" , null);
			VentanaRegistro vr = null;
			vr = new VentanaRegistro();
			vr.setVisible(true);
			dispose();
		});
		
		
		btnAdmin.addActionListener(e -> {
			BDRegistro.log(Level.INFO, "Accediendo a INICIO DE SESION DE ADMINISTRADOR" , null);
			VentanaLoginAdmin vr = null;
			vr = new VentanaLoginAdmin();
			vr.setVisible(true);
			dispose();
		});
		
		btnIniciarSesion.addActionListener(e->{
			String usr=usuario.getText();
			String contra=contrasenya.getText();
			
			try {
				if(BDRegistro.login(usr, contra, BDRegistro.baseDatos)==true) {	
					Usuario usuarioActual =BDRegistro.obtenerUsuario(usr, BDRegistro.baseDatos);
					JOptionPane.showMessageDialog(null, "Inicio de sesion correcto");
					BDRegistro.log(Level.INFO, "Sesion iniciada con exito del usuario: "+usr , null);
					
					VentanaMenu vr = null;
					vr = new VentanaMenu(usuarioActual);
					vr.setVisible(true);
					dispose();	
				}
				else {
					JOptionPane.showMessageDialog(null, "Inicio de sesion incorrecto");
					BDRegistro.log(Level.SEVERE, "Inicio de sesion no valido" , null);
				}
				
				
			} catch (Exception e1) {
				BDRegistro.log(Level.SEVERE, "Error al intentar comprobar el usario con la base de datos" , null);
				e1.printStackTrace();
				
			}
			
			
			
			
		});
	}
}




