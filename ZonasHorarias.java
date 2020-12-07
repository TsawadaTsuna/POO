public class ZonasHorarias {
	private Clock[] horarios;

	public ZonasHorarias(){
		this.horarios = new Clock[10]; 
	}
	public void ponerHora(int pos, int hr, int min, int sec, String cd){
		if(this.horarios[pos]==null){
			this.horarios[pos] = new Clock(hr,min,sec,cd);
		}else{
			this.horarios[pos].setTime(hr,min,sec);
		}
	}
	public void cambiarHorarioInvierno(){
		for(int i =0;i<this.horarios.length;i++){
			if(this.horarios[i]!=null){
				this.horarios[i].incrementHours();
			}
		}
	}
	public static void main(String[] args) {
		ZonasHorarias zh=new ZonasHorarias();
		zh.ponerHora(0,12,45,30,"Guadalajara");
		zh.ponerHora(1,19,45,30,"Paris");
		zh.ponerHora(2,21,45,30,"Dubai");
		System.out.println(zh);
	}
	public String toString(){
		String res="";
		for(int i =0;i<this.horarios.length;i++){
			if(this.horarios[i]!=null){
				res+=this.horarios[i]+"\n";
			}
		}
		return res;
	}

}