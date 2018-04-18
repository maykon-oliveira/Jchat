package ifrn.edu.jchat;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToolbar;
import ifrn.edu.jchat.cliente.Emissor;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import ifrn.edu.jchat.models.Mensagem;
import ifrn.edu.jchat.models.MensagemImagem;
import ifrn.edu.jchat.models.MensagemTexto;
import java.awt.image.BufferedImage;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javax.imageio.ImageIO;

/**
 *
 * @author Maykon Oliveira
 */
public class TelaPrincipalController implements Initializable {
    
    @FXML private JFXTextField fieldCaixaMensagem;
    private ObservableList listMensagens;
    @FXML private JFXListView mensagensContent;
    @FXML private JFXToolbar toolBar;
    @FXML private HBox toolBarRight;
    @FXML private Label lblMenu;
    @FXML private VBox overflowContainer;
    @FXML private StackPane stackPane;
    
    private final Emissor emissor;
    private FileChooser fileChooser;

    public TelaPrincipalController(Emissor emissor) {
        this.emissor = emissor;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configuraFileChoose();
        configurarMenu();
        
        listMensagens = mensagensContent.getItems();
        mensagensContent.depthProperty().set(1);
        mensagensContent.setExpanded(true);
    }
    
    private void configuraFileChoose() {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Escolha uma imagem");
        fileChooser.setSelectedExtensionFilter(
                new ExtensionFilter("Escolha uma imagem", "*.jpg","*.jpeg","*.bmp", "*.png"));
    }
    
    private void configurarMenu() {
        JFXRippler rippler = new JFXRippler(lblMenu);
        rippler.setMaskType((JFXRippler.RipplerMask.RECT));
        toolBarRight.getChildren().add(rippler);
        
        JFXPopup popup = new JFXPopup();
        popup.setPopupContent(overflowContainer);
        lblMenu.setOnMouseClicked((MouseEvent e) -> {
            popup.show(rippler, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT);
        });
    }
    
    @FXML
    private void handleSendTextMessage(ActionEvent event) {
        try {
            emissor.sendTextMessage(fieldCaixaMensagem.getText());
            fieldCaixaMensagem.clear();
        } catch (IOException ex) {
            System.out.println("Erro ao enviar mensagem de texto" + ex);
        }
    }
    
    @FXML
    private void handleSendImageMessage(ActionEvent event) {
        File selectedFile = fileChooser.showOpenDialog(null);
        
        if (selectedFile != null) {
            try {
                emissor.sendImageMessage(selectedFile);
            } catch (IOException ex) {
                System.out.println("Erro ao enviar imagem" + ex);
            }
        }
    }

    public void escreverMensagem(Mensagem mensagem) {
        if (mensagem instanceof MensagemTexto) {
            escreverMensagemTextoTela((MensagemTexto) mensagem);
            
        } else if (mensagem instanceof MensagemImagem) {
            try {
                escreverMensagemImagemTela((MensagemImagem) mensagem);
            } catch (IOException ex) {
                System.out.println("Erro ao escrever mensagem " + ex);
            }
        }
        
    }
    
    private void escreverMensagemTextoTela(MensagemTexto mensagemTexto) {
        Label label = new Label(mensagemTexto.toString());
        
        listMensagens.add(label);
    }
    
    private void escreverMensagemImagemTela(MensagemImagem mensagem) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(mensagem.getConteudo());
        
        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        
        ImageView imageView = new ImageView(image);
        imageView.preserveRatioProperty().setValue(Boolean.TRUE);
        ajustarImagem(imageView);
        
        Label label = new Label(mensagem.getRemetente(), imageView);
        label.contentDisplayProperty().setValue(ContentDisplay.BOTTOM);
        
        listMensagens.add(label);
    }
    
    private void ajustarImagem(ImageView image) {
        if (image.getImage().getWidth() > 270) {
            image.setFitWidth(270);
        }
    }
    
    @FXML
    private void handleSair(ActionEvent event) {
        try {
            emissor.fecharConexao();
            
        } catch (IOException ex) {
            System.out.println("Erro ao fechar conexão");
        } finally {
            ((Stage) fieldCaixaMensagem.getScene().getWindow()).close();
        }
    }
}
