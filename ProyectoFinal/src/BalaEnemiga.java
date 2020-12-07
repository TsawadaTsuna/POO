//Kevin Daniel Contreras Hern�ndez | A01635597
//Jesús Riquelmer Gaxiola Higuera | A01740223
import java.awt.*;

public class BalaEnemiga extends Bala{
    private boolean hit;//Bandera para ver si choco
    public BalaEnemiga(int x, int y, String s) {
        super(x, y,"BalaEnemiga.png");
        this.hit=true;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.paintBala(g);
    }
    public void setHit(boolean h){
        this.hit=h;
    }

    @Override
    public boolean isHit() {
        return hit;
    }
}
