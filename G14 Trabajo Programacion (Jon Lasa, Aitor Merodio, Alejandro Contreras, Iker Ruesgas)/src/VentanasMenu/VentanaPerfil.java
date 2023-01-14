package VentanasMenu;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import BD.BDServicio;
import Datos.BusComprado;
import Datos.Compra;
import Datos.Usuario;
import Datos.ViajeCombinadoComprado;
import Datos.VueloComprado;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Color;
import java.awt.Font;


public class VentanaPerfil extends JFrame {

	private JPanel contentPane;


	public VentanaPerfil(Usuario usrActual) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(47, 60, 79, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidos.setBounds(47, 87, 79, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblMostrarUsuario = new JLabel(usrActual.getNombre());
		lblMostrarUsuario.setBounds(157, 61, 110, 14);
		contentPane.add(lblMostrarUsuario);
		
		
		
		JLabel lblMostrarApellidos = new JLabel(usrActual.getApellido());
		lblMostrarApellidos.setBounds(157, 88, 120, 14);
		contentPane.add(lblMostrarApellidos);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDni.setBounds(47, 116, 46, 14);
		contentPane.add(lblDni);
		
		JLabel lblMostrarDni = new JLabel(usrActual.getDni());
		lblMostrarDni.setBounds(157, 117, 120, 14);
		contentPane.add(lblMostrarDni);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMail.setBounds(47, 145, 73, 14);
		contentPane.add(lblMail);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(368, 277, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lblMostrarMail = new JLabel(usrActual.getCorreoElectronico());
		lblMostrarMail.setBounds(157, 142, 132, 23);
		contentPane.add(lblMostrarMail);
		
		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setForeground(new Color(255, 128, 0));
		lblPerfil.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPerfil.setBounds(215, 27, 52, 23);
		contentPane.add(lblPerfil);
		
		JLabel lblPuntos = new JLabel("PUNTOS T&T");
		lblPuntos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPuntos.setBounds(341, 60, 110, 14);
		contentPane.add(lblPuntos);
		
		
		
		JLabel lblMostrarPuntos = new JLabel(String.valueOf(usrActual.getPuntos()));
		lblMostrarPuntos.setForeground(new Color(0, 255, 255));
		lblMostrarPuntos.setFont(new Font("Tahoma", Font.PLAIN, 53));
		lblMostrarPuntos.setBounds(351, 60, 106, 153);
		contentPane.add(lblMostrarPuntos);
		
		JButton btnMostrarCompras = new JButton("Mostrar Compras");
		btnMostrarCompras.setBounds(10, 177, 148, 23);
		contentPane.add(btnMostrarCompras);
		
		JLabel lMostrarCompras = new JLabel("Aqui se mostraran las compras");
		lMostrarCompras.setForeground(new Color(255, 128, 64));
		lMostrarCompras.setBackground(new Color(255, 128, 64));
		lMostrarCompras.setBounds(10, 211, 447, 77);
		contentPane.add(lMostrarCompras);
		
		JLabel lblNewLabel_1 = new JLabel("Cada 2 segundos se mostrara una compra");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1.setBounds(204, 181, 244, 14);
		contentPane.add(lblNewLabel_1);
		
		btnVolver.addActionListener(e->{
			VentanaMenu vr = null;
			vr = new VentanaMenu(usrActual);
			vr.setVisible(true);
			dispose();
			
		});
		
		//EVENTO PARA MOSTRAR LAS COMPRAS
		
		//SOLO VUELO POR AHORA
		
		btnMostrarCompras.addActionListener(e -> {
			
			//CREAMOS MAPA 
			HashMap <String, ArrayList<Compra>> mapaCompras = new HashMap <String, ArrayList<Compra>> ();
			
			//llenamos con los tres tipos posibles
			
			
			
			mapaCompras.put("Vuelo", new ArrayList<Compra>());
			mapaCompras.put("Bus", new ArrayList<Compra>());
			mapaCompras.put("Viaje Combinado", new ArrayList<Compra>());
			// Arraylist con los vuelos de ese usuario
			
			ArrayList <VueloComprado> listaConVuelos = BDServicio.vuelosCompradosUsuario(usrActual.getCodigo(),BDServicio.baseDatosServicio);
			
			ArrayList<Compra> listaAnyadir = mapaCompras.get("Vuelo");
			
			for(VueloComprado vuelo: listaConVuelos) {
				listaAnyadir.add(vuelo);
			}
			
			mapaCompras.replace("Vuelo", listaAnyadir);
			
			
			//LO MISMO CON EL BUS
			ArrayList <BusComprado> listaConBuses = BDServicio.busesCompradosUsuario(usrActual.getCodigo(),BDServicio.baseDatosServicio);
			
			ArrayList<Compra> listaAnyadir2 = mapaCompras.get("Bus");
			
			for(BusComprado bus: listaConBuses) {
				listaAnyadir2.add(bus);
			}
			
			mapaCompras.replace("Bus", listaAnyadir2);
			//ASI TAMBIEN CON LOS VIAJES COMBINADOS
		
			ArrayList <ViajeCombinadoComprado> listaConCombinados = BDServicio.viajesCombinadosCompradosUsuario(usrActual.getCodigo(),BDServicio.baseDatosServicio);
			
			ArrayList<Compra> listaAnyadir3 = mapaCompras.get("Viaje Combinado");
			
			for(ViajeCombinadoComprado viaje: listaConCombinados) {
				listaAnyadir3.add(viaje);
			}
	
	//FINALMENTE MOSTRAMOS EN EL LABEL
			//HILO!!!! CON ESPERA DE 2 SEGUNDOS
			
			Thread hilo = new Thread (() -> {
				for(String nombreServicio:mapaCompras.keySet()) {
					
					lMostrarCompras.setText(nombreServicio);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//obtenemos la lista de esos servicios 
					ArrayList<Compra> listaComprado = mapaCompras.get(nombreServicio);
					if(listaComprado.size()==0) {
						lMostrarCompras.setText("No hay compras del tipo: "+nombreServicio);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
					for(Compra compra:listaComprado) {
						
						lMostrarCompras.setText(compra.toString());
						
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					}
		
				}
				
				
				
			});hilo.start();
		
		});
		
		
		
	}
}

