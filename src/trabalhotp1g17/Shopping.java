package trabalhotp1g17;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;


public class Shopping implements Estabelecimento {
    private int[] vagasCarro = {0, 200};                                                        //vagas de carro { ocupadas, totais } 
    private int[] vagasMoto = {0, 200};                                                         //vagas de moto { ocupadas, totais }

    private boolean aberto = false;
    
    private ClienteEsporadico dummyCE = new ClienteEsporadico();                                //Um objeto de cada tipo de cliente, usados apenas para descobrir que tipo de pessoa entra
    private ClienteFrequente dummyCF = new ClienteFrequente(null, null, null, null, null, 0);   //no shopping. a pessoa pode ser um cliente esporádico, frequente ou funcionário de lá
    private Funcionario dummyF = new Funcionario(null, null, null, null, null, null, 0);        //
        
    private ArrayList<ClienteEsporadico> clientesEsporadicos = new ArrayList<>();               //listas que vão manter os registros de quem está no shopping, divididas por tipo de pessoa
    private ArrayList<ClienteFrequente> clientesFrequentes = new ArrayList<>();                 
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    @Override
    public boolean aoEntrar(Pessoa pessoa){
        TipoVeiculo tipoDoVeiculo = pessoa.getVeiculo().getTipo();
        
        if (tipoDoVeiculo == null){
            System.out.println("Chegou uma nova pessoa a pé.");
        } 
        else{
            System.out.print("Chegou uma nova pessoa dirigindo");
            if((tipoDoVeiculo == TipoVeiculo.CARRO) && (vagasCarro[0] < vagasCarro[1])){
                System.out.println(" um carro.");
                this.vagasCarro[0]++;
            }
            else if((tipoDoVeiculo == TipoVeiculo.MOTO) && (vagasMoto[0] < vagasMoto[1])){
                System.out.println(" uma moto.");
                this.vagasMoto[0]++;
            }
            else {
                System.out.println(", mas ela não pode estacionar. Não há vagas para o veículo dela (" + tipoDoVeiculo + ").");
                return false;
            }
        }
        add(pessoa);
        return true;
    }

    @Override
    public boolean aoSair(Pessoa pessoa){
        if(!contains(pessoa)){
            System.out.println("O cliente especificado não está no shopping.");
            return false;
        }

        TipoVeiculo tipoDoVeiculo = pessoa.getVeiculo().getTipo();
        System.out.print("A pessoa foi embora");
        
        if (tipoDoVeiculo == null){
            System.out.println(" a pé.");
        } 
        else{
            if(tipoDoVeiculo == TipoVeiculo.CARRO){
                System.out.println(" de carro.");
                this.vagasCarro[0]--;
            }
            else if(tipoDoVeiculo == TipoVeiculo.MOTO){
                System.out.println(" de moto.");
                this.vagasMoto[0]--;
            }
        }
        remove(pessoa);
        return true;
    }
    
    @Override
    public boolean isAberto(){
        return this.aberto;
    }

    @Override
    public boolean abrir(){
        if(this.aberto){
            System.out.println("O Shopping já está aberto.");
            return false;
        }
        System.out.println("O Shopping abriu.");
        this.aberto = true;
        return true;
    }

    @Override
    public boolean fechar(){
        if (getTotalDePessoas() == 0){
            System.out.println("O Shopping fechou.");
            this.aberto = false;
            return true;
        }
         
        System.out.println("O Shopping não pode ser fechado, ainda há " + getTotalDePessoas() + " pessoas dentro.");
        return false;
    }

    //Métodos privados////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    private void add(Pessoa pessoa){                                            //efetivamente adiciona a pessoa ao contingente inserido no shopping
        if (pessoa.getClass() == this.dummyCE.getClass()){
            this.clientesEsporadicos.add((ClienteEsporadico)pessoa);
            return;
        }
        else if (pessoa.getClass() == this.dummyCF.getClass()){
            this.clientesFrequentes.add((ClienteFrequente)pessoa);
            return;
        }
        this.funcionarios.add((Funcionario)pessoa);
    }
    
    private void remove(Pessoa pessoa){
        if (pessoa.getClass() == this.dummyCE.getClass()){
            this.clientesEsporadicos.remove((ClienteEsporadico)pessoa);
            return;
        }
        else if (pessoa.getClass() == this.dummyCF.getClass()){
            this.clientesFrequentes.remove((ClienteFrequente)pessoa);
            return;
        }
        this.funcionarios.remove((Funcionario)pessoa);
    }
    
    private boolean contains(Pessoa pessoa){
        if(pessoa.getClass()==this.dummyCE.getClass()){
            return this.clientesEsporadicos.contains((ClienteEsporadico)pessoa);            
        }
        else if(pessoa.getClass() == this.dummyCF.getClass()){
            return this.clientesFrequentes.contains((ClienteFrequente)pessoa);
        }
        return this.funcionarios.contains((Funcionario)pessoa);
    }
    
    private int getTotalDePessoas(){
        //
        return (this.clientesEsporadicos.size() + this.clientesFrequentes.size() + this.funcionarios.size());
    }
}