package no.ntnu.idatx2003.oblig3.cardgame;

public class CardHand {
  private PlayingCard[] cards;

  public CardHand() {
  }

  public CardHand(PlayingCard[] cards) {
    this.cards = cards;
  }

  private PlayingCard[] getCards() {
    return cards;
  }

  private void setCards(PlayingCard[] toAdd) {
    cards = toAdd;
  }

  public void addCard(PlayingCard card) {
    cards[getHandSize()+1] = card;
  }

  private int getHandSize() {
    return cards.length;
  }


}
