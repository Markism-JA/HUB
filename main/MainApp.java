package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MainApp extends Application{

  Button button;
  StackPane stackPane;
  Text text;
  public static void main(String[] args) {
    launch(args)0;
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("PrimaryStage");

    button = new Button();
    button.setText("Test");

    text = new Text();
    text.setText("Admin");

    stackPane = new StackPane();
    stackPane.getChildren().add(button);
    stackPane.getChildren().add(text);

    Scene scene = new Scene(stackPane, 500, 300);
    primaryStage.setScene(scene);
    primaryStage.show();
  }


}
