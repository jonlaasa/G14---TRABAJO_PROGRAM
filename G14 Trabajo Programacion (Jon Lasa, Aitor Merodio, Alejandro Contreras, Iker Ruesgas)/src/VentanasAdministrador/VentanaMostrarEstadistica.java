package VentanasAdministrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.Administrador;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VentanaMostrarEstadistica extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


	public VentanaMostrarEstadistica(Administrador u) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ESTADISTICAS GENERALES");
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 17));
		lblNewLabel.setBounds(21, 35, 201, 22);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBoxGeneral = new JComboBox();
		comboBoxGeneral.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		comboBoxGeneral.setBounds(21, 68, 379, 22);
		contentPane.add(comboBoxGeneral);
		
		JPanel panelGrafico = new JPanel();
		panelGrafico.setBackground(new Color(255, 255, 224));
		panelGrafico.setBounds(21, 248, 525, 352);
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
		

	}
}
