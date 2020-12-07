//Kevin Daniel Contreras Hern�ndez | A01635597
//Jesús Riquelmer Gaxiola Higuera | A01740223
import javax.swing.*;
import java.awt.*;

public class Bala extends JPanel {
    protected int x,y;
    protected boolean hit;//Bandera para ver si choco
    protected String img;
    public Bala(int x, int y, String img) {
        super();
        this.setPreferredSize(new Dimension(20, 20));//Panel bala de 20 x 20
        this.x = x;
        this.y = y;
        hit = true;//Bandera para ver si choco

        this.img = img;
    }
    public void paintBala(Graphics g){
        g.drawImage(new ImageIcon(img).getImage(),0,0,this.getWidth(),this.getHeight(),null);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.paintBala(g);
    }

    public void incrementX(int n){
        this.x+=n;
    }

    public void incrementY(int n){
        this.y+=n;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }
    public void desaparece(){
        this.img="fon.png";
    }
}
