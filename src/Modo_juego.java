import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Modo_juego extends javax.swing.JFrame {
         String Usuario;
         String contra;
         private Inicio_sesion loginWindow;
    static ArrayList<Usuarios> ListadeUsuarios;
    public Modo_juego() {
       this.loginWindow = loginWindow;
        initComponents();
        setLocationRelativeTo(null);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        guardar = new javax.swing.JToggleButton();
        modo_combo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Modo de Juego");

        guardar.setText("Guardar Cambios");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        modo_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tutorial", "Arcade", " ", " " }));
        modo_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modo_comboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(guardar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modo_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 479, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(modo_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(guardar)
                .addContainerGap(298, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        
        String modojuego = String.valueOf(modo_combo.getSelectedItem());
        Almacen_datos.setModo(modojuego);
        configuracion tp=new configuracion(ListadeUsuarios,Usuario,contra,loginWindow);
        tp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_guardarActionPerformed

    private void modo_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modo_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modo_comboActionPerformed


    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modo_juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> modo_combo;
    // End of variables declaration//GEN-END:variables
}
