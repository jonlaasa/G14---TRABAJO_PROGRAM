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

public class VentanaBilletes extends JFrame {
	JButton restar, sumar;
	private JPanel contentPane;
	private JLabel mensajeEscoja;
	private JLabel foto;
	private final static SimpleDateFormat SDF_FECHA_FOTO = new SimpleDateFormat("yyyy/MM/dd");
	
	
	public VentanaBilletes(Usuario usuarioActual, Servicio servicio) {

		setResizable(false);
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		restar = new JButton(" - ");
		restar.setForeground(new Color(0, 0, 0));
		restar.setBackground(new Color(255, 255, 255));
		restar.setBounds(10, 103, 47, 23);
		contentPane.add(restar);
		
		sumar = new JButton(" + ");
		sumar.setBackground(new Color(255, 255, 255));
		sumar.setBounds(144, 103, 47, 23);
		contentPane.add(sumar);
		
		mensajeEscoja = new JLabel("Escoja el n�mero de tickets que desee:");
		mensajeEscoja.setBounds(10, 67, 256, 14);
		contentPane.add(mensajeEscoja);
		
		foto = new JLabel("");
		foto.setIcon(new ImageIcon("imagenes//icons//fotoBilletes.jpg"));
		foto.setBounds(231, 47, 193, 184);
		contentPane.add(foto);
		
		JButton continuar = new JButton("Continuar");
		continuar.setBackground(new Color(255, 255, 255));
		continuar.setBounds(10, 190, 89, 23);
		contentPane.add(continuar);
		
		JLabel mensajeYaQueda = new JLabel("Ya queda menos");
		mensajeYaQueda.setBounds(10, 157, 181, 14);
		contentPane.add(mensajeYaQueda);
		
		JLabel lcantidad = new JLabel("1");
		lcantidad.setBounds(78, 107, 46, 14);
		contentPane.add(lcantidad);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(115, 190, 89, 23);
		contentPane.add(btnAtras);
		
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
			
		});
		
		
		
		
		
	}
}

