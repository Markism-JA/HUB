package main.View.Front;

import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.Model.PCBuild;

import java.io.IOException;

public class DashboardController implements Initializable{


    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @FXML
    private Label cpuLabel;
    @FXML
    private Label gpuLabel;
    
    @FXML
    private Label motherBoardLabel;
    
    @FXML
    private Label ramLabel;
    
    @FXML
    private Label fanLabel;
    
    @FXML
    private Label caseLabel;
    
    @FXML
    private Label psuLabel;

    @FXML
    private Label cpuPrice; 
    
    @FXML
    private Label gpuPrice;
    
    @FXML
    private Label motherBoardPrice;
    
    @FXML
    private Label ramPrice;
    
    @FXML
    private Label fanPrice;
    
    @FXML
    private Label casePrice;
    
    @FXML
    private Label psuPrice;
    
    @FXML
    private Button  saveButton;

    @FXML
    private Button  buyButton;
    @Override

    public void initialize(URL location, ResourceBundle resources) {
        // Update labels on scene load
        updateComponentLabels();
    }

    private void updateComponentLabels() {
        if (userService != null && userService.getCurrentUser() != null && userService.getCurrentUser().getPCBuild() != null) {
            PCBuild pcBuild = userService.getCurrentUser().getPCBuild();
            cpuLabel.setText(pcBuild.getCpu().getModel());
            gpuLabel.setText(pcBuild.getGpu().getBrand());
            motherBoardLabel.setText(pcBuild.getMotherBoard().getModel());
            ramLabel.setText(pcBuild.getRam().getModel());
            fanLabel.setText(pcBuild.getFan().getModel());
            caseLabel.setText(pcBuild.getCase1().getModel());
            psuLabel.setText(pcBuild.getPowerSupply().getModel());

            cpuPrice.setText(String.valueOf(pcBuild.getCpu().getPrice()));
            gpuPrice.setText(String.valueOf(pcBuild.getGpu().getPrice()));
            motherBoardPrice.setText(String.valueOf(pcBuild.getMotherBoard().getPrice()));
            ramPrice.setText(String.valueOf(pcBuild.getRam().getPrice()));
            fanPrice.setText(String.valueOf(pcBuild.getFan().getPrice()));
            casePrice.setText(String.valueOf(pcBuild.getCase1().getPrice()));
            psuPrice.setText(String.valueOf(pcBuild.getPowerSupply().getPrice()));
        } else {
            // Handle case where user or PCBuild is not available (set default values or display error message)
            System.out.println("User or PCBuild information not available.");
        }
    }
    @FXML
    private void handleButtonAction(ActionEvent event) {

    }
    
}
    


