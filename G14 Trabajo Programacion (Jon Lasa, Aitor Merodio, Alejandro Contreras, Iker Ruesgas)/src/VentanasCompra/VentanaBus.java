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
import Datos.Bus;
<<<<<<< HEAD
import Datos.Servicio;
=======
import Datos.Usuario;
>>>>>>> branch 'master' of https://github.com/jonlaasa/G14---TRABAJO_PROGRAM
import Datos.Vuelo;
import VentanasMenu.VentanaMenu;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

public class VentanaBus extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modeloTabla;
	private JCalendar calendarioIda;
	private JCalendar calendarioVuelta;
	private JTable tableBus;
	private DefaultListModel<Bus> mBus = new DefaultListModel<>();
	private ArrayList<Bus> listaBus;
	private static Servicio Bus;
	private JComboBox comboBoxDestino;
	private JComboBox comboBoxOrigen;


	/**
	 * Create the frame.
	 */
	public VentanaBus(Usuario usuarioActual) {
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxOrigen = new JComboBox();
		comboBoxOrigen.setBounds(89, 28, 167, 22);
		contentPane.add(comboBoxOrigen);
		cargarOrigenesBD();
		
		comboBoxDestino = new JComboBox();
		comboBoxDestino.setBounds(89, 61, 167, 22);
		contentPane.add(comboBoxDestino);
		cargarDestinosBD();
		
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
		tableBus=new JTable(modeloTabla);
		// Cambios de anchura
		
		tableBus.getColumnModel().getColumn(1).setMinWidth(75);
		
		tableBus.getColumnModel().getColumn(3).setMinWidth(75);
		tableBus.getColumnModel().getColumn(4).setMinWidth(75);
		
		panelTabla.setLayout(new BorderLayout());
		
		JScrollPane scroll = new JScrollPane(tableBus,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		panelTabla.add(scroll);
		
		
		//LLENAMOS LA LISTA de VUELOS ACTUALES CON LOS VUELOS  DE BD
		
		listaBus = BDServicio.mostrarBusesTotal();
		
		//CARGAMOS EL MODELO
		for(Bus bus: listaBus) {
			modeloTabla.addRow(new Object [] {bus.getFecha(),bus.getDuracionString(),bus.getOrigen(),
					bus.getDestino(),bus.getPrecioString(),bus.getCompanya(),bus.getPlazasRestantes()
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
		
		
		
		//CREAMOS EVENTO DE RATON PARA AL HACER CONTROL CLICK RESTAURAR COMO INICILAMENTE (POR SI NO TENEMOS OPCIONES DESPUES DE FILTRAR EJ.)
		//daigual donde hagamos el click + control
		
		
				KeyListener key = new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent f) {
						if (f.isControlDown() && f.getKeyCode() == KeyEvent.VK_PLUS) {
							//entonces llenamos la lista que manejamos primero
							
							listaBus=BDServicio.mostrarBusesTotal();
							//DESPUES LLENAMOS EL MODELO
							for(Bus bus: listaBus) {
								modeloTabla.addRow(new Object [] {bus.getFecha(),bus.getDuracionString(),bus.getOrigen(),
										bus.getDestino(),bus.getPrecioString(),bus.getCompanya(),bus.getPlazasRestantes()
								});
							}
							
						}
					}
				};
				
				tableBus.addKeyListener(key);
				this.addKeyListener(key);
				buttonAceptar.addKeyListener(key);
				buttonBuscarVuelo.addKeyListener(key);
				buttonVolver.addKeyListener(key);
				
				//A LOS COMPONENTES COMBO TAMBIEN?
<<<<<<< HEAD
	
	}
	
	public void cargarOrigenesBD() {
		// AÑADIR ORIGENES DISTINTOS DE LA BD
		ArrayList<String> listaOrigenes = BD.BDServicio.mostrarDiferentesOrigenes(Bus);
	
			
		//CARGAMOS LOS ORIGENES
		for (String origen: listaOrigenes) {
			comboBoxOrigen.addItem(origen);
			}
		}
				
	public void cargarDestinosBD() {
		// AÑADIR DESTINOS DISTINTOS DE LA BD
		ArrayList<String> listaDestinos = BD.BDServicio.mostrarDiferentesDestinos(Bus);
		
	
		//CARGAMOS LOS DESTINOS
		for (String destino: listaDestinos) {
		comboBoxDestino.addItem(destino);
		};
=======

		buttonVolver.addActionListener(e->{
			VentanaMenu vb = null;
			vb = new VentanaMenu(usuarioActual);
			vb.setVisible(true);
			dispose();
		});

		
		
		
>>>>>>> branch 'master' of https://github.com/jonlaasa/G14---TRABAJO_PROGRAM
	}
}
