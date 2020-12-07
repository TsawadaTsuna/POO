//Kevin Daniel Contreras Hern�ndez | A01635597
//Jesús Riquelmer Gaxiola Higuera | A01740223
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ventana extends JFrame implements KeyListener {

    private Espacio es;//Espacio de juego

    public Ventana(){//Frame del juego
        super("Space traveler");
        this.es = new Espacio(new Nave());

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(this.es);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.addKeyListener(this);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {//Evento de teclado
        if(!this.es.isgOver()) {
            if (e.getKeyCode() == e.VK_UP) {//keycode regresa la tecla y VK es una constante de tecla
                if (this.es.getNave().getY() > 0)
                    this.es.setYNave(-10);
            }
            if (e.getKeyCode() == e.VK_DOWN) {
                if (this.es.getNave().getY() + 50 < 800)
                    this.es.setYNave(10);
            }
            if (e.getKeyCode() == e.VK_RIGHT) {
                if (this.es.getNave().getX() + 100 < 800)
                    this.es.setXNave(10);
            }
            if (e.getKeyCode() == e.VK_LEFT) {
                if (this.es.getNave().getX() > 0)
                    this.es.setXNave(-10);
            }
            this.es.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(!this.es.isgOver()) {
            if (e.getKeyCode() == e.VK_SPACE) {


                for (int i = 0; i < es.getBalas().length; i++) {//Recorre el arreglo hasta un nulo y genera una bala
                    if (es.getBalas()[i] == null) {
                        Bala bal = new Bala(es.getNave().getX() + 110, es.getNave().getY() + 30,"Bala.png");
                        bal.setBounds(this.es.getNave().getX() + 110, this.es.getNave().getY() + 30, 20, 20);
                        es.getBalas()[i] = bal;
                        break;
                    }
                }


            }
        }
        this.es.repaint();
    }
}
