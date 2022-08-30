package trabalhotp1g17;

/*
Representa um veículo. Possui como atributos o tipo do veículo (que pode ser um carro ou uma moto),
além de outras informações como marca, modelo e placa.
 */
public class Veiculo {
    private TipoVeiculo tipo;   // O tipo do veículo
    private String marca;       // A marca do veículo
    private String modelo;      // O modelo do veículo
    private String placa;       // A placa do veículo

    // Construtor

    public Veiculo(TipoVeiculo tipo, String marca, String modelo, String placa) {
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
    }

    // Getters e Setters

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
