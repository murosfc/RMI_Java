package com.muros.servidor;

//importação dos pacotes RMI necessários
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;

//determina que a interface extende de Remote, o que diz que ela pode ter seus métodos invocados por uma máquina virtual não local
public interface FatInterface extends Remote{

//define a assinatura do método calcular e obriga que ele implemente as exceções de Remote e ServerNotActive
    int calcularFatorial(int numero) throws RemoteException, ServerNotActiveException;
	
}
