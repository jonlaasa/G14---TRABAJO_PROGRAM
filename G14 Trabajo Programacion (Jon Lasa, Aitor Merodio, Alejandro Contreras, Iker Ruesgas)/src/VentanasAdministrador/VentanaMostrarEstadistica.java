package VentanasAdministrador;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import BD.BDServicio;
import Datos.Administrador;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.awt.Color;

public class VentanaMostrarEstadistica extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


	public VentanaMostrarEstadistica(Administrador u) {
		
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonVolver = new JButton("VOLVER");
		botonVolver.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		botonVolver.setBackground(new Color(255, 255, 224));
		botonVolver.setBounds(10, 574, 96, 26);
		contentPane.add(botonVolver);
		
		JLabel lblNewLabel = new JLabel("ESTADISTICAS GENERALES");
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 17));
		lblNewLabel.setBounds(21, 35, 201, 22);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBoxGeneral = new JComboBox();
		comboBoxGeneral.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		comboBoxGeneral.setBounds(21, 68, 263, 22);
		comboBoxGeneral.addItem("MEDIA DE PRECIO DE COMPRA");
		comboBoxGeneral.addItem("COMPRA MAS CARA");
		comboBoxGeneral.addItem("COMPRA MAS BARATA");
		comboBoxGeneral.addItem("USUARIO CON MAS COMPRAS");
		comboBoxGeneral.addItem("DESTINO MAS VISITADO");
		contentPane.add(comboBoxGeneral);
		
		JPanel panelGrafico = new JPanel();
		panelGrafico.setBackground(new Color(255, 255, 224));
		panelGrafico.setBounds(21, 237, 525, 352);
		contentPane.add(panelGrafico);
		
		JButton botonBuscarSimple = new JButton("");
		botonBuscarSimple.setBackground(new Color(255, 255, 224));
		botonBuscarSimple.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		botonBuscarSimple.setBounds(414, 92, 45, 42);
		
		//CREAMOS EL ICONO DE BUSQUEDA
		ImageIcon imagenbuscar =  new ImageIcon("src/ImagenesPNG/buscarIcon.png");
		Icon i= new ImageIcon(imagenbuscar.getImage().getScaledInstance(botonBuscarSimple.getWidth(), botonBuscarSimple.getHeight(), Image.SCALE_SMOOTH));
		
		botonBuscarSimple.setIcon(i);
		contentPane.add(botonBuscarSimple);
		
		JLabel lblNewLabel_1 = new JLabel("ESTADISTICAS AVANZADAS");
		lblNewLabel_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(21, 160, 220, 22);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBoxAvanzado = new JComboBox();
		comboBoxAvanzado.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		comboBoxAvanzado.setBounds(21, 193, 379, 22);
		comboBoxAvanzado.addItem("NUMERO DE COMPRAS/MES");
		comboBoxAvanzado.addItem("NUMERO DE COMPRAS/TIPO DE SERVICIO");
		comboBoxAvanzado.addItem("NUMERO DE COMPRAS/DESTINOS");
		
		contentPane.add(comboBoxAvanzado);
		
		 
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(21, 109, 379, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton botongrafico = new JButton("GRAFICAR");
		botongrafico.setBackground(new Color(255, 255, 224));

		botongrafico.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		botongrafico.setBounds(443, 193, 96, 26);
		contentPane.add(botongrafico);
		

		
		//CREAMOS LA IMAGEN DE FONDO
		ImageIcon imagenFondo =  new ImageIcon("src/ImagenesPNG/fondoEstadistica.png");
		ImageIcon nuevoIcono = new ImageIcon(imagenFondo.getImage().getScaledInstance(584,611,Image.SCALE_AREA_AVERAGING));
		
		JLabel labelFondo = new JLabel("",nuevoIcono,JLabel.CENTER);
		labelFondo.setBounds(0, 0, 584, 611);

		contentPane.add(labelFondo);
		
		JComboBox comboBoxServicio = new JComboBox();
		comboBoxServicio.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		comboBoxServicio.setBounds(296, 68, 104, 22);
		comboBoxServicio.addItem("VUELO");
		comboBoxServicio.addItem("BUS");
		comboBoxServicio.addItem("VIAJE COMBINADO");
		contentPane.add(comboBoxServicio);
		
		botonVolver.addActionListener(e->{
			VentanaInicioAdmin vb = null;
			vb = new VentanaInicioAdmin(u);
			vb.setVisible(true);
			dispose();
		});
		
		//BOTON PARA CONSULTAS SIMPLES
		
		botonBuscarSimple.addActionListener(e->{
			String resultado="";
			String servicio= comboBoxServicio.getSelectedItem().toString();
			if (comboBoxGeneral.getSelectedItem().toString()=="MEDIA DE PRECIO DE COMPRA") {
				resultado=BDServicio.mediaCompras(servicio,BDServicio.baseDatosServicio);
			} else if (comboBoxGeneral.getSelectedItem().toString()=="COMPRA MAS CARA") {
				resultado=BDServicio.compraMax(servicio,BDServicio.baseDatosServicio);
			} else if (comboBoxGeneral.getSelectedItem().toString()=="COMPRA MAS BARATA") {
				resultado=BDServicio.compraMin(servicio,BDServicio.baseDatosServicio);
			} else if (comboBoxGeneral.getSelectedItem().toString()=="USUARIO CON MAS COMPRAS") {
				resultado=BDServicio.usuarioMasCompra(servicio,BDServicio.baseDatosServicio);
			} else {
				resultado=BDServicio.destinoMasvisitado(servicio,BDServicio.baseDatosServicio);
			}
			textField.setText(resultado);
		});
		
		//BOTON PARA GRAFICOS
		
		botongrafico.addActionListener(e->{
			//CODIGO PARA HACER GRAFICOS
			String tipodegrafico= comboBoxAvanzado.getSelectedItem().toString();
			DefaultCategoryDataset datos = new DefaultCategoryDataset();
			ArrayList<Integer> resultados= new ArrayList<Integer>();
			
			if (tipodegrafico=="NUMERO DE COMPRAS/MES") {
				
				resultados=BDServicio.comprasAnualesTotales(BDServicio.baseDatosServicio);
				panelGrafico.removeAll();
				
				datos.addValue(resultados.get(0), "Enero", "Ene");
				datos.addValue(resultados.get(1),"Febrero","Feb");
				datos.addValue(resultados.get(2),"Marzo","Mar");
				datos.addValue(resultados.get(3),"Abril","Abr");
				datos.addValue(resultados.get(4),"Mayo","May");
				datos.addValue(resultados.get(5),"Junio","Jun");
				datos.addValue(resultados.get(6),"Julio","Jul");
				datos.addValue(resultados.get(7),"Agosto","Ags");
				datos.addValue(resultados.get(8),"Septiembre","Sep");
				datos.addValue(resultados.get(9),"Octubre","Oct");
				datos.addValue(resultados.get(10),"Noviembre","Nov");
				datos.addValue(resultados.get(11),"Diciembre","Dic");
				
				JFreeChart grafico_barras = ChartFactory.createBarChart3D("COMPRAS MENSUALES 2022", "Meses", "Compras",datos, PlotOrientation.VERTICAL, false, true, false);
				grafico_barras.setBackgroundPaint(new Color(255, 255, 224));
				ChartPanel panelg =  new ChartPanel(grafico_barras);
				panelg.setPreferredSize(panelGrafico.getSize());
			
				panelGrafico.add(panelg);
				panelGrafico.setVisible(true);
				pack();
				setBounds(100, 100, 600, 650);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setLocationRelativeTo(null);
				
			} else if (tipodegrafico=="NUMERO DE COMPRAS/TIPO DE SERVICIO") {
				resultados=BDServicio.comprasServicio(BDServicio.baseDatosServicio);
				panelGrafico.removeAll();
				
				DefaultPieDataset datos2 = new DefaultPieDataset();
				datos2.setValue("Vuelos",resultados.get(0));
				datos2.setValue("Buses",resultados.get(1));
				datos2.setValue("Viajes Combinados",resultados.get(2));
				
				JFreeChart grafico_tarta = ChartFactory.createPieChart3D("SERVICIOS COMPRADOS 2022", datos2, true, true, false);
				grafico_tarta.setBackgroundPaint(new Color(255, 255, 224));
				grafico_tarta.setBorderPaint(Color.CYAN);
				ChartPanel panelg =  new ChartPanel(grafico_tarta);
				panelg.setPreferredSize(panelGrafico.getSize());
				panelGrafico.add(panelg);
				panelGrafico.setVisible(true);
				pack();
				setBounds(100, 100, 600, 650);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setLocationRelativeTo(null);
				
			} else {
				resultados=BDServicio.comprasDestino(BDServicio.baseDatosServicio);
				panelGrafico.removeAll();
				
				datos.addValue(resultados.get(0),"Barcelona", "BRC");
				datos.addValue(resultados.get(1),"Madrid","MDR");
				datos.addValue(resultados.get(2),"Valencia","VAL");
				datos.addValue(resultados.get(3),"Lugo","LGO");
				datos.addValue(resultados.get(4),"Murcia","MRC");
				datos.addValue(resultados.get(5),"Bilbao","BIO");
				datos.addValue(resultados.get(6),"Cadiz","CDZ");
				datos.addValue(resultados.get(7),"Lisboa","LIS");
				datos.addValue(resultados.get(8),"Santander","SNT");
				datos.addValue(resultados.get(9),"Castellon","CAS");

				
				JFreeChart grafico_barras = ChartFactory.createBarChart3D("COMPRAS POR DESTINOS 2022", "Destinos", "Compras",datos, PlotOrientation.VERTICAL, false, true, false);
				grafico_barras.setBackgroundPaint(new Color(255, 255, 224));
				ChartPanel panelg =  new ChartPanel(grafico_barras);
				panelg.setPreferredSize(panelGrafico.getSize());
				panelGrafico.add(panelg);
				panelGrafico.setVisible(true);
				pack();
				setBounds(100, 100, 600, 650);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setLocationRelativeTo(null);
			}
			
		});
	}
}
