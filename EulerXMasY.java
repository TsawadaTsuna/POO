//Kevin Contreras A01635597
//Clase Euler x mas y
public class EulerXMasY extends Euler {
    public  EulerXMasY(double x0, double y0,double xf, double h){
        super(x0,y0,xf,h);
    }

    @Override
    protected double f(double x, double y) {
        return x+y;
    }

    public static void main(String[] args) {
        EulerXMasY exc= new EulerXMasY(0,0,5,0.001);
        System.out.println(exc.integrar());
    }
}
