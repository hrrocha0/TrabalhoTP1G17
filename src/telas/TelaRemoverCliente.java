package telas;

import javax.swing.*;

import trabalhotp1g17.Pessoa;
import trabalhotp1g17.Shopping;

// Tela responsável por remover um cliente do sistema
public class TelaRemoverCliente extends javax.swing.JFrame {
    private final TelaPrincipal telaPrincipal;  // Referência da tela principal

    // Construtor

    public TelaRemoverCliente(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        initComponents();
        carregarListaClientes();
        setLocationRelativeTo(null);
    }

    /*
    Atualiza a exibição da lista de clientes, adicionando como elementos
    os IDs dos clientes esporádicos, na forma 'Cliente ID', ou os nomes
    dos clientes frequentes, segundo o botão selecionado. Após definir
    o modelo da lista, habilita e desabilita os elementos da tela conforme
    a funcionalidade desejada.
    */
    private void carregarListaClientes() {
        if (telaPrincipal == null) {
            return;
        }
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();

        if (btnEsporadico.isSelected()) {
            for (int i = 0; i < telaPrincipal.getQtdClientesEsporadicos(); i++) {
                modelo.addElement("Cliente " + telaPrincipal.getClienteEsporadico(i).getId());
            }
        } else {
            for (String nome : telaPrincipal.getNomesClientesFrequentes()) {
                modelo.addElement(nome);
            }
        }
        selectCliente.setModel(modelo);
        boolean temElementos = modelo.getSize() > 0;

        txtCliente.setEnabled(temElementos);
        selectCliente.setEnabled(temElementos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngTipo = new javax.swing.ButtonGroup();
        painelPrincipal = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JLabel();
        painelDados = new javax.swing.JPanel();
        txtTipo = new javax.swing.JLabel();
        btnEsporadico = new javax.swing.JRadioButton();
        btnFrequente = new javax.swing.JRadioButton();
        txtCliente = new javax.swing.JLabel();
        selectCliente = new javax.swing.JComboBox<>();
        txtAviso = new javax.swing.JLabel();
        btnRemover = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Remover Cliente");

        painelPrincipal.setBackground(new java.awt.Color(220, 220, 220));
        painelPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTitulo.setText("Remover Cliente");
        txtTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        painelDados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTipo.setText("Tipo:");

        btngTipo.add(btnEsporadico);
        btnEsporadico.setText("Esporádico");
        btnEsporadico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsporadicoActionPerformed(evt);
            }
        });

        btngTipo.add(btnFrequente);
        btnFrequente.setSelected(true);
        btnFrequente.setText("Frequente");
        btnFrequente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFrequenteActionPerformed(evt);
            }
        });

        txtCliente.setText("Cliente:");
        txtCliente.setEnabled(false);

        selectCliente.setEnabled(false);
        selectCliente.setFocusable(false);

        txtAviso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAviso.setText("Atenção: Esta ação não pode ser desfeita.");
        txtAviso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnRemover.setText("Remover");
        btnRemover.setFocusable(false);
        btnRemover.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setFocusable(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(btnFrequente)
                                .addGap(18, 18, 18)
                                .addComponent(btnEsporadico)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFrequente)
                    .addComponent(btnEsporadico)
                    .addComponent(txtTipo))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliente)
                    .addComponent(selectCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(txtAviso)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemover)
                    .addComponent(btnCancelar))
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

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if (telaPrincipal == null) {
            dispose();
            return;
        }
        if (!selectCliente.isEnabled()) {
            if (btnEsporadico.isSelected()) {
                JOptionPane.showMessageDialog(this, "Não há clientes esporádicos cadastrados.", "Erro: Remover Cliente", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Não há clientes frequentes cadastrados.", "Erro: Remover Cliente", JOptionPane.ERROR_MESSAGE);
            }
            dispose();
            return;
        }
        Pessoa pessoa;
        Shopping shopping = telaPrincipal.getShopping();

        if (btnEsporadico.isSelected()) {
            pessoa = telaPrincipal.getClienteEsporadico(selectCliente.getSelectedIndex());
        } else {
            pessoa = telaPrincipal.getClienteFrequente((String) selectCliente.getSelectedItem());
        }
        telaPrincipal.removerPessoa(pessoa);
        telaPrincipal.getShopping().aoSair(pessoa);
        telaPrincipal.getShopping().remove(pessoa);
        JOptionPane.showMessageDialog(this, "O cliente " + selectCliente.getSelectedItem() + " foi removido com sucesso.", "Remover Cliente", JOptionPane.PLAIN_MESSAGE);
        telaPrincipal.updateExibicao();
        dispose();
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEsporadicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsporadicoActionPerformed
        carregarListaClientes();
    }//GEN-LAST:event_btnEsporadicoActionPerformed

    private void btnFrequenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFrequenteActionPerformed
        carregarListaClientes();
    }//GEN-LAST:event_btnFrequenteActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRemoverCliente(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JRadioButton btnEsporadico;
    private javax.swing.JRadioButton btnFrequente;
    private javax.swing.JButton btnRemover;
    private javax.swing.ButtonGroup btngTipo;
    private javax.swing.JPanel painelDados;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JComboBox<String> selectCliente;
    private javax.swing.JLabel txtAviso;
    private javax.swing.JLabel txtCliente;
    private javax.swing.JLabel txtTipo;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
