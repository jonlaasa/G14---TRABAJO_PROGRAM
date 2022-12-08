package VentanasCompra;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.BusComprado;
import Datos.Compra;
import Datos.Servicio;
import Datos.Usuario;
import VentanasMenu.VentanaMenu;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class VentanaConfirmacionCompra extends JFrame {

	private JPanel contentPane;
	
	
	public VentanaConfirmacionCompra(Usuario usuarioActual ,Compra compra,Servicio serv) {
		
		inicializar(usuarioActual,compra,serv );
	}


	private void inicializar(Usuario usuarioActual ,Compra compra,Servicio serv) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel mconf = new JLabel("CONFIRMACION DE LA COMPRA");
		mconf.setForeground(new Color(255, 128, 0));
		mconf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mconf.setBounds(222, 31, 335, 40);
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
		}
		
		
		JLabel mUsu = new JLabel("USUARIO: "+nUsua);
		mUsu.setForeground(new Color(255, 128, 0));
		mUsu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mUsu.setBounds(281, 71, 335, 40);
		contentPane.add(mUsu);
		
		JButton bMenu = new JButton("VOLVER AL MENU");
		bMenu.setBounds(512, 337, 132, 33);
		contentPane.add(bMenu);
		
		JLabel mServ = new JLabel("SERVICIO COMPRADO: "+nServicio);
		mServ.setForeground(new Color(255, 128, 0));
		mServ.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mServ.setBounds(20, 103, 335, 40);
		contentPane.add(mServ);
		
		JLabel mOrigen = new JLabel("ORIGEN: "+origen);
		mOrigen.setForeground(new Color(255, 128, 0));
		mOrigen.setFont(new Font("Tahoma", Font.PLAIN, 11));
		mOrigen.setBounds(20, 169, 292, 23);
		contentPane.add(mOrigen);
		
		JLabel mDestino = new JLabel("DESTINO: "+destino);
		mDestino.setForeground(new Color(255, 128, 0));
		mDestino.setFont(new Font("Tahoma", Font.PLAIN, 11));
		mDestino.setBounds(20, 205, 292, 23);
		contentPane.add(mDestino);
		
		JLabel mFecha = new JLabel("FECHA: "+fecha);
		mFecha.setForeground(new Color(255, 128, 0));
		mFecha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		mFecha.setBounds(20, 239, 292, 23);
		contentPane.add(mFecha);
		
		JLabel mHora = new JLabel("HORA SALIDA: "+hora);
		mHora.setForeground(new Color(255, 128, 0));
		mHora.setFont(new Font("Tahoma", Font.PLAIN, 11));
		mHora.setBounds(20, 273, 292, 23);
		contentPane.add(mHora);
		
		JLabel mCantidad = new JLabel("CANTIDAD: "+cantidad );
		mCantidad.setForeground(new Color(255, 128, 0));
		mCantidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		mCantidad.setBounds(368, 169, 292, 23);
		contentPane.add(mCantidad);
		
		JLabel mPrecio = new JLabel("PRECIO: "+precio);
		mPrecio.setForeground(new Color(255, 128, 0));
		mPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		mPrecio.setBounds(368, 226, 292, 23);
		contentPane.add(mPrecio);
		
		
		
		//EVENTOS DE BOTON
		
		//RETORNO AL MENU CON BOTON Y MISMO USUARIO
		
		bMenu.addActionListener(e -> {
			
			
			VentanaMenu vent = new VentanaMenu(usuarioActual);
			vent.setVisible(true);
	
			
		});
		
		
		
	}
}
