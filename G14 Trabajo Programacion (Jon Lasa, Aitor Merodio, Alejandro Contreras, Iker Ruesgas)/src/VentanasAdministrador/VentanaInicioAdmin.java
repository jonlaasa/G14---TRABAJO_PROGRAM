package VentanasAdministrador;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.Administrador;
import VentanasMenu.VentanaMenu;
import VentanasRegistro.VentanaInicio;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class VentanaInicioAdmin extends JFrame {

	private JPanel contentPane;


	
	public VentanaInicioAdmin(Administrador administradorActual) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBackground(new Color(0, 255, 255));
		setJMenuBar(menuBar_1);
		
		JMenu mnAdmin = new JMenu("Administradores");
		menuBar_1.add(mnAdmin);
		
		JMenuItem mntmverAdmin = new JMenuItem("Ver administradores");
		mnAdmin.add(mntmverAdmin);
		
		JMenuItem mntmCrearAdmin = new JMenuItem("Crear administrador");
		mnAdmin.add(mntmCrearAdmin);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar_1.add(mnUsuarios);
		
		JMenuItem mntmVerUsuarios = new JMenuItem("Ver usuarios");
		mnUsuarios.add(mntmVerUsuarios);
		
		JMenu mnServicios = new JMenu("Servicios");
		menuBar_1.add(mnServicios);
		
		JMenuItem mntmVuelos = new JMenuItem("Vuelos");
		mnServicios.add(mntmVuelos);
		
		JMenuItem mntmBuses = new JMenuItem("Buses");
		mnServicios.add(mntmBuses);
		
		JMenuItem mntmCombinados = new JMenuItem("Combinados");
		mnServicios.add(mntmCombinados);
		
		JMenu mnPerfil = new JMenu("Perfil");
		menuBar_1.add(mnPerfil);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mnPerfil.add(mntmCerrarSesion);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuariosActuales = new JLabel("MENU DE ADMINISTARDORES");
		lblUsuariosActuales.setForeground(new Color(255, 128, 0));
		lblUsuariosActuales.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuariosActuales.setBounds(206, 31, 284, 61);
		contentPane.add(lblUsuariosActuales);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\alexc\\OneDrive\\Escritorio\\PROG 3\\Proyecto\\G14---TRABAJO_PROGRAM\\G14 Trabajo Programacion (Jon Lasa, Aitor Merodio, Alejandro Contreras, Iker Ruesgas)\\Imagenes\\icons\\avionNN.jpg"));
		lblNewLabel_1.setBounds(266, 79, 155, 200);
		contentPane.add(lblNewLabel_1);
		
		mntmCrearAdmin.addActionListener(e->{
			VentanaCrearAdmin vr = null;
			vr = new VentanaCrearAdmin(administradorActual);
			vr.setVisible(true);
			dispose();
		});
		
		mntmVerUsuarios.addActionListener(e->{
			VentanaVerUsuarios vr = null;
			try {
				vr = new VentanaVerUsuarios(administradorActual);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			vr.setVisible(true);
			dispose();
		});
		
		mntmverAdmin.addActionListener(e->{
			VentanaVerAdmin vr = null;
			try {
				vr = new VentanaVerAdmin(administradorActual);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			vr.setVisible(true);
			dispose();
		});
		
		
		mntmCerrarSesion.addActionListener(e->{
			int opcion = JOptionPane.showConfirmDialog(null, "¿Estas seguro que quieres cerrar sesion?");
			if(opcion==0) {
				VentanaInicio vr = null;
				vr=new VentanaInicio();
				vr.setVisible(true);
				dispose();
			}
		});
		
		
		
		
		
	}
}