package trabalhotp1g17;

public class Ticket {
    
    private static int tolerancia;
    
    private String horarioEntrada;
    private int custo;
    private boolean isento;
    
    
    public Ticket(String horarioEntrada, boolean isIsento){
        this.horarioEntrada = horarioEntrada;
        this.isento = isIsento;
        this.tolerancia = 15;                                       //tolerância de 15 minutos
    }
    
    public String getHoraEntrada(){
        return this.horarioEntrada;
    }
    
    public int getPermanencia(String horarioAtual){                //espera-se uma string do tipo "hh:mm"
        String[] atual = horarioAtual.split(":");
        int[] horaAtual = {Integer.parseInt(atual[0]), Integer.parseInt(atual[1])};    
        String[] entrada = this.horarioEntrada.split(":");
        int[] horaEntrada = {Integer.parseInt(entrada[0]), Integer.parseInt(entrada[1])}; 
      
        int permanencia = 60*(horaAtual[0] - horaEntrada[0]) + (horaAtual[1] - horaEntrada[1]);
        
        return permanencia;                                         //permanencia retornada em minutos
    }
     
    public int updateTicket(String horarioAtual){                 //atualiza custo do estacionamento
        int horas = (getPermanencia(horarioAtual)/60);
        if(((getPermanencia(horarioAtual) > tolerancia)&&(!isIsento()))){
            custo = 10*(horas + 1);
        }
        else{
            custo = 0;
        }
        return custo;
    }

    public boolean isIsento(){
        return this.isento;
    }

    public void setIsento(boolean isento) {
        this.isento = isento;
    }
}
