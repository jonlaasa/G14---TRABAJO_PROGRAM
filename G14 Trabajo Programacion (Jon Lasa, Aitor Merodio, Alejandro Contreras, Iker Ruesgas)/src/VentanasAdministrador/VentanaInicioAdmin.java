package VentanasAdministrador;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.Administrador;
import VentanasRegistro.VentanaInicio;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.ImageIcon;

public class VentanaInicioAdmin extends JFrame {

	private JPanel contentPane;


	
	public VentanaInicioAdmin(Administrador administradorActual) {
		
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		setLocationRelativeTo(null);
		
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
		
		JMenu mnServicios = new JMenu("Crear Servicios");
		menuBar_1.add(mnServicios);
		
		JMenu mnEstadisticas = new JMenu("Estadisticas de T&T");
		menuBar_1.add(mnEstadisticas);
		
		
		JMenuItem mntmVuelos = new JMenuItem("Vuelos");
		mnServicios.add(mntmVuelos);
		
		JMenuItem mntmBuses = new JMenuItem("Buses");
		mnServicios.add(mntmBuses);
		

		
		JMenuItem mntmEstadisticas = new JMenuItem("Ver estadisticas");
		mnEstadisticas.add(mntmEstadisticas);
		
		JMenuItem mntmVerBus = new JMenuItem("Ver Buses");
		mnEstadisticas.add(mntmVerBus);
		
		JMenuItem mntmVerVuelos = new JMenuItem("Ver Vuelos");
		mnEstadisticas.add(mntmVerVuelos);
		
		JMenuItem mntmVerViajesCombinados = new JMenuItem("Ver V.Combinados");
		mnEstadisticas.add(mntmVerViajesCombinados);
		
		
		JMenu mnPerfil = new JMenu("Perfil");
		menuBar_1.add(mnPerfil);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mnPerfil.add(mntmCerrarSesion);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon imagenFondod =  new ImageIcon("src/ImagenesPNG/triangulosD.png");
		ImageIcon nuevoIconod = new ImageIcon(imagenFondod.getImage().getScaledInstance(271,259,Image.SCALE_AREA_AVERAGING));
		
		JLabel LabeltriangulosD = new JLabel("",nuevoIconod,JLabel.CENTER);		
		LabeltriangulosD.setBounds(487, 171, 271, 259);
		contentPane.add(LabeltriangulosD);
		
		ImageIcon imagenFondoI =  new ImageIcon("src/ImagenesPNG/triangulosI.png");
		ImageIcon nuevoIconoI = new ImageIcon(imagenFondoI.getImage().getScaledInstance(271,259,Image.SCALE_AREA_AVERAGING));
		
		JLabel LabeltriangulosI = new JLabel("", nuevoIconoI,JLabel.CENTER);
		LabeltriangulosI.setBounds(-55, 171, 271, 259);
		contentPane.add(LabeltriangulosI);
		
		JLabel lblUsuariosActuales = new JLabel("MENU DE ADMINISTARDORES");
		lblUsuariosActuales.setForeground(new Color(255, 128, 0));
		lblUsuariosActuales.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuariosActuales.setBounds(206, 28, 284, 61);
		contentPane.add(lblUsuariosActuales);

		JLabel labelFoto;
		ImageIcon imgIcon = new ImageIcon("imagenes//logo.jpeg");
		Image image = imgIcon.getImage();
		Image imagenModificada = image.getScaledInstance(700,380,Image.SCALE_SMOOTH);
		ImageIcon nuevoIcono = new ImageIcon(imagenModificada);
		labelFoto = new JLabel ("",new ImageIcon(VentanaInicioAdmin.class.getResource("/ImagenesPNG/logo.jpeg")),JLabel.CENTER);
		labelFoto.setBounds(172, 76, 296, 295);
		contentPane.add(labelFoto);
		
		
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
	
		mntmBuses.addActionListener(e->{
			VentanaCrearBus vcb=null;
			vcb=new VentanaCrearBus(administradorActual);
			vcb.setVisible(true);
			dispose();
		});
		
		mntmVuelos.addActionListener(e->{
			VentanaCrearVuelo vcb=null;
			vcb=new VentanaCrearVuelo(administradorActual);
			vcb.setVisible(true);
			dispose();
		});
		
		mntmVerBus.addActionListener(e->{
			VentanaVerBus vcb=null;
			try {
				vcb=new VentanaVerBus(administradorActual);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			vcb.setVisible(true);
			dispose();
		});
		mntmVerVuelos.addActionListener(e->{
			VentanaVerVuelos vcb=null;
			try {
				vcb=new VentanaVerVuelos(administradorActual);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			vcb.setVisible(true);
			dispose();
		});
		
		
		
		
		mntmVerViajesCombinados.addActionListener(e->{
			VentanaVerViajeCombinado vcb=null;
			try {
				vcb=new VentanaVerViajeCombinado(administradorActual);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			vcb.setVisible(true);
			dispose();
		});
		
		
		//ESTADISTICA EVENTO, CREAMOS VENTANA
		mntmEstadisticas.addActionListener(e -> {
			
			VentanaMostrarEstadistica v = new VentanaMostrarEstadistica(administradorActual);
			v.setVisible(true);
			dispose();
			
			
		});
		
		
		
	}
}

