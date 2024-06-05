package main.View.Front;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Model.DataManager;
import main.View.Front.MainApp;

public class AdminController {
    private MainApp mainApp;
    private final String ADMINNAME = "@admin", ADMINPASS = "@admin";
    private DataManager dataManager;
    
    @FXML
    private TextField adminName;
    
    @FXML
    private PasswordField adminPass;
    
    @FXML
    private Label errorLabelName;

    @FXML
    private Label errorLabelPass;
    
    @FXML
    private Button adminAccess;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @FXML
    private void handleAdminAccess(ActionEvent  event) {
        String name = adminName.getText();
        String pass = adminPass.getText();

        Stage stage = (Stage) adminAccess.getScene().getWindow();
        Parent root = null;

        if (!name.equals(ADMINNAME)) {
            errorLabelName.setText("Incorrect admin name");
        } else if (!pass.equals(ADMINPASS)) {
            errorLabelPass.setText("Incorrect admin password");
        } else if (name.equals(ADMINNAME) && pass.equals(ADMINPASS)) {
            errorLabelName.setText("");
            errorLabelPass.setText("");

            try {
                root = FXMLLoader.load(getClass().getResource(null));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                System.out.println("Error loading admin dashboard scene: " + e.getMessage());
            }
        }
    }
}