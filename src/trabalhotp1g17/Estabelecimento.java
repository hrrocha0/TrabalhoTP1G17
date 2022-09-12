package trabalhotp1g17;

public interface Estabelecimento {
    boolean abrir();
    boolean fechar();
    boolean isAberto();
    boolean aoEntrar(Pessoa p); // Podem ser movidos para a classe Shopping
    boolean aoSair(Pessoa p);
}
