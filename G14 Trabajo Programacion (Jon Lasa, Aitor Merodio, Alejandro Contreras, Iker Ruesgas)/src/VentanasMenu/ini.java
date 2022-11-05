package VentanasMenu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;

public class ini extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ini frame = new ini();
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
	public ini() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 334);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 204, 255));
		menuBar.setForeground(Color.BLACK);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(new ImageIcon("imagenes/icons//png-transparent-font-awesome-bar-bel-the-dragon-computer-icons-buttons-miscellaneous-rectangle-bar.jpg"));
		//new ImageIcon("imagenes//iconoRegistro.png
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Vuelos");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Buses");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Interrail");
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("TOP");
		menuBar.add(mnNewMenu_4);
		
		JButton btnNewButton = new JButton("");
		menuBar.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon("imagenes/icons//kisspng-computer-icons-user-membership-vector-5b498fc76f2a07.4607730515315475914553.jpg"));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("imagenes/icons/kisspng-airplane-computer-icons-aircraft-icon-a5-air-transport-5b10f05fb9f810.1049603215278367677617.jpg"));
		lblNewLabel.setBounds(157, 35, 60, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Vuelos");
		btnNewButton_1.setIcon(null);
		btnNewButton_1.setBounds(10, 35, 137, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("imagenes/icons/kisspng-visakhapatnam-bus-computer-icons-icons-download-bus-png-5ab0d27c5d2195.9444277015215376603815.jpg"));
		lblNewLabel_1.setBounds(157, 101, 60, 23);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Buses");
		btnNewButton_2.setBounds(10, 101, 137, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Viaje Combinado");
		btnNewButton_3.setBounds(10, 167, 133, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("imagenes/icons/descarga.jpg"));
		lblNewLabel_2.setBounds(170, 159, 60, 37);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("EUROPA");
		lblNewLabel_3.setBounds(41, 11, 80, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NACIONAL");
		lblNewLabel_4.setBounds(41, 76, 60, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("NACIONAL");
		lblNewLabel_5.setBounds(41, 146, 60, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("imagenes/icons/avionNN.jpg"));
		lblNewLabel_6.setBounds(272, 11, 139, 179);
		contentPane.add(lblNewLabel_6);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
