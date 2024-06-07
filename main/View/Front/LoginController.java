package main.View.Front;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Model.User;

public class LoginController {

    @FXML
    private Button login;

    @FXML
    private PasswordField password;

    @FXML
    private TextField user;

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @FXML
    void submit(ActionEvent event) {
        String username = user.getText();
        String pass = password.getText();

        Stage stage = (Stage) login.getScene().getWindow();
        Parent root = null;

        // Get the list of users from the DataManager
            
            List<User> users = userService.getDataManager().getUsers();
            User newUser = new User("123", "123",null);
            users.add(newUser);
        for (User user : users){
            System.out.println(user);
        }
        User currentUser = null;
        String hashedPassword = hashPassword(pass);
        System.out.println(hashedPassword);
        // Check if the username and password match any user
        if (userService.getUserAccountManagement().loginUser(username, hashedPassword)) {
            for (User u : users) {
                if (u.getUserName().equals(username) && u.getPassword().equals(hashedPassword)) {
                    currentUser = u;
                    break;
                }
            }

            if (currentUser != null) {
                userService.setCurrentUser(currentUser);  // Set the current user in UserService

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
            } else {
                System.out.println("Invalid username or password.");
            }
        } else {
            System.out.println("Invalid username or password.");
        }
    }

      public String hashPassword(String password) {
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // Hash the password
            byte[] encodedHash = digest.digest(password.getBytes());
            // Encode the hashed password using Base64
            return Base64.getEncoder().encodeToString(encodedHash);
        } catch (NoSuchAlgorithmException e) {
            // Handle NoSuchAlgorithmException
            e.printStackTrace();
            return null;
        }
    }
}
