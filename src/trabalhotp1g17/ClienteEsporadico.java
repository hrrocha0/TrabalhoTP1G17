package trabalhotp1g17;

//Subclasse de Pessoa. Não possui nenhum método ou atributo adicional e tem como valor de isenção R$100,00.
public class ClienteEsporadico extends Pessoa {
    private int id; // O id do cliente esporádico. É usado para listá-los e diferenciá-los
    
    // Construtor
    
    public ClienteEsporadico(Veiculo veiculo, int id) {
        this.veiculo = veiculo;
        this.id = id;
    }

    // Método abstrato de Pessoa
    @Override
    public double getValorIsencao() {
        return 100.0;
    }
    
    // Getters e Setters
    
    public int getID(){
        return this.id;
    }
}
