public class Habitacion{
	private int numero,
				adultos,
				infantes;
	private double credito,
				   cargo;
	private String nombre;
	private boolean disponible;

	public Habitacion(int num){
		this.numero=num;
		this.disponible=true;
	}
	public int getNumero(){
		return this.numero;
	}
	public boolean getDisponible(){
		return this.disponible;
	}
	public void checkIn(String nombre, int nino, int adulto, double credito){
		this.nombre=nombre;
		this.infantes=nino;
		this.adultos=adulto;
		this.credito=credito;
		this.disponible=false;
	}
	public boolean checkOut(){
		if(!this.getDisponible()){
			this.nombre="";
			this.infantes=0;
			this.adultos=0;
			this.credito=0;
			this.disponible=true;
			return true;
		}else{
			return false;
		}
	}
	public int getTarifaBase(){
		return this.adultos*350+this.infantes*100;
	}
	public boolean cargar(double cargo){
		if (cargo>0&&this.cargo+cargo<=this.credito){
			
			this.cargo+=cargo;
			return true;
		}
		
		return false;
	}
	public String toString(){
		return "#"+this.numero+", Huesped: "+this.nombre+", Tarifa base: "+this.getTarifaBase()+", Credito: "+this.credito+", Cargos: "+this.cargo;
	}
	public static void main(String[] args) {
		Habitacion uno = new Habitacion(1);
		uno.checkIn("Kevin",1,3,550.35);
		System.out.println(uno.getTarifaBase());
		System.out.println(uno);
		uno.cargar(120.2);
		System.out.println(uno);
		uno.checkOut();
		System.out.println(uno.getDisponible());

	}
}