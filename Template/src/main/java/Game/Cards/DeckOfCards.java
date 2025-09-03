package Game.Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    private final List<Card> deck = new ArrayList<>();

    public DeckOfCards() {
        initializeDeck();
    }

    public List<Card> getDeck() {
        return deck;
    }


    public void removeCard(Card card) {
        deck.remove(card);
    }

    public void initializeDeck() {
        for (Suits s : Suits.values()) {
            for (Ranks r : Ranks.values()) {
                Card card = new Card(s, r);
                deck.add(card);
            }
        }
        shuffle(deck);
    }

    public void shuffle(List<Card> deck) {
        Collections.shuffle(deck);
    }
}
