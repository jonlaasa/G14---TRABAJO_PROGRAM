package VentanasAdministrador;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BD.BDRegistro;
import Datos.Administrador;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaVerAdmin extends JFrame {
	

	private JPanel contentPane;
	private DefaultTableModel modeloTabla;
	private JTable tableUsr;
	private ArrayList<Administrador> listaAdmin;


	public VentanaVerAdmin(Administrador adminActual) throws SQLException {
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 51));
		contentPane.setForeground(new Color(0, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		modeloTabla = new DefaultTableModel( new Object [] {
				"Id","Nombre","Apellidos","Usuario"},0);
		
		tableUsr = new JTable(modeloTabla);
		tableUsr.setBounds(398, 290, -226, -173);
		contentPane.add(tableUsr);
		
		JScrollPane scroll = new JScrollPane(tableUsr,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(51, 79, 574, 260);
		contentPane.add(scroll);
		
		JButton btnVolver = new JButton("Menu Principal");
		btnVolver.setBounds(168, 362, 137, 23);
		contentPane.add(btnVolver);
		
		JLabel lblAdministradores = new JLabel("LISTA DE ADMINISTRADORES:");
		lblAdministradores.setFont(new Font("Eras Light ITC", Font.BOLD, 16));
		lblAdministradores.setForeground(new Color(255, 128, 64));
		lblAdministradores.setBounds(220, 30, 228, 46);
		contentPane.add(lblAdministradores);
		
		JButton btnCrearAdmin = new JButton("Nuevo Administrador");
		btnCrearAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrearAdmin.setBounds(348, 362, 160, 23);
		contentPane.add(btnCrearAdmin);
		
		
		
		listaAdmin= BDRegistro.mostrarAdministradoresTotal();
		
		for (Administrador admin:listaAdmin) {
			modeloTabla.addRow(new Object [] {admin.getCodAcceso(),admin.getNombre(),admin.getApellido(),admin.getNombreUsuario()
			});
		}
		
		btnVolver.addActionListener(e->{
			VentanaInicioAdmin vb = null;
			vb = new VentanaInicioAdmin(adminActual);
			vb.setVisible(true);
			dispose();
		});
		
		
		btnCrearAdmin.addActionListener(e->{
			VentanaCrearAdmin vb = null;
			vb = new VentanaCrearAdmin(adminActual);
			vb.setVisible(true);
			dispose();
		});
	
	}
}
