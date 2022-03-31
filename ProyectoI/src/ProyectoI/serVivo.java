package ProyectoI;

/**
 *
 * @author Mari
 */
public class serVivo {

    private int vida = 0;
    private int x = 0;
    private int y = 0;
    private boolean movimiento = false;

    public serVivo(int vida, int x, int y, boolean movimiento) {
        this.vida = vida;
        this.x = x;
        this.y = y;
        this.movimiento = movimiento;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean isMovimiento() {
        return movimiento;
    }

    public void setMovimiento(boolean movimiento) {
        this.movimiento = movimiento;
    }
    
}
