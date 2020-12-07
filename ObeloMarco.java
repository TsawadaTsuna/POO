import java.awt.*;

public class ObeloMarco extends Obelo {
    public ObeloMarco(int xIni, int yIni, int ancho, int alto){
        super(xIni,yIni,alto,ancho);

    }
    public void pintaMarco(Graphics g){
        g.setColor(Color.RED);
        g.drawRect(xIni,yIni,ancho,alto);
    }
}
