//Classe para cálculo de tempo, isolada da classe de Fatorial
package com.muros.servidor;

import static java.rmi.server.RemoteServer.getClientHost;

public class TempoDeOperacao {
    private long startTime;    

    public TempoDeOperacao() {
        this.startTime = System.nanoTime();        
    }
    
    public long finish(){
    //retorna o tempo levado para cálculo do fatorial (tempo do momento – inicial)
    return System.nanoTime() - this.startTime;
    }
    
    
}
