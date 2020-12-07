import javax.swing.JOptionPane;
public class IntroJava{
	public static void calificacion(){
		String strNota = JOptionPane.showInputDialog("Dime la nota obtenida");
		int nota=Integer.parseInt(strNota);
		if(nota>=70){
			System.out.println("Aprobaste");
		}else{
			System.out.println("Reprobaste");
		}
	}

	public static void nums1Al100(){
		for(int i=0;i<100;i++){
			System.out.println(i+1);
		}
	}	

	public static void main(String[] args){
		calificacion();
		nums1Al100();
	}

}