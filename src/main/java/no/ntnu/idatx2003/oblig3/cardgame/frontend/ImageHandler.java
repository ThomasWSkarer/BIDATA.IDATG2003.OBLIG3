package no.ntnu.idatx2003.oblig3.cardgame.frontend;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.image.Image;
import no.ntnu.idatx2003.oblig3.cardgame.backend.PlayingCard;

public class ImageHandler {
  private Map<String, Image> cardImages = new HashMap<>(); // A map of the card images

  /**
   * Creates a new ImageHandler and loads the card images.
   */
  public ImageHandler() {
    loadCardImages();
  }

  /**
   * Loads the card images into the cardImages map.
   * The images are loaded from the resources' folder.
   * Minor modifications made to the original code.
   *
   * @author Skjalg C. Tøfte
   */
  private void loadCardImages() {
    char[] suits = {'H', 'S', 'D', 'C'};
    for (char suit : suits) {
      for (int face = 1; face <= 13; face++) {
        String imageName = String.valueOf(suit) + face + ".png";
        Image image = new Image(getClass().getResourceAsStream(
            "/cardimages/" + imageName));
        cardImages.put(imageName, image);
      }
    }
  }

  /**
   * Returns the image of a given card.
   *
   * @param card the card to get the image of
   * @return the image of the card
   * @author Skjalg C. Tøfte
   */
  public Image getCardImage(PlayingCard card) {
    String imageName = String.valueOf(card.getSuit()) + card.getFace() + ".png";
    return cardImages.get(imageName);
  }
}
