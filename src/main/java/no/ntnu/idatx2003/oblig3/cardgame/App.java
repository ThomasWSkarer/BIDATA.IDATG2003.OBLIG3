package no.ntnu.idatx2003.oblig3.cardgame;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    BorderPane root = new BorderPane();
    Scene scene = new Scene(root, 600, 400);
    stage.setTitle("Card Game");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
