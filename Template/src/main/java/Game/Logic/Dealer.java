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
