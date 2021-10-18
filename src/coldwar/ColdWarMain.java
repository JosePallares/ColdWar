package coldwar;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import coldwar.utildb.DatosBDD;
import coldwar.utildb.DatosXML;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ColdWarMain extends JFrame implements ActionListener{
	
	public ColdWarMain() {
		setTitle("Cold War");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(crearMenu());
		setSize(300, 300);
		setVisible(true);
		setResizable(false);
	}
	
	
	
	public JPanel crearMenu() {
		JButton btnJugar = new JButton("Nueva partida");
		btnJugar.addActionListener(this);
		btnJugar.setName("jugar");
		JButton btnReglas = new JButton("Reglas juego");
		btnReglas.addActionListener(this);
		btnReglas.setName("reglas");
		JButton btnInfo = new JButton("Información");
		btnInfo.addActionListener(this);
		btnInfo.setName("Info");
		JButton btnRannking = new JButton("Rangking");
		btnRannking.addActionListener(this);
		btnRannking.setName("Rangking");
		JButton btnCargar = new JButton("Cargar partida");
		btnCargar.addActionListener(this);
		btnCargar.setName("cargar");
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setName("salir");
		
		JPanel menu = new JPanel(new GridLayout(6,1));
		
        menu.setBorder(new EmptyBorder(new Insets(10, 20, 50, 20)));
        menu.add(btnJugar);
		menu.add(btnReglas);
		menu.add(btnInfo);
		menu.add(btnRannking);
		menu.add(btnCargar);
		menu.add(btnSalir);
        
        return menu;
	}

	public static void main(String[] args) {
	JFrame ventana = new JFrame("Ventana de gestión de eventos");

        ventana.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("Se abre la ventana");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Cerrando la ventana");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Ventana cerrada");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("Ventana a icono");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GestionEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("Ventana sale de icono");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("Ventana activada");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("Ventana desactivada");
            }
        });
        
      
        ventana.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("Tecla: " + e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Pulsada: " + e.getKeyText(e.getKeyCode()));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Soltada: "  + e.getKeyText(e.getKeyCode()));
            }
        });
        
        ventana.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Pulsado el botón del ratón " + e.getButton());
                System.out.println("En la posición: " + e.getPoint());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("El ratón sale de la ventana");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("El ratón entra en la ventana");
            }
        });
        
        
        ventana.setSize(600, 400);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
            // TODO Auto-generated method stub
        new ColdWarMain();
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) arg0.getSource();
	    if (btn.getName().equals("jugar")) {
             new Jugar(new Partida(), false);
		}else if (btn.getName().equals("reglas")) {
			 new ReglasJuego();
		}else if (btn.getName().equals("Info")) {
			 new Informacion();
		}else if (btn.getName().equals("Rangking")) {
			    new Ranking();
		}else if (btn.getName().equals("cargar")) {
			Partida p = DatosBDD.cargarPartida();
			if (p != null) {
			    new Jugar(p, true);
			}else {
				System.out.println("No hay partida que podamos cargar.");
			}
		}else if (btn.getName().equals("salir")) {
			this.dispose();
		}
			
	}

}


