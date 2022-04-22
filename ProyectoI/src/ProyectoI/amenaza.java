package ProyectoI;

/**
 *
 * @author Mari
 */
public class amenaza extends serVivo{

    public amenaza(int vida, int x, int y, boolean movimiento, String posicion, 
            String posicion01, String posicion10, String posicion11, 
            ProcesosTablero tablero) {
        super(vida, x, y, movimiento, posicion, posicion01, posicion10, 
                posicion11, tablero);
    }


}
