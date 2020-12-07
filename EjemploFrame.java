import javax.swing.*;
import java.awt.*;

public class EjemploFrame extends JFrame{//Heredar de swing
    public EjemploFrame(){//Constructor
        this.setSize(500,500);//Tamano de mi ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//Accion al cerrar
    }


    /*public static void main(String[] args) {
        EjemploFrame v1 = new EjemploFrame();//Objeto
        v1.setTitle("Tituloooo");//EStablece titulo
        v1.setLocation(1000,25);//Pocision inicial
        v1.setBounds(100,25,1000,800);//Location, size
        v1.setLocationRelativeTo(null);//centro
        v1.setVisible(true);//Hacer visible

        JPanel pan = new JPanel();//Crear panel
        pan.setLayout(null);//Desactivar el layout por defecto para poder mover
        v1.getContentPane().add(pan);//Agregar panel
        //pan.setBackground(Color.GREEN);//Color

        JLabel etiq =new JLabel("Texto default",SwingConstants.RIGHT);//Creacion de Label. Constructor con texto y alinacion horizaontal (swingconstant.alineacion)
        etiq.setOpaque(true);//Poder cambiar el fondo del label
        etiq.setBounds(12,20,300,300);
        etiq.setText("Prueba");//Cambia el mensaje
        etiq.setHorizontalAlignment(SwingConstants.CENTER);//Alineacion
        etiq.setForeground(Color.CYAN);
        etiq.setBackground(Color.BLACK);
        pan.add(etiq);//Agregacion

        /*
        import java.swing,ImageIcon;
        Jlabel im = new Jlabel(new ImageIcon("imagename.extension"));//Label de imagen





        JButton boton = new JButton("Boton");//crea boton
        boton.setBounds(200,350,100,50);
        boton.setEnabled(true);//Hablitar o desabilitar
        pan.add(boton);

        JRadioButton radio = new JRadioButton("Radio gaga",true);//crea radioboton texto y seleccionado
        radio.setBounds(320,420,100,100);
        pan.add(radio);
        JRadioButton radio2 = new JRadioButton("Radio gugu",false);
        radio2.setBounds(320,520,100,100);
        pan.add(radio2);

        ButtonGroup radios = new ButtonGroup();//Grupo de botones para que solo se marque 1
        radios.add(radio);
        radios.add(radio2);

        JTextField cajaTex = new JTextField();
        cajaTex.setBounds(500,10,300,300);
        cajaTex.setText("Ahua");
        pan.add(cajaTex);

    }*/
}
