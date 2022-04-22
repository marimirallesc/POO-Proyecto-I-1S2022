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
    private String posicion01 = "";
    private String posicion10 = "";
    private String posicion11 = "";
    ProcesosTablero tablero;

    public serVivo(int vida, int x, int y, boolean movimiento, String posicion, 
            String posicion01, String posicion10, String posicion11, 
            ProcesosTablero tablero) {
        this.vida = vida;
        this.x = x;
        this.y = y;
        this.movimiento = movimiento;
        this.posicion = posicion;
        this.posicion01 = posicion01;
        this.posicion10 = posicion10;
        this.posicion11 = posicion11;
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
        this.posicion = (this.x) + "," + (this.y);
        this.posicion01 = (this.x + 1) + "," + (this.y);
        this.posicion10 = (this.x) + "," + (this.y + 1);
        this.posicion11 = (this.x + 1) + "," + (this.y + 1);
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
        this.posicion = (this.x) + "," + (this.y);
        this.posicion01 = (this.x + 1) + "," + (this.y);
        this.posicion10 = (this.x) + "," + (this.y + 1);
        this.posicion11 = (this.x + 1) + "," + (this.y + 1);
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

    public String getPosicion01() {
        return posicion01;
    }

    public void setPosicion01(String posicion01) {
        this.posicion01 = posicion01;
    }

    public String getPosicion10() {
        return posicion10;
    }

    public void setPosicion10(String posicion10) {
        this.posicion10 = posicion10;
    }

    public String getPosicion11() {
        return posicion11;
    }

    public void setPosicion11(String posicion11) {
        this.posicion11 = posicion11;
    }

}
