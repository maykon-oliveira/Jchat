package ifrn.edu.jchat.cliente;

import ifrn.edu.jchat.models.Mensagem;
import ifrn.edu.jchat.TelaPrincipalController;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/**
 *
 * @author Maykon Oliveira
 */
public class Cliente implements Runnable {
    private final Integer PORTA = 5000;
    private final String SERVER_ADDRESS;
    private final TelaPrincipalController TELA_PRINCIPAL;
    private ObjectOutputStream saidaDoCliente;

    public Cliente(TelaPrincipalController TELA_PRINCIPAL, String SERVER_ADDRESS) {
        this.TELA_PRINCIPAL = TELA_PRINCIPAL;
        this.SERVER_ADDRESS = SERVER_ADDRESS;
    }
    
    @Override
    public void run() {
        try {
            conectaServidor();
        } catch (IOException ex) {
            Logger.getLogger("Erro ao conectar ao servidor.", ex.toString());
        }
    }
    
    private void conectaServidor() throws IOException {
        Socket socketToServidor = new Socket(SERVER_ADDRESS, PORTA);
        
        getStreamsFromSocket(socketToServidor);
    }
    
    private void getStreamsFromSocket(Socket socket) throws IOException {
        this.saidaDoCliente = new ObjectOutputStream(socket.getOutputStream());
        
        ObjectInputStream entradaDoCliente = new ObjectInputStream(socket.getInputStream());
        iniciarRecebedor(entradaDoCliente);
    }
    
    private void iniciarRecebedor(ObjectInputStream streamEntrada) {
        Recebedor recebedor = new Recebedor(this.TELA_PRINCIPAL, streamEntrada);
        new Thread(recebedor).start();
    }
    
    public void enviarMensagem(Mensagem mensagem) throws IOException {
        saidaDoCliente.writeObject(mensagem);
        saidaDoCliente.flush();
    }
}
