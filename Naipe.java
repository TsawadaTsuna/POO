public class Naipe{
	private int figura;//0-espadas, 1-corazones, 2-treboles & 3-diamantes
	private int valor;//0-as, 1-dos.....10-jota, 11-reina, 12-rey.

	private static final String[] figuras={"espadas","corazones","treboles","diamantes"};//static -> Atributo de clase. final->Constante
	private static final String[] valores={"As","Dos","Tres","Cuatro","Cinco","Seis","Siete","Ocho","Nueve","Diez","Jota","Reina","Rey"};
	public Naipe(int valor, int figura){
		this.valor=valor;
		this.figura=figura;
	}
	public String toString(){

		return Naipe.valores[this.valor]+" de "+Naipe.figuras[this.figura];
	}
	public static void main(String[] args){
		Naipe cincoEspadas = new Naipe(4,0);
		System.out.println(cincoEspadas);
		
	}
}