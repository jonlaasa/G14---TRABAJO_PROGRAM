package VentanasAdministrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import BD.BDRegistro;
import BD.BDServicio;
import Datos.Administrador;
import Datos.Bus;

import java.awt.TextArea;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import java.awt.Canvas;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

public class VentanaCrearBus extends JFrame {

	private JPanel contentPane;
	private JTextField tfDuracion;
	private JTextField tfPrecio;
	private final static SimpleDateFormat SDF_FECHA_FOTO = new SimpleDateFormat("yyyy/MM/dd");
	


	public VentanaCrearBus(Administrador adminActual) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(162, 90, 113, 22);
		contentPane.add(menuBar_1);
		
		JMenu mnFecha = new JMenu("Seleccionar fecha");
		menuBar_1.add(mnFecha);
		
		
		JCalendar calendario = new JCalendar();
		mnFecha.add(calendario);
		calendario.setWeekOfYearVisible(false);
		
		Label label = new Label("Crear nuevo servicio de bus");
		label.setForeground(new Color(255, 128, 0));
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setBounds(223, 37, 247, 39);
		contentPane.add(label);
		
		Label label_1 = new Label("Fecha:");
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1.setBounds(94, 90, 62, 22);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Duracion:");
		label_2.setFont(new Font("Dialog", Font.BOLD, 12));
		label_2.setBounds(94, 138, 62, 22);
		contentPane.add(label_2);
		
		Label label_3 = new Label("Origen:");
		label_3.setFont(new Font("Dialog", Font.BOLD, 12));
		label_3.setBounds(94, 186, 62, 22);
		contentPane.add(label_3);
		
		Label label_4 = new Label("Destino:");
		label_4.setFont(new Font("Dialog", Font.BOLD, 12));
		label_4.setBounds(286, 186, 62, 22);
		contentPane.add(label_4);
		
		Label label_5 = new Label("Precio:");
		label_5.setFont(new Font("Dialog", Font.BOLD, 12));
		label_5.setBounds(94, 229, 62, 22);
		contentPane.add(label_5);
		
		Label label_6 = new Label("Plazas:");
		label_6.setFont(new Font("Dialog", Font.BOLD, 12));
		label_6.setBounds(94, 275, 62, 22);
		contentPane.add(label_6);
		
		Label label_7 = new Label("Compañia:");
		label_7.setFont(new Font("Dialog", Font.BOLD, 12));
		label_7.setBounds(94, 319, 62, 22);
		contentPane.add(label_7);
	
		
		JComboBox<String> comboBoxOrigen = new JComboBox<String>();
		comboBoxOrigen.setBounds(162, 186, 113, 22);
		comboBoxOrigen.addItem("Barcelona");
		comboBoxOrigen.addItem("Madrid");
		comboBoxOrigen.addItem("Valencia");
		comboBoxOrigen.addItem("Lugo");
		comboBoxOrigen.addItem("Murcia");
		comboBoxOrigen.addItem("Bilbao");
		comboBoxOrigen.addItem("Cadiz");
		comboBoxOrigen.addItem("Lisboa");
		contentPane.add(comboBoxOrigen);
		
		JComboBox<String> comboBoxDestino = new JComboBox<String>();
		comboBoxDestino.setBounds(353, 186, 113, 22);
		comboBoxDestino.addItem("Barcelona");
		comboBoxDestino.addItem("Madrid");
		comboBoxDestino.addItem("Valencia");
		comboBoxDestino.addItem("Lugo");
		comboBoxDestino.addItem("Murcia");
		comboBoxDestino.addItem("Bilbao");
		comboBoxDestino.addItem("Cadiz");
		comboBoxDestino.addItem("Lisboa");
		contentPane.add(comboBoxDestino);
		
		tfDuracion = new JTextField();
		tfDuracion.setBounds(162, 140, 86, 20);
		contentPane.add(tfDuracion);
		tfDuracion.setColumns(10);
		
		tfPrecio = new JTextField();
		tfPrecio.setBounds(162, 231, 86, 20);
		contentPane.add(tfPrecio);
		tfPrecio.setColumns(10);
		
		JComboBox<String> comboBoxCompanya = new JComboBox<String>();
		comboBoxCompanya.setBounds(162, 319, 113, 22);
		comboBoxCompanya.addItem("Alsa");
		comboBoxCompanya.addItem("Avanza");
		comboBoxCompanya.addItem("Lycar");
		comboBoxCompanya.addItem("Socibus");
		comboBoxCompanya.addItem("Linebus");
		comboBoxCompanya.addItem("Movella");
		contentPane.add(comboBoxCompanya);
		
		JComboBox<String> comboBoxPlazas = new JComboBox<String>();
		comboBoxPlazas.setBounds(162, 275, 150, 22);
		comboBoxPlazas.addItem("Minibus (22 plazas)");
		comboBoxPlazas.addItem("Bus estandar (50 plazas)");
		comboBoxPlazas.addItem("Bus especial (100 plazas)");
		contentPane.add(comboBoxPlazas);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(223, 362, 89, 23);
		contentPane.add(btnVolver);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(353, 362, 89, 23);
		contentPane.add(btnCrear);
		
		
		
	
	
		
		btnVolver.addActionListener(e->{
			VentanaInicioAdmin vb = null;
			vb = new VentanaInicioAdmin(adminActual);
			vb.setVisible(true);
			dispose();
		});
		
		btnCrear.addActionListener(e->{
			String fecha =SDF_FECHA_FOTO.format(calendario.getDate());
			int duracion = Integer.valueOf(tfDuracion.getText());
			String origen = comboBoxOrigen.getToolTipText();
			String destino = comboBoxDestino.getToolTipText();
			double precio = Double.valueOf(tfDuracion.getText());
			String plaza= comboBoxPlazas.getToolTipText();
			int plazasFinal = 22;
			String companya = comboBoxCompanya.getToolTipText();
			if(plaza=="Bus estandar (50 plazas)") {
				plazasFinal=50;
			}
			else if (plaza=="Bus especial (100 plazas)") {
				plazasFinal=100;
			}
			try {
				BDServicio.crearBus(new Bus(fecha,duracion,origen,destino,precio,plazasFinal,companya));
				JOptionPane.showMessageDialog(null, "Bus creado");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		

	}
}
