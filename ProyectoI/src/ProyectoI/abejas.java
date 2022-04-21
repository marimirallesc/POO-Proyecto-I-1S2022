package ProyectoI;

/**
 *
 * @author Mari
 */
public class abejas extends serVivo{

    private int tipo = 0; //Base = 0; Recolector = 1; Defensor = 2;
    private boolean polen = false;
    private boolean amenaza = false;
    
    public abejas(int vida, int x, int y, boolean movimiento, int tipo, boolean polen, boolean amenaza) {
        super(vida, x, y, movimiento);
        this.tipo = tipo;
        this.polen = polen;
        this.amenaza = amenaza;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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
    
}
