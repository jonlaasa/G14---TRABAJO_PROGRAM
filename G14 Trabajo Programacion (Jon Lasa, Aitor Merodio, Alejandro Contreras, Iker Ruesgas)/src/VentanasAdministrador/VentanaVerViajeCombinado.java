package VentanasAdministrador;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BD.BDServicio;
import Datos.Administrador;
import Datos.ViajeCombinado;
import Datos.Vuelo;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class VentanaVerViajeCombinado extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modeloTabla;
	private JTable tableUsr;
	private ArrayList<ViajeCombinado> listaViaje;


	public VentanaVerViajeCombinado(Administrador adminActual) throws SQLException {
		
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		modeloTabla = new DefaultTableModel( new Object [] {
				"Id","Fecha","HoraSalida","Duracion","Origen","Transbordo","Destino","Precio","Plazas"},0);
		
		
		tableUsr = new JTable(modeloTabla);
		tableUsr.setBounds(398, 290, -226, -173);
		contentPane.add(tableUsr);
		
		JScrollPane scroll = new JScrollPane(tableUsr,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(51, 79, 574, 260);
		contentPane.add(scroll);
		
		JButton btnVolver = new JButton("Menu Principal");
		btnVolver.setBounds(216, 372, 164, 23);
		contentPane.add(btnVolver);
		
		
		JLabel lblNewLabel = new JLabel("LISTA DE VIAJES COMBINADOS:");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setFont(new Font("Eras Light ITC", Font.BOLD, 16));
		lblNewLabel.setBounds(246, 38, 255, 30);
		contentPane.add(lblNewLabel);
		
		tableUsr.getColumnModel().getColumn(0).setMaxWidth(40);
		tableUsr.getColumnModel().getColumn(1).setMinWidth(80);
		
		
		
		
		listaViaje= BDServicio.mostrarViajesCombinadosTotal(BDServicio.baseDatosServicio);
		
		for (ViajeCombinado viajeC:listaViaje) {
			modeloTabla.addRow(new Object [] {viajeC.getCodigo(),viajeC.getFecha(),viajeC.getHoraSalida(),viajeC.getDuracionString(),viajeC.getOrigen(),viajeC.getTrasbordo(),
					viajeC.getDestino(),viajeC.getPrecioString(),viajeC.getPlazasRestantes()
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
