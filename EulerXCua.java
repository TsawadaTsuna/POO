//Kevin COntreras A01635597
//Clase Euler x cuadrada
public class EulerXCua extends Euler{

    public  EulerXCua(double x0, double y0,double xf, double h){
        super(x0,y0,xf,h);
    }
    @Override
    protected double f(double x, double y) {
        return x*x;
    }

    public static void main(String[] args) {
        EulerXCua exc = new EulerXCua(0,0,5,0.001);
        System.out.println(exc.integrar());
    }
}
