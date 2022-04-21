package ProyectoI;

import static java.lang.Integer.parseInt;

/**
 *
 * @author Mari
 */
public class abeja extends serVivo {

    private boolean polen = false;
    private boolean amenaza = false;
    private String amenazaXY = "";
    private String recursoXY = "";
    private int huidas = 0;

    public abeja(int vida, int x, int y, boolean movimiento, String posicion,
            boolean polen, boolean amenaza, String amenazaXY, String recursoXY,
            int huidas, ProcesosTablero tablero) {
        super(vida, x, y, movimiento, posicion, tablero);
        this.polen = polen;
        this.amenaza = amenaza;
        this.amenazaXY = amenazaXY;
        this.recursoXY = recursoXY;
        this.huidas = huidas;
    }

    public boolean isPolen() {
        return polen;
    }

    public void setPolen(boolean polen) {
        this.polen = polen;
    }

    public boolean isAmenaza() {
        return amenaza;
    }

    public void setAmenaza(boolean amenaza) {
        this.amenaza = amenaza;
    }

    public String getAmenazaXY() {
        return amenazaXY;
    }

    public void setAmenazaXY(String amenazaXY) {
        this.amenazaXY = amenazaXY;
    }

    public String getRecursoXY() {
        return recursoXY;
    }

    public void setRecursoXY(String recursoXY) {
        this.recursoXY = recursoXY;
    }

    public void atacar(serVivo enemigo) {
        if (this.getVida() > 0) {
            enemigo.recibirAtaque();
        }
    }

    public void recolectarPolen(serVivo recurso) {
        try {
            recurso.recibirAtaque();
            this.setPolen(true);
            this.setRecursoXY(recurso.getPosicion());
        } catch (NullPointerException e) {
        }
    }
    
}
