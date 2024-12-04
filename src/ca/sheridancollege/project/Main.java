/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author ritikasancheti
 */
public class Main {
    
    public static void main(String[] args) {
        
        // Create the deck of cards
        GroupOfCards groupOfCards = new GroupOfCards(52);

        
        // Create players and pass the deck to each player
        BlackjackPlayer player1 = new BlackjackPlayer("Player1", groupOfCards);
        BlackjackPlayer player2 = new BlackjackPlayer("Player2", groupOfCards);


        // Create the Blackjack game
        BlackjackGame blackjackGame = new BlackjackGame("Blackjack");

        // Add players to the game
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        // Set players in the game
        blackjackGame.setPlayers(players);

        // Start the game
        blackjackGame.play();

        // Declare the winner
        blackjackGame.declareWinner();
    }
    
}
