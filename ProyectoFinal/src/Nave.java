//Kevin Daniel Contreras Hernandez | A01635597
//Jesús Riquelmer Gaxiola Higuera | A01740223
import javax.swing.*;
import java.awt.*;

public class Nave extends JPanel  {
    private int x,y,vida;


    public Nave(){
        super();
        this.setPreferredSize(new Dimension(100,50));
        x=0;
        y=0;
        vida=3;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x += x;

    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y += y;
    }

    public void pintaNave(Graphics g){
        g.drawImage(new ImageIcon("naavee.png").getImage(),0,0,this.getWidth(),this.getHeight(),null);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        pintaNave(g);
    }


    public void colisionEnemigo(Enemigo ene){//Colision contra enemigo
        if(ene.getX()>this.x&&ene.getY()>this.y&&ene.getX()-(this.x+100)<=0&&ene.getY()-(this.y+50)<0&&ene.isCrash()&&ene.img!="fon.png"){
            this.vida--;
            ene.setCrash(false);
        }
    }

    public void colisionBalaEnemigo(BalaEnemiga bal){//Colision bala enemiga
        if(bal.getX()>this.x&&bal.getY()>this.y&&bal.getX()-(this.x+100)<=0&&bal.getY()-(this.y+50)<0&&bal.isHit()){
            this.vida-=1;
            bal.setHit(false);
            bal.desaparece();
        }

    }

    public int getVida() {
        return vida;
    }

    public boolean morir(){
        return (vida<=0);
    }

}
