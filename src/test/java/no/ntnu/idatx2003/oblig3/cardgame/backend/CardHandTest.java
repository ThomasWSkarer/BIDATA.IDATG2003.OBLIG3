package no.ntnu.idatx2003.oblig3.cardgame.backend;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardHandTest {
  CardHand controlledHand;

  PlayingCard S8;
  PlayingCard H12;
  PlayingCard D3;

  @BeforeEach
  void setUp() {
    S8 = new PlayingCard('S', 8);
    H12 = new PlayingCard('H', 12);
    D3 = new PlayingCard('D', 3);

    controlledHand = new CardHand();
    controlledHand.addCard(S8);
    controlledHand.addCard(H12);
    controlledHand.addCard(D3);
  }

  @Test
  void contructorTest() {
    controlledHand = new CardHand();
    assertEquals(0, controlledHand.getHandSize(),
        "The hand size should be 0, but it is not");
  }

  @Test
  void getCardsTest() {
    assertTrue(controlledHand.checkIfCardInHand(S8) && controlledHand.checkIfCardInHand(H12)
        && controlledHand.checkIfCardInHand(D3),
        "The hand should include" + S8.getAsString() + ", " + H12.getAsString() + " and "
            + D3.getAsString() + ", but it does not");
  }

  @Test
  void addCard() {
    PlayingCard testCard = new PlayingCard('S', 12);
    controlledHand.addCard(testCard);
    assertTrue(controlledHand.checkIfCardInHand(testCard) && controlledHand.getHandSize() == 4,
        "the card " + testCard.getAsString() + "should be in the hand, but it is not"
    + "and the hand size should be 6, but it is " + controlledHand.getHandSize());
  }

  @Test
  void getHandSizeEquals() {
    assertEquals(3, controlledHand.getHandSize()
        , "The hand size should be 5, but turned out to be" + controlledHand.getHandSize());
  }

  @Test
  void getHandValueTestTrue() {
    assertEquals(23, controlledHand.getHandValue(),
        "The hand value should be 23, but turned out to be" + controlledHand.getHandValue());
  }

  @Test
  void getCardsOfSuit() {
    controlledHand.addCard(new PlayingCard('S', 9));

    assertEquals(controlledHand.getCardsOfSuit("S"), List.of(S8, new PlayingCard('S', 9)),
        "The hand should include S8 and S9, but it does not");

  }

  @Test
  void checkIfFlush() {
    controlledHand.clearHand();

    controlledHand.addCard(S8);
    controlledHand.addCard(new PlayingCard('S', 9));
    controlledHand.addCard(new PlayingCard('S', 10));
    controlledHand.addCard(new PlayingCard('S', 11));
    controlledHand.addCard(new PlayingCard('S', 12));

    assertTrue(controlledHand.checkIfFlush(), "The hand should be a flush, but it is not");
  }

  @Test
  void checkIfCardInHand() {
    assertTrue(controlledHand.checkIfCardInHand(S8),
        "The hand should include " + S8.getAsString() + ", but it does not");
  }

  @Test
  void clearHand() {
    controlledHand.clearHand();
    assertEquals(0, controlledHand.getHandSize(),
        "The hand size should be 0, but it is not");
  }
}