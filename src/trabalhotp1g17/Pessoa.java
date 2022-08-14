package trabalhotp1g17;

import java.util.ArrayList;

public abstract class Pessoa {
    /* TODO:
        - A relação entre cliente e loja/shopping poderia ser unidirecional;
        - Não é necessário que o cliente tenha o método comprar e a loja o metodo vender ao mesmo tempo;
        - O atributo tipo não parece ser necessário. Se for, um enum seria melhor;
        - Essa classe ser abstrata só serve para impedir a instanciação, já que todas as subclasses implementam
        os métodos de maneira igual;
        - Os métodos entrar() e sair() deveriam estar aqui;
        - O atributo que armazena o valor mínimo para a isenção do estacionamento deveria estar aqui, como protected.
        Poderia ser um método abstrato a ser implementado pelas subclasses também;
    */
    //private String tipo;
    protected Veiculo veiculo;
    protected Ticket ticket;
    protected double gastoTotal;
    protected final ArrayList<Produto> produtosComprados = new ArrayList<>();

    public Pessoa() {
        this(null, null, 0.0);
    }

    public Pessoa(Veiculo veiculo, Ticket ticket, double gastoTotal) {
        this.veiculo = veiculo;
        this.ticket = ticket;
        this.gastoTotal = gastoTotal;
    }

    public void comprar(Produto produto) {
        Loja loja = produto.getLoja();
        Shopping shopping = loja.getShopping();

        if (!loja.isAberto() || !shopping.isAberto()) {
            System.out.println("Não foi possível efetuar a compra.");
            return;
        }
        produtosComprados.add(produto);
        gastoTotal += produto.getPreco();
        loja.vender(this, produto);
    }

    /*
    public String getTipo() {
        return tipo;
    }

    public void setTipo() {
        this.tipo = tipo;
    }
    */

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

    public ArrayList<Produto> getProdutosComprados() {
        return produtosComprados;
    }
}
