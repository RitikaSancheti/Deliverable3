/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author ritikasancheti
 */
public class BlackjackPlayerTest {
    
    public static void main(String[] args) {
        // Create a deck of cards
        GroupOfCards deck = new GroupOfCards(52);
        
        // Create a Blackjack player and pass the deck
        BlackjackPlayer player = new BlackjackPlayer("Player1", deck);

        // Draw two cards for the player
        BlackjackCard card1 = (BlackjackCard) deck.drawRandomCard();
        player.addCard(card1);
        
        BlackjackCard card2 = (BlackjackCard) deck.drawRandomCard();
        player.addCard(card2);

        // Show the player's hand and score
        player.showHand();
        System.out.println("Player's total score: " + player.getScore());
    }
    
}
