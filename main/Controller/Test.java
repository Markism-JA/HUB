package main.Controller;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Test extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Click me!");
        Scene scene = new Scene(button, 200, 250);
        primaryStage.setTitle("MyJavaFX!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

public static void main(String[] args) {
    Application.launch(args);
}
}