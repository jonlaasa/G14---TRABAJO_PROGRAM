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
		this.setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(177, 351, 124, 23);
		contentPane.add(btnVolver);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(386, 351, 130, 23);
		contentPane.add(btnCrear);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(258, 136, 194, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		lblNewLabel.setBounds(129, 139, 73, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblApellido = new JLabel("Apellidos:");
		lblApellido.setForeground(new Color(255, 255, 255));
		lblApellido.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		lblApellido.setBounds(129, 186, 73, 14);
		contentPane.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		lblUsuario.setBounds(129, 230, 73, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasenya = new JLabel("Contraseña:");
		lblContrasenya.setForeground(new Color(255, 255, 255));
		lblContrasenya.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		lblContrasenya.setBounds(129, 262, 103, 34);
		contentPane.add(lblContrasenya);
		
		tfApellidos = new JTextField();
		tfApellidos.setBounds(258, 183, 194, 20);
		contentPane.add(tfApellidos);
		tfApellidos.setColumns(10);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(258, 227, 194, 20);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfContrasenya = new JPasswordField();
		tfContrasenya.setBounds(258, 269, 194, 20);
		contentPane.add(tfContrasenya);
		
		JLabel lblNewLabel_1 = new JLabel("Crear nuevo administrador");
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setFont(new Font("Eras Light ITC", Font.BOLD, 16));
		lblNewLabel_1.setEnabled(true);
		lblNewLabel_1.setBounds(258, 46, 257, 30);
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
