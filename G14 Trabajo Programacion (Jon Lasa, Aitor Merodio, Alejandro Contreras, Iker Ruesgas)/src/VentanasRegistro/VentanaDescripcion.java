package VentanasRegistro;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class VentanaDescripcion extends JFrame {

	private JTextArea textArea;
	JScrollPane scroll;  
	
	public VentanaDescripcion() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 500, 600 );
		setLocationRelativeTo( null );
		// Pone la ventana relativa a la pantalla
		JPanel panelArriba = new JPanel();
		JLabel labelDescripcion = new JLabel("Descripcion de T&T");
		labelDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelDescripcion.setForeground(new Color(255, 128, 0));
		panelArriba.add(labelDescripcion,BorderLayout.CENTER);
		getContentPane().add(panelArriba, BorderLayout.NORTH );
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scroll = new JScrollPane( textArea );
		getContentPane().add( scroll, BorderLayout.CENTER );
		JPanel panelBotonera = new JPanel();
		JButton botonSubir = new JButton( "^" );
		JButton botonBajar = new JButton( "v" );
		JButton bcerrar = new JButton("Cerrar");
		panelBotonera.add( botonSubir );
		panelBotonera.add( botonBajar );
		panelBotonera.add( bcerrar );
		
		
		bcerrar.addActionListener((e) -> {
			
			dispose();
			
			
			
			
		});
		
		getContentPane().add( panelBotonera, BorderLayout.SOUTH );
		
		
		
		this.cargaDescripcion();
		botonSubir.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				muevePagina( -(scroll.getHeight()-400) );
			}
		});
		botonBajar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				muevePagina( (scroll.getHeight()-400) );
			}
		});
	}
	
	private Thread hiloUltimo = null;  // El último hilo programado
	
	private void muevePagina( int pixelsVertical ) {
		Thread hiloAEjecutar = new Thread() {  // ...porque solo lo usamos aquí
			public void run() {
				if (hiloUltimo!=null) {  // Si hay otro hilo funcionando esperar a que acabe
					try {
						Thread anterior = hiloUltimo;
						hiloUltimo = this;
						anterior.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					hiloUltimo = this;
				}
				JScrollBar bVertical = scroll.getVerticalScrollBar();
				// bVertical.setValue( bVertical.getValue() + pixelsVertical );
				if (pixelsVertical>0) {
					for (int i=0; i<pixelsVertical; i++) {
						bVertical.setValue( bVertical.getValue() + 1 );
						try {Thread.sleep(10); } catch (InterruptedException e) {}
					}
				} else {
					// for (int i=0; i>pixelsVertical; i--) {
					for (int i=0; i<Math.abs(pixelsVertical); i++) {
						bVertical.setValue( bVertical.getValue() - 1 );
						try {Thread.sleep(10); } catch (InterruptedException e) {}
					}
				}
				if (hiloUltimo==this) {  // Si soy el último, marco que ya no queda ninguno
					hiloUltimo = null;
				}
			}
		};
		hiloAEjecutar.start();
	}
	
	public void cargaDescripcion() { 
		try {
			Scanner scanner = new Scanner( VentanaDescripcion.class.getResourceAsStream( "t_descripcion.txt" ));
			while (scanner.hasNextLine()) {
				String lineaEscribir = scanner.nextLine();
				textArea.append( lineaEscribir + "\n" );
			}
			scanner.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog( this, "El fichero con la descripcion no se ha podido cargar" );
		}
	}



}

