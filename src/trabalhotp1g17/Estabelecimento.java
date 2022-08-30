package trabalhotp1g17;

public interface Estabelecimento {
    boolean abrir();
    boolean fechar();
    boolean isAberto();
    void aoEntrar(Pessoa pessoa);
    void aoSair(Pessoa pessoa);
}
