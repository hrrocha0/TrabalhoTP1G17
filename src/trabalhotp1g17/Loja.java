package trabalhotp1g17;

import java.util.ArrayList;

public class Loja implements Estabelecimento {
    
    private String nome;
    private TipoLoja tipo;
    private boolean aberto = false;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();            //apenas a presença dos funcionários será contabilizada nas lojas. Assume-se para este modelo
    private ArrayList<Produto> produtos = new ArrayList<>();                    //que os clientes entram, compram o que querem e vão embora. Assim, somente os funcionarios são levados em conta

    
    //Construtor//////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public Loja(String nome, TipoLoja tipo){
        this.nome = nome;
        this.tipo = tipo;
    }
    
    //Métodos da interface//////////////////////////////////////////////////////////////////////////////////////////////
    
    @Override
    public boolean isAberto(){
        return this.aberto;
    }

    @Override
    public boolean abrir(){
        if(this.aberto){
            System.out.println("A loja " + this.nome + " já está aberta.");
            return false;
        }
        System.out.println("A loja " + this.nome + " abriu.");
        this.aberto = true;
        return true;
    }
    
    @Override
    public boolean fechar(){
        if(!this.aberto){
            System.out.println("A loja " + this.nome + " já está fechada.");
            return false;
        }
        else if(alguemTrabalhando()){
            System.out.println("Ainda há funcionários trabalhando na loja " + this.nome + ".");
            return false;
        }
        System.out.println("A loja " + this.nome + " fechou.");
        this.aberto = false;
        return true;
    }
    
    @Override
    public boolean aoEntrar(Pessoa pessoa) {                                    //tem que implementar ainda
        return true;  //TODO
    }
    
    @Override
    public boolean aoSair(Pessoa pessoa) {                                      //tem que implementar ainda
        return true;    //TODO
    }    

    
    //Métodos exclusivos desta classe////////////////////////////////////////////////////////////////////////////////////
    
   
    public boolean contratar(Funcionario f){
        f.setLoja(this); 
        this.funcionarios.add(f);
        return true;
    }
    
    public boolean demitir(Funcionario f){
        if(!this.funcionarios.contains(f)){
            System.out.println("A loja " + this.nome + "não possui esta pessoa no quadro de funcionários");
            return false;
        }
        this.funcionarios.remove(f);
        return true;
    }
    
    public void abastecer(Produto produto){                                     //um objeto da classe Produto contém três atributos: nome, preço e quantidade.
        String nome = produto.getNome();                                        //com esta função e estes três parâmetros é possível, de maneira relativamente elegante,
        for (Produto p : produtos){                                             //modificarmos o estoque e o preço de produtos já existentes de maneira unificada. 
            if (nome.equals(p.getNome())){                                      //a função simplesmente soma o estoque atual com o do produto a ser inserido
                Produto prod = p;                                               //e substitui o preço vigente até então pelo passado no produto argumento da função.
                produtos.remove(p);                                             //removemos a informação do estoque antigo para mais abaixo substituir pelo novo;
                prod.setQuantidade(prod.getQuantidade() + produto.getQuantidade());   
                prod.setPreco(produto.getPreco());
                produtos.add(prod);                                             //alteramos os atributos e devolvemos à lista o produto atualizado
                return;
            }
        }
    }
    
    public boolean vender(Produto produto){
        if(this.produtos.contains(produto)){
            for(int i = 0; i < produtos.size(); i++){                                                       //vamos varrer os produtos do catálogo em busca do que deseja-se vender
                if(produtos.get(i).getNome().equals(produto.getNome())){                                    //encontramos o porduto pelo nome
                    int diff = produtos.get(i).getQuantidade() - produto.getQuantidade();                   //diff = estoque - vendidos
                    if(diff >= 0){                                                                          //se diff >= 0, significa que há produtos suficientes para serem vendidos
                        produtos.get(i).setQuantidade(diff);                                                //e aí nesse caso, diff é o que resta em estoque após a venda
                        return true;
                    }                                                                                       //caso diff < 0, a venda não é realizada
                    System.out.println("Venda não realizada, não há quantidade suficiente do produto " + produto.getNome() + ".");
                    return false;
                }
            }
        }
        return false;
    }
 
    private boolean alguemTrabalhando(){
        for(Funcionario f : funcionarios){
            if (f.isTrabalhando()){
            return true;
            }
        }
        return false;
    }
}
