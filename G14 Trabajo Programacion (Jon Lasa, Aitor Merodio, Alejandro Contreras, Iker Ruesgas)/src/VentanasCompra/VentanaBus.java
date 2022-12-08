package VentanasCompra;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.toedter.calendar.JCalendar;

import BD.BDServicio;
import Datos.Bus;

import Datos.Servicio;

import Datos.Usuario;

import Datos.Vuelo;
import VentanasMenu.VentanaMenu;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
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
	private final static SimpleDateFormat SDF_FECHA_FOTO = new SimpleDateFormat("yyyy/MM/dd");


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
		
		
		comboBoxDestino = new JComboBox();
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
		
		JLabel filtroInicial = new JLabel("CONTROL + PLUS PARA RESTABLECER TABLA INICIAL");
		filtroInicial.setForeground(new Color(255, 128, 0));
		filtroInicial.setFont(new Font("Stencil", Font.PLAIN, 11));
		filtroInicial.setBounds(269, 7, 305, 14);
		contentPane.add(filtroInicial);
		
		JPanel panelTabla = new JPanel();
		panelTabla.setBounds(10, 266, 574, 260);
		contentPane.add(panelTabla);
		
		modeloTabla = new DefaultTableModel( new Object [] {
				"FECHA","HORA","DURACION","ORIGEN","DESTINO","PRECIO","COMPANYA","PLAZAS"},0) {
			
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
			
			
		};
		tableBus=new JTable(modeloTabla);
		// Cambios de anchura
		
		tableBus.getColumnModel().getColumn(0).setMinWidth(75);
		tableBus.getColumnModel().getColumn(1).setMaxWidth(50);
		tableBus.getColumnModel().getColumn(2).setMinWidth(85);
		tableBus.getColumnModel().getColumn(7).setMaxWidth(60);
		tableBus.getColumnModel().getColumn(5).setMaxWidth(60);
		
		panelTabla.setLayout(new BorderLayout());
		
		JScrollPane scroll = new JScrollPane(tableBus,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		panelTabla.add(scroll);
		
		
		//LLENAMOS LA LISTA de VUELOS ACTUALES CON LOS VUELOS  DE BD
		
		listaBus = BDServicio.mostrarBusesTotal();
		
		//CARGAMOS EL MODELO
		for(Bus bus: listaBus) {
			modeloTabla.addRow(new Object [] {bus.getFecha(),bus.getHoraSalida(),bus.getDuracionString(),bus.getOrigen(),
					bus.getDestino(),bus.getPrecioString(),bus.getCompanya(),bus.getPlazasRestantes()
			});
		}
		
		//Llenamos los origen y destino de los bus
		//ORIGEN
		ArrayList<String> listaOrigenes = BDServicio.mostrarDiferentesOrigenes("bus");
		
		
		for (String origen: listaOrigenes) {
			comboBoxOrigen.addItem(origen);
			}
		
		// DESTINO
		ArrayList<String> listaDestinos = BDServicio.mostrarDiferentesDestinos("bus");
		
		
		for (String destino: listaDestinos) {
		comboBoxDestino.addItem(destino);
		};
		
		
		
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
		//POR DEFECTO SELECCIONADO
		menorMayor.setSelected(true);
		
		JCheckBox mayorMenor = new JCheckBox("Mayor a menor");
		mayorMenor.setBounds(407, 56, 113, 23);
		contentPane.add(mayorMenor);
		
		bg.add(menorMayor);
		bg.add(mayorMenor);
		
		
		//RENDER TABLA
		
		tableBus.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				if(isSelected) {
					l.setBackground(Color.orange);
				}else {
					//SI TIENE POCAS PLAZAS EN ROJO
					
					int plazas =  (int) modeloTabla.getValueAt(row,7	);
					if(plazas<10) {
						l.setFont( new Font( "Arial", Font.ITALIC, 12 ) );
						l.setBackground(Color.red);
					}else {
						l.setBackground(Color.white);
					}
					
					
				}
				return l;
			}
		});
		
		//EVENTO DE BOTON, FILTRAR BUSES
		
		buttonBuscarVuelo.addActionListener(e -> {
			
			BD.BDServicio.log(Level.INFO,"Realizando filtrado de los buses", null);
			//Obtenenemos los origen y destino 		
			
			String origen = comboBoxOrigen.getSelectedItem().toString();
			String destino = comboBoxDestino.getSelectedItem().toString();
			
			//Ahora obtenemos el valor de precio ascendente o descendente
			String filtroPrecio ="";
			
			boolean valor = menorMayor.isSelected();
			if (valor ==true) {
				filtroPrecio="menor";
			}else {
				filtroPrecio= "mayor";
			}
			
			
			//FALTA LA FECHA
			
			String fechaInicio = SDF_FECHA_FOTO.format(calendarIda.getDate());
			String fechaFin = SDF_FECHA_FOTO.format(calendarVuelta.getDate());
			
			//LLAMAMOS AL METODO 
			ArrayList<Bus> listaBusFiltrado = BD.BDServicio.listaServicioBusFiltrado(origen, destino, filtroPrecio,fechaInicio, fechaFin);
			
			listaBus=listaBusFiltrado;
			
			
			//VACIAMOS Y LLENAMOS
			
			while (modeloTabla.getRowCount() > 0) {
				modeloTabla.removeRow( 0 );
			}
			
			//LLENAMOS
			
			for(Bus bus: listaBus) {
				modeloTabla.addRow(new Object [] {bus.getFecha(),bus.getHoraSalida(),bus.getDuracionString(),bus.getOrigen(),
						bus.getDestino(),bus.getPrecioString(),bus.getCompanya(),bus.getPlazasRestantes()
				});
			
			
			}
			tableBus.repaint();
			
		});
		
		
		//EVENTO DE CONTINUAR
		
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//OBTENEMOS EL VUELO
				
				Bus busSeleccionado =  listaBus.get( tableBus.getSelectedRow() );
				
				if(busSeleccionado==null) {
					//SI NO HA SELECCIONADO NINGUNO, MENSAJE DE ERROR
					JOptionPane.showMessageDialog( null, "Seleccione un bus para continuar", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					//PASAMOS A LA SIGUIENTE VENTANA DE LA COMPRA
					BDServicio.log(Level.INFO, "Accediendo a la cantidad de billetes a seleccionar del vuelo", null);
					VentanaBilletes vent= new VentanaBilletes(usuarioActual,busSeleccionado);
					vent.setVisible(true);
					dispose();
					
				}	
				
				
			}
		});
		
		//RENDERER DE LA LISTA DE ORIGEN Y DESTINO
		
		comboBoxOrigen.setRenderer( new DefaultListCellRenderer() {

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				// TODO Auto-generated method stub

				JLabel l= (JLabel)  super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				
				if(isSelected) {
					l.setBackground(Color.green);
				}else {
					l.setBackground(Color.white);
				}
				return l;
			}
		
			
		});
		
		
		comboBoxDestino.setRenderer( new DefaultListCellRenderer() {

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				// TODO Auto-generated method stub

				JLabel l= (JLabel)  super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				
				if(isSelected) {
					l.setBackground(Color.green);
				}else {
					l.setBackground(Color.white);
				}
				return l;
			}
		
			
		});
	
		
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
								modeloTabla.addRow(new Object [] {bus.getFecha(),bus.getHoraSalida(),bus.getDuracionString(),bus.getOrigen(),
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

	

		buttonVolver.addActionListener(e->{
			VentanaMenu vb = null;
			vb = new VentanaMenu(usuarioActual);
			vb.setVisible(true);
			dispose();
		});

		
		
		
	}
}