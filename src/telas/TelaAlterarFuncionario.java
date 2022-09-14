package telas;

import trabalhotp1g17.*;

import javax.swing.*;

/*
Tela responsável por alterar as informações de funcionários sendo elas os seus
veículos, nomes, CPFs e lojas. Funcionários não podem ser alterados enquanto 
no shopping.
*/
public class TelaAlterarFuncionario extends javax.swing.JFrame {
    private final TelaPrincipal telaPrincipal; // Referência da tela principal

    // Construtor

    public TelaAlterarFuncionario(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        initComponents();
        atualizarExibicao();
        setLocationRelativeTo(null);
    }

    // Atualiza a exibição das listas de funcionários, veículos e lojas
    private void atualizarExibicao() {
        carregarListaFuncionarios();
        carregarListaVeiculos();
        carregarListaLojas();
    }

    /*
    Atualiza a exibição da lista de clientes, adicionando como elementos
    os nomes dos funcionários. Após definir o modelo da lista, habilita e 
    desabilita os elementos da tela conforme a funcionalidade desejada.
    */
    private void carregarListaFuncionarios() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        for (String nome : telaPrincipal.getNomesFuncionarios()) {
            modelo.addElement(nome);
        }
        selectFuncionario.setModel(modelo);

        if (modelo.getSize() > 0) {
            txtFuncionario.setEnabled(true);
            selectFuncionario.setEnabled(true);

            fldNome.setEnabled(true);
            fldCpf.setEnabled(true);
            txtNome.setEnabled(true);
            txtCpf.setEnabled(true);

            btnAlterarNome.setEnabled(true);
            btnAlterarCpf.setEnabled(true);
            btnAlterarVeiculo.setEnabled(true);
            btnAlterarLoja.setEnabled(true);

            txtVeiculo.setEnabled(true);
            selectVeiculo.setEnabled(true);
            txtLoja.setEnabled(true);
            selectLoja.setEnabled(true);

            btnSalvar.setEnabled(true);
        } else {
            txtFuncionario.setEnabled(false);
            selectFuncionario.setEnabled(false);

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
            btnAlterarLoja.setSelected(false);

            txtVeiculo.setEnabled(false);
            selectVeiculo.setEnabled(false);
            txtLoja.setEnabled(false);
            selectLoja.setEnabled(false);

            btnSalvar.setEnabled(false);
        }
    }

    /*
    Atualiza a exibição da lista de veículos, adicionando como elementos
    as informações do veículo, na forma 'PLACA (MARCA MODELO)'.
    */
    private void carregarListaVeiculos() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();

        if (!selectVeiculo.isEnabled()) {
            selectVeiculo.setModel(modelo);
            return;
        }
        modelo.addElement("Nenhum");

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

    // Atualiza a exibição da lista de lojas, adicionando como elementos os nomes das lojas.
    private void carregarListaLojas() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();

        if (!selectLoja.isEnabled()) {
            selectLoja.setModel(modelo);
            return;
        }
        modelo.addElement("Nenhuma");

        if (telaPrincipal == null) {
            selectLoja.setModel(modelo);
            return;
        }
        for (String nome : TelaPrincipal.shopping.getLojas(false)) {
            modelo.addElement(nome);
        }
        selectLoja.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JLabel();
        painelDados = new javax.swing.JPanel();
        txtFuncionario = new javax.swing.JLabel();
        selectFuncionario = new javax.swing.JComboBox<>();
        txtNome = new javax.swing.JLabel();
        fldNome = new javax.swing.JTextField();
        btnAlterarNome = new javax.swing.JCheckBox();
        btnAlterarCpf = new javax.swing.JCheckBox();
        btnAlterarVeiculo = new javax.swing.JCheckBox();
        btnAlterarLoja = new javax.swing.JCheckBox();
        txtCpf = new javax.swing.JLabel();
        fldCpf = new javax.swing.JTextField();
        txtVeiculo = new javax.swing.JLabel();
        selectVeiculo = new javax.swing.JComboBox<>();
        txtLoja = new javax.swing.JLabel();
        selectLoja = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Funcionário");

        painelPrincipal.setBackground(new java.awt.Color(220, 220, 220));
        painelPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTitulo.setText("Alterar Funcionário");
        txtTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        painelDados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtFuncionario.setText("Funcionário:");
        txtFuncionario.setEnabled(false);

        selectFuncionario.setEnabled(false);
        selectFuncionario.setFocusable(false);

        txtNome.setText("Nome:");
        txtNome.setEnabled(false);

        fldNome.setEnabled(false);

        btnAlterarNome.setEnabled(false);
        btnAlterarNome.setFocusable(false);

        btnAlterarCpf.setEnabled(false);
        btnAlterarCpf.setFocusable(false);

        btnAlterarVeiculo.setEnabled(false);
        btnAlterarVeiculo.setFocusable(false);

        btnAlterarLoja.setEnabled(false);
        btnAlterarLoja.setFocusable(false);

        txtCpf.setText("CPF:");
        txtCpf.setEnabled(false);

        fldCpf.setEnabled(false);

        txtVeiculo.setText("Veículo:");
        txtVeiculo.setEnabled(false);

        selectVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Nenhum"}));
        selectVeiculo.setEnabled(false);
        selectVeiculo.setFocusable(false);

        txtLoja.setText("Loja:");
        txtLoja.setEnabled(false);

        selectLoja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Nenhuma"}));
        selectLoja.setEnabled(false);
        selectLoja.setFocusable(false);

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
                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtVeiculo)
                                                        .addComponent(txtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtLoja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(selectFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(painelDadosLayout.createSequentialGroup()
                                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(selectLoja, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(selectVeiculo, javax.swing.GroupLayout.Alignment.LEADING, 0, 338, Short.MAX_VALUE)
                                                                        .addComponent(fldCpf, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(fldNome, javax.swing.GroupLayout.Alignment.LEADING))
                                                                .addGap(18, 18, Short.MAX_VALUE)
                                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(btnAlterarNome, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(btnAlterarCpf, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(btnAlterarVeiculo, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(btnAlterarLoja, javax.swing.GroupLayout.Alignment.TRAILING))))))
                                .addContainerGap())
        );
        painelDadosLayout.setVerticalGroup(
                painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelDadosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtFuncionario)
                                        .addComponent(selectFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(painelDadosLayout.createSequentialGroup()
                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtVeiculo)
                                                        .addComponent(selectVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, Short.MAX_VALUE)
                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtLoja)
                                                        .addComponent(selectLoja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(painelDadosLayout.createSequentialGroup()
                                                .addComponent(btnAlterarVeiculo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnAlterarLoja)
                                                .addGap(3, 3, 3)))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSalvar)
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

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (telaPrincipal == null) {
            dispose();
            return;
        }
        Funcionario funcionario = telaPrincipal.getFuncionario((String) selectFuncionario.getSelectedItem());
        String placa = (String) selectVeiculo.getSelectedItem();
        Veiculo veiculo = null;
        String nomeLoja = (String) selectLoja.getSelectedItem();
        Loja loja = null;

        if (funcionario.isDentroDoShopping()) {
            JOptionPane.showMessageDialog(this, "O funcionário deve estar fora do shopping para ser alterado.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
            dispose();
            return;
        }
        if (!placa.equals("Nenhum")) {
            String[] placaMarcaModelo = selectVeiculo.getItemAt(selectVeiculo.getSelectedIndex()).split(" ");
            veiculo = telaPrincipal.getVeiculo(placaMarcaModelo[0]);
        }
        if (!nomeLoja.equals("Nenhuma")) {
            loja = TelaPrincipal.shopping.getLoja(nomeLoja);
        }
        String nome = fldNome.getText();
        String cpf = fldCpf.getText();

        if (btnAlterarNome.isSelected()) {
            if (nome.isBlank()) {
                JOptionPane.showMessageDialog(this, "Verifique se os campos foram preenchidos corretamente.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (telaPrincipal.getClienteFrequente(nome) != null || telaPrincipal.getFuncionario(nome) != null) {
                JOptionPane.showMessageDialog(this, "Já existe uma pessoa registrada com esse nome.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
                return;
            }
            telaPrincipal.removerPessoa(funcionario);
            funcionario.setNome(nome);
            telaPrincipal.adicionarPessoa(funcionario);
        }
        if (btnAlterarCpf.isSelected()) {
            if (cpf.isBlank()) {
                JOptionPane.showMessageDialog(this, "Verifique se os campos foram preenchidos corretamente.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
                return;
            }
            funcionario.setCpf(cpf);
        }
        if (btnAlterarVeiculo.isSelected()) {
            funcionario.setVeiculo(veiculo);
            veiculo.setDono(funcionario);
        }
        if (btnAlterarLoja.isSelected()) {
            if (funcionario.getLoja() != null) {
                funcionario.getLoja().demitir(funcionario);
            }
            if (loja != null) {
                loja.contratar(funcionario);
            }
            funcionario.setLoja(loja);
        }
        JOptionPane.showMessageDialog(this, "Funcionário alterado com sucesso.", getTitle(), JOptionPane.INFORMATION_MESSAGE);
        telaPrincipal.updateExibicao();
        dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAlterarFuncionario(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox btnAlterarCpf;
    private javax.swing.JCheckBox btnAlterarLoja;
    private javax.swing.JCheckBox btnAlterarNome;
    private javax.swing.JCheckBox btnAlterarVeiculo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField fldCpf;
    private javax.swing.JTextField fldNome;
    private javax.swing.JPanel painelDados;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JComboBox<String> selectFuncionario;
    private javax.swing.JComboBox<String> selectLoja;
    private javax.swing.JComboBox<String> selectVeiculo;
    private javax.swing.JLabel txtCpf;
    private javax.swing.JLabel txtFuncionario;
    private javax.swing.JLabel txtLoja;
    private javax.swing.JLabel txtNome;
    private javax.swing.JLabel txtTitulo;
    private javax.swing.JLabel txtVeiculo;
    // End of variables declaration//GEN-END:variables
}
