public class Calendario{//Hecho por Kevin Contreras A01635597

	public static String imprimeMes(int inicio, int numDias){
		
		String dias = " D  L Ma Mi  J  V  S \n"; //Dias del calendario
		for(int i = 0; i<(numDias+inicio);i++){//Ciclo que imprime los numeros y los dias vacios
			if (i<inicio){
				dias+="   ";//Dias de espacio vacio, 3 espacios	
			}else{
				if (i-inicio+1<10){
					dias+=" ";//Dias de un solo digito
				}
				
				dias+=(i-inicio+1)+" ";//Dias de 2 digitos
				
				if((i+1)%7==0){
					dias+="\n";// Salto de linea
				}
			}
		}

		return dias;

	}

	public static void main(String[] args){

		System.out.print(imprimeMes(6,28));
		/* 
		Esta tarea me ayudo a recordar algunas cosas como que puede hacer += a strings.
		Tambien como la hice con tiempo tuve tiempo de mejorarla un poco porque primero tenia un contador y luego vi que era innecesario	
		 */
	}

}