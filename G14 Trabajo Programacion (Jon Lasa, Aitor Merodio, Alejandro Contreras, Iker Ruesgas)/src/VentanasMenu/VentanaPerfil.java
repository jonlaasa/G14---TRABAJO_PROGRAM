package VentanasMenu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.Usuario;
import VentanasRegistro.VentanaDescripcion;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class VentanaPerfil extends JFrame {

	private JPanel contentPane;


	public VentanaPerfil(Usuario usrActual) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 350, 500, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(59, 87, 79, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidos.setBounds(59, 128, 79, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblMostrarUsuario = new JLabel(usrActual.getNombre());
		lblMostrarUsuario.setBounds(157, 87, 110, 14);
		contentPane.add(lblMostrarUsuario);
		
		
		
		JLabel lblMostrarApellidos = new JLabel(usrActual.getApellido());
		lblMostrarApellidos.setBounds(157, 128, 120, 14);
		contentPane.add(lblMostrarApellidos);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDni.setBounds(59, 165, 46, 14);
		contentPane.add(lblDni);
		
		JLabel lblMostrarDni = new JLabel(usrActual.getDni());
		lblMostrarDni.setBounds(157, 165, 120, 14);
		contentPane.add(lblMostrarDni);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMail.setBounds(59, 203, 73, 14);
		contentPane.add(lblMail);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(199, 263, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lblMostrarMail = new JLabel(usrActual.getCorreoElectronico());
		lblMostrarMail.setBounds(157, 199, 132, 23);
		contentPane.add(lblMostrarMail);
		
		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setForeground(new Color(255, 128, 0));
		lblPerfil.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPerfil.setBounds(215, 33, 52, 23);
		contentPane.add(lblPerfil);
		
		JLabel lblPuntos = new JLabel("PUNTOS T&T");
		lblPuntos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPuntos.setBounds(328, 87, 110, 14);
		contentPane.add(lblPuntos);
		
		
		
		JLabel lblMostrarPuntos = new JLabel(String.valueOf(usrActual.getPuntos()));
		lblMostrarPuntos.setForeground(new Color(0, 255, 255));
		lblMostrarPuntos.setFont(new Font("Tahoma", Font.PLAIN, 53));
		lblMostrarPuntos.setBounds(345, 87, 156, 173);
		contentPane.add(lblMostrarPuntos);
		
		btnVolver.addActionListener(e->{
			VentanaMenu vr = null;
			vr = new VentanaMenu(usrActual);
			vr.setVisible(true);
			dispose();
			
		});
		
		
		
	}
}
