package main.View.Front;

import java.util.List;

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
import main.Model.User;

public class SignUpController {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @FXML
    private Label errorLabel;

    @FXML
    private Label emptyLabel;

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
        } else if (username.equals("")) {
            emptyLabel.setText("Please enter a username.");
        } else if (password.equals(verifyPassword) && !password.equals("")) {
            // Clear the error message if registration is successful
            errorLabel.setText("");
            emptyLabel.setText("");

            // Register the user through UserService
            userService.getUserAccountManagement().registerUser(username, password);

            List<User> users = userService.getDataManager().getUsers();
            User newUser = null;
            for (User user : users) {
                if (user.getUserName().equals(username)) {
                    newUser = user;
                    System.out.println(user.toString() + " = User Registered");  // Print user details using toString()
                    break;
                }
            }

            if (newUser != null) {
                userService.setCurrentUser(newUser);  // Set the current user in UserService

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("FrontUserPreference.fxml")); // Replace with the actual path
                    loader.setControllerFactory(c -> {
                        FrontUserPreferenceController controller = new FrontUserPreferenceController();
                        controller.setUserService(userService);  // Inject UserService into FrontUserPreferenceController
                        return controller;
                    });
                    root = loader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    System.out.println("Error loading front Preference scene: " + e.getMessage());
                }
            }
        }
    }
}
