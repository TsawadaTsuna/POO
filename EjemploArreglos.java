//Autor: Kevin Contreras A01635597
//Clase: EjemploArreglos.
//Fecha: 1/9/19
/*Observaciones:
Con este ejercicio practique arreglos y me quedo mas claro como utilizarlos.
Tambien me ayudo a comprender la parte de "String[] args" del metodo main.
Y me ayudo a practicar mi logica y mis matematicas ya que en el metodo main me tarde en el diseño de mi arreglo "lista" que se genera a partir de args.
*/
public class EjemploArreglos{

	public int suma(int[] arreglo){
		int acum=0;
		for(int i=0;i<arreglo.length;i++){
			acum+=arreglo[i];
		}
		return acum;
	}
	public int maximo(int[] arreglo){
		int max = arreglo[0];
		for(int i=0;i<arreglo.length;i++){
			if (arreglo[i]>max){
				max=arreglo[i];
			}
		}
		return max;
	}
	public int minimo(int[] arreglo){
		int min = arreglo[0];
		for(int i=0;i<arreglo.length;i++){
			if (arreglo[i]<min){
				min=arreglo[i];
			}
		}
		return min;
	}
	public double promedio(int[] arreglo){
		return this.suma(arreglo)/arreglo.length;
	}
	public void imprime(String[][] palabras){
		for(int i=0;i<palabras.length;i++){
			for(int j=0;j<palabras[i].length;j++){
				System.out.print(palabras[i][j]+" ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args){
		EjemploArreglos ea = new EjemploArreglos();
		String[][] lista = new String [Integer.parseInt(args[0])] [Integer.parseInt(args[1])];//Nuevo arreglo multidimensional a partir de args
		for (int i=0;i<lista.length;i++){
			
			for(int j=0;j<lista[i].length;j++){
				lista[i][j]=args[j+2+i*Integer.parseInt(args[1])];
			}
			
		}
		ea.imprime(lista);

	}

}