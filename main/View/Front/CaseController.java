package main.View.Front;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.Model.PCBuild;
import main.Model.Recommendation;
import main.Model.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CaseController {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private String formFactor; // String for budget tier

    @FXML
    private Button ATX, MiniATX, MicroATX;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            if (event.getSource() == ATX) {
                formFactor = "atx";
            } else if (event.getSource() == MiniATX) {
                formFactor = "Mitx";
            } else if (event.getSource() == MicroATX) {
                formFactor = "Matx";
            }

            User currentUser = userService.getCurrentUser();

            // Set the user's form factor preference
            currentUser.getPreferences().setFormFactor(formFactor);
            System.out.println(currentUser.getUserName() + " = Set Form Factor: " + formFactor);

            Recommendation recommendation = new Recommendation(userService.getDataManager(), currentUser.getPreferences());
            recommendation.recommendComponents();

            PCBuild pcBuild = recommendation.recommendComponents();
            userService.getCurrentUser().setPCBuild(pcBuild);


            System.out.println();
            System.out.println(userService.getCurrentUser() +  "PC Build");
            System.out.println(userService.getCurrentUser().getPCBuild().getCpu());
            System.out.println(userService.getCurrentUser().getPCBuild().getMotherBoard());
            System.out.println(userService.getCurrentUser().getPCBuild().getRam());
            System.out.println(userService.getCurrentUser().getPCBuild().getGpu());
            System.out.println(userService.getCurrentUser().getPCBuild().getCase1());
            System.out.println(userService.getCurrentUser().getPCBuild().getPowerSupply());
            System.out.println(userService.getCurrentUser().getPCBuild().getFan());

            try (FileWriter fw = new FileWriter("main/Resources/data/PCBuild.csv", true);
            BufferedWriter writer = new BufferedWriter(fw)) {

                String cpu = userService.getCurrentUser().getPCBuild().getCpu().toString();
                String gpu = userService.getCurrentUser().getPCBuild().getGpu().toString();
                String Case = userService.getCurrentUser().getPCBuild().getCase1().toString();
                String psu = userService.getCurrentUser().getPCBuild().getPowerSupply().toString();
                String ram = userService.getCurrentUser().getPCBuild().getRam().toString();
                String motherboard = userService.getCurrentUser().getPCBuild().getMotherBoard().toString();
                String fan = userService.getCurrentUser().getPCBuild().getFan().toString();

                writer.write(cpu);
                writer.write(gpu);
                writer.write(Case);
                writer.write(psu);
                writer.write(ram);
                writer.write(motherboard);
                writer.write(fan);
                writer.newLine();
                writer.write("");
            } catch (IOException e) {
            e.printStackTrace();
            }   
            

            userService.getDataManager().saveData();

            System.out.println(userService.getCurrentUser().getUserName() + ": Preferences Set ");

            loadNewScene();
        } catch (Exception e) {
            System.out.println("Error handling button action: " + e.getMessage());
        }
    }

    private void loadNewScene() {
        Stage stage = (Stage) ATX.getScene().getWindow();
        Parent root = null;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml")); // Replace with the actual path
            loader.setControllerFactory(c -> {
                DashboardController controller = new DashboardController();
                controller.setUserService(userService);  // Inject UserService into AdminDashboardController
                return controller;
            });
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error loading dashboard scene: " + e.getMessage());
        }
    }
}
