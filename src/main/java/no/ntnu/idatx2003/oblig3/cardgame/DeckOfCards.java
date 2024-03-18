package no.ntnu.idatx2003.oblig3.cardgame;

public class DeckOfCards {

  public DeckOfCards() {
    final char[] suits = { 'S', 'H', 'D', 'C' }; // 'S'=spade, 'H'=heart, 'D'=diamonds, 'C'=clubs
    final int[] faces = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 }; // 1=ace, 11=knight, 12=queen, 13=king

    PlayingCard[] cards = new PlayingCard[52];
    int i = 0;
    for (char suit : suits) {
      for (int face : faces) {
        cards[i++] = new PlayingCard(suit, face);
      }
    }
  }



}
