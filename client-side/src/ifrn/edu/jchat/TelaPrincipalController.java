package ifrn.edu.jchat;

import com.jfoenix.controls.JFXTextField;
import ifrn.edu.jchat.cliente.SocketCliente;
import ifrn.edu.jchat.models.Mensagem;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Maykon Oliveira
 */
public class TelaPrincipalController implements Initializable {
    // Referências para o template
    @FXML private TextField areaDeMensagem;
    @FXML private JFXTextField fieldCaixaMensagem;
    @FXML private Text textNickname;
    
    private SocketCliente socketCliente;
    private String nickname;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.socketCliente = new SocketCliente(this);
        new Thread(socketCliente).start();
    }
    
    public void escreverMensagemTela(Mensagem mensagem) {
        // TODO
    }

    @FXML
    private void handleEnviarMensagem(ActionEvent event) {
        // TODO
    }
    
    private Mensagem getUserMensagem() {
        Mensagem mensagem = new Mensagem(this.nickname, fieldCaixaMensagem.getText());
        return mensagem;
    }

    @FXML
    private void handleSair(ActionEvent event) {
        try {
            this.socketCliente.fecharConexao();
        } catch (IOException ex) {
            Logger.getLogger("Erro ao fechar conexão", ex.toString());
        } finally {
            ((Stage) textNickname.getScene().getWindow()).close();
        }
    }
}
