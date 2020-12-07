//Kevin Daniel Contreras Hern�ndez | A01635597
//Jesús Riquelmer Gaxiola Higuera | A01740223
import javax.swing.*;
import java.awt.*;

public  class Enemigo extends JPanel {//Clase que define el comportamiento de los enemigos
    protected int x,y,ancho,alto,vida;
    protected String img;
    protected boolean crash,death;//Banderas de choque y muerte
    public Enemigo(int ancho, int alto,int x,int y,String img, int vida){
        super();
        this.x=x;
        this.y=y;
        this.ancho=ancho;
        this.alto=alto;
        this.img=img;
        this.vida=vida;
        this.crash=true;
        this.death=false;
        this.setPreferredSize(new Dimension(ancho,alto));
    }

    public void paintEnemigo(Graphics g){
        g.drawImage(new ImageIcon(img).getImage(),0,0,this.getWidth(),this.getHeight(),null);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        paintEnemigo(g);
    }

    public void mover(int x, int y){
        this.x+=x;
        this.y+=y;
    }




    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public void colisionBala(Bala bal){
        if(bal.getX()>this.x&&bal.getY()>this.y&&bal.getX()-(this.x+this.ancho)<=0&&bal.getY()-(this.y+this.alto)<0&&bal.isHit()&&img!="fon.png"){
            //Verifica empalme de coordenadas entre enemigo y balas al igual que su bandera
            this.vida-=1;
            bal.setHit(false);
            bal.desaparece();
        }

    }

    public boolean morir(){
        if (vida<=0){
            this.death=true;
            return true;
        }
        return false;
    }

    public boolean isCrash() {
        return crash;
    }

    public boolean isDeath() {
        return death;
    }

    public void setCrash(boolean crash) {
        this.crash = crash;
    }


}
