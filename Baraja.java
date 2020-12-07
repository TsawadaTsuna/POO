import java.util.Random;
public class Baraja{
	private Naipe[] naipes;
	public Baraja(){
		this.naipes = new Naipe[52];
		int c=0;
		for(int i = 0; i<4;i++){
			for(int j=0;j<13;j++){
				this.naipes[c++]=new Naipe(j,i);
			}
		}
	}
	public String toString(){
		String res= "";
		for(int i =0;i<this.naipes.length;i++){
			res+=this.naipes[i]+"\n";
		}
		return res;
	}
	public void mezcla(){
		Random ran = new Random();
		int pos;
		Naipe tmp;
		for(int i=0;i<this.naipes.lengthi++){
			pos=ran.nextInt(52);
			tmp=this.naipes[i];
			this.naipes[i]=this.naipes[pos];
			this.naipes[pos]=tmp;
		}
	}
	public static void main(String[] args) {
		Baraja baraja=new Baraja();
		System.out.println(baraja);
	}

}