package main.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FrontController {

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    @FXML
    private Button adminDatabaseAccessButton;

    @FXML
    private void handleLogin() {
        // Logic for handling the login button click
        System.out.println("Login button clicked");
    }

    @FXML
    private void handleSignUp() {
        // Logic for handling the sign-up button click
        System.out.println("Sign Up button clicked");
    }

    @FXML
    private void handleAdminDatabaseAccess() {
        // Logic for handling the admin database access button click
        System.out.println("Admin Database Access button clicked");
    }
}
