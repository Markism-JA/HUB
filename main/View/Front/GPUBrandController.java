package main.View.Front;

//import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Model.User;

public class GPUBrandController {
  private UserService userService;

  public void setUserService(UserService userService) {
      this.userService = userService;
  }

  private String gpuBrand; // String for budget tier

  @FXML
  private Button NVIDIA, AMD, NoPref;

  @FXML
  private void handleButtonAction(ActionEvent event) throws InvalidBudgetException {

    if (event.getSource() == NVIDIA) {
      gpuBrand = "NVIDIA";
    } else if (event.getSource() == AMD) {
      gpuBrand = "AMD";
    } else if (event.getSource() == NoPref) {
      gpuBrand = "No Preference";
    }

    User currentUser = userService.getCurrentUser();


    // Set the user's budget preference
    currentUser.getPreferences().setGpuBrand(gpuBrand);
    System.out.println(currentUser.getUserName() + " = Set GPU Brand: " + gpuBrand);

      // Load the new scene
      loadNewScene();
      
      //List<User> users = userService.getDataManager().getUsers();
      //for (User user : users) {
          //System.out.println(user.toString());
      //}
  }


  private void loadNewScene() {
      Stage stage = (Stage) NVIDIA.getScene().getWindow();
      Parent root = null;

      try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Storage.fxml")); // Replace with the actual path
        loader.setControllerFactory(c -> {
            StorageController controller = new StorageController();
            controller.setUserService(userService);  // Inject UserService into AdminDashboardController
            return controller;
        });
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } catch (Exception e) {
        System.out.println("Error loading front storage scene: " + e.getMessage());
    }
  }

  public static class InvalidBudgetException extends Exception {
      public InvalidBudgetException(String message) {
          super(message);
      }
  }
}
