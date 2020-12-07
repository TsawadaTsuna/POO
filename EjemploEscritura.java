import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EjemploEscritura {
    public static void main(String[] args) {
        PrintWriter pw = null;
        try{

            pw = new PrintWriter(new FileWriter("nuevo.txt"));
            pw.println("Esta es la primer linea de mi primer archivo creado desde Java :)");
            pw.println("espero que salga bien :D");
            pw.flush();
            pw.println("esto no se guarara");

        }catch (IOException ex){
            System.out.println("No se puede crear el archivo");
        }finally{
            pw.close();
        }
    }
}
