//Kevin Daniel Contreras Hernandez | A01635597
//Jesús Riquelmer Gaxiola Higuera | A01740223
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel{
    private JButton jugar,
            salir;
    public Menu(MenuVentana mv) {
        super();

        this.setPreferredSize(new Dimension(800,800));
        this.setLayout(null);

        this.jugar=new JButton("Jugar");
        this.salir=new JButton("Salir");

        this.jugar.setBounds(150,600,200,100);
        this.salir.setBounds(450,600,200,100);

        this.jugar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Abre el panel del juego
                setVisible(false);
                Ventana ven=new Ventana();

            }
        });

        this.salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Termina la ejecucion del programa
                mv.dispose();
                System.exit(0);
            }
        });

        this.add(this.jugar);
        this.add(this.salir);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(new ImageIcon("FonoMenu.jpg").getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial",1,90));
        g.drawString("Space Traveler",80,200);
    }
}
