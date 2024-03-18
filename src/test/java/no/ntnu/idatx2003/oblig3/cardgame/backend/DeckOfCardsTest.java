package no.ntnu.idatx2003.oblig3.cardgame.backend;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckOfCardsTest {
  DeckOfCards deckOfCards;

  @BeforeEach
  void setUp() {
    deckOfCards = new DeckOfCards(true);
  }

  @Test
  void dealHandPosTest() {
    deckOfCards.dealHand(5);
    assertEquals(5, deckOfCards.dealHand(5).getHandSize());
  }

  @Test
  void dealHandNegTest() {
    deckOfCards.dealHand(5);
    assertNotEquals(0, deckOfCards.dealHand(5).getHandSize());
  }

  @Test
  void shuffleNegTest() {
    DeckOfCards toTest = new DeckOfCards(false);
    toTest.shuffle();
    assertNotEquals(toTest, deckOfCards);
  }
}