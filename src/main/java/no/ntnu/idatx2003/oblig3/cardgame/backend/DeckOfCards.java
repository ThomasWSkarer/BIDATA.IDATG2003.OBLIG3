package no.ntnu.idatx2003.oblig3.cardgame.backend;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Represents a deck of cards. A deck of cards is a collection of playing cards.
 */
public class DeckOfCards {
  Iterator<PlayingCard> it;
  private ArrayList<PlayingCard> cards; // An array representing a deck of cards.

  /**
   * Constructs a new deck of cards.
   */
  public DeckOfCards(boolean shuffleOrNot) {
    this.cards = new ArrayList<>();

    resetCards();
    if (shuffleOrNot) {
      shuffle();
    }
    //cards.forEach(card -> System.out.println(card.getAsString())); was for testing purposes
  }

  /**
   * Resets the deck of cards to its original state.
   */
  private void resetCards() {
    cards.clear();

    final char[] suits = { 'S', 'H', 'D', 'C' }; // 'S'=spade, 'H'=heart, 'D'=diamonds, 'C'=clubs
    final int[] faces = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 }; // 1=ace, 11=knight, 12=queen, 13=king

    int i = 0;
    for (char suit : suits) {
      for (int face : faces) {
        this.cards.add(i++, new PlayingCard(suit, face));
      }
    }
  }

  /**
   * Returns a hand of cards.
   *
   * @param n the number of cards to deal
   * @return a hand of n amount of cards
   */
  public CardHand dealHand(int n) {
    CardHand hand = new CardHand();

    if (n > cards.size()) {
      resetCards();
      shuffle();
    }

    List<PlayingCard> toBeRemoved = new ArrayList<>();
    it = cards.stream().limit(n).iterator();

    while (it.hasNext()) {
      PlayingCard card = it.next();

      hand.addCard(card);
      toBeRemoved.add(card);
    }
    cards.removeAll(toBeRemoved);

    return hand;
  }

  /**
   * Shuffles the deck of cards, done using random.
   */
  public void shuffle() {
    Random random = new Random();
    for (int i = 0; i < cards.size(); i++) {

      int randomIndex = random.nextInt(cards.size());
      swapCardPositions(i, randomIndex);
    }
  }

  /**
   * Swaps the positions of two cards in the deck.
   *
   * @param posA the position of the first card
   * @param posB the position of the second card
   */
  private void swapCardPositions(int posA, int posB) {
    PlayingCard cardA = cards.get(posA);
    PlayingCard cardB = cards.get(posB);
    cards.set(posA, cardB);
    cards.set(posB, cardA);
  }

}
