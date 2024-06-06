package main.View.Front;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Model.User;

public class StorageController {
  private UserService userService;

  public void setUserService(UserService userService) {
      this.userService = userService;
  }

  private int storage; // String for budget tier

  @FXML
  private Button first, second, third, fourth, NoPref;

  @FXML
  private void handleButtonAction(ActionEvent event) throws InvalidBudgetException {

    if (event.getSource() == first) {
      storage = 256;
    } else if (event.getSource() == second) {
      storage = 512;
    } else if (event.getSource() == third) {
      storage = 1000;
    } else if (event.getSource() == NoPref) {
      storage = 0;
    }

    User currentUser = userService.getCurrentUser();


    // Set the user's budget preference
    currentUser.getPreferences().setStorage(storage);
    System.out.println(currentUser.getUserName() + " = Set Storage: " + storage);

      // Load the new scene
      loadNewScene();
  }


  private void loadNewScene() {
      Stage stage = (Stage) first.getScene().getWindow();
      Parent root = null;

      try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Ram.fxml")); // Replace with the actual path
        loader.setControllerFactory(c -> {
            RamController controller = new RamController();
            controller.setUserService(userService);  // Inject UserService into AdminDashboardController
            return controller;
        });
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } catch (Exception e) {
        System.out.println("Error loading front ram scene: " + e.getMessage());
    }
  }

  public static class InvalidBudgetException extends Exception {
      public InvalidBudgetException(String message) {
          super(message);
      }
  }
}
