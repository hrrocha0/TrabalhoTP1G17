package telas;

import trabalhotp1g17.*;

import javax.swing.*;

/*
Tela responsável por alterar as informações de veículos,
sendo elas os seus tipos, placas, marcas e modelos. Veículos não podem ser alterados
enquanto no shopping.
*/
public class TelaAlterarVeiculo extends javax.swing.JFrame {
    private final TelaPrincipal telaPrincipal;  // Referência da tela principal

    // Construtor

    public TelaAlterarVeiculo(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        initComponents();
        atualizarExibicao();
        setLocationRelativeTo(null);
    }

    // Atualiza a exibição da lista de veículos
    private void atualizarExibicao() {
        carregarListaVeiculos();
    }

    /*
    Atualiza a exibição da lista de veículos, adicionando como elementos
    as informações do veículo, na forma 'PLACA (MARCA MODELO)'. Após definir 
    o modelo da lista, habilita e desabilita os elementos da tela conforme
    a funcionalidade desejada.
    */
    private void carregarListaVeiculos() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();

        if (telaPrincipal == null) {
            selectVeiculo.setModel(modelo);
            return;
        }
        for (String placa : telaPrincipal.getPlacasVeiculos()) {
            Veiculo veiculo = telaPrincipal.getVeiculo(placa);

            modelo.addElement(placa + " (" + veiculo.getMarca() + " " + veiculo.getModelo() + ")");
        }
        selectVeiculo.setModel(modelo);

