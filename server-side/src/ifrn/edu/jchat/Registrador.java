package ifrn.edu.jchat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author 20171148060019
 */
public class Registrador implements Runnable {

    private final DistribuidorMensagem distribuidor;
    private final ServerSocket serverSocket;

    public Registrador(DistribuidorMensagem distribuidor, ServerSocket serverSocket) {
        this.distribuidor = distribuidor;
        this.serverSocket = serverSocket;

    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket socketCliente = serverSocket.accept();
                ObjectInputStream entradaCliente = new ObjectInputStream(socketCliente.getInputStream());
                ObjectOutputStream saidaCliente = new ObjectOutputStream(socketCliente.getOutputStream());
                
                Receptor receptor = new Receptor(entradaCliente, distribuidor);
                Thread pilha = new Thread(receptor);
                pilha.start();
                
                Emissor emissor = new Emissor(saidaCliente);

                this.distribuidor.addEmisor(emissor);

            } catch (IOException e) {
                System.out.println("Erro no registrador " + e);
            }
        }

    }
}
