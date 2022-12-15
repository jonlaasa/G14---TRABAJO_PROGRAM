package VentanasRegistro;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import BD.BDRegistro;
import Datos.Usuario;
import logicaDeNegocio.LongitudStringException;
import logicaDeNegocio.Utils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(80, 200, 84, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(80, 140, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(80, 105, 84, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DNI:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(80, 170, 84, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(77, 274, 113, 14);
		contentPane.add(lblNewLabel_5);
		
		usuario = new JTextField();
		usuario.setBounds(189, 197, 110, 20);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		dni = new JTextField();
		dni.setBounds(189, 167, 110, 20);
		contentPane.add(dni);
		dni.setColumns(10);
		
		apellido = new JTextField();
		apellido.setBounds(189, 137, 110, 20);
		contentPane.add(apellido);
		apellido.setColumns(10);
		
		nombre = new JTextField();
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nombre.setBounds(189, 102, 110, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		contrasenya = new JPasswordField();
		contrasenya.setBounds(189, 273, 110, 20);
		contentPane.add(contrasenya);
		
		JLabel lblNewLabel_6 = new JLabel("Repetir Contrase\u00F1a:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(315, 274, 153, 14);
		contentPane.add(lblNewLabel_6);
		
		contrasenyaRepetida = new JPasswordField();
		contrasenyaRepetida.setBounds(462, 273, 113, 20);
		contentPane.add(contrasenyaRepetida);
		
		btnVolverRegistro = new JButton("Volver");
		btnVolverRegistro.setBounds(210, 335, 89, 23);
		contentPane.add(btnVolverRegistro);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrarse.setBounds(363, 335, 89, 23);
		contentPane.add(btnRegistrarse);
		
		JLabel lblNewLabel_4 = new JLabel("Por favor, rellene todos los campos");
		lblNewLabel_4.setForeground(new Color(255, 128, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_4.setBounds(189, 25, 349, 50);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("Mail:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(80, 237, 73, 14);
		contentPane.add(lblNewLabel_7);
		
		mail = new JTextField();
		mail.setBounds(189, 236, 110, 20);
		contentPane.add(mail);
		mail.setColumns(10);
		
		
		
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
						BDRegistro.registrar(new Usuario(nom,ape,usr,contra,correo,dn));
						log.log(Level.INFO, "USUARIO REGISTRADO EN LA BASE DE DATOS");
						//VOLVEMOS A LA VENTANA DE INICIO DE SESION
						
						VentanaLogin vent = new VentanaLogin();
						vent.setVisible(true);
						dispose();
						
					} catch (LongitudStringException e2) {
						log.log(Level.SEVERE, "Longitud de datos de registro no valida:");
											
					}	
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		});
		
		
	}
}

