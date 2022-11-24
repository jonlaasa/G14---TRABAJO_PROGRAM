package VentanasCompra;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.toedter.calendar.JCalendar;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JScrollBar;

public class VentanaViajeCombinado extends JFrame {

	private JPanel contentPane;
	private JTable tableViajeCombinado;
	private JCalendar calendarioIda;
	private JCalendar calendarioVuelta;


	/**
	 * Create the frame.
	 */
	
	
	public VentanaViajeCombinado() {
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 719);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBoxOrigen = new JComboBox();
		comboBoxOrigen.setBounds(90, 25, 457, 22);
		contentPane.add(comboBoxOrigen);
		
		JComboBox comboBoxDestino = new JComboBox();
		comboBoxDestino.setBounds(90, 61, 457, 22);
		contentPane.add(comboBoxDestino);
		
		JLabel lblNewLabel = new JLabel("Origen");
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(22, 20, 58, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setForeground(Color.BLACK);
		lblDestino.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblDestino.setBounds(22, 56, 58, 25);
		contentPane.add(lblDestino);
		
		tableViajeCombinado = new JTable();
		tableViajeCombinado.setBounds(22, 248, 498, 390);
		contentPane.add(tableViajeCombinado);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.BLACK);
		lblPrecio.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblPrecio.setBounds(22, 92, 58, 25);
		contentPane.add(lblPrecio);
		
		JLabel lblFiltart = new JLabel("Filtrar por:");
		lblFiltart.setHorizontalAlignment(SwingConstants.LEFT);
		lblFiltart.setForeground(Color.BLACK);
		lblFiltart.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		lblFiltart.setBounds(48, 113, 58, 22);
		contentPane.add(lblFiltart);
		
		JRadioButton rdbtnDeMayorAMenor = new JRadioButton("De mayor a menor");
		rdbtnDeMayorAMenor.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnDeMayorAMenor.setBounds(22, 136, 109, 23);
		contentPane.add(rdbtnDeMayorAMenor);
		
		JRadioButton rdbtnDeMenorA = new JRadioButton("De menor a mayor");
		rdbtnDeMenorA.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnDeMenorA.setBounds(22, 162, 109, 23);
		contentPane.add(rdbtnDeMenorA);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblFecha.setBounds(121, 94, 58, 25);
		contentPane.add(lblFecha);
		
		JLabel lblInicio = new JLabel("Ida:");
		lblInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblInicio.setForeground(Color.BLACK);
		lblInicio.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		lblInicio.setBounds(189, 83, 58, 22);
		contentPane.add(lblInicio);
		
		JLabel lblVuelta = new JLabel("Vuelta:");
		lblVuelta.setHorizontalAlignment(SwingConstants.LEFT);
		lblVuelta.setForeground(Color.BLACK);
		lblVuelta.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		lblVuelta.setBounds(364, 83, 58, 22);
		contentPane.add(lblVuelta);
		
		Button buttonBuscarVuelo = new Button("BUSCAR");
		buttonBuscarVuelo.setActionCommand("buscarVuelo");
		buttonBuscarVuelo.setBackground(new Color(102, 204, 204));
		buttonBuscarVuelo.setBounds(22, 201, 70, 22);
		contentPane.add(buttonBuscarVuelo);
		
		Button buttonVolver = new Button("VOLVER");
		buttonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonVolver.setBackground(new Color(102, 204, 204));
		buttonVolver.setActionCommand("buscarVuelo");
		buttonVolver.setBounds(22, 636, 70, 22);
		contentPane.add(buttonVolver);
		
		Button buttonAceptar = new Button("ACEPTAR");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonAceptar.setBackground(new Color(102, 204, 204));
		buttonAceptar.setActionCommand("buscarVuelo");
		buttonAceptar.setBounds(450, 636, 70, 22);
		contentPane.add(buttonAceptar);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(530, 248, 17, 390);
		contentPane.add(scrollBar);
		
		JCalendar calendarIda = new JCalendar();
		calendarIda.setWeekOfYearVisible(false);
		calendarIda.setBounds(168, 102, 184, 153);
		contentPane.add(calendarIda);
		
		JCalendar calendarVuelta = new JCalendar();
		calendarVuelta.setWeekOfYearVisible(false);
		calendarVuelta.setBounds(363, 102, 184, 153);
		contentPane.add(calendarVuelta);
	}
}
