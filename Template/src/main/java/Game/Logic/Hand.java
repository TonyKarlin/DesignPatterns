package Game.Logic;

import Game.Cards.Card;
import Game.Cards.DeckOfCards;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> myHand = new ArrayList<>();
    private final int handSize;
    private boolean stood = false;

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

    public void stand() {
        this.stood = true;
    }

    public boolean hasStood() {
        return stood;
    }

    public void addCard(Card card) {
        myHand.add(card);
    }

    public int getScore() {
        int score = 0;
        int aceCount = 0;

        for (Card card : myHand) {
            int cardValue = card.getRank().getValue();
            if (cardValue > 10) {
                score += 10;
            } else if (cardValue == 1) {
                aceCount++;
                score += 11;
            } else {
                score += cardValue;
            }
        }

        // Adjust for Aces if score is over 21
        while (score > 21 && aceCount > 0) {
            score -= 10; // Count one Ace as 1 instead of 11
            aceCount--;
        }

        return score;
    }

    public boolean isBlackjack() {
        return myHand.size() == 2 && getScore() == 21;
    }

    public void printHand(String name) {
        System.out.println(name + "'s hand: ");
        for (Card card : myHand) {
            System.out.println(card.toString());
        }
        System.out.println("Score: " + getScore() + "\n");
    }
}
