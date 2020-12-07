public class Linea{

	public static boolean isLeft(double x1, double x2, double y1, double y2, double h, double k){
		boolean left = false;
		if(y2>y1){
			if(h<x1&&h<x2){
				left=true;
			}
		}else{
			if(h>x1&&h>x2){
				left=true;
			}
		}
		return left;
	}
	public static void main(String[] args) {
		System.out.println(isLeft(0,5,0,4,7,2));
		System.out.println(isLeft(0,5,0,4,-7,2));
	}
}