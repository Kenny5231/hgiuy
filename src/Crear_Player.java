import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Crear_Player extends javax.swing.JFrame {
    
    static ArrayList<Usuarios> ListadeUsuarios;
    int contnombre = 0, contcontraseña = 0;
    boolean mododejuego_Tutorial=true;
    public Crear_Player(ArrayList<Usuarios> AtributListadeUsuarios) {
        if (AtributListadeUsuarios == null) {
            ListadeUsuarios = new ArrayList<Usuarios>();
        } else {
            ListadeUsuarios = AtributListadeUsuarios;
        }
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombre = new javax.swing.JTextField();
        contrase = new javax.swing.JTextField();
        Crear = new javax.swing.JToggleButton();
        contraseña = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Cancelar = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 120, 30));

        contrase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseActionPerformed(evt);
            }
        });
        getContentPane().add(contrase, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 120, 30));

        Crear.setText("Crear usuario");
        Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearActionPerformed(evt);
            }
        });
        getContentPane().add(Crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, -1));

        contraseña.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        contraseña.setForeground(new java.awt.Color(0, 0, 0));
        contraseña.setText("Contraseña");
        getContentPane().add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, -1, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, -1));

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        getContentPane().add(Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseActionPerformed

    private void CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearActionPerformed
        boolean usuarioexistente = false;
        if(nombre.getText().equals("") && contrase.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe llenar todos los espacios");
            System.out.println("Size: "+ListadeUsuarios.size());
        }else{
            for (int i = 0; i < ListadeUsuarios.size(); i++) {

            if (ListadeUsuarios.get(i).Nombre.equals(nombre.getText())) {
                System.out.println(ListadeUsuarios.get(i).getnombre());
                JOptionPane.showMessageDialog(null, "Usuario Existente");
                System.out.println("Size: "+ListadeUsuarios.size());
                usuarioexistente = true;
                
            }

        }
        if (!usuarioexistente) {
            System.out.println("Size: "+ListadeUsuarios.size());
            System.out.println(nombre.getText());
            System.out.println(contrase.getText());
            System.out.println("Size: "+ListadeUsuarios.size());
            
                Usuarios NuevoUsuario = new Usuarios(nombre.getText(), contrase.getText());
                
                System.out.println("Size: "+ListadeUsuarios.size());
                System.out.println(NuevoUsuario);
                
                ListadeUsuarios.add(NuevoUsuario);
                System.out.println("Size: "+ListadeUsuarios.size());
                System.out.println(ListadeUsuarios);
                System.out.println("Size: "+ListadeUsuarios.size());
                

                JOptionPane.showMessageDialog(null, "Usuario Registrado");
                System.out.println("Size: "+ListadeUsuarios.size());
                this.setVisible(false);
                System.out.println("Size: "+ListadeUsuarios.size());
                System.out.println(nombre.getText());
                System.out.println(contrase.getText());
                System.out.println("Size: "+ListadeUsuarios.size());
                Main menu = new Main(ListadeUsuarios);
                menu.setVisible(true);
                System.out.println("Size: "+ListadeUsuarios.size());    
        }
        }
    }//GEN-LAST:event_CrearActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        // TODO add your handling code here:
        Main cancelar = new Main(ListadeUsuarios);
        cancelar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Cancelar;
    private javax.swing.JToggleButton Crear;
    private javax.swing.JTextField contrase;
    private javax.swing.JLabel contraseña;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
}