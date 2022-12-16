package VentanasCompra;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.BDServicio;
import Datos.BusComprado;
import Datos.Compra;
import Datos.RentingCoche;
import Datos.Servicio;
import Datos.Usuario;
import Datos.Vuelo;
import Datos.VueloComprado;
import Enum.ClaseCoche;
import Enum.TipoServicio;
import Enum.ZonaAsientoVuelo;
import VentanasMenu.VentanaMenu;
import VentanasRegistro.VentanaMetodoPago;

import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class VentanaServicioAdicional extends JFrame {

	private JPanel contentPane;
	private final static SimpleDateFormat SDF_FECHA_FOTO = new SimpleDateFormat("yyyy/MM/dd");
	
	
	public VentanaServicioAdicional(Usuario usuarioActual, Vuelo vuelo, int cantidad) {
		
		inicializar(usuarioActual,vuelo, cantidad);
	}


	private void inicializar(Usuario usuarioActual ,Vuelo vuelo, int cantidad) {
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SERVICIOS ADICIONALES PARA VUELO");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(206, 11, 326, 42);
		contentPane.add(lblNewLabel);
		
		//LLENAMOS EL COMBO CON LAS OPCIONES
		String [] listaZonas = new String [] {"ZONA TRASERA (+0 EU)","ZONA CENTRAL (+10 EU)", "ZONA DELANTERA (+30 EU)"};
		JComboBox comboAsiento = new JComboBox(listaZonas);
		comboAsiento.setBounds(38, 106, 150, 22);
		contentPane.add(comboAsiento);
		
	
		JLabel lblNewLabel_1 = new JLabel("SELECCION DE ZONA DE ASIENTO");
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setBounds(28, 81, 189, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel imagenAsiento = new JLabel("");
		imagenAsiento.setBounds(299, 59, 347, 85);
		contentPane.add(imagenAsiento);
		imagenAsiento.setIcon(new ImageIcon("imagenes//asientoo.jpg"));
		
		JLabel mRenting = new JLabel("SERVICIO DE RENTING DE COCHE (OPCIONAL) RECOGER EL COCHE CUANDO QUIERA, EN EL AEROPUERTO DESTINO");
		mRenting.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		mRenting.setForeground(new Color(255, 128, 0));
		mRenting.setBounds(28, 164, 618, 27);
		contentPane.add(mRenting);
		
		//LLENAMOS EL COMBO DE OPCIONES (3 CLASE/GAMAS POSIBLES)
		String [] listaClase = new String [] {"NINGUNO","GAMA BAJA","GAMA MEDIA","GAMA ALTA"};
		JComboBox comboOpcion = new JComboBox(listaClase);
		comboOpcion.setBounds(28, 343, 127, 22);
		contentPane.add(comboOpcion);
		
		JLabel mClase = new JLabel("OPCION ESCOGIDA");
		mClase.setForeground(new Color(255, 128, 0));
		mClase.setBounds(28, 318, 127, 14);
		contentPane.add(mClase);
		
		JLabel lblNumeroDeDias = new JLabel("NUMERO DE DIAS");
		lblNumeroDeDias.setForeground(new Color(255, 128, 0));
		lblNumeroDeDias.setBounds(184, 318, 127, 14);
		contentPane.add(lblNumeroDeDias);
		
		String [] listaDias = new String [] {"1","2","3","4","5","6","7","8","9"};
		
		JComboBox comboDias = new JComboBox(listaDias);
		comboDias.setBounds(194, 343, 73, 22);
		contentPane.add(comboDias);
		
		JButton continuar = new JButton("CONTINUAR");
		continuar.setBounds(448, 343, 109, 23);
		contentPane.add(continuar);
		
		JButton atras = new JButton("ATRAS");
		atras.setBounds(581, 347, 81, 18);
		contentPane.add(atras);
		
		JLabel mGama = new JLabel("GAMA BAJA");
		mGama.setBounds(91, 289, 81, 22);
		contentPane.add(mGama);
		
		JLabel mGamaM = new JLabel("GAMA MEDIA");
		mGamaM.setBounds(307, 289, 81, 22);
		contentPane.add(mGamaM);
		
		JLabel mGamaA = new JLabel("GAMA ALTA");
		mGamaA.setBounds(497, 289, 81, 22);
		contentPane.add(mGamaA);
		
		JLabel fotoGamaB = new JLabel("");
		fotoGamaB.setBounds(10, 193, 206, 97);
		contentPane.add(fotoGamaB);
		
		fotoGamaB.setIcon(new ImageIcon("imagenes//coche1.jpg"));
		
		JLabel fotoGamaM = new JLabel("");
		fotoGamaM.setBounds(206, 193, 227, 97);
		contentPane.add(fotoGamaM);
		
		fotoGamaM.setIcon(new ImageIcon("imagenes//coche2.jpg"));
		
		JLabel fotoGamaA = new JLabel("");
		fotoGamaA.setBounds(422, 193, 252, 97);
		contentPane.add(fotoGamaA);
		
		fotoGamaA.setIcon(new ImageIcon("imagenes//coche3.jpg"));
		
		
		
		
		//EVENTOS
		atras.addActionListener(e -> {
			//VOLVEMOS A LA VENTANA DE SELECCCION DE CANTIDAD DE BILLETES
			
			VentanaBilletes vent = new VentanaBilletes(usuarioActual, vuelo);
			vent.setVisible(true);
			
			
		});
		
		
		continuar.addActionListener(e -> {
			//EVENTO DE CONTINUAR
			//PRIMERO LEEMOS LOS VALORES 
			
			//EMPEZAMOS CON LA ZONA DE ASIENTO
			String zonaAsiento = comboAsiento.getSelectedItem().toString();
			ZonaAsientoVuelo zonaEnum = null;
			
			if (zonaAsiento.equals("ZONA TRASERA (+0 EU)")) {
				
				
				zonaEnum=ZonaAsientoVuelo.trasera;
				
			}else {
				if(zonaAsiento.equals("ZONA CENTRAL (+10 EU)")) {
					
					zonaEnum=ZonaAsientoVuelo.central;
				}
				else {
					zonaEnum=ZonaAsientoVuelo.delantera;
				}
			}
			
			//DESPUES OBTENEMOS EL COCHE SELECCIONADO (SI ES ASI)
			
			//Creamos el array (SOLO TENDRA COMO MUCHO UN OBJETO DE LA CLASE RENTING COCHE)
			
			ArrayList<RentingCoche> rentingCoche = new ArrayList<RentingCoche> ();
			//obtenemos el valor del combo de opcion y el numero de dias
			
			String opcionCoche = comboOpcion.getSelectedItem().toString();
			int numDias = Integer.parseInt(comboDias.getSelectedItem().toString());
		
			if(opcionCoche.equals("GAMA BAJA")) {
				
				//CREAMOS COCHE DE ESTA GAMA Y LO INSERTAMOS A LA LISTA
				RentingCoche renting = new RentingCoche (numDias,ClaseCoche.gamaBaja);
				rentingCoche.add(renting);
				
				
			}else {
				if(opcionCoche.equals("GAMA MEDIA")) {
					
					//CREAMOS COCHE DE ESTA GAMA Y LO INSERTAMOS A LA LISTA
					RentingCoche renting = new RentingCoche (numDias,ClaseCoche.gamaMedia);
					rentingCoche.add(renting);
				}else {
					if(opcionCoche.equals("GAMA ALTA")) {
						
						//CREAMOS COCHE DE ESTA GAMA Y LO INSERTAMOS A LA LISTA
						RentingCoche renting = new RentingCoche (numDias,ClaseCoche.gamaAlta);
						rentingCoche.add(renting);
						
					}
				}
			}
			
			
			//UNA VEZ TENEMOS EL PRECIO A ANYADIR Y LA LISTA CON EL COCHE ( EN CASO DE HABER), PODEMOS CREAR EL VUELO COMPRADO
			
			//LA FECHA DE LA COMPRA SERA LA ACTUAL
			Date fechaEnDate = new Date(System.currentTimeMillis());
			String fechaActual = SDF_FECHA_FOTO.format(fechaEnDate);
			
			VueloComprado vueloComprado = new VueloComprado (usuarioActual.getCodigo(),cantidad,fechaActual,TipoServicio.vuelo,
					-1 ,vuelo,rentingCoche, zonaEnum);
			
			//EL PRECIO SE PONE SOLO, CALCULANDO LA SUMA DE LOS SERVICIOS (VUELO + ZONA DE ASIENTO + RENTING)
			
			//AHORA PASAMOS A LA VENTANA DE METODO DE PAGO
			
			
			//ACCEDEMOS A LA VENTANA DE METODO DE PAGO
			BDServicio.log(Level.INFO, "Accediendo a la ventana de METODO DE PAGO, para pagar el vuelo", null);
			VentanaMetodoPago vent = new VentanaMetodoPago(usuarioActual,vueloComprado,vuelo);
			vent.setVisible(true);
			dispose();	
			
		});
		
		
		
		
		
		
		
		
		
		
	}	
}