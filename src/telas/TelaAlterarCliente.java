package telas;

import trabalhotp1g17.*;

import javax.swing.*;

/*
Tela responsável por alterar as informações de clientes esporádicos e frequentes,
sendo elas os seus veículos, nomes (apenas clientes frequentes) e CPFs (apenas clientes frequentes).
Clientes não podem ser alterados enquanto dentro do shopping.
*/
public class TelaAlterarCliente extends javax.swing.JFrame {
    private final TelaPrincipal telaPrincipal;  // Referência da tela principal

    // Construtor

    public TelaAlterarCliente(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        initComponents();
        atualizarExibicao();
        setLocationRelativeTo(null);
    }

    // Atualiza a exibição das listas de clientes e de veículos
    private void atualizarExibicao() {
        carregarListaClientes();
        carregarListaVeiculos();
    }

    /*
    Atualiza a exibição da lista de clientes, adicionando como elementos
    os IDs dos clientes esporádicos, na forma 'Cliente ID', ou os nomes
    dos clientes frequentes, segundo o botão selecionado. Após definir
    o modelo da lista, habilita e desabilita os elementos da tela conforme
    a funcionalidade desejada.
    */
    private void carregarListaClientes() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();

        if (telaPrincipal == null) {
            selectCliente.setModel(modelo);
            return;
        }
        if (btnEsporadico.isSelected()) {
            for (int i = 0; i < telaPrincipal.getQtdClientesEsporadicos(); i++) {
                modelo.addElement("Cliente " + telaPrincipal.getClienteEsporadico(i).getId());
            }
        }
        if (btnFrequente.isSelected()) {
            for (String nome : telaPrincipal.getNomesClientesFrequentes()) {
                modelo.addElement(nome);
            }
        }
        selectCliente.setModel(modelo);

