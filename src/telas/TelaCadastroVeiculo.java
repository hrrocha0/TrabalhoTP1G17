package telas;

import trabalhotp1g17.TipoVeiculo;
import trabalhotp1g17.Veiculo;

import javax.swing.*;

// Tela responsável por cadastrar veículos no sistema.
public class TelaCadastroVeiculo extends javax.swing.JFrame {
    private final TelaPrincipal telaPrincipal;  // Referência da tela principal

    // Construtor

    public TelaCadastroVeiculo(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngTipo = new javax.swing.ButtonGroup();
        painelPrincipal = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JLabel();
        painelDados = new javax.swing.JPanel();
        txtTipo = new javax.swing.JLabel();
        btnCarro = new javax.swing.JRadioButton();
        btnMoto = new javax.swing.JRadioButton();
        txtMarca = new javax.swing.JLabel();
        fldMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JLabel();
        fldModelo = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JLabel();
        fldPlaca = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Veículo");

        painelPrincipal.setBackground(new java.awt.Color(220, 220, 220));
        painelPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTitulo.setText("Cadastrar Veículo");
        txtTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        painelDados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTipo.setText("Tipo:");

        btngTipo.add(btnCarro);
        btnCarro.setSelected(true);
        btnCarro.setText("Carro");
        btnCarro.setFocusable(false);

        btngTipo.add(btnMoto);
        btnMoto.setText("Moto");
        btnMoto.setFocusable(false);

        txtMarca.setText("Marca:");

        txtModelo.setText("Modelo:");

        txtPlaca.setText("Placa:");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setFocusable(false);
        btnCadastrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
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
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtModelo)
                                                        .addComponent(txtPlaca)
                                                        .addComponent(txtMarca)
                                                        .addComponent(txtTipo))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(painelDadosLayout.createSequentialGroup()
                                                                .addComponent(btnCarro)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnMoto)
                                                                .addGap(0, 238, Short.MAX_VALUE))
                                                        .addComponent(fldMarca)
                                                        .addComponent(fldModelo)
                                                        .addComponent(fldPlaca)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnCadastrar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCancelar)))
                                .addContainerGap())
        );
        painelDadosLayout.setVerticalGroup(
                painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelDadosLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtTipo)
                                        .addComponent(btnCarro)
                                        .addComponent(btnMoto))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtMarca)
                                        .addComponent(fldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtModelo)
                                        .addComponent(fldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtPlaca)
                                        .addComponent(fldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCadastrar)
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (telaPrincipal == null) {
            dispose();
            return;
        }
        TipoVeiculo tipo = btnCarro.isSelected() ? TipoVeiculo.CARRO : TipoVeiculo.MOTO;
        String marca = fldMarca.getText();
        String modelo = fldModelo.getText();
        String placa = fldPlaca.getText();

        if (marca.isBlank() || modelo.isBlank() || placa.isBlank()) {
            JOptionPane.showMessageDialog(this, "Verifique se os campos foram preenchidos corretamente.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (telaPrincipal.getVeiculo(placa) != null) {
            JOptionPane.showMessageDialog(this, "Já existe um veículo registrado com essa placa.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
            return;
        }
        placa = placa.replace(' ', '-');
        Veiculo veiculo = new Veiculo(tipo, marca, modelo, placa);

        telaPrincipal.adicionarVeiculo(veiculo);
        JOptionPane.showMessageDialog(this, "O veículo de placa " + placa + " foi cadastrado com sucesso.", getTitle(), JOptionPane.INFORMATION_MESSAGE);
        telaPrincipal.updateExibicao();
        dispose();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroVeiculo(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JRadioButton btnCarro;
    private javax.swing.JRadioButton btnMoto;
    private javax.swing.ButtonGroup btngTipo;
    private javax.swing.JTextField fldMarca;
    private javax.swing.JTextField fldModelo;
    private javax.swing.JTextField fldPlaca;
    private javax.swing.JPanel painelDados;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JLabel txtMarca;
    private javax.swing.JLabel txtModelo;
    private javax.swing.JLabel txtPlaca;
    private javax.swing.JLabel txtTipo;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
