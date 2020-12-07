//Autor: Kevin Contreras A01635597
//Clase Clock
//Fecha 17/09/19
/*
En esta pequena tarea reforze lo visto sobre interfacres.
Ademas conoci una de las interfaces predeterminadas que es comparable.
Ademas me ayudo a pensar un poco
*/
public class Clock implements Comparable{
	private int hr,
		    min,
		    sec;
	private String cd;
	public Clock(){
		this(12,0,0,"Guadajara");
		
	}
	public Clock(int hr, int min, int sec, String cd){
		this.setTime(hr,min,sec);
		this.cd=cd;
	}
	public void setTime(int hr, int min, int sec){
		if(hr>=0 && hr<24){
			this.hr=hr;
		}else{
			this.hr=12;
		}
		if(min>=0 && min<60){
			this.min=min;
		}else{
			this.min=0;
		}
		if(min>=0 && min<60){
			this.sec=sec;
		}else{
			this.sec=00;
		}
		
	}
	public int getHours(){
		return this.hr;
	}
	public int getMinutes(){
		return this.min;
	}
	public int getSeconds(){
		return this.sec;
	}
	public void printTime(){
		System.out.println("Ciudad: "+this.cd+" "+this.hr+":"+this.min+":"+this.sec);
	}
	public void incrementHours(){
		/*if (this.hr == 23){
			this.hr=0;
		}else{
			this.hr++1;
		}*/
		this.hr=++this.hr%24;
		
	}
	public void incrementMinutes(){
		if(this.min<59){
			this.min++;
		}else{
			this.min=0;
			this.incrementHours();
		}
	}
	public void incrementSeconds(){
		if(this.sec<59){
			this.sec++;
		}else{
			this.sec=0;
			this.incrementMinutes();
		}
	}
	public boolean equals(Clock reloj){
		return this.hr == reloj.hr && this.min == reloj.min && this.sec == reloj.sec;

	}	
	public void makeCopy(Clock reloj){
		this.hr=reloj.hr;
		this.min=reloj.min;
		this.sec=reloj.sec;
		//this.cd=reloj.cd;
	}
	public Clock getCopy(){
		return new Clock(this.hr, this.min, this.sec, this.cd);
	}
	public String toString(){
		return "Ciudad: "+this.cd+" "+this.hr+":"+this.min+":"+this.sec;
	}
	public int compareTo(Object obj){
		Clock reloj = (Clock)obj;
		return (this.sec*1+this.min*100+this.hr*10000)-(reloj.sec*1+reloj.min*100+reloj.hr*10000);
	}
	public static void main(String[] args) {
		Clock r1 = new Clock();
		Clock r2 = new Clock(12,0,1,"");
		Clock r3 = new Clock(11,58,58,"");
		Clock r4 = new Clock();
		System.out.println(r1.compareTo(r2));
		System.out.println(r1.compareTo(r3));
		System.out.println(r1.compareTo(r4));
	}
}