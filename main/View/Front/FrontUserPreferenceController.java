package main.View.Front;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FrontUserPreferenceController {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
  
    @FXML
    private Button startButton;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Stage stage = (Stage) startButton.getScene().getWindow();
        Parent root = null;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Budget.fxml")); // Replace with the actual path
            loader.setControllerFactory(c -> {
                BudgetController controller = new BudgetController();
                controller.setUserService(userService);  // Inject UserService into AdminDashboardController
                return controller;
            });
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            System.out.println("Starting Build");
        } catch (Exception e) {
            System.out.println("Error loading front Budget scene: " + e.getMessage());
        }
    }
}
