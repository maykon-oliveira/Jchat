package ifrn.edu.jchat.models;

import java.io.Serializable;

/**
 *
 * @author Maykon Oliveira
 */
public class Mensagem implements Serializable {
    private String remetente;
    private String mensagem;

    public Mensagem(String remetente, String mensagem) {
        this.remetente = remetente;
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return remetente+": "+mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }
}
