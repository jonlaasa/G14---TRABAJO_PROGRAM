package VentanasCompra;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.Bus;
import Datos.BusComprado;
import Datos.Servicio;
import Datos.Usuario;
import Enum.TipoServicio;
import VentanasRegistro.VentanaMetodoPag;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
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
				VentanaMetodoPag vent = new VentanaMetodoPag(usuarioActual,busComprado);
				vent.setVisible(true);
				dispose();
			}
			else {
				
				//AQUI PASAMOS A LA VENTANA DE SELECCIONAR EL RENTING
				
				
			}
			
		});
		
		
		
		
		
	}
}


//}