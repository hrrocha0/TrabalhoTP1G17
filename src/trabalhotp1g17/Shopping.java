package trabalhotp1g17;

import java.util.ArrayList;
import java.util.HashMap;


public class Shopping implements Estabelecimento {
    private final int[] vagasCarro = {0, 200};                                                        //vagas de carro { ocupadas, totais }
    private final int[] vagasMoto = {0, 50};                                                         //vagas de moto { ocupadas, totais }

    private boolean aberto = false;

    private final ArrayList<ClienteEsporadico> clientesEsporadicos = new ArrayList<>();               //listas e mapas que vão manter os registros de quem está no shopping, divididas por tipo de pessoa
    private final HashMap<String, ClienteFrequente> clientesFrequentes = new HashMap<>();
    private final HashMap<String, Funcionario> funcionarios = new HashMap<>();
    private final HashMap<String, Loja> lojas = new HashMap<>();

    public boolean aoEntrar(Pessoa pessoa) {
        Veiculo veiculo = pessoa.getVeiculo();
            
        if (veiculo == null) {
            System.out.println("Chegou uma nova pessoa a pé.");
        } else {
            System.out.print("Chegou uma nova pessoa dirigindo");
            if ((veiculo.getTipo() == TipoVeiculo.CARRO) && (vagasCarro[0] < vagasCarro[1])) {
                System.out.println(" um carro.");
                this.vagasCarro[0]++;
            } else if ((veiculo.getTipo() == TipoVeiculo.MOTO) && (vagasMoto[0] < vagasMoto[1])) {
                System.out.println(" uma moto.");
                this.vagasMoto[0]++;
            } else {
                System.out.println(", mas ela não pode estacionar. Não há vagas para o veículo dela (" + veiculo.getTipo() + ").");
                return false;
            }
        }
        add(pessoa);
        return true;
    }

    public boolean aoSair(Pessoa pessoa) {
        if (!contains(pessoa)) {
            System.out.println("O cliente especificado não está no shopping.");
            return false;
        }
        
        Veiculo veiculo = pessoa.getVeiculo();
        System.out.print("A pessoa foi embora");

        if (veiculo == null) {
            System.out.println(" a pé.");
        } else {
            if (veiculo.getTipo() == TipoVeiculo.CARRO) {
                System.out.println(" de carro.");
                this.vagasCarro[0]--;
            } else if (veiculo.getTipo() == TipoVeiculo.MOTO) {
                System.out.println(" de moto.");
                this.vagasMoto[0]--;
            }
        }
        remove(pessoa);
        return true;
    }

    @Override
    public boolean isAberto() {
        return this.aberto;
    }

    @Override
    public boolean abrir() {
        if (this.aberto) {
            System.out.println("O Shopping já está aberto.");
            return false;
        }
        System.out.println("O Shopping abriu.");
        this.aberto = true;
        return true;
    }

    @Override
    public boolean fechar() {
        if (getTotalDePessoas() == 0) {
            System.out.println("O Shopping fechou.");
            this.aberto = false;
            return true;
        }

        System.out.println("O Shopping não pode ser fechado, ainda há " + getTotalDePessoas() + " pessoas dentro.");
        return false;
    }

    @Override
    public String toString() {
        return "Shopping";
    }

