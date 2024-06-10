package main.View.Front;

import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class FrontController implements Initializable {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @FXML
    private Label lbl1, lbl2;
    
    @FXML
    private Button adminDatabaseAccessButton, signUpButton, loginButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Stage stage = null;
        Parent root = null;
       
        try {
            if (event.getSource() == adminDatabaseAccessButton) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
                root = loader.load();
                AdminController adminController = loader.getController();
                adminController.setUserService(userService);
                stage = (Stage) adminDatabaseAccessButton.getScene().getWindow();
            } else if (event.getSource() == loginButton) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LogIn.fxml"));
                root = loader.load();
                LoginController logInController = loader.getController();
                logInController.setUserService(userService);
                stage = (Stage) loginButton.getScene().getWindow();
            } else if (event.getSource() == signUpButton) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
                root = loader.load();
                SignUpController signUpController = loader.getController();
                signUpController.setUserService(userService);
                stage = (Stage) signUpButton.getScene().getWindow();
            }
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        if (root != null) {
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    
}
    
