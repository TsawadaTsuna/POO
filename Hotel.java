public class Hotel{
	private Habitacion[] habitaciones;
	private String nombre;
	public Hotel(int habitacion, String nombre){
		this.nombre=nombre;
		this.habitaciones= new Habitacion[habitacion];
		for(int i=0;i<this.habitaciones.length;i++){
			this.habitaciones[i]=new Habitacion(i+100);
		}
	}
	public int checkIn(String nombre, int ninos, int adultos, double credito){
		for(int i=0;i<this.habitaciones.length;i++){
			if(this.habitaciones[i].getDisponible()){
				this.habitaciones[i].checkIn(nombre, ninos, adultos, credito);
				return this.habitaciones[i].getNumero();
			}
		}
		return -1;
	}
	public boolean checkOut(int num){
		if(num-100>=0&&num-100<this.habitaciones.length&&!this.habitaciones[num-100].getDisponible()){
			
			this.habitaciones[num-100].checkOut();
			return true;
			
		}else{
			return false;
		}
	}
	public int getTotalXTarifaBase(){
		int total = 0;
		for(int i=0;i<this.habitaciones.length;i++){
			total+=this.habitaciones[i].getTarifaBase();
		}
		return total;
	}
	public boolean realizarCargos(int num, double cargo){
		if (!this.habitaciones[num-100].getDisponible()){
			this.habitaciones[num-100].cargar(cargo);
			return true;
		}else{
			return false;
		}
	}
	public void imprimeOcupacion(){
		System.out.println("Ocupacion en "+this.nombre);
		for(int i=0;i<this.habitaciones.length;i++){
			if(!this.habitaciones[i].getDisponible()){
				System.out.println(this.habitaciones[i]);
			}
		}
	}
	public static void main(String[] args) {
		Hotel lagran = new Hotel(10, "El gran Hotel");
		System.out.println(lagran.checkIn("Kevin",2,3,552.34));
		System.out.println(lagran.realizarCargos(100,220.5));
		System.out.println(lagran.getTotalXTarifaBase());
		lagran.imprimeOcupacion();
		System.out.println(lagran.checkOut(100));
	}
}