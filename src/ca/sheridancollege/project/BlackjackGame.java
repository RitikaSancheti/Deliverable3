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
 * BlackjackGame class represents the game logic for Blackjack.
 * It extends the Game class and includes functionality for shuffling the deck,
 * dealing cards, handling players' and dealer's turns, and declaring the winner.
 * 
 * @author ritikasancheti
 */
public class BlackjackGame extends Game {
    
    private GroupOfCards deck; // The deck of cards
    private BlackjackPlayer dealer; // The dealer in the game

    
    GroupOfCards groupOfCards = new GroupOfCards(52); // Create a new deck of 52 cards

    // Constructor: Initializes the game with a deck of cards and a dealer
    public BlackjackGame(String gameName) {
        super(gameName); // Calls the superclass constructor to set the game name
        deck = new GroupOfCards(52); // Standard deck of 52 cards
        dealer = new BlackjackPlayer("Dealer", deck); // Create a dealer player and pass the deck reference
    }

    // Shuffle the deck
    public void shuffleDeck() {
        deck.shuffle(); // Shuffle the deck to randomize card order
    }
    
    
    // Deal two cards to each player and the dealer
    public void dealCards() {
        // Iterate through each player and deal two cards to each
        for (Player player : getPlayers()) {
            if (player instanceof BlackjackPlayer) { // Ensure the player is a BlackjackPlayer
                BlackjackPlayer blackjackPlayer = (BlackjackPlayer) player;
                // Draw two random cards for the player
                blackjackPlayer.addCard((BlackjackCard) deck.drawRandomCard()); // First card
                blackjackPlayer.addCard((BlackjackCard) deck.drawRandomCard()); // Second card
            }
        }
        // Deal two cards to the dealer as well
        dealer.addCard((BlackjackCard) deck.drawRandomCard()); // First card for dealer
        dealer.addCard((BlackjackCard) deck.drawRandomCard()); // Second card for dealer
    }
    
    
    // Show the initial hands of all players and the dealer
    public void showHands() {
        // Iterate through each player and show their hand
        for (Player player : getPlayers()) {
            if (player instanceof BlackjackPlayer) { // Ensure the player is a BlackjackPlayer
                ((BlackjackPlayer) player).showHand(); // Display the player's hand
            }
        }
        // Show the dealer's hand
        System.out.println("Dealer's hand: ");
        dealer.showHand(); // Display the dealer's hand
    }


    
    // Implement the abstract play method to execute the game
    // Implement the abstract play method to execute the game
    @Override
    public void play() {
        shuffleDeck(); // Shuffle the deck at the beginning of the game
        dealCards(); // Deal cards to players and dealer

        // Players take their turns (interactive)
        for (Player player : getPlayers()) {
            if (player instanceof BlackjackPlayer) { // Ensure the player is a BlackjackPlayer
                ((BlackjackPlayer) player).play(); // Execute player's turn
            }
        }

        // Dealer's turn (dealer will hit until their score is 17 or more)
        while (dealer.getScore() < 17) {
            System.out.println("Dealer hits."); // Inform that the dealer is hitting
            BlackjackCard newCard = (BlackjackCard) deck.drawRandomCard(); // Draw a new card for the dealer
            dealer.addCard(newCard); // Add the card to the dealer's hand
            dealer.showHand(); // Show the updated dealer's hand
        }

        // If the dealer busts (score exceeds 21), announce it
        if (dealer.getScore() > 21) {
            System.out.println("Dealer busts!"); // Dealer has exceeded 21, so they bust
        }
    }
    
    
    // Declare the winner of the game based on the highest score
    @Override
    public void declareWinner() {
        int maxScore = 0; // Track the highest score found
        BlackjackPlayer winner = null; // Track the winning player

        // Check each player's score to determine the winner
        for (Player player : getPlayers()) {
            if (player instanceof BlackjackPlayer) { // Ensure the player is a BlackjackPlayer
                BlackjackPlayer blackjackPlayer = (BlackjackPlayer) player;
                // Check if the player has a higher score than the current winner and hasn't busted
                if (blackjackPlayer.getScore() > maxScore && blackjackPlayer.getScore() <= 21) {
                    maxScore = blackjackPlayer.getScore(); // Update the highest score
                    winner = blackjackPlayer; // Update the winner
                }
            }
        }

        // If no winner found (i.e., all players busted), print a message
        if (winner == null) {
            System.out.println("No winner, all players busted!"); // All players busted
        } else {
            // Announce the winner with their score
            System.out.println("The winner is " + winner.getPlayerID() + " with a score of " + winner.getScore());
        }
    }
}