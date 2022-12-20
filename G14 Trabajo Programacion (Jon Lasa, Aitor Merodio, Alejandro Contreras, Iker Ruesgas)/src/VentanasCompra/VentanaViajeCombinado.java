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
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import BD.BDServicio;

import Datos.Servicio;


import Datos.Usuario;
import Datos.ViajeCombinado;
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
import java.util.TreeSet;
import java.util.Vector;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;

public class VentanaViajeCombinado extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modeloTabla;
	private JTable tableViajesCombinados;
	private DefaultListModel<ViajeCombinado> mViajesCombinados = new DefaultListModel<>();
	private ArrayList<ViajeCombinado> listaViajesCombinados;
	private JComboBox comboBoxDestino;
	private JComboBox comboBoxOrigen;
	
	private final static SimpleDateFormat SDF_FECHA_FOTO = new SimpleDateFormat("yyyy/MM/dd");


	/**
	 * Create the frame.
	 */
	public VentanaViajeCombinado(Usuario usuarioActual) {
		setLocationRelativeTo(null); 
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxOrigen = new JComboBox() ;
		comboBoxOrigen.setBounds(89, 137, 167, 22);
		contentPane.add(comboBoxOrigen);
		
		
		comboBoxDestino = new JComboBox();
		comboBoxDestino.setBounds(89, 170, 167, 22);
		contentPane.add(comboBoxDestino);
		
		JLabel lblNewLabel = new JLabel("Origen");
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(21, 132, 58, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setForeground(Color.BLACK);
		lblDestino.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblDestino.setBounds(21, 165, 58, 25);
		contentPane.add(lblDestino);
		
		JLabel filtroInicial = new JLabel("CONTROL + PLUS PARA RESTABLECER TABLA INICIAL");
		filtroInicial.setForeground(new Color(255, 128, 0));
		filtroInicial.setFont(new Font("Stencil", Font.PLAIN, 11));
		filtroInicial.setBounds(269, 11, 305, 30);
		contentPane.add(filtroInicial);
		
		JPanel panelTabla = new JPanel();
		panelTabla.setBounds(10, 266, 574, 260);
		contentPane.add(panelTabla);
		
		//LA TABLA NO SERA EDITABLE 
		
		modeloTabla = new DefaultTableModel( new Object [] {
				"FECHA","HORA","DURACION","ORIGEN","TRASBORDO","DESTINO","PRECIO","PLAZAS"},0) {
			
			 @Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
			
		
			
		};
		tableViajesCombinados=new JTable(modeloTabla);
		
		// Cambios de anchura
		
		tableViajesCombinados.getColumnModel().getColumn(0).setMinWidth(70);
		tableViajesCombinados.getColumnModel().getColumn(1).setMaxWidth(50);
		tableViajesCombinados.getColumnModel().getColumn(2).setMinWidth(90);
		tableViajesCombinados.getColumnModel().getColumn(3).setMinWidth(60);
		tableViajesCombinados.getColumnModel().getColumn(4).setMinWidth(85);
		tableViajesCombinados.getColumnModel().getColumn(5).setMinWidth(65);
		tableViajesCombinados.getColumnModel().getColumn(6).setMaxWidth(60);
		tableViajesCombinados.getColumnModel().getColumn(7).setMaxWidth(50);
		
		panelTabla.setLayout(new BorderLayout());
		
		JScrollPane scroll = new JScrollPane(tableViajesCombinados,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		panelTabla.add(scroll);
		
		
		
		
		//LLENAMOS LA LISTA de VIAJES COMBINADOS ACTUALES CON LOS VIAJES COMBINADOS  DE BD
		listaViajesCombinados = BDServicio.mostrarViajesCombinadosTotal();
		
//		//CARGAMOS EL MODELO
		for(ViajeCombinado viaje: listaViajesCombinados) {
			modeloTabla.addRow(new Object [] {viaje.getFecha(),viaje.getHoraSalida(),viaje.getDuracionString(),viaje.getVuelo().getOrigen(),viaje.getVuelo().getDestino(),viaje.getBus().getDestino(),viaje.getPrecioString(),viaje.getPlazasRestantes()});
		}
		
			
		
		//Llenamos los origen y destino de los bus
				//ORIGEN 
		TreeSet<String> listaOrigenes = BDServicio.mostrarOrigenesCombinados();
		
		for (String origen: listaOrigenes) {
			comboBoxOrigen.addItem(origen);
		}					
//				
//        		// DESTINO
		TreeSet<String> listaDestinos = BDServicio.mostrarDestinosCombinados();
//				
//				
//				
		for (String destino: listaDestinos) {
			comboBoxDestino.addItem(destino);
		}
		
		
		
		
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.BLACK);
		lblPrecio.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblPrecio.setBounds(317, 86, 58, 25);
		contentPane.add(lblPrecio);
		
		JLabel lblFiltart = new JLabel("Filtrar por:");
		lblFiltart.setHorizontalAlignment(SwingConstants.LEFT);
		lblFiltart.setForeground(Color.BLACK);
		lblFiltart.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		lblFiltart.setBounds(317, 112, 58, 22);
		contentPane.add(lblFiltart);
		
		Button buttonVolver = new Button("VOLVER");
		buttonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonVolver.setBackground(new Color(102, 204, 204));
		buttonVolver.setBounds(72, 549, 63, 31);
		contentPane.add(buttonVolver);
		
		Button buttonAceptar = new Button("ACEPTAR");
		//buttonAceptar.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent e) {
//				
//				//OBTENEMOS EL VUELO
//				
//				Vuelo vueloSeleccionado =  listaVuelos.get( tableVuelos.getSelectedRow() );
//				
//				if(vueloSeleccionado==null) {
//					//SI NO HA SELECCIONADO NINGUNO, MENSAJE DE ERROR
//					JOptionPane.showMessageDialog( null, "Seleccione un vuelo para continuar", "ERROR", JOptionPane.ERROR_MESSAGE);
//				}
//				else {
//					//PASAMOS A LA SIGUIENTE VENTANA DE LA COMPRA
//					BDServicio.log(Level.INFO, "Accediendo a la cantidad de billetes a seleccionar del vuelo", null);
//					VentanaBilletes vent= new VentanaBilletes(usuarioActual,vueloSeleccionado);
//					vent.setVisible(true);
//					dispose();
//					
//				}
//				
//				
//				
//			}
//		});
		
		
		buttonAceptar.setBackground(new Color(102, 204, 204));
		buttonAceptar.setBounds(359, 549, 124, 31);
		contentPane.add(buttonAceptar);
		

		
	
		
		Button buttonBuscarViajeCombinado = new Button("BUSCAR");
		buttonBuscarViajeCombinado.setBounds(245, 208, 70, 19);
		contentPane.add(buttonBuscarViajeCombinado);
		
		buttonBuscarViajeCombinado.setBackground(new Color(102, 204, 204));
		
		ButtonGroup bg=new ButtonGroup();
		
		JCheckBox menorMayor = new JCheckBox("Menor a mayor");
		menorMayor.setBounds(410, 113, 110, 23);
		contentPane.add(menorMayor);
		//POR DEFECTO SELECCIONADO
		menorMayor.setSelected(true);
		
		JCheckBox mayorMenor = new JCheckBox("Mayor a menor");
		mayorMenor.setBounds(410, 146, 113, 23);
		contentPane.add(mayorMenor);
		
		bg.add(menorMayor);
		bg.add(mayorMenor);
		
		
		//EVENTOS DE FILTRADO
//		
		buttonBuscarViajeCombinado.addActionListener(e -> {
//			
			BD.BDServicio.log(Level.INFO,"Realizando filtrado de los Viajes Combinados", null);
			//Obtenenemos los origen y destino 		
//			
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
	
		
			
			
//			//LLAMAMOS AL METODO 
			ArrayList<ViajeCombinado> listaViajesFiltrado = BD.BDServicio.listaServicioCombinadoFiltrado(origen, destino,filtroPrecio);
			
			listaViajesCombinados=listaViajesFiltrado;
		
			//VACIAMOS Y LLENAMOS			
			while (modeloTabla.getRowCount() > 0) {
				modeloTabla.removeRow( 0 );
			}
			
		
			//LLENAMOS
			
		for(ViajeCombinado viaje: listaViajesCombinados) {

			modeloTabla.addRow(new Object [] {viaje.getFecha(),viaje.getHoraSalida(),viaje.getOrigen(),viaje.getVuelo().getDestino(),viaje.getDestino(),viaje.getPrecio()});
		};
			
		tableViajesCombinados.repaint();
			
		});
		
		
		
		
		
		
		
		
		//RENDERERS
		
		tableViajesCombinados.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				if(isSelected) {
					l.setBackground(Color.yellow);
				}else {
					if(listaViajesCombinados.get(row).getPlazasRestantes()<10) {
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
		
		
	
		
		
		JLabel labelFoto;
		ImageIcon imgIcon = new ImageIcon("imagenes//vuelobus.jpg");
		Image image = imgIcon.getImage();
		Image imagenModificada = image.getScaledInstance(300,200,Image.SCALE_SMOOTH);
		ImageIcon nuevoIcono = new ImageIcon(imagenModificada);
		labelFoto = new JLabel ("",nuevoIcono,JLabel.CENTER);
		labelFoto.setBounds(10, 0, 246, 121);
		contentPane.add(labelFoto);
		
	
		
		
		//CREAMOS EVENTO DE RATON PARA AL HACER CONTROL CLICK RESTAURAR COMO INICILAMENTE (POR SI NO TENEMOS OPCIONES DESPUES DE FILTRAR EJ.)
		//daigual donde hagamos el click + plus
		
		
		KeyListener key = new KeyAdapter() {
			
		public void keyReleased(KeyEvent f) {
			if (f.isControlDown() && f.getKeyCode() == KeyEvent.VK_PLUS) {
		}
			//entonces llenamos la lista que manejamos primero
			
			listaViajesCombinados=BDServicio.mostrarViajesCombinadosTotal();
			//DESPUES LLENAMOS EL MODELO, VACIAMOS PRIMERO
			
			while (modeloTabla.getRowCount() > 0) {
				modeloTabla.removeRow( 0 );
			}
							
							
						//LLENAMOS
							
			  for(ViajeCombinado viaje: listaViajesCombinados) {
				modeloTabla.addRow(new Object [] {viaje.getFecha(),viaje.getHoraSalida(),viaje.getOrigen(),viaje.getVuelo().getDestino(),viaje.getDestino(),viaje.getPrecio()});
			}
							}
		
				};
	
				
				tableViajesCombinados.addKeyListener(key);
				this.addKeyListener(key);
				buttonAceptar.addKeyListener(key);
				buttonBuscarViajeCombinado.addKeyListener(key);
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

