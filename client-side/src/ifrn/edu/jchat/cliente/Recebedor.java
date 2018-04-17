package ifrn.edu.jchat.cliente;

import ifrn.edu.jchat.models.Mensagem;
import ifrn.edu.jchat.TelaPrincipalController;
import java.io.IOException;
import java.io.ObjectInputStream;

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
                aguardaMensagens();
            }
            
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao receber mensagem " + ex);
            
        } finally {
            try {
                ENTRADA_CLIENTE.close();
            } catch (IOException ex) {
                System.out.println("Erro ao fechar conexão no recebedor");
            }
        }
    }
    
    private void aguardaMensagens() throws IOException, ClassNotFoundException {
        Mensagem mesagemFromServidor = (Mensagem) ENTRADA_CLIENTE.readObject();
        TELA_PRINCIPAL.escreverMensagem(mesagemFromServidor);
            
    }
}
