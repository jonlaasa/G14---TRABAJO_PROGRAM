package VentanasAdministrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BD.BDRegistro;
import Datos.Administrador;
import Datos.Usuario;
import VentanasMenu.VentanaMenu;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class VentanaVerUsuarios extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modeloTabla;
	private JTable tableUsr;
	private ArrayList<Usuario> listaUsr;


	public VentanaVerUsuarios(Administrador adminActual) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
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
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(282, 363, 89, 23);
		contentPane.add(btnVolver);
		
		
		
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
