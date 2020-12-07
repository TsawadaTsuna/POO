import javax.swing.JFrame;
import java.awt.*;
//import java.util.Stack;

public class MyVentana extends JFrame {
    public MyVentana(){
        super("Primer ventana en java");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setSize(800,600);
        MyPanelDibujo pd = new MyPanelDibujo();
        this.add(pd);
        this.add(new MyPanelControles(pd),BorderLayout.WEST);
        this.pack();
        this.setVisible(true);
    }


    public static void main(String[] args) {
        /*Stack<Integer> pila=new Stack<Integer>(){
          public Integer push(Integer e){
              super.push(e);
              System.out.println("Se me tio el valor "+e);
              return e;
          }
        };*/


        MyVentana ventana = new MyVentana(){
            public void paint(Graphics g){
                super.paint(g);
                g.drawRect(50,50,500,200);
            }
        };


    }
}
