package VentanasRegistro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import BD.BDRegistro;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.Icon;
import javax.swing.SwingConstants;


public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	
	
	public  VentanaInicio () {
		inicializar();

	}

	private void inicializar() {
		
		
		//CREAMOS LA VENTANA DE FONDO
		
		VentanaFondo ventF = new VentanaFondo();
		ventF.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null); 

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRegistrarse = new JButton("");
		btnRegistrarse.setBackground(new Color(255, 255, 255));
		btnRegistrarse.setIcon(new ImageIcon("imagenes//iconoRegistro.png"));
		btnRegistrarse.setBounds(232, 316, 53, 54);
		contentPane.add(btnRegistrarse);

		JButton btnIniciarSesion = new JButton("");
		btnIniciarSesion.setBackground(new Color(255, 255, 255));
		btnIniciarSesion.setIcon(new ImageIcon("imagenes//iconoLogin.png"));
		btnIniciarSesion.setBounds(403, 316, 53, 54);
		contentPane.add(btnIniciarSesion);

		JLabel lblBienvenido = new JLabel("Bienvenid@!");
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBienvenido.setForeground(new Color(255, 128, 0));
		lblBienvenido.setBounds(283, 21, 127, 71);
		contentPane.add(lblBienvenido);
		
		JButton btnDescripcion = new JButton("Conocenos!");
		btnDescripcion.setBounds(507, 35, 135, 23);
		contentPane.add(btnDescripcion);
		
		JLabel LabelRegistrarse = new JLabel("Registrarse");
		LabelRegistrarse.setFont(new Font("Tahoma", Font.ITALIC, 14));
		LabelRegistrarse.setBounds(226, 378, 92, 17);
		contentPane.add(LabelRegistrarse);
		
		JLabel LabelIniciarSesion = new JLabel("Iniciar Sesion");
		LabelIniciarSesion.setFont(new Font("Tahoma", Font.ITALIC, 14));
		LabelIniciarSesion.setBounds(391, 378, 108, 17);
		contentPane.add(LabelIniciarSesion);
		
		ImageIcon imagenFondo =  new ImageIcon("src/ImagenesPNG/triangulosD.png");
		ImageIcon nuevoIcono = new ImageIcon(imagenFondo.getImage().getScaledInstance(271,259,Image.SCALE_AREA_AVERAGING));
		
		JLabel LabeltriangulosD = new JLabel("",nuevoIcono,JLabel.CENTER);		
		LabeltriangulosD.setBounds(487, 171, 271, 259);
		contentPane.add(LabeltriangulosD);
		
		ImageIcon imagenFondoI =  new ImageIcon("src/ImagenesPNG/triangulosI.png");
		ImageIcon nuevoIconoI = new ImageIcon(imagenFondoI.getImage().getScaledInstance(271,259,Image.SCALE_AREA_AVERAGING));
		
		JLabel LabeltriangulosI = new JLabel("", nuevoIconoI,JLabel.CENTER);
		LabeltriangulosI.setBounds(-55, 171, 271, 259);
		contentPane.add(LabeltriangulosI);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("imagenes\\logo.jpeg"));
		lblNewLabel.setBounds(26, 38, 594, 373);
		contentPane.add(lblNewLabel);
		
		Date fecha = new Date(System.currentTimeMillis());
		BDRegistro.log(Level.INFO, "Iniciando aplicacion T&T, en hora: " +fecha , null);
		

		btnRegistrarse.addActionListener(e -> {
			BDRegistro.log(Level.INFO, "Accediendo a REGISTRO" , null);
			VentanaRegistro vr = null;
			vr = new VentanaRegistro();
			vr.setVisible(true);
			dispose();
		});

		btnIniciarSesion.addActionListener(e -> {
			BDRegistro.log(Level.INFO, "Accediendo a Inicio de sesion" , null);
			VentanaLogin vr = null;
			vr = new VentanaLogin();
			vr.setVisible(true);
			dispose();
		});
		
		btnDescripcion.addActionListener(e -> {
			BDRegistro.log(Level.INFO, "Accediendo a la descripcion de T&T" , null);
			
			VentanaDescripcion vr = null;
			vr = new VentanaDescripcion();
			vr.setVisible(true);
		});

	}
}


