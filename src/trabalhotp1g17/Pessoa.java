package trabalhotp1g17;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Pessoa {
    protected Veiculo veiculo;
    protected Ticket ticket;
    protected double gastoTotal;
    protected Estabelecimento localizacao;
    protected ArrayList<Produto> produtosComprados = new ArrayList<>();

    public Pessoa() {
        this(null, null, null, 0.0);
    }

    public Pessoa(Veiculo veiculo, Ticket ticket, Estabelecimento localizacao, double gastoTotal) {
        this.veiculo = veiculo;
        this.ticket = ticket;
        this.localizacao = localizacao;
        this.gastoTotal = gastoTotal;
    }

    abstract double getValorIsencao();

    public void comprar(Produto produto, Loja loja, Shopping shopping) {
        if (loja.isAberto() && shopping.isAberto() && localizacao == loja) {
            produtosComprados.add(produto);
            gastoTotal += produto.getPreco();
            loja.vender(produto);
        }
        System.out.println("Não foi possível efetuar a compra.");
    }

    public void entrar(Estabelecimento estabelecimento) {
        if (localizacao == estabelecimento) {
            System.out.println("A pessoa já está no estabelecimento.");
            return;
        }
        localizacao = estabelecimento;
        estabelecimento.aoEntrar(this);
        System.out.println("A pessoa entrou no estabelecimento.");
    }

    public void sair(Estabelecimento estabelecimento) {
        if (localizacao != estabelecimento) {
            System.out.println("A pessoa não está no estabelecimento.");
            return;
        }
        localizacao = null;
        estabelecimento.aoSair(this);
        System.out.println("A pessoa saiu do estabelecimento.");
    }

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

    public Produto[] getProdutosComprados() {
        return produtosComprados.toArray(new Produto[0]);
    }

    public void setProdutosComprados(Produto[] produtosComprados) {
        Collections.addAll(this.produtosComprados, produtosComprados);
    }
}
