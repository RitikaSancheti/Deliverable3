/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author ritikasancheti
 */
public class BlackjackCard extends Card {
    
    private final String rank;
    private final String suit;
    private final int value;

    // Constructor to initialize the card with rank, suit, and value
    public BlackjackCard(String rank, String suit, int value) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
    }

    //Getters for rank, suit and value
    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }
    
    //Overridden toString method
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
    
    
    
    
    
}
