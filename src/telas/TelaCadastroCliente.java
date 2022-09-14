package telas;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import trabalhotp1g17.ClienteEsporadico;
import trabalhotp1g17.ClienteFrequente;
import trabalhotp1g17.Pessoa;
import trabalhotp1g17.Veiculo;

//Tela responsável por cadastrar clientes esporádicos e frequentes no sistema.
public class TelaCadastroCliente extends javax.swing.JFrame {
    private final TelaPrincipal telaPrincipal;  // Referência da tela principal

    // Construtor

    public TelaCadastroCliente(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        initComponents();
        carregarListaVeiculos();
        setLocationRelativeTo(null);
    }

    /*
    Atualiza a exibição da lista de veículos, adicionando como elementos
    as informações do veículo, na forma 'PLACA (MARCA MODELO)'.
    */
    private void carregarListaVeiculos() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
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
        txtNome = new javax.swing.JLabel();
        fldNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JLabel();
        fldCpf = new javax.swing.JTextField();
        txtVeiculo = new javax.swing.JLabel();
        selectVeiculo = new javax.swing.JComboBox<>();
        btnCadastrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Cliente");

        painelPrincipal.setBackground(new java.awt.Color(220, 220, 220));
        painelPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTitulo.setText("Cadastrar Cliente");
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

        txtNome.setText("Nome:");

        txtCpf.setText("CPF:");

        txtVeiculo.setText("Veículo:");

        selectVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Nenhum"}));
        selectVeiculo.setFocusable(false);

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
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(painelDadosLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnCadastrar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCancelar))
                                        .addGroup(painelDadosLayout.createSequentialGroup()
                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtVeiculo)
                                                        .addComponent(txtCpf)
                                                        .addComponent(txtNome)
                                                        .addComponent(txtTipo))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(painelDadosLayout.createSequentialGroup()
                                                                .addComponent(btnFrequente)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnEsporadico)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(fldCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                                                        .addComponent(fldNome)
                                                        .addComponent(selectVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtNome)
                                        .addComponent(fldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtCpf)
                                        .addComponent(fldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtVeiculo)
                                        .addComponent(selectVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (telaPrincipal == null) {
            dispose();
            return;
        }
        String placa = (String) selectVeiculo.getSelectedItem();
        Veiculo veiculo = null;

        if (!placa.equals("Nenhum")) {
            String[] placaMarcaModelo = ((String) selectVeiculo.getSelectedItem()).split(" ");
            veiculo = telaPrincipal.getVeiculo(placaMarcaModelo[0]);
        }
        String nome;
        Pessoa pessoa;

        if (btnFrequente.isSelected()) {
            String cpf = fldCpf.getText();
            nome = fldNome.getText();

            if (nome.isBlank() || cpf.isBlank()) {
                JOptionPane.showMessageDialog(this, "Verifique se os campos foram preenchidos corretamente.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (telaPrincipal.getClienteFrequente(nome) != null || telaPrincipal.getFuncionario(nome) != null) {
                JOptionPane.showMessageDialog(this, "Já existe uma pessoa registrada com esse nome.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
                return;
            }
            pessoa = new ClienteFrequente(nome, cpf, veiculo);
        } else {
            int id = TelaPrincipal.idEsporadico + 1;

            nome = "Cliente " + id;
            pessoa = new ClienteEsporadico(veiculo, id);
            TelaPrincipal.idEsporadico++;
        }
        if (veiculo != null) {
            veiculo.setDono(pessoa);
        }
        telaPrincipal.adicionarPessoa(pessoa);
        TelaPrincipal.shopping.add(pessoa);
        JOptionPane.showMessageDialog(this, "O cliente " + nome + " foi cadastrado com sucesso.", getTitle(), JOptionPane.INFORMATION_MESSAGE);
        telaPrincipal.updateExibicao();
        dispose();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEsporadicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsporadicoActionPerformed
        txtNome.setEnabled(false);
        fldNome.setEnabled(false);
        txtCpf.setEnabled(false);
        fldCpf.setEnabled(false);
    }//GEN-LAST:event_btnEsporadicoActionPerformed

    private void btnFrequenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFrequenteActionPerformed
        txtNome.setEnabled(true);
        fldNome.setEnabled(true);
        txtCpf.setEnabled(true);
        fldCpf.setEnabled(true);
    }//GEN-LAST:event_btnFrequenteActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroCliente(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JRadioButton btnEsporadico;
    private javax.swing.JRadioButton btnFrequente;
    private javax.swing.ButtonGroup btngTipo;
    private javax.swing.JTextField fldCpf;
    private javax.swing.JTextField fldNome;
    private javax.swing.JPanel painelDados;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JComboBox<String> selectVeiculo;
    private javax.swing.JLabel txtCpf;
    private javax.swing.JLabel txtNome;
    private javax.swing.JLabel txtTipo;
    private javax.swing.JLabel txtTitulo;
    private javax.swing.JLabel txtVeiculo;
    // End of variables declaration//GEN-END:variables
}
