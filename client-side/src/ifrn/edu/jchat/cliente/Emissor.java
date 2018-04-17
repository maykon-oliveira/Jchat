package ifrn.edu.jchat.cliente;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;


/**
 *
 * @author Maykon Oliveira
 */
public class Emissor {
    private final String nickname;
    private final ObjectOutputStream SAIDA_CLIENTE;

    public Emissor(String nickname, ObjectOutputStream SAIDA_CLIENTE) {
        this.nickname = nickname;
        this.SAIDA_CLIENTE = SAIDA_CLIENTE;
    }
    
    public void sendMessageText(String conteudo) throws IOException {
        
    }
    
    public void sendMessageImage(File conteudo) throws IOException {
        
    }
}
