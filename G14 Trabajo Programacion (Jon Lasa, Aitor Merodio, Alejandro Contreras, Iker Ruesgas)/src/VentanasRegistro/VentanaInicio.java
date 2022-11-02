package VentanasRegistro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import BD.BD;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	
	

	
	
	public  VentanaInicio () {
		inicializar();

	}

	private void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRegistrarse = new JButton("");
		btnRegistrarse.setBackground(new Color(255, 255, 255));
		btnRegistrarse.setIcon(new ImageIcon("imagenes//iconoRegistro.png"));
		btnRegistrarse.setBounds(232, 329, 53, 54);
		contentPane.add(btnRegistrarse);

		JButton btnIniciarSesion = new JButton("");
		btnIniciarSesion.setBackground(new Color(255, 255, 255));
		btnIniciarSesion.setIcon(new ImageIcon("imagenes//iconoLogin.png"));
		btnIniciarSesion.setBounds(403, 329, 53, 54);
		contentPane.add(btnIniciarSesion);

		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBienvenido.setForeground(new Color(255, 128, 0));
		lblBienvenido.setBounds(286, 35, 127, 71);
		contentPane.add(lblBienvenido);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("imagenes\\logo.jpeg"));
		lblNewLabel.setBounds(27, 56, 594, 373);
		contentPane.add(lblNewLabel);
		
		JButton btnDescripcion = new JButton("Conocenos");
		btnDescripcion.setBounds(502, 11, 135, 23);
		contentPane.add(btnDescripcion);

		btnRegistrarse.addActionListener(e -> {
			VentanaRegistro vr = null;
			vr = new VentanaRegistro();
			vr.setVisible(true);
			dispose();
		});

		btnIniciarSesion.addActionListener(e -> {
			VentanaLogin vr = null;
			vr = new VentanaLogin();
			vr.setVisible(true);
			dispose();
		});
		
		btnDescripcion.addActionListener(e -> {
			VentanaDescripcion vr = null;
			vr = new VentanaDescripcion();
			vr.setVisible(true);
		});

	}
}

