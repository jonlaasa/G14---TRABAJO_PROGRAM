package VentanasAdministrador;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BD.BDRegistro;
import Datos.Administrador;
import Datos.Usuario;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class VentanaVerUsuarios extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modeloTabla;
	private JTable tableUsr;
	private ArrayList<Usuario> listaUsr;


	public VentanaVerUsuarios(Administrador adminActual) throws SQLException {
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		modeloTabla = new DefaultTableModel( new Object [] {
				"Id","Nombre","Apellidos","Usuario","DNI","Puntos T&T","Mail"},0);
		
		tableUsr = new JTable(modeloTabla);
		tableUsr.setBounds(398, 290, -226, -173);
		contentPane.add(tableUsr);
		
		JScrollPane scroll = new JScrollPane(tableUsr,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(51, 79, 574, 260);
		contentPane.add(scroll);
		
		JButton btnVolver = new JButton("Menu Principal");
		btnVolver.setBounds(258, 363, 134, 23);
		contentPane.add(btnVolver);
		
		JLabel lblNewLabel = new JLabel("LISTA DE USUARIOS:");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setFont(new Font("Eras Light ITC", Font.BOLD, 16));
		lblNewLabel.setBounds(244, 30, 173, 36);
		contentPane.add(lblNewLabel);
		
		
		
		listaUsr= BDRegistro.mostrarUsuariosTotal();
		
		for (Usuario usr:listaUsr) {
			modeloTabla.addRow(new Object [] {usr.getCodigo(),usr.getNombre(),usr.getApellido(),usr.getNombreUsuario(),usr.getDni(),usr.getPuntos(),usr.getCorreoElectronico()
			});
		}
		
		btnVolver.addActionListener(e->{
			VentanaInicioAdmin vb = null;
			vb = new VentanaInicioAdmin(adminActual);
			vb.setVisible(true);
			dispose();
		});
	
	}
}

