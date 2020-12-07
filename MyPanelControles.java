import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyPanelControles extends JPanel implements ChangeListener {
    private JTextField tfNombre;
    private JButton btNombre,
                    btFondo;
    private JRadioButton  rbr,
                          rbg,
                          rbb;
    private MyPanelDibujo pd;
    private JPanel pColor;
    private JSlider slider;

    public MyPanelControles(MyPanelDibujo pd){
        super();
        this.pColor = new JPanel();
        this.pColor.setPreferredSize(new Dimension(150,150));
        this.pColor.setBackground(Color.RED);
        this.pd = pd;

        this.setPreferredSize(new Dimension(200,600));
        this.tfNombre = new JTextField(10);
        this.btNombre = new JButton("Cambiar");
        this.rbr = new JRadioButton("Color Rojo");
        this.rbr.setSelected(true);
        this.rbg = new JRadioButton("Color Verde");
        this.rbb = new JRadioButton("Color Azul");
        this.btFondo = new JButton("Color fondo");
        this.btNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hola "+tfNombre.getText());
                pd.setNombre(tfNombre.getText());
            }
        });

        this.btFondo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbr.isSelected()) {
                    setBackground(Color.RED);
                }else if(rbg.isSelected()) {
                    setBackground(Color.GREEN);
                }else{
                    setBackground(Color.BLUE);
                }
            }
        });

        this.slider=new JSlider(JSlider.VERTICAL,0,15,5);
        this.slider.setPaintLabels(true);
        this.slider.setPaintTicks(true);
        this.slider.setMajorTickSpacing(5);
        this.slider.setMinorTickSpacing(1);
        this.slider.addChangeListener(this);
        ButtonGroup bg = new ButtonGroup();

        bg.add(this.rbb);
        bg.add(this.rbg);
        bg.add(this.rbr);
        this.add(this.tfNombre);
        this.add(this.btNombre);
        this.add(new JLabel("Selecciona el fondo"));
        this.add(this.rbr);
        this.add(this.rbg);
        this.add(this.rbb);
        this.add(this.btFondo);
        this.add(new JLabel("Selecciona color globo"));
        this.add(pColor);
        this.add(this.slider);
        this.pColor.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Color tmpColor = JColorChooser.showDialog(MyPanelControles.this,"Selecciona un color",Color.RED);
                pColor.setBackground(tmpColor);
                pd.setC(tmpColor);
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

        //this.pColor.addMouseListener(this.pd);
    }
    public Color getColor(){
        return this.pColor.getBackground();
    }

    /*public void actionPerformed(ActionEvent evt) {
        if(evt.getSource()==this.btNombre){
            System.out.println("Hola "+tfNombre.getText());
            this.pd.setNombre(this.tfNombre.getText());
        }else{
            if(this.rbr.isSelected()) {
                this.setBackground(Color.RED);
            }else if(this.rbg.isSelected()) {
                this.setBackground(Color.GREEN);
            }else{
                this.setBackground(Color.BLUE);
            }
        }

    }*/


    @Override
    public void stateChanged(ChangeEvent evt) {
        this.pd.setTt(this.slider.getValue());
    }
}
