package main.View.Front;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Model.DataManager;
import main.Model.UserAccountManagement;

public class LoginController {

    @FXML
    private Button login;

    @FXML
    private PasswordField password;

    @FXML
    private TextField user;

    private DataManager dataManager;
    private UserAccountManagement userAccountManagement;

    public LoginController() {
        // Initialize the DataManager with the path to your data files
        this.dataManager = new DataManager("main/Resources/data"); // Adjust the path as needed
        this.userAccountManagement = new UserAccountManagement(dataManager.getUsers());
    }

    public void setUserAccountManagement(UserAccountManagement userAccountManagement) {
        this.userAccountManagement = userAccountManagement;
    }

    @FXML
    void submit(ActionEvent event) {
        String username = user.getText();
        String pass = password.getText();
        Stage stage = (Stage) login.getScene().getWindow();
        Parent root = null;

        if (userAccountManagement.loginUser(username, pass)) {
            showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome, " + username + "!");
            try {
                root = FXMLLoader.load(getClass().getResource("FrontUserPreference.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                System.out.println("Error loading preference scene: " + e.getMessage());
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
