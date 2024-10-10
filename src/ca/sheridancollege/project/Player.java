/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 * @author Rishabdeep Singh 10-09-2024
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 */

import java.util.ArrayList;


public class Player {
    private String name; 
    private ArrayList<Card> hand; 
    private int cardsPlayed; 

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.cardsPlayed = 0; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void incrementCardsPlayed() {
        cardsPlayed++;
    }

    public int getCardsPlayed() {
        return cardsPlayed;
    }

    public void play() {
        
    }
}
