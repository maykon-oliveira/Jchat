package ifrn.edu.jchat.models;

import java.io.File;

/**
 *
 * @author Maykon Oliveira
 */
public class MensagemImagem extends Mensagem {
    private File conteudo;

    public MensagemImagem(String remetente, File mensagem) {
        super(remetente);
        this.conteudo = conteudo;
    }
    

    public File getConteudo() {
        return conteudo;
    }

    public void setConteudo(File conteudo) {
        this.conteudo = conteudo;
    }
}
