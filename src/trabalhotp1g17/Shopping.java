package trabalhotp1g17;

import java.util.ArrayList;
import java.util.HashMap;


public class Shopping implements Estabelecimento {
    private final int[] vagasCarro = {0, 200};                                                        //vagas de carro { ocupadas, totais }
    private final int[] vagasMoto = {0, 50};                                                         //vagas de moto { ocupadas, totais }

    private boolean aberto = false;

    private final ArrayList<ClienteEsporadico> clientesEsporadicos = new ArrayList<>();               //listas e mapas que vão manter os registros de quem está no shopping, divididas por tipo de pessoa
    private final HashMap<String, ClienteFrequente> clientesFrequentes = new HashMap<>();
    private final HashMap<String, Funcionario> funcionarios = new HashMap<>();
    private final HashMap<String, Veiculo> veiculos = new HashMap<>();
    
    private static final HashMap<String, Loja> lojas = new HashMap<>();

    @Override
    public boolean aoEntrar(Pessoa pessoa) {
        TipoVeiculo tipoDoVeiculo = pessoa.getVeiculo().getTipo();

        if (tipoDoVeiculo == null) {
            System.out.println("Chegou uma nova pessoa a pé.");
        } else {
            System.out.print("Chegou uma nova pessoa dirigindo");
            if ((tipoDoVeiculo == TipoVeiculo.CARRO) && (vagasCarro[0] < vagasCarro[1])) {
                System.out.println(" um carro.");
                this.vagasCarro[0]++;
            } else if ((tipoDoVeiculo == TipoVeiculo.MOTO) && (vagasMoto[0] < vagasMoto[1])) {
                System.out.println(" uma moto.");
                this.vagasMoto[0]++;
            } else {
                System.out.println(", mas ela não pode estacionar. Não há vagas para o veículo dela (" + tipoDoVeiculo + ").");
                return false;
            }
        }
        add(pessoa);
        return true;
    }

    @Override
    public boolean aoSair(Pessoa pessoa) {
        if (!contains(pessoa)) {
            System.out.println("O cliente especificado não está no shopping.");
            return false;
        }

        TipoVeiculo tipoDoVeiculo = pessoa.getVeiculo().getTipo();
        System.out.print("A pessoa foi embora");

        if (tipoDoVeiculo == null) {
            System.out.println(" a pé.");
        } else {
            if (tipoDoVeiculo == TipoVeiculo.CARRO) {
                System.out.println(" de carro.");
                this.vagasCarro[0]--;
            } else if (tipoDoVeiculo == TipoVeiculo.MOTO) {
                System.out.println(" de moto.");
                this.vagasMoto[0]--;
            }
        }
        remove(pessoa);
        return true;
    }

    @Override
    public boolean isAberto() {
        return this.aberto;
    }

    @Override
    public boolean abrir() {
        if (this.aberto) {
            System.out.println("O Shopping já está aberto.");
            return false;
        }
        System.out.println("O Shopping abriu.");
        this.aberto = true;
        return true;
    }

    @Override
    public boolean fechar() {
        if (getTotalDePessoas() == 0) {
            System.out.println("O Shopping fechou.");
            this.aberto = false;
            return true;
        }

        System.out.println("O Shopping não pode ser fechado, ainda há " + getTotalDePessoas() + " pessoas dentro.");
        return false;
    }
    
    @Override
    public String toString() {
        return "Shopping";
    }

    //Métodos privados////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    

    public void add(Loja loja) {
        lojas.put(loja.getNome(), loja);
    }

    public boolean remove(Loja loja) {
        return lojas.remove(loja.getNome()) != null;
    }

    public void add(Pessoa pessoa) {                                            //efetivamente adiciona a pessoa ao contingente inserido no shopping
        if (pessoa instanceof ClienteEsporadico) {
            this.clientesEsporadicos.add((ClienteEsporadico) pessoa);
            return;
        } else if (pessoa instanceof ClienteFrequente) {
            this.clientesFrequentes.put(((ClienteFrequente) pessoa).getNome(), (ClienteFrequente) pessoa);
            return;
        }
        this.funcionarios.put(((Funcionario) pessoa).getNome(),(Funcionario) pessoa);
    }

