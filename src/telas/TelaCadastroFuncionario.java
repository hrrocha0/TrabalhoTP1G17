package telas;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import trabalhotp1g17.Funcionario;
import trabalhotp1g17.Loja;
import trabalhotp1g17.Veiculo;

// Tela responsável por cadastrar funcionários no sistema.
public class TelaCadastroFuncionario extends javax.swing.JFrame {
    private final TelaPrincipal telaPrincipal;  // Referência da tela principal
    
    // Construtor
    
    public TelaCadastroFuncionario(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        initComponents();
        carregarListaVeiculos();
        carregarListaLojas();
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
            caixaVeiculo.setModel(modelo);
            return;
        }
        
        for (String placa : telaPrincipal.getPlacasVeiculos()) {
            modelo.addElement(placa);
        }
        caixaVeiculo.setModel(modelo);
    }
    
    // Atualiza a exibição da lista de lojas, adicionando como elementos os nomes das lojas.
    private void carregarListaLojas() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        modelo.addElement("Nenhuma");
        
        if (telaPrincipal == null) {
            caixaLoja.setModel(modelo);
            return;
        }
        
        for (String nome : TelaPrincipal.shopping.getLojas(false)) {
            modelo.addElement(nome);
        }
        caixaLoja.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        painelDados = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        labelCpf = new javax.swing.JLabel();
        campoCpf = new javax.swing.JTextField();
        labelVeiculo = new javax.swing.JLabel();
        caixaVeiculo = new javax.swing.JComboBox<>();
        labelLoja = new javax.swing.JLabel();
        caixaLoja = new javax.swing.JComboBox<>();
        botaoCadastrar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Funcionário");

        painelPrincipal.setBackground(new java.awt.Color(220, 220, 220));
        painelPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        titulo.setText("Cadastrar Funcionário");
        titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        painelDados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelNome.setText("Nome:");

        labelCpf.setText("CPF:");

        labelVeiculo.setText("Veículo:");

        caixaVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum" }));

        labelLoja.setText("Loja:");

        caixaLoja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum" }));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCancelar))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelVeiculo)
                            .addComponent(labelLoja)
                            .addComponent(labelCpf)
                            .addComponent(labelNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                            .addComponent(campoNome)
                            .addComponent(caixaVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(caixaLoja, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCpf)
                    .addComponent(campoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVeiculo)
                    .addComponent(caixaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelLoja)
                    .addComponent(caixaLoja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        
        String nome = campoNome.getText();
        String cpf = campoCpf.getText();
        
        if (nome.isBlank() || cpf.isBlank()) {
            JOptionPane.showMessageDialog(this, "Verifique se os campos foram preenchidos corretamente.", "Erro: Cadastrar Funcionário", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (telaPrincipal.getClienteFrequente(nome) != null || telaPrincipal.getFuncionario(nome) != null) {
            JOptionPane.showMessageDialog(this, "Já existe uma pessoa registrada com esse nome.", "Erro: Cadastrar Cliente", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String placa = (String) caixaVeiculo.getSelectedItem();
        Veiculo veiculo = telaPrincipal.getVeiculo(placa);
        String nomeLoja = (String) caixaLoja.getSelectedItem();
        Loja loja = TelaPrincipal.shopping.getLoja(nomeLoja);
        
        Funcionario funcionario = new Funcionario(nome, cpf, veiculo, loja);
        
        if(TelaPrincipal.shopping.getLoja(nomeLoja) != null){
            TelaPrincipal.shopping.getLoja(nomeLoja).contratar(funcionario);
        }
        telaPrincipal.adicionarPessoa(funcionario);
        TelaPrincipal.shopping.add(funcionario);
        JOptionPane.showMessageDialog(this, "O funcionário " + nome + " foi cadastrado com sucesso." , "Cadastrar Funcionário", JOptionPane.PLAIN_MESSAGE);
        telaPrincipal.updateExibicao();
        dispose();
    }//GEN-LAST:event_botaoCadastrarActionPerformed
     
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroFuncionario(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JComboBox<String> caixaLoja;
    private javax.swing.JComboBox<String> caixaVeiculo;
    private javax.swing.JTextField campoCpf;
    private javax.swing.JTextField campoNome;
    private javax.swing.JLabel labelCpf;
    private javax.swing.JLabel labelLoja;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelVeiculo;
    private javax.swing.JPanel painelDados;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
