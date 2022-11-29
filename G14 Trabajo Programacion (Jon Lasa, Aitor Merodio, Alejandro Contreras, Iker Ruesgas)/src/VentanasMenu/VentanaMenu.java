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

public class VentanaMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu frame = new VentanaMenu();
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
	public VentanaMenu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 204, 255));
		menuBar.setForeground(Color.BLACK);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(new ImageIcon("imagenes/icons//png-transparent-font-awesome-bar-bel-the-dragon-computer-icons-buttons-miscellaneous-rectangle-bar.jpg"));
		//new ImageIcon("imagenes//iconoRegistro.png
		menuBar.add(mnNewMenu);
		
		JMenu jmVuelos = new JMenu("Vuelos");
		menuBar.add(jmVuelos);
		
		JMenu jmBuses = new JMenu("Buses");
		menuBar.add(jmBuses);
		
		JMenu jmInterrail = new JMenu("Interrail");
		menuBar.add(jmInterrail);
		
		JMenu mnNewMenu_4 = new JMenu("TOP");
		menuBar.add(mnNewMenu_4);
		
		JButton btnUsuario = new JButton("");
		menuBar.add(btnUsuario);
		btnUsuario.setIcon(new ImageIcon("imagenes/icons//kisspng-computer-icons-user-membership-vector-5b498fc76f2a07.4607730515315475914553.jpg"));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ftAvion = new JLabel("New label");
		ftAvion.setIcon(new ImageIcon("imagenes/icons/kisspng-airplane-computer-icons-aircraft-icon-a5-air-transport-5b10f05fb9f810.1049603215278367677617.jpg"));
		ftAvion.setBounds(240, 114, 60, 23);
		contentPane.add(ftAvion);
		
		JButton btnVuelos = new JButton("Vuelos");
		btnVuelos.setIcon(null);
		btnVuelos.setBounds(58, 114, 137, 23);
		contentPane.add(btnVuelos);
		
		JLabel ftBus = new JLabel("New label");
		ftBus.setIcon(new ImageIcon("imagenes/icons/kisspng-visakhapatnam-bus-computer-icons-icons-download-bus-png-5ab0d27c5d2195.9444277015215376603815.jpg"));
		ftBus.setBounds(240, 173, 60, 23);
		contentPane.add(ftBus);
		
		JButton btnBuses = new JButton("Buses");
		btnBuses.setBounds(58, 173, 137, 23);
		contentPane.add(btnBuses);
		
		JButton btnViajeCombinado = new JButton("Viaje Combinado");
		btnViajeCombinado.setBounds(62, 232, 133, 23);
		contentPane.add(btnViajeCombinado);
		
		JLabel ftCombinado = new JLabel("");
		ftCombinado.setIcon(new ImageIcon("imagenes/icons/descarga.jpg"));
		ftCombinado.setBounds(240, 218, 60, 37);
		contentPane.add(ftCombinado);
		
		JLabel lblNewLabel_3 = new JLabel("EUROPA");
		lblNewLabel_3.setBounds(99, 89, 80, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NACIONAL");
		lblNewLabel_4.setBounds(99, 148, 60, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("NACIONAL");
		lblNewLabel_5.setBounds(99, 208, 60, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel ftLogo = new JLabel("");
		ftLogo.setIcon(new ImageIcon("imagenes/icons/avionNN.jpg"));
		ftLogo.setBounds(458, 76, 139, 179);
		contentPane.add(ftLogo);
		
		
		
		
		btnUsuario.addActionListener(e -> {
			
			
			VentanaPerfil vp = new VentanaPerfil();
			vp.setVisible(true);
			
			
			
		});
		
		
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
