import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.SocketOption;

public class PanelControlesObelo extends JPanel implements ActionListener, ChangeListener {
    private JSlider slider;
    private JButton btnGuardar,
                    btnAbrir;
    private PanelObelo po;
    public PanelControlesObelo(PanelObelo po){
        super();
        this.po=po;

        slider=new JSlider(JSlider.HORIZONTAL,0,100,60);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        this.add(slider);
        slider.addChangeListener(this);
        po.getObelo().setpBolaAlto((double)this.slider.getValue()/100.0);


        this.btnGuardar=new JButton("Guardar");
        this.add(btnGuardar);
        this.btnGuardar.addActionListener(this);

        this.btnAbrir=new JButton("Abrir");
        this.add(btnAbrir);
        this.btnAbrir.addActionListener(this);


    }
    @Override
    public void actionPerformed(ActionEvent e) {



            if (e.getSource() == btnGuardar) {
                try {
                    PrintWriter pw = new PrintWriter(new FileWriter("Obelo.txt"));
                    pw.println(this.po.getObelo().getxIni());
                    pw.println(this.po.getObelo().getyIni());
                    pw.println(this.po.getObelo().getAncho());
                    pw.println(this.po.getObelo().getAlto());
                    pw.println(this.po.getObelo().getpBolaAlto());
                    pw.println(this.po.getObelo().getColorBarra().getRed());
                    pw.println(this.po.getObelo().getColorBarra().getGreen());
                    pw.println(this.po.getObelo().getColorBarra().getBlue());
                    pw.close();
                }catch (IOException ex) {
                    System.out.println("No se encontro el archivo");
                }
            } else {
                try {
                    /*BufferedReader br = new BufferedReader(new FileReader("Obelo.txt"));
                    this.po.getObelo().setXYInt(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
                    this.po.getObelo().setXYFin(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
                    this.po.getObelo().setpBolaAlto(Double.parseDouble(br.readLine()));
                    this.po.getObelo().setColorBarra(new Color(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine())));
                    this.po.repaint();
                    br.close();*/
                    BufferedReader br = new BufferedReader(new FileReader("Obelo.txt"));
                    this.po.getObelo().setXYInt(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
                    this.po.getObelo().setXYFin(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
                    this.po.getObelo().setpBolaAlto(Double.parseDouble(br.readLine()));
                    this.po.getObelo().setColorBarra(new Color(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine())));
                    this.po.repaint();
                    br.close();

                } catch (IOException ex) {
                    System.out.println("Error");
                }
            }

    }



    @Override
    public void stateChanged(ChangeEvent e) {
       this.po.getObelo().setpBolaAlto(this.slider.getValue()/100.0);
       po.repaint();
    }
}
