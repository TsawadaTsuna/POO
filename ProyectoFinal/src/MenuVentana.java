//Kevin Daniel Contreras Hernandez | A01635597
//Jesús Riquelmer Gaxiola Higuera | A01740223
import javax.swing.JFrame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MenuVentana extends JFrame{

    public MenuVentana() {
        super("Space traveler");
        Menu menu=new Menu(this);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(menu);

        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) throws FileNotFoundException, JavaLayerException {
        MenuVentana vn=new MenuVentana();
        //Musica libreria JLayer
        Player apl = new Player(new FileInputStream("League of Legends Music Bit Rush.mp3"));
        apl.play();
    }
}
