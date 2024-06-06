package main.View.Front;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Model.User;

import main.Model.Recommendation;

import java.util.List;

public class CaseController {
  private UserService userService;

  public void setUserService(UserService userService) {
      this.userService = userService;
  }

  private String formFactor; // String for budget tier

  @FXML
  private Button ATX, MiniATX, MicroATX;

  @FXML
  private void handleButtonAction(ActionEvent event) throws InvalidBudgetException {

    if (event.getSource() == ATX) {
      formFactor = "ATX";
    } else if (event.getSource() == MiniATX) {
      formFactor = "Mini-ATX";
    } else if (event.getSource() == MicroATX) {
      formFactor = "Micro-ATX";
    }

    User currentUser = userService.getCurrentUser();


    // Set the user's budget preference
    currentUser.getPreferences().setFormFactor(formFactor);
    System.out.println(currentUser.getUserName() + " = Set Form Factor: " + formFactor);

    Recommendation recommendation =  new Recommendation(userService.getDataManager(), userService.getCurrentUser().getPreferences());
          
    System.out.println(userService.getCurrentUser().getUserName() + ": Preferences Set ");
      
    loadNewScene();


  }


  private void loadNewScene() {
      Stage stage = (Stage) ATX.getScene().getWindow();
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
        System.out.println("Error loading front form factor scene: " + e.getMessage());
    }
  }

  public static class InvalidBudgetException extends Exception {
      public InvalidBudgetException(String message) {
          super(message);
      }
  }
}
