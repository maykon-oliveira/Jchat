package ifrn.edu.jchat.models;

import java.io.File;

/**
 *
 * @author Maykon Oliveira
 */
public class MensagemImagem extends Mensagem {
    private File conteudo;
    
    public MensagemImagem(String remetente, File conteudo) {
        super(remetente);
        this.conteudo = conteudo;                
    }

    @Override
    public String toString() {
        return getRemetente() + ": Imagem " + conteudo.getName();
    }
    
    public File getConteudo() {
        return conteudo;
    }

    public void setConteudo(File conteudo) {
        this.conteudo = conteudo;
    }
}
