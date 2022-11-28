package VentanasCompra;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.toedter.calendar.JCalendar;

import BD.BDServicio;
import Datos.Vuelo;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;

public class VentanaVuelo extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modeloTabla;
	private JCalendar calendarioIda;
	private JCalendar calendarioVuelta;
	private JTable tableVuelos;
	private DefaultListModel<Vuelo> mVuelos = new DefaultListModel<>();
	private ArrayList<Vuelo> listaVuelos;
	


	/**
	 * Create the frame.
	 */
	public VentanaVuelo() {
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBoxOrigen = new JComboBox();
		comboBoxOrigen.setBounds(89, 28, 167, 22);
		contentPane.add(comboBoxOrigen);
		
		JComboBox comboBoxDestino = new JComboBox();
		comboBoxDestino.setBounds(89, 61, 167, 22);
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
		
		JPanel panelTabla = new JPanel();
		panelTabla.setBounds(10, 266, 574, 260);
		contentPane.add(panelTabla);
		
		modeloTabla = new DefaultTableModel( new Object [] {
				"FECHA","DURACION","ORIGEN","DESTINO","PRECIO","COMPANYA","PLAZAS"},0);
		tableVuelos=new JTable(modeloTabla);
		// Cambios de anchura
		
		tableVuelos.getColumnModel().getColumn(1).setMinWidth(75);
		
		tableVuelos.getColumnModel().getColumn(3).setMinWidth(75);
		tableVuelos.getColumnModel().getColumn(4).setMinWidth(75);
		
		panelTabla.setLayout(new BorderLayout());
		
		JScrollPane scroll = new JScrollPane(tableVuelos,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		panelTabla.add(scroll);
		
		
		//LLENAMOS LA LISTA de VUELOS ACTUALES CON LOS VUELOS  DE BD
		BDServicio bd = new BDServicio();
		listaVuelos = bd.mostrarVuelosTotal();
		
		//CARGAMOS EL MODELO
		for(Vuelo vuelo: listaVuelos) {
			modeloTabla.addRow(new Object [] {vuelo.getFecha(),vuelo.getDuracion(),vuelo.getOrigen(),
					vuelo.getDestino(),vuelo.getPrecio(),vuelo.getCompanya(),vuelo.getPlazasRestantes()
			});
		}
		
		
		
	
		
		
		
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.BLACK);
		lblPrecio.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblPrecio.setBounds(333, 23, 58, 25);
		contentPane.add(lblPrecio);
		
		JLabel lblFiltart = new JLabel("Filtrar por:");
		lblFiltart.setHorizontalAlignment(SwingConstants.LEFT);
		lblFiltart.setForeground(Color.BLACK);
		lblFiltart.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		lblFiltart.setBounds(333, 50, 58, 22);
		contentPane.add(lblFiltart);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblFecha.setBounds(245, 100, 58, 25);
		contentPane.add(lblFecha);
		
		JLabel lblInicio = new JLabel("Ida:");
		lblInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblInicio.setForeground(Color.BLACK);
		lblInicio.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		lblInicio.setBounds(146, 83, 58, 22);
		contentPane.add(lblInicio);
		
		JLabel lblVuelta = new JLabel("Vuelta:");
		lblVuelta.setHorizontalAlignment(SwingConstants.LEFT);
		lblVuelta.setForeground(Color.BLACK);
		lblVuelta.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		lblVuelta.setBounds(315, 83, 58, 22);
		contentPane.add(lblVuelta);
		
		Button buttonVolver = new Button("VOLVER");
		buttonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonVolver.setBackground(new Color(102, 204, 204));
		buttonVolver.setActionCommand("buscarVuelo");
		buttonVolver.setBounds(72, 549, 63, 31);
		contentPane.add(buttonVolver);
		
		Button buttonAceptar = new Button("ACEPTAR");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonAceptar.setBackground(new Color(102, 204, 204));
		buttonAceptar.setActionCommand("buscarVuelo");
		buttonAceptar.setBounds(359, 549, 124, 31);
		contentPane.add(buttonAceptar);
		
		JCalendar calendarIda = new JCalendar();
		calendarIda.setWeekOfYearVisible(false);
		calendarIda.setBounds(45, 102, 184, 153);
		contentPane.add(calendarIda);
		
		JCalendar calendarVuelta = new JCalendar();
		calendarVuelta.setWeekOfYearVisible(false);
		calendarVuelta.setBounds(320, 100, 184, 153);
		contentPane.add(calendarVuelta);
		
		Button buttonBuscarVuelo = new Button("BUSCAR");
		buttonBuscarVuelo.setBounds(245, 208, 70, 19);
		contentPane.add(buttonBuscarVuelo);
		buttonBuscarVuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonBuscarVuelo.setActionCommand("buscarVuelo");
		buttonBuscarVuelo.setBackground(new Color(102, 204, 204));
		
		ButtonGroup bg=new ButtonGroup();
		
		JCheckBox menorMayor = new JCheckBox("Menor a mayor");
		menorMayor.setBounds(410, 28, 110, 23);
		contentPane.add(menorMayor);
		
		JCheckBox mayorMenor = new JCheckBox("Mayor a menor");
		mayorMenor.setBounds(407, 56, 113, 23);
		contentPane.add(mayorMenor);
		
		bg.add(menorMayor);
		bg.add(mayorMenor);
		

		
		
		
	}
}

