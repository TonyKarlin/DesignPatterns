package Game.Logic;

import Game.Cards.DeckOfCards;

public class Dealer extends Game{
    DeckOfCards deck;
    GameType type;

    public Dealer(GameType type) {
        this.deck = new DeckOfCards();
        this.type = type;
    }

    @Override
    public void initializeGame(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            Hand hand = new Hand(type.getValue());
            hand.deal(deck);
            hand.printHand("Player " + (i + 1));
        }
    }

    @Override
    public boolean endOfGame() {
        return false;
    }

    @Override
    public void playSingleTurn(int player) {

    }

    @Override
    public void displayWinner() {

    }
}
