package telas;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import trabalhotp1g17.Loja;
import trabalhotp1g17.Pessoa;
import trabalhotp1g17.Produto;

// Tela responsável por registrar a compra de um produto por uma pessoa.
public class TelaComprarProduto extends javax.swing.JFrame {
    private final TelaPrincipal telaPrincipal;  // Referência da tela principal
    private final Pessoa cliente;   // O cliente que irá comprar o produto
    private Loja loja;  // A loja que vende o produto

    // Construtor

    public TelaComprarProduto(TelaPrincipal telaPrincipal, Pessoa cliente) {
        this.telaPrincipal = telaPrincipal;
        this.cliente = cliente;
        initComponents();
        setLocationRelativeTo(null);
        
        carregarListaLojas();
        selectLoja.setSelectedIndex(0);
        
        atualizaLoja();
        atualizaListaDeProdutos();
        
        //carregarListaProdutos(); 
    }

    /*
    Atualiza a exibição da lista de lojas, adicionando como elementos
    os nomes das lojas. Após definir o modelo da lista, habilita e desabilita
    os elementos da tela conforme a funcionalidade desejada.
    */
    private void carregarListaLojas() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();

        String[] nomesLojas = telaPrincipal.getShopping().getLojasAbertas(true);

        if (nomesLojas != null) {
            for (String nome : nomesLojas) {
                modelo.addElement(nome);
            }
        }
        selectLoja.setModel(modelo);
        selectLoja.setEnabled(modelo.getSize() > 0);
        selectProduto.setEnabled(modelo.getSize() > 0);
    }

    private void carregarListaProdutos() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        loja = telaPrincipal.getShopping().getLoja((String) selectLoja.getSelectedItem());

        if (loja == null) {
            selectProduto.setModel(modelo);
            return;
        }
        ArrayList<Produto> produtos = loja.getProdutos(true);
        String[] nomesProdutos = new String[produtos.size()];
        int i = 0;

        for (Produto p : produtos) {
            nomesProdutos[i] = p.getNome() + " [R$ " + p.getPreco() + "; " + p.getQuantidade() + " itens]";
        }
        for (String nome : nomesProdutos) {
            modelo.addElement(nome);
        }
        selectProduto.setModel(modelo);
        selectProduto.setEnabled(modelo.getSize() > 0);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JLabel();
        painelDados = new javax.swing.JPanel();
        txtLoja = new javax.swing.JLabel();
        selectLoja = new javax.swing.JComboBox<>();
        txtProduto = new javax.swing.JLabel();
        selectProduto = new javax.swing.JComboBox<>();
        txtQuantidade = new javax.swing.JLabel();
        fldQuantidade = new javax.swing.JTextField();
        btnComprar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Comprar Produto");

        painelPrincipal.setBackground(new java.awt.Color(220, 220, 220));
        painelPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTitulo.setText("Comprar");
        txtTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        painelDados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtLoja.setText("Loja (aberta):");

        selectLoja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        selectLoja.setFocusable(false);
        selectLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectLojaActionPerformed(evt);
            }
        });

        txtProduto.setText("Produto (em estoque):");

        selectProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        selectProduto.setFocusable(false);

        txtQuantidade.setText("Quantidade:");

        fldQuantidade.setColumns(2);

        btnComprar.setText("Comprar");
        btnComprar.setFocusable(false);
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
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
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnComprar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCancelar))
                                        .addGroup(painelDadosLayout.createSequentialGroup()
                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(txtQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtLoja, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(selectProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(selectLoja, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(painelDadosLayout.createSequentialGroup()
                                                                .addComponent(fldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 192, Short.MAX_VALUE)))))
                                .addContainerGap())
        );
        painelDadosLayout.setVerticalGroup(
                painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelDadosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(selectLoja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtLoja))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtProduto)
                                        .addComponent(selectProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtQuantidade)
                                        .addComponent(fldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCancelar)
                                        .addComponent(btnComprar))
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
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
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

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        if (telaPrincipal == null || cliente == null) {
            dispose();
            return;
        }
        String item = selectProduto.getItemAt(selectProduto.getSelectedIndex());
        loja = telaPrincipal.getShopping().getLoja(selectLoja.getItemAt(selectLoja.getSelectedIndex()));
        String[] nomePrecoQuantidade = item.split(" ");
        Produto estoque = loja.getProduto(nomePrecoQuantidade[0]);
        int quantidade;

        try {
            quantidade = Integer.parseInt(fldQuantidade.getText());

            if (quantidade > estoque.getQuantidade()) {
                JOptionPane.showMessageDialog(this, "O número de itens comprados deve ser\nmenor que " + estoque.getQuantidade() + " (estoque do produto '" + estoque.getNome() + "').", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite um número válido.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
            return;
        }
        Produto produto = new Produto(estoque.getNome(), estoque.getPreco(), quantidade);
        boolean sucesso = cliente.comprar(produto, loja, telaPrincipal.getShopping());

        if (sucesso) {
            telaPrincipal.carregarDadosPessoa();
            telaPrincipal.updateDadosLoja();
            JOptionPane.showMessageDialog(this, "Compra efetuada com sucesso.\nProduto: " + produto.getNome() + "\nQuantidade: " + produto.getQuantidade() + "\nPreço: R$" + produto.getPreco() * produto.getQuantidade(), getTitle(), JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Não foi possível efetuar a compra.", "Erro: " + getTitle(), JOptionPane.ERROR_MESSAGE);
        }
        dispose();
    }//GEN-LAST:event_btnComprarActionPerformed

    private void selectLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectLojaActionPerformed
        atualizaLoja();
        atualizaListaDeProdutos();
    }//GEN-LAST:event_selectLojaActionPerformed

    public void atualizaLoja() {
        String nomeLoja = (String) selectLoja.getSelectedItem();
        loja = telaPrincipal.getShopping().getLoja(nomeLoja);
    }

    public void atualizaListaDeProdutos() {
        if (loja != null) {
            selectProduto.removeAllItems();
            ArrayList<Produto> produtos = loja.getProdutos(true);               //separa, dentre os produtos da loja, aqueles que possuem estoque

            for (Produto produto : produtos) {
                selectProduto.addItem(produto.getNome() + " [R$ " + produto.getPreco() + ", " + produto.getQuantidade() + " itens]");
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JTextField fldQuantidade;
    private javax.swing.JPanel painelDados;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JComboBox<String> selectLoja;
    private javax.swing.JComboBox<String> selectProduto;
    private javax.swing.JLabel txtLoja;
    private javax.swing.JLabel txtProduto;
    private javax.swing.JLabel txtQuantidade;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
