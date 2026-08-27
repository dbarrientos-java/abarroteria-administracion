package main.java.com.ingsf.abarroteria.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.java.com.ingsf.abarroteria.controller.DashboardController;
import main.java.com.ingsf.abarroteria.controller.LoginController;
import main.java.com.ingsf.abarroteria.repository.AuthRepository;
import main.java.com.ingsf.abarroteria.repository.ProductoRepository;
import main.java.com.ingsf.abarroteria.service.AuthService;
import main.java.com.ingsf.abarroteria.service.DashboardService;


public class SceneManager {
    //atributos
    private final Stage stage;
    private final String FXML_PATH = "/main/resource/view/";
    //constructor
    public SceneManager(Stage stage ){
        this.stage = stage;
        
    }
    
   //metodos
    public void showLoginView()throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML_PATH + "login-view.fxml"));
        
        loader.setControllerFactory(
        clazz ->{
        if(clazz == LoginController.class) {  
           AuthRepository authRepository = new AuthRepository();
           AuthService authService = new AuthService(authRepository);
           return new LoginController(authService, this);
        }
        try{
            return clazz.getDeclaredConstructor().newInstance();
        }catch(Exception e) {
            throw new RuntimeException("error al crear el constructor "+e.getMessage() );
        }
             
           } );
Parent root = loader.load();
Scene scene = new Scene(root, 600, 600);
stage.setScene(scene);
stage.centerOnScreen();
stage.show();
       
}
    
    public void showDashboardController() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML_PATH + "dashboard-view.fxml"));
        
        loader.setControllerFactory(
        clazz ->{
            if(clazz == DashboardController.class){
                ProductoRepository repository = new ProductoRepository();
                DashboardService service = new DashboardService(repository);
                return new DashboardController(service, this);
            }
          try{
            return clazz.getDeclaredConstructor().newInstance();
          }catch(Exception e){
              throw new RuntimeException("error al corgar el constructor.");
          } 
            
        }
        );
        
          Parent root = loader.load();
          Scene scene = new Scene(root, 600, 600);
          stage.setScene(scene);
          stage.centerOnScreen();
          stage.show();
    }
    
    
  
    
  //alerta modal reutilizable
    public void showAlertInfo(String head, String title, String content, AlertType type){
        Alert alert = new Alert(type);
        alert.initOwner(this.stage);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();                                                                                                
    }
        
 }
//when pajaros: *volar*
//SOY MAGNO SOLIS Y ESTOY TALLERES 🗣️🔥🔥