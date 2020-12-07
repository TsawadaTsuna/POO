public class  EjemploClaseGenerica <E extends Comparable<E>> {

    private E[] arr;

    public EjemploClaseGenerica(E[] arr){
        this.arr=arr;
    }

    public E min(){
        E min=arr[0];
        for(int i =1;i<arr.length;i++){
            if(arr[i].compareTo(min)<0){
                min=arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Integer[] arr={1,2,3,4};
        EjemploClaseGenerica<Integer> ecg = new EjemploClaseGenerica<>(arr);
        System.out.println(ecg.min());

        String[] nombre={"Juan","Paco","Pedro","de","la","Mar"};
        EjemploClaseGenerica<String> ecg2 = new EjemploClaseGenerica<>(nombre);
        System.out.println(ecg2.min());

    }

}
