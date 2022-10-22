package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import erm.dataBase.DBException;
import erm.ventanasPrimarias.VentanaRegistro;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.BindException;
import java.awt.event.ActionEvent;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrarse.setBounds(179, 308, 112, 23);
		contentPane.add(btnRegistrarse);
		
		JButton btnLogin = new JButton("Iniciar Sesion");
		btnLogin.setBounds(395, 308, 124, 23);
		contentPane.add(btnLogin);
		
		
		btnRegistrarse.addActionListener(e -> {
			VentanaRegistro vr = null;
			vr = new VentanaRegistro();
			vr.setVisible(true);
			dispose();
		});

		
	}

}