        if (modelo.getSize() > 0) {
            txtCliente.setEnabled(true);
            selectCliente.setEnabled(true);

            fldNome.setEnabled(btnFrequente.isSelected());
            fldCpf.setEnabled(btnFrequente.isSelected());
            txtNome.setEnabled(btnFrequente.isSelected());
            txtCpf.setEnabled(btnFrequente.isSelected());

            btnAlterarNome.setEnabled(btnFrequente.isSelected());
            btnAlterarCpf.setEnabled(btnFrequente.isSelected());
            btnAlterarVeiculo.setEnabled(true);

            txtVeiculo.setEnabled(true);
            selectVeiculo.setEnabled(true);

            btnSalvar.setEnabled(true);
        } else {
            txtCliente.setEnabled(false);
            selectCliente.setEnabled(false);

            fldNome.setEnabled(false);
            fldCpf.setEnabled(false);
            txtNome.setEnabled(false);
            txtCpf.setEnabled(false);

            btnAlterarNome.setEnabled(false);
            btnAlterarCpf.setEnabled(false);
            btnAlterarVeiculo.setEnabled(false);

            btnAlterarNome.setSelected(false);
            btnAlterarCpf.setSelected(false);
            btnAlterarVeiculo.setSelected(false);

            txtVeiculo.setEnabled(false);
            selectVeiculo.setEnabled(false);

            btnSalvar.setEnabled(false);
        }
    }

    /*
    Atualiza a exibição da lista de veículos, adicionando como elementos
    as informações do veículo, na forma 'PLACA (MARCA MODELO)'.
    */
    private void carregarListaVeiculos() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        
        modelo.addElement("Nenhum");

        if (!selectVeiculo.isEnabled()) {
            selectVeiculo.setModel(modelo);
            return;
        }
        if (telaPrincipal == null) {
            selectVeiculo.setModel(modelo);
            return;
        }
        for (String placa : telaPrincipal.getPlacasVeiculos()) {
            Veiculo veiculo = telaPrincipal.getVeiculo(placa);

            if (veiculo.getDono() == null) {
                modelo.addElement(placa + " (" + veiculo.getMarca() + " " + veiculo.getModelo() + ")");
            }
        }
        selectVeiculo.setModel(modelo);
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
        txtNome = new javax.swing.JLabel();
        fldNome = new javax.swing.JTextField();
        btnAlterarNome = new javax.swing.JCheckBox();
        btnAlterarCpf = new javax.swing.JCheckBox();
        btnAlterarVeiculo = new javax.swing.JCheckBox();
        txtCpf = new javax.swing.JLabel();
        fldCpf = new javax.swing.JTextField();
        txtVeiculo = new javax.swing.JLabel();
        selectVeiculo = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Cliente");

        painelPrincipal.setBackground(new java.awt.Color(220, 220, 220));
        painelPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTitulo.setText("Alterar Cliente");
        txtTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        painelDados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTipo.setText("Tipo:");

        btngTipo.add(btnEsporadico);
        btnEsporadico.setText("Esporádico");
        btnEsporadico.setFocusable(false);
        btnEsporadico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsporadicoActionPerformed(evt);
            }
        });

        btngTipo.add(btnFrequente);
        btnFrequente.setSelected(true);
        btnFrequente.setText("Frequente");
        btnFrequente.setFocusable(false);
        btnFrequente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFrequenteActionPerformed(evt);
            }
        });

        txtCliente.setText("Cliente:");
        txtCliente.setEnabled(false);

        selectCliente.setEnabled(false);
        selectCliente.setFocusable(false);

        txtNome.setText("Nome:");
        txtNome.setEnabled(false);

        fldNome.setEnabled(false);

        btnAlterarNome.setEnabled(false);
        btnAlterarNome.setFocusable(false);

        btnAlterarCpf.setEnabled(false);
        btnAlterarCpf.setFocusable(false);

        btnAlterarVeiculo.setEnabled(false);
        btnAlterarVeiculo.setFocusable(false);

        txtCpf.setText("CPF:");
        txtCpf.setEnabled(false);

        fldCpf.setEnabled(false);

        txtVeiculo.setText("Veículo:");
        txtVeiculo.setEnabled(false);

        selectVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Nenhum"}));
        selectVeiculo.setEnabled(false);
        selectVeiculo.setFocusable(false);

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
                                                        .addComponent(txtVeiculo)
                                                        .addComponent(txtTipo)
                                                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(txtCpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(txtCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(selectCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(painelDadosLayout.createSequentialGroup()
                                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(selectVeiculo, javax.swing.GroupLayout.Alignment.LEADING, 0, 338, Short.MAX_VALUE)
                                                                        .addComponent(fldCpf, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelDadosLayout.createSequentialGroup()
                                                                                .addComponent(btnFrequente)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(btnEsporadico))
                                                                        .addComponent(fldNome, javax.swing.GroupLayout.Alignment.LEADING))
                                                                .addGap(18, 18, Short.MAX_VALUE)
                                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(btnAlterarCpf, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(btnAlterarNome, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(btnAlterarVeiculo, javax.swing.GroupLayout.Alignment.TRAILING))))))
                                .addContainerGap())
        );
        painelDadosLayout.setVerticalGroup(
                painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelDadosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtTipo)
                                        .addComponent(btnEsporadico)
                                        .addComponent(btnFrequente))
                                .addGap(18, 18, 18)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtCliente)
                                        .addComponent(selectCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAlterarNome)
                                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtNome)
                                                .addComponent(fldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAlterarCpf)
                                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtCpf)
                                                .addComponent(fldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(painelDadosLayout.createSequentialGroup()
                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtVeiculo)
                                                        .addComponent(selectVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, Short.MAX_VALUE)
                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnSalvar)
                                                        .addComponent(btnCancelar)))
                                        .addGroup(painelDadosLayout.createSequentialGroup()
                                                .addComponent(btnAlterarVeiculo)
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
        String placa = (String) selectVeiculo.getSelectedItem();
        Pessoa cliente;
        Veiculo veiculo = null;

        if (!placa.equals("Nenhum")) {
            String[] placaMarcaModelo = selectVeiculo.getItemAt(selectVeiculo.getSelectedIndex()).split(" ");
            veiculo = telaPrincipal.getVeiculo(placaMarcaModelo[0]);
        }
        if (btnFrequente.isSelected()) {
            cliente = telaPrincipal.getClienteFrequente((String) selectCliente.getSelectedItem());
            String nome = fldNome.getText();
            String cpf = fldCpf.getText();

            if (cliente.isDentroDoShopping()) {
                JOptionPane.showMessageDialog(this, "O cliente deve estar fora do shopping para ser alterado.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
                dispose();
                return;
            }
            if (btnAlterarNome.isSelected()) {
                if (nome.isBlank()) {
                    JOptionPane.showMessageDialog(this, "Verifique se os campos foram preenchidos corretamente.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (telaPrincipal.getClienteFrequente(nome) != null || telaPrincipal.getFuncionario(nome) != null) {
                    JOptionPane.showMessageDialog(this, "Já existe uma pessoa registrada com esse nome.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
                    return;
                }
                telaPrincipal.removerPessoa(cliente);
                ((ClienteFrequente) cliente).setNome(nome);
                telaPrincipal.adicionarPessoa(cliente);
            }
            if (btnAlterarCpf.isSelected()) {
                if (cpf.isBlank()) {
                    JOptionPane.showMessageDialog(this, "Verifique se os campos foram preenchidos corretamente.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
                    return;
                }
                ((ClienteFrequente) cliente).setCpf(cpf);
            }
        } else {
            cliente = telaPrincipal.getClienteEsporadico(selectCliente.getSelectedIndex());

            if (cliente.isDentroDoShopping()) {
                JOptionPane.showMessageDialog(this, "O cliente deve estar fora do shopping para ser alterado.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
                dispose();
                return;
            }
        }
        if (btnAlterarVeiculo.isSelected()) {
            cliente.setVeiculo(veiculo);
            veiculo.setDono(cliente);
        }
        JOptionPane.showMessageDialog(this, "Cliente alterado com sucesso.", getTitle(), JOptionPane.INFORMATION_MESSAGE);
        telaPrincipal.updateExibicao();
        dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEsporadicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsporadicoActionPerformed
        atualizarExibicao();
    }//GEN-LAST:event_btnEsporadicoActionPerformed

    private void btnFrequenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFrequenteActionPerformed
        atualizarExibicao();
    }//GEN-LAST:event_btnFrequenteActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAlterarCliente(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox btnAlterarCpf;
    private javax.swing.JCheckBox btnAlterarNome;
    private javax.swing.JCheckBox btnAlterarVeiculo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JRadioButton btnEsporadico;
    private javax.swing.JRadioButton btnFrequente;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup btngTipo;
    private javax.swing.JTextField fldCpf;
    private javax.swing.JTextField fldNome;
    private javax.swing.JPanel painelDados;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JComboBox<String> selectCliente;
    private javax.swing.JComboBox<String> selectVeiculo;
    private javax.swing.JLabel txtCliente;
    private javax.swing.JLabel txtCpf;
    private javax.swing.JLabel txtNome;
    private javax.swing.JLabel txtTipo;
    private javax.swing.JLabel txtTitulo;
    private javax.swing.JLabel txtVeiculo;
    // End of variables declaration//GEN-END:variables
}
