package trabalhotp1g17;

/*
Subclasse de Pessoa. Tem como atributos o nome e o CPF do funcionário, além da loja onde ele trabalha
e um boolean que indica se o funcionário está trabalhando. Essa classe também possui duas funcionalidades
adicionais: iniciar e finalizar o trabalho.
 */
public class Funcionario extends Pessoa {
    private String nome;    // O nome do funcionário
    private String cpf;     // O CPF do funcionário
    private Loja loja;      // A loja onde o funcionário trabalha
    private boolean trabalhando;    // Indica se o funcionário está trabalhando

    // Construtores

    public Funcionario(String nome, String cpf, Veiculo veiculo, Loja loja) {
        this.nome = nome;
        this.cpf = cpf;
        this.loja = loja;
        this.veiculo = veiculo;
    }

    public Funcionario(String nome, String cpf, Loja loja, Veiculo veiculo, Ticket ticket, boolean dentroDoShopping, double gastoTotal) {
        super(veiculo, ticket, dentroDoShopping, gastoTotal);
        this.nome = nome;
        this.cpf = cpf;
        this.loja = loja;
    }

    // Método abstrato de Pessoa
    @Override
    public double getValorIsencao() {
        return 0.0;
    }

    // Getters e Setters

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
        return trabalhando;
    }

    /*
    Verifica se o funcionário já está trabalhando. Caso esteja, retorna false,
    senão define o atributo trabalhando como true e retorna true.
     */
    public boolean iniciarTrabalho() {
        if (trabalhando) {
            return false;
        }
        trabalhando = true;
        return true;
    }

    /*
    Verifica se o funcionário já está trabalhando. Se não estiver, retorna false,
    no contrário define o atributo trabalhando como false e retorna true.
    */
    public boolean finalizarTrabalho() {
        if (!trabalhando) {
            return false;
        }
        trabalhando = false;
        return true;
    }
}
