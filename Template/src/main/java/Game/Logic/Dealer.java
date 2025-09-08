package Game.Logic;

import Game.Cards.Card;
import Game.Cards.DeckOfCards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealer extends Game {
    private final DeckOfCards deck;
    private final List<Hand> playersHands = new ArrayList<>();
    private Hand dealerHand;
    private final Scanner scanner = new Scanner(System.in);


    public Dealer() {
        this.deck = new DeckOfCards();
    }

    @Override
    public void initializeGame(int numberOfPlayers) {
        int handSize = 2;   // Default hand size for each player (Blackjack)
        for (int i = 0; i < numberOfPlayers; i++) {
            Hand hand = new Hand(handSize);
            hand.deal(deck);
            hand.printHand("Player " + (i + 1));
            playersHands.add(hand);

            if (hand.isBlackjack()) {
                System.out.println("Player " + (i + 1) + " has Blackjack!");
                hand.stand();
            }
        }

        dealerHand = new Hand(handSize);
        dealerHand.deal(deck);
        if (dealerHand.isBlackjack()) {
            System.out.println("Dealer has a natural Blackjack!");
            System.out.println("Dealer's hand: ");
            dealerHand.printHand("Dealer");
            dealerHand.stand();
        } else {
            System.out.println("Dealer's visible hand: " + dealerHand.getMyHand().getFirst());
            System.out.println("Dealer's visible score: " + dealerHand.getMyHand().getFirst().getRank().getValue());
        }
    }

    @Override
    public boolean endOfGame() {
        for (Hand hand : playersHands) {
            if (hand.getScore() <= 21 && !hand.hasStood()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void playSingleTurn(int player) {
        Hand hand = playersHands.get(player);
        if (hand.getScore() > 21 || hand.hasStood()) {
            return;
        }

        System.out.println("\nPlayer " + (player + 1) + "'s turn. Current score: " + hand.getScore());
        System.out.println("Do you want to Hit or Stand? (H/S)");
        String input = scanner.nextLine().trim().toUpperCase();

        if (input.equalsIgnoreCase("h")) {
            Card card = deck.getDeck().removeFirst();
            hand.addCard(card);
            System.out.println("You drew: " + card);
            System.out.println("New score: " + hand.getScore());

            if (hand.getScore() > 21) {
                System.out.println("Bust! You exceeded 21.");
            }
        } else if (input.equalsIgnoreCase("s")) {
            hand.stand();
        }
    }

    @Override
    public void displayWinner() {
        while (dealerHand.getScore() < 17) {
            Card card = deck.getDeck().removeFirst();
            dealerHand.addCard(card);
        }
        System.out.println("\nDealer's hand:");
        dealerHand.printHand("Dealer");
        System.out.println("Dealer's score: " + dealerHand.getScore());

        int dealerScore = dealerHand.getScore();
        for (int i = 0; i < playersHands.size(); i++) {
            Hand hand = playersHands.get(i);
            int score = hand.getScore();
            System.out.println("\nPlayer " + (i + 1) + " score: " + score);

            if (score > 21) {
                System.out.println("Player " + (i + 1) + " busted. Dealer wins.");
            } else if (dealerScore > 21 || score > dealerScore) {
                System.out.println("Player " + (i + 1) + " wins!");
            } else if (score == dealerScore) {
                System.out.println("Player " + (i + 1) + " pushes (tie).");
            } else {
                System.out.println("Dealer wins against Player " + (i + 1));
            }
        }
    }
}
