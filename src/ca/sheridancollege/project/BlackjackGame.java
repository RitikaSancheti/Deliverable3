/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author ritikasancheti
 */
public class BlackjackGame extends Game {
    
    private GroupOfCards deck; // The deck of cards
    private BlackjackPlayer dealer; // The dealer in the game

    
    GroupOfCards groupOfCards = new GroupOfCards(52);

    // Constructor
    public BlackjackGame(String gameName) {
        super(gameName);
        deck = new GroupOfCards(52); // Standard deck of 52 cards
        dealer = new BlackjackPlayer("Dealer", deck); // Pass the deck to the dealer
    }

    // Shuffle the deck
    public void shuffleDeck() {
        deck.shuffle();
    }
    
    // Deal cards to players and dealer
    public void dealCards() {
        // Iterate through each player
        for (Player player : getPlayers()) {
            if (player instanceof BlackjackPlayer) {
                BlackjackPlayer blackjackPlayer = (BlackjackPlayer) player;
                // Draw two random cards for each player
                blackjackPlayer.addCard((BlackjackCard) deck.drawRandomCard()); // First card
                blackjackPlayer.addCard((BlackjackCard) deck.drawRandomCard()); // Second card
            }
        }
        // Deal two cards to the dealer as well
        dealer.addCard((BlackjackCard) deck.drawRandomCard()); // First card for dealer
        dealer.addCard((BlackjackCard) deck.drawRandomCard()); // Second card for dealer
    }

    // Show the initial hands of the players and dealer
    public void showHands() {
        for (Player player : getPlayers()) {
            if (player instanceof BlackjackPlayer) {
                ((BlackjackPlayer) player).showHand();
            }
        }
        System.out.println("Dealer's hand: ");
        dealer.showHand();
    }

    
    // Implement the abstract play method to execute the game
    @Override
    public void play() {
        // Shuffle the deck and deal cards
        shuffleDeck();
        dealCards();

        // Players take their turns
        for (Player player : getPlayers()) {
            if (player instanceof BlackjackPlayer) {
                ((BlackjackPlayer) player).play(); // Interactive player turn
            }
        }

        // Dealer's turn (dealer will hit until they reach 17)
        while (dealer.getScore() < 17) {
            System.out.println("Dealer hits.");
            BlackjackCard newCard = (BlackjackCard) deck.drawRandomCard();
            dealer.addCard(newCard);
            dealer.showHand();
        }

        // If dealer busts
        if (dealer.getScore() > 21) {
            System.out.println("Dealer busts!");
        }
    }

    
    // Declare the winner of the game
    
    // Declare the winner of the game
    @Override
    public void declareWinner() {
        int maxScore = 0;
        BlackjackPlayer winner = null;

        // Check each player's score to determine the winner
        for (Player player : getPlayers()) {
            if (player instanceof BlackjackPlayer) {
                BlackjackPlayer blackjackPlayer = (BlackjackPlayer) player;
                if (blackjackPlayer.getScore() > maxScore && blackjackPlayer.getScore() <= 21) {
                    maxScore = blackjackPlayer.getScore();
                    winner = blackjackPlayer;
                }
            }
        }

        // If no winner found, all players busted
        if (winner == null) {
            System.out.println("No winner, all players busted!");
        } else {
            System.out.println("The winner is " + winner.getPlayerID() + " with a score of " + winner.getScore());
        }
    }
}