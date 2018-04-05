
package ifrn.edu.jchat;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author CristianeSilva
 */
public class TelaInicialController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void fieldNickname(ActionEvent event) {
    }

    @FXML
    private void hendleSalvar(ActionEvent event) {
        try {
            openMainStage();
            closeStage();
        } catch (IOException ex) {
            System.out.println("Erro ao abrir a tela principal" + ex.toString());
        }
    }
    
    private void openMainStage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("tela_principal.fxml"));

        loader.setController(new TelaPrincipalController());

        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("JChat");
        stage.setScene(scene);
        stage.show();
            
    }
    
    private void closeStage() {
        // TODO
    }
}
