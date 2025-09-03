package Game.Cards;

public class Card {
    Suits suit;
    Ranks rank;

    public Card(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit + "S";
    }
}
