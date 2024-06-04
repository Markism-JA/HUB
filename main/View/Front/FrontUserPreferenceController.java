package main.View.Front;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class FrontUserPreferenceController {
  
    @FXML
    private Button startButton;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Stage stage = (Stage) startButton.getScene().getWindow();
        Parent root = null;

        try {
            // Load the Budget.fxml file
            root = FXMLLoader.load(getClass().getResource("Budget.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // Log the error details
            System.err.println("Error loading Budget.fxml: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
