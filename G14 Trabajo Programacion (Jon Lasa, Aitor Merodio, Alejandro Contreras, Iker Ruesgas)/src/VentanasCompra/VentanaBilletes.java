package VentanasCompra;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class VentanaBilletes extends JFrame implements ActionListener {
	JLabel texto;
	JButton restar, sumar;
	int contador=0;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBilletes frame = new VentanaBilletes();
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
	public VentanaBilletes() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		restar = new JButton(" - ");
		restar.setForeground(new Color(0, 0, 0));
		restar.setBackground(new Color(255, 255, 255));
		restar.setBounds(10, 103, 47, 23);
		contentPane.add(restar);
		restar.addActionListener(this);
		
		texto= new JLabel("");
		texto.setBounds(67, 103, 46, 23);
		contentPane.add(texto);
		
		sumar = new JButton(" + ");
		sumar.setBackground(new Color(255, 255, 255));
		sumar.setBounds(94, 103, 47, 23);
		contentPane.add(sumar);
		
		lblNewLabel = new JLabel("Escoja el número de tickets que desee:");
		lblNewLabel.setBounds(10, 67, 256, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaBilletes.class.getResource("imagenes/icons/boton/icon/icono-de-plano-bus-dise\u00F1o-del-logo-la-agencia-viajes-sobre-fondo-blanco-aislado-vector-eps-avi\u00F3n-us-186014994 (2).jpg")));
		lblNewLabel_1.setBounds(231, 47, 193, 184);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(10, 190, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Ya queda menos");
		lblNewLabel_2.setBounds(10, 157, 181, 14);
		contentPane.add(lblNewLabel_2);
		sumar.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== restar ) {
			contador--;
			if (contador<0){
				contador=0;
			}
	    }
		if(e.getSource()== sumar ) {
			contador++;
			if (contador>200) {
				contador=200;
			}
		}
		texto.setText(contador+"");
	}
}
