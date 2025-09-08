package Game.Cards;

public class Card {
    Suits suit;
    Ranks rank;

    public Card(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Ranks getRank() {
        return rank;
    }

    public Suits getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit + "S";
    }
}
