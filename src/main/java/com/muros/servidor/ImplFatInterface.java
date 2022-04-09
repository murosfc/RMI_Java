package com.muros.servidor;

//importação dos pacotes RMI
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;

import com.muros.servidor.TempoDeOperacao;
import com.muros.servidor.FatInterface;
import java.rmi.server.UnicastRemoteObject;
     
//define a classe servidor que implementa a interface remota Fatorial
public class ImplFatInterface extends UnicastRemoteObject implements FatInterface{
    private static final long serialVersionUID = 1L;
    
    //o método construtor do UnicastRemoteObject exporta o objeto para o RMI
    protected ImplFatInterface() throws RemoteException {
        super();
    }
     
//implementa o corpo do código para calcular o fatorial
//recebe o número passado pelo cliente
public int calcularFatorial(int numero) throws RemoteException, ServerNotActiveException{   
    System.err.println("O cliente de IP " + getClientHost() + 
            ", solicitou o cálculo do fatorial de " + numero + "!\n");
		
    /*inicia um ojeto para guardar a hora inicial da execução do fatorial
    apenas para mostrar que o servidor pode manipular outros objetos que não são retornados ao cliente,
    e são utilizados para manipular o solicitado*/
    TempoDeOperacao ObjCalcTempo = new TempoDeOperacao();
    
    //realiza o cálculo do fatorial
    int resultadoFatorial = this.fatorial(numero);
    
     //exibe o tempo que o cliente levou para executar o cálculo do fatorial
    System.out.println("O cliente de IP " + getClientHost() + " levou " +
            ObjCalcTempo.finish() + " ns para calcular o fatorial de " + numero + "!\n");
   
    //retorna o resultado para o cliente
    return resultadoFatorial;
	}
//define um método recursivo para calcular o fatorial do número passado
private int fatorial(int numero) {		
        if(numero <= 1) {
                return 1;
        } else {
                return numero * fatorial(numero - 1);
        }		
}
}

