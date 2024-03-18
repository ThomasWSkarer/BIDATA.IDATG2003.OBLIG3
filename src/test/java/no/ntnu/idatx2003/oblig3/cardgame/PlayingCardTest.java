package no.ntnu.idatx2003.oblig3.cardgame;

import static org.junit.jupiter.api.Assertions.*;

import no.ntnu.idatx2003.oblig3.cardgame.backend.PlayingCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayingCardTest {
  PlayingCard playingCard;

  @BeforeEach
  void setUp() {
    playingCard = new PlayingCard('S', 8);
  }

  @Test
  void getAsStringPosTest() {
    assertEquals("S8", playingCard.getAsString());
  }

  @Test
  void getSuitPosTest() {
    assertEquals('S', playingCard.getSuit());
  }

  @Test
  void getFacePosTest() {
    assertEquals(8, playingCard.getFace());
  }
}