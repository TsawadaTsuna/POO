//Kevin Daniel Contreras Hernández | A01635597
//Jesús Riquelmer Gaxiola Higuera | A01740223
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Espacio extends JPanel implements Runnable {
    private Nave nave;
    private boolean gOver,ast;//Bandera para acabar el juego, genera asteroides
    private Bala[] balas;//Arreglo de balas
    private BalaEnemiga[] balasera;//Arreglo de balas enemigas
    private Enemigo[] enes;//Arreglo de enemigos sencillos
    private Enemigo[] eds;//Arreglo de enemigos disparadores
    private Enemigo[] as;//Arreglo de asteroides
    private int score;

    public Espacio(Nave nave){
        super();
        Random ran = new Random();
        this.setPreferredSize(new Dimension(800,800));
        this.setLayout(null);
        this.nave=nave;
        this.nave.setBounds(this.nave.getX(),this.nave.getY(),100,50);
        this.add(this.nave);
        this.gOver=false;
        this.ast=false;
        this.balas= new Bala[50];

        enes=new Enemigo[3];
        for(int i=0;i<enes.length;i++) {
            this.enes[i] = new Enemigo(50, 50, 800, ran.nextInt(700), "Enemigo1.png",3);
            this.add(enes[i]);
        }
        eds=new Enemigo[3];
        for(int i =0;i<eds.length;i++) {
            this.eds[i] = new Enemigo(50, 50, 800, ran.nextInt(700), "taank.png",2);
            this.add(eds[i]);
        }
        as= new Enemigo[2];
        for(int i=0;i<as.length;i++) {
            this.as[i] = new Enemigo(70, 70, ran.nextInt(740), -100, "Assteroide.png",2);
            this.add(as[i]);
        }

        balasera= new BalaEnemiga[3];
        for(int i=0;i<balasera.length;i++){
            new BalaEnemiga(eds[i].getX(), eds[i].getY() + 20, "BalaEnemiga.png");
        }

        Thread t = new Thread(this);
        t.start();

    }

    public Nave getNave() {
        return nave;
    }

    public void setXNave(int x){
        nave.setX(x);
    }

    public void setYNave(int y){
        nave.setY(y);
    }

    public void crearEnemigos(){
        Random ran=new Random();
        if(score<500) {
            for(int i=0;i<enes.length;i++) {
                if (enes[i] == null) {
                    this.enes[i] = new Enemigo(50, 50, 800, ran.nextInt(700), "Enemigo1.png",3);
                } else {
                    this.add(enes[i]);
                    this.enes[i].setBounds(this.enes[i].getX(), this.enes[i].getY(), 50, 50);
                    if (enes[i].getX() < -300) {
                        this.enes[i] = null;
                    }
                }
            }
        }

        else  {
            for(int i=0;i<enes.length;i++) {
                if (enes[i] == null) {
                    this.enes[i] = new Enemigo(50, 50, 800, ran.nextInt(700), "Enemigo1.png",3);
                } else {
                    this.add(enes[i]);
                    this.enes[i].setBounds(this.enes[i].getX(), this.enes[i].getY(), 50, 50);
                    if (enes[i].getX() < -200) {
                        this.enes[i] = null;
                    }
                }
            }


            for(int i=0;i<eds.length;i++) {
                if (eds[i] == null) {
                    this.eds[i] = new Enemigo(50, 50, 800, ran.nextInt(700), "taank.png",2);
                } else {
                    this.add(eds[i]);
                    this.eds[i].setBounds(this.eds[i].getX(), this.eds[i].getY(), 50, 50);
                    if (this.eds[i].img != "fon.png") {
                        if (balasera[i] == null) {
                            balasera[i] = new BalaEnemiga(eds[i].getX(), eds[i].getY() + 20, "BalaEnemiga.png");
                        } else {
                            this.add(balasera[i]);
                            balasera[i].setBounds(balasera[i].getX(), balasera[i].getY(), 20, 20);
                            if (balasera[i].getX() < -20 || balasera[i].getY() > 800) {
                                balasera[i] = null;
                            }
                        }
                    }
                    if (eds[i].getX() < -200) {
                        this.eds[i] = null;
                    }
                }
            }

        }

        if(this.ast){
            for(int i=0;i<as.length;i++) {
                if (this.as[i] == null) {
                    this.as[i] = new Enemigo(50, 50, ran.nextInt(700), -100, "Assteroide.png",2);
                } else if (this.as[i] != null) {
                    this.add(this.as[i]);
                    this.as[i].setBounds(this.as[i].getX(), this.as[i].getY(), 50, 50);
                    if (this.as[i].getY() > 1000) {
                        this.as[i] = null;
                        this.ast = false;
                    }
                }
            }
        }

        for (int i = 0; i < balas.length; i++) {//recorre arreglo. checa si la bala no es nula y la pinta
            if (balas[i] != null) {
                this.add(balas[i]);
                balas[i].setBounds(balas[i].getX(), balas[i].getY(), 20, 20);
                if (balas[i].getX() >= 810) //Cuando llega a la orilla se nulifica la bala
                    balas[i] = null;
            }
        }
    }

    public void pintaVida(Graphics g){
        if(this.nave.getVida()==3){
            g.drawImage(new ImageIcon("naavee.png").getImage(),10,10,30,20,null);
            g.drawImage(new ImageIcon("naavee.png").getImage(),50,10,30,20,null);
            g.drawImage(new ImageIcon("naavee.png").getImage(),90,10,30,20,null);
        }if(this.nave.getVida()==2){
            g.drawImage(new ImageIcon("naavee.png").getImage(),10,10,30,20,null);
            g.drawImage(new ImageIcon("naavee.png").getImage(),50,10,30,20,null);

        }else {
            g.drawImage(new ImageIcon("naavee.png").getImage(),10,10,30,20,null);
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("fondo.jpg").getImage(),0,0,this.getWidth(),this.getHeight(),null);

        if (!gOver) {//Control del juego
            g.setFont(new Font("Arial", 0, 20));
            g.setColor(Color.WHITE);
            g.drawString("Score: " + score, 680, 18);
            this.nave.setBounds(this.nave.getX(), this.nave.getY(), 100, 50);

            crearEnemigos();

            //Impresion de vidas
            pintaVida(g);


        } else {
            this.removeAll();                            //...Borra la pantalla...
            this.pintaGameOver(g);
        }
    }
    public void pintaGameOver(Graphics g){				//Solo Pinta Game Over en el "medio" de la pantalla
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", 1, 48));
        g.drawString("Game Over", 150, 400);
        g.setFont(new Font("Arial",1,24));
        g.drawString("Score: "+score,500,400);
    }

    public Bala[] getBalas() {
        return balas;
    }

    public void controlEnemigos(){
        if(score<1500) {
            for (int i = 0; i < enes.length; i++) {
                if (enes[i] != null) {
                    this.enes[i].mover(-5, 0);
                    this.nave.colisionEnemigo(enes[i]);
                    if (!enes[i].isDeath() && enes[i].morir()) {
                        this.enes[i].img = "fon.png";//imagen del fondo negro
                        this.score += 100;
                    }
                }
            }

            for (int i = 0; i < eds.length; i++) {
                if (eds[i] != null) {
                    this.eds[i].mover(-5, 0);
                    this.nave.colisionEnemigo(eds[i]);
                    if (!eds[i].isDeath() && eds[i].morir()) {
                        this.eds[i].img = "fon.png";
                        this.score += 200;
                    }
                }
            }

                for (int i = 0; i < as.length; i++) {
                    if (as[i] != null) {
                        this.as[i].mover(0, 10);
                        this.nave.colisionEnemigo(as[i]);
                        if (!as[i].isDeath() && as[i].morir()) {
                            this.as[i].img = "fon.png";
                            this.score += 150;
                        }
                    }
                }

        } else if(score<3000){
            for (int i = 0; i < enes.length; i++) {
                if (enes[i] != null) {
                    this.enes[i].mover(-8, 0);
                    this.nave.colisionEnemigo(enes[i]);
                    if (!enes[i].isDeath() && enes[i].morir()) {
                        this.enes[i].img = "fon.png";
                        this.score += 100;
                    }
                }
            }

            for (int i = 0; i < eds.length; i++) {
                if (eds[i] != null) {
                    this.eds[i].mover(-8, 0);
                    this.nave.colisionEnemigo(eds[i]);
                    if (!eds[i].isDeath() && eds[i].morir()) {
                        this.eds[i].img = "fon.png";
                        this.score += 200;
                    }
                }
            }

                for (int i = 0; i < as.length; i++) {
                    if (as[i] != null) {
                        this.as[i].mover(0, 10);
                        this.nave.colisionEnemigo(as[i]);
                        if (!as[i].isDeath() && as[i].morir()) {
                            this.as[i].img = "fon.png";
                            this.score += 150;
                        }
                    }
                }

        }else{
            for (int i = 0; i < enes.length; i++) {
                if (enes[i] != null) {
                    this.enes[i].mover(-10, 0);
                    this.nave.colisionEnemigo(enes[i]);
                    if (!enes[i].isDeath() && enes[i].morir()) {
                        this.enes[i].img = "fon.png";
                        this.score += 100;
                    }
                }
            }
            for (int i = 0; i < eds.length; i++) {
                if (eds[i] != null) {
                    this.eds[i].mover(-10, 0);
                    this.nave.colisionEnemigo(eds[i]);
                    if (!eds[i].isDeath() && eds[i].morir()) {
                        this.eds[i].img = "fon.png";
                        this.score += 200;
                    }
                }
            }
            for (int i = 0; i < as.length; i++) {
                if (as[i] != null) {
                    this.as[i].mover(0, 10);
                    this.nave.colisionEnemigo(as[i]);
                    if (!as[i].isDeath() && as[i].morir()) {
                        this.as[i].img = "fon.png";
                        this.score += 150;
                    }
                }
            }
        }
    }

    @Override
    public void run() {
        while (!gOver) {
            try {
                controlEnemigos();

                if(this.nave.morir()) {
                    this.gOver=true;
                }

                if(score%500==0||score%550==0) {//Bandera de los asteroides
                    this.ast=true;
                }

                for (int i = 0; i < balas.length; i++) {//Recorre el arreglo checando que existan balas y las anima
                    //checa las colisiones de las balas
                    if(balas[i]!=null) {
                        if(this.enes[0]!=null)
                            this.enes[0].colisionBala(balas[i]);
                        if(this.enes[1]!=null)
                            this.enes[1].colisionBala(balas[i]);
                        if(this.enes[2]!=null)
                            this.enes[2].colisionBala(balas[i]);

                        if (this.as[0] != null)
                            this.as[0].colisionBala(balas[i]);

                        if (this.as[1] != null)
                            this.as[1].colisionBala(balas[i]);



                        if (score > 499)
                            if(this.eds[0]!=null)
                                this.eds[0].colisionBala(balas[i]);
                        if (score > 499)
                            if(this.eds[1]!=null)
                                this.eds[1].colisionBala(balas[i]);
                        if (score > 499)
                            if(this.eds[2]!=null)
                                this.eds[2].colisionBala(balas[i]);


                        balas[i].incrementX(10);
                    }
                }
                for(int i=0;i<balasera.length;i++) {
                    if (balasera[i] != null) {
                        balasera[i].incrementX(-10);
                        balasera[i].incrementY(10);
                        this.nave.colisionBalaEnemigo(balasera[i]);
                    }
                }
                repaint();
                Thread.sleep(50);
            }catch (InterruptedException ex){
                System.out.println("Interrupcion");
            }
        }
    }

    public boolean isgOver() {
        return gOver;
    }
}
