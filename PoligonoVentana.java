import javax.swing.*;

public class PoligonoVentana extends JFrame {
    public PoligonoVentana(Poligono p){
        super();
        this.add(p);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        PoligonoVentana pv = new PoligonoVentana(new Poligono());
    }
}
