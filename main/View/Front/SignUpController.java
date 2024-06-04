package main.View.Front;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Model.UserAccountManagement;
import main.Model.UserPreferences;

public class SignUpController {
    private MainApp mainApp;
    private UserAccountManagement userAccountManagement;

    @FXML
    private Label errorLabel;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setUserAccountManagement(UserAccountManagement userAccountManagement) {
        this.userAccountManagement = userAccountManagement;
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
    
        // Create default preferences for the user
        // UserPreferences preferences = new UserPreferences(null, null, null, null, 0, 0, null);
    
        if (!password.equals(verifyPassword)) {
            errorLabel.setText("Passwords do not match. Please re-enter your password.");

        } else if (password.equals("") && passVerify.equals("")) {
            errorLabel.setText("Please enter a password.");
            
        } else if (password.equals(verifyPassword) && !password.equals("")) {

            // Clear the error message if registration is successful
            errorLabel.setText("");
            
            // Register the user
            // userAccountManagement.registerUser(username, password, preferences);

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
