package ProyectoI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import static java.lang.constant.ConstantDescs.NULL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ProcesosTablero {

    public ProcesosTablero(JPanel pnlTablero, JFrame ventanaP) throws Exception {
        panel = pnlTablero;
        ventana = ventanaP;
        sizeJLabel(); //Establece el tamaño de los JLabel según el panel
        inicio(10); //En teoría es para generar todos los elementos
        crearTablero(); //Crea el tablero
    }

    public int random(int min, int max) { //Retorna un número random
        int num = (int) (Math.random() * (max - min)) + min;
        return num;
    }

    private void sizeJLabel() {
        //Asigna el tamaño de los labels según la dimensión del panel, sus columnas
        //y filas
        dimension = panel.getSize(); //Dimensión del panel
        TableroX = dimension.width; //Ancho del panel
        TableroY = dimension.height; //Alto del panel
        TamX = TableroX / DimensionX; //Ancho del label
        TamY = TableroY / DimensionY; //Alto del label
    }

    public void inicio(int max) {
        //Llama a generar las posiciones de los objetos
        //Max es la cantidad de objetos a generar
        todo.add("0,0"); //Posición de la colmena
        todo.add("0,1"); //Punto de acceso de la abeja a la colmena
        todo.add("1,0"); //Punto de acceso de la abeja a la colmena
        agregarObjetos(1, max); //Genera las posiciones de las defensoras
        agregarObjetos(2, max); //Genera las posiciones de las recolectoras
        agregarObjetos(3, max); //Genera las posiciones de los obstáculos
        agregarObjetos(4, max); //Genera las posiciones de los recursos
        agregarObjetos(5, max); //Genera las posiciones de las amenazas
    }

    public void agregarObjetos(int valor, int cant) {
        //Genera las posiciones de los objetos según la cantidad
        String var00 = "";
        String var01 = "";
        String var10 = "";
        String var11 = "";
        int num = size - 2;
        for (int i = 0; i < cant; i++) {
            do {
                x = random(0, num);
                y = random(0, num);
                var00 = x + "," + y;
                var01 = x + "," + (y + 1);
                var10 = (x + 1) + "," + y;
                var11 = (x + 1) + "," + (y + 1);
            } while (todo.contains(var00) || todo.contains(var01)
                    || todo.contains(var10) || todo.contains(var11));
            //Las posiciones deben ser únicas
            switch (valor) {
                case 1: //Posiciones abejas defensoras
                    abejasDefensoras.add(var00);
                    todo.add(var00);
                    defensoraAL.add(new abejaDefensora(10, x, y, true, var00,
                            false, false, "Defensora", "", "", 10, this));
                    break;
                case 2: //Posiciones abejas recolectoras
                    abejasRecolectoras.add(var00);
                    todo.add(var00);
                    recolectoraAL.add(new abejaRecolectora(10, x, y, true,
                            var00, false, false, "Recolectora", "", "", 10,
                            this));
                    break;
                case 3: //Posiciones obstáculos
                    obstaculos.add(var00);
                    todo.add(var00);
                    obstaculos.add(var01);
                    todo.add(var01);
                    obstaculos.add(var10);
                    todo.add(var10);
                    obstaculos.add(var11);
                    todo.add(var11);
                    muroAL.add(new obstaculo(-1, x, y, false, var00, this));
                    break;
                case 4: //Posiciones recursos
                    recursos.add(var00);
                    recursos00.add(var00);
                    todo.add(var00);
                    recursos.add(var01);
                    recursos01.add(var01);
                    todo.add(var01);
                    recursos.add(var10);
                    recursos10.add(var10);
                    todo.add(var10);
                    recursos.add(var11);
                    recursos11.add(var11);
                    todo.add(var11);
                    florAL.add(new recurso(10, x, y, false, var00, this));
                    break;
                case 5: //Posiciones amenazas
                    amenazas.add(var00);
                    amenazas00.add(var00);
                    todo.add(var00);
                    amenazas.add(var01);
                    amenazas01.add(var01);
                    todo.add(var01);
                    amenazas.add(var10);
                    amenazas10.add(var10);
                    todo.add(var10);
                    amenazas.add(var11);
                    amenazas11.add(var11);
                    todo.add(var11);
                    humoAL.add(new amenaza(10, x, y, false, var00, this));
                    break;
            }
        }
    }

    private void crearTablero() {
        //Crea el tablero de labels y llama a imprimir el primer recurso y la 
        //primera amenaza
        int contadorX, contadorY;
        MatrizLabels = new JLabel[DimensionX][DimensionY];
        panel.setLayout(new GridLayout(DimensionX, DimensionY));
        for (contadorX = 0; contadorX < DimensionX; contadorX++) {
            for (contadorY = 0; contadorY < DimensionY; contadorY++) {
                JLabel jLNuevo = new JLabel();
                jLNuevo.setSize(TamX, TamY);
                jLNuevo.setToolTipText(Integer.toString(contadorX) + "," + Integer.toString(contadorY));

                if (obstaculos.contains(jLNuevo.getToolTipText())) {
                    jLNuevo.setIcon(obstaculo);
                } else if (abejasDefensoras.contains(jLNuevo.getToolTipText())) {
                    jLNuevo.setIcon(iconDefensora);
                } else if (abejasRecolectoras.contains(jLNuevo.getToolTipText())) {
                    jLNuevo.setIcon(iconRecolectora);
                } else if (jLNuevo.getToolTipText().equals("0,0")) {
                    jLNuevo.setIcon(colmena);
                }

                MatrizLabels[contadorX][contadorY] = jLNuevo;
                panel.add(MatrizLabels[contadorX][contadorY]);
            }
        }
        imprimir();
    }

    public void continuar() {
        //Llama a los algoritmos de movimiento de las abejas y llama a imprimir
        //los recursos, amenazas y abejas con sus posiciones actualizadas
        imprimir();
        for (int i = 0; i < MatrizLabels.length; i++) {
            for (int j = 0; j < MatrizLabels.length; j++) {
                posicion = MatrizLabels[i][j].getToolTipText();
                JLabel jLNuevo = MatrizLabels[i][j];
                for (int k = 0; k < 10; k++) {
                    if (defensoraAL.get(k).getPosicion() == posicion) {
                        jLNuevo.setIcon(iconDefensora);
                    } else if (recolectoraAL.get(k).getPosicion() == posicion) {
                        jLNuevo.setIcon(iconRecolectora);
                    }
                }
            }
        }
    }

    public void imprimir() {
        //LLama a imprimir amenazas y recursos en el tiempo
        ponerRecursos(veces);
        ponerAmenazas(veces);
        veces++;
    }

    public void ponerRecursos(int num) { //Imprime los recursos
        int contador00 = 0;
        int contador01 = 0;
        int contador10 = 0;
        int contador11 = 0;
        for (int i = 0; i < MatrizLabels.length; i++) {
            for (int j = 0; j < MatrizLabels.length; j++) {
                JLabel jLNuevo = MatrizLabels[i][j];
                posicion = jLNuevo.getToolTipText();
                if (florAL.get(i).getVida() > 0) {
                    if (recursos00.contains(posicion)) {
                        if (contador00 <= num) {
                            jLNuevo.setIcon(flor00);
                            contador00++;
                        }
                    } else if (recursos01.contains(posicion)) {
                        if (contador01 <= num) {
                            jLNuevo.setIcon(flor01);
                            contador01++;
                        }
                    } else if (recursos10.contains(posicion)) {
                        if (contador10 <= num) {
                            jLNuevo.setIcon(flor10);
                            contador10++;
                        }
                    } else if (recursos11.contains(posicion)) {
                        if (contador11 <= num) {
                            jLNuevo.setIcon(flor11);
                            contador11++;
                        }
                    }
                } else if (florAL.get(i).getVida() == 0) {
                    if (recursos00.contains(posicion)) {
                        jLNuevo.setIcon(null);
                    } else if (recursos01.contains(posicion)) {
                        jLNuevo.setIcon(null);
                    } else if (recursos10.contains(posicion)) {
                        jLNuevo.setIcon(null);
                    } else if (recursos11.contains(posicion)) {
                        jLNuevo.setIcon(null);
                    }
                    florAL.get(i).setVida(10);
                }
            }
        }
    }

    public void ponerAmenazas(int num) { //Imprime las amenazas
        int contador00 = 0;
        int contador01 = 0;
        int contador10 = 0;
        int contador11 = 0;
        for (int i = 0; i < MatrizLabels.length; i++) {
            for (int j = 0; j < MatrizLabels.length; j++) {
                posicion = MatrizLabels[i][j].getToolTipText();
                JLabel jLNuevo = MatrizLabels[i][j];
                if (humoAL.get(i).getVida() > 0) {
                    if (amenazas00.contains(posicion)) {
                        if (contador00 <= num) {
                            jLNuevo.setIcon(humo00);
                            contador00++;
                        }
                    } else if (amenazas01.contains(posicion)) {
                        if (contador01 <= num) {
                            jLNuevo.setIcon(humo01);
                            contador01++;
                        }
                    } else if (amenazas10.contains(posicion)) {
                        if (contador10 <= num) {
                            jLNuevo.setIcon(humo10);
                            contador10++;
                        }
                    } else if (amenazas11.contains(posicion)) {
                        if (contador11 <= num) {
                            jLNuevo.setIcon(humo11);
                            contador11++;
                        }
                    }
                } else if (humoAL.get(i).getVida() == 0) {
                    if (amenazas00.contains(posicion)) {
                        jLNuevo.setIcon(null);
                    } else if (amenazas01.contains(posicion)) {
                        jLNuevo.setIcon(null);
                    } else if (amenazas10.contains(posicion)) {
                        jLNuevo.setIcon(null);
                    } else if (amenazas11.contains(posicion)) {
                        jLNuevo.setIcon(null);
                    }
                    humoAL.get(i).setVida(10);
                }
            }
        }
    }

//Variables globales
    //00 = Lado superior izquierdo
    //01 = Lado superior derecho
    //10 = Lado inferior izquierdo
    //11 = Lado inferior derecho
//Interfaz
    JLabel[][] MatrizLabels; //Contiene todos los labels
    JPanel panel; //Panel en el que se imprimen los objetos
    JFrame ventana; //Ventana del proyecto
    Dimension dimension; //Dimensión del panel principal

    //Variables simples
    int size = 50; //Para simplificar porque ambas dimensiones son 50
    int DimensionX = size; //Cantidad de columnas
    int DimensionY = size; //Cantidad de filas
    int TableroX;// La anchura exacta del panel = 1335; 
    int TableroY;//La altura exacta del panel = 845;
    int TamX; //La anchura de los labels de acuerdo al panel
    int TamY; //La altura de los labels de acuerdo al panel
    int x = 0; //Valor en el ejeX
    int y = 0; //Valor en el ejeY
    int veces = 0; //Veces en las que se han impreso los recursos y amenazas
    String posicion = ""; //Posicion de un objeto

    //ArrayList <String> Estos arrays son para tener el control de las 
    //coordenadas
    ArrayList<String> abejasDefensoras = new ArrayList<String>();
    //Contiene todos las coordenadas de las abeja defensoras
    ArrayList<String> abejasRecolectoras = new ArrayList<String>();
    //Contiene todos las coordenadas de las abeja recolectoras
    ArrayList<String> obstaculos = new ArrayList<String>();
    //Contiene todos las coordenadas de los obstáculos
    ArrayList<String> recursos = new ArrayList<String>();
    //Contiene todos las coordenadas de los recursos
    ArrayList<String> recursos00 = new ArrayList<String>();
    //Lado superior izquierdo
    ArrayList<String> recursos01 = new ArrayList<String>();
    //Lado superior derecho
    ArrayList<String> recursos10 = new ArrayList<String>();
    //Lado inferior izquierdo
    ArrayList<String> recursos11 = new ArrayList<String>();
    //Lado inferior derecho
    ArrayList<String> amenazas = new ArrayList<String>();
    //Contiene todos las coordenadas de las amenazas
    ArrayList<String> amenazas00 = new ArrayList<String>();
    //Lado superior izquierdo
    ArrayList<String> amenazas01 = new ArrayList<String>();
    //Lado superior derecho
    ArrayList<String> amenazas10 = new ArrayList<String>();
    //Lado inferior izquierdo
    ArrayList<String> amenazas11 = new ArrayList<String>();
    //Lado inferior derecho
    ArrayList<String> todo = new ArrayList<String>();
    //Contiene todas las coordenadas que no son vacías (contiene un icono)

    //ArrayList <serVivo> Estos arrays contienen los elementos
    ArrayList<abejaDefensora> defensoraAL = new ArrayList<>();
    //Contiene todos los objetos de las abeja defensoras
    ArrayList<abejaRecolectora> recolectoraAL = new ArrayList<>();
    //Contiene todos los objetos de las abeja recolectoras
    ArrayList<obstaculo> muroAL = new ArrayList<>();
    //Contiene todos los objetos de los obstáculos
    ArrayList<recurso> florAL = new ArrayList<>();
    //Contiene todos los objetos de los recursos
    ArrayList<amenaza> humoAL = new ArrayList<>();
    //Contiene todos los objetos de las amenazas

    //ImageIcon 
    //Colmena
    ImageIcon colmena = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/colmena2.png"));
    //Abeja Recolector
    ImageIcon iconRecolectora = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/abejaRecolector.png"));
    //Abeja Defensor
    ImageIcon iconDefensora = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/abejaDefensor.png"));
    //Obstáculo
    ImageIcon obstaculo = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/obstaculo.png"));
    //Recurso
    ImageIcon flor00 = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/flor00.png"));
    ImageIcon flor01 = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/flor01.png"));
    ImageIcon flor10 = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/flor10.png"));
    ImageIcon flor11 = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/flor11.png"));
    //Amenaza
    ImageIcon humo00 = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/humo00.png"));
    ImageIcon humo01 = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/humo01.png"));
    ImageIcon humo10 = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/humo10.png"));
    ImageIcon humo11 = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/humo11.png"));
}
