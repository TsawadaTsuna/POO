import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PanelObelo extends JPanel implements MouseListener, MouseMotionListener {
    private Obelo obelo;
    public PanelObelo(){
        super();
        this.setPreferredSize(new Dimension(800,600));
        this.obelo = new Obelo(0,0,0,0);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

    }

    public Obelo getObelo() {
        return obelo;

    }

    public void pintarObelo(Graphics g){
        this.obelo.pintaObelo(g);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        pintarObelo(g);
        ObeloMarco om = new ObeloMarco(this.obelo.getxIni(),this.obelo.getyIni(),this.obelo.getAncho(),this.obelo.getAlto());
        om.pintaMarco(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Color tmpColor = JColorChooser.showDialog(this,"Selecciona un color",Color.RED);
        this.obelo.setColorBarra(tmpColor);

        //this.repaint();


    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.obelo.setXYInt(e.getX(),e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println(e.getX()+","+e.getY());
        this.obelo.setXYFin(e.getX(),e.getY());
        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
