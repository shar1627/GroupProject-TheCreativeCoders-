/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 *@author Shivansh Sharma 10-09-2024
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;



public class GroupOfCards {
    private ArrayList<Card> cards;
    private int size;

    public GroupOfCards(int size) {
        this.size = size;
        this.cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void addCard(Card card) {
        if (cards.size() < size) {
            cards.add(card);
        }
    }
}
