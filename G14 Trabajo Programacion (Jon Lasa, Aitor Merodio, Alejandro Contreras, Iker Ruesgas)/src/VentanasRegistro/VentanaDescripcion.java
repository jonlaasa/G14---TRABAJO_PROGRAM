package VentanasRegistro;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.logging.Level;

import javax.swing.*;

import BD.BDRegistro;

public class VentanaDescripcion extends JFrame {

	private JTextArea textArea;
	JScrollPane scroll;  
	
	public VentanaDescripcion() {
		
		//Creamos la  ventana Descripcion 
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setBounds(100, 100, 700, 450);
		setLocationRelativeTo( null );
		JPanel panelArriba = new JPanel();
		JLabel labelDescripcion = new JLabel("Descripcion de T&T");
		labelDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelDescripcion.setForeground(new Color(255, 128, 0));
		panelArriba.add(labelDescripcion,BorderLayout.CENTER);
		getContentPane().add(panelArriba, BorderLayout.NORTH );
		
		//Creamos los JTextArea y lo introducimos en el JScrollPane
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scroll = new JScrollPane( textArea );
		getContentPane().add( scroll, BorderLayout.CENTER );
		JPanel panelBotonera = new JPanel();
		
		//Botones para subir y bajar el texto, que funcionaran con hilos 
		
		JButton botonSubir = new JButton( "^" );
		JButton botonBajar = new JButton( "v" );
		JButton bcerrar = new JButton("Cerrar");
		panelBotonera.add( botonSubir );
		panelBotonera.add( botonBajar );
		panelBotonera.add( bcerrar );
		
		
		//SI PULSAMOSS CERRAR, CERRAMOS LA DESCRIPCION
		
		bcerrar.addActionListener((e) -> {
			BDRegistro.log(Level.INFO, "Volviendo a la ventana de Inicio" , null);
			
			dispose();
			
			
			
			
		});
		
		getContentPane().add( panelBotonera, BorderLayout.SOUTH );
		
		
		//Cargamos el fichero .txt
		this.cargaDescripcion();
		
		//FUNCIONAMIENTO BOTONES SUBIR Y BAJAR (LLAMAN A LA FUNCION PARA MOVERLO, PASANDO COMO PARAMETRO EL VALOR ACTUAL +-UN INCREMENTO
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
	
	//A traves de hilos, haremos que si clica dos veces, se guarden y se ejecuten en serie. 
	
	private Thread hiloUltimo = null;  
	
	private void muevePagina( int pixelsVertical ) {
		Thread hiloAEjecutar = new Thread() {  // 
			public void run() {
				if (hiloUltimo!=null) {  // Si hay otro hilo funcionando esperar a que acabe A TRAVES DE JOIN CON ESE. EL NUEVO, LO FIJAMOS COMO ULTIMO
					
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
				if (pixelsVertical>0) {
					for (int i=0; i<pixelsVertical; i++) {
						bVertical.setValue( bVertical.getValue() + 1 );
						try {Thread.sleep(10); } catch (InterruptedException e) {}
					}
				} else {
					for (int i=0; i<Math.abs(pixelsVertical); i++) {
						bVertical.setValue( bVertical.getValue() - 1 );
						try {Thread.sleep(10); } catch (InterruptedException e) {}
					}
				}
				if (hiloUltimo==this) {  // SI ES EL ULTIMO, EJECUTA Y EL ULTIMO QUEDA A NULL
					hiloUltimo = null;
				}
			}
		};
		hiloAEjecutar.start();
	}
	
	
	//LECTURA DE TEXTO A TRAVES DE SCANNER
	
	public void cargaDescripcion() { 
		try {
			Scanner scanner = new Scanner( VentanaDescripcion.class.getResourceAsStream( "t_descripcion.txt" ));
			while (scanner.hasNextLine()) {
				String lineaEscribir = scanner.nextLine();
				textArea.append( lineaEscribir + "\n" + "\n" );
			}
			
			//COLOCAMOS LA POSICION INICIAL DEL TEXTO EN LA PARTE DE MAS ARRIBA (LOGICAMENTE)
			textArea.setCaretPosition(0);
			BDRegistro.log(Level.INFO, "Descripcion descargada con exito" , null);
			scanner.close();
		} catch (Exception e) {
			//SI NO CONSEGUIMOS CARGARLO, MENSAJE PARA NOTIFICARLO
			JOptionPane.showMessageDialog( this, "El fichero con la descripcion no se ha podido cargar" );
			BDRegistro.log(Level.SEVERE, "Error al cargar descripcion" , e);
		}
	}



}

