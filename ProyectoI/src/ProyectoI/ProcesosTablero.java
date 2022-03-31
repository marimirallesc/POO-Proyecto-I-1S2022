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

    //Variables simples
    int size = 50;
    int DimensionX = size;
    int DimensionY = size;
    int TableroX;// = 1335;
    int TableroY;// = 845;
    int TamX;
    int TamY;
    int var1;
    int var2;
    boolean gano = false;
    String actual;
    //ArrayList
    ArrayList<String> abejasBase = new ArrayList<String>();
    ArrayList<String> abejasRecolector = new ArrayList<String>();
    ArrayList<String> obstaculos = new ArrayList<String>();
    //Interfaz
    JLabel[][] MatrizBotones;
    JLabel anterior;
    JPanel panel;
    JFrame ventana;
    //Dimensión del panel principal
    Dimension dimension;
    //ImageIcon 
    //Colmena
    ImageIcon colmena00 = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/colmena00.png"));
    ImageIcon colmena01 = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/colmena01.png"));
    ImageIcon colmena10 = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/colmena10.png"));
    ImageIcon colmena11 = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/colmena11.png"));
    //Abejas
    ImageIcon abejaBase = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/abejaBase.png"));
    ImageIcon abejaRecolector = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/abejaRecolector.png"));
    ImageIcon abejaDefensor = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/abejaDefensor.png"));
    //Obstáculo
    ImageIcon obstaculo = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/obstaculo.png"));
    //Recurso
    ImageIcon recurso = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/recurso.png"));
    //Amenaza
    ImageIcon amenaza = new javax.swing.ImageIcon(getClass()
            .getResource("/Imagenes/amenaza.png"));

    public ProcesosTablero(JPanel pnlTablero, JFrame ventanaP) throws Exception {
        panel = pnlTablero;
        ventana = ventanaP;
        sizeJLabel(); //Establece el tamaño de los JLabel según el panel
        inicio(0, -1); //En teoría es para generar todos los elementos
        crearTablero(); //Crea el tablero
    }

    public void anuncios() { //Imprime si gana o pierde y termina la ejecución
        panel.setEnabled(false);
        if (gano) {
            JOptionPane.showMessageDialog(panel, "Ganaste");
        } else {
            JOptionPane.showMessageDialog(panel, "Perdiste");
        }
        ventana.dispose();
    }

    public int random(int min, int max) { //Retorna un número random
        for (int i = min; i <= max; i++) {
            int num = (int) (Math.random() * (max - min)) + min;
            return num;
        }
        return 5;
    }

    private void sizeJLabel() {
        dimension = panel.getSize();
        TableroX = dimension.width;
        TableroY = dimension.height;
        TamX = TableroX / DimensionX;
        TamY = TableroY / DimensionY;
        //System.out.println(TamX + "\t" + TamY);
    }

    public void inicio(int array, int maxP) {
        String var = "";
        int num = size - 1;
        int max = maxP;
        if (max == -1) {
            max = random(10, 15);
        }
        for (int i = 0; i < max; i++) {
            do {
                var = random(0, num) + "," + random(0, num);
            } while ("0,0".equals(var) && "0,1".equals(var) && "1,0".equals(var)
                    && "1,1".equals(var));
                        obstaculos.add(var);
        }
 /*switch (array) {
            case 0:
                max = max / 2;
                for (int i = 2; i < max; i++) {
                    var = 0 + "," + i;
                    abejasBase.add(var);
                }
                for (int i = 2; i < max; i++) {
                    var = 1 + "," + i;
                    abejasBase.add(var);
                }
                for (int j = 0; j < max; j++) {
                    var = 2 + "," + j;
                    abejasBase.add(var);
                }
                break;
        }*/
    }

    private void crearTablero() {
        int contadorX, contadorY;
        MatrizBotones = new JLabel[DimensionX][DimensionY];
        panel.setLayout(new GridLayout(DimensionX, DimensionY));
        for (contadorX = 0; contadorX < DimensionX; contadorX++) {
            for (contadorY = 0; contadorY < DimensionY; contadorY++) {
                JLabel jLNuevo = new JLabel();
                jLNuevo.setSize(TamX, TamY);
                jLNuevo.setToolTipText(Integer.toString(contadorX) + "," + Integer.toString(contadorY));
                if (obstaculos.contains(jLNuevo.getToolTipText())) {
                    jLNuevo.setIcon(obstaculo);
                }
                if (jLNuevo.getToolTipText().equals("0,0")) {
                    jLNuevo.setIcon(colmena00);
                } else if (jLNuevo.getToolTipText().equals("0,1")) {
                    jLNuevo.setIcon(colmena01);
                } else if (jLNuevo.getToolTipText().equals("1,0")) {
                    jLNuevo.setIcon(colmena10);
                } else if (jLNuevo.getToolTipText().equals("1,1")) {
                    jLNuevo.setIcon(colmena11);
                } else if (jLNuevo.getToolTipText().equals("2,0")) {
                    jLNuevo.setIcon(abejaBase);
                } else if (jLNuevo.getToolTipText().equals("2,1")) {
                    jLNuevo.setIcon(abejaRecolector);
                } else if (jLNuevo.getToolTipText().equals("2,2")) {
                    jLNuevo.setIcon(abejaDefensor);
                } else if (jLNuevo.getToolTipText().equals("2,3")) {
                    jLNuevo.setIcon(obstaculo);
                } else if (jLNuevo.getToolTipText().equals("2,4")) {
                    jLNuevo.setIcon(recurso);
                } else if (jLNuevo.getToolTipText().equals("2,5")) {
                    jLNuevo.setIcon(amenaza);
                } else {
                    jLNuevo.setText("X");
                }
                MatrizBotones[contadorX][contadorY] = jLNuevo;
                panel.add(MatrizBotones[contadorX][contadorY]);
            }
        }
    }

    /*private void isIcon(JLabel label) { //Determina si el JLabel tiene icono
        try {
            if (label.getIcon().equals(NULL)) {
            }
        } catch (NullPointerException e) {
            algoritmoMovimiento();
        }
    }*/
    public void algoritmoMovimiento() { //Algoritmo de movimiento
        ArrayList array = abejasBase;
        for (int i = 0; i < array.size(); i++) {
            String strMain = array.get(i).toString();
            String[] arrSplit = strMain.split(",");
            var1 = parseInt(arrSplit[0]);
            var2 = parseInt(arrSplit[1]);
        }
    }

}
