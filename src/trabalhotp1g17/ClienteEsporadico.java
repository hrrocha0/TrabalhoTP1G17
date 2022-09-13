package trabalhotp1g17;

//Subclasse de Pessoa. Não possui nenhum método ou atributo adicional e tem como valor de isenção R$100,00.
public class ClienteEsporadico extends Pessoa {
    private final int ID;
    
    public ClienteEsporadico(Veiculo veiculo, int ID) {
        this.veiculo = veiculo;
        this.ID = ID;
    }

    // Método abstrato de Pessoa
    @Override
    public double getValorIsencao() {
        return 100.0;
    }
    
    public int getID(){
        return this.ID;
    }
}
