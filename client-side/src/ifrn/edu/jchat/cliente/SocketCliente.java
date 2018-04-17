package ifrn.edu.jchat.cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Maykon Oliveira
 */
public class SocketCliente {
    private final Integer PORTA = 5000;
    private final String SERVER_ADDRESS = "localhost";
    
    private Socket socketToServidor;
    private ObjectOutputStream saidaCliente;
    private ObjectInputStream entradaCliente;

    public SocketCliente() {
        try {
            conectaServidor();
        } catch (IOException ex) {
            System.out.println("Erro ao conectar servidor" + ex);
        }
        
    }

    private void conectaServidor() throws IOException {
        this.socketToServidor = new Socket(SERVER_ADDRESS, PORTA);
        
        getStreamsFromSocket(socketToServidor);
    }
    
    private void getStreamsFromSocket(Socket socket) throws IOException {
        saidaCliente = new ObjectOutputStream(socket.getOutputStream());
        entradaCliente = new ObjectInputStream(socket.getInputStream());
    }
    
    public ObjectOutputStream getSaidaCliente() {
        return saidaCliente;
    }
    
    public ObjectInputStream getEntradaCliente() {
        return entradaCliente;
    }
}
