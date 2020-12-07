import java.awt.*;

public class Obelo {
    protected int xIni,yIni,alto,ancho;
    private Color colorBarra;
    private double pBarraAlto, pBolaAlto;
    public Obelo(int xIni, int yIni,int alto, int ancho, Color colorBarra){
        this.xIni=xIni;
        this.yIni=yIni;
        this.alto=alto;
        this.ancho=ancho;
        this.colorBarra=colorBarra;
        this.pBarraAlto=0.20;
        this.pBolaAlto=0.60;
    }
    public Obelo(int xIni, int yIni,int alto, int ancho){
        this(xIni,yIni,alto,ancho,Color.GREEN);
    }

    public int getxIni() {
        return xIni;
    }

    public Color getColorBarra() {
        return colorBarra;
    }

    public int getyIni() {
        return yIni;
    }

    public double getpBarraAlto() {
        return pBarraAlto;
    }

    public double getpBolaAlto() {
        return pBolaAlto;
    }

    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }
    public void setXYInt(int x, int y){
        this.xIni=x;
        this.yIni=y;
    }
    public void setXYFin(int x,int y){
        this.ancho=x-this.xIni;
        this.alto=y-this.yIni;
    }

    public void setColorBarra(Color colorBarra) {
        this.colorBarra = colorBarra;
    }

    public void setpBolaAlto(double pBolaAlto) {
        this.pBolaAlto = pBolaAlto;
    }
    public void pintaObelo(Graphics g){
        double pLibre=(1.0-pBarraAlto)/2.0;
        double anchoLibre=pLibre*this.alto;
        double diametro=anchoLibre*this.pBolaAlto;
        int yBarra=(int)(this.yIni+this.alto*pLibre);
        int xBola=(int)(this.xIni+(this.ancho-diametro)/2.0);
        g.setColor(this.colorBarra);
        g.fillRect(this.xIni, yBarra, this.ancho,(int)(this.alto*this.pBarraAlto));
        g.setColor(Color.GREEN);
        g.fillOval(xBola,this.yIni,(int)(this.alto*pLibre*this.pBolaAlto),(int)(this.alto*pLibre*this.pBolaAlto));
        g.fillOval(xBola,(int)(this.yIni+this.alto-diametro),(int)(this.alto*pLibre*this.pBolaAlto),(int)(this.alto*pLibre*this.pBolaAlto));

    }
}
