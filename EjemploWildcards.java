//Kevin Contreras A01635597
import java.util.ArrayList;

public class EjemploWildcards {

    public double suma(ArrayList<? extends Number> al){
        double sum=0;
        for(int i=0;i<al.size();i++){
            System.out.println(al.get(i));
            sum+=al.get(i).doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<Number> al = new ArrayList<>();
        al.add(12.5);
        al.add(23);
        EjemploWildcards ew = new EjemploWildcards();
        System.out.println(ew.suma(al));

        ArrayList<Integer> ali = new ArrayList<>();
        al.add(12);
        al.add(23);
        System.out.println(ew.suma(ali));
    }

}
