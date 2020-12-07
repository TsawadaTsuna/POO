public class UsaTermometro{

	public static void main(String[] args){
		Termometro gda = new Termometro();
		Termometro her = new Termometro(40);
		System.out.println(gda.getTemp);
		System.out.println(her.getTemp);
	}



}