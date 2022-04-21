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
    private String posicion = "";
    ProcesosTablero tablero;

    public serVivo(int vida, int x, int y, boolean movimiento, String posicion, ProcesosTablero tablero) {
        this.vida = vida;
        this.x = x;
        this.y = y;
        this.movimiento = movimiento;
        this.posicion = posicion;
        this.tablero = tablero;
    }

    public void recibirAtaque() {
        this.vida--;
        if (vida <= 0) {
            this.morir();
        }
    }

    public void morir() {
        setVida(0);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        this.posicion = this.x + "," + this.y;
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
        this.posicion = this.x + "," + this.y;
    }

    public boolean isMovimiento() {
        return movimiento;
    }

    public void setMovimiento(boolean movimiento) {
        this.movimiento = movimiento;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

}
