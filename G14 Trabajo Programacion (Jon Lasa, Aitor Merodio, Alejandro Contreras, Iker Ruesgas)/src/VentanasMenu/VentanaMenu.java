package VentanasMenu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.Usuario;
import VentanasCompra.VentanaBus;
import VentanasCompra.VentanaViajesC;
import VentanasCompra.VentanaVuelo;
import VentanasRegistro.VentanaInicio;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;

public class VentanaMenu extends JFrame {

	private JPanel contentPane;



	public VentanaMenu(Usuario usuarioActual) {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.setMargin(new Insets(5, 0, 0, 0));
		menuBar.setBackground(new Color(0, 204, 255));
		menuBar.setForeground(Color.BLACK);
		setJMenuBar(menuBar);
		
		JMenu jmVuelos = new JMenu("Vuelos");
		jmVuelos.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(jmVuelos);
		
		JMenuItem compraVuelos =  new JMenuItem("Comprar vuelos");
		jmVuelos.add(compraVuelos);

		JMenu jmBuses = new JMenu("Buses");
		jmBuses.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(jmBuses);
		
		JMenuItem compraBuses =  new JMenuItem("Comprar buses");
		jmBuses.add(compraBuses);
		
		JMenu jmICombinado = new JMenu("Viajes Combinados");
		jmICombinado.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(jmICombinado);
		
		JMenu jmEspacio = new JMenu("                                                                                                                                   "); //Este JMenu lo añadimos por estetica ya que queremos que el icono del perfil quede a la derecha
		jmEspacio.setEnabled(false);
		menuBar.add(jmEspacio);
		
		JMenuItem compraComb =  new JMenuItem("Comprar viajes combinados");
		jmICombinado.add(compraComb);
		
		JMenu mnOpcionesPerfil = new JMenu("");
		mnOpcionesPerfil.setHorizontalAlignment(SwingConstants.TRAILING);
		mnOpcionesPerfil.setIcon(new ImageIcon("Imagenes\\icons\\KISSPN~2.JPG"));
		menuBar.add(mnOpcionesPerfil);
		
		JMenuItem mntmPerfil = new JMenuItem("Perfil");
		mnOpcionesPerfil.add(mntmPerfil);
		
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		mnOpcionesPerfil.add(mntmCerrarSesion);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon imagenFondoA =  new ImageIcon("src/ImagenesPNG/AvionFiltro.jpg");
		ImageIcon nuevoIconoA = new ImageIcon(imagenFondoA.getImage().getScaledInstance(201,128,Image.SCALE_AREA_AVERAGING));
		
		JLabel ftAvion = new JLabel("", nuevoIconoA, JLabel.CENTER);
		ftAvion.setBounds(15, 124, 201, 128);
		contentPane.add(ftAvion);
		
		JButton btnVuelos = new JButton("Vuelo");
		btnVuelos.setForeground(new Color(0, 0, 255));
		btnVuelos.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVuelos.setIcon(null);
		btnVuelos.setBounds(56, 276, 137, 23);
		contentPane.add(btnVuelos);
		
		ImageIcon imagenFondoBus =  new ImageIcon("src/ImagenesPNG/BusFiltro.png");
		ImageIcon nuevoIconoBus = new ImageIcon(imagenFondoBus.getImage().getScaledInstance(201,128,Image.SCALE_AREA_AVERAGING));
		
		JLabel ftBus = new JLabel("",nuevoIconoBus, JLabel.CENTER);
		ftBus.setBounds(237, 124, 201, 128);
		contentPane.add(ftBus);
		
		JButton btnBuses = new JButton("Bus");
		btnBuses.setForeground(new Color(34, 139, 34));
		btnBuses.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuses.setBounds(266, 276, 143, 23);
		contentPane.add(btnBuses);
		
		JButton btnViajeCombinado = new JButton("Viaje Combinado");
		btnViajeCombinado.setForeground(new Color(255, 140, 0));
		
		btnViajeCombinado.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnViajeCombinado.setBounds(479, 276, 143, 23);
		contentPane.add(btnViajeCombinado);
		
		ImageIcon imagenFondoVC =  new ImageIcon("src/ImagenesPNG/ViajecFiltro.jpg");
		ImageIcon nuevoIconoVC = new ImageIcon(imagenFondoVC.getImage().getScaledInstance(201,128,Image.SCALE_AREA_AVERAGING));
		
		JLabel ftCombinado = new JLabel("",nuevoIconoVC, JLabel.CENTER);
		ftCombinado.setBounds(460, 124, 201, 128);
		contentPane.add(ftCombinado);
		
		ImageIcon imagenFondo =  new ImageIcon("src/ImagenesPNG/triangulosD.png");
		ImageIcon nuevoIcono = new ImageIcon(imagenFondo.getImage().getScaledInstance(271,259,Image.SCALE_AREA_AVERAGING));
		
		JLabel LabeltriangulosD = new JLabel("",nuevoIcono,JLabel.CENTER);		
		LabeltriangulosD.setBounds(487, 171, 271, 259);
		contentPane.add(LabeltriangulosD);
		
		ImageIcon imagenFondoI =  new ImageIcon("src/ImagenesPNG/triangulosI.png");
		ImageIcon nuevoIconoI = new ImageIcon(imagenFondoI.getImage().getScaledInstance(271,259,Image.SCALE_AREA_AVERAGING));
		
		JLabel LabeltriangulosI = new JLabel("", nuevoIconoI,JLabel.CENTER);
		LabeltriangulosI.setBounds(-55, 171, 271, 259);
		contentPane.add(LabeltriangulosI);

		JLabel lblBienevenida = new JLabel("¡Bienvenido "+usuarioActual.getNombre()+"!");
		lblBienevenida.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBienevenida.setForeground(new Color(255, 128, 0));
		lblBienevenida.setBounds(181, 33, 252, 37);
		contentPane.add(lblBienevenida);
		
		ImageIcon imagenFondoN =  new ImageIcon("src/ImagenesPNG/ViajesP.png");
		ImageIcon nuevoIconoN = new ImageIcon(imagenFondoN.getImage().getScaledInstance(193,73,Image.SCALE_AREA_AVERAGING));
		
		JLabel labelN = new JLabel("", nuevoIconoN, JLabel.CENTER);
		labelN.setBounds(434, 22, 193, 73);
		contentPane.add(labelN);
		
		JLabel lblNewLabel = new JLabel("Seleccione el tipo de viaje que quiera comprar:");
		lblNewLabel.setForeground(new Color(100, 149, 237));
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel.setBounds(15, 94, 232, 14);
		contentPane.add(lblNewLabel);
		
		//EVENTOS DE BOTONES
		
		compraVuelos.addActionListener(e -> {
			VentanaVuelo vb = new VentanaVuelo(usuarioActual);
			vb.setVisible(true);
			dispose();
		});
		
		compraBuses.addActionListener(e -> {
			VentanaBus vb = null;
			vb = new VentanaBus(usuarioActual);
			vb.setVisible(true);
			dispose();
		});
		
		compraComb.addActionListener(e -> {
			VentanaViajesC vb = null;
			vb = new VentanaViajesC(usuarioActual);
			vb.setVisible(true);
			dispose();
	
		});
		
		
		mntmPerfil.addActionListener(e -> {		
			VentanaPerfil vp = null;
			vp=new VentanaPerfil(usuarioActual);
			vp.setVisible(true);
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
		
		
		
		
		btnBuses.addActionListener(e->{
			VentanaBus vb = null;
			vb = new VentanaBus(usuarioActual);
			vb.setVisible(true);
			dispose();
		});
		btnVuelos.addActionListener(e->{
			VentanaVuelo vb = null;
			vb = new VentanaVuelo(usuarioActual);
			vb.setVisible(true);
			dispose();
		});
		
		btnViajeCombinado.addActionListener(e->{
			VentanaViajesC vb = null;
			vb = new VentanaViajesC(usuarioActual);
			vb.setVisible(true);
			dispose();
		});
	}
}
