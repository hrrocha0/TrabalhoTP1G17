package trabalhotp1g17;

public class Funcionario extends Pessoa {
    private String nome;
    private String cpf;
    private Loja loja;
    private boolean trabalhando;

    public Funcionario(String nome, String cpf, Loja loja) {
        this.nome = nome;
        this.cpf = cpf;
        this.loja = loja;
    }

    public Funcionario(String nome, String cpf, Loja loja, Veiculo veiculo, Ticket ticket, Estabelecimento localizacao, double gastoTotal) {
        super(veiculo, ticket, localizacao, gastoTotal);
        this.nome = nome;
        this.cpf = cpf;
        this.loja = loja;
    }

    @Override
    public double getValorIsencao() {
        return 0.0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public boolean isTrabalhando() {
        return this.trabalhando;
    }

    public boolean startTrabalho() {
        if (!this.trabalhando) {
            this.trabalhando = true;
            System.out.println("O funcionário " + this.nome + " começou a trabalhar.");
            return true;
        }
        System.out.println("O funcionário " + this.nome + " já está trabalhando");
        return false;
    }

    public boolean endTrabalho() {
        if (!this.trabalhando) {
            System.out.println("O funcionário " + this.nome + " não está trabalhando.");
            return false;
        }
        this.trabalhando = false;
        System.out.println("O funcionário " + this.nome + " terminou de trabalhar.");
        return true;
    }
}
