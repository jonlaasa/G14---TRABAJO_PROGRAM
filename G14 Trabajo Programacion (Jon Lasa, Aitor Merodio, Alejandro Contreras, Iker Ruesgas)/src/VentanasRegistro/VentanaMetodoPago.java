package VentanasRegistro;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BD.BDRegistro;
import BD.BDServicio;
import Datos.BusComprado;
import Datos.Compra;
import Datos.Servicio;
import Datos.Usuario;
import Datos.ViajeCombinadoComprado;
import Datos.VueloComprado;
import VentanasCompra.VentanaBus;
import VentanasCompra.VentanaConfirmacionCompra;
import logicaDeNegocio.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;

public class VentanaMetodoPago extends JFrame {

	private JPanel contentPane;
	private JTextField titularTarjeta;
	private JTextField direccion;
	private JTextField ciudad;
	private JTextField codigoPostal;
	private JTextField numeroTarjeta;
	private JTextField fechaCaducidad;
	private JTextField codigoSeguridad;
	
	
	public VentanaMetodoPago (Usuario usuarioActual, Compra compra,Servicio serv) {
		
		inicializar(usuarioActual,compra,serv );
	}

	private void  inicializar(Usuario usuarioActual, Compra compra,Servicio serv) {
		
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null); 

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
		
		JButton pagarConMetodo = new JButton("PAGAR CON TARJETA");
		pagarConMetodo.setForeground(new Color(255, 128, 64));
		pagarConMetodo.setBounds(512, 318, 162, 46);
		contentPane.add(pagarConMetodo);
		
		JButton atras = new JButton("Atras");
		atras.setBounds(66, 377, 86, 23);
		contentPane.add(atras);
		
		JButton pagarConPuntos = new JButton("PAGAR CON PUNTOS");
		pagarConPuntos.setForeground(new Color(255, 128, 64));
		pagarConPuntos.setBounds(349, 319, 153, 45);
		contentPane.add(pagarConPuntos);
		
