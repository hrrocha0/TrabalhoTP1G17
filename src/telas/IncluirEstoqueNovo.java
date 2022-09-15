/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import javax.swing.JOptionPane;
import trabalhotp1g17.*;

/**
 *
 * @author axelp
 */
public class IncluirEstoqueNovo extends javax.swing.JFrame {

    
    private TelaPrincipal telaPrincipal;
    
    String[] nomesLojas;
    
    public IncluirEstoqueNovo(TelaPrincipal telaPrincipal) {
        initComponents();
        setLocationRelativeTo(null);            //faz a tela nascer centralizada
        
        this.telaPrincipal = telaPrincipal;
        nomesLojas = telaPrincipal.getShopping().getLojas(false);
        selectNomesLojas.removeAllItems();

        for (String nomeLoja : nomesLojas) {
            selectNomesLojas.addItem(nomeLoja);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        selectNomesLojas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        textNomeProduto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textQuantidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textPreco = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atualizar estoque de uma loja");

        jLabel1.setText("Loja:");

        selectNomesLojas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Produto:");

        textNomeProduto.setToolTipText("insira o nome de um produto...");

        jLabel3.setText("Quantidade:");

        jLabel4.setText("Preço (R$):");

        textPreco.setToolTipText("");

        jButton1.setText("Atualizar estoque");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("<html>Insira o nome do produto, a quantidade a incluir no estoque e o preço. Se o produto já existir no estoque da loja selecionada, a quantidade inserida será adicionada à existente e o preço será sobrescrito.</html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNomeProduto)
                            .addComponent(selectNomesLojas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(textQuantidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectNomesLojas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nomeLoja = selectNomesLojas.getItemAt(selectNomesLojas.getSelectedIndex());
        String nomeProduto = "";
        int quantidade = 0;
        double preco = 0;
        
        try{
            nomeProduto = textNomeProduto.getText();
            quantidade = Integer.parseInt(textQuantidade.getText());
            textPreco.setText(textPreco.getText().replace(',', '.'));
            preco = Double.parseDouble(textPreco.getText());
            if(preco <= 0){
               JOptionPane.showMessageDialog(null, "O preço deve ser maior que 0!", "erro!", JOptionPane.ERROR_MESSAGE);
               return;
            }
            if(quantidade <= 0){
                JOptionPane.showMessageDialog(null, "A quantidade deve ser maior que 0!", "erro!", JOptionPane.ERROR_MESSAGE);
               return;
            }
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Revise os dados. A quantidade deve ser inteira e o preço deve ser inteiro ou fracionário.", "erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (nomeProduto.isBlank()) {
            JOptionPane.showMessageDialog(null, "Revise os dados. O nome não pode ser vazio.", "erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        nomeProduto = nomeProduto.replace(' ', '-');
        telaPrincipal.getShopping().abasteceEstoqueDaLoja(nomeLoja, new Produto(nomeProduto, preco, quantidade));
        telaPrincipal.updateNomesLojas();
        dispose();
        JOptionPane.showMessageDialog(null, "Produto '" + nomeProduto + "' adicionado com sucesso ao estoque da loja '" + nomeLoja + "'", "sucesso!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox<String> selectNomesLojas;
    private javax.swing.JTextField textNomeProduto;
    private javax.swing.JTextField textPreco;
    private javax.swing.JTextField textQuantidade;
    // End of variables declaration//GEN-END:variables
}
