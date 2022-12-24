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
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class VentanaMostrarEstadistica extends JFrame {

	private JPanel contentPane;


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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(21, 68, 343, 22);
		contentPane.add(comboBox);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(23, 101, 341, 20);
		contentPane.add(textPane);
		
		JPanel panelGrafico = new JPanel();
		panelGrafico.setBounds(23, 195, 471, 263);
		contentPane.add(panelGrafico);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("Imagenes\\icons\\buscar.png"));
		btnNewButton.setBounds(393, 68, 54, 43);
		contentPane.add(btnNewButton);
	}
}
