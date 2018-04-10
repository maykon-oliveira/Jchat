package ifrn.edu.jchat;

import com.jfoenix.controls.JFXTextField;
import ifrn.edu.jchat.cliente.*;
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

    @FXML private JFXTextField fieldNickname;
    
    private SocketCliente socketCliente;
    private Emissor emissor;
    private Recebedor recebedor;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        socketCliente = new SocketCliente();
    }

    @FXML
    private void hendleSalvarNickname(ActionEvent event) {
        if (isValidNickname()) {
            try {
                closeStage();
                openMainStage();
            } catch (IOException ex) {
                System.out.println("Erro ao abrir a tela principal" + ex.toString());
            }
        } else {
            System.out.println("Nickname inválido");
        }
    }
    
    private boolean isValidNickname() {
        String regex = "^[A-Za-z0-9]{1,12}$";
        return fieldNickname.getText().matches(regex);
    }
    
    private void closeStage() {
        ((Stage) fieldNickname.getScene().getWindow()).close();
    }
    
    private void openMainStage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("tela_principal.fxml"));
        
        TelaPrincipalController tela = new TelaPrincipalController(emissor);
        
        iniciarRecebedor(tela);
        
        loader.setController(tela);
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setTitle("JChat");
        stage.setScene(scene);
        stage.show();            
    }
    
    private void iniciarRecebedor(TelaPrincipalController tela) {
        recebedor = new Recebedor(tela, socketCliente.getEntradaCliente());
        new Thread(recebedor).start();
    }
}
