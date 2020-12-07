//Hecho por Kevin Contreras
import java.util.Scanner;
public class Triangulo{
	private double x1,
				   y1,
				   x2,
				   y2,
				   x3,
				   y3;

	public Triangulo(){
		Scanner coord = new Scanner(System.in);
		System.out.print("Ingrese la coordenada x1: ");
		this.x1 = coord.nextDouble();
		System.out.print("Ingrese la coordenada y1: ");
		this.y1 = coord.nextDouble();
		System.out.print("Ingrese la coordenada x2: ");
		this.x2 = coord.nextDouble();
		System.out.print("Ingrese la coordenada y2: ");
		this.y2 = coord.nextDouble();
		System.out.print("Ingrese la coordenada x3: ");
		this.x3 = coord.nextDouble();
		System.out.print("Ingrese la coordenada y3: ");
		this.y3 = coord.nextDouble();
	}
	public double calculaArea(){
		return Math.abs(((x1*y2+x2*y3+x3*y1)-(x1*y3+x3*y2+x2*y1)/2));
	}
	public static void main(String[] args){
		Triangulo tri = new Triangulo();
		System.out.print("Area: "+tri.calculaArea()+" U^2");
	}
}