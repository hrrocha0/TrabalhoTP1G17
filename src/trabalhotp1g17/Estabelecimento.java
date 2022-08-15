package trabalhotp1g17;

import trabalhotp1g17.Pessoa;

public interface Estabelecimento {
    boolean isAberto();
    void aoEntrar(Pessoa pessoa);
    void aoSair(Pessoa pessoa);
}
