package ifrn.edu.jchat.models;

/**
 *
 * @author Maykon Oliveira
 */
public class MensagemTexto extends Mensagem {
    private String conteudo;

    public MensagemTexto(String remetente, String mensagem) {
        super(remetente);
        this.conteudo = conteudo;
    }
    
    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
    
}
