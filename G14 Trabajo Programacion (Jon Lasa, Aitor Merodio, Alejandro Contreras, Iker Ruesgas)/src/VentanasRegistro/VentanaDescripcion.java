package VentanasRegistro;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

/** Ejercicio de hilos  con ventanas. Esta clase carga el texto del Quijote en un área de texto,
 * y permite navegar por el área con la scrollbar y con botones de página arriba y página abajo.
 * 1. Modificarlo para que al pulsar los botones el scroll se haga con una animación 
 * a lo largo de un segundo, en lugar de en forma inmediata.
 * 2. Prueba a pulsar muy rápido varias páginas abajo. ¿Cómo lo arreglarías para que el scroll
 * en ese caso funcione bien y vaya bajando una página tras otra pero las baje *completas*?
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
@SuppressWarnings("serial")
public class VentanaDescripcion extends JFrame {

	private JTextArea taTexto;
	JScrollPane spTexto;  // atributo de paquete para poder hacer test de JUnit
	JButton bPagAbajo;    // atributo de paquete para poder hacer test de JUnit
	
	public VentanaDescripcion() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setTitle( "Descripcion" );
		setSize( 500, 600 );
		setLocationRelativeTo( null );
		// Pone la ventana relativa a la pantalla
		JPanel panelArriba = new JPanel();
		JLabel labelDescripcion = new JLabel("Descripcion de T&T");
		labelDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelDescripcion.setForeground(new Color(255, 128, 0));
		panelArriba.add(labelDescripcion,BorderLayout.CENTER);
		getContentPane().add(panelArriba, BorderLayout.NORTH );
		
		taTexto = new JTextArea();
		spTexto = new JScrollPane( taTexto );
		getContentPane().add( spTexto, BorderLayout.CENTER );
		JPanel pBotonera = new JPanel();
		JButton bPagArriba = new JButton( "^" );
		bPagAbajo = new JButton( "v" );
		JButton bcerrar = new JButton("Cerrar");
		pBotonera.add( bPagArriba );
		pBotonera.add( bPagAbajo );
		pBotonera.add( bcerrar );
		
		
		bcerrar.addActionListener((e) -> {
			
			dispose();
			
			
			
			
		});
		
		getContentPane().add( pBotonera, BorderLayout.SOUTH );
		
		
		
		this.cargaQuijote();
		bPagArriba.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				muevePagina( -(spTexto.getHeight()-400) );
			}
		});
		bPagAbajo.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				muevePagina( (spTexto.getHeight()-400) );
			}
		});
	}
	
	private Thread ultimoHilo = null;  // El último hilo programado
	
	private void muevePagina( int pixelsVertical ) {
		Thread hiloActual = new Thread() {  // ...porque solo lo usamos aquí
			public void run() {
				if (ultimoHilo!=null) {  // Si hay otro hilo funcionando esperar a que acabe
					try {
						System.out.println( "Hilo " + getName() + " espera a " + ultimoHilo.getName() + "..." );
						Thread anterior = ultimoHilo;
						ultimoHilo = this;
						anterior.join();
						System.out.println( "Final de espera. Hilo " + getName() + " comienza su trabajo." );
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					ultimoHilo = this;
				}
				JScrollBar bVertical = spTexto.getVerticalScrollBar();
				System.out.println( "Moviendo texto de " + bVertical.getValue() + " a " + (bVertical.getValue()+pixelsVertical) );
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
				if (ultimoHilo==this) {  // Si soy el último, marco que ya no queda ninguno
					ultimoHilo = null;
				}
			}
		};
		hiloActual.start();
	}
	
	public void cargaQuijote() { 
		try {
			Scanner scanner = new Scanner( VentanaDescripcion.class.getResourceAsStream( "t_descripcion.txt" ), "UTF-8" );
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				taTexto.append( linea + "\n" + "\n" );
			}
			scanner.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog( this, "No se ha podido cargar el texto" );
		}
	}



}

