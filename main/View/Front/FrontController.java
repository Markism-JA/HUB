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
import main.Model.DataManager;

import java.io.IOException;

public class FrontController implements Initializable {

    private DataManager dataManager;

    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;
        dataManager.loadData();
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
                stage = (Stage) adminDatabaseAccessButton.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
            } else if (event.getSource() == loginButton) {
                stage = (Stage) loginButton.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
            } else if (event.getSource() == signUpButton) {
                stage = (Stage) signUpButton.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
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
    
