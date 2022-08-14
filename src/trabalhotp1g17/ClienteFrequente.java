package trabalhotp1g17;

public class ClienteFrequente extends Pessoa {
    /* TODO:
        - É um pouco estranho que tanto essa classe quanto a Funcionario tenham os atributos nome e cpf, sem
        que exista uma interface;
    */
    private String nome;
    private String cpf;

    public ClienteFrequente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public ClienteFrequente(String nome, String cpf, Veiculo veiculo, Ticket ticket, double gastoTotal) {
        super(veiculo, ticket, gastoTotal);
        this.nome = nome;
        this.cpf = cpf;
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
