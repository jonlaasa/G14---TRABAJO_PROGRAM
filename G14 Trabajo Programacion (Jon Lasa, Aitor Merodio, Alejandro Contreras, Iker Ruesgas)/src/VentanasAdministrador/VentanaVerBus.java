package VentanasAdministrador;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BD.BDServicio;
import Datos.Administrador;
import Datos.Bus;


import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class VentanaVerBus extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modeloTabla;
	private JTable tableUsr;
	private ArrayList<Bus> listaBus;


	public VentanaVerBus(Administrador adminActual) throws SQLException {
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		modeloTabla = new DefaultTableModel( new Object [] {
				"Id","Fecha","Hora de salida","Duracion","Origen","Destino","Precio","Compañia","Plazas restantes"},0);
		
		
		tableUsr = new JTable(modeloTabla);
		tableUsr.setBounds(398, 290, -226, -173);
		contentPane.add(tableUsr);
		
		JScrollPane scroll = new JScrollPane(tableUsr,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(51, 79, 574, 260);
		contentPane.add(scroll);
		
		JButton btnVolver = new JButton("Menu Principal");
		btnVolver.setBounds(180, 363, 122, 23);
		contentPane.add(btnVolver);
		
		JLabel lblNewLabel = new JLabel("LISTA DE BUSES:");
		lblNewLabel.setFont(new Font("Eras Light ITC", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setBounds(254, 24, 247, 44);
		contentPane.add(lblNewLabel);
		
		JButton btnCrearBus = new JButton("Nuevo Bus");
		btnCrearBus.setBounds(356, 363, 145, 23);
		contentPane.add(btnCrearBus);
		
		
//		String[] options = {"Todos los buses", "Buses llenos", "Ultimas plazas"};
//		JComboBox comboBox = new JComboBox(options);
//		comboBox.setBounds(51, 46, 137, 22);
//		contentPane.add(comboBox);
		
		
		
		listaBus= BDServicio.verBus();
		
		for (Bus bus:listaBus) {
			modeloTabla.addRow(new Object [] {bus.getCodigo(),bus.getFecha(),bus.getHoraSalida(),bus.getDuracionString(),bus.getOrigen(),bus.getDestino(),bus.getPrecioString(),bus.getCompanya(),bus.getPlazasRestantes()
			});
		}
		
		btnVolver.addActionListener(e->{
			VentanaInicioAdmin vb = null;
			vb = new VentanaInicioAdmin(adminActual);
			vb.setVisible(true);
			dispose();
		});
		
		
		btnCrearBus.addActionListener(e->{
			VentanaCrearBus vb = null;
			vb = new VentanaCrearBus(adminActual);
			vb.setVisible(true);
			dispose();
		});
	
	}
}