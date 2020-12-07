import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.*;
import java.util.Random;

public class MyPanelDibujo extends JPanel {
    private int xV,yV,xT,yT,tt;
    private Image fondo;
    private Image poco;
    private String nombre;
    private boolean mover;
    private Color c;
    private Asteroides[] aste;
    public MyPanelDibujo(){
        super();
        Random ran = new Random();
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                    System.out.println("Clickeado en" + evt.getX() + "," + evt.getY());
                    guardarDatos();
                    mover = true;

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
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                System.out.println(evt.getX()+","+evt.getY());
                xT=evt.getX();
                yT=evt.getY();
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        this.mover = false;
        this.tt=5;
        this.setPreferredSize(new Dimension(800,600));
        this.xV=this.yV=0;
        this.xT=110;
        this.yT=475;
        this.aste= new Asteroides[20];

        this.cargarDatos();

        for(int i =0;i<aste.length;i++){
            this.aste[i]=new Asteroides(ran.nextInt(750),ran.nextInt(550));
        }

        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while (xV<550){
                    try {
                        if(mover){
                            xV+=2;
                            yV--;
                        }
                        repaint();
                        Thread.sleep(50);
                    }catch (InterruptedException ex){
                        System.out.println("No pude despertar al vamoosh");
                    }
                }
            }
        });
        this.fondo = new ImageIcon("leon.jpg").getImage();
        this.poco = new ImageIcon("pocoyo.png").getImage();
        hilo.start();
        this.setBackground(Color.darkGray);

    }

    public void cargarDatos(){
        try{
            JFileChooser jfc=new JFileChooser();
            int op=jfc.showOpenDialog(this);
            if(op==JFileChooser.APPROVE_OPTION){
                String file = jfc.getSelectedFile().getAbsolutePath();
                BufferedReader br=new BufferedReader(new FileReader(file));
                this.nombre=br.readLine();
                this.c=new Color(Integer.parseInt(br.readLine()));
                br.close();
            }
            /*BufferedReader br=new BufferedReader(new FileReader("Pocoyo.poo"));
            this.nombre=br.readLine();
            this.c=new Color(Integer.parseInt(br.readLine()));
            br.close();*/

        }catch (FileNotFoundException ex){
            System.out.println("No se encontro el archivo");
            this.c=Color.RED;
            this.nombre="Pocoyo";
        }catch(IOException ex){
            System.out.println("Error IO");
            this.c=Color.RED;
            this.nombre="Pocoyo";
        }
    }

    public void setTt(int tt) {
        this.tt = tt;
        repaint();
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
        this.repaint();
    }
    public void setC(Color c){
        this.c=c;
        repaint();
    }

    private void dibujaCabina(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillOval(50+this.xV,400+this.yV,200,100);
        g.setColor(Color.CYAN);
        g.fillArc(50+this.xV,400+this.yV,200,100,0,110);
    }

    private void dibujaGlobo(Graphics g){
        g.setColor(Color.BLACK);
        g.drawLine(100+this.xV,407+this.yV,100+this.xV,300+this.yV);
        g.setColor(this.c);
        g.fillOval(50+this.xV,200+this.yV,100,100);
    }

    private void dibujaFondo(Graphics g){
        g.drawImage(this.fondo,0,0,this.getWidth(),this.getHeight(),this);
    }

    private void dibujaAsteroides(Graphics g){
        for(int i =0;i<aste.length;i++){
            this.aste[i].pintate(g);
        }
    }
    private void dibujaTriangulo(Graphics g){
        int[] xs={600,500,700},
                ys={250,500,500};
        g.setColor(new Color(128,64,0));
        g.fillPolygon(xs,ys,3);
        g.setColor(Color.RED);
        Graphics2D g2=(Graphics2D)g;
        g2.setStroke(new BasicStroke(this.tt));
        g.drawPolygon(xs,ys,3);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        dibujaFondo(g);
        g.drawImage(this.poco,160+this.xV,410+this.yV,40,40,this);

        dibujaCabina(g);

        dibujaGlobo(g);
        g.drawImage(this.poco,160+this.xV,410+this.yV,40,40,this);
        dibujaAsteroides(g);
        g.drawString("Vamos "+this.nombre+"!",this.xT,this.yT);
        this.dibujaTriangulo(g);

    }



    private void guardarDatos(){
        try {
            JFileChooser jfc = new JFileChooser();
            int op=jfc.showSaveDialog(this);
            if(op==JFileChooser.APPROVE_OPTION){
               String file= jfc.getSelectedFile().getAbsolutePath();
                PrintWriter pw = new PrintWriter(new FileWriter(file));
                if (this.nombre != null) {
                    pw.println(this.nombre);
                }
                if (this.c != null) {
                    pw.println(this.c.getRGB());
                }
                pw.close();
            }
            /*PrintWriter pw = new PrintWriter(new FileWriter("Pocoyo.poo"));
            if (this.nombre != null) {
                pw.println(this.nombre);
            }
            if (this.c != null) {
                pw.println(this.c.getRGB());
            }
            pw.close();*/
        }catch (IOException ex){
            System.out.println("Error");
        }
    }
  /*  @Override
    public void mouseClicked(MouseEvent evt) {
        if(evt.getSource()==this) {
            System.out.println("Clickeado en" + evt.getX() + "," + evt.getY());
            guardarDatos();
            this.mover = true;
        }else{
            this.setBackground(Color.PINK);
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

    }*/


    /*public void mouseDragged(MouseEvent evt) {
        System.out.println(evt.getX()+","+evt.getY());
        this.xT=evt.getX();
        this.yT=evt.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }*/
}
