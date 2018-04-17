package ifrn.edu.jchat;

import ifrn.edu.jchat.models.Mensagem;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author 20171148060019
 */
public class Emissor {
    private final ObjectOutputStream SAIDA_CLIENTE;

    public Emissor(ObjectOutputStream SAIDA_CLIENTE) {
        this.SAIDA_CLIENTE = SAIDA_CLIENTE;
    }

    public void enviarMensagem(Mensagem mensagem) throws IOException {
        SAIDA_CLIENTE.writeObject(mensagem);
        SAIDA_CLIENTE.flush();
    }
}
