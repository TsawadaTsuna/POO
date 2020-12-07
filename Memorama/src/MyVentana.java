//Kevin Daniel Contreras Hernanzdez A01635597
//Juan Diego
//Clase MyVentana
import javax.swing.*;

public class MyVentana extends JFrame {

    private Jugador[] jugadores;

    public MyVentana() {
        super("Memorama");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        String[] options = {"1", "2", "3"};

        int players = JOptionPane.showOptionDialog(null, "Selecciona el numero de jugadores",
                "Click a button",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        this.jugadores= new Jugador[players+1];
        for(int i =0;i<this.jugadores.length;i++){
            jugadores[i]=new Jugador(JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador "+(i+1)));
        }


        Tablero tablero = new Tablero(this.jugadores);
        this.add(tablero);

        this.pack();
        this.setVisible(true);

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Hola!");
        MyVentana ventana = new MyVentana();
    }

}

