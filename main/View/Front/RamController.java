package main.View.Front;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Model.User;

public class RamController {
    private UserService userService;
    private boolean prefSet = false; // Flag to indicate if RAM preference is set

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private int ram; // String for budget tier

    @FXML
    private Button first, second, third, fourth, NoPref;

    @FXML
    private void handleButtonAction(ActionEvent event) throws InvalidBudgetException {
        if (event.getSource() == first) {
            ram = 8;
            prefSet = true;
        } else if (event.getSource() == second) {
            ram = 16;
            prefSet = true;
        } else if (event.getSource() == third) {
            ram = 32;
            prefSet = true;
        } else if (event.getSource() == fourth) {
            ram = 64;
            prefSet = true;
        } else if (event.getSource() == NoPref) {
            ram = 0;
            prefSet = false; // Reset flag to indicate no preference
        }

        User currentUser = userService.getCurrentUser();

        // Set the user's RAM preference only if a preference is set
        if (prefSet) {
            currentUser.getPreferences().setRam(ram);
            System.out.println(currentUser.getUserName() + " = Set RAM: " + ram);
        } else {
            currentUser.getPreferences().setRam(0);
            System.out.println(currentUser.getUserName() + " = No RAM preference set");
        }

        // Load the new scene
        loadNewScene();
    }

    private void loadNewScene() {
        Stage stage = (Stage) first.getScene().getWindow();
        Parent root = null;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CaseFormFactor.fxml")); // Replace with the actual path
            loader.setControllerFactory(c -> {
                CaseController controller = new CaseController();
                controller.setUserService(userService);  // Inject UserService into AdminDashboardController
                return controller;
            });
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Error loading front Purpose scene: " + e.getMessage());
        }
    }

    public static class InvalidBudgetException extends Exception {
        public InvalidBudgetException(String message) {
            super(message);
        }
    }
}
