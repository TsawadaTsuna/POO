//Kevin Daniel Contreras Hernanzdez A01635597
//Juan Diego
//Clase Carta
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Carta extends JPanel implements MouseListener {
    private String nombre;//Nombre de carta
    private Image imagen;//Imagen de la carta
    private boolean encontrada,//Define si ya se encotro su par
                    estado;//false:cerrada, true:abierto//Este lo puse para iniciar el Thread con el click, si quieres este puedes modificarlo
    private Tablero tablero;//Le paso un tablero para que tenga referencia a carta 1 y carta 2, para trabajar sobre esas y no estar recorriendo el arreglo a cada rato



    public Carta(String nombre,String image,Tablero tablero){//Se pasa un nombre, el nombre de la imagen (carta.jpg) y el tablero
        super();
        this.setPreferredSize(new Dimension(300,300));
        this.nombre=nombre;
        this.imagen=new ImageIcon(image).getImage();
        this.estado=false;
        this.encontrada=false;
        this.addMouseListener(this);
        this.tablero=tablero;

    }

    public boolean abrir(){
        if(!this.estado) {
            this.estado = true;
            this.repaint();
            return true;
        }else{
            return false;
        }

    }

    public boolean cerrar(){
        if(this.estado&&!this.encontrada){
            this.estado=false;
            this.repaint();
            return true;
        }else{
            this.repaint();
            return false;
        }
    }
    public void parEncontrado(){
        this.encontrada=true;
    }
    public void pintaCarta(Graphics g){
        if(this.estado){
            g.drawImage(this.imagen,0,0,this.getWidth(),this.getHeight(),this);
        }else {
            g.drawImage(new ImageIcon("cartaDefault.jpg").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        this.pintaCarta(g);

    }
    public boolean equals(Object ob){
        Carta car = (Carta)ob;
        return (this.toString()==car.toString());


    }
    public String toString(){
        return this.nombre;
    }

    public boolean isEncontrada() {
        return encontrada;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //Tengo algunos codigos comentados mientras hacia pruebas. Puedes dejarlos o borrarlos

        if(this.tablero.getCarta1()==null&&!this.estado){//Verifica que el atributo carta1 del tablero sea null, entonces asigna esta carta como la uno
            this.tablero.setCarta1(this);
            this.abrir();
        }else if(this.tablero.getCarta2()==null&&!this.estado){//sino si carta2 es null asigana esta como la carta 2
            this.tablero.setCarta2(this);
            this.abrir();
            if(this.tablero.getCarta1().equals(this.tablero.getCarta2())){//Verifica que son iguales
                this.tablero.getCarta1().parEncontrado();
                this.tablero.getCarta2().parEncontrado();
                this.tablero.incrementParesEncontrados();
                this.tablero.getTurno().incrementScore();
            }



            try {

                tablero.tStart();

            }catch(IllegalThreadStateException ex){

            }

            this.tablero.cambiaTurno();


        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
