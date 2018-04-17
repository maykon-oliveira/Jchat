package ifrn.edu.jchat.models;

import java.io.Serializable;

/**
 *
 * @author Maykon Oliveira
 */
public abstract class Mensagem implements Serializable {
    private String remetente;

    public Mensagem(String remetente) {
        this.remetente = remetente;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }
}
