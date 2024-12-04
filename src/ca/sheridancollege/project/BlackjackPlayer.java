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
    
    // Constructor
    public BlackjackPlayer(String name, GroupOfCards groupOfCards) {
        super(name);
        this.hand = new ArrayList<>();
        this.score = 0;
        this.groupOfCards = groupOfCards; // Passing the deck reference
    }
    
    // Add a card to the player's hand
    public void addCard(BlackjackCard card) {
        hand.add(card);
        score += card.getValue();
    }
    
    // Get the current score
    public int getScore() {
        return score;
    }

    // Show the player's hand
    public void showHand() {
        System.out.println(getPlayerID() + "'s hand:");
        hand.forEach(System.out::println);
        System.out.println("Score: " + score);
    }
    
    
    // Allow the player to decide whether to hit or stand
    public boolean hitOrStand() {
        Scanner scanner = new Scanner(System.in); // One instance for all user inputs
        while (true) {
            System.out.println("Do you want to (H)it or (S)tand?");
            String choice = scanner.nextLine().toUpperCase();
            if (choice.equals("H")) {
                return true; // Player wants to hit
            } else if (choice.equals("S")) {
                return false; // Player wants to stand
            } else {
                System.out.println("Invalid input. Please enter 'H' to hit or 'S' to stand.");
            }
        }
    }
    
    
     @Override
    public void play() {
        showHand();
        while (getScore() < 21) {
            if (hitOrStand()) {
                System.out.println("You chose to hit!");
                BlackjackCard newCard = (BlackjackCard) groupOfCards.drawRandomCard();
                addCard(newCard);
                showHand();
                
                // Check if the player busted
                if (getScore() > 21) {
                    System.out.println("You busted! Score: " + getScore());
                    break;
                }
            } else {
                System.out.println("You chose to stand!");
                break;
            }
        }
    }

    
}
