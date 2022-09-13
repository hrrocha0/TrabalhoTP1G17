package telas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import trabalhotp1g17.ClienteEsporadico;
import trabalhotp1g17.ClienteFrequente;
import trabalhotp1g17.Veiculo;

import java.io.FileWriter;
import java.io.IOException;

/*
Tela responsável por gerar o relatório de clientes, que contém informações
sobre tais e podem ser salvos em um arquivo. Dados de clientes esporádicos não 
são salvos no arquivo.
*/
public class TelaRelatorioClientes extends javax.swing.JFrame {
    private final TelaPrincipal telaPrincipal;  // Referência da tela principal

    // Construtor
    
    public TelaRelatorioClientes(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        initComponents();
        carregarTabelaClientes();
        setLocationRelativeTo(null);
    }
    
    /*
    Carrega a tabela dos clientes, mostrando informações tanto dos clientes
    frequentes quanto dos clientes esporádicos. As informações mostradas são:
    nome, CPF, veículo e gasto em produtos. Para clientes esporádicos, o nome
    será representado por 'Cliente ID' e a caixa do CPF estará vazia.
    */
    private void carregarTabelaClientes() {
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Nome", "CPF", "Veículo", "Gasto Total"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        if (telaPrincipal == null) {
            tblClientes.setModel(modelo);
            return;
        }
        for (int i = 0; i < telaPrincipal.getQtdClientesEsporadicos(); i++) {
            ClienteEsporadico clienteEsporadico = telaPrincipal.getClienteEsporadico(i);
            String nome = "Cliente " + clienteEsporadico.getID();
            Veiculo veiculo = clienteEsporadico.getVeiculo();
            double gastoTotal = clienteEsporadico.getGastoTotal();

            Object[] linha = {nome, null, veiculo, gastoTotal};
            modelo.addRow(linha);
        }
        for (String nome : telaPrincipal.getNomesClientesFrequentes()) {
            ClienteFrequente clienteFrequente = telaPrincipal.getClienteFrequente(nome);
            String cpf = clienteFrequente.getCpf();
            Veiculo veiculo = clienteFrequente.getVeiculo();
            double gastoTotal = clienteFrequente.getGastoTotal();

            Object[] linha = {nome, cpf, veiculo, gastoTotal};
            modelo.addRow(linha);
        }
        tblClientes.setModel(modelo);
        btnSalvar.setEnabled(telaPrincipal.getNomesClientesFrequentes().length > 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JLabel();
        painelDados = new javax.swing.JPanel();
        barraDeRolagem = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        txtAviso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelPrincipal.setBackground(new java.awt.Color(220, 220, 220));
        painelPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTitulo.setText("Relatório de Clientes");
        txtTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        painelDados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Veículo", "Gasto Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        barraDeRolagem.setViewportView(tblClientes);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtAviso.setText("Aviso: Clientes esporádicos não serão salvos.");

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barraDeRolagem, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                        .addComponent(txtAviso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar)))
                .addContainerGap())
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barraDeRolagem, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(txtAviso))
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
        String nomeArquivo = JOptionPane.showInputDialog(this, "Digite o nome do arquivo (.csv):", "Salvar Relatório", JOptionPane.QUESTION_MESSAGE);
        
        if (nomeArquivo == null || telaPrincipal == null) {
            return;
        }
        if (!nomeArquivo.endsWith(".csv")) {
            nomeArquivo += ".csv";
        }
        try {
            FileWriter arquivo = new FileWriter(nomeArquivo);
            
            for (String nome : telaPrincipal.getNomesClientesFrequentes()) {
                ClienteFrequente clienteFrequente = telaPrincipal.getClienteFrequente(nome);
                arquivo.write(nome + ", ");
                arquivo.write(clienteFrequente.getCpf() + ", ");
                arquivo.write(clienteFrequente.getVeiculo() + ", ");
                arquivo.write(String.valueOf(clienteFrequente.getGastoTotal()));
                arquivo.write('\n');
            }
            arquivo.close();
            JOptionPane.showMessageDialog(this, "Relatório salvo como " + nomeArquivo + ".", "Salvar Relatório",JOptionPane.PLAIN_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Não foi possível salvar o relatório em " + nomeArquivo + ".", "Erro: Salvar Relatório", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorioClientes(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane barraDeRolagem;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JPanel painelDados;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JTable tblClientes;
    private javax.swing.JLabel txtAviso;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
