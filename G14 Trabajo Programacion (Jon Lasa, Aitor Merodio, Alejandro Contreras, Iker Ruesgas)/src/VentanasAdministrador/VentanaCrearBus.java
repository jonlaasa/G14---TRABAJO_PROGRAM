package VentanasAdministrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import BD.BDServicio;
import Datos.Administrador;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;

import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;

public class VentanaCrearBus extends JFrame {

	private JPanel contentPane;
	private JTextField tfDuracion;
	private JTextField tfHoraSalida;
	private final static SimpleDateFormat SDF_FECHA_FOTO = new SimpleDateFormat("yyyy-MM-dd");
	private JTextField tfPrecio;
	private JTextField textFieldCompanya;
	private JComboBox<String> comboBoxDestino;
	private JComboBox<String> comboBoxOrigen;
	private JComboBox<String> comboBoxPlazas;
	

	public VentanaCrearBus(Administrador adminActual) {

		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		comboBoxOrigen = new JComboBox<String>();
		comboBoxOrigen.setBounds(151, 231, 150, 22);
		comboBoxOrigen.addItem("Barcelona");
		comboBoxOrigen.addItem("Madrid");
		comboBoxOrigen.addItem("Valencia");
		comboBoxOrigen.addItem("Lugo");
		comboBoxOrigen.addItem("Murcia");
		comboBoxOrigen.addItem("Bilbao");
		comboBoxOrigen.addItem("Cadiz");
		comboBoxOrigen.addItem("Lisboa");
		comboBoxOrigen.addItem("Santander");
		comboBoxOrigen.addItem("Castellon");

		contentPane.add(comboBoxOrigen);
		
		comboBoxDestino = new JComboBox<String>();
		comboBoxDestino.setBounds(151, 279, 150, 22);
		comboBoxDestino.addItem("Barcelona");
		comboBoxDestino.addItem("Madrid");
		comboBoxDestino.addItem("Valencia");
		comboBoxDestino.addItem("Lugo");
		comboBoxDestino.addItem("Murcia");
		comboBoxDestino.addItem("Bilbao");
		comboBoxDestino.addItem("Cadiz");
		comboBoxDestino.addItem("Lisboa");
		comboBoxDestino.addItem("Santander");
		comboBoxDestino.addItem("Castellon");

		contentPane.add(comboBoxDestino);
		
		tfDuracion = new JTextField();
		tfDuracion.setBounds(65, 124, 78, 20);
		contentPane.add(tfDuracion);
		tfDuracion.setColumns(10);
		
		tfHoraSalida = new JTextField();
		tfHoraSalida.setBounds(214, 177, 113, 20);
		contentPane.add(tfHoraSalida);
		tfHoraSalida.setColumns(10);
		
		comboBoxPlazas= new JComboBox<String>();
		comboBoxPlazas.setBounds(151, 333, 150, 22);
		comboBoxPlazas.addItem("50 (Estandar)");
		comboBoxPlazas.addItem("100 (Grande)");
		contentPane.add(comboBoxPlazas);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(133, 552, 89, 23);
		contentPane.add(btnVolver);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(347, 552, 89, 23);
		contentPane.add(btnCrear);
		
		tfPrecio = new JTextField();
		tfPrecio.setColumns(10);
		tfPrecio.setBounds(350, 334, 86, 20);
		contentPane.add(tfPrecio);
		
		JLabel lablTitulo = new JLabel("Crear BUSES");
		lablTitulo.setForeground(Color.GREEN);
		lablTitulo.setFont(new Font("Eras Light ITC", Font.BOLD, 25));
		lablTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lablTitulo.setBounds(133, 11, 285, 50);
		contentPane.add(lablTitulo);
		
		JLabel lblNewLabel = new JLabel("FECHA:");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(285, 87, 62, 14);
		contentPane.add(lblNewLabel);
		
		JCalendar calendarFecha = new JCalendar();
		calendarFecha.setWeekOfYearVisible(false);
		calendarFecha.getDayChooser().getDayPanel().setForeground(new Color(204, 255, 255));
		calendarFecha.getDayChooser().getDayPanel().setBackground(new Color(204, 255, 255));
		calendarFecha.setBounds(359, 87, 184, 153);
		contentPane.add(calendarFecha);
		
		JLabel lblDuracion = new JLabel("DURACION:");
		lblDuracion.setForeground(Color.WHITE);
		lblDuracion.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		lblDuracion.setBounds(65, 88, 113, 14);
		contentPane.add(lblDuracion);
		
		JLabel lblEnSegundos = new JLabel("segundos");
		lblEnSegundos.setForeground(Color.WHITE);
		lblEnSegundos.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 13));
		lblEnSegundos.setBounds(146, 130, 113, 14);
		contentPane.add(lblEnSegundos);
		
		JLabel lblHoraSalida = new JLabel("HORA SALIDA:");
		lblHoraSalida.setForeground(Color.WHITE);
		lblHoraSalida.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		lblHoraSalida.setBounds(65, 179, 139, 14);
		contentPane.add(lblHoraSalida);
		
		JLabel lblFormatoXxxx = new JLabel("formato XX:XX");
		lblFormatoXxxx.setForeground(Color.WHITE);
		lblFormatoXxxx.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 12));
		lblFormatoXxxx.setBounds(254, 157, 113, 14);
		contentPane.add(lblFormatoXxxx);
		
		JLabel lblOrigen = new JLabel("ORIGEN:");
		lblOrigen.setForeground(Color.WHITE);
		lblOrigen.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		lblOrigen.setBounds(65, 231, 139, 14);
		contentPane.add(lblOrigen);
		
		JLabel lblDestino = new JLabel("DESTINO:");
		lblDestino.setForeground(Color.WHITE);
		lblDestino.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		lblDestino.setBounds(65, 282, 139, 14);
		contentPane.add(lblDestino);
		
		JLabel lblPlazas = new JLabel("PLAZAS:");
		lblPlazas.setForeground(Color.WHITE);
		lblPlazas.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		lblPlazas.setBounds(65, 336, 139, 14);
		contentPane.add(lblPlazas);
		
		JLabel lblPrecio = new JLabel("PRECIO:");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		lblPrecio.setBounds(353, 287, 139, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblFormato = new JLabel("formato 00.0");
		lblFormato.setForeground(Color.WHITE);
		lblFormato.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 12));
		lblFormato.setBounds(441, 341, 113, 14);
		contentPane.add(lblFormato);
		
		JLabel lblCompaia = new JLabel("COMPAÑIA:");
		lblCompaia.setForeground(Color.WHITE);
		lblCompaia.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		lblCompaia.setBounds(65, 398, 139, 14);
		contentPane.add(lblCompaia);
		
		textFieldCompanya = new JTextField();
		textFieldCompanya.setBounds(188, 396, 248, 20);
		contentPane.add(textFieldCompanya);
		textFieldCompanya.setColumns(10);
		
		JLabel lblPeriodo = new JLabel("PERIODO:");
		lblPeriodo.setForeground(Color.WHITE);
		lblPeriodo.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		lblPeriodo.setBounds(65, 468, 139, 14);
		contentPane.add(lblPeriodo);
		
		  ButtonGroup bg=new ButtonGroup();
		JCheckBox semanal = new JCheckBox("Semanal");
		semanal.setBackground(new Color(0, 51, 51));
		semanal.setForeground(new Color(255, 255, 255));
		semanal.setBounds(214, 464, 109, 23);
		contentPane.add(semanal);
		//POR DEFECTO SELECCIONADO
		semanal.setSelected(true);
		
		JCheckBox mensual = new JCheckBox("Mensual");
		mensual.setForeground(Color.WHITE);
		mensual.setFont(new Font("Tahoma", Font.PLAIN, 13));
		mensual.setBackground(new Color(0, 51, 51));
		mensual.setBounds(324, 464, 109, 23);
		contentPane.add(mensual);
		
		bg.add(semanal);
		bg.add(mensual);
		
		
		//RENDERES PARA LOS COMBOX
		
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
		
		comboBoxPlazas.setRenderer( new DefaultListCellRenderer() {

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				// TODO Auto-generated method stub

				JLabel l= (JLabel)  super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				
				if(isSelected) {
					l.setBackground(Color.lightGray);
				}else {
					l.setBackground(Color.white);
				}
				return l;
			}
		});
		

		
		btnVolver.addActionListener(e->{
			VentanaInicioAdmin vb = null;
			vb = new VentanaInicioAdmin(adminActual);
			vb.setVisible(true);
			dispose();
		});
		
		btnCrear.addActionListener(e->{
			if (comboBoxDestino.getSelectedIndex()==-1 || comboBoxOrigen.getSelectedIndex()==-1 || textFieldCompanya.getText().toString()=="" || tfDuracion.getText().toString()=="" || tfHoraSalida.getText().toString()=="" || tfPrecio.getText().toString()=="") {
				JOptionPane.showMessageDialog(null,"Por favor rellene todos los campos");
			}else if (comboBoxDestino.getSelectedItem()==comboBoxOrigen.getSelectedItem()) {
				JOptionPane.showMessageDialog(null,"Origen y destino incorrecto");
			}else {
				String destino = comboBoxDestino.getSelectedItem().toString();
				String origen = comboBoxOrigen.getSelectedItem().toString();
				int plazas=100; //Default value
				if (comboBoxPlazas.getSelectedItem().toString()=="50 (Estandar)") {
					plazas=50;
				}else {
					plazas=100;
				}
				int duracion = Integer.valueOf(tfDuracion.getText());
				String companya = textFieldCompanya.getText();
				double precio = Double.valueOf(tfPrecio.getText());
				Date fecha =calendarFecha.getDate();
				String horaSalida= tfHoraSalida.getText();
				//Por defecto el button semanal estara activado
				boolean semanalBox=false;
				boolean mensualBox=false;
					
				
				if(semanal.isSelected()) {
					semanalBox=true;
					mensualBox=false;
					
				}else {
					semanalBox=false;
					mensualBox=true;
				}
				
				
				
					
					BDServicio.crearBuses(fecha, horaSalida, duracion, origen, destino, precio, plazas, companya, semanalBox,
							mensualBox,BDServicio.baseDatosServicio);
					
					JOptionPane.showMessageDialog(null, "Bus creado","OPERACION COMPLETADA",JOptionPane.INFORMATION_MESSAGE);
			
				
//				BDServicio.log(Level.INFO, "NUEVOS BUSES CREADOS", null);
			}
			
			
		});

}
}
