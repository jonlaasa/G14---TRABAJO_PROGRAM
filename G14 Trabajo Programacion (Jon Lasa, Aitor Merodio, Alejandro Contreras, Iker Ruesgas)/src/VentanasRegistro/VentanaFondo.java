package VentanasRegistro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

public class VentanaFondo extends JFrame {

	private JPanel contentPane;

	public VentanaFondo() {
		
		inicializar();
	}

	private void inicializar() {
		// TODO Auto-generated method stub
		
		//TAMAÑO DE LA VENTANA DE FONDO
		Toolkit tk=Toolkit.getDefaultToolkit(); //Initializing the Toolkit class.
		Dimension screenSize = tk.getScreenSize(); //Get the Screen resolution of our device.
		this.setSize(screenSize.width,screenSize.height);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		
		
		JLabel background;
		
		ImageIcon imgIcon = new ImageIcon("imagenes//ft2.jpg");
		Image image = imgIcon.getImage();
		Image imagenModificada = image.getScaledInstance(screenSize.width,screenSize.height,Image.SCALE_SMOOTH);
		ImageIcon nuevoIcono = new ImageIcon(imagenModificada);
		background = new JLabel ("",nuevoIcono,JLabel.CENTER);
		background.setBounds(0,0,1350,700);
		add(background);
		
		

	
	
	}
}
