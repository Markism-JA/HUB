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

public class AdminController {
    private final String ADMINNAME = "@admin";
    private final String ADMINPASS = "@admin";
    
    private UserService userService;
    
    @FXML
    private TextField adminName;
    
    @FXML
    private PasswordField adminPass;
    
    @FXML
    private Label errorLabelName;

    @FXML
    private Label errorLabelPass;
    
    @FXML
    private Button adminAccess;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @FXML
    private void handleAdminAccess(ActionEvent event) {
        String name = adminName.getText();
        String pass = adminPass.getText();

        Stage stage = (Stage) adminAccess.getScene().getWindow();
        Parent root = null;

        if (!name.equals(ADMINNAME)) {
            errorLabelName.setText("Incorrect admin name");
        } else if (!pass.equals(ADMINPASS)) {
            errorLabelPass.setText("Incorrect admin password");
        } else if (name.equals(ADMINNAME) && pass.equals(ADMINPASS)) {
            errorLabelName.setText("");
            errorLabelPass.setText("");

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminDashboard.fxml")); // Replace with the actual path
                loader.setControllerFactory(c -> {
                    AdminDashboardController controller = new AdminDashboardController();
                    controller.setUserService(userService);  // Inject UserService into AdminDashboardController
                    return controller;
                });
                root = loader.load();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                System.out.println("Error loading admin dashboard scene: " + e.getMessage());
            }
        }
    }
}
