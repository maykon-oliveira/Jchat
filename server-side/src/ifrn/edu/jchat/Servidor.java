package ifrn.edu.jchat;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author 20171148060019
 */
public class Servidor {
    private static final int PORTA = 5000;

    public static void main(String[] args) throws IOException {
        DistribuidorMensagem distribuidor = new DistribuidorMensagem();
        
        ServerSocket servidor = new ServerSocket(PORTA);
        
        System.out.println("Porta: " + PORTA + " Aberta!");
        
        Registrador registrador = new Registrador(distribuidor, servidor);
        Thread pilha = new Thread(registrador);
        pilha.start();

    }
}
