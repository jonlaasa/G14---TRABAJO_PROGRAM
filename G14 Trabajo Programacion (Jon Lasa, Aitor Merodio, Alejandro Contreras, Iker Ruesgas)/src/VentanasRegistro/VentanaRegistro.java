package VentanasRegistro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import erm.dataBase.DBException;
import erm.ventanasPrimarias.VentanaRegistro;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.net.BindException;
import java.awt.event.ActionEvent;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField usuario;
	private JTextField dni;
	private JTextField apellido;
	private JTextField nombre;
	private JPasswordField contraseña;
	private JPasswordField passwordField_1;
	private JButton btnVolverRegistro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistro() {
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
		lblNewLabel_5.setBounds(80, 230, 113, 14);
		contentPane.add(lblNewLabel_5);
		
		usuario = new JTextField();
		usuario.setBounds(189, 197, 86, 20);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		dni = new JTextField();
		dni.setBounds(189, 167, 86, 20);
		contentPane.add(dni);
		dni.setColumns(10);
		
		apellido = new JTextField();
		apellido.setBounds(189, 137, 86, 20);
		contentPane.add(apellido);
		apellido.setColumns(10);
		
		nombre = new JTextField();
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nombre.setBounds(189, 102, 86, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		contraseña = new JPasswordField();
		contraseña.setBounds(189, 227, 86, 20);
		contentPane.add(contraseña);
		
		JLabel lblNewLabel_6 = new JLabel("Repetir Contrase\u00F1a:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(295, 230, 153, 14);
		contentPane.add(lblNewLabel_6);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(442, 229, 86, 20);
		contentPane.add(passwordField_1);
		
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
		
		
		
		btnVolverRegistro.addActionListener(e -> {
			VentanaInicio vr = null;
			vr = new VentanaInicio();
			vr.setVisible(true);
			dispose();
		});
//
	}
}
