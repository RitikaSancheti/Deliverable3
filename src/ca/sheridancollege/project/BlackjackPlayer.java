/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author ritikasancheti
 */
public class BlackjackPlayer extends Player {
    
    private final ArrayList<BlackjackCard> hand; // The player's hand (list of cards)
    private int score; // Player's score (sum of card values)
    
    private GroupOfCards groupOfCards; // Reference to the game deck (Group of cards)
    
    // Constructor Initializes the player's name, hand, score, and deck reference
    public BlackjackPlayer(String name, GroupOfCards groupOfCards) {
        super(name); // Calls the superclass constructor to set the player's name
        this.hand = new ArrayList<>(); // Initialize an empty list for the player's hand
        this.score = 0; // Initialize the player's score to 0
        this.groupOfCards = groupOfCards; // Passing the deck reference
    }
    
    // Add a card to the player's hand and update the score
    public void addCard(BlackjackCard card) {
        hand.add(card); // Add the card to the player's hand
        score += card.getValue(); // Update the score based on the card's value
    }
    
    // Get the current score of the player
    public int getScore() {
        return score;
    }

    // Show the player's hand
    public void showHand() {
          System.out.println(getPlayerID() + "'s hand:"); // Print the player's name and hand
        hand.forEach(System.out::println); // Print each card in the player's hand
        System.out.println("Score: " + score); // Print the player's score
    }
    
    
    // Allow the player to decide whether to hit (take another card) or stand (end their turn)
    public boolean hitOrStand() {
        Scanner scanner = new Scanner(System.in); // One instance for all user inputs
        while (true) {
            System.out.println("Do you want to (H)it or (S)tand?");
            String choice = scanner.nextLine().toUpperCase(); // Get the user's choice, converting to uppercase
            if (choice.equals("H")) {
                return true; // Player wants to hit (take another card)
            } else if (choice.equals("S")) {
                return false; // Player wants to stand (end their turn)
            } else {
                System.out.println("Invalid input. Please enter 'H' to hit or 'S' to stand."); // Handle invalid input
            }
        }
    }
    
    
     // The main gameplay loop for the player
    @Override
    public void play() {
        showHand(); // Display the player's current hand and score
        while (getScore() < 21) { // Continue until the player's score is 21 or higher
            if (hitOrStand()) { // If the player chooses to hit
                System.out.println("You chose to hit!"); // Inform the player
                BlackjackCard newCard = (BlackjackCard) groupOfCards.drawRandomCard(); // Draw a new card from the deck
                addCard(newCard); // Add the new card to the player's hand and update score
                showHand(); // Show the updated hand and score
                
                // Check if the player has busted (score exceeds 21)
                if (getScore() > 21) {
                    System.out.println("You busted! Score: " + getScore()); // Inform the player that they busted
                    break; // End the game for the player
                }
            } else {
                System.out.println("You chose to stand!"); // Inform the player that they stood
                break; // End the player's turn
            }
        }
    }

    
}
