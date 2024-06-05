package main.View.Front;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Model.DataManager;
import main.Model.UserAccountManagement;
import main.Model.UserPreferences;

public class SignUpController {
    private MainApp mainApp;
    private UserAccountManagement userAccountManagement;
    private DataManager dataManager;


    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @FXML
    private Label errorLabel;

    @FXML
    private Label emptyLabel;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setUserAccountManagement() {
        this.userAccountManagement = new UserAccountManagement(dataManager.getUsers());
    }


    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField passVerify;

    @FXML
    private Button signUpButton;

    @FXML
    private void handleSignUp(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String verifyPassword = passVerify.getText();

        // Get the current stage from the signUpButton
        Stage stage = (Stage) signUpButton.getScene().getWindow();
        Parent root = null;
        
    
        if (!password.equals(verifyPassword)) {
            errorLabel.setText("Passwords do not match. Please re-enter your password.");

        } else if (password.equals("") && passVerify.equals("")) {
            errorLabel.setText("Please enter a password.");
           
        
        } else if ( username.equals("")) {
            emptyLabel.setText("Please enter a username.");
            
        } else if (password.equals(verifyPassword) && !password.equals("")) {

            // Clear the error message if registration is successful
            errorLabel.setText("");
            emptyLabel.setText("");
            
            setUserAccountManagement();

            // Register the user
            userAccountManagement.registerUser(username, password);

            try {
                root = FXMLLoader.load(getClass().getResource("FrontUserPreference.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                System.out.println("Error loading preference scene: " + e.getMessage());
            }
        }
    }
}
