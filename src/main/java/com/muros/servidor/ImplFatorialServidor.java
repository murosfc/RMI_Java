package com.muros.servidor;

//importação dos pacotes RMI
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.UUID;
     
//define a classe servidor que implementa a interface remota Fatorial
public class ImplFatorialServidor extends UnicastRemoteObject implements FatInterface{
    private static final long serialVersionUID = 1L;
     
    protected ImplFatorialServidor() throws RemoteException {
        super();
    }
     
@Override
//implementa o corpo do código para calcular o fatorial
//recebe o número passado pelo cliente
public int calcularFatorial(int numero) throws RemoteException, ServerNotActiveException{
    //gera um identificador único para o cliente 
    String uuid = UUID.randomUUID().toString();
    System.err.println("O cliente " + uuid + " de IP(" + getClientHost() + 
            ") começou a calcular o fatorial de " + numero + "!");
		
    //inicia um ojeto para guardar a hora inicial da execução do fatorial
    TempoDeOperacao ObjCalcTempo = new TempoDeOperacao();
    
    //realiza o cálculo do fatorial
    int resultadoFatorial = this.fatorial(numero);
    
     //exibe o tempo que o cliente levou para executar o cálculo do fatorial
    System.out.println("O cliente " + uuid + " de IP(" + getClientHost() + ") levou " +
            ObjCalcTempo.finish() + " ns para calcular o fatorial de " + numero + "!");
   
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

