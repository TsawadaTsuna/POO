//Autor: Kevin Contreras A01635597
//Clase Vector
//Fecha: 29/08/19
/*Observaciones:
Esta tarea me ayudo a ver como se comportan ciertos metodos cuando reciben objetos como parametros o cuando tienen que regresar objetos.
Ademas me ayudo a ver como se pueden usar varios metodos sobre un mismo objeto a la vez y como interactuan
*/
import java.lang.Math;//Libreria math
public class Vector{
	private double i,
				   j,
				   k;
	public Vector(){//Constructor default
		i=0;
		j=0;
		k=0;
	}
	public Vector(double x, double y, double z){//Constructor con parametros
		this.i=x;
		this.j=y;
		this.k=z;
	}
	public double magnitud(){
		return Math.abs(Math.sqrt(Math.pow(this.i,2)+Math.pow(this.j,2)+Math.pow(this.k,2)));
	}
	public Vector suma(Vector vector){
		return new Vector(this.i+vector.i, this.j+vector.j, this.k+vector.k);
	}
	public Vector resta(Vector vector){
		return new Vector(this.i-vector.i, this.j-vector.j, this.k-vector.k);
	}
	public double productoPunto(Vector vector){
		return (this.i*vector.i+this.j*vector.j+this.k*vector.k);
	}
	public Vector productoCruz(Vector vector){
		return new Vector(this.j*vector.k-this.k*vector.j,this.k*vector.i-this.i*vector.k,this.i*vector.j-this.j*vector.i);
	}
	public void agregar(Vector vector){
		this.i=vector.i;
		this.j=vector.j;
		this.k=vector.k;
	}
	public void imprimeVector(){
		System.out.println("("+this.i+"i , "+this.j+"j , "+this.k+"k)");
	}
	public static void main(String[] args) {
		Vector vector1 = new Vector();
		Vector vector2 = new Vector(1,2,3);
		Vector vector3 = new Vector(2.5,4.7,3.9);

		System.out.println("Magnitud: "+vector2.magnitud());
		vector2.imprimeVector();
		System.out.println("Product point: "+vector3.productoPunto(vector2));
		vector3.productoCruz(vector2).imprimeVector();

	}
}