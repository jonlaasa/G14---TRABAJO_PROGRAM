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
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;

public class VentanaVuelo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVuelo frame = new VentanaVuelo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaVuelo() {
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 707);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(90, 25, 423, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(90, 61, 423, 22);
		contentPane.add(comboBox_1);
		
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
		
		table = new JTable();
		table.setBounds(22, 178, 491, 460);
		contentPane.add(table);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.BLACK);
		lblPrecio.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblPrecio.setBounds(22, 104, 58, 25);
		contentPane.add(lblPrecio);
		
		JLabel lblFiltart = new JLabel("Filtrar por:");
		lblFiltart.setHorizontalAlignment(SwingConstants.LEFT);
		lblFiltart.setForeground(Color.BLACK);
		lblFiltart.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		lblFiltart.setBounds(73, 119, 58, 22);
		contentPane.add(lblFiltart);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("De mayor a menor");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnNewRadioButton.setBounds(22, 136, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnDeMenorA = new JRadioButton("De menor a mayor");
		rdbtnDeMenorA.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnDeMenorA.setBounds(133, 136, 109, 23);
		contentPane.add(rdbtnDeMenorA);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblFecha.setBounds(211, 104, 58, 25);
		contentPane.add(lblFecha);
		
		JLabel lblInicio = new JLabel("Ida:");
		lblInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblInicio.setForeground(Color.BLACK);
		lblInicio.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		lblInicio.setBounds(265, 83, 58, 22);
		contentPane.add(lblInicio);
		
		JLabel lblVuelta = new JLabel("Vuelta:");
		lblVuelta.setHorizontalAlignment(SwingConstants.LEFT);
		lblVuelta.setForeground(Color.BLACK);
		lblVuelta.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		lblVuelta.setBounds(404, 83, 58, 22);
		contentPane.add(lblVuelta);
		
		Button buttonBuscarVuelo = new Button("BUSCAR");
		buttonBuscarVuelo.setActionCommand("buscarVuelo");
		buttonBuscarVuelo.setBackground(new Color(102, 204, 204));
		buttonBuscarVuelo.setBounds(443, 636, 70, 22);
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
		
		Panel panelCalendarioIda = new Panel();
		panelCalendarioIda.setBounds(260, 106, 109, 66);
		contentPane.add(panelCalendarioIda);
		
		Panel panelCalendarioVuelta = new Panel();
		panelCalendarioVuelta.setBounds(404, 106, 109, 66);
		contentPane.add(panelCalendarioVuelta);
	}
}
