package VentanasRegistro;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Datos.Servicio;
import Datos.Usuario;

public class VentanaMetodoPago extends JFrame {

	private JPanel contentPane;
	private JTextField titularTarjeta;
	private JTextField direccion;
	private JTextField ciudad;
	private JTextField codigoPostal;
	private JTextField numeroTarjeta;
	private JTextField fechaCaducidad;
	private JTextField codigoSeguridad;
	
	
	
	
	public VentanaMetodoPago (Usuario usuarioActual, Servicio servicio) {
		
		inicializar();
		
	}

	
	private void  inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titular = new JLabel("Titular de la tarjeta:");
		titular.setForeground(new Color(255, 128, 64));
		titular.setFont(new Font("Tahoma", Font.PLAIN, 16));
		titular.setBounds(80, 95, 141, 14);
		contentPane.add(titular);
		
		JLabel introduzca = new JLabel("INTRODUZCA LOS DATOS DEL METODO DE PAGO A UTILIZAR");
		introduzca.setForeground(new Color(255, 128, 64));
		introduzca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		introduzca.setBounds(80, 27, 479, 45);
		contentPane.add(introduzca);
		
		JLabel dir = new JLabel("Direccion:");
		dir.setForeground(new Color(255, 128, 64));
		dir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dir.setBounds(80, 130, 141, 14);
		contentPane.add(dir);
		
		JLabel ciud = new JLabel("Ciudad:");
		ciud.setForeground(new Color(255, 128, 64));
		ciud.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ciud.setBounds(80, 170, 141, 14);
		contentPane.add(ciud);
		
		JLabel codpostal = new JLabel("Codigo postal:");
		codpostal.setForeground(new Color(255, 128, 64));
		codpostal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		codpostal.setBounds(80, 210, 141, 20);
		contentPane.add(codpostal);
		
		JLabel numtarjeta = new JLabel("Numero de tarjeta:");
		numtarjeta.setForeground(new Color(255, 128, 64));
		numtarjeta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		numtarjeta.setBounds(80, 247, 141, 14);
		contentPane.add(numtarjeta);
		
		JLabel fechacad = new JLabel("Fecha de caducidad:");
		fechacad.setForeground(new Color(255, 128, 64));
		fechacad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fechacad.setBounds(80, 290, 153, 14);
		contentPane.add(fechacad);
		
		JLabel codseguridad = new JLabel("Codigo de seguridad");
		codseguridad.setForeground(new Color(255, 128, 64));
		codseguridad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		codseguridad.setBounds(80, 329, 164, 20);
		contentPane.add(codseguridad);
		
		titularTarjeta = new JTextField();
		titularTarjeta.setBounds(254, 94, 120, 20);
		contentPane.add(titularTarjeta);
		titularTarjeta.setColumns(10);
		
		direccion = new JTextField();
		direccion.setColumns(10);
		direccion.setBounds(254, 129, 170, 20);
		contentPane.add(direccion);
		
		ciudad = new JTextField();
		ciudad.setColumns(10);
		ciudad.setBounds(254, 160, 120, 20);
		contentPane.add(ciudad);
		
		codigoPostal = new JTextField();
		codigoPostal.setColumns(10);
		codigoPostal.setBounds(254, 212, 86, 20);
		contentPane.add(codigoPostal);
		
		numeroTarjeta = new JTextField();
		numeroTarjeta.setColumns(10);
		numeroTarjeta.setBounds(254, 246, 170, 20);
		contentPane.add(numeroTarjeta);
		
		fechaCaducidad = new JTextField();
		fechaCaducidad.setColumns(10);
		fechaCaducidad.setBounds(254, 289, 78, 20);
		contentPane.add(fechaCaducidad);
		
		codigoSeguridad = new JTextField();
		codigoSeguridad.setColumns(10);
		codigoSeguridad.setBounds(254, 331, 64, 20);
		contentPane.add(codigoSeguridad);
		
		JButton confirmar = new JButton("Confirmar");
		confirmar.setBounds(438, 336, 121, 39);
		contentPane.add(confirmar);
		

//
	}
}
