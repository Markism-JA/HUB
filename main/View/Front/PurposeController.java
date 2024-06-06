package main.View.Front;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Model.User;

public class PurposeController {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private String userPurpose; // String for budget tier

    @FXML
    private Button gaming, workstation, general;

    @FXML
    private void handleButtonAction(ActionEvent event) throws InvalidBudgetException {

      if (event.getSource() == gaming) {
        userPurpose = "gaming";
      } else if (event.getSource() == workstation) {
        userPurpose = "workstation";
      } else if (event.getSource() == general) {
        userPurpose = "general";
      }

      User currentUser = userService.getCurrentUser();

      // Set the user's purpose preference
      currentUser.getPreferences().setPurpose(userPurpose);
      System.out.println(currentUser.getUserName() + " = Set Purpose: " + userPurpose);
        // Load the new scene
        loadNewScene();
    }


    private void loadNewScene() {
        Stage stage = (Stage) gaming.getScene().getWindow();
        Parent root = null;

        try {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("CPUBrand.fxml")); // Replace with the actual path
          loader.setControllerFactory(c -> {
              CPUBrandController controller = new CPUBrandController();
              controller.setUserService(userService);  // Inject UserService into AdminDashboardController
              return controller;
          });
          root = loader.load();
          Scene scene = new Scene(root);
          stage.setScene(scene);
          stage.show();
      } catch (Exception e) {
          System.out.println("Error loading front CPU Brand scene: " + e.getMessage());
      }
    }

    public static class InvalidBudgetException extends Exception {
        public InvalidBudgetException(String message) {
            super(message);
        }
    }
}

