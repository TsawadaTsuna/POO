//Autor: Kevin Contreras A01635597
//Clase: Division
//Fecha 23/09/19
/* Comentarios:
Reafirme como se usan las excepciones de tipo Runtime
 */
import javax.swing.JOptionPane;
public class Division {
    public static int divisionEntera(int num, int den) {
        return num / den;
    }

    public static void main(String[] args) {
        boolean flag = true;

        while (flag) {
            try {
                int num = Integer.parseInt(JOptionPane.showInputDialog("Escribe un numero")),
                        den = Integer.parseInt(JOptionPane.showInputDialog("Escribe otro"));
                JOptionPane.showMessageDialog(null, "La division es: " + divisionEntera(num, den));
                flag = false;
            } catch (ArithmeticException ex) {
                flag = true;
                JOptionPane.showMessageDialog(null, "Error: Division entre 0.\nFavor de reingresar los datos");
            } catch (NumberFormatException ex){
                flag = true;
                JOptionPane.showMessageDialog(null, "Error: No ingreso un numero.\nFavor de reingresar los datos");
            }
            /* Tarea: Si ocurre un error vuelve a empezar y pide to de uevo */
        }
    }
}
