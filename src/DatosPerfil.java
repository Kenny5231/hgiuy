import java.util.ArrayList;

public class DatosPerfil extends javax.swing.JFrame {
  
    private String Usuario; 
    private String contra;
    private Inicio_sesion loginWindow;
    private static ArrayList<Usuarios> ListadeUsuarios;
    
    public DatosPerfil(ArrayList<Usuarios> AtributListadeUsuarios, String nombreUsuario, String contraUsuario) {
    this.Usuario = nombreUsuario;
    this.contra = contraUsuario;
    this.ListadeUsuarios = AtributListadeUsuarios;
    loginWindow = new Inicio_sesion(AtributListadeUsuarios); 

    for (int i = 0; i < ListadeUsuarios.size(); i++) {
        System.out.println("Entro a for");
        if (this.ListadeUsuarios.get(i).Nombre.equals(nombreUsuario)) {
            System.out.println(this.Usuario);
            this.Usuario = nombreUsuario;
            System.out.println(nombreUsuario);
        }
        if (this.ListadeUsuarios.get(i).getnombre().equals(this.contra)) {
            this.contra = contraUsuario;
        }
    }
    
    initComponents(); 
    mostrarVentana(); 
    jLabel1.setText("Nombre: " + nombreUsuario); 
    jLabel2.setText("Contraseña: " + this.contra); 
}
     

    public void mostrarVentana() {
    this.setVisible(true);   
}  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Regresar a mi perfil");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(626, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(481, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Perfil profile = new Perfil(ListadeUsuarios, Usuario, contra,loginWindow);
        profile.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatosPerfil(null,null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
