import java.io.*;
import java.util.StringTokenizer;

public class CalculaNominna {
    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("horasTrabajadas.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter("nomina.csv"));
            String linea,
                    nombre,
                    apellido;
            int hr;
            double tab;
            StringTokenizer st;
            bf.readLine();
            pw.println("Nombre Completo, Nomina");
            while ((linea=bf.readLine()) != null){
                st = new StringTokenizer(linea);
                nombre=st.nextToken();
                apellido=st.nextToken();
                hr=Integer.parseInt(st.nextToken());
                tab=Double.parseDouble(st.nextToken());
                pw.println(nombre+" "+apellido+","+hr*tab);
            }
            //System.out.println(linea);
            bf.close();
            pw.close();
            System.out.println("fin");
        }catch (FileNotFoundException ex){
            System.out.println("No se puede cerrar");
        }catch(IOException ex){
            System.out.println("No se puede cerrar");
        }
    }
}
