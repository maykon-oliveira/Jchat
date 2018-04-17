package ifrn.edu.jchat;

import ifrn.edu.jchat.models.Mensagem;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author 20171148060019
 */
public class Receptor implements Runnable {
    
    private final ObjectInputStream ENTRADA_CLIENTE;
    private final DistribuidorMensagem distribuidor;
    
    public Receptor(ObjectInputStream ENTRADA_CLIENTE, DistribuidorMensagem distribuidor) {
        this.ENTRADA_CLIENTE = ENTRADA_CLIENTE;
        this.distribuidor = distribuidor;
        
    }
    @Override
    public void run() {
        try {
            while (true) {
                Mensagem mensagemFromCliente = (Mensagem) ENTRADA_CLIENTE.readObject();
                distribuidor.DistribuirMensagens(mensagemFromCliente);
            }
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao receber mensagem " + e);
        }
    }
}
