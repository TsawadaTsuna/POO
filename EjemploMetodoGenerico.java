public class EjemploMetodoGenerico {
    public static <E> E imprimeArreglo(E[] arr){
        for(int i =0;i<arr.length;i++){
            if(i!=arr.length-1)
                System.out.print(arr[i]+",");
            else
                System.out.print(arr[i]+"");
        }
        System.out.println();
        return arr[0];
    }


    public static void main(String[] args) {
        Integer[] arr={0,1,2,3};
        Double[] dec={1.2,2.5,3.4,2.36};
        String[] nombre={"Juan","Paco","Pedro","de","la","Mar"};
        int ri=EjemploMetodoGenerico.imprimeArreglo(arr);
        double rd=EjemploMetodoGenerico.imprimeArreglo(dec);
        String rs=EjemploMetodoGenerico.imprimeArreglo(nombre);
    }
}
