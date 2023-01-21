package VentanasCompra;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.BDServicio;
import Datos.Bus;
import Datos.BusComprado;
import Datos.Servicio;
import Datos.Usuario;
import Datos.ViajeCombinado;
import Datos.ViajeCombinadoComprado;
import Datos.Vuelo;
import Enum.TipoServicio;
import VentanasMenu.VentanaMenu;
import VentanasRegistro.VentanaMetodoPago;

import javax.swing.JButton;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

public class VentanaBilletes extends JFrame {
	JButton restar, sumar;
	private JPanel contentPane;
	private JLabel mensajeEscoja;
	private JLabel fotoTicket;
	private final static SimpleDateFormat SDF_FECHA_FOTO = new SimpleDateFormat("yyyy/MM/dd");
	
	
	public VentanaBilletes(Usuario usuarioActual, Servicio servicio) {

		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon imagenFondo =  new ImageIcon("src/ImagenesPNG/triangulosD.png");
		ImageIcon nuevoIcono = new ImageIcon(imagenFondo.getImage().getScaledInstance(271,259,Image.SCALE_AREA_AVERAGING));
		
		ImageIcon imagenFondoI =  new ImageIcon("src/ImagenesPNG/triangulosI.png");
		ImageIcon nuevoIconoI = new ImageIcon(imagenFondoI.getImage().getScaledInstance(271,259,Image.SCALE_AREA_AVERAGING));
		
		ImageIcon imagenFondoT =  new ImageIcon("src/ImagenesPNG/Ticket.png");
		ImageIcon nuevoIconoT = new ImageIcon(imagenFondoT.getImage().getScaledInstance(271,259,Image.SCALE_AREA_AVERAGING));
		
		fotoTicket = new JLabel("",nuevoIconoT, JLabel.CENTER);
		fotoTicket.setBounds(166, 28, 361, 172);
		contentPane.add(fotoTicket);
		
		restar = new JButton(" - ");
		restar.setFont(new Font("Tahoma", Font.BOLD, 14));
		restar.setForeground(new Color(0, 0, 0));
		restar.setBackground(new Color(255, 255, 255));
		restar.setBounds(243, 218, 58, 44);
		contentPane.add(restar);
		
		sumar = new JButton(" + ");
		sumar.addActionListener(new ActionListener() {
		});
		sumar.setFont(new Font("Tahoma", Font.BOLD, 12));
		sumar.setBackground(new Color(255, 255, 255));
		sumar.setBounds(384, 219, 58, 44);
		contentPane.add(sumar);
		
		mensajeEscoja = new JLabel("Escoja el numero de tickets que desee");
		mensajeEscoja.setForeground(new Color(100, 149, 237));
		mensajeEscoja.setFont(new Font("Tahoma", Font.ITALIC, 12));
		mensajeEscoja.setBounds(243, 274, 256, 14);
		contentPane.add(mensajeEscoja);
		
		JButton continuar = new JButton("Continuar");
		continuar.setBackground(new Color(255, 255, 255));
		continuar.setBounds(553, 343, 89, 23);
		contentPane.add(continuar);
		
		JLabel mensajeYaQueda = new JLabel("Ya queda menos...");
		mensajeYaQueda.setFont(new Font("Tahoma", Font.ITALIC, 14));
		mensajeYaQueda.setBounds(408, 343, 135, 23);
		contentPane.add(mensajeYaQueda);
		
		JLabel lcantidad = new JLabel("1");
		lcantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lcantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lcantidad.setForeground(Color.BLACK);
		lcantidad.setBackground(new Color(192, 192, 192));
		lcantidad.setBounds(316, 219, 58, 44);
		contentPane.add(lcantidad);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(57, 343, 89, 23);
		contentPane.add(btnAtras);
		
		JLabel LabeltriangulosD = new JLabel("",nuevoIcono,JLabel.CENTER);		
		LabeltriangulosD.setBounds(487, 171, 271, 259);
		contentPane.add(LabeltriangulosD);
		
		JLabel LabeltriangulosI = new JLabel("", nuevoIconoI,JLabel.CENTER);
		LabeltriangulosI.setBounds(-55, 171, 271, 259);
		contentPane.add(LabeltriangulosI);
		
		//EVENTOS DE SELECCION DE CANTIDAD
		sumar.addActionListener(e -> {
			
			//NO SE PUEDEN MAS DE DIEZ DE LA MISMA
			int cantidadActual = Integer.parseInt(lcantidad.getText());
			
			if(cantidadActual<10) {
				cantidadActual++;
				lcantidad.setText(cantidadActual+"");
				
			}else {
				
				JOptionPane.showMessageDialog( null, "No se pueden selccionar mas de 10 billetes", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		
		});
		
		
		//EVENTOS DE SELECCION DE CANTIDAD
		restar.addActionListener(e -> {
			
			//NO SE PUEDEN MAS DE DIEZ DE LA MISMA
			int cantidadActual = Integer.parseInt(lcantidad.getText());
			
			if(cantidadActual>1) {
				cantidadActual--;
				lcantidad.setText(cantidadActual+"");
				
			}else {
				
				JOptionPane.showMessageDialog( null, "No se pueden selccionar menos de 1 billete", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		
		});
		
		//ATRAS
		
		btnAtras.addActionListener(e -> {
			VentanaMenu m = new VentanaMenu(usuarioActual);
			m.setVisible(true);
			dispose();
		});
		
		
		//CONTINUAMOS
		
		continuar.addActionListener(e -> {
			//OBTENEMOS LA CANTIDAD
			int cantidad = Integer.parseInt(lcantidad.getText());
			
			//COMPROBAMOS SI LA CANTIDAD ES VALIDA CON LAS PLAZAS RESTANTES
			
			boolean valido =false;
			int plazasRestantes= -1;
			
			if(servicio instanceof Vuelo) {
				int plazasServ = ((Vuelo) servicio).getPlazasRestantes();
				plazasRestantes=plazasServ;
				if(cantidad<=plazasServ) {
					valido=true;
				}
				
			} else {
				
				if(servicio instanceof Bus) {
					int plazasServ = ((Bus) servicio).getPlazasRestantes();
					plazasRestantes=plazasServ;
					if(cantidad<=plazasServ) {
						valido=true;
					}
				
				
			}else {
				
				int plazasServ = ((ViajeCombinado) servicio).getPlazasRestantes();
				plazasRestantes=plazasServ;
				if(cantidad<=plazasServ) {
					valido=true;
				}
			}
			}
				
				
				
				if(valido==true) {
					
				
				
			Date fechaEnDate = new Date(System.currentTimeMillis());
			String fechaActual = SDF_FECHA_FOTO.format(fechaEnDate);
			//SI ES UN BUS, DE LA MISMA YA PODEMOS ESCRIBIRLO EN LA BASE DE DATOS
			if(servicio instanceof Bus ) {
				
				//CREAMOS EL BUS COMPRADO con un codigo de compra que lo actualizaremos al insertarlo en la BD, ya que tiene codigo
				//AUTOINCREMENTADO
				
				BusComprado busComprado = new BusComprado(usuarioActual.getCodigo(),cantidad,fechaActual,1, TipoServicio.bus, (Bus) servicio );
				
				//ACCEDEMOS A LA VENTANA DE METODO DE PAGO
				BDServicio.log(Level.INFO, "Accediendo a la ventana de METODO DE PAGO, para pagar el bus", null);
				VentanaMetodoPago vent = new VentanaMetodoPago(usuarioActual,busComprado,servicio);
				vent.setVisible(true);
				dispose();
			}
			else {
				if(servicio instanceof Vuelo) {
					//CREAMOS VENTANA CON LOS SERVICIO ADICIONALES
					BDServicio.log(Level.INFO, "Accediendo a la ventana de servicios adicionales de vuelo", null);
					Vuelo vuelo = (Vuelo) servicio;
					VentanaServicioAdicional vent = new VentanaServicioAdicional (usuarioActual,vuelo,cantidad);
					vent.setVisible(true);
					dispose();
					
					
				}
				
				else {
					ViajeCombinadoComprado viaj = new ViajeCombinadoComprado(usuarioActual.getCodigo(),cantidad,fechaActual, TipoServicio.viajeCombinado,1, (ViajeCombinado) servicio );
					System.out.println(viaj.getPrecio());
					BDServicio.log(Level.INFO, "Accediendo a la ventana de METODO DE PAGO, para pagar el Viaje Combinado", null);
					VentanaMetodoPago vent = new VentanaMetodoPago(usuarioActual,viaj,servicio);
					vent.setVisible(true);
					dispose();
	
				}
	
			}
				
			
		}else {
			
			JOptionPane.showMessageDialog( null, "Solo disponibles: "+ plazasRestantes+" plazas", "ERROR", JOptionPane.ERROR_MESSAGE);
			
		}

		});	
	}
}