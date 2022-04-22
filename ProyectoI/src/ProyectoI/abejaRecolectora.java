package ProyectoI;

/**
 *
 * @author Mari
 */
public class abejaRecolectora extends abeja {

    private String tipo = "";

    public abejaRecolectora(int vida, int x, int y, boolean movimiento, 
            String posicion, boolean polen, boolean amenaza, String tipo, String recursoXY, 
            String amenazaXY, int huidas, String posicion01, String posicion10, 
            String posicion11, ProcesosTablero tablero) {
        super(vida, x, y, movimiento, posicion, polen, amenaza, recursoXY, 
                amenazaXY, huidas, posicion01, posicion10, posicion11, tablero);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void algoritmoMovimiento() {//Algoritmo de movimiento
        if (isPolen()) {
            System.out.println("move2Colmena");
            toColmena();
        } else if (getAmenazaXY() != "") {
            if (getTipo() == "Defensora") {
                System.out.println("moveToAmenaza");
                moveTo(getAmenazaXY());
            } else {
                System.out.println("moveAwayAmenaza");
                moveAway(getAmenazaXY());
            }
        } else if (getRecursoXY() != "") {
            System.out.println("moveToRecurso");
            moveTo(getRecursoXY());
        } else {
            System.out.println("moverAleatorio");
            moverAleatorio();
        }
    }
}
