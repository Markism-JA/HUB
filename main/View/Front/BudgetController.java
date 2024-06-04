package main.View.Front;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BudgetController {

  private String userBudget;
  
  @FXML
  private Button low, mid, high, startButton;

  @FXML
  private void handleButtonAction(ActionEvent event) {
    Button clickedButton = (Button) event.getSource();
    
    if (clickedButton == low) {
      System.out.println("Low Budget Selected");
      userBudget = "Low";
    } else if (clickedButton == mid) {
      System.out.println("Mid Budget Selected");
      userBudget = "Mid";
    } else if (clickedButton == high) {
      System.out.println("High Budget Selected");
      userBudget = "High";
    }

    


    
    // Load the new scene
    loadNewScene();

  }

  private void loadNewScene() {
    Stage stage = (Stage) startButton.getScene().getWindow();
    Parent root = null;

    try {
      root = FXMLLoader.load(getClass().getResource("Budget.fxml"));
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
    } catch (IOException e) {
      System.err.println("Error loading Budget.fxml: " + e.getMessage());
      e.printStackTrace();
    }
  }
}