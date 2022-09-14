package telas;

import javax.swing.*;

import trabalhotp1g17.Funcionario;
import trabalhotp1g17.Loja;

public class TelaGerenciarFuncionarios extends javax.swing.JFrame {
    private final TelaPrincipal telaPrincipal;

    public TelaGerenciarFuncionarios(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        initComponents();
        carregarListaLojas();
        setLocationRelativeTo(null);
    }

    private void carregarListaLojas() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();

        for (String nome : TelaPrincipal.shopping.getLojas(false)) {
            modelo.addElement(nome);
        }
        boolean temElementos = modelo.getSize() > 0;

        selectLoja.setModel(modelo);

        selectLoja.setEnabled(temElementos);
        txtLoja.setEnabled(temElementos);
        carregarListaFuncionarios();
    }

    private void carregarListaFuncionarios() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();

        if (selectLoja.isEnabled()) {
            Loja loja = TelaPrincipal.shopping.getLoja((String) selectLoja.getSelectedItem());

            for (String nome : loja.getFuncionarios()) {
                modelo.addElement(nome);
            }
        }
        boolean temElementos = modelo.getSize() > 0;

        selectFuncionario.setModel(modelo);

        selectFuncionario.setEnabled(temElementos);
        txtFuncionario.setEnabled(temElementos);

        btnIniciarTrabalho.setEnabled(temElementos);
        btnFinalizarTrabalho.setEnabled(temElementos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JLabel();
        painelDados = new javax.swing.JPanel();
        txtLoja = new javax.swing.JLabel();
        selectLoja = new javax.swing.JComboBox<>();
        txtFuncionario = new javax.swing.JLabel();
        selectFuncionario = new javax.swing.JComboBox<>();
        btnIniciarTrabalho = new javax.swing.JButton();
        btnFinalizarTrabalho = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Funcionários");

        painelPrincipal.setBackground(new java.awt.Color(220, 220, 220));
        painelPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTitulo.setText("Gerenciar Funcionários");

        painelDados.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtLoja.setText("Loja:");
        txtLoja.setEnabled(false);

        selectLoja.setEnabled(false);
        selectLoja.setFocusable(false);
        selectLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectLojaActionPerformed(evt);
            }
        });

        txtFuncionario.setText("Funcionário:");
        txtFuncionario.setEnabled(false);

        selectFuncionario.setEnabled(false);
        selectFuncionario.setFocusable(false);

        btnIniciarTrabalho.setText("Iniciar Trabalho");
        btnIniciarTrabalho.setEnabled(false);
        btnIniciarTrabalho.setFocusable(false);
        btnIniciarTrabalho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarTrabalhoActionPerformed(evt);
            }
        });

        btnFinalizarTrabalho.setText("Finalizar Trabalho");
        btnFinalizarTrabalho.setEnabled(false);
        btnFinalizarTrabalho.setFocusable(false);
        btnFinalizarTrabalho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarTrabalhoActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.setFocusable(false);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
                painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelDadosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(painelDadosLayout.createSequentialGroup()
                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtFuncionario)
                                                        .addComponent(txtLoja))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(selectFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(selectLoja, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(painelDadosLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnIniciarTrabalho)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnFinalizarTrabalho)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSair)))
                                .addContainerGap())
        );
        painelDadosLayout.setVerticalGroup(
                painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelDadosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtLoja)
                                        .addComponent(selectLoja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtFuncionario)
                                        .addComponent(selectFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnIniciarTrabalho)
                                        .addComponent(btnFinalizarTrabalho)
                                        .addComponent(btnSair))
                                .addContainerGap())
        );

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
                painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelPrincipalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTitulo)
                                        .addComponent(painelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        painelPrincipalLayout.setVerticalGroup(
                painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelPrincipalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(painelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnIniciarTrabalhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarTrabalhoActionPerformed
        if (!selectLoja.isEnabled() || !selectFuncionario.isEnabled()) {
            return;
        }
        Loja loja = TelaPrincipal.shopping.getLoja((String) selectLoja.getSelectedItem());
        
        if (!loja.isAberto()) {
            JOptionPane.showMessageDialog(this, "A loja " + loja.getNome() + " está fechada.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
            return;
        }
        Funcionario funcionario = telaPrincipal.getFuncionario((String) selectFuncionario.getSelectedItem());
        boolean sucesso = funcionario.iniciarTrabalho();

        if (sucesso) {
            JOptionPane.showMessageDialog(this, "O funcionário " + funcionario.getNome() + " começou a trabalhar.", getTitle(), JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "O funcionário " + funcionario.getNome() + " já está trabalhando.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIniciarTrabalhoActionPerformed

    private void btnFinalizarTrabalhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarTrabalhoActionPerformed
        if (!selectLoja.isEnabled() || !selectFuncionario.isEnabled()) {
            return;
        }
        Funcionario funcionario = telaPrincipal.getFuncionario((String) selectFuncionario.getSelectedItem());
        boolean sucesso = funcionario.finalizarTrabalho();

        if (sucesso) {
            JOptionPane.showMessageDialog(this, "O funcionário " + funcionario.getNome() + " terminou trabalhar.", getTitle(), JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "O funcionário " + funcionario.getNome() + " não está trabalhando.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFinalizarTrabalhoActionPerformed

    private void selectLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectLojaActionPerformed
        carregarListaFuncionarios();
    }//GEN-LAST:event_selectLojaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGerenciarFuncionarios(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizarTrabalho;
    private javax.swing.JButton btnIniciarTrabalho;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel painelDados;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JComboBox<String> selectFuncionario;
    private javax.swing.JComboBox<String> selectLoja;
    private javax.swing.JLabel txtFuncionario;
    private javax.swing.JLabel txtLoja;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
