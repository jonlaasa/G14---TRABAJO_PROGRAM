package VentanasRegistro;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import BD.BDRegistro;
import Datos.Usuario;
import logicaDeNegocio.LongitudStringException;
import logicaDeNegocio.Utils;

import javax.swing.JLabel;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class VentanaRegistro extends JFrame {


    Logger log = Logger.getLogger("loger-usuario");
	private JPanel contentPane;
	private JTextField usuario;
	private JTextField dni;
	private JTextField apellido;
	private JTextField nombre;
	private JPasswordField contrasenya;
	private JPasswordField contrasenyaRepetida;
	private JButton btnVolverRegistro;
	private JTextField mail;
	


	
	public VentanaRegistro () {
		inicializar();
		
	}


	private void  inicializar() {
		
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null); 

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(72, 252, 84, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(72, 168, 84, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(72, 124, 84, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DNI:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(72, 212, 84, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(72, 338, 113, 14);
		contentPane.add(lblNewLabel_5);
		
		usuario = new JTextField();
		usuario.setBounds(189, 251, 138, 20);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		dni = new JTextField();
		dni.setBounds(189, 211, 138, 20);
		contentPane.add(dni);
		dni.setColumns(10);
		
		apellido = new JTextField();
		apellido.setBounds(189, 167, 138, 20);
		contentPane.add(apellido);
		apellido.setColumns(10);
		
		nombre = new JTextField();
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nombre.setBounds(189, 123, 138, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		contrasenya = new JPasswordField();
		contrasenya.setBounds(189, 337, 138, 20);
		contentPane.add(contrasenya);
		
		JLabel lblNewLabel_6 = new JLabel("Repetir Contrase\u00F1a:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(340, 335, 198, 20);
		contentPane.add(lblNewLabel_6);
		
		contrasenyaRepetida = new JPasswordField();
		contrasenyaRepetida.setBounds(518, 337, 144, 20);
		contentPane.add(contrasenyaRepetida);
		
		btnVolverRegistro = new JButton("Volver");
		btnVolverRegistro.setBounds(198, 401, 121, 23);
		contentPane.add(btnVolverRegistro);
		
		JButton btnRegistrarse = new JButton("Registrarse");

		btnRegistrarse.setBounds(395, 401, 127, 23);
		contentPane.add(btnRegistrarse);
		
		JLabel lblNewLabel_4 = new JLabel("Por favor, rellene todos los campos");
		lblNewLabel_4.setForeground(new Color(255, 128, 0));
		lblNewLabel_4.setFont(new Font("Eras Light ITC", Font.BOLD, 19));
		lblNewLabel_4.setBounds(208, 60, 349, 50);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("Mail:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(72, 294, 73, 14);
		contentPane.add(lblNewLabel_7);
		
		mail = new JTextField();
		mail.setBounds(189, 293, 138, 20);
		contentPane.add(mail);
		mail.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("REGISTRO DE USUARIO");
		lblNewLabel_8.setForeground(new Color(255, 128, 64));
		lblNewLabel_8.setFont(new Font("Eras Light ITC", Font.BOLD, 20));
		lblNewLabel_8.setBounds(242, 11, 271, 70);
		contentPane.add(lblNewLabel_8);
		
		ImageIcon imagenFondo =  new ImageIcon("src/ImagenesPNG/vueloruta.png");
		ImageIcon nuevoIcono = new ImageIcon(imagenFondo.getImage().getScaledInstance(248,300,Image.SCALE_AREA_AVERAGING));
		
		JLabel panelIconoVuelo = new JLabel("",nuevoIcono,JLabel.CENTER);		
		panelIconoVuelo.setBounds(487, 24, 248, 300);
		
		contentPane.add(panelIconoVuelo);
		
		btnVolverRegistro.addActionListener(e -> {
			VentanaInicio vr = null;
			vr = new VentanaInicio();
			vr.setVisible(true);
			dispose();
		});
		

		btnRegistrarse.addActionListener(e -> {
			String usr=usuario.getText();
			String nom=nombre.getText();
			String dn=dni.getText();
			String ape=apellido.getText();
			String contra=contrasenya.getText();
			String contraRepe=contrasenyaRepetida.getText();
			String correo=mail.getText();
				
				try {
					//Comprobaciones de los parametros del registro
					Utils.comprobarString(usr);
					Utils.comprobarString(contra);					
					Utils.comprobarString(ape);
					Utils.comprobarString(nom);
					Utils.comprobarString(dn);
					Utils.comprobarStringUsuario(usr);
					Utils.comprobarStringContra(contra);
					Utils.comprobarContrasenyas(contra, contraRepe);
					Utils.comprobarMail(correo);
					
					try {
						BDRegistro.registrar(new Usuario(nom,ape,usr,contra,correo,dn),BDRegistro.baseDatos);
						log.log(Level.INFO, "USUARIO REGISTRADO EN LA BASE DE DATOS, NOMBRE DE USUARIO: "+usuario);
						//VOLVEMOS A LA VENTANA DE INICIO DE SESION
						
						VentanaLogin vent = new VentanaLogin();
						vent.setVisible(true);
						dispose();
						
					} catch (LongitudStringException e2) {
						log.log(Level.SEVERE, "Longitud de datos de registro no valida:");
											
					}	
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
		});
		
		
	}
}
