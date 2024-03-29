package telas;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import trabalhotp1g17.Pessoa;
import trabalhotp1g17.Veiculo;

// Tela responsável por remover um veículo do sistema
public class TelaRemoverVeiculo extends javax.swing.JFrame {
    private final TelaPrincipal telaPrincipal;  // Referência da tela principal

    // Construtor

    public TelaRemoverVeiculo(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        initComponents();
        carregarListaVeiculos();
        setLocationRelativeTo(null);
    }

    /*
    Atualiza a exibição da lista de veículos, adicionando como elementos
    as informações do veículo, na forma 'PLACA (MARCA MODELO)'. Após definir 
    o modelo da lista, habilita e desabilita os elementos da tela conforme
    a funcionalidade desejada.
    */
    private void carregarListaVeiculos() {
        if (telaPrincipal == null) {
            return;
        }
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();

        for (String placa : telaPrincipal.getPlacasVeiculos()) {
            Veiculo veiculo = telaPrincipal.getVeiculo(placa);
            modelo.addElement(placa + " (" + veiculo.getMarca() + " " + veiculo.getModelo() + ")");
        }
        caixaVeiculo.setModel(modelo);

        if (modelo.getSize() > 0) {
            labelVeiculo.setEnabled(true);
            caixaVeiculo.setEnabled(true);
        } else {
            labelVeiculo.setEnabled(false);
            caixaVeiculo.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        painelDados = new javax.swing.JPanel();
        labelVeiculo = new javax.swing.JLabel();
        caixaVeiculo = new javax.swing.JComboBox<>();
        labelAviso = new javax.swing.JLabel();
        botaoRemover = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Remover Veículo");

        painelPrincipal.setBackground(new java.awt.Color(220, 220, 220));
        painelPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        titulo.setText("Remover Veículo");
        titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        painelDados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelVeiculo.setText("Veículo:");
        labelVeiculo.setEnabled(false);

        caixaVeiculo.setEnabled(false);
        caixaVeiculo.setFocusable(false);

        labelAviso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAviso.setText("Atenção: Esta ação não pode ser desfeita.");
        labelAviso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        botaoRemover.setText("Remover");
        botaoRemover.setFocusable(false);
        botaoRemover.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.setFocusable(false);
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(labelVeiculo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(caixaVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCancelar)))
                .addContainerGap())
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVeiculo)
                    .addComponent(caixaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(labelAviso)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoRemover)
                    .addComponent(botaoCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo)
                    .addComponent(painelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
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

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        if (telaPrincipal == null) {
            dispose();
            return;
        }
        if (!caixaVeiculo.isEnabled()) {
            JOptionPane.showMessageDialog(this, "Não há veículos no shopping.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
            dispose();
            return;
        }
        String[] placaMarcaModelo = ((String) caixaVeiculo.getSelectedItem()).split(" ");
        Veiculo veiculo = telaPrincipal.getVeiculo(placaMarcaModelo[0]);
        Pessoa dono = veiculo.getDono();

        if (dono != null) {
            int resultado = JOptionPane.showConfirmDialog(this, "O veículo de placa " + veiculo.getPlaca() + " possui um dono. Deseja continuar mesmo assim?", getTitle(), JOptionPane.YES_NO_OPTION);

            if (resultado == 1) {
                dispose();
                return;
            }
            dono.setVeiculo(null);
        }
        telaPrincipal.removerVeiculo(veiculo);
        JOptionPane.showMessageDialog(this, "O veículo de placa " + veiculo.getPlaca() + " foi removido com sucesso.", getTitle(), JOptionPane.PLAIN_MESSAGE);
        telaPrincipal.updateExibicao();
        dispose();
    }//GEN-LAST:event_botaoRemoverActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRemoverVeiculo(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JComboBox<String> caixaVeiculo;
    private javax.swing.JLabel labelAviso;
    private javax.swing.JLabel labelVeiculo;
    private javax.swing.JPanel painelDados;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
