package ifrn.edu.jchat.models;

import java.io.Serializable;

/**
 *
 * @author Maykon Oliveira
 */
public class Mensagem implements Serializable {
    private String remetenteNickname;
    private String mensagem;

    public Mensagem(String remetenteNickname, String mensagem) {
        this.remetenteNickname = remetenteNickname;
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return remetenteNickname+": "+mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getRemetenteNickname() {
        return remetenteNickname;
    }

    public void setRemetenteNickname(String remetenteNickname) {
        this.remetenteNickname = remetenteNickname;
    }
}
