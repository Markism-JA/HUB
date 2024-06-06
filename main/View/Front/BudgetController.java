package main.View.Front;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Model.User;
import main.Model.UserPreferences;

public class BudgetController {

  private UserService userService;

  public void setUserService(UserService userService) {
      this.userService = userService;
  }

  private String userBudgetTier; // String for budget tier

  @FXML
  private Button low, mid, high;

    @FXML
    private void handleButtonAction(ActionEvent event) throws InvalidBudgetException {

      if (event.getSource() == low) {
        userBudgetTier = "Low";
      } else if (event.getSource() == mid) {
        userBudgetTier = "Mid";
      } else if (event.getSource() == high) {
        userBudgetTier = "High";
      }

      User currentUser = userService.getCurrentUser();

      if (currentUser.getPreferences() == null) {
      // If not, create new preferences
      currentUser.setPreferences(new UserPreferences(null, null, null, null, 0, 0, null));
      }


      // Set the user's budget preference
      currentUser.getPreferences().setBudget(userBudgetTier);

      System.out.println(currentUser.getUserName() + " = Set Budget: " + userBudgetTier);

        // Load the new scene
        loadNewScene();
    }


    private void loadNewScene() {
        Stage stage = (Stage) low.getScene().getWindow();
        Parent root = null;

        try {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Purpose.fxml")); // Replace with the actual path
          loader.setControllerFactory(c -> {
              PurposeController controller = new PurposeController();
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
