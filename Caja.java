public class Caja extends Rectangulo {
    private double alto;

    public Caja(double largo, double ancho, double alto){
        super(largo, ancho);
        this.alto=alto;
    }

    public Caja(){
        this(10.0,4.0,8.0);
    }
    @Override
    public double perimetro() {
        return 4.0*this.largo+2.0*this.ancho+8.0*this.alto;
    }
    @Override
    public double area(){
        return 2.0*(super.area()+this.largo*this.alto+this.ancho*this.alto);
    }

    @Override
    public double volumen() {
        return super.area()*this.alto;
    }

    @Override
    public String toString() {
        return "Caja con largo: "+this.largo+" ancho: "+this.ancho+" alto: "+this.alto;
    }

    public void saluda(){
        System.out.println("hola");
    }
}
