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

public class VentanaMenu extends JFrame {

	private JPanel contentPane;



	public VentanaMenu(Usuario usuarioActual) {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 204, 255));
		menuBar.setForeground(Color.BLACK);
		setJMenuBar(menuBar);
		
		JMenu jmVuelos = new JMenu("Vuelos");
		menuBar.add(jmVuelos);
		
		JMenuItem compraVuelos =  new JMenuItem("Comprar vuelos");
		jmVuelos.add(compraVuelos);
		
		
		JMenu jmBuses = new JMenu("Buses");
		menuBar.add(jmBuses);
		

		JMenuItem compraBuses =  new JMenuItem("Comprar buses");
		jmBuses.add(compraBuses);
		
		JMenu jmICombinado = new JMenu("Viajes Combinados");
		menuBar.add(jmICombinado);
		
		JMenuItem compraComb =  new JMenuItem("Comprar viajes combinados");
		jmICombinado.add(compraComb);
		
		
		JMenu mnOpcionesPerfil = new JMenu("");
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
		
		JLabel ftAvion = new JLabel("ftAvion");
		ftAvion.setIcon(new ImageIcon("imagenes/icons/kisspng-airplane-computer-icons-aircraft-icon-a5-air-transport-5b10f05fb9f810.1049603215278367677617.jpg"));
		ftAvion.setBounds(240, 114, 60, 23);
		contentPane.add(ftAvion);
		
		JButton btnVuelos = new JButton("Vuelos");
		btnVuelos.setIcon(null);
		btnVuelos.setBounds(58, 114, 137, 23);
		contentPane.add(btnVuelos);
		
		JLabel ftBus = new JLabel("ftBus");
		ftBus.setIcon(new ImageIcon("imagenes/icons/kisspng-visakhapatnam-bus-computer-icons-icons-download-bus-png-5ab0d27c5d2195.9444277015215376603815.jpg"));
		ftBus.setBounds(240, 173, 60, 23);
		contentPane.add(ftBus);
		
		JButton btnBuses = new JButton("Buses");
		btnBuses.setBounds(58, 173, 137, 23);
		contentPane.add(btnBuses);
		
		JButton btnViajeCombinado = new JButton("Viaje Combinado");
		btnViajeCombinado.setBounds(62, 232, 133, 23);
		contentPane.add(btnViajeCombinado);
		
		JLabel ftCombinado = new JLabel("ftCombinado");
		ftCombinado.setIcon(new ImageIcon("imagenes/icons/descarga.jpg"));
		ftCombinado.setBounds(240, 218, 60, 37);
		contentPane.add(ftCombinado);
		
		JLabel lblNewLabel_3 = new JLabel("NACIONAL"
				+ "");
		lblNewLabel_3.setBounds(99, 89, 80, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NACIONAL");
		lblNewLabel_4.setBounds(99, 148, 60, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("NACIONAL");
		lblNewLabel_5.setBounds(99, 208, 60, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel ftLogo = new JLabel("");
		ftLogo.setIcon(new ImageIcon("imagenes/icons/avionNN.jpg"));
		ftLogo.setBounds(458, 76, 139, 179);
		contentPane.add(ftLogo);

		JLabel lblBienevenida = new JLabel("¡Bienvenido "+usuarioActual.getNombre()+"!");
		lblBienevenida.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBienevenida.setForeground(new Color(255, 128, 0));
		lblBienevenida.setBounds(253, 31, 225, 37);
		contentPane.add(lblBienevenida);
		
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
