package ifrn.edu.jchat;

import ifrn.edu.jchat.cliente.Cliente;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Maykon Oliveira
 */
public class tela_principalController implements Initializable {
    
    @FXML private Label label;
    private Cliente cliente = new Cliente(this, "Maykon");
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
//        try {
//            cliente.enviarMensagem("Teste");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new Thread(cliente).start();
    }    
    
}
