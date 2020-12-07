import javax.swing.JOptionPane;
//Kevin Contreras A01635597
public class Triangulo2A01635597 {


    public static void main(String[] args){
	    String x1s = JOptionPane.showInputDialog("Ingrese la coordenada X del vertice 1");
		String y1s = JOptionPane.showInputDialog("Ingrese la coordenada Y del vertice 1");
		String x2s = JOptionPane.showInputDialog("Ingrese la coordenada X del vertice 2");
		String y2s = JOptionPane.showInputDialog("Ingrese la coordenada Y del vertice 2");
		String x3s = JOptionPane.showInputDialog("Ingrese la coordenada X del vertice 3");
		String y3s = JOptionPane.showInputDialog("Ingrese la coordenada Y del vertice 3");
		double x1 = Double.parseDouble(x1s);
		double y1 = Double.parseDouble(y1s);
		double x2 = Double.parseDouble(x2s);
		double y2 = Double.parseDouble(y2s);
		double x3 = Double.parseDouble(x3s);
		double y3 = Double.parseDouble(y3s);
	    System.out.println("El area del triangulo es: " + ((x1*y2+x2*y3+x3*y1)-(x2*y1+x3*y2+x1*y3))/2 + " unidades cuadradas");
|	}
}