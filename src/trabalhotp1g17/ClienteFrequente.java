package trabalhotp1g17;

public class ClienteFrequente extends Pessoa {
    private String nome;
    private String cpf;

    public ClienteFrequente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public ClienteFrequente(String nome, String cpf, Veiculo veiculo, Ticket ticket, Estabelecimento localizacao, double gastoTotal) {
        super(veiculo, ticket, localizacao, gastoTotal);
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public double getValorIsencao() {
        return 50.0;
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
}
