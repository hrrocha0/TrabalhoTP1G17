
package telas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import trabalhotp1g17.*;


public class IncluirEstoqueExistente extends javax.swing.JFrame {

    private TelaPrincipal telaPrincipal;
    private String[] nomesLojas;
    private String[] nomesProdutos;
    private Loja loja;
    
    public IncluirEstoqueExistente(TelaPrincipal telaPrincipal) {
        initComponents();
        setLocationRelativeTo(null);
        
        this.telaPrincipal = telaPrincipal;
        nomesLojas = TelaPrincipal.shopping.getLojas(true);
        System.out.print(nomesLojas.length + " lojas com produtos cadastrados: ");
        loja = TelaPrincipal.shopping.getLoja(nomesLojas[0]);
        
        for(String s : nomesLojas){
            System.out.print(s + " ");
        }
        System.out.println("");

        selectNomesLojas.removeAllItems();
        for(int i = 0; i < nomesLojas.length; i++){
            selectNomesLojas.addItem(nomesLojas[i]);
        }
        
        selectNomesLojas.setSelectedIndex(0);

        atualizaLoja();
        atualizaListaDeProdutos();
    }


    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        radioQuantidade = new javax.swing.JRadioButton();
        inputQuantidade = new javax.swing.JTextField();
        inputPreco = new javax.swing.JTextField();
        selectNomesLojas = new javax.swing.JComboBox<>();
        selectNomesProdutos = new javax.swing.JComboBox<>();
        radioPreco = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atualizar um item existente");

        jLabel1.setText("Loja:");

        jLabel2.setText("Item:");

        jLabel3.setText("Quantidade:");

        jLabel4.setText("Preço (R$):");

        radioQuantidade.setText("Não desejo atualizar a quantidade");
        radioQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioQuantidadeActionPerformed(evt);
            }
        });

        inputPreco.setText(" ");

        selectNomesLojas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectNomesLojas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectNomesLojasActionPerformed(evt);
            }
        });

        selectNomesProdutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        radioPreco.setText("Não desejo atualizar o preço");
        radioPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPrecoActionPerformed(evt);
            }
        });

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selectNomesLojas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectNomesProdutos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(radioQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(radioPreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(selectNomesLojas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(selectNomesProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioQuantidade))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inputPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioPreco))
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nomeLoja = selectNomesLojas.getItemAt(selectNomesLojas.getSelectedIndex());
        String nomeProduto = selectNomesProdutos.getItemAt(selectNomesProdutos.getSelectedIndex());
        int quantidade = 0;
        double preco = 0;
        
        try{
            if(!radioQuantidade.isSelected()){
                quantidade = Integer.parseInt(inputQuantidade.getText());
                if(quantidade <= 0){
                    JOptionPane.showMessageDialog(null, "A quantidade deve ser maior que 0!", "erro!", JOptionPane.PLAIN_MESSAGE);
                    return;
                }
            }
            if(!radioPreco.isSelected()){
                inputPreco.setText(inputPreco.getText().replace(',', '.'));
                preco = Double.parseDouble(inputPreco.getText());
                if(preco <= 0){
                    JOptionPane.showMessageDialog(null, "O preço deve ser maior que 0!", "erro!", JOptionPane.PLAIN_MESSAGE);
                    return;
                }
            }
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Revise os dados. A quantidade deve ser inteira e o preço deve ser inteiro ou fracionário.", "erro!", JOptionPane.PLAIN_MESSAGE);
            return;
        }          
        TelaPrincipal.shopping.abasteceEstoqueDaLoja(nomeLoja, new Produto(nomeProduto, preco, quantidade));
        telaPrincipal.updateNomesLojas();
        dispose();
        JOptionPane.showMessageDialog(null, "Produto \'" + nomeProduto + "\' adicionado com sucesso ao estoque da loja \'" + nomeLoja + "\'", "sucesso!", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void radioQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioQuantidadeActionPerformed
        radioPreco.setSelected(false);
        if(radioQuantidade.isSelected()){
            inputQuantidade.setText("");
            inputQuantidade.setEnabled(false);
            inputPreco.setEnabled(true);
        }
        else{
            inputQuantidade.setEnabled(true);
        }
    }//GEN-LAST:event_radioQuantidadeActionPerformed

    private void radioPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPrecoActionPerformed
        radioQuantidade.setSelected(false);
        if(radioPreco.isSelected()){
            inputPreco.setText("");
            inputPreco.setEnabled(false);
            inputQuantidade.setEnabled(true);
        }
        else{
            inputPreco.setEnabled(true);
        }
    }//GEN-LAST:event_radioPrecoActionPerformed

    private void selectNomesLojasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectNomesLojasActionPerformed
            atualizaLoja();
            atualizaListaDeProdutos();// TODO add your handling code here:
    }//GEN-LAST:event_selectNomesLojasActionPerformed

    public void atualizaLoja(){
        String nomeLoja = selectNomesLojas.getItemAt(selectNomesLojas.getSelectedIndex());
        System.out.println(nomeLoja);
        loja = TelaPrincipal.shopping.getLoja(nomeLoja);
    }
    
    public void atualizaListaDeProdutos(){
        if(loja != null){
            selectNomesProdutos.removeAllItems();
            ArrayList<Produto> produtos = loja.getProdutos(false);
        
            for(Produto p : produtos){
                selectNomesProdutos.addItem(p.getNome());
            }
        }
    }
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField inputPreco;
    private javax.swing.JTextField inputQuantidade;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton radioPreco;
    private javax.swing.JRadioButton radioQuantidade;
    private javax.swing.JComboBox<String> selectNomesLojas;
    private javax.swing.JComboBox<String> selectNomesProdutos;
    // End of variables declaration//GEN-END:variables
}
