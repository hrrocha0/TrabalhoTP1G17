/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import trabalhotp1g17.TipoVeiculo;
import trabalhotp1g17.Veiculo;

import javax.swing.*;

/**
 * @author Admin
 */
public class TelaCadastroVeiculo extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroCliente
     */
    private final TelaPrincipal telaPrincipal;
    
    public TelaCadastroVeiculo(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
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

        botoesTipo = new javax.swing.ButtonGroup();
        painelPrincipal = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        painelDados = new javax.swing.JPanel();
        labelTipo = new javax.swing.JLabel();
        botaoTipoCarro = new javax.swing.JRadioButton();
        botaoTipoMoto = new javax.swing.JRadioButton();
        labelMarca = new javax.swing.JLabel();
        campoMarca = new javax.swing.JTextField();
        labelModelo = new javax.swing.JLabel();
        campoModelo = new javax.swing.JTextField();
        labelPlaca = new javax.swing.JLabel();
        campoPlaca = new javax.swing.JTextField();
        botaoCadastrar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Veículo");

        painelPrincipal.setBackground(new java.awt.Color(220, 220, 220));
        painelPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        titulo.setText("Cadastrar Veículo");
        titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        painelDados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelTipo.setText("Tipo:");

        botoesTipo.add(botaoTipoCarro);
        botaoTipoCarro.setSelected(true);
        botaoTipoCarro.setText("Carro");
        botaoTipoCarro.setFocusable(false);

        botoesTipo.add(botaoTipoMoto);
        botaoTipoMoto.setText("Moto");
        botaoTipoMoto.setFocusable(false);

        labelMarca.setText("Marca:");

        labelModelo.setText("Modelo:");

        labelPlaca.setText("Placa:");

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.setFocusable(false);
        botaoCadastrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
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
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelModelo)
                                                        .addComponent(labelPlaca)
                                                        .addComponent(labelMarca)
                                                        .addComponent(labelTipo))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(painelDadosLayout.createSequentialGroup()
                                                                .addComponent(botaoTipoCarro)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(botaoTipoMoto)
                                                                .addGap(0, 238, Short.MAX_VALUE))
                                                        .addComponent(campoMarca)
                                                        .addComponent(campoModelo)
                                                        .addComponent(campoPlaca)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(botaoCadastrar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(botaoCancelar)))
                                .addContainerGap())
        );
        painelDadosLayout.setVerticalGroup(
                painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelDadosLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelTipo)
                                        .addComponent(botaoTipoCarro)
                                        .addComponent(botaoTipoMoto))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelMarca)
                                        .addComponent(campoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelModelo)
                                        .addComponent(campoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelPlaca)
                                        .addComponent(campoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botaoCadastrar)
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

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        if (telaPrincipal == null) {
            dispose();
            return;
        }
        
        TipoVeiculo tipo = botaoTipoCarro.isSelected() ? TipoVeiculo.CARRO : TipoVeiculo.MOTO;

        String marca = campoMarca.getText();
        String modelo = campoModelo.getText();
        String placa = campoPlaca.getText();
        
        if (marca.isBlank() || modelo.isBlank() || placa.isBlank()) {
            JOptionPane.showMessageDialog(this, "Verifique se os campos foram preenchidos corretamente.", "Erro: Cadastrar Veículo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (telaPrincipal.getVeiculo(placa) != null) {
            JOptionPane.showMessageDialog(this, "Já existe um veículo registrado com essa placa.", "Erro: Cadastrar Veículo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        placa = placa.replace(' ','-');
        Veiculo veiculo = new Veiculo(tipo, marca, modelo, placa);
        telaPrincipal.adicionarVeiculo(veiculo);
        JOptionPane.showMessageDialog(this, "O veículo de placa " + placa + " foi cadastrado com sucesso.", "Cadastrar Veículo", JOptionPane.PLAIN_MESSAGE);
        telaPrincipal.updateExibicao();
        dispose();
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroVeiculo(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JRadioButton botaoTipoCarro;
    private javax.swing.JRadioButton botaoTipoMoto;
    private javax.swing.ButtonGroup botoesTipo;
    private javax.swing.JTextField campoMarca;
    private javax.swing.JTextField campoModelo;
    private javax.swing.JTextField campoPlaca;
    private javax.swing.JLabel labelMarca;
    private javax.swing.JLabel labelModelo;
    private javax.swing.JLabel labelPlaca;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JPanel painelDados;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
