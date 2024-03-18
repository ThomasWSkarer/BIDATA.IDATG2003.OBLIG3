package no.ntnu.idatx2003.oblig3.cardgame;

import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import no.ntnu.idatx2003.oblig3.cardgame.backend.CardHand;
import no.ntnu.idatx2003.oblig3.cardgame.backend.DeckOfCards;
import no.ntnu.idatx2003.oblig3.cardgame.backend.PlayingCard;
import no.ntnu.idatx2003.oblig3.cardgame.frontend.ImageHandler;

public class App extends Application {
  private ImageHandler cardImageHandler;
  private DeckOfCards deck;
  private CardHand hand;
  private HBox cardsDisplay;
  private VBox handInfoDisplay;
  private static final int WIDTH = 600;
  private static final int HEIGHT = 400;

  @Override
  public void start(Stage stage) throws IOException {
    cardsDisplay = new HBox(10);
    cardImageHandler = new ImageHandler();


    // Buttons
    Button generateHand = new Button("Generate Hand");

    // ButtonEvents
    generateHand.setOnAction(e -> newHand());

    // ButtonBox
    HBox buttonBox = new HBox();
    buttonBox.setAlignment(Pos.CENTER); // Center the button
    buttonBox.getChildren().add(generateHand);

    BorderPane.setMargin(buttonBox, new Insets(0, 0, 10,0));

    // CardDisplay
    cardsDisplay.setAlignment(Pos.CENTER);

    // handInfoDisplay
    handInfoDisplay = new VBox(2);
    handInfoDisplay.setAlignment(Pos.BOTTOM_LEFT);

    BorderPane.setMargin(handInfoDisplay, new Insets(0, 0, 10, 10));


    // BorderPane
    StackPane root = new StackPane();

    BorderPane infoPane = new BorderPane();
    infoPane.setLeft(handInfoDisplay);

    BorderPane gamePane = new BorderPane();
    gamePane.setCenter(cardsDisplay);
    gamePane.setBottom(buttonBox);

    root.getChildren().addAll(infoPane, gamePane);

    // Scene
    Scene scene = new Scene(root, WIDTH, HEIGHT);

    // Stage
    stage.setTitle("Card Game");
    stage.setScene(scene);
    stage.show();
  }

  /**
   * Generates a new hand of cards.
   */
  private void newHand() {
    if (deck == null) {
      deck = new DeckOfCards(true);
    }
    hand = deck.dealHand(5);

    displayHand();
    displayHandInfo();
  }

  /**
   * Displays the hand of cards.
   */
  private void displayHand() {
    cardsDisplay.getChildren().clear();
    for (PlayingCard card : hand.getCards()) {
      ImageView imageView = new ImageView(cardImageHandler.getCardImage(card));
      imageView.setFitWidth(100);
      imageView.setFitHeight(150);
      cardsDisplay.getChildren().add(imageView);
    }
  }

  /**
   * Displays the hand info.
   * Includes: sum of the faces, cards of the heart suit, if it includes the queen of spades,
   * and if the hand is a flush.
   */
  private void displayHandInfo() {
    handInfoDisplay.getChildren().clear();
    handInfoDisplay.getChildren().addAll(checkSumOfHand(), cardsOfEachSuit(),
        queenOfSpades(), checkIfFlush());
  }

  /**
   * Calculates the sum of the faces of the hand and returns it as a label.
   *
   * @return the sum of the faces of the hand as a label.
   */
  private Label checkSumOfHand() {
    return new Label("Sum of faces: " + hand.getHandValue());
  }

  /**
   * Creates a label with the cards that have hearts.
   *
   * @return a label of all the cards with hearts as their suit.
   */
  private Label cardsOfEachSuit() {
    StringBuilder builder = new StringBuilder();
    for (PlayingCard card : hand.getCardsOfSuit("H")) {
      builder.append(card.getAsString()).append(" ");
    }
    return new Label("Cards of hearts: " + builder);
  }

  /**
   * Returns a label including .
   *
   * @return if the hand includes the queen of spades as a label.
   */
  private Label queenOfSpades() {
    return new Label("Queen of spades: " + hand.checkIfCardInHand("S12"));
  }

  private Label checkIfFlush() {
    return new Label("Flush: " + hand.checkIfFlush());
  }


  public static void main(String[] args) {
    launch();
  }
}
