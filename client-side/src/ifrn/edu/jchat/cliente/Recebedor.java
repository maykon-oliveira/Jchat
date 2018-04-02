package ifrn.edu.jchat.cliente;

import ifrn.edu.jchat.models.Mensagem;
import ifrn.edu.jchat.TelaPrincipalController;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Logger;

/**
 *
 * @author Maykon Oliveira
 */
public class Recebedor implements Runnable {
    private final TelaPrincipalController TELA_PRINCIPAL;
    private final ObjectInputStream ENTRADA_CLIENTE;

    public Recebedor(TelaPrincipalController TELA_PRINCIPAL, ObjectInputStream entradaCliente) {
        this.TELA_PRINCIPAL = TELA_PRINCIPAL;
        this.ENTRADA_CLIENTE = entradaCliente;
    }
    
    @Override
    public void run() {
        try {
            while (true) {                
                Mensagem mensagemFromServidor = (Mensagem) ENTRADA_CLIENTE.readObject();
                System.out.println(mensagemFromServidor);                
      // TODO - TELA_PRINCIPAL.escreverMensagemTela(mensagemFromServidor);
            }
            
        } catch (IOException ex) {
            exibeExecao(ex);
        } catch (ClassNotFoundException ex) {
            exibeExecao(ex);
        }
    }
    
    private void exibeExecao(Exception ex) {
        Logger.getLogger("Erro no recebedor de mensagem.", ex.toString());
    }
}
