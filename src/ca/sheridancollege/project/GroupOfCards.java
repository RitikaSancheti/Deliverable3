/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 * @modifier ritikasancheti, Dec 4, 2024
 */
public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList <Card> cards;
    private int size;//the size of the grouping
    
    
    /**
     * Constructor to initialize the deck with a specified size.
     * It also calls the method to initialize a standard deck of 52 cards.
     */
    
    public GroupOfCards(int givenSize)
    {
        this.size = givenSize;
        this.cards = new ArrayList<>();
        initializeDeck();    // Initializes the deck with cards
    }

    
    
    /**
     * Method to initialize the deck with a standard 52-card set.
     * This method creates cards for all suits (Hearts, Diamonds, Clubs, Spades)
     * and ranks (2-10, Jack, Queen, King, Ace), assigning proper values to each card.
     */
    public void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        
        // Iterate through each suit and rank to create the cards
        for (String suit : suits) {
            for (String rank : ranks) {
                int value = getCardValue(rank);  // Get the value of the card
                
                // Add the card to the deck
                cards.add(new BlackjackCard(rank, suit, value));
            }
        }
    }
    
    private int getCardValue(String rank) {
        if (rank.equals("A")) {
            return 11;  // Ace is worth 11
        } else if (rank.equals("K") || rank.equals("Q") || rank.equals("J")) {
            return 10;  // Face cards are worth 10
        } else {
            return Integer.parseInt(rank);  // Numbered cards are worth their face value
        }
    }
    
    // Draw a random card from the deck
    public Card drawRandomCard() {
        Random random = new Random();
        int randomIndex = random.nextInt(cards.size());  // Random index from 0 to cards.size() - 1
        return cards.remove(randomIndex);  // Remove and return the card at the random index
    }
    
    public ArrayList<Card> getCards() {
        return cards;
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    
    public ArrayList<Card> showCards()
    {
        return cards;
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }
    
}//end class
