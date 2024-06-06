package main.View.Front;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Model.User;

public class CPUBrandController {
    private UserService userService;

  public void setUserService(UserService userService) {
      this.userService = userService;
  }

  private String cpuBrand; // String for budget tier

  @FXML
  private Button Intel, AMD, NoPref;

    @FXML
    private void handleButtonAction(ActionEvent event) throws InvalidBudgetException {

      if (event.getSource() == Intel) {
        cpuBrand = "Intel";
      } else if (event.getSource() == AMD) {
        cpuBrand = "AMD";
      } else if (event.getSource() == NoPref) {
        cpuBrand = "No Preference";
      }

      User currentUser = userService.getCurrentUser();


      // Set the user's budget preference
      currentUser.getPreferences().setCpuBrand(cpuBrand);
      System.out.println(currentUser.getUserName() + " = Set CPU Brand: " + cpuBrand);

        // Load the new scene
        loadNewScene();
    }


    private void loadNewScene() {
        Stage stage = (Stage) Intel.getScene().getWindow();
        Parent root = null;

        try {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("GPUBrand.fxml")); // Replace with the actual path
          loader.setControllerFactory(c -> {
              GPUBrandController controller = new GPUBrandController();
              controller.setUserService(userService);  // Inject UserService into AdminDashboardController
              return controller;
          });
          root = loader.load();
          Scene scene = new Scene(root);
          stage.setScene(scene);
          stage.show();
      } catch (Exception e) {
          System.out.println("Error loading front GPU Brand scene: " + e.getMessage());
      }
    }

    public static class InvalidBudgetException extends Exception {
        public InvalidBudgetException(String message) {
            super(message);
        }
    }
}
