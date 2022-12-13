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

public class VentanaVuelo extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modeloTabla;
	private JCalendar calendarioIda;
	private JCalendar calendarioVuelta;
	private JTable tableVuelos;
	private DefaultListModel<Vuelo> mVuelos = new DefaultListModel<>();
	private ArrayList<Vuelo> listaVuelos;
	private static Servicio Vuelo;
	private JComboBox comboBoxDestino;
	private JComboBox comboBoxOrigen;
	
	private final static SimpleDateFormat SDF_FECHA_FOTO = new SimpleDateFormat("yyyy/MM/dd");


	/**
	 * Create the frame.
	 */
	public VentanaVuelo(Usuario usuarioActual) {
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxOrigen = new JComboBox() ;
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
		tableVuelos=new JTable(modeloTabla);
		// Cambios de anchura
		
		tableVuelos.getColumnModel().getColumn(0).setMinWidth(75);
		tableVuelos.getColumnModel().getColumn(1).setMaxWidth(50);
		tableVuelos.getColumnModel().getColumn(2).setMinWidth(85);
		tableVuelos.getColumnModel().getColumn(7).setMaxWidth(60);
		tableVuelos.getColumnModel().getColumn(5).setMaxWidth(60);
		
		panelTabla.setLayout(new BorderLayout());
		
		JScrollPane scroll = new JScrollPane(tableVuelos,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		panelTabla.add(scroll);
		
		//LA TABLA NO SERA EDITABLE 
		
		
		
		//LLENAMOS LA LISTA de VUELOS ACTUALES CON LOS VUELOS  DE BD
		listaVuelos = BDServicio.mostrarVuelosTotal();
		
		//CARGAMOS EL MODELO
		for(Vuelo vuelo: listaVuelos) {
			modeloTabla.addRow(new Object [] {vuelo.getFecha(),vuelo.getHoraSalida(),vuelo.getDuracionString(),vuelo.getOrigen(),
					vuelo.getDestino(),vuelo.getPrecioString(),vuelo.getCompanya(),vuelo.getPlazasRestantes()
			});
		}
		
		
		//Llenamos los origen y destino de los bus
				//ORIGEN
				ArrayList<String> listaOrigenes = BDServicio.mostrarDiferentesOrigenes("vuelo");
				
				
				
				for (String origen: listaOrigenes) {
					comboBoxOrigen.addItem(origen);
					}
				
				// DESTINO
				ArrayList<String> listaDestinos = BDServicio.mostrarDiferentesDestinos("vuelo");
				
				
				
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
		
		JLabel lblInicio = new JLabel("Inicio");
		lblInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblInicio.setForeground(Color.BLACK);
		lblInicio.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		lblInicio.setBounds(146, 83, 58, 22);
		contentPane.add(lblInicio);
		
		JLabel lblVuelta = new JLabel("Fin:");
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
				
				//OBTENEMOS EL VUELO
				
				Vuelo vueloSeleccionado =  listaVuelos.get( tableVuelos.getSelectedRow() );
				
				if(vueloSeleccionado==null) {
					//SI NO HA SELECCIONADO NINGUNO, MENSAJE DE ERROR
					JOptionPane.showMessageDialog( null, "Seleccione un vuelo para continuar", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					//PASAMOS A LA SIGUIENTE VENTANA DE LA COMPRA
					BDServicio.log(Level.INFO, "Accediendo a la cantidad de billetes a seleccionar del vuelo", null);
					VentanaBilletes vent= new VentanaBilletes(usuarioActual,vueloSeleccionado);
					vent.setVisible(true);
					dispose();
					
				}
				
				
				
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
		
		calendarIda.setMinSelectableDate(new Date(System.currentTimeMillis()));
		
		JCalendar calendarVuelta = new JCalendar();
		calendarVuelta.setWeekOfYearVisible(false);
		calendarVuelta.setBounds(320, 100, 184, 153);
		contentPane.add(calendarVuelta);
		
		calendarVuelta.setMinSelectableDate(new Date(System.currentTimeMillis()));
		
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
		
		
		//EVENTOS DE FILTRADO
		
		buttonBuscarVuelo.addActionListener(e -> {
			
			BD.BDServicio.log(Level.INFO,"Realizando filtrado de los vuelos", null);
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
			ArrayList<Vuelo> listaVuelosFiltrado = BD.BDServicio.listaServicioVueloFiltrado(origen, destino, filtroPrecio,fechaInicio, fechaFin);
			
			listaVuelos=listaVuelosFiltrado;
			
			
			//VACIAMOS Y LLENAMOS
			
			while (modeloTabla.getRowCount() > 0) {
				modeloTabla.removeRow( 0 );
			}
			
			//LLENAMOS
			
			for(Vuelo vuelo: listaVuelos) {
				modeloTabla.addRow(new Object [] {vuelo.getFecha(),vuelo.getHoraSalida(),vuelo.getDuracionString(),vuelo.getOrigen(),
						vuelo.getDestino(),vuelo.getPrecioString(),vuelo.getCompanya(),vuelo.getPlazasRestantes()
				});
			
			}
			
			tableVuelos.repaint();
			
		});
		
		
		
		
		
		
		
		
		//RENDERERS
		
		tableVuelos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				if(isSelected) {
					l.setBackground(Color.yellow);
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
		
		
		
		//RENDERER DE LA LISTA DE ORIGEN Y DESTINO
		
		comboBoxOrigen.setRenderer( new DefaultListCellRenderer() {

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				
				// TODO Auto-generated method stub

				JLabel l= (JLabel)  super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				
				if(isSelected) {
					l.setBackground(Color.orange);
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
					l.setBackground(Color.orange);
				}else {
					l.setBackground(Color.white);
				}
				return l;
			}
		
			
		});
		
	
		
		
		//CREAMOS EVENTO DE RATON PARA AL HACER CONTROL CLICK RESTAURAR COMO INICILAMENTE (POR SI NO TENEMOS OPCIONES DESPUES DE FILTRAR EJ.)
		//daigual donde hagamos el click + plus
		
		
				KeyListener key = new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent f) {
						if (f.isControlDown() && f.getKeyCode() == KeyEvent.VK_PLUS) {
							//entonces llenamos la lista que manejamos primero
							
							listaVuelos=BDServicio.mostrarVuelosTotal();
							//DESPUES LLENAMOS EL MODELO, VACIAMOS PRIMERO
							
							while (modeloTabla.getRowCount() > 0) {
								modeloTabla.removeRow( 0 );
							}
							
							//LLENAMOS
							
							for(Vuelo vuelo: listaVuelos) {
								modeloTabla.addRow(new Object [] {vuelo.getFecha(),vuelo.getHoraSalida(),vuelo.getDuracion(),vuelo.getOrigen(),
										vuelo.getDestino(),vuelo.getPrecio(),vuelo.getCompanya(),vuelo.getPlazasRestantes()
								});
							}
							
						}
					}
				};
				
				tableVuelos.addKeyListener(key);
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