    //Métodos privados////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void add(Loja loja) {
        lojas.put(loja.getNome(), loja);
    }

    public void remove(Loja loja) {
        lojas.remove(loja.getNome());
    }

    public void add(Pessoa pessoa) {                                            //efetivamente adiciona a pessoa ao contingente inserido no shopping
        if (pessoa instanceof ClienteEsporadico) {
            this.clientesEsporadicos.add((ClienteEsporadico) pessoa);
            return;
        } else if (pessoa instanceof ClienteFrequente) {
            this.clientesFrequentes.put(((ClienteFrequente) pessoa).getNome(), (ClienteFrequente) pessoa);
            return;
        }
        this.funcionarios.put(((Funcionario) pessoa).getNome(), (Funcionario) pessoa);
    }

    public void remove(Pessoa pessoa) {
        if (pessoa instanceof ClienteEsporadico) {
            this.clientesEsporadicos.remove((ClienteEsporadico) pessoa);
            return;
        } else if (pessoa instanceof ClienteFrequente) {
            this.clientesFrequentes.remove(((ClienteFrequente) pessoa).getNome());
            return;
        }
        this.funcionarios.remove(((Funcionario) pessoa).getNome());
    }

    public boolean contains(Pessoa pessoa) {
        if (pessoa instanceof ClienteEsporadico) {
            return this.clientesEsporadicos.contains((ClienteEsporadico) pessoa);
        } else if (pessoa instanceof ClienteFrequente) {
            return this.clientesFrequentes.containsKey(((ClienteFrequente) pessoa).getNome());
        }
        return this.funcionarios.containsKey(((Funcionario) pessoa).getNome());
    }

    private int getTotalDePessoas() {
        return (this.clientesEsporadicos.size() + this.clientesFrequentes.size() + this.funcionarios.size());
    }

    public boolean setVagasTotais(int vagasDeCarro, int vagasDeMoto) {
        this.vagasCarro[1] = vagasDeCarro;
        this.vagasMoto[1] = vagasDeMoto;
        return true;
    }

    public int[] getVagasCarro() {
        return this.vagasCarro;
    }

    public int[] getVagasMoto() {
        return this.vagasMoto;
    }

    public boolean temVagaCarro() {
        return this.vagasCarro[0] < this.vagasCarro[1];
    }

    public boolean temVagaMoto() {
        return this.vagasMoto[0] < this.vagasMoto[1];
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

    public Loja getLoja(String nome) {
        return lojas.get(nome);
    }

    public boolean abrirLoja(String nome) {
        Loja loja = lojas.get(nome);

        if (loja != null) {
            return loja.abrir();
        }
        return false;
    }

    public boolean fecharLoja(String nome) {
        Loja loja = lojas.get(nome);

        if (loja != null) {
            return loja.fechar();
        }
        return false;
    }

    public boolean isLojaAberta(String nome){
       Loja loja = lojas.get(nome);
       if(loja != null){
           return loja.isAberto();
       }
       return false;
    }
    
    public String[] getLojas(boolean somenteLojasComProdutos) {
        
        if(somenteLojasComProdutos){                                            //o código faz este trecho se desejarmos saber a lista das lojas com produtos cadastrados
            int i = 0;
            String[] lojasComProdutos = new String[lojas.size()];
            
            System.out.print("Verificando quais lojas tem produtos... ");
            for(String nome: lojas.keySet()){
                Loja loja = lojas.get(nome);
                
                if(loja.getProdutos() != null){                                 //se há produtos cadastrados na loja, sendo inspecionada
                    System.out.print("loja " + nome + " tem produtos! ");       
                    lojasComProdutos[i] = nome;                                 //adiciona o nome da loja em questão ao arrayList de lojas que possuem produtos
                    i++;
                }
            }                                                                   //o vetor final pode ter elementos null se nem todas as lojas tiverem produtos cadastrados
                        
            System.out.println("");
            if(i == 0){                                                         //se i = 0, nenhuma loja dentre as cadastradas tem produtos registrados no estoque
                System.out.println("Nenhuma loja tem produtos.");
                return null;
            }
                      
            String[] nomesLojas = new String[i];                                //se chagamos até aqui, criamos um novo vetor com apenas o tamanho correspondente ao número de lojas com produtos
            for(int j = 0; j < i; j++){                                         //e populamos esse vetor com as informações obtidas na passagem mais acima
                nomesLojas[j] = lojasComProdutos[j];
                System.out.println("loja " + nomesLojas[j] + " incluida");
            }
            return nomesLojas;                                                  //o vetor final contém o nome SOMENTE das lojas que possuem produtos já cadastrados
        }
        
        String[] nomesLojas = new String[lojas.size()];
        int i = 0;

        for (String nome : lojas.keySet()) {
            nomesLojas[i] = nome;
            i++;
        }
        return nomesLojas;
    }
    
    
    public String[] getLojasAbertas(boolean somenteLojasComProdutos) {
        
        if(somenteLojasComProdutos){                                            //o código faz este trecho se desejarmos saber a lista das lojas com produtos cadastrados
            int i = 0;
            String[] lojasComProdutos = new String[lojas.size()];
            
            System.out.print("Verificando quais lojas tem produtos... ");
            for(String nome: lojas.keySet()){
                Loja loja = lojas.get(nome);
                int[] estoque = loja.getEstoque();
                
                if((estoque[1] > 0)&&(loja.isAberto())){                                              //se há produtos cadastrados na loja, sendo inspecionada
                    System.out.print("loja " + nome + " esta aberta e tem produtos em estoque! ");       
                    lojasComProdutos[i] = nome;                                 //adiciona o nome da loja em questão ao arrayList de lojas que possuem produtos
                    i++;
                }
            }                                                                   //o vetor final pode ter elementos null se nem todas as lojas tiverem produtos cadastrados
                        
            System.out.println("");
            if(i == 0){                                                         //se i = 0, nenhuma loja dentre as cadastradas tem produtos registrados no estoque
                System.out.println("Nenhuma loja tem produtos.");
                return null;
            }
                      
            String[] nomesLojas = new String[i];                                //se chagamos até aqui, criamos um novo vetor com apenas o tamanho correspondente ao número de lojas com produtos
            for(int j = 0; j < i; j++){                                         //e populamos esse vetor com as informações obtidas na passagem mais acima
                nomesLojas[j] = lojasComProdutos[j];
                System.out.println("loja " + nomesLojas[j] + " incluida");
            }
            return nomesLojas;                                                  //o vetor final contém o nome SOMENTE das lojas que possuem produtos já cadastrados
        }
        
        String[] nomes = new String[lojas.size()];
        int i = 0;

        for (String nome : lojas.keySet()) {
            Loja loja = lojas.get(nome);
            
            if(loja.isAberto()){
                nomes[i] = nome;
                i++;
            }
        }
        
        String[] nomesLojas = new String[i];
        
        i = 0;
        for(String s : nomes){
            nomesLojas[i] = s;
            i++;
        }
            
        return nomesLojas;
    }
    
    
    public boolean abasteceEstoqueDaLoja(String nomeLoja, Produto produto){
        lojas.get(nomeLoja).abastecer(produto);
        int[] estoque = lojas.get(nomeLoja).getEstoque();
        System.out.println("Estoque da loja " + nomeLoja + ": " + estoque[0] + " produtos, somando " + estoque[1] + " itens.");
        return true;
    }
}