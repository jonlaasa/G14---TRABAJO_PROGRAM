package VentanasAdministrador;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.Administrador;
import VentanasMenu.VentanaMenu;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

public class VentanaInicioAdmin extends JFrame {

	private JPanel contentPane;


	
	public VentanaInicioAdmin(Administrador administradorActual) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		
		JMenuBar menuBar_1 = new JMenuBar();
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
		
		JMenu mnCerrarSesion = new JMenu("Cerrar sesion");
		menuBar_1.add(mnCerrarSesion);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuariosActuales = new JLabel("Usuarios actuales:");
		lblUsuariosActuales.setBounds(80, 106, 127, 14);
		contentPane.add(lblUsuariosActuales);
		
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
		
		
		
		
		
	}
}
