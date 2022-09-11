package trabalhotp1g17;

//Subclasse de Pessoa. Não possui nenhum método ou atributo adicional e tem como valor de isenção R$100,00.
public class ClienteEsporadico extends Pessoa {
    public ClienteEsporadico(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    // Método abstrato de Pessoa
    @Override
    public double getValorIsencao() {
        return 100.0;
    }
}