		ArrayList <String> valoresProperties = new ArrayList<String> ();
		///FICHERO PROPERTIES QUE GUARDA LOS DATOS ANTERIORES!!!
		try {
			FileReader fd = new FileReader("usuariosPago.txt");
			BufferedReader br = new BufferedReader(fd);
			String linea;
			linea=br.readLine();
			if(linea.equals(usuarioActual.getNombreUsuario())) {
				
			while ((linea=br.readLine())!=null) {
					valoresProperties.add(linea);
	
				}
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		
		
		if(valoresProperties.size()!=0) {
			codigoSeguridad.setText(valoresProperties.get(6));
			fechaCaducidad.setText(valoresProperties.get(5));
			numeroTarjeta.setText(valoresProperties.get(4));
			codigoPostal.setText(valoresProperties.get(3));
			ciudad.setText(valoresProperties.get(2));
			direccion.setText(valoresProperties.get(1));
			titularTarjeta.setText(valoresProperties.get(0));
			
			
			
		}

		
		///UNA VEZ YA HEMOS LEIDO EL FICHERO LO IMPRIMIMOS PARA VERLO
		
		System.out.println(valoresProperties);
		
		
		//EVENTOS
		
		// EL PRECIO DE LA COMPRA (LO NECESITAREMOS EN VARIAS OCASIONES

		
		atras.addActionListener(e-> {
			
			//VOLVEMOS A ABRIR LA VENTANA DE COMPRA DE BUSES CON EL USUARIO ACTUAL
			VentanaBus vent = new VentanaBus(usuarioActual);
			vent.setVisible(true);
			dispose();		
		});
		
		ArrayList<String> listaParaEscribir = new 	ArrayList<String>();
		
		
		//EVENTO DE CONFIRMAR
		pagarConMetodo.addActionListener(e-> {
			
		//LEEMOS TODOS LOS VALORES Y LOS COMPROBAMOS SI SON CORRECTOS (CUMPLEN UNAS CARACTERISTICAS)
			
			String nombreTitular= titularTarjeta.getText();
			String direc= direccion.getText();
			String ciu = ciudad.getText();
			String cd = codigoPostal.getText();
			String numT = numeroTarjeta.getText();
			String feC = fechaCaducidad.getText();
			String codS = codigoSeguridad.getText();
			
			
			
			//llamamos al metodo de escritura
			
			escribirFicheroProperties(listaParaEscribir, usuarioActual);
			
			
			try {
				
				
				Utils.comprobarString(nombreTitular);
				Utils.comprobarString(direc);
				Utils.comprobarString(ciu);
				Utils.comprobarString(cd);
				Utils.comprobarString(codS);
				Utils.comprobarString(feC);
				Utils.comprobarString(numT);
				Utils.comprobarNumerosConLongitud(cd, 5,"Codigo Postal");			
				Utils.comprobarNumeroTarjeta(numT,"Numero de Tarjeta");
				Utils.comprobarFechaCaducidad(feC,"Fecha de Caducidad");
				Utils.comprobarNumerosConLongitud(codS, 3,"Codigo de Seguridad");
				
	
				
				
				listaParaEscribir.add(nombreTitular);
				listaParaEscribir.add(nombreTitular);
				listaParaEscribir.add(ciu);
				listaParaEscribir.add(cd);
				listaParaEscribir.add(numT);
				listaParaEscribir.add(feC);
				listaParaEscribir.add(codS);
				
				escribirFicheroProperties(listaParaEscribir, usuarioActual);
				
				
				//SI SE CUMPLEN??? //PRIMERO ESCRIBIMOS LA COMPRA EN LA BASE DE DATOS
				BDServicio.escribirCompra(compra,BDServicio.baseDatosServicio);
				
				//AHORA ACTUALIZAMOS LOS PUNTOS
				 double  precioCompra =0;
					
					if(compra instanceof VueloComprado) {
						 precioCompra = ((VueloComprado) compra).getPrecio();
					}else {
						if(compra instanceof BusComprado) {
						 precioCompra = ((BusComprado) compra).getPrecio();
					}else {
						 //VIAJE COMBINADO
						precioCompra= ((ViajeCombinadoComprado) compra).getPrecio();
					}
					}
				
				//CONSEGUIMOS CUANTOS DEBERIA CONSEGUIR
				int puntosObtenidos = (int) Math.floor(precioCompra/10);
			    int puntosAnteriores = BDRegistro.obtenerPuntos(usuarioActual.getCodigo(),BDRegistro.baseDatos);
			    int puntosAnyadir = puntosAnteriores+puntosObtenidos;
			 
			
				
				//ACTUALIZAMOS
			   
				
				
			    BDRegistro.actualizarPuntos(usuarioActual.getCodigo(), puntosAnyadir,BDRegistro.baseDatos);

				
				//DESPUES PASAMOS A LA VENTANA DE CONFIRMACION DE LA COMPRA
				
				VentanaConfirmacionCompra vent = new VentanaConfirmacionCompra(usuarioActual, compra, serv);
				vent.setVisible(true);
				dispose();
		
			}catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
		});
		
		
		
		//EVENTO DE PAGAR CON PUNTOS
		
	pagarConPuntos.addActionListener(e -> {
		
		
		//UNA VEZ TENEMOS EL PRECIO, OBTENEMOS LOS PUNTOS QUE TIENE Y EL DINERO QUE ELLO IMPLICA 
		
		
		
		 double  precioCompra =0;
			
			if(compra instanceof VueloComprado) {
				 precioCompra = ((VueloComprado) compra).getPrecio();
			}else {
				if(compra instanceof BusComprado) {
				 precioCompra = ((BusComprado) compra).getPrecio();
			}else {
				 //VIAJE COMBINADO
			}
			}
			
			
			int puntosUsuario = BDRegistro.obtenerPuntos(usuarioActual.getCodigo(),BDRegistro.baseDatos);
			double dineroConPuntos = puntosUsuario;
			
			System.out.println("PUNTOS ACTUALES: "+puntosUsuario + " LA COMPRA VALE"+precioCompra);
			if(dineroConPuntos >= precioCompra) {
				
				//ENTONCES SI ES VALIDO Y AVANZAMOS (ESCRIBIMOS COMPRA EN BASE DE DATOS)
				BDServicio.log(Level.INFO, "COMPRA PAGADA CON PUNTOS, POR EL USUARIO: "+usuarioActual.getNombreUsuario(), null);
	            BDServicio.escribirCompra(compra,BDServicio.baseDatosServicio);
	            
	            //AHORA RESTAMOS LOS QUE HAYA UTILIZADO
	
	            double precioRestante = dineroConPuntos - precioCompra;
	            int puntos = (int)Math.floor(precioRestante);
	            
	            System.out.println("PUNTOS ACTUALES: "+puntos + " LA COMPRA VALE"+precioCompra);
	            
	            //ACTUALIZAMOS PUNTOS EN LA BD
	            
	            BDRegistro.actualizarPuntos(usuarioActual.getCodigo(), puntos,BDRegistro.baseDatos);
				//DESPUES PASAMOS A LA VENTANA DE CONFIRMACION DE LA COMPRA
				
				VentanaConfirmacionCompra vent = new VentanaConfirmacionCompra(usuarioActual, compra, serv);
				vent.setVisible(true);
				dispose();
				
				
			}
			else {
				
				//MENSAJE DE ERROR
				BDServicio.log(Level.INFO, "INTENTO DE PAGAR CON PUNTOS, PERO NO TIENE LOS SUFICIENTES EL USUARIO: "+usuarioActual.getNombreUsuario(), null);
				JOptionPane.showMessageDialog(null, "NO TIENES LOS PUNTOS SUFICIENTES! Tienes:" + dineroConPuntos +" euros en puntos y la compra vale: "+precioCompra ,"ERROR",JOptionPane.ERROR_MESSAGE);
				
				
				
			}
			
	});
	
	}
	
	
	public static void escribirFicheroProperties(ArrayList<String> valoresActuales,Usuario usuarioActual) {
	
		try{
			  FileWriter fw=new FileWriter("usuariosPago.txt" );
		     fw.write(usuarioActual.getNombreUsuario()+"\n");
				
		     for(String valor:valoresActuales) {
		 		fw.write(valor+"\n");
		 		System.out.println(valor);
		 		}

		     // Hay que cerrar el fichero
		     fw.close();
		  } catch (IOException ioe){
		     ioe.printStackTrace();
		  }
	
		
	}
}
