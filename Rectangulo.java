public class Rectangulo implements Figura {
    protected double ancho,
            largo;
    public  Rectangulo(double largo, double ancho){
        this.largo=largo;
        this.ancho=ancho;
    }
    public Rectangulo(){
        this(10,4);
    }
    public double perimetro(){
        return 2.0*(this.ancho+this.largo);
    }
    public double area(){
        return this.largo*this.ancho;
    }

    @Override
    public double volumen() {
        return 0;
    }

    public String toString(){
        return "Rectangulo con largo: "+this.largo+" ancho: "+this.ancho;
    }
    public static void main(String[] args){

        Figura[] figuras = {new Rectangulo(), new Cuadrado(),new Caja()};//Objetos figura o hija. POLIMORFISMO!!!!!
        for(int i=0;i<figuras.length;i++){
            System.out.println(figuras[i]);
            System.out.println(figuras[i].perimetro());
            System.out.println(figuras[i].area());
            System.out.println(figuras[i].volumen());
            if(figuras[i] instanceof Caja){//Pregunta por instancia. Osea objeto
                ((Caja)figuras[i]).saluda();//Casteo (Clase)objetoAParsear
            }
        }
        //Tarea: CompareTo de la clase clock segun las horas
        //public int compareTo(Object obj)v
        //Clock reloj = (Clock)obj;
        // Clock implements Comparable
    }
}
