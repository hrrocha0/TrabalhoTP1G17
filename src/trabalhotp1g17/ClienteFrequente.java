package trabalhotp1g17;

//Subclasse de Pessoa. Armazena o nome e o CPF do cliente, e o valor de isenção é de R$50,00.
public class ClienteFrequente extends Pessoa {
    private String nome;    // O nome do cliente
    private String cpf;     // O CPF do cliente

    // Construtores

    public ClienteFrequente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public ClienteFrequente(String nome, String cpf, Veiculo veiculo, Ticket ticket, Estabelecimento localizacao, double gastoTotal) {
        super(veiculo, ticket, localizacao, gastoTotal);
        this.nome = nome;
        this.cpf = cpf;
    }

    // Método abstrato de Pessoa
    @Override
    public double getValorIsencao() {
        return 50.0;
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
}
