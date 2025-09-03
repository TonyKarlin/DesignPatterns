import Game.Cards.DeckOfCards;
import Game.Poker.Hand;

public class Main {
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();

        Hand myHand = new Hand(2);
        myHand.deal(deck);
        myHand.printHand("Bob");
    }
}
