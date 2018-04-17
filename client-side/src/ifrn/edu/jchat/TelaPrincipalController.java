package ifrn.edu.jchat;

import com.jfoenix.controls.JFXTextField;
import ifrn.edu.jchat.cliente.Emissor;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ifrn.edu.jchat.models.Mensagem;

/**
 *
 * @author Maykon Oliveira
 */
public class TelaPrincipalController implements Initializable {

    // Referências para o template
    @FXML
    private TextField areaDeMensagem;
    @FXML
    private JFXTextField fieldCaixaMensagem;
    @FXML
    private Text titleNickname;

    private final Emissor emissor;
    private FileChooser fileChooser;

    public TelaPrincipalController(Emissor emissor) {
        this.emissor = emissor;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configuraFileChoose();
    }

    private void configuraFileChoose() {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Escolha uma imagem");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("JPEG", "*.jpeg"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp"),
                new FileChooser.ExtensionFilter("PNG", "*.png"));
    }

    @FXML
    private void handleSendTextMessage(ActionEvent event) {
        try {
            emissor.sendMessageText(fieldCaixaMensagem.getText());
        } catch (IOException ex) {
            System.out.println("Erro ao enviar mensagem de texto" + ex.toString());
        }
    }

    @FXML
    void handleSendImageMessage(ActionEvent event) {
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            try {
                emissor.sendMessageImage(selectedFile);
            } catch (IOException ex) {
                System.out.println("Erro ao enviar imagem" + ex.toString());
            }
        }
    }

    @FXML
    private void handleSair(ActionEvent event) {
        ((Stage) titleNickname.getScene().getWindow()).close();
    }

    public void escreverMensagemTela(Mensagem mensagem) {
        // TODO
    }
}
