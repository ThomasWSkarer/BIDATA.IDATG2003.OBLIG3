package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.Random;

public class DeckOfCards {
  private PlayingCard[] cards;

  /**
   * Creates a new deck of cards, where the cards are ordered in a standard fashion.
   * That is, the cards are ordered by suit (spades, hearts, diamonds and clubs) and
   * by face value (from ace of spades, to king of clubs).
   * The deck is then shuffled, so that the cards are placed in a random order.
   */
  public DeckOfCards() {
    final char[] suits = { 'S', 'H', 'D', 'C' }; // 'S'=spade, 'H'=heart, 'D'=diamonds, 'C'=clubs
    final int[] faces = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 }; // 1=ace, 11=knight, 12=queen, 13=king

    cards = new PlayingCard[52];
    int i = 0;
    for (char suit : suits) {
      for (int face : faces) {
        cards[i++] = new PlayingCard(suit, face);
      }
    }
    shuffle();
  }

  /**
   * Returns a hand of cards.
   *
   * @param n the number of cards to deal
   * @return a hand of n amount of cards
   */
  public CardHand dealHand(int n) {
    CardHand hand = new CardHand();
    for (int i = 0; i < n; i++) {
      hand.addCard(cards[i]);
    }
    return hand;
  }

  /**
   * Shuffles the deck of cards, done using random.
   */
  private void shuffle() {
    Random random = new Random();

    int[] randos = random.ints(52).toArray();
    for (int i = 0; i < randos.length; i++) {
      swapCardPositions(i, randos[i]);
    }
  }

  /**
   * Swaps the positions of two cards in the deck.
   *
   * @param i the position of the first card
   * @param j the position of the second card
   */
  private void swapCardPositions(int i, int j) {
    PlayingCard temp = cards[i];
    cards[i] = cards[j];
    cards[j] = temp;
  }

}
