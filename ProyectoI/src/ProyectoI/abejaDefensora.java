package ProyectoI;

import static java.lang.Integer.parseInt;

/**
 *
 * @author Mari
 */
public class abejaDefensora extends abeja {

    private String tipo = "";

    public abejaDefensora(int vida, int x, int y, boolean movimiento,
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

    public void atacar(amenaza humo) {
        if (humo.getVida() > 0) {
            humo.recibirAtaque();
        } else {
            setAmenaza(false);
            setAmenazaXY("");
        }
    }

    public void ifAmenaza(String Eje, String Direccion) {
        if ((Eje == "X") && (Direccion == "UP")) {
            atacar(tablero.obtenerAmenaza((getX() + 1), (getY())));
        }
        if ((Eje == "X") && (Direccion == "Down")) {
            atacar(tablero.obtenerAmenaza((getX() - 1), (getY())));
        }
        if ((Eje == "Y") && (Direccion == "UP")) {
            atacar(tablero.obtenerAmenaza((getX()), (getY() + 1)));
        }
        if ((Eje == "Y") && (Direccion == "Down")) {
            atacar(tablero.obtenerAmenaza((getX()), (getY() - 1)));
        }
    }

    public void moveTo(String punto) {
        String[] puntos = punto.split(",");
        int puntoX = parseInt(puntos[0]);
        int puntoY = parseInt(puntos[1]);
        if (puntoX == getX()) {
            if (Math.abs(puntoY - getY()) == 1) {
                if (punto.equals(getRecursoXY())) {
                    String[] recursoPunto = getRecursoXY().split(",");
                    int recursoX = parseInt(recursoPunto[0]);
                    int recursoY = parseInt(recursoPunto[1]);
                    recurso polen = tablero.obtenerRecurso(recursoX, recursoY);
                    if (polen != null) {
                    recolectarPolen(polen);
                    }
                }
                if (punto.equals(getAmenazaXY()) && (getTipo() == "Defensora")) {
                    String[] amenazaPunto = getAmenazaXY().split(",");
                    int amenazaX = parseInt(amenazaPunto[0]);
                    int amenazaY = parseInt(amenazaPunto[1]);
                    amenaza humo = tablero.obtenerAmenaza(amenazaX, amenazaY);
                    if (humo != null) {
                    atacar(humo);
                    }
                }
                if (tablero.isEmpty(puntoX, puntoY)) {
                    setAmenaza(false);
                    setAmenazaXY("");
                    setPolen(false);
                    setRecursoXY("");
                }
            }
        } else if (puntoY == getY()) {
            if (Math.abs(puntoX - getX()) == 1) {
                if (punto.equals(getRecursoXY())) {
                    String[] recursoPunto = getRecursoXY().split(",");
                    int recursoX = parseInt(recursoPunto[0]);
                    int recursoY = parseInt(recursoPunto[1]);
                    recurso polen = tablero.obtenerRecurso(recursoX, recursoY);
                    if (polen != null) {
                    recolectarPolen(polen);
                    }
                }
                if (punto.equals(getAmenazaXY()) && (getTipo() == "Defensora")) {
                    String[] amenazaPunto = getAmenazaXY().split(",");
                    int amenazaX = parseInt(amenazaPunto[0]);
                    int amenazaY = parseInt(amenazaPunto[1]);
                    amenaza humo = tablero.obtenerAmenaza(amenazaX, amenazaY);
                    if (humo != null) {
                    atacar(humo);
                    }
                }
                if (tablero.isEmpty(puntoX, puntoY)) {
                    setAmenaza(false);
                    setAmenazaXY("");
                    setPolen(false);
                    setRecursoXY("");
                }
            }
        } else {
            if (getX() > puntoX) {
                if (tablero.isEmpty((getX() - 1), (getY()))) {
                    setX(getX() - 1);
                } else if (getY() > puntoY) {
                    if (tablero.isEmpty((getX()), (getY() - 1))) {
                        setY(getY() - 1);
                    }
                } else if (tablero.isEmpty((getX()), (getY() + 1))) {
                    setY(getY() + 1);
                }
            } else if (tablero.isEmpty((getX() + 1), (getY()))) {
                setX(getX() + 1);
            } else if (getY() > puntoY) {
                if (tablero.isEmpty((getX()), (getY() - 1))) {
                    setY(getY() - 1);
                }
            } else if (tablero.isEmpty((getX()), (getY() + 1))) {
                setY(getY() + 1);
            }
        }
    }

    public void algoritmoMovimiento() {//Algoritmo de movimiento
        if (isPolen()) {
            toColmena();
        } else if (getAmenazaXY() != "") {
            if (getTipo() == "Defensora") {
                moveTo(getAmenazaXY());
            } else {
                moveAway(getAmenazaXY());
            }
        } else if (getRecursoXY() != "") {
            moveTo(getRecursoXY());
        } else {
            moverAleatorio();
        }
    }
}
