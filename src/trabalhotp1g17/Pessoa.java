package trabalhotp1g17;

import java.util.ArrayList;

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
    protected boolean dentroDoShopping;  // A localização da pessoa
    protected ArrayList<Produto> produtosComprados = new ArrayList<>(); // Os produtos comprados pela pessoa

    // Construtor simplificado, que inicializa o objeto com valores padrão
    public Pessoa() {
        this(null, null, false, 0.0);
    }

    // Construtor completo, que recebe como parâmetros a maioria dos atributos
    public Pessoa(Veiculo veiculo, Ticket ticket, boolean dentroDoShopping, double gastoTotal) {
        this.veiculo = veiculo;
        this.ticket = ticket;
        this.dentroDoShopping = dentroDoShopping;
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
            return false;
        }
        if (!shopping.isAberto()) {
            return false;
        }
        if (!dentroDoShopping) {
            return false;
        }
        if (!loja.vender(produto)) {
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
    public boolean entrarNoShopping() {
        if (dentroDoShopping) {
            System.out.println("A pessoa já está no estabelecimento.");
            return false;
        }
        dentroDoShopping = true;
        System.out.println("A pessoa entrou no estabelecimento.");
        return true;
    }

    /*
     Verifica se a pessoa está no estabelecimento. Caso não esteja, retorna false,
     senão define a localização como nula e delega a lógica para o estabelecimento,
     retornando true.
     */
    public boolean sairDoShopping() {
        if (!dentroDoShopping) {
            System.out.println("A pessoa não está no estabelecimento.");
            return false;
        }
        dentroDoShopping = false;
        System.out.println("A pessoa saiu do estabelecimento.");
        return true;
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

    public boolean isDentroDoShopping() {
        return dentroDoShopping;
    }
}
