package ifrn.edu.jchat;

import ifrn.edu.jchat.models.Mensagem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author 20171148060019
 */
class DistribuidorMensagem {

    private final Collection<Emissor> emissores;

    public DistribuidorMensagem() {
        emissores = new ArrayList();
    }

    public void addEmisor(Emissor emissor) {
        this.emissores.add(emissor);
    }

    public void DistribuirMensagens(Mensagem mensagem) throws IOException {
        for (Emissor emissor : this.emissores) {
            emissor.enviarMensagem(mensagem);
        }
    }
}
