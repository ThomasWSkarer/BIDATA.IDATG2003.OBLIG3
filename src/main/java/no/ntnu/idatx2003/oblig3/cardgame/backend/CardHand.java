package no.ntnu.idatx2003.oblig3.cardgame.backend;

import java.util.List;

public class CardHand {
  private List<PlayingCard> cards; // A list including the cards in the hand

  /**
   * Creates a new hand of cards. This is the default constructor.
   */
  public CardHand() {
    this.cards = List.of();
  }

  /**
   * Creates a new hand of cards.
   *
   * @param cards the cards in the hand.
   */
  public CardHand(PlayingCard[] cards) {
    this.cards = List.of(cards);
  }

  /**
   * Returns the cards in the hand.
   *
   * @return the cards in the hand.
   */
  private List<PlayingCard> getCards() {
    return cards;
  }

  /**
   * Adds a card to the hand.
   *
   * @param card the card to add to the hand.
   */
  public void addCard(PlayingCard card) {
    cards.add(card);
  }

  /**
   * Returns the number of cards in the hand.
   *
   * @return the number of cards in the hand.
   */
  public int getHandSize() {
    return cards.size();
  }

  /**
   * Returns the total value of the hand.
   * The value of the hand is the sum of the faces.
   *
   * @return the total value of the hand.
   */
  public int getHandValue() {
    return cards.stream().mapToInt(PlayingCard::getFace).sum();
  }

  /**
   * Returns cards in the hand of a given suit.
   *
   * @param suit the suit to filter by.
   * @return the cards that are of the suit.
   */
  public List<PlayingCard> getCardsOfSuit(String suit) {
    if (suit.length() != 1) {
      throw new IllegalArgumentException("Parameter suit must be a single character");
    } else {
      return cards.stream().filter(card -> card.getSuit() == suit.charAt(0)).toList();
    }
  }

  /**
   * Checks if the hand is a flush.
   *
   * @return true if the hand is a flush, false otherwise.
   */
  public boolean checkIfFlush() {
    return cards.stream().allMatch(card -> card.getSuit() == cards.get(0).getSuit());
  }

  /**
   * Checks if a card is in the hand.
   *
   * @param card the card to check for.
   * @return true if the card is in the hand, false otherwise.
   */
  public boolean checkIfCardInHand(PlayingCard card) {
    return cards.contains(card);
  }

  /**
   * Clears the hand of all cards.
   */
  public void clearHand() {
    cards.clear();
  }


}