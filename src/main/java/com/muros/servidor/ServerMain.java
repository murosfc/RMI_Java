package com.muros.servidor;

import java.rmi.Naming;

public class ServerMain {
 
    public static void main(String[] args){
        try {
            //define o objeto remoto que será associado ao nome
            ImplFatorialServidor ojbCalculofatorial = new ImplFatorialServidor();
            Naming.rebind("//localhost:5000", ojbCalculofatorial);            
            System.err.println("O servidor está pronto para receber requisicao de cliente");            
        } catch (Exception e) {
        	System.err.println("Erro no servidor: " + e.toString());
          e.printStackTrace();
        }
	}
	
}

