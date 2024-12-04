/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author ritikasancheti
 */
public class GroupOfCardsTest {
    
    public static void main(String[] args) {
        // Create a deck of cards
        GroupOfCards deck = new GroupOfCards(52);

        // Print the initial size of the deck
        System.out.println("Initial deck size: " + deck.getSize());

        // Draw a random card from the deck
        Card drawnCard = deck.drawRandomCard();
        
        // Print the drawn card and the deck size after drawing
        System.out.println("Drawn Card: " + drawnCard);
        System.out.println("Deck size after draw: " + deck.getSize());
    }
}
