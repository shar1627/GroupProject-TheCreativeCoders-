/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author Rishabdeep Singh 10-09-2024
 */

import java.util.List;

public class Card {
    private List<String> symbols; 

    public Card(List<String> symbols) {
        this.symbols = symbols;
    }

    @Override
    public String toString() {
        return "Card{" +
                "symbols=" + symbols +
                '}';
    }

    public List<String> getSymbols() {
        return symbols;
    }
}
