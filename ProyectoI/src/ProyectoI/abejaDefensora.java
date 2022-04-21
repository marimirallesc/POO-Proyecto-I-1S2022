package ProyectoI;

/**
 *
 * @author Mari
 */
public class abejaDefensora extends abeja {

    private String tipo = "";

    public abejaDefensora(int vida, int x, int y, boolean movimiento,
            String posicion, boolean polen, boolean amenaza,
            String tipo, String amenazaXY, String recursoXY, int huidas,
            ProcesosTablero tablero) {
        super(vida, x, y, movimiento, posicion, polen, amenaza,
                amenazaXY, recursoXY, huidas, tablero);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
