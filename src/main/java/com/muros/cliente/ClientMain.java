package com.muros.cliente;

//importação das bibliotecas RMI
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
     
import javax.swing.JOptionPane;
//importação da interface RMI para fatorial
import com.muros.servidor.FatInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
     
public class ClientMain {
    //cria um objeto de interface RMI que vai conter a referência do objeto remoto
    private static FatInterface objServerRef;

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException, ServerNotActiveException {
        Integer numero;
        while (true){
            try{
                //Buscar o registro no servidor especificado
                Registry registro = LocateRegistry.getRegistry("localhost", 5005);

                //Buscar a referencia do objeto exportado pelo servidor no Regitro do RMI
                FatInterface refFat = (FatInterface) registro.lookup("Fat");

                //define a janela para pegar o número do fatorial
                numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número para calcular o fatorial."
                        + "\nOu um número negativo para encerrar"));
                
                if (numero >= 0){
                    //chama o método calcular fatorial do objeto remoto, passando o valor inserido pelo usuário.  exibe o resultado na tela
                    JOptionPane.showMessageDialog(null, "Fatorial de " + numero + " = " + refFat.calcularFatorial(numero));
                }
                else{
                    System.out.println("App do cliente encerrado com sucesso\n");
                    System.exit(0);
                }                
            }
            catch (Exception e){
                System.err.println("Erro no cliente: "+e.toString());
                e.printStackTrace();
                System.exit(0);
            }
        }
    }
}
     
