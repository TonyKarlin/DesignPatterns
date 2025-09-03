import Game.Cards.DeckOfCards;
import Game.Logic.Dealer;
import Game.Logic.GameType;
import Game.Logic.Hand;

public class Main {
    public static void main(String[] args) {
        Dealer dealer = new Dealer(GameType.HOLDEM);
        dealer.play(1);
    }
}
