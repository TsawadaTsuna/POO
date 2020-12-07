import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjemploLectura {
    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("nuevo.txt"));
            String linea;

            while ((linea=bf.readLine()) != null){
                System.out.println(linea);
            }
            //System.out.println(linea);
            bf.close();
        }catch (FileNotFoundException ex){
            System.out.println("No se puede cerrar");
        }catch(IOException ex){
            System.out.println("No se puede cerrar");
        }
    }
}
