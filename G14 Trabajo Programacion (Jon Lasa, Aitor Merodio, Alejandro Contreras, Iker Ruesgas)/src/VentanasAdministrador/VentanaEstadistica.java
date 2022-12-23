package VentanasAdministrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class VentanaEstadistica extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEstadistica frame = new VentanaEstadistica();
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
	public VentanaEstadistica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ESTADISTICAS GENERALES");
		lblNewLabel.setBounds(23, 23, 171, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(164, 19, 163, 22);
		contentPane.add(comboBox);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(23, 53, 231, 20);
		contentPane.add(textPane);
		
		JPanel panelGrafico = new JPanel();
		panelGrafico.setBounds(23, 128, 471, 263);
		contentPane.add(panelGrafico);
	}
}
