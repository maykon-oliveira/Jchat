package ifrn.edu.jchat.cliente;

import ifrn.edu.jchat.models.Mensagem;
import ifrn.edu.jchat.tela_principalController;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author Maykon Oliveira
 */
public class Recebedor implements Runnable {
    private final tela_principalController TELA_PRINCIPAL;
    private final ObjectInputStream ENTRADA_CLIENTE;

    public Recebedor(tela_principalController TELA_PRINCIPAL, ObjectInputStream entradaCliente) {
        this.TELA_PRINCIPAL = TELA_PRINCIPAL;
        this.ENTRADA_CLIENTE = entradaCliente;
    }
    
    @Override
    public void run() {
        try {
            while (true) {                
                Mensagem mensagemDoServidor = (Mensagem) ENTRADA_CLIENTE.readObject();
                System.out.println(mensagemDoServidor);                
            }
            
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro no recebedor de mensagem." + ex.getMessage());
        }
    }
}
