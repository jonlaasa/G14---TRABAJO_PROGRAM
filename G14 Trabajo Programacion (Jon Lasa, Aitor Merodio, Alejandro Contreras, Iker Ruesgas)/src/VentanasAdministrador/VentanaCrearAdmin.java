package VentanasAdministrador;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.BDRegistro;
import Datos.Administrador;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.sql.SQLException;
import java.awt.Color;

public class VentanaCrearAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private JTextField tfUsuario;
	private JPasswordField tfContrasenya;


	public VentanaCrearAdmin(Administrador administradorActual) {
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 372);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(155, 276, 89, 23);
		contentPane.add(btnVolver);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(298, 276, 89, 23);
		contentPane.add(btnCrear);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(194, 96, 150, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		lblNewLabel.setBounds(72, 99, 73, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblApellido = new JLabel("Apellidos:");
		lblApellido.setForeground(new Color(255, 255, 255));
		lblApellido.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		lblApellido.setBounds(72, 139, 73, 14);
		contentPane.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		lblUsuario.setBounds(72, 178, 73, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasenya = new JLabel("Contraseña:");
		lblContrasenya.setForeground(new Color(255, 255, 255));
		lblContrasenya.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		lblContrasenya.setBounds(72, 213, 103, 34);
		contentPane.add(lblContrasenya);
		
		tfApellidos = new JTextField();
		tfApellidos.setBounds(194, 136, 150, 20);
		contentPane.add(tfApellidos);
		tfApellidos.setColumns(10);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(194, 175, 150, 20);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfContrasenya = new JPasswordField();
		tfContrasenya.setBounds(194, 220, 150, 20);
		contentPane.add(tfContrasenya);
		
		JLabel lblNewLabel_1 = new JLabel("Crear nuevo administrador");
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setFont(new Font("Eras Light ITC", Font.BOLD, 16));
		lblNewLabel_1.setEnabled(true);
		lblNewLabel_1.setBounds(155, 33, 257, 30);
		contentPane.add(lblNewLabel_1);
		
		btnVolver.addActionListener(e->{
			VentanaInicioAdmin vr = null;
			vr = new VentanaInicioAdmin(administradorActual);
			vr.setVisible(true);
			dispose();
		});
		
		btnCrear.addActionListener(e->{
			Administrador admin = new Administrador();
			
			String nombre = tfNombre.getText();
			String apellido = tfApellidos.getText();
			String usuario = tfUsuario.getText();
			String contrasenya=tfContrasenya.getText();
			
			admin.setNombre(nombre);
			admin.setApellido(apellido);
			admin.setContrasenya(contrasenya);
			admin.setNombreUsuario(usuario);
			
			
			try {
				BDRegistro.crearAdmin(admin);
				JOptionPane.showMessageDialog(null, "Registro completado");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	
	}
}
