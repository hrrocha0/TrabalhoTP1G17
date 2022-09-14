package telas;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

import trabalhotp1g17.TipoVeiculo;
import trabalhotp1g17.Veiculo;

import javax.swing.table.DefaultTableModel;

/*
Tela responsável por gerar o relatório de veículos, que contém informações
sobre tais e podem ser salvos num arquivo.
*/
public class TelaRelatorioVeiculos extends javax.swing.JFrame {
    private final TelaPrincipal telaPrincipal;  // Referência da tela principal

    // Construtor

    public TelaRelatorioVeiculos(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        initComponents();
        carregarTabelaVeiculos();
        setLocationRelativeTo(null);
    }

    /*
    Carrega a tabela dos funcionários, mostrando as suas informações. As informações
    mostradas são: placa, tipo do veículo, marca e modelo. 
    */
    private void carregarTabelaVeiculos() {
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Placa", "Tipo", "Marca", "Modelo"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        if (telaPrincipal == null) {
            tblVeiculos.setModel(modelo);
            return;
        }
        for (String placa : telaPrincipal.getPlacasVeiculos()) {
            Veiculo veiculo = telaPrincipal.getVeiculo(placa);
            TipoVeiculo tipo = veiculo.getTipo();
            String marca = veiculo.getMarca();
            String modeloVeiculo = veiculo.getModelo();

            Object[] linha = {placa, tipo, marca, modeloVeiculo};
            modelo.addRow(linha);
        }
        tblVeiculos.setModel(modelo);
        btnSalvar.setEnabled(telaPrincipal.getPlacasVeiculos().length > 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JLabel();
        painelDados = new javax.swing.JPanel();
        barraDeRolagem = new javax.swing.JScrollPane();
        tblVeiculos = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Veículos");

        painelPrincipal.setBackground(new java.awt.Color(220, 220, 220));
        painelPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTitulo.setText("Relatório de Veículos");
        txtTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        painelDados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Placa", "Tipo", "Marca", "Modelo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
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
        barraDeRolagem.setViewportView(tblVeiculos);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barraDeRolagem, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar)))
                .addContainerGap())
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barraDeRolagem, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar)
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

            for (String placa : telaPrincipal.getPlacasVeiculos()) {
                Veiculo veiculo = telaPrincipal.getVeiculo(placa);

                arquivo.write(placa + ", ");
                arquivo.write(veiculo.getTipo() + ", ");
                arquivo.write(veiculo.getMarca() + ", ");
                arquivo.write(veiculo.getModelo());
                arquivo.write('\n');
            }
            arquivo.close();
            JOptionPane.showMessageDialog(this, "Relatório salvo como " + nomeArquivo + ".", "Salvar Relatório", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Não foi possível salvar o relatório em " + nomeArquivo + ".", "Erro: Salvar Relatório", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorioVeiculos(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane barraDeRolagem;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JPanel painelDados;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JTable tblVeiculos;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
