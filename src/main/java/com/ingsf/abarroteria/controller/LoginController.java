package main.java.com.ingsf.abarroteria.controller;
 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.java.com.ingsf.abarroteria.dto.request.LoginDTORequest;
import main.java.com.ingsf.abarroteria.dto.response.LoginDTOResponse;
import main.java.com.ingsf.abarroteria.service.AuthService;
import main.java.com.ingsf.abarroteria.util.SceneManager;

public class LoginController implements Initializable {

    private final AuthService authService;
    private final SceneManager sceneManager;

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private TextField txtFieldEmail;

    @FXML
    private PasswordField txtFieldPassword;
 
    public LoginController(AuthService authService, SceneManager sceneManager) {

        this.authService = authService;
        this.sceneManager = sceneManager;

    }
 
    @Override

    public void initialize(URL url, ResourceBundle rb) {

        // TODO

    }
   
    public void handleLogin(){

        if(txtFieldEmail.getText().isEmpty() || txtFieldPassword.getText().isEmpty()){

            throw new RuntimeException("Los campos están vacios");

        }else{
               try{
            LoginDTOResponse response = authService.login(new LoginDTORequest(txtFieldEmail.getText(), txtFieldPassword.getText()));
            sceneManager.showAlertInfo("Bienvenido", "Es bueno verte"+response.getNombre(),"Inicio de sesion correcto. " , Alert.AlertType.INFORMATION);
               }catch(RuntimeException e){
                   sceneManager.showAlertInfo("ERROR", "Verifica los Campos", "No se Ah podido iniciar sesion", Alert.AlertType.WARNING);
               }
        }

    }

}
 