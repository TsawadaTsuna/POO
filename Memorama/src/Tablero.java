//Kevin Daniel Contreras Hernanzdez A01635597
//Juan Diego
//ClaseTablero
import java.awt.*;
import java.util.Random;

import javax.swing.*;

public class Tablero extends JPanel implements Runnable{
    private Carta[] cartas;//Arreglo de cartas

    private Carta carta1,//Carta1
            carta2;//Carta2

    private Jugador[] jugadores;//Jugadores

    private Jugador turno;

    private int paresEncontrados,
                contadorTurno;//Pares, no he hecho nada con este, supongo que cada que se encuentra un par aumenta y cuando llegue a 6 acaba el juego
                                 //La verificacion de pares esta en la clase carta, si quieres modificar esto puedes hacer setters ya que referenciamos a tablero en cada carta

    private JPanel panelGrid,//Paneles
            panelJugadores;

    private JLabel turn;

    private Thread t;

    public Tablero(Jugador[] jugadores) {
        super();
        this.jugadores = jugadores;
        this.cartas = new Carta[12];
        this.paresEncontrados = 0;
        this.carta1=null;
        this.carta2=null;
        this.contadorTurno = 0;
        this.turno = jugadores[this.contadorTurno];
        this.setLayout(new BorderLayout());

        this.turn=new JLabel();
        this.t = new Thread(this);
        //this.t.start();

        //Cartas(nombre,String con el nombre de la imagen, el tablero al que referencian las cartas (this en este caso))
        this.cartas[0]=new Carta("Agua","water.jpg",this);
        this.cartas[1]=new Carta("Agua","water.jpg",this);
        this.cartas[2]=new Carta("Fuego","fire.jpg",this);
        this.cartas[3]=new Carta("Fuego","fire.jpg",this);
        this.cartas[4]=new Carta("Planta","nature.jpg",this);
        this.cartas[5]=new Carta("Planta","nature.jpg",this);
        this.cartas[6]=new Carta("Tierra","earth.png",this);
        this.cartas[7]=new Carta("Tierra","earth.png",this);
        this.cartas[8]=new Carta("Core","core.jpg",this);
        this.cartas[9]=new Carta("Core","core.jpg",this);
        this.cartas[10]=new Carta("Sky","sky.jpg",this);
        this.cartas[11]=new Carta("Sky","sky.jpg",this);

        //Panel Grid
        this.panelGrid = new JPanel();
        this.panelGrid.setPreferredSize(new Dimension(1200, 800));
        this.panelGrid.setLayout(new GridLayout(3, 4));
        this.add(this.panelGrid, BorderLayout.CENTER);

        //Agregacion random
        //Tenemos un arreglo de banderas para ver cual ya se agrego
        boolean[] agregados=new boolean[12];
        int n;
        Random ran=new Random();
        for(int i =0;i<12;i++){
            do {
                n = ran.nextInt(12);//Se genera un numero random dependiendo de su respectivo booleano en agregados
            }while (agregados[n]);//Do while para que se genere siempre uno al principio
            agregados[n]=true;
            panelGrid.add(this.cartas[n]);
        }


        //Panel Jugadores
        this.panelJugadores = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                turn.setBounds(20,50,200,20);
                turn.setText("Turno de: "+turno);

                //g.drawString("Turno de: "+turno, 20, 50);
                int j = 70;
                for(int i=0; i < jugadores.length; i++ ) {
                    g.drawString(jugadores[i].getNombre()+": "+jugadores[i].getScore(), 20, 20+j);
                    j+=20;

                }


            }
        };
        this.panelJugadores.add(turn);
        /*JLabel turn = new JLabel();
        turn.setBounds(20,50,200,20);
        turn.setText("Turno de: "+turno);*/
        this.panelJugadores.setLayout(new BorderLayout());
        this.panelJugadores.setPreferredSize(new Dimension(300, 900));
        //this.panelJugadores.add(turn);
        //this.panelJugadores.setBackground(Color.RED);
        this.add(this.panelJugadores, BorderLayout.WEST);







    }

    public void cambiaTurno() {
        this.contadorTurno+=2;
        //JOptionPane.showMessageDialog(null, "Bien");
        if(contadorTurno % 2 == 0&&!carta1.isEncontrada()) {
            this.turno = jugadores[(this.contadorTurno / 2) % this.jugadores.length];
            System.out.println(this.turno);
        }

        this.repaint();
    }

    //Setters
    public void setCarta1(Carta carta1) {
        this.carta1 = carta1;
    }

    public void setCarta2(Carta carta2) {
        this.carta2 = carta2;
    }

    //Getters
    public Carta getCarta1() {
        return carta1;
    }

    public Carta getCarta2() {
        return carta2;
    }

    public Jugador getTurno() {
        return turno;
    }

    public void incrementParesEncontrados(){
        this.paresEncontrados+=1;
    }

    //@Override
    public void run() {
        while(paresEncontrados<6) {
            if (carta1 != null && carta2 != null) {//Cuando las 2 cartas esten asignadas(corriendo en paralelo)
                try {//Sleep de 1 seg
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println("No se pudo");
                }

                try {
                    carta1.cerrar();//cierra carta1
                    carta2.cerrar();//cierra carta2
                }catch (NullPointerException ex){


                }
                this.setCarta1(null);//vuelve carta1 null otra vez para que vuelva a entrar el condicion de mouse clicked
                this.setCarta2(null);//vuelve carta2 null otra vez para que vuelva a entrar el condicion de mouse clicked


            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                System.out.println("No se pudo");
            }

        }
    }

    public void tStart(){
        this.t.start();
    }
}
