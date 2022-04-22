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
            boolean polen, boolean amenaza, String recursoXY, String amenazaXY,
            int huidas, String posicion01, String posicion10, String posicion11,
            ProcesosTablero tablero) {
        super(vida, x, y, movimiento, posicion, posicion01, posicion10,
                posicion11, tablero);
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

    public int getHuidas() {
        return huidas;
    }

    public void setHuidas(int huidas) {
        this.huidas = huidas;
    }

    public void recolectarPolen(recurso flor) {
        if (flor.getVida() > 0) {
            this.setPolen(true);
            flor.recibirAtaque();
        } else {
            setPolen(false);
            setRecursoXY("");
        }
    }

    public void avanzarVacio() {
        if (getX() > getY()) {
            if (tablero.isEmpty((getX() - 1), (getY()))) {
                setX(getX() - 1);
            } else if (tablero.isEmpty((getX()), (getY() - 1))) {
                setY(getY() - 1);
            } else if (tablero.isEmpty((getX()), (getY() + 1))) {
                setY(getY() + 1);
            } else if (tablero.isEmpty((getX() + 1), (getY()))) {
                setX(getX() + 1);
            }
        } else {
            if (tablero.isEmpty((getX()), (getY() - 1))) {
                setY(getY() - 1);
            } else if (tablero.isEmpty((getX() - 1), (getY()))) {
                setX(getX() - 1);
            } else if (tablero.isEmpty((getX() + 1), (getY()))) {
                setX(getX() + 1);
            } else if (tablero.isEmpty((getX()), (getY() + 1))) {
                setY(getY() + 1);
            }
        }
    }

    public void toColmena() {
        if (getX() != 0 && getY() != 0) {
            avanzarVacio();
        } else if (getX() != 0 && getY() == 0) {
            if (getX() == 1) {
                setPolen(false);
                setAmenazaXY("");
                setRecursoXY("");
            } else {
                setX(getX() - 1);
            }
        } else if (getY() != 0 && getX() == 0) {
            if (getY() == 1) {
                setPolen(false);
                setAmenazaXY("");
                setRecursoXY("");
            } else {
                setY(getY() - 1);
            }
        }
    }

    public void ifAmenaza(String Eje, String Direccion) {
        if ((Eje == "X") && (Direccion == "UP")) {
            if (getX() > 0) {
                if (tablero.isEmpty((getX() - 1), (getY()))) {
                    setX(getX() - 1);
                } else if ((getY() < (tablero.size - 1)) && (tablero.isEmpty((getX()), (getY() + 1)))) {
                    setY(getY() + 1);
                } else if ((getY() > 0) && (tablero.isEmpty((getX()), (getY() - 1)))) {
                    setY(getY() - 1);
                }
            } else if (getY() < (tablero.size - 1)) {
                if (tablero.isEmpty((getX()), (getY() + 1))) {
                    setY(getY() + 1);
                }
            } else {
                if (tablero.isEmpty((getX()), (getY() - 1))) {
                    setY(getY() - 1);
                }
            }
        }
        if ((Eje == "X") && (Direccion == "Down")) {
            if (getX() < (tablero.size - 1)) {
                if (tablero.isEmpty((getX() + 1), (getY()))) {
                    setX(getX() + 1);
                } else if ((getY() < (tablero.size - 1)) && (tablero.isEmpty((getX()), (getY() + 1)))) {
                    setY(getY() + 1);
                } else if ((getY() > 0) && (tablero.isEmpty((getX()), (getY() - 1)))) {
                    setY(getY() - 1);
                }
            } else if (getY() < (tablero.size - 1)) {
                if (tablero.isEmpty((getX()), (getY() + 1))) {
                    setY(getY() + 1);
                }
            } else {
                if (tablero.isEmpty((getX()), (getY() - 1))) {
                    setY(getY() - 1);
                }
            }
        }
        if ((Eje == "Y") && (Direccion == "UP")) {
            if (getY() > 0) {
                if (tablero.isEmpty((getX()), (getY() - 1))) {
                    setY(getY() - 1);
                } else if ((getX() < (tablero.size - 1)) && (tablero.isEmpty((getX() + 1), (getY())))) {
                    setX(getX() + 1);
                } else if ((getX() > 0) && (tablero.isEmpty((getX() - 1), (getY())))) {
                    setX(getX() - 1);
                }
            } else if (getX() < (tablero.size - 1)) {
                if (tablero.isEmpty((getX() + 1), (getY()))) {
                    setX(getX() + 1);
                }
            } else {
                if (tablero.isEmpty((getX() - 1), (getY()))) {
                    setX(getX() - 1);
                }
            }
        }
        if ((Eje == "Y") && (Direccion == "Down")) {
            if (getY() < (tablero.size - 1)) {
                if (tablero.isEmpty((getX()), (getY() + 1))) {
                    setY(getY() + 1);
                } else if ((getX() < (tablero.size - 1)) && (tablero.isEmpty((getX() + 1), (getY())))) {
                    setX(getX() + 1);
                } else if ((getX() > 0) && (tablero.isEmpty((getX() - 1), (getY())))) {
                    setX(getX() - 1);
                }
            } else if (getX() < (tablero.size - 1)) {
                if (tablero.isEmpty((getX() + 1), (getY()))) {
                    setX(getX() + 1);
                }
            } else {
                if (tablero.isEmpty((getX() - 1), (getY()))) {
                    setX(getX() - 1);
                }
            }
        }
    }

    public void moverAleatorio() {
        if (tablero.random(0, 10) % 2 == 0) {
            if (tablero.random(0, 10) % 2 == 0) {
                if (getX() < (tablero.size - 1)) {
                    if (tablero.isRecurso((getX() + 1), (getY()))) {
                        setRecursoXY((getX() + 1) + "," + (getY()));
                        recurso polen = tablero.obtenerRecurso((getX() + 1), (getY()));
                        if (polen != null) {
                            recolectarPolen(polen);
                        }
                    } else if (tablero.isAmenaza((getX() + 1), (getY()))) {
                        setHuidas(10);
                        setAmenazaXY((getX() + 1) + "," + (getY()));
                        setAmenaza(true);
                        ifAmenaza("X", "UP");
                    } else if (tablero.isObstaculo((getX() + 1), (getY()))) {
                        if (getX() > 0) {
                            setX(getX() - 1);
                        } else if (getY() < (tablero.size - 1)) {
                            setY(getY() + 1);
                        } else {
                            setY(getY() - 1);
                        }
                    } else if (tablero.isAbeja((getX() + 1), (getY()))) {
                        abeja otra = tablero.obtenerAbeja((getX() + 1), (getY()));
                        if (otra.isPolen()) {
                            setPolen(true);
                            setRecursoXY(otra.getRecursoXY());
                        }
                        if (otra.isAmenaza()) {
                            setHuidas(10);
                            setAmenaza(true);
                            setAmenazaXY(otra.getAmenazaXY());
                        }
                    } else if (tablero.isEmpty((getX() + 1), (getY()))) {
                        setX(getX() + 1);
                    }
                }
            } else {
                if (getX() > 0) {
                    if (tablero.isRecurso((getX() - 1), (getY()))) {
                        setRecursoXY((getX() - 1) + "," + (getY()));
                        recurso polen = tablero.obtenerRecurso((getX() + 1), (getY()));
                        if (polen != null) {
                            recolectarPolen(polen);
                        }
                    } else if (tablero.isAmenaza((getX() - 1), (getY()))) {
                        setAmenazaXY((getX() - 1) + "," + (getY()));
                        setHuidas(10);
                        setAmenaza(true);
                        ifAmenaza("X", "DOWN");
                    } else if (tablero.isObstaculo((getX() - 1), (getY()))) {
                        if (getX() < (tablero.size - 1)) {
                            setX(getX() + 1);
                        } else if (getY() < (tablero.size - 1)) {
                            setY(getY() + 1);
                        } else {
                            setY(getY() - 1);
                        }
                    } else if (tablero.isAbeja((getX() - 1), (getY()))) {
                        abeja otra = tablero.obtenerAbeja((getX() - 1), (getY()));
                        if (otra.isPolen()) {
                            setPolen(true);
                            setRecursoXY(otra.getRecursoXY());
                        }
                        if (otra.isAmenaza()) {
                            setHuidas(10);
                            setAmenaza(true);
                            setAmenazaXY(otra.getAmenazaXY());
                        }
                    } else if (tablero.isEmpty((getX() - 1), (getY()))) {
                        setX(getX() - 1);
                    }
                }
            }
        } else {
            if (tablero.random(0, 10) % 2 == 0) {
                if (getY() < (tablero.size - 1)) {
                    if (tablero.isRecurso((getX()), (getY() + 1))) {
                        setRecursoXY((getX()) + "," + (getY() + 1));
                        recurso polen = tablero.obtenerRecurso((getX()), (getY() + 1));
                        if (polen != null) {
                            recolectarPolen(polen);
                        }
                    } else if (tablero.isAmenaza((getX()), (getY() + 1))) {
                        setHuidas(10);
                        setAmenazaXY((getX()) + "," + (getY() + 1));
                        setAmenaza(true);
                        ifAmenaza("Y", "UP");
                    } else if (tablero.isObstaculo((getX()), (getY() + 1))) {
                        if (getY() > 0) {
                            setY(getY() - 1);
                        } else if (getX() < (tablero.size - 1)) {
                            setX(getX() + 1);
                        } else {
                            setX(getX() - 1);
                        }
                    } else if (tablero.isAbeja((getX()), (getY() + 1))) {
                        abeja otra = tablero.obtenerAbeja((getX()), (getY() + 1));
                        if (otra.isPolen()) {
                            setPolen(true);
                            setRecursoXY(otra.getRecursoXY());
                        }
                        if (otra.isAmenaza()) {
                            setHuidas(10);
                            setAmenaza(true);
                            setAmenazaXY(otra.getAmenazaXY());
                        }
                    } else if (tablero.isEmpty((getX()), (getY() + 1))) {
                        setY(getY() + 1);
                    }
                }
            } else {
                if (getY() > 0) {
                    if (tablero.isRecurso((getX()), (getY() - 1))) {
                        setRecursoXY((getX()) + "," + (getY() + 1));
                        recurso polen = tablero.obtenerRecurso((getX()), (getY() - 1));
                        if (polen != null) {
                            recolectarPolen(polen);
                        }
                    } else if (tablero.isAmenaza((getX()), (getY() - 1))) {
                        setHuidas(10);
                        setAmenazaXY((getX()) + "," + (getY() - 1));
                        setAmenaza(true);
                        ifAmenaza("Y", "DOWN");
                    } //Fin is Treat
                    else if (tablero.isObstaculo((getX()), (getY() - 1))) {
                        if (getY() < (tablero.size - 1)) {
                            setY(getY() + 1);
                        } else if (getX() < (tablero.size - 1)) {
                            setX(getX() + 1);
                        } else {
                            setX(getX() - 1);
                        }
                    } else if (tablero.isAbeja((getX()), (getY() - 1))) {
                        abeja otra = tablero.obtenerAbeja((getX()), (getY() - 1));
                        if (otra.isPolen()) {
                            setPolen(true);
                            setRecursoXY(otra.getRecursoXY());
                        }
                        if (otra.isAmenaza()) {
                            setHuidas(10);
                            setAmenaza(true);
                            setAmenazaXY(otra.getAmenazaXY());
                        }
                    } else if (tablero.isEmpty((getX()), (getY() - 1))) {
                        setY(getY() - 1);
                    }
                }
            }
        }
    }

    public void moveTo(String punto) {
        String[] puntos = punto.split(",");
        int puntoX = parseInt(puntos[0]);
        int puntoY = parseInt(puntos[1]);
        if (puntoX == getX()) {
            if (Math.abs(puntoY - getY()) == 1) {
                if (punto.equals(recursoXY)) {
                    String[] recursoPunto = recursoXY.split(",");
                    int recursoX = parseInt(recursoPunto[0]);
                    int recursoY = parseInt(recursoPunto[1]);
                    recurso polen = tablero.obtenerRecurso(recursoX, recursoY);
                    if (polen != null) {
                        recolectarPolen(polen);
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
                if (punto.equals(recursoXY)) {
                    String[] recursoPunto = recursoXY.split(",");
                    int recursoX = parseInt(recursoPunto[0]);
                    int recursoY = parseInt(recursoPunto[1]);
                    recurso polen = tablero.obtenerRecurso(recursoX, recursoY);
                    if (polen != null) {
                        recolectarPolen(polen);
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

    public void moveAway(String punto) {
        String[] puntos = punto.split(",");
        int puntoX = parseInt(puntos[0]);
        int puntoY = parseInt(puntos[1]);
        if (getHuidas() != 0) {
            if (getX() > puntoX) {
                if (getX() < (tablero.size - 1) && tablero.isEmpty((getX() + 1), (getY()))) {
                    setX(getX() + 1);
                } else if (getY() > puntoY) {
                    if (getY() < (tablero.size - 1) && tablero.isEmpty((getX()), (getY() + 1))) {
                        setY(getY() + 1);
                    } else if (tablero.isEmpty((getX()), (getY() - 1))) {
                        setY(getY() - 1);
                    }
                }
            } else if (getX() > 0 && tablero.isEmpty((getX() - 1), (getY()))) {
                setX(getX() - 1);
            } else if (getY() < puntoY) {
                if (getY() > 0 && tablero.isEmpty((getX()), (getY() - 1))) {
                    setY(getY() - 1);
                } else if (tablero.isEmpty((getX()), (getY() + 1))) {
                    setY(getY() + 1);
                }
            } else if (getY() < (tablero.size - 1) && tablero.isEmpty((getX()), (getY() + 1))) {
                setY(getY() + 1);
            }
            setHuidas(getHuidas() - 1);
        } else {
            setHuidas(0);
            setAmenaza(false);
            setAmenazaXY("");
        }
    }
}