    public void remove(Pessoa pessoa) {
        if (pessoa instanceof ClienteEsporadico) {
            this.clientesEsporadicos.remove((ClienteEsporadico) pessoa);
            return;
        } else if (pessoa instanceof ClienteFrequente) {
            this.clientesFrequentes.remove(((ClienteFrequente) pessoa).getNome());
            return;
        }
        this.funcionarios.remove(((Funcionario) pessoa).getNome());
    }

    public boolean contains(Pessoa pessoa) {
        if (pessoa instanceof ClienteEsporadico) {
            return this.clientesEsporadicos.contains((ClienteEsporadico) pessoa);
        } else if (pessoa instanceof ClienteFrequente) {
            return this.clientesFrequentes.containsKey(((ClienteFrequente) pessoa).getNome());
        }
        return this.funcionarios.containsKey(((Funcionario) pessoa).getNome());
    }
    
    public void adicionarVeiculo(Veiculo veiculo) {
        this.veiculos.put(veiculo.getPlaca(), veiculo);
    }
    
    public void removerVeiculo(Veiculo veiculo) {
        this.veiculos.remove(veiculo.getPlaca());
    }

    private int getTotalDePessoas() {
        return (this.clientesEsporadicos.size() + this.clientesFrequentes.size() + this.funcionarios.size());
    }

    public boolean setVagasTotais(int vagasDeCarro, int vagasDeMoto) {
        this.vagasCarro[1] = vagasDeCarro;
        this.vagasMoto[1] = vagasDeMoto;
        return true;
    }

    public int[] getVagasCarro() {
        return this.vagasCarro;
    }

    public int[] getVagasMoto() {
        return this.vagasMoto;
    }

    public boolean temVagaCarro() {
        return this.vagasCarro[0] < this.vagasCarro[1];
    }

    public boolean temVagaMoto() {
        return this.vagasMoto[0] < this.vagasMoto[1];
    }
    
    public ClienteEsporadico getClienteEsporadico(int id) {
        return clientesEsporadicos.get(id);
    }
    
    public int getQtdClientesEsporadicos() {
        return clientesEsporadicos.size();
    }
    
    public ClienteFrequente getClienteFrequente(String nome) {
        return clientesFrequentes.get(nome);
    }
    
    public String[] getNomesClientesFrequentes() {
        return clientesFrequentes.keySet().toArray(new String[0]);
    }
    
    public Funcionario getFuncionario(String nome) {
        return funcionarios.get(nome);
    }
    
    public String[] getNomesFuncionarios() {
        return funcionarios.keySet().toArray(new String[0]);
    }
    
    public Veiculo getVeiculo(String placa) {
        return veiculos.get(placa);
    }
    
    public String[] getPlacasVeiculos() {
        return veiculos.keySet().toArray(new String[0]);
    }
 
    public Loja getLoja(String nome) {
        /*if (lojas.size() > 0) {
            for (int i = 0; i < lojas.size(); i++) {
                if (lojas.get(i).getNome().equals(nome)) {
                    return lojas.get(i);
                }
            }
        }
        return null;*/
        return lojas.get(nome);
    }

    public boolean abrirLoja(String nome) {
        // Não é mais necessário
        /*
        int index = 0;
        for (int i = 0; i < lojas.size(); i++) {
            if (lojas.get(i).getNome().equals(nome)) {
                lojas.get(i).abrir();
                index = i;
                break;
            }
        }*/
        Loja loja = lojas.get(nome);

        if (loja != null) {
            return loja.abrir();
        }
        return false;
    }

    public boolean fecharLoja(String nome) {
        /*
        int index = 0;
        for (int i = 0; i < lojas.size(); i++) {
            if (lojas.get(i).getNome().equals(loja)) {
                lojas.get(i).fechar();
                index = i;
                break;
            }
        }*/
        Loja loja = lojas.get(nome);

        if (loja != null) {
            return loja.fechar();
        }
        return false;
    }

    public String[] getLojas() {
        /*
        String[] nomes = new String[lojas.size()];

        for (int i = 0; i < lojas.size(); i++) {
            nomes[i] = lojas.get(i).getNome();
        }
        return nomes;*/
        return lojas.keySet().toArray(new String[0]);
    }
}