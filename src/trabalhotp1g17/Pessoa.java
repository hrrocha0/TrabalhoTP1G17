package trabalhotp1g17;

import java.util.ArrayList;
import telas.TelaPrincipal;

/*
 Classe abstrata responsável pela lógica compartilhada entre ClienteEsporadico, ClienteFrequente e Funcionario.
 Pode ou não possuir um veículo e um ticket, e também armazena como argumentos o gasto total do cliente em produtos,
 a sua localização no shopping, e os produtos comprados. Além de getters e setters para alguns dos atributos,
 também possui métodos que realizam as ações de entrada e saída de um estabelecimento.
 */
public abstract class Pessoa {
    protected Veiculo veiculo;  // O veículo da pessoa
    protected Ticket ticket;    // O ticket de estacionamento
    protected double gastoTotal;    // O gasto total da pessoa em produtos
    protected Estabelecimento localizacao;  // A localização da pessoa
    protected ArrayList<Produto> produtosComprados = new ArrayList<>(); // Os produtos comprados pela pessoa

    // Construtor simplificado, que inicializa o objeto com valores padrão
    public Pessoa() {
        this(null, null, null, 0.0);
    }

    // Construtor completo, que recebe como parâmetros a maioria dos atributos
    public Pessoa(Veiculo veiculo, Ticket ticket, Estabelecimento localizacao, double gastoTotal) {
        this.veiculo = veiculo;
        this.ticket = ticket;
        this.localizacao = localizacao;
        this.gastoTotal = gastoTotal;
    }

    // Método abstrato que retorna o valor que a pessoa deve gastar em produtos para receber isenção
    public abstract double getValorIsencao();

    /*
    Retorna se a loja ou o shopping não estiveren abertos, se a localização da pessoa
    não for a loja que vende o produto, ou se a venda não for possível. Na possibilidade
    de compra, adiciona o produto à lista de produtos comprados e aumenta o gasto total
    no preço do produto.
     */
    public boolean comprar(Produto produto, Loja loja, Shopping shopping) {
        if (!loja.isAberto()) {
            System.out.println("A loja está fechada.");
            return false;
        }
        if (!shopping.isAberto()) {
            System.out.println("O shopping está fechado.");
            return false;
        }
        if (!loja.vender(produto)) {
            System.out.println("Não foi possível efetuar a compra.");
            return false;
        }
        produtosComprados.add(produto);
        gastoTotal += produto.getPreco();
        System.out.println("A compra foi realizada com sucesso.");
        
        return true;
    }

    /*
     Verifica se a pessoa está no estabelecimento. Caso esteja, retorna false,
     e no contrário define a localização da pessoa como o estabelecimento. Depois,
     delega a lógica para o estabelecimento e retorna true.
     */
    public boolean entrar(Estabelecimento estabelecimento) {
        if (localizacao == estabelecimento) {
            System.out.println("A pessoa já está no estabelecimento.");
            return false;
        }
        localizacao = estabelecimento;
        //estabelecimento.aoEntrar(this);
        System.out.println("A pessoa entrou no estabelecimento.");
        return true;
    }

    /*
     Verifica se a pessoa está no estabelecimento. Caso não esteja, retorna false,
     senão define a localização como nula e delega a lógica para o estabelecimento,
     retornando true.
     */
    public void sair(Estabelecimento estabelecimento) {
        if (localizacao != estabelecimento) {
            System.out.println("A pessoa não está no estabelecimento.");
            return;
        }
        localizacao = null;
        //estabelecimento.aoSair(this);
        System.out.println("A pessoa saiu do estabelecimento.");
    }

    // Getters e Setters

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public double getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal(double gastoTotal) {
        this.gastoTotal = gastoTotal;
    }

    public Estabelecimento getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Estabelecimento localizacao) {
        this.localizacao = localizacao;
    }
}
