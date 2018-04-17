package ifrn.edu.jchat.cliente;

import ifrn.edu.jchat.models.Mensagem;
import ifrn.edu.jchat.models.MensagemImagem;
import ifrn.edu.jchat.models.MensagemTexto;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;


/**
 *
 * @author Maykon Oliveira
 */
public class Emissor {
    private final String NICKNAME;
    private final ObjectOutputStream SAIDA_CLIENTE;

    public Emissor(String NICKNAME, ObjectOutputStream SAIDA_CLIENTE) {
        this.NICKNAME = NICKNAME;
        this.SAIDA_CLIENTE = SAIDA_CLIENTE;
    }
    
    public void sendTextMessage(String conteudo) throws IOException {
        Mensagem mensagem = new MensagemTexto(NICKNAME, conteudo);
        SAIDA_CLIENTE.writeObject(mensagem);
        SAIDA_CLIENTE.flush();
    }
    
    public void sendImageMessage(File conteudo) throws IOException {
        Mensagem mensagem = new MensagemImagem(NICKNAME, conteudo);
        SAIDA_CLIENTE.writeObject(mensagem);
        SAIDA_CLIENTE.flush();
    }
    
    public void fecharConexao() throws IOException {
        SAIDA_CLIENTE.close();
    }

    public String getNickname() {
        return NICKNAME;
    }
}
