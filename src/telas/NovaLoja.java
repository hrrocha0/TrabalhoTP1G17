
package telas;
import javax.swing.JOptionPane;
import trabalhotp1g17.*;

public class NovaLoja extends javax.swing.JFrame {

    public NovaLoja() {
        initComponents();
        radioLoja.setSelected(true);
        setLocationRelativeTo(null);            //faz a tela nascer centralizada
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textNomeLoja = new javax.swing.JTextField();
        btnCadastrarLoja = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        radioLoja = new javax.swing.JRadioButton();
        radioRestaurante = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar nova loja");

        textNomeLoja.setToolTipText("inserir...");

        btnCadastrarLoja.setText("Cadastrar");
        btnCadastrarLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarLojaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome da loja:");

        jLabel2.setText("Tipo de loja:");

        radioLoja.setText("comum");
        radioLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioLojaActionPerformed(evt);
            }
        });

        radioRestaurante.setText("restaurante");
        radioRestaurante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioRestauranteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(textNomeLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioLoja)
                                .addGap(18, 18, 18)
                                .addComponent(radioRestaurante))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(btnCadastrarLoja)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNomeLoja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(radioLoja)
                    .addComponent(radioRestaurante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btnCadastrarLoja)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioLojaActionPerformed
        radioLoja.setSelected(true);
        radioRestaurante.setSelected(false);
    }//GEN-LAST:event_radioLojaActionPerformed

    
    
    private void btnCadastrarLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarLojaActionPerformed
        String nomeLoja = textNomeLoja.getText();
        TipoLoja tipo = (radioLoja.isSelected())? TipoLoja.PRODUTOS : TipoLoja.RESTAURANTE;
        TelaPrincipal.shopping.add(new Loja(nomeLoja, tipo));
        
        dispose();
        JOptionPane.showMessageDialog(null, "Loja \'" + nomeLoja + "\' cadastrada ao shopping!", "sucesso!", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_btnCadastrarLojaActionPerformed

    private void radioRestauranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioRestauranteActionPerformed
        radioRestaurante.setSelected(true);
        radioLoja.setSelected(false);
    }//GEN-LAST:event_radioRestauranteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NovaLoja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovaLoja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovaLoja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovaLoja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovaLoja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarLoja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton radioLoja;
    private javax.swing.JRadioButton radioRestaurante;
    private javax.swing.JTextField textNomeLoja;
    // End of variables declaration//GEN-END:variables
}
