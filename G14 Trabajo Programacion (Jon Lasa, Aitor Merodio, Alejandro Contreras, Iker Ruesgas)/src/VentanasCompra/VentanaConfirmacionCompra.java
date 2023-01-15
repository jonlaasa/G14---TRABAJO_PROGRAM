package VentanasCompra;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.BusComprado;
import Datos.Compra;
import Datos.Servicio;
import Datos.Usuario;
import Datos.VueloComprado;
import VentanasMenu.VentanaMenu;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VentanaConfirmacionCompra extends JFrame {

	private JPanel contentPane;
	
	
	public VentanaConfirmacionCompra(Usuario usuarioActual ,Compra compra,Servicio serv) {
		
		inicializar(usuarioActual,compra,serv );
	}


	private void inicializar(Usuario usuarioActual ,Compra compra,Servicio serv) {
		 
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel mconf = new JLabel("CONFIRMACION DE LA COMPRA");
		mconf.setBounds(191, 11, 310, 60);
		mconf.setForeground(new Color(255, 128, 0));
		mconf.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(mconf);
		
		
		//EN LOS LABELS PONDREMOS LA INFORMACION CORRESPONDIENTE DE LA COMPRA REALIZADA
		
		//OBTENEMOS DICHOS VALORES
		
		String nUsua = usuarioActual.getNombreUsuario();
		String nServicio = compra.getTipoServicio().toString();
		String origen = serv.getOrigen();
		String destino = serv.getDestino();
		String fecha = serv.getFecha();
		String hora = serv.getHoraSalida();
		String cantidad = compra.getCantidad()+"";
		//CASTEAMOS A LO QUE SEA
		String precio="";
		if (compra instanceof BusComprado) {
			BusComprado busC = (BusComprado) compra;
			precio= busC.getPrecio()+"";
		}else {
			if(compra instanceof VueloComprado) {
				VueloComprado vueloC = (VueloComprado) compra;
				precio = vueloC.getPrecio()+"";
			}
		}
		
		
		JLabel mUsu = new JLabel("USUARIO: "+nUsua);
		mUsu.setBounds(283, 70, 335, 40);
		mUsu.setForeground(new Color(255, 128, 0));
		mUsu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(mUsu);
		
		JButton bMenu = new JButton("VOLVER AL MENU");
		bMenu.setForeground(new Color(255, 128, 64));
		bMenu.setBounds(476, 337, 165, 33);
		contentPane.add(bMenu);
		
		JLabel mServ = new JLabel("SERVICIO COMPRADO: "+nServicio);
		mServ.setBounds(20, 103, 335, 40);
		mServ.setForeground(new Color(255, 128, 0));
		mServ.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(mServ);
		
		JLabel mOrigen = new JLabel("ORIGEN: "+origen);
		mOrigen.setBounds(20, 169, 292, 23);
		mOrigen.setForeground(new Color(255, 128, 0));
		mOrigen.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(mOrigen);
		
		JLabel mDestino = new JLabel("DESTINO: "+destino);
		mDestino.setBounds(20, 205, 292, 23);
		mDestino.setForeground(new Color(255, 128, 0));
		mDestino.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(mDestino);
		
		JLabel mFecha = new JLabel("FECHA: "+fecha);
		mFecha.setBounds(20, 239, 292, 23);
		mFecha.setForeground(new Color(255, 128, 0));
		mFecha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(mFecha);
		
		JLabel mHora = new JLabel("HORA SALIDA: "+hora);
		mHora.setBounds(20, 273, 292, 23);
		mHora.setForeground(new Color(255, 128, 0));
		mHora.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(mHora);
		
		JLabel mCantidad = new JLabel("CANTIDAD: "+cantidad );
		mCantidad.setBounds(368, 169, 292, 23);
		mCantidad.setForeground(new Color(255, 128, 0));
		mCantidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(mCantidad);
		
		JLabel mPrecio = new JLabel("PRECIO: "+precio);
		mPrecio.setBounds(368, 226, 292, 23);
		mPrecio.setForeground(new Color(255, 128, 0));
		mPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(mPrecio);
		
		JLabel tick = new JLabel("");
		tick.setBounds(531, 29, 143, 142);
		tick.setIcon(new ImageIcon("imagenes//tick.jpg"));
		contentPane.add(tick);
		
		
		
		//SI LA VENTANA ES DE VUELO COMPRADO, LE ANYADIMOS LABEL PARA EL RENTING?
		if(compra instanceof VueloComprado) {
			
			VueloComprado vueloComp = (VueloComprado) compra;
			boolean renting =false;
			if(vueloComp.getListaRenting().size()!=0) {
				renting=true;
				
				//Y ADEMAS AÑADIMOS LABELS CON LA CLASE DEL COCHE Y EL NUMERO DE DIAS
				JLabel clase = new JLabel("CLASE DEL COCHE: " + vueloComp.getListaRenting().get(0).getClaseCoche().toString());
				clase.setForeground(new Color(255, 128, 0));
				clase.setBounds(20, 310, 292, 23);
				contentPane.add(clase);

				
				//LO MISMO CON EL NUMERO DE DIAS
				
				JLabel nDias = new JLabel("NUMERO DE DIAS: " + vueloComp.getListaRenting().get(0).getDiasAlquilado());
				nDias.setForeground(new Color(255, 128, 0));
				nDias.setBounds(20, 330, 292, 23);
				contentPane.add(nDias);
				
				
				
			}
			JLabel labelRenting = new JLabel("RENTING: " + renting);
			labelRenting.setForeground(new Color(255, 128, 0));
			labelRenting.setBounds(20, 290, 292, 23);
			contentPane.add(labelRenting);

			
		}
		
		
		
		//EVENTOS DE BOTON
		
		//RETORNO AL MENU CON BOTON Y MISMO USUARIO
		
		bMenu.addActionListener(e -> {
			
			
			VentanaMenu vent = new VentanaMenu(usuarioActual);
			vent.setVisible(true);
			dispose();
			
		});
		
		
		
	}
}