        if (modelo.getSize() > 0) {
            txtVeiculo.setEnabled(true);
            selectVeiculo.setEnabled(true);

            btnCarro.setEnabled(true);
            btnMoto.setEnabled(true);

            fldMarca.setEnabled(true);
            fldModelo.setEnabled(true);
            fldPlaca.setEnabled(true);
            txtTipo.setEnabled(true);
            txtMarca.setEnabled(true);
            txtModelo.setEnabled(true);
            txtPlaca.setEnabled(true);

            btnAlterarTipo.setEnabled(true);
            btnAlterarMarca.setEnabled(true);
            btnAlterarModelo.setEnabled(true);
            btnAlterarPlaca.setEnabled(true);

            btnSalvar.setEnabled(true);
        } else {
            txtVeiculo.setEnabled(false);
            selectVeiculo.setEnabled(false);

            btnCarro.setEnabled(false);
            btnMoto.setEnabled(false);

            fldMarca.setEnabled(false);
            fldModelo.setEnabled(false);
            fldPlaca.setEnabled(false);
            txtTipo.setEnabled(false);
            txtMarca.setEnabled(false);
            txtModelo.setEnabled(false);
            txtPlaca.setEnabled(false);

            btnAlterarTipo.setEnabled(false);
            btnAlterarMarca.setEnabled(false);
            btnAlterarModelo.setEnabled(false);
            btnAlterarPlaca.setEnabled(false);

            btnAlterarTipo.setSelected(false);
            btnAlterarMarca.setSelected(false);
            btnAlterarModelo.setSelected(false);
            btnAlterarPlaca.setSelected(false);

            btnSalvar.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngTipo = new javax.swing.ButtonGroup();
        painelPrincipal = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JLabel();
        painelDados = new javax.swing.JPanel();
        txtVeiculo = new javax.swing.JLabel();
        selectVeiculo = new javax.swing.JComboBox<>();
        txtTipo = new javax.swing.JLabel();
        btnCarro = new javax.swing.JRadioButton();
        btnMoto = new javax.swing.JRadioButton();
        txtMarca = new javax.swing.JLabel();
        fldMarca = new javax.swing.JTextField();
        btnAlterarTipo = new javax.swing.JCheckBox();
        btnAlterarMarca = new javax.swing.JCheckBox();
        btnAlterarModelo = new javax.swing.JCheckBox();
        btnAlterarPlaca = new javax.swing.JCheckBox();
        txtModelo = new javax.swing.JLabel();
        fldModelo = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JLabel();
        fldPlaca = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Veículo");

        painelPrincipal.setBackground(new java.awt.Color(220, 220, 220));
        painelPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTitulo.setText("Alterar Veículo");
        txtTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        painelDados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtVeiculo.setText("Veículo:");
        txtVeiculo.setEnabled(false);

        selectVeiculo.setFocusable(false);

        txtTipo.setText("Tipo:");
        txtTipo.setEnabled(false);

        btngTipo.add(btnCarro);
        btnCarro.setSelected(true);
        btnCarro.setText("Carro");
        btnCarro.setEnabled(false);
        btnCarro.setFocusable(false);
        btnCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarroActionPerformed(evt);
            }
        });

        btngTipo.add(btnMoto);
        btnMoto.setText("Moto");
        btnMoto.setEnabled(false);
        btnMoto.setFocusable(false);
        btnMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMotoActionPerformed(evt);
            }
        });

        txtMarca.setText("Marca:");
        txtMarca.setEnabled(false);

        fldMarca.setEnabled(false);

        btnAlterarTipo.setEnabled(false);
        btnAlterarTipo.setFocusable(false);

        btnAlterarMarca.setEnabled(false);
        btnAlterarMarca.setFocusable(false);

        btnAlterarModelo.setEnabled(false);
        btnAlterarModelo.setFocusable(false);

        btnAlterarPlaca.setEnabled(false);
        btnAlterarPlaca.setFocusable(false);

        txtModelo.setText("Modelo:");
        txtModelo.setEnabled(false);

        fldModelo.setEnabled(false);

        txtPlaca.setText("Placa:");
        txtPlaca.setEnabled(false);

        fldPlaca.setEnabled(false);

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.setFocusable(false);
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
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
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPlaca)
                            .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtModelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMarca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                .addComponent(txtTipo, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(txtVeiculo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(fldModelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                                        .addComponent(fldMarca, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fldPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
                                    .addGroup(painelDadosLayout.createSequentialGroup()
                                        .addComponent(btnCarro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMoto)))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAlterarModelo)
                                    .addComponent(btnAlterarPlaca)
                                    .addComponent(btnAlterarMarca)
                                    .addComponent(btnAlterarTipo)))
                            .addComponent(selectVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVeiculo)
                    .addComponent(selectVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterarTipo)
                    .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTipo)
                        .addComponent(btnCarro)
                        .addComponent(btnMoto)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterarMarca)
                    .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMarca)
                        .addComponent(fldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterarModelo)
                    .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtModelo)
                        .addComponent(fldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPlaca)
                            .addComponent(fldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar)
                            .addComponent(btnCancelar)))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(btnAlterarPlaca)
                        .addGap(0, 0, Short.MAX_VALUE)))
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

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (telaPrincipal == null) {
            dispose();
            return;
        }
        String[] placaMarcaModelo = ((String) selectVeiculo.getSelectedItem()).split(" ");
        Veiculo veiculo = telaPrincipal.getVeiculo(placaMarcaModelo[0]);
        String marca = fldMarca.getText();
        String modelo = fldModelo.getText();
        String placa = fldPlaca.getText();

        if (btnAlterarTipo.isSelected()) {
            if (btnCarro.isSelected()) {
                veiculo.setTipo(TipoVeiculo.CARRO);
            } else {
                veiculo.setTipo(TipoVeiculo.MOTO);
            }
        }
        if (btnAlterarMarca.isSelected()) {
            if (marca.isBlank()) {
                JOptionPane.showMessageDialog(this, "Verifique se os campos foram preenchidos corretamente.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
                return;
            }
            veiculo.setMarca(marca);
        }
        if (btnAlterarModelo.isSelected()) {
            if (modelo.isBlank()) {
                JOptionPane.showMessageDialog(this, "Verifique se os campos foram preenchidos corretamente.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
                return;
            }
            veiculo.setModelo(modelo);
        }
        if (btnAlterarPlaca.isSelected()) {
            if (placa.isBlank()) {
                JOptionPane.showMessageDialog(this, "Verifique se os campos foram preenchidos corretamente.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (telaPrincipal.getVeiculo(placa) != null) {
                JOptionPane.showMessageDialog(this, "Já existe um veículo registrado com essa placa.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
                return;
            }
            placa = placa.replace(' ', '-');
            telaPrincipal.removerVeiculo(veiculo);
            veiculo.setPlaca(placa);
            telaPrincipal.adicionarVeiculo(veiculo);
        }
        JOptionPane.showMessageDialog(this, "Veículo alterado com sucesso.", getTitle(), JOptionPane.INFORMATION_MESSAGE);
        telaPrincipal.updateExibicao();
        dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotoActionPerformed
        atualizarExibicao();
    }//GEN-LAST:event_btnMotoActionPerformed

    private void btnCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarroActionPerformed
        atualizarExibicao();
    }//GEN-LAST:event_btnCarroActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAlterarVeiculo(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox btnAlterarMarca;
    private javax.swing.JCheckBox btnAlterarModelo;
    private javax.swing.JCheckBox btnAlterarPlaca;
    private javax.swing.JCheckBox btnAlterarTipo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JRadioButton btnCarro;
    private javax.swing.JRadioButton btnMoto;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup btngTipo;
    private javax.swing.JTextField fldMarca;
    private javax.swing.JTextField fldModelo;
    private javax.swing.JTextField fldPlaca;
    private javax.swing.JPanel painelDados;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JComboBox<String> selectVeiculo;
    private javax.swing.JLabel txtMarca;
    private javax.swing.JLabel txtModelo;
    private javax.swing.JLabel txtPlaca;
    private javax.swing.JLabel txtTipo;
    private javax.swing.JLabel txtTitulo;
    private javax.swing.JLabel txtVeiculo;
    // End of variables declaration//GEN-END:variables
}
