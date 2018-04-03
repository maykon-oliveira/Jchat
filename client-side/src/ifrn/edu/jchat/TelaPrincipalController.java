package ifrn.edu.jchat;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Maykon Oliveira
 */
public class TelaPrincipalController implements Initializable {

    @FXML private TextField fieldCaixaMensagem;
    @FXML private TextField areaDeMensagem;
    @FXML
    private Button buttonSair;
    
    /*  ======= TODO =======
        Novo objeto cliente;
        Nickanme;
    */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*  ======== TODO =========
            Nova Thread do cliente;
        */        
    }    
    
    /* ===== TODO ======
        Método escreverMensagemTela(Mensagem mensagem);
        Método encapsularMensagem(String texto);
    */

    @FXML
    private void handleEnviarMensagem(ActionEvent event) {
    }

    @FXML
    private void handleSair(ActionEvent event) {
    }
}
