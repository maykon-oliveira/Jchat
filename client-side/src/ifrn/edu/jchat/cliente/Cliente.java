package ifrn.edu.jchat.cliente;

import ifrn.edu.jchat.models.Mensagem;
import ifrn.edu.jchat.tela_principalController;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Maykon Oliveira
 */
public class Cliente implements Runnable {
    private final Integer PORTA = 5000;
    private final String IP_SERVIDOR = "localhost";
    private final tela_principalController TELA_PRINCIPAL;
    private final String NICKNAME;
    private ObjectOutputStream saidaDoCliente;

    public Cliente(tela_principalController TELA_PRINCIPAL, String NICKNAME) {
        this.TELA_PRINCIPAL = TELA_PRINCIPAL;
        this.NICKNAME = NICKNAME;
    }
    
    @Override
    public void run() {
        try {
            Socket socketParaServidor = new Socket(IP_SERVIDOR, PORTA);
            System.out.println("O cliente se conectou ao servidor!");
            
            saidaDoCliente = new ObjectOutputStream(socketParaServidor.getOutputStream());
            
            ObjectInputStream entradaDoCliente = new ObjectInputStream(socketParaServidor.getInputStream());
            new Thread(new Recebedor(TELA_PRINCIPAL, entradaDoCliente)).start();
            
        } catch (IOException ex) {
            System.out.println("Erro no cliente " + ex.getMessage());
        }
    }
    
    public void enviarMensagem(String mensagem) throws IOException {
        Mensagem mensagemToCliente = new Mensagem(NICKNAME, mensagem);
        saidaDoCliente.writeObject(mensagemToCliente);
        saidaDoCliente.flush();
    }
}
