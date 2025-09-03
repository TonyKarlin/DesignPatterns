package Game.Logic;

import Game.Cards.Card;
import Game.Cards.DeckOfCards;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> myHand = new ArrayList<>();
    private final int handSize;

    public Hand(int size) {
        this.handSize = size;
    }

    public List<Card> getMyHand() {
        return myHand;
    }

    public void deal(DeckOfCards deck) {
        deck.shuffle(deck.getDeck());
        for (int i = 0; i < handSize; i++) {
            if (!deck.getDeck().isEmpty()) {
                Card card = deck.getDeck().removeFirst();
                myHand.add(card);
            }
        }
    }

    public void printHand(String name) {
        System.out.println(name + "'s hand: ");
        for (Card card : myHand) {
            System.out.println(card.toString());
        }
    }
}
