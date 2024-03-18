package no.ntnu.idatx2003.oblig3.cardgame;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import no.ntnu.idatx2003.oblig3.cardgame.backend.PlayingCard;
import no.ntnu.idatx2003.oblig3.cardgame.frontend.ImageHandler;

public class App extends Application {
  private HBox cardDisplay;
  private static final int WIDTH = 600;
  private static final int HEIGHT = 400;

  @Override
  public void start(Stage stage) throws IOException {
    cardDisplay = new HBox(10);
    // Buttons
    Button generateImage = new Button("Generate Image");

    // ButtonEvents
    generateImage.setOnAction(e -> testOneCard());

    // ButtonBox
    HBox buttonBox = new HBox();
    buttonBox.getChildren().add(generateImage);

    // ButtonBox

    // Labels
    Label helloThere = new Label("Hello there!");


    // Images
    // hbox

    // BorderPane
    BorderPane root = new BorderPane();
    //root.setCenter(helloThere);
    root.setCenter(buttonBox);
    root.setTop(cardDisplay);

    // Scene
    Scene scene = new Scene(root, WIDTH, HEIGHT);

    // Stage
    stage.setTitle("Card Game");
    stage.setScene(scene);
    stage.show();
  }

  private void testOneCard() {
    ImageHandler imageHandler = new ImageHandler();
    PlayingCard card = new PlayingCard('H', 12);
    ImageView imageView = new ImageView(imageHandler.getCardImage(card));
    imageView.setFitWidth(100);
    imageView.setFitHeight(150);
    cardDisplay.getChildren().add(imageView);
  }


  public static void main(String[] args) {
    launch();
  }
}
