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
     
public class ClientMain {
	//cria um objeto de interface RMI que vai conter a referência do objeto remoto
	private static FatInterface objServerRef;
     
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException, ServerNotActiveException {
		//retorna a referência do objeto remoto, do tipo da Interface, associado ao nome informado
		objServerRef = (FatInterface) Naming.lookup("//localhost:5000");

		//define a janela para pegar o número do fatorial
		Integer numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número para o fatorial:"));

		//chama o método calcular fatorial do objeto remoto, passando o valor inserido pelo usuário.
		Integer response = objServerRef.calcularFatorial(numero);
                
		//exibe o resultado na tela
		JOptionPane.showMessageDialog(null, "O fatorial de " + numero + ": " + response);
     
		System.exit(0);
	}
}
     
