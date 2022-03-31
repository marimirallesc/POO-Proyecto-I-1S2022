package ProyectoI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends javax.swing.JFrame {

    int size = 50;
    int DimensionX = size;
    int DimensionY = size;
    int cantidad = (DimensionX * DimensionY) / 2;
    int TamX = 0;
    int TamY = 0;
    int contador = 0;
    int total = 0;
    static final int TableroX = 1500;
    static final int TableroY = 1000;
    JButton[][] MatrizBotones;
    JButton anterior;
    ArrayList<String> contenido = new ArrayList<String>();
    int id = 0;
    String valorID = "";
    int contadorX, contadorY;
    ImageIcon recolector = new javax.swing.ImageIcon(getClass().getResource("/Imagenes/abejaT.png"));
    ImageIcon casilla = new javax.swing.ImageIcon(getClass().getResource(""));
    boolean turnoGato = true;
    boolean gano = false;
    int var1;
    int var2;
    int norte;
    int oeste;
    int este;
    int sur;
    int no;
    int ne;
    int so;
    int se;
    String strnorte;
    String stroeste;
    String streste;
    String strsur;
    String strno;
    String strne;
    String strso;
    String strse;
    String actual;

    public VentanaPrincipal() {
        initComponents();
        setTitle("Proyecto I");
        setLocationRelativeTo(null);
        pnlTablero.setOpaque(false);
        inicio();
        crearTablero();
    }

    public int aleatorioProcedimiento(int min, int max) {
        for (int i = min; i <= max; i++) {
            int num = (int) (Math.random() * (max - min)) + min;
            return num;
        }
        return 5;
    }

    public void inicio() {
        String var = "";
        for (int i = 0; i < aleatorioProcedimiento(9, 22); i++) {
            do {
                var = aleatorioProcedimiento(0, 10) + "," + aleatorioProcedimiento(0, 10);
            } while ("5,5".equals(var));
            contenido.add(var);
        }
    }

    public void algoritmoAbeja() {
        boolean valor = false;
        int contadorGato = 0;
        if (MatrizBotones[var1][var2].getIcon().equals(recolector)) {
            rectas();
            diagonales();
            algoritmo();
        }
        if (var1 == 0 || var1 == 10 || var2 == 0 || var2 == 10) {
            anuncios(2);
        }
    }

    public void rectas() {
        oeste = var1 - 0;
        oeste = (int) Math.pow(oeste, 2);
        oeste = (int) Math.sqrt(oeste);
        este = var1 - 10;
        este = (int) Math.pow(este, 2);
        este = (int) Math.sqrt(este);
        norte = var2 - 0;
        norte = (int) Math.pow(norte, 2);
        norte = (int) Math.sqrt(norte);
        sur = var2 - 10;
        sur = (int) Math.pow(sur, 2);
        sur = (int) Math.sqrt(sur);
        stroeste = var1 + "," + (var2 - 1);
        streste = var1 + "," + (var2 + 1);
        strnorte = (var1 - 1) + "," + var2;
        strsur = (var1 + 1) + "," + var2;
    }

    public void diagonales() {
        if (norte <= oeste) {
            no = norte;
            strno = (var1 - 1) + "," + (var2 - 1);
        } else {
            no = oeste;
            strno = (var1 - 1) + "," + (var2 - 1);
        }
        if (norte <= este) {
            ne = norte;
            strne = (var1 - 1) + "," + (var2 + 1);
        } else {
            ne = este;
            strne = (var1 - 1) + "," + (var2 + 1);
        }
        if (sur <= oeste) {
            so = sur;
            strso = (var1 + 1) + "," + (var2 - 1);
        } else {
            so = oeste;
            strso = (var1 + 1) + "," + (var2 - 1);
        }
        if (sur <= este) {
            se = sur;
            strse = (var1 + 1) + "," + (var2 + 1);
        } else {
            se = este;
            strse = (var1 + 1) + "," + (var2 + 1);
        }
    }

    public void algoritmo() {
        ArrayList contenidoint = new ArrayList();
        ArrayList<String> contenidostr = new ArrayList<String>();
        int contadorAlg = 11;
        int valorAlg = 0;
        int indiceAlg = 0;
        if (!contenido.contains(stroeste)) {
            contenidoint.add(oeste);
            contenidostr.add("oeste");
        }
        if (!contenido.contains(streste)) {
            contenidoint.add(este);
            contenidostr.add("este");
        }
        if (!contenido.contains(strnorte)) {
            contenidoint.add(norte);
            contenidostr.add("norte");
        }
        if (!contenido.contains(strsur)) {
            contenidoint.add(sur);
            contenidostr.add("sur");
        }
        if (!contenido.contains(strno)) {
            contenidoint.add(no);
            contenidostr.add("no");
        }
        if (!contenido.contains(strne)) {
            contenidoint.add(ne);
            contenidostr.add("ne");
        }
        if (!contenido.contains(strso)) {
            contenidoint.add(so);
            contenidostr.add("so");
        }
        if (!contenido.contains(strse)) {
            contenidoint.add(se);
            contenidostr.add("se");
        }
        int size = (int) contenidoint.size();
        if (size == 0) {
            gano = true;
            anuncios(2);
        } else {
            for (int i = 0; i < contenidoint.size(); i++) {
                valorAlg = (int) contenidoint.get(i);
                if (contadorAlg > valorAlg && contadorAlg != valorAlg) {
                    contadorAlg = valorAlg;
                    indiceAlg = i;
                }
            }
            algoritmoInterno(contenidostr.get(indiceAlg));
        }
    }

    public void algoritmoInterno(String dir) {
        switch (dir) {
            case "oeste":
                anterior.setIcon(null);
                var2--;
                anterior = MatrizBotones[var1][var2];
                anterior.setIcon(recolector);
                actual = stroeste;
                break;
            case "este":
                anterior.setIcon(null);
                var2++;
                anterior = MatrizBotones[var1][var2];
                anterior.setIcon(recolector);
                actual = streste;
                break;
            case "norte":
                anterior.setIcon(null);
                var1--;
                anterior = MatrizBotones[var1][var2];
                anterior.setIcon(recolector);
                actual = strnorte;
                break;
            case "sur":
                anterior.setIcon(null);
                var1++;
                anterior = MatrizBotones[var1][var2];
                anterior.setIcon(recolector);
                actual = strsur;
                break;
            case "no":
                anterior.setIcon(null);
                var1--;
                var2--;
                anterior = MatrizBotones[var1][var2];
                anterior.setIcon(recolector);
                actual = strno;
                break;
            case "ne":
                anterior.setIcon(null);
                var1--;
                var2++;
                anterior = MatrizBotones[var1][var2];
                anterior.setIcon(recolector);
                actual = strne;
                break;
            case "so":
                anterior.setIcon(null);
                var1++;
                var2--;
                anterior = MatrizBotones[var1][var2];
                anterior.setIcon(recolector);
                actual = strso;
                break;
            case "se":
                anterior.setIcon(null);
                var1++;
                var2++;
                anterior = MatrizBotones[var1][var2];
                anterior.setIcon(recolector);
                actual = strse;
                break;
            default:
                throw new AssertionError();
        }
    }

    private void crearTablero() {
        MatrizBotones = new JButton[DimensionX][DimensionY];
        pnlTablero.setLayout(new GridLayout(DimensionX, DimensionY));
        for (contadorX = 0; contadorX < DimensionX; contadorX++) {
            for (contadorY = 0; contadorY < DimensionY; contadorY++) {
                JButton btnNuevo = new JButton();
                btnNuevo.setSize(TamX, TamY);
                btnNuevo.setToolTipText(Integer.toString(contadorX) + "," + Integer.toString(contadorY));
                if (contenido.contains(btnNuevo.getToolTipText())) {
                    btnNuevo.setIcon(casilla);
                }
                if (btnNuevo.getToolTipText().equals("23,22")) {
                    anterior = btnNuevo;
                    btnNuevo.setIcon(recolector);
                    var1 = contadorX;
                    var2 = contadorY;
                    actual = btnNuevo.getToolTipText();
                }
                //btnNuevo.setEnabled(false);
                MatrizBotones[contadorX][contadorY] = btnNuevo;
                MatrizBotones[contadorX][contadorY].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Click(btnNuevo);
                        valorID = btnNuevo.getToolTipText();
                        if (!contenido.contains(valorID) && valorID != actual) {
                            Click(btnNuevo);
                            contador++;
                            contenido.add(valorID);
                            algoritmoAbeja();
                        } else if (valorID == actual) {
                            JOptionPane.showMessageDialog(null, "¡Auch!");
                        }
                    }
                });
                pnlTablero.add(MatrizBotones[contadorX][contadorY]);
                RedibujarTablero();
            }
        }
    }

    private void RedibujarTablero() {
        pnlTablero.validate();
        pnlTablero.repaint();
    }

    private void Click(JButton btn) {
        boolean valor = true;
        try {
            if (btn.getIcon().equals(casilla) || btn.getIcon().equals(recolector)) {
                valor = false;
            }
        } catch (NullPointerException e) {
            if (valor) {
                btn.setIcon(casilla);
                total++;
                //jMovimientos.setText(Integer.toString(total));
            }
        }
    }

    public void anuncios(int num) {
        this.setEnabled(false);
        if (num == 2) {
            if (gano) {
                JOptionPane.showMessageDialog(this, "Ganaste");
            } else {
                JOptionPane.showMessageDialog(this, "Perdiste");
            }
            this.dispose();
        }
    }

    private void ObtenerTamanioObjetos(int cantX, int cantY) {
        TamX = TableroX / cantX;
        TamY = TableroY / cantY;
    }

    public void status() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                MatrizBotones[i][j].setVisible(false);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTablero = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        continuar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));
        setSize(new java.awt.Dimension(800, 800));

        pnlTablero.setBackground(new java.awt.Color(255, 153, 102));
        pnlTablero.setPreferredSize(new java.awt.Dimension(500, 500));
        pnlTablero.setSize(new java.awt.Dimension(800, 800));

        javax.swing.GroupLayout pnlTableroLayout = new javax.swing.GroupLayout(pnlTablero);
        pnlTablero.setLayout(pnlTableroLayout);
        pnlTableroLayout.setHorizontalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1335, Short.MAX_VALUE)
        );
        pnlTableroLayout.setVerticalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 843, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));

        continuar.setText("Continuar");
        continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(continuar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(continuar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlTablero, javax.swing.GroupLayout.PREFERRED_SIZE, 1335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTablero, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarActionPerformed
        algoritmoAbeja();
    }//GEN-LAST:event_continuarActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VentanaPrincipal.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VentanaPrincipal.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VentanaPrincipal.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VentanaPrincipal.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaPrincipal().setVisible(true);
//            }
//        });
//    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continuar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlTablero;
    // End of variables declaration//GEN-END:variables
}
