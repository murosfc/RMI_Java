package com.muros.servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {
 
    public static void main(String[] args){
        try {
            //configura o nome do sevidor como 127.0.0.1
            System.setProperty("java.rmi.server.hostname", "192.168.1.179");
            
            //cria um objeto que possui o método de cálculo do fatorial
            ImplFatInterface ojbCalculofatorial = new ImplFatInterface();
            
            //Registrar o nome do objeto que será exportado pelo servido e requisitado pelo cliente  
            Registry registro = LocateRegistry.createRegistry(5005);
            
            //faz o bind do stub nomeando como "Fat"
            registro.rebind("Fat",ojbCalculofatorial);
            
            System.out.println("O servidor está pronto para receber requisicao de cliente");            
        } catch (Exception e) {
        	System.err.println("Erro no servidor: " + e.toString());
          e.printStackTrace();
        }
	}	
}

