package trabalhotp1g17;

import java.util.ArrayList;

public class Loja implements Estabelecimento {

    private String nome;
    private TipoLoja tipo;
    private boolean aberto = false;
    private final ArrayList<Funcionario> funcionarios = new ArrayList<>();            //Apenas a presença dos funcionários será contabilizada nas lojas. Assume-se para este modelo
    private final ArrayList<Produto> produtos = new ArrayList<>();                    //que os clientes entram, compram o que querem e vão embora. Assim, somente os funcionarios são levados em conta


    //Construtor//////////////////////////////////////////////////////////////////////////////////////////////////////

    public Loja(String nome, TipoLoja tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    //Métodos da interface//////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public boolean isAberto() {
        return this.aberto;
    }

    @Override
    public boolean abrir() {
        if (this.aberto) {
            System.out.println("A loja " + this.nome + " já está aberta.");
            return false;
        }
        System.out.println("A loja " + this.nome + " abriu.");
        this.aberto = true;
        return true;
    }

    @Override
    public boolean fechar() {
        if (!this.aberto) {
            System.out.println("A loja " + this.nome + " já está fechada.");
            return false;
        } else if (alguemTrabalhando()) {
            System.out.println("Ainda há funcionários trabalhando na loja " + this.nome + ".");
            return false;
        }
        System.out.println("A loja " + this.nome + " fechou.");
        this.aberto = false;
        return true;
    }

    @Override
    public void aoEntrar(Pessoa pessoa) {                                    //tem que implementar ainda
    }

    @Override
    public void aoSair(Pessoa pessoa) {                                      //tem que implementar ainda
    }

    //Métodos exclusivos desta classe////////////////////////////////////////////////////////////////////////////////////

    public boolean contratar(Funcionario f) {
        f.setLoja(this);
        this.funcionarios.add(f);
        return true;
    }

    public boolean demitir(Funcionario f) {
        if (!this.funcionarios.contains(f)) {
            System.out.println("A loja " + this.nome + "não possui esta pessoa no quadro de funcionários");
            return false;
        }
        this.funcionarios.remove(f);
        return true;
    }

    /**
     * Um objeto da classe Produto contém três atributos: nome, preço e quantidade.
     * Este método abastece o estoque de determinado produto somando o estoque atual
     * com o do produto a ser inserido.
     * @param produto o produto a ser abastecido.
     * @return true, se o abastecimento foi realizado, false caso contrário.
     */
    public boolean abastecer(Produto produto) {
        String nome = produto.getNome();
        for (Produto p : produtos) {
            if (nome.equals(p.getNome())) {
                p.setQuantidade(p.getQuantidade() + produto.getQuantidade());
                return true;
            }
        }
        return false;
    }

    /**
     * Este método varre os produtos do catálogo em busca do que se deseja vender.
     * O produto é encontrado pelo nome. Caso a loja não tenha esse produto em estoque ou
     * a quantidade a ser vendida seja maior que o estoque disponível, a venda não é realizada.
     *
     * @param produto o produto a ser vendido.
     * @return true, se a venda foi realizada, false caso contrário.
     */
    public boolean vender(Produto produto) {
        if (this.produtos.contains(produto)) {
            for (Produto p : produtos) {
                if (p.getNome().equals(produto.getNome())) {
                    int diff = p.getQuantidade() - produto.getQuantidade();

                    if (diff >= 0) {
                        p.setQuantidade(diff);
                    }
                    System.out.println("Venda não realizada, não há quantidade suficiente do produto " + produto.getNome() + ".");
                    return false;
                }
            }
        }
        return false;
    }

    private boolean alguemTrabalhando() {
        for (Funcionario f : funcionarios) {
            if (f.isTrabalhando()) {
                return true;
            }
        }
        return false;
    }
}
