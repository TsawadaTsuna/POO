import javax.swing.*;
import java.awt.*;

public class Poligono extends JPanel {

    public Poligono(){
        super();
        this.setPreferredSize(new Dimension(800,800));
    }
    public void dibujaPentagono(Graphics g){
        int[] xc={500,600,700,550,400};
        int[] yc={700,700,600,500,600};
        g.drawPolygon(xc,yc,5);
    }
    public void paintComponent(Graphics g){
        this.dibujaPentagono(g);
    }

}
