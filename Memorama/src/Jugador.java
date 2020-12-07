//Kevin Daniel Contreras Hernanzdez A01635597
//Juan Diego
//Clase Jugador
public class Jugador {
    private String nombre;
    private int score;
    public Jugador(String nombre){
        this.nombre=nombre;
        this.score=0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        this.score++;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
