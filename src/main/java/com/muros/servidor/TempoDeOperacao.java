//Classe para cálculo de tempo, isolada da classe de Fatorial
package com.muros.servidor;

public class TempoDeOperacao {
    private final long startTime;    

    public TempoDeOperacao() {      
        this.startTime = System.nanoTime();        
    }
    
    //retorna o tempo em nanosegundos levado para cálculo do fatorial (tempo do momento – inicial)
    public long finish(){
        return (System.nanoTime() - this.startTime);     
        
    }   
}
