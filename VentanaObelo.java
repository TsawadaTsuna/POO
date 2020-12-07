import javax.swing.*;
import java.awt.*;

public class VentanaObelo extends JFrame {
    public VentanaObelo(PanelObelo po){
        super("Obelo");
        this.add(po);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(new PanelControlesObelo(po), BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        VentanaObelo vo = new VentanaObelo(new PanelObelo());
    }
}
