package main.View.Front;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import main.Model.DataManager;


public class MainApp extends Application {
    private final DataManager dataManager = new DataManager("main/Resources/data");

    private UserService userService = UserService.getInstance(dataManager); 

    @Override
    public void start(Stage primaryStage) throws IOException {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("Front.fxml"));
        loader.setControllerFactory(c -> {
            FrontController controller = new FrontController();
            controller.setUserService(userService); // Inject DataManager
            return controller;
        });

        final Parent root = loader.load();
        final Scene scene = new Scene(root);

        primaryStage.setTitle("HUB");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}