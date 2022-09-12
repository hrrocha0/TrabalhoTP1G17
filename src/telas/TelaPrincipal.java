
package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import trabalhotp1g17.*;        

public class TelaPrincipal extends javax.swing.JFrame {
    
    public static String data = "00:00:00";
    public static Shopping shopping = new Shopping();
    
    private final ArrayList<ClienteEsporadico> clientesEsporadicos = new ArrayList<>();
    private final HashMap<String, ClienteFrequente> clientesFrequentes = new HashMap<>();
    private final HashMap<String, Funcionario> funcionarios = new HashMap<>();
    private final HashMap<String, Veiculo> veiculos = new HashMap<>();
    
    public TelaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);            //faz a tela nascer centralizada
        
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                updateData();
            }
        };
        Timer t = new Timer(1000, taskPerformer);
        t.start();
        updateExibicao();
    }
    
    public void adicionarPessoa(Pessoa pessoa) {
        if (pessoa instanceof ClienteEsporadico) {
            clientesEsporadicos.add((ClienteEsporadico) pessoa);
        } else if (pessoa instanceof ClienteFrequente) {
            clientesFrequentes.put(((ClienteFrequente) pessoa).getNome(), (ClienteFrequente) pessoa);
        } else {
            funcionarios.put(((Funcionario) pessoa).getNome(), (Funcionario) pessoa);
        }
    }
    
    public void removerPessoa(Pessoa pessoa) {
        if (pessoa instanceof ClienteEsporadico) {
            clientesEsporadicos.remove((ClienteEsporadico) pessoa);
        } else if (pessoa instanceof ClienteFrequente) {
            clientesFrequentes.remove(((ClienteFrequente) pessoa).getNome());
        } else {
            funcionarios.remove(((Funcionario) pessoa).getNome());
        }
    }
    
    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.put(veiculo.getPlaca(), veiculo);
    }
    
    public void removerVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo.getPlaca());
    }
    
    public ClienteEsporadico getClienteEsporadico(int id) {
        return clientesEsporadicos.get(id);
    }
    
    public int getQtdClientesEsporadicos() {
        return clientesEsporadicos.size();
    }
    
    public ClienteFrequente getClienteFrequente(String nome) {
        return clientesFrequentes.get(nome);
    }
    
    public String[] getNomesClientesFrequentes() {
        String[] nomesClientesFrequentes = new String[clientesFrequentes.size()];
        int i = 0;

        for (String nome : clientesFrequentes.keySet()) {
            nomesClientesFrequentes[i] = nome;
            i++;
        }
        return nomesClientesFrequentes;
    }
    
    public Funcionario getFuncionario(String nome) {
        return funcionarios.get(nome);
    }
    
    public String[] getNomesFuncionarios() {
        String[] nomesFuncionarios = new String[funcionarios.size()];
        int i = 0;

        for (String nome : funcionarios.keySet()) {
            nomesFuncionarios[i] = nome;
            i++;
        }
        return nomesFuncionarios;
    }
    
    public Veiculo getVeiculo(String placa) {
        return veiculos.get(placa);
    }
    
    public String[] getPlacasVeiculos() {
        String[] placasVeiculos = new String[veiculos.size()];
        int i = 0;

        for (String placa : veiculos.keySet()) {
            placasVeiculos[i] = placa;
            i++;
        }
        return placasVeiculos;
    }
    
    private void carregarListaPessoas() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        
        if (btnClientesEsporadicos.isSelected()) {
            for (int i = 1; i <= clientesEsporadicos.size(); i++) {
                modelo.addElement("Cliente " + i);
            }
        } else if (btnClientesFrequentes.isSelected()) {
            for (String nome : clientesFrequentes.keySet()) {
                modelo.addElement(nome);
            }
        } else {
            for (String nome : funcionarios.keySet()) {
                modelo.addElement(nome);
            }
        }
        listaPessoas.setModel(modelo);
        
        if (modelo.getSize() > 0) {
            listaPessoas.setEnabled(true);
            
            if (shopping.isAberto()) {
                btnEntrarNoShopping.setEnabled(true);
                btnComprar.setEnabled(true);
                btnSairDoShopping.setEnabled(true);
            } else {
                btnEntrarNoShopping.setEnabled(false);
                btnComprar.setEnabled(false);
                btnSairDoShopping.setEnabled(false);
            }
            
            labelLocalizacaoPessoa.setEnabled(true);
            labelVeiculoPessoa.setEnabled(true);
            labelGastosPessoa.setEnabled(true);
            labelEstacionamentoPessoa.setEnabled(true);
        } else {
            listaPessoas.setEnabled(false);
            
            btnEntrarNoShopping.setEnabled(false);
            btnComprar.setEnabled(false);
            btnSairDoShopping.setEnabled(false);
            
            labelLocalizacaoPessoa.setEnabled(false);
            labelVeiculoPessoa.setEnabled(false);
            labelGastosPessoa.setEnabled(false);
            labelEstacionamentoPessoa.setEnabled(false);
        }
    }
    
    private void carregarDadosPessoa() {
        if (listaPessoas.isEnabled()) {
            Pessoa pessoa;
            
            if (btnClientesEsporadicos.isSelected()) {
                pessoa = clientesEsporadicos.get(listaPessoas.getSelectedIndex());
            } else if (btnClientesFrequentes.isSelected()) {
                pessoa = clientesFrequentes.get((String) listaPessoas.getSelectedItem());
            } else {
                pessoa = funcionarios.get((String) listaPessoas.getSelectedItem());
            }
            
            if (pessoa.getLocalizacao() != null) {
                labelLocalizacaoPessoa.setText("Localização: " + pessoa.getLocalizacao());
            } else {
                labelLocalizacaoPessoa.setText("Localização: Fora do Shopping");
            }
            if (pessoa.getVeiculo() != null) {
                labelVeiculoPessoa.setText("Veículo: " + pessoa.getVeiculo());
            } else {
                labelVeiculoPessoa.setText("Veículo: nenhum");
            }
            labelGastosPessoa.setText("Valor em Compras: R$" + pessoa.getGastoTotal());
            labelEstacionamentoPessoa.setText("Estacionamento: R$" + pessoa.getValorIsencao());
        } else {
            labelLocalizacaoPessoa.setText("Localização: -");
            labelVeiculoPessoa.setText("Veículo: -");
            labelGastosPessoa.setText("Valor em Compras: -");
            labelEstacionamentoPessoa.setText("Estacionamento: -");
        }
    }
    
    public void updateExibicao(){
        carregarListaPessoas();
        carregarDadosPessoa();
        updateNomesLojas();
        updateEstacionamento();
        updateData();
    }
    
    public void updateNomesLojas(){
        String[] nomes = shopping.getLojas(false);
        
        nomesLojas.removeAllItems();
        
        if (nomes.length > 0){
            for(int i = 0; i < nomes.length; i++){
                nomesLojas.addItem(nomes[i]);
            }
            return;
        }
        
        nomesLojas.addItem("Nenhuma loja cadastrada");
        textStatusLoja.setText("Status: -");
        textFuncionarios.setText("Funcionarios: -");
        textProdutosEmEstoque.setText("Estoque: -");
    }
    
    public void updateEstacionamento(){
        int[] vagasCarro = shopping.getVagasCarro();
        int[] vagasMoto = shopping.getVagasMoto();
        
        VagasCarroDisponiveis.setText("Disponiveis: " + (vagasCarro[1] - vagasCarro[0]));
        VagasCarroOcupadas.setText("Ocupadas: " + vagasCarro[0]);
        VagasMotoDisponiveis.setText("Disponiveis: " + (vagasMoto[1] - vagasMoto[0]));
        VagasMotoOcupadas.setText("Ocupadas: " + vagasMoto[0]);
    }

    public void updateData(){
        data = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        labelData.setText("Hora: " + data);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrPessoas = new javax.swing.ButtonGroup();
        jMenuItem2 = new javax.swing.JMenuItem();
        painelShopping = new javax.swing.JPanel();
        tituloShopping = new javax.swing.JLabel();
        labelStatusShopping = new javax.swing.JLabel();
        btnAbrirShopping = new javax.swing.JButton();
        btnFecharShopping = new javax.swing.JButton();
        labelPessoas = new javax.swing.JLabel();
        labelData = new javax.swing.JLabel();
        painelCategorias = new javax.swing.JPanel();
        painelPessoas = new javax.swing.JPanel();
        tituloPessoas = new javax.swing.JLabel();
        separadorPessoas = new javax.swing.JSeparator();
        btnClientesEsporadicos = new javax.swing.JRadioButton();
        btnClientesFrequentes = new javax.swing.JRadioButton();
        btnFuncionarios = new javax.swing.JRadioButton();
        listaPessoas = new javax.swing.JComboBox<>();
        btnEntrarNoShopping = new javax.swing.JButton();
        btnComprar = new javax.swing.JButton();
        btnSairDoShopping = new javax.swing.JButton();
        painelDadosPessoas = new javax.swing.JPanel();
        labelLocalizacaoPessoa = new javax.swing.JLabel();
        labelVeiculoPessoa = new javax.swing.JLabel();
        labelGastosPessoa = new javax.swing.JLabel();
        labelEstacionamentoPessoa = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        VagasCarroDisponiveis = new javax.swing.JLabel();
        VagasCarroOcupadas = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        VagasMotoDisponiveis = new javax.swing.JLabel();
        VagasMotoOcupadas = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        textProdutosEmEstoque = new javax.swing.JLabel();
        textStatusLoja = new javax.swing.JLabel();
        textFuncionarios = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        nomesLojas = new javax.swing.JComboBox<>();
        barraMenu = new javax.swing.JMenuBar();
        menuClientes = new javax.swing.JMenu();
        menuCadastrarCliente = new javax.swing.JMenuItem();
        menuRemoverCliente = new javax.swing.JMenuItem();
        menuRelatorioClientes = new javax.swing.JMenuItem();
        menuFuncionarios = new javax.swing.JMenu();
        menuCadastrarFuncionario = new javax.swing.JMenuItem();
        menuRemoverFuncionario = new javax.swing.JMenuItem();
        menuRelatorioFuncionarios = new javax.swing.JMenuItem();
        menuVeiculos = new javax.swing.JMenu();
        menuCadastrarVeiculo = new javax.swing.JMenuItem();
        menuRemoverVeiculo = new javax.swing.JMenuItem();
        menuRelatorioVeiculos = new javax.swing.JMenuItem();
        menuLojas = new javax.swing.JMenu();
        menuCadastrarLoja = new javax.swing.JMenuItem();
        menuRemoverLoja = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        menuEstacionamento = new javax.swing.JMenu();
        menuAlterarVagas = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciamento do shopping");
        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(java.awt.Color.darkGray);

        painelShopping.setBackground(new java.awt.Color(220, 220, 220));
        painelShopping.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tituloShopping.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tituloShopping.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloShopping.setText("SHOPPING CENTER");
        tituloShopping.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelStatusShopping.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelStatusShopping.setText("Status: fechado");

        btnAbrirShopping.setText("Abrir");
        btnAbrirShopping.setToolTipText("");
        btnAbrirShopping.setFocusable(false);
        btnAbrirShopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirShoppingActionPerformed(evt);
            }
        });

        btnFecharShopping.setText("Fechar");
        btnFecharShopping.setFocusable(false);
        btnFecharShopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharShoppingActionPerformed(evt);
            }
        });

        labelPessoas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPessoas.setText("Pessoas dentro: 0");

        labelData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelData.setText("Data: 10:46");

        javax.swing.GroupLayout painelShoppingLayout = new javax.swing.GroupLayout(painelShopping);
        painelShopping.setLayout(painelShoppingLayout);
        painelShoppingLayout.setHorizontalGroup(
            painelShoppingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelShoppingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelShoppingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloShopping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelShoppingLayout.createSequentialGroup()
                        .addComponent(labelStatusShopping, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelShoppingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAbrirShopping, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFecharShopping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelShoppingLayout.setVerticalGroup(
            painelShoppingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelShoppingLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelShoppingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelShoppingLayout.createSequentialGroup()
                        .addComponent(tituloShopping, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(painelShoppingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelShoppingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelStatusShopping)
                                .addComponent(labelPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelData)))
                    .addGroup(painelShoppingLayout.createSequentialGroup()
                        .addComponent(btnAbrirShopping, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFecharShopping, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        painelPessoas.setBackground(new java.awt.Color(220, 220, 220));
        painelPessoas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tituloPessoas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tituloPessoas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloPessoas.setText("Pessoas");

        btnClientesEsporadicos.setBackground(new java.awt.Color(220, 220, 220));
        btngrPessoas.add(btnClientesEsporadicos);
        btnClientesEsporadicos.setSelected(true);
        btnClientesEsporadicos.setText("Clientes Esporádicos");
        btnClientesEsporadicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesEsporadicosActionPerformed(evt);
            }
        });

        btnClientesFrequentes.setBackground(new java.awt.Color(220, 220, 220));
        btngrPessoas.add(btnClientesFrequentes);
        btnClientesFrequentes.setText("Clientes Frequentes");
        btnClientesFrequentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesFrequentesActionPerformed(evt);
            }
        });

        btnFuncionarios.setBackground(new java.awt.Color(220, 220, 220));
        btngrPessoas.add(btnFuncionarios);
        btnFuncionarios.setText("Funcionários");
        btnFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionariosActionPerformed(evt);
            }
        });

        listaPessoas.setEnabled(false);

        btnEntrarNoShopping.setText("Entrar no shopping");
        btnEntrarNoShopping.setEnabled(false);
        btnEntrarNoShopping.setFocusable(false);
        btnEntrarNoShopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarNoShoppingActionPerformed(evt);
            }
        });

        btnComprar.setText("Comprar em uma loja");
        btnComprar.setEnabled(false);
        btnComprar.setFocusable(false);
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        btnSairDoShopping.setText("Sair do shopping");
        btnSairDoShopping.setEnabled(false);
        btnSairDoShopping.setFocusable(false);
        btnSairDoShopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairDoShoppingActionPerformed(evt);
            }
        });

        painelDadosPessoas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelLocalizacaoPessoa.setText("Localização: -");
        labelLocalizacaoPessoa.setEnabled(false);

        labelVeiculoPessoa.setText("Veículo: -");
        labelVeiculoPessoa.setEnabled(false);

        labelGastosPessoa.setText("Valor em Compras: -");
        labelGastosPessoa.setEnabled(false);

        labelEstacionamentoPessoa.setText("Estacionamento:");
        labelEstacionamentoPessoa.setEnabled(false);

        javax.swing.GroupLayout painelDadosPessoasLayout = new javax.swing.GroupLayout(painelDadosPessoas);
        painelDadosPessoas.setLayout(painelDadosPessoasLayout);
        painelDadosPessoasLayout.setHorizontalGroup(
            painelDadosPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosPessoasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLocalizacaoPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelVeiculoPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelGastosPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelEstacionamentoPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelDadosPessoasLayout.setVerticalGroup(
            painelDadosPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosPessoasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLocalizacaoPessoa)
                .addGap(18, 18, 18)
                .addComponent(labelVeiculoPessoa)
                .addGap(18, 18, 18)
                .addComponent(labelGastosPessoa)
                .addGap(18, 18, 18)
                .addComponent(labelEstacionamentoPessoa)
                .addContainerGap())
        );

        javax.swing.GroupLayout painelPessoasLayout = new javax.swing.GroupLayout(painelPessoas);
        painelPessoas.setLayout(painelPessoasLayout);
        painelPessoasLayout.setHorizontalGroup(
            painelPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separadorPessoas)
            .addGroup(painelPessoasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloPessoas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(painelDadosPessoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEntrarNoShopping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listaPessoas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSairDoShopping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnComprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelPessoasLayout.createSequentialGroup()
                        .addGroup(painelPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnClientesEsporadicos)
                            .addComponent(btnClientesFrequentes)
                            .addComponent(btnFuncionarios))
                        .addGap(0, 108, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelPessoasLayout.setVerticalGroup(
            painelPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPessoasLayout.createSequentialGroup()
                .addComponent(tituloPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separadorPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClientesEsporadicos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClientesFrequentes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFuncionarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEntrarNoShopping, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnComprar)
                .addGap(18, 18, 18)
                .addComponent(btnSairDoShopping, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(painelDadosPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(220, 220, 220));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Estacionamento");

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Vagas de carro");

        VagasCarroDisponiveis.setText("Disponíveis: 200");

        VagasCarroOcupadas.setText("Ocupadas: 0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addComponent(VagasCarroDisponiveis, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(VagasCarroOcupadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VagasCarroDisponiveis)
                .addGap(27, 27, 27)
                .addComponent(VagasCarroOcupadas)
                .addGap(0, 57, Short.MAX_VALUE))
        );

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Vagas de moto");

        VagasMotoDisponiveis.setText("Disponíveis: 50");

        VagasMotoOcupadas.setText("Ocupadas: 0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4)
                    .addComponent(VagasMotoDisponiveis, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(VagasMotoOcupadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VagasMotoDisponiveis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(VagasMotoOcupadas)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(220, 220, 220));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Lojas");

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        textProdutosEmEstoque.setText("Estoque total: 0 itens, totalizando 0 peças");

        textStatusLoja.setText("Status: fechada");

        textFuncionarios.setText("Funcionários: 0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(textFuncionarios)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(textStatusLoja)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(textProdutosEmEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(textStatusLoja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textFuncionarios)
                .addGap(12, 12, 12)
                .addComponent(textProdutosEmEstoque)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton7.setText("Abrir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Fechar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        nomesLojas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        nomesLojas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomesLojasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nomesLojas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(nomesLojas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout painelCategoriasLayout = new javax.swing.GroupLayout(painelCategorias);
        painelCategorias.setLayout(painelCategoriasLayout);
        painelCategoriasLayout.setHorizontalGroup(
            painelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCategoriasLayout.createSequentialGroup()
                .addComponent(painelPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        painelCategoriasLayout.setVerticalGroup(
            painelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCategoriasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelPessoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelCategoriasLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        menuClientes.setText("Clientes");
        menuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClientesActionPerformed(evt);
            }
        });

        menuCadastrarCliente.setText("Cadastrar Cliente");
        menuCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarClienteActionPerformed(evt);
            }
        });
        menuClientes.add(menuCadastrarCliente);

        menuRemoverCliente.setText("Remover Cliente");
        menuRemoverCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemoverClienteActionPerformed(evt);
            }
        });
        menuClientes.add(menuRemoverCliente);

        menuRelatorioClientes.setText("Relatório de Clientes");
        menuRelatorioClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioClientesActionPerformed(evt);
            }
        });
        menuClientes.add(menuRelatorioClientes);

        barraMenu.add(menuClientes);

        menuFuncionarios.setText("Funcionários");

        menuCadastrarFuncionario.setText("Cadastrar Funcionário");
        menuCadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarFuncionarioActionPerformed(evt);
            }
        });
        menuFuncionarios.add(menuCadastrarFuncionario);

        menuRemoverFuncionario.setText("Remover Funcionário");
        menuRemoverFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemoverFuncionarioActionPerformed(evt);
            }
        });
        menuFuncionarios.add(menuRemoverFuncionario);

        menuRelatorioFuncionarios.setText("Relatório de Funcionários");
        menuRelatorioFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioFuncionariosActionPerformed(evt);
            }
        });
        menuFuncionarios.add(menuRelatorioFuncionarios);

        barraMenu.add(menuFuncionarios);

        menuVeiculos.setText("Veículos");

        menuCadastrarVeiculo.setText("Cadastrar Veículo");
        menuCadastrarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarVeiculoActionPerformed(evt);
            }
        });
        menuVeiculos.add(menuCadastrarVeiculo);

        menuRemoverVeiculo.setText("Remover Veículo");
        menuRemoverVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemoverVeiculoActionPerformed(evt);
            }
        });
        menuVeiculos.add(menuRemoverVeiculo);

        menuRelatorioVeiculos.setText("Relatório de Veículos");
        menuRelatorioVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioVeiculosActionPerformed(evt);
            }
        });
        menuVeiculos.add(menuRelatorioVeiculos);

        barraMenu.add(menuVeiculos);

        menuLojas.setText("Lojas");

        menuCadastrarLoja.setText("Cadastrar Loja");
        menuCadastrarLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarLojaActionPerformed(evt);
            }
        });
        menuLojas.add(menuCadastrarLoja);

        menuRemoverLoja.setText("Remover Loja");
        menuRemoverLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemoverLojaActionPerformed(evt);
            }
        });
        menuLojas.add(menuRemoverLoja);

        jMenu8.setText("Atualizar estoque");

        jMenuItem17.setText("Adicionar novo item");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem17);

        jMenuItem18.setText("Atualizar um item existente");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem18);

        menuLojas.add(jMenu8);

        barraMenu.add(menuLojas);

        menuEstacionamento.setText("Estacionamento");

        menuAlterarVagas.setText("Alterar Relação de Vagas");
        menuAlterarVagas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAlterarVagasActionPerformed(evt);
            }
        });
        menuEstacionamento.add(menuAlterarVagas);

        barraMenu.add(menuEstacionamento);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelShopping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelShopping, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnComprarActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(nomesLojas.getItemAt(0).equals("Nenhuma loja cadastrada")){
            return;
        }
        if(shopping.getLojas(false).length > 0){
            String nome = nomesLojas.getItemAt(nomesLojas.getSelectedIndex());
            shopping.abrirLoja(nome);
            textStatusLoja.setText((shopping.isLojaAberta(nome))?"Status: aberta":"Status: fechada");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void menuAlterarVagasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAlterarVagasActionPerformed
        new AlterarVagas(this).setVisible(true);
    }//GEN-LAST:event_menuAlterarVagasActionPerformed

    private void menuRemoverLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemoverLojaActionPerformed
        new RemoverLoja(this).setVisible(true);
    }//GEN-LAST:event_menuRemoverLojaActionPerformed

    private void menuCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarClienteActionPerformed
        new TelaCadastroCliente(this).setVisible(true);
    }//GEN-LAST:event_menuCadastrarClienteActionPerformed

    private void menuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuClientesActionPerformed

    private void menuCadastrarLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarLojaActionPerformed
        new NovaLoja(this).setVisible(true);
    }//GEN-LAST:event_menuCadastrarLojaActionPerformed

    private void menuCadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarFuncionarioActionPerformed
        new TelaCadastroFuncionario(this).setVisible(true);
    }//GEN-LAST:event_menuCadastrarFuncionarioActionPerformed

    private void menuCadastrarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarVeiculoActionPerformed
        new TelaCadastroVeiculo(this).setVisible(true);
    }//GEN-LAST:event_menuCadastrarVeiculoActionPerformed

    private void menuRemoverClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemoverClienteActionPerformed
        new TelaRemoverCliente(this).setVisible(true);
    }//GEN-LAST:event_menuRemoverClienteActionPerformed

    private void menuRemoverFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemoverFuncionarioActionPerformed
        new TelaRemoverFuncionario(this).setVisible(true);
    }//GEN-LAST:event_menuRemoverFuncionarioActionPerformed

    private void menuRemoverVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemoverVeiculoActionPerformed
        new TelaRemoverVeiculo(this).setVisible(true);
    }//GEN-LAST:event_menuRemoverVeiculoActionPerformed

    private void nomesLojasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomesLojasActionPerformed
        Loja loja = shopping.getLoja((String) nomesLojas.getSelectedItem());
        if(loja != null){
            int[] estoque = loja.getEstoque();
            String status = (loja.isAberto())?"aberta":"fechada";
            String[] nomes = loja.getFuncionarios();
            int funcionarios = (nomes == null)? 0: nomes.length;
            
            textStatusLoja.setText("Status: " + status);
            textFuncionarios.setText("Funcionários: " + funcionarios);
            textProdutosEmEstoque.setText("Estoque total: " + estoque[0] + " itens, totalizando " + estoque[1] + " peças");
        }
    }//GEN-LAST:event_nomesLojasActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(nomesLojas.getItemAt(0).equals("Nenhuma loja cadastrada")){
            return;
        }
        if(shopping.getLojas(false).length > 0){
            String nome = nomesLojas.getItemAt(nomesLojas.getSelectedIndex());
            shopping.fecharLoja(nome);
            textStatusLoja.setText((shopping.isLojaAberta(nome))?"Status: aberta":"Status: fechada");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void menuRelatorioClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioClientesActionPerformed
        new TelaRelatorioClientes(this).setVisible(true);
    }//GEN-LAST:event_menuRelatorioClientesActionPerformed

    private void menuRelatorioFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioFuncionariosActionPerformed
        new TelaRelatorioFuncionarios(this).setVisible(true);
    }//GEN-LAST:event_menuRelatorioFuncionariosActionPerformed

    private void menuRelatorioVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioVeiculosActionPerformed
        new TelaRelatorioVeiculos(this).setVisible(true);
    }//GEN-LAST:event_menuRelatorioVeiculosActionPerformed

    private void btnAbrirShoppingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirShoppingActionPerformed
        boolean sucesso = shopping.abrir();
        
        if (sucesso) {
            labelStatusShopping.setText("Status: aberto");
            painelCategorias.setEnabled(true);
        }
    }//GEN-LAST:event_btnAbrirShoppingActionPerformed

    private void btnFecharShoppingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharShoppingActionPerformed
        boolean sucesso = shopping.fechar();
        
        if (sucesso) {
            labelStatusShopping.setText("Status: fechado");
        }
    }//GEN-LAST:event_btnFecharShoppingActionPerformed

    private void btnClientesFrequentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesFrequentesActionPerformed
        updateExibicao();
    }//GEN-LAST:event_btnClientesFrequentesActionPerformed

    private void btnClientesEsporadicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesEsporadicosActionPerformed
        updateExibicao();
    }//GEN-LAST:event_btnClientesEsporadicosActionPerformed

    private void btnFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionariosActionPerformed
        updateExibicao();
    }//GEN-LAST:event_btnFuncionariosActionPerformed

    private void btnEntrarNoShoppingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarNoShoppingActionPerformed
        Pessoa pessoa;
        
        if (btnClientesEsporadicos.isSelected()) {
            pessoa = clientesEsporadicos.get(listaPessoas.getSelectedIndex());
        } else if (btnClientesFrequentes.isSelected()) {
            pessoa = clientesFrequentes.get((String) listaPessoas.getSelectedItem());
        } else {
            pessoa = funcionarios.get((String) listaPessoas.getSelectedItem());
        }
        if (pessoa.getLocalizacao() == null) {
            pessoa.entrar(shopping);
        } else {
            JOptionPane.showMessageDialog(this, "O cliente já está no shopping.", "Erro: Entrar no Shopping", JOptionPane.ERROR_MESSAGE);
        }
        updateExibicao();
    }//GEN-LAST:event_btnEntrarNoShoppingActionPerformed

    private void btnSairDoShoppingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairDoShoppingActionPerformed
        Pessoa pessoa;
        
        if (btnClientesEsporadicos.isSelected()) {
            pessoa = clientesEsporadicos.get(listaPessoas.getSelectedIndex());
        } else if (btnClientesFrequentes.isSelected()) {
            pessoa = clientesFrequentes.get((String) listaPessoas.getSelectedItem());
        } else {
            pessoa = funcionarios.get((String) listaPessoas.getSelectedItem());
        }
        if (pessoa.getLocalizacao() != null) {
            pessoa.sair(shopping);
        } else {
            JOptionPane.showMessageDialog(this, "O cliente não está no shopping.", "Erro: Sair do Shopping", JOptionPane.ERROR_MESSAGE);
        }
        updateExibicao();
    }//GEN-LAST:event_btnSairDoShoppingActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        String[] nomesLojas = shopping.getLojas(false);
        if((nomesLojas.length == 0)||(nomesLojas == null)){
            JOptionPane.showMessageDialog(null, "Não há lojas cadastradas!", "erro!", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        new IncluirEstoqueNovo(this).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        String[] nomesLojas = shopping.getLojas(false);                                                             //primeiro vemos se temos lojas cadastradas
        if(nomesLojas.length == 0){
            JOptionPane.showMessageDialog(null, "Não há lojas cadastradas!", "erro!", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        String[] nomesLojas2 = shopping.getLojas(true);                                                                       //agora vemos se temos lojas com produtos cadastrados
        if(nomesLojas2 == null){
            JOptionPane.showMessageDialog(null, "Nenhuma das lojas possui produtos registrados!", "erro!", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        
        new IncluirEstoqueExistente(this).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel VagasCarroDisponiveis;
    private javax.swing.JLabel VagasCarroOcupadas;
    private javax.swing.JLabel VagasMotoDisponiveis;
    private javax.swing.JLabel VagasMotoOcupadas;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnAbrirShopping;
    private javax.swing.JRadioButton btnClientesEsporadicos;
    private javax.swing.JRadioButton btnClientesFrequentes;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnEntrarNoShopping;
    private javax.swing.JButton btnFecharShopping;
    private javax.swing.JRadioButton btnFuncionarios;
    private javax.swing.JButton btnSairDoShopping;
    private javax.swing.ButtonGroup btngrPessoas;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelEstacionamentoPessoa;
    private javax.swing.JLabel labelGastosPessoa;
    private javax.swing.JLabel labelLocalizacaoPessoa;
    private javax.swing.JLabel labelPessoas;
    private javax.swing.JLabel labelStatusShopping;
    private javax.swing.JLabel labelVeiculoPessoa;
    private javax.swing.JComboBox<String> listaPessoas;
    private javax.swing.JMenuItem menuAlterarVagas;
    private javax.swing.JMenuItem menuCadastrarCliente;
    private javax.swing.JMenuItem menuCadastrarFuncionario;
    private javax.swing.JMenuItem menuCadastrarLoja;
    private javax.swing.JMenuItem menuCadastrarVeiculo;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenu menuEstacionamento;
    private javax.swing.JMenu menuFuncionarios;
    private javax.swing.JMenu menuLojas;
    private javax.swing.JMenuItem menuRelatorioClientes;
    private javax.swing.JMenuItem menuRelatorioFuncionarios;
    private javax.swing.JMenuItem menuRelatorioVeiculos;
    private javax.swing.JMenuItem menuRemoverCliente;
    private javax.swing.JMenuItem menuRemoverFuncionario;
    private javax.swing.JMenuItem menuRemoverLoja;
    private javax.swing.JMenuItem menuRemoverVeiculo;
    private javax.swing.JMenu menuVeiculos;
    private javax.swing.JComboBox<String> nomesLojas;
    private javax.swing.JPanel painelCategorias;
    private javax.swing.JPanel painelDadosPessoas;
    private javax.swing.JPanel painelPessoas;
    private javax.swing.JPanel painelShopping;
    private javax.swing.JSeparator separadorPessoas;
    private javax.swing.JLabel textFuncionarios;
    private javax.swing.JLabel textProdutosEmEstoque;
    private javax.swing.JLabel textStatusLoja;
    private javax.swing.JLabel tituloPessoas;
    private javax.swing.JLabel tituloShopping;
    // End of variables declaration//GEN-END:variables


}
