package trabalhotp1g17;

public interface Estabelecimento {
    boolean abrir();
    boolean fechar();
    boolean isAberto();
    boolean aoEntrar(Pessoa p);
    boolean aoSair(Pessoa p);
}
