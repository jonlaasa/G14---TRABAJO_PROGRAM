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
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(282, 363, 89, 23);
		contentPane.add(btnVolver);
		
		
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
	
	}
}